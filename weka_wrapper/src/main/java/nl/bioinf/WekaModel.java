package nl.bioinf;

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils;

public class WekaModel {

    Classifier loadClassifier(String modelFile) throws Exception {
        SerializationHelper reader = new SerializationHelper();
        Classifier model = (Classifier) reader.read(modelFile);
        return model;
    }

    private Instances loadData(String dataFile) throws Exception {
        ConverterUtils.DataSource reader = new ConverterUtils.DataSource(dataFile);
        Instances data = reader.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);
        return data;
    }

    private Instances classifyData(Classifier model, Instances data) throws Exception {
        Instances labeled = new Instances(data);
        for (int index = 0; index < data.numInstances(); index++) {
            double label = model.classifyInstance(data.instance(index));
            labeled.instance(index).setClassValue(label);
        }
        return labeled;
    }
}
