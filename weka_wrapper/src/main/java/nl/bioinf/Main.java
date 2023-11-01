package nl.bioinf;
import org.apache.commons.cli.ParseException;


public class Main {



    public static void main(String[] args){
        try {
            CommandLineParser testy = new CommandLineParser();
            testy.runAll(args);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
}