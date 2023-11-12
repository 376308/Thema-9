package nl.bioinf;
import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils;


public class Main {



    public static void main(String[] args) throws Exception {
        CommandLineParser testy = new CommandLineParser();
        try {
            testy.runAll(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        WekaModel testo = new WekaModel();
        Classifier model = testo.loadClassifier(testy.modelFile);




    }
}