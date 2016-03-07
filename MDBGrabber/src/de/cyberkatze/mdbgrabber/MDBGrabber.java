package de.cyberkatze.mdbgrabber;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

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
        // create Options object
        Options options = new Options();

        options.addOption("?", false, "Show help");
        options.addOption("h", "help", false, "Show help");

        options.addOption("i", "input", true, "Path until *.MDB database");
        options.addOption("o", "output", true, "Path until output JSON file, if not getting export in 'out.json'-file");

        options.addOption("v", "version", false, "Show version");
        options.addOption("s", "stat", false, "Show stat");

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
                ISORex iso = new ISORex(inputFilePath);

                if (stat) {
                    iso.printStat();
                }

                Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), "UTF-8"));
                try {
                    out.write(iso.getJSON().toJSONString());
                } finally {
                    out.close();
                    System.out.println("File saved:" + outputFilePath);
                }

                iso.closeDB();

            }

        } catch (ParseException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

}
