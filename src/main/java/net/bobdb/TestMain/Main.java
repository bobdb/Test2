package net.bobdb.TestMain;

import org.apache.commons.cli.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // create Options object
        Options options = new Options();

        // add t option
        options.addOption("t", "time", false, "display current time");

        // add help option
        options.addOption( "h", "help", false, "print this message" );

        // file option
        Option logfile = Option.builder("f")
                .argName( "file" )
                .hasArg()
                .desc(  "use given file for input" )
                .build();
        options.addOption(logfile);

        // parse and generate CommandLine object
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse( options, args);

            if (cmd.hasOption("help")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp( "Main", options );
                return;
            }

            if(cmd.hasOption("t")) {
                // print the date and time
                System.out.println("current time");
            }
            else {
                // print the date
                System.out.println("the date");
            }

            // get c option value
            String countryCode = cmd.getOptionValue("c");

            if(countryCode == null) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                System.out.println(timestamp);
            }
            else {
                Date d1 = new Date();

                // creating a new locale for England Format
                Locale locEngland = new Locale("en", "ch");

                // initializing the date formatter and converting
                // the date
                DateFormat de = DateFormat.getDateInstance(
                        DateFormat.FULL, locEngland);

                System.out.println("England Format: "
                        + de.format(d1));
            }



        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
