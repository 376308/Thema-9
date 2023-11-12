package nl.bioinf;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class OptionProvider {
    Options alloptions;

    public void AddOptions(){
        Options options = new Options();

        Option model = Option.builder("m")
                .longOpt("model")
                .required(false)
                .hasArg()
                .desc("Model to be used instead of the default one")
                .build();

        Option instance = Option.builder("i")
                .longOpt("instance")
                .required(false)
                .hasArg()
                .desc("a single instance to predict")
                .build();

        Option file = Option.builder("f")
                .longOpt("file")
                .required(false)
                .hasArg()
                .desc("a csv file with multiple instances to predict")
                .build();
        options.addOption(model);
        options.addOption(file);
        options.addOption(instance);
        this.alloptions = options;
    }



}
