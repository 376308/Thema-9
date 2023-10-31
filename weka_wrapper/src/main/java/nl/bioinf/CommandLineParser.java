package nl.bioinf;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

public class CommandLineParser {

    private static CommandLine getCommandline(String[] args) throws ParseException {
        OptionProvider options = new OptionProvider();
        org.apache.commons.cli.CommandLineParser parser = new DefaultParser();
        options.AddOptions();
        CommandLine cmd = parser.parse(options.alloptions, args);
        System.out.println();
        return cmd;
    }

    private static void checkCommandline(CommandLine cmd){
        System.out.println(cmd.getArgList());
        System.out.println(cmd.getOptionValue("m model"));

    }

    public void runall(String[] args) throws ParseException {
        CommandLine cmd = getCommandline(args);
        checkCommandline(cmd);
    }
}
