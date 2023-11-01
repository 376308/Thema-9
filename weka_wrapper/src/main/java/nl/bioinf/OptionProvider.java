package nl.bioinf;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class OptionProvider {
    Options alloptions;

    public void AddOptions(){
        Options options = new Options();

        Option model = Option.builder("m")
                .longOpt("model")
                .required(true)
                .hasArg()
                .desc("Model to be used")
                .build();

        Option data = Option.builder("d")
                .longOpt("data")
                .required(true)
                .hasArg()
                .desc("dataset to build the model")
                .build();

        Option instance = Option.builder("i")
                .longOpt("instance")
                .required(true)
                .hasArg()
                .desc("Instance to predict")
                .build();
        options.addOption(model);
        options.addOption(data);
        options.addOption(instance);
        this.alloptions = options;
    }



}
