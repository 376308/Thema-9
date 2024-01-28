package nl.bioinf;
import weka.classifiers.Classifier;
import weka.core.Instances;



public class Main {
    /**
     * The main class of the app, combines the different functions and controls the flow. Prints the instances
     * with the predicted class at the end
     * @param args
     * @throws Exception
     */


    public static void main(String[] args) throws Exception {
        CommandLineParser cmdParser = new CommandLineParser();
        try {
            cmdParser.runAll(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        WekaModel wekaModel = new WekaModel();
        Classifier model = wekaModel.loadClassifier(cmdParser.modelFile);
        Instances data = wekaModel.loadData(cmdParser.instances);
        System.out.println(wekaModel.classifyData(model, data));



    }
}