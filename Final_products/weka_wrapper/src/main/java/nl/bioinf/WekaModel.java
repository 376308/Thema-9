package nl.bioinf;

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils;

public class WekaModel {


    Classifier loadClassifier(String modelFile) throws Exception {
        /**
         * Takes the modelfile and reads the model and converts it to a classifier class
         */
        Classifier model = (Classifier) SerializationHelper.read(modelFile);
        return model;
    }

    Instances loadData(String dataFile) throws Exception {
        /**
         * Takes the datafile with the instances and makes an actual instances object
         */
        ConverterUtils.DataSource reader = new ConverterUtils.DataSource(dataFile);
        Instances data = reader.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);
        return data;
    }

    Instances classifyData(Classifier model, Instances data) throws Exception {
        /**
         * Classifies based on the model and the instances. Adds a column with the prediction
         */
        Instances labeled = new Instances(data);
        for (int index = 0; index < data.numInstances(); index++) {
            double label = model.classifyInstance(data.instance(index));
            labeled.instance(index).setClassValue(label);
        }
        return labeled;
    }
}
