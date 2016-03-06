package de.cyberkatze.mdbgrabber;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class MDBGrabber {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception {
        // -------------
        // create Options object
        Options options = new Options();

        options.addOption("?", false, "Show help");
        options.addOption("h", "help", false, "Show help");

        options.addOption("i", "input", true, "Path until *.MDB database");
        options.addOption("o", "output", true, "Path until output JSON file, if not getting export in 'out.json'-file");

        options.addOption("v", "version", false, "Show version");
        options.addOption("s", "stat", false, "Show stat");

        // -------------
        // parse command line args
        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            // Get input and output options
            String inputFilePath = null;
            String outputFilePath = null;

            boolean stat = false;

            if (cmd.hasOption("v")) {
                System.out.println(ISORex.VERSION);
            }

            if (cmd.hasOption("i")) {
                inputFilePath = cmd.getOptionValue("i");
                System.out.println("input: " + inputFilePath);
            }

            if (cmd.hasOption("s")) {
                stat = true;
            }

            if (cmd.hasOption("o")) {
                outputFilePath = cmd.getOptionValue("o");
                System.out.println("output: " + outputFilePath);
            }

            if (cmd.hasOption("?") || cmd.hasOption("h")) {
                System.out.println("show help");
                // automatically generate the help statement
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("MDBGrabber", options);
            }

            if (outputFilePath == null) {
                outputFilePath = "out.json";
            }

            if (inputFilePath == null) {
                System.out.println("Please write input file");
                System.exit(0);
            }

            if ((inputFilePath != null) && (outputFilePath != null)) {
                ISORex iso = new ISORex(inputFilePath);// ISORex("/home/cyberkatze/workspaces/eclipse/mme_code.mdb");

                if (stat) {
                    iso.printStat();
                }

                try {
                    FileWriter file = new FileWriter(outputFilePath);
                    file.write(iso.getJSON().toJSONString());
                    file.flush();
                    file.close();
                    System.out.println("File saved:" + outputFilePath);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                iso.closeDB();

            }

        } catch (ParseException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

}
