package de.cyberkatze.mdbgrabber;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

public class ISORex {

    public static final String VERSION = "1.0.0";
    private HashMap<String, Table> tables = new HashMap<>();
    private LinkedList<String> isoTables = new LinkedList<>();
    private HashMap<String, String[]> codeName = new HashMap<>();

    private final DateFormat DF = new SimpleDateFormat("dd.MM.yyyy");
    private final SimpleDateFormat FORMATTER = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.US);
    private Database db = null;

    /**
     * Initialise codeName and isoTables Lists.
     */
    private void initCodes() {
        codeName.put("MME_TEST_OBJECTS", new String[] { "TO", "TEST_OBJECT" });
        codeName.put("MME_POSITIONS", new String[] { "PO", "POSITION" });
        codeName.put("MME_TRANSDUCER_MAIN_LOCATIONS", new String[] { "ML", "TRANS_MAIN_LOC" });
        codeName.put("MME_FINE_LOCATIONS_1", new String[] { "F1", "FINE_LOC_1" });
        codeName.put("MME_FINE_LOCATIONS_2", new String[] { "F2", "FINE_LOC_2" });
        codeName.put("MME_FINE_LOCATIONS_3", new String[] { "F3", "FINE_LOC_3" });
        codeName.put("MME_PHYSICAL_DIMENSIONS", new String[] { "PD", "PHYSICAL_DIMENSION" });
        codeName.put("MME_DIRECTIONS", new String[] { "DI", "DIRECTION" });
        codeName.put("MME_FILTER_CLASSES", new String[] { "FC", "FILTER_CLASS" });

        isoTables.add("MME_TEST_OBJECTS");// TO
        isoTables.add("MME_POSITIONS");// PO
        isoTables.add("MME_TRANSDUCER_MAIN_LOCATIONS");// ML
        isoTables.add("MME_FINE_LOCATIONS_1");// F1
        isoTables.add("MME_FINE_LOCATIONS_2");// F2
        isoTables.add("MME_FINE_LOCATIONS_3");// F3
        isoTables.add("MME_PHYSICAL_DIMENSIONS");// PD
        isoTables.add("MME_DIRECTIONS");// DI
        isoTables.add("MME_FILTER_CLASSES");// FC
    }

    /**
     * Open Database, init codeName and isoTables and prepare Tables.
     * 
     * @param dbPath
     *            - path until *.MDB file
     */
    public ISORex(final String dbPath) {

        openDatabase(dbPath);

        initCodes();
        prepareTables();

    }

    /**
     * Open database.
     * 
     * @param path
     *            Path to *.MDB Database
     */
    private void openDatabase(final String path) {
        try {
            db = DatabaseBuilder.open(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print all tables from DB.
     */
    public void printTables() {
        try {
            System.out.println(db.getTableNames());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close database connection.
     */
    public void closeDB() {
        try {
            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if MDB-database consist isoTables and add it into "tables"-List.
     */
    private void prepareTables() {
        boolean contain;
        try {
            for (String currentTable : db.getTableNames()) {
                contain = isoTables.contains(currentTable);
                if (contain) {
                    String index = codeName.get(currentTable)[0];
                    tables.put(index, db.getTable(currentTable));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public JSONObject getJSON() throws Exception {

        if (tables.size() != isoTables.size()) {
            throw new Exception("Error! Count of tables in mdb file not equals to default list of tables!");
        }

        JSONObject rex = new JSONObject();

        rex.put("TO", parseTable("TO"));
        rex.put("PO", parseTable("PO"));
        rex.put("ML", parseTable("ML"));
        rex.put("F1", parseTable("F1"));
        rex.put("F2", parseTable("F2"));
        rex.put("F3", parseTable("F3"));
        rex.put("PD", parseTable("PD"));
        rex.put("DI", parseTable("DI"));
        rex.put("FC", parseTable("FC"));

        return rex;
    }

    @SuppressWarnings("unchecked")
    private JSONObject parseRow(final Row row, final List<? extends Column> cols, final String cRex,
            final String cColumn) {
        JSONObject currentItem = new JSONObject();
        for (Column column : cols) {
            String columnName = column.getName();
            DataType columnType = column.getType();
            Object columnValue = row.get(columnName);

            // ignore GUID column
            if (columnType != DataType.GUID) {

                // convert NULL to empty string
                if (columnValue == null) {
                    columnValue = "";
                }

                if ((columnType == DataType.MEMO) || (columnType == DataType.TEXT)) {
                    columnValue = columnValue.toString().replace("\"", "'");
                }

                // fix REMARKS column name
                if (columnName.equals("REMARKS") || columnName.equals("REAMRKS")) {
                    columnName = "REMARKS";
                }

                // change column name to REX and convert value "?" to "."
                if (columnName.equals(cColumn)) {
                    columnName = "rex";
                    columnValue = columnValue.toString().replace("?", ".");
                }

                if ((column.getType() == DataType.SHORT_DATE_TIME) && (columnValue != null)) {
                    if (columnValue.toString().trim().length() == 0) {
                        columnValue = "";
                    } else {
                        try {
                            columnValue = DF.format(FORMATTER.parse(columnValue.toString()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                currentItem.put(columnName.toLowerCase(), columnValue);
            }// if guid

        }// for column
        return currentItem;
    }// parseRow()

    @SuppressWarnings("unchecked")
    private JSONArray parseTable(final String tableIndex) throws Exception {
        Table table = tables.get(tableIndex);
        String tName = table.getName();

        JSONArray rexList = new JSONArray();
        List<? extends Column> cols = table.getColumns();
        if (codeName.containsKey(tName)) {
            String cRex = codeName.get(tName)[0];
            String cColumn = codeName.get(tName)[1];

            for (Row row : table) {
                rexList.add(parseRow(row, cols, cRex, cColumn));
            }// for rows
        } else {
            throw new Exception("codeName don't have table:[" + tName + "]");
        }

        return rexList;
    }// printTable()

    /**
     * Show statistic for ISO-Tables.
     */
    public void printStat() {
        Table t = null;

        System.out.printf("| %2s | %35s | %8s |\n", "CN", "Tables", "RowCount");
        System.out.printf("| %2s | %35s | %8s |\n", "--", "---", "---");

        for (Entry<String, Table> entry : tables.entrySet()) {
            String key = entry.getKey();
            t = entry.getValue();
            System.out.printf("| %2s | %35s | %8d |\n", key, t.getName(), t.getRowCount());
        }

    }
}
