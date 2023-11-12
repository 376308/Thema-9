package nl.bioinf;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommandLineParser {
    public static String modelFile = "src/main/java/nl/bioinf/data/RandomForestCrabs.model";
    public static File instances = null;

    private static CommandLine getCommandline(String[] args) throws ParseException {
        OptionProvider options = new OptionProvider();
        org.apache.commons.cli.CommandLineParser parser = new DefaultParser();
        options.AddOptions();
        CommandLine cmd = parser.parse(options.alloptions, args);
        System.out.println(cmd.hasOption("m"));
        return cmd;
    }

    private void parseCommandline(CommandLine cmd) throws Exception {
        if (!cmd.hasOption("i") && !cmd.hasOption("f") ){
            throw new Exception("Please provide either an instance or an file, none found");
        }
        if (cmd.hasOption("i") && cmd.hasOption("f")){
            throw new Exception("Can't provide both a file and an instance, please chose one");
        }
        if (cmd.hasOption("m")) {
            String file = cmd.getOptionValue("m");
            Path path = Paths.get(file);
            if (Files.exists(path) && file.endsWith(".model")){
                modelFile = file;
            }
            else {
                System.out.println(Character.toUpperCase('x'));
                throw new Exception("Not a existing model file");
            }
        }
        if (cmd.hasOption("i")){
            ;
        }
        if (cmd.hasOption("f")){
            Path csvpath = Paths.get(cmd.getOptionValue("f"));
            if (Files.exists(csvpath) && csvpath.endsWith("csv")){
                this.instances = new File(cmd.getOptionValue("i"));
            }
            else {
                throw new Exception("f needs to be an existing csv file");
            } }
    }

    public void runAll(String[] args) throws Exception {
        CommandLine cmd = getCommandline(args);
        parseCommandline(cmd);
    }
}
