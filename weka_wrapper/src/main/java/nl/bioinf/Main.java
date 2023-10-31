package nl.bioinf;
import org.apache.commons.cli.ParseException;


public class Main {



    public static void main(String[] args){
        try {
            System.out.println("Hello world!");
            CommandLineParser testy = new CommandLineParser();
            testy.runall(args);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
}