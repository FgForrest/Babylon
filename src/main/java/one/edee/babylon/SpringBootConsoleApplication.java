package one.edee.babylon;

import one.edee.babylon.config.TranslationConfigurationReader;
import one.edee.babylon.config.TranslationConfiguration;
import one.edee.babylon.enums.Action;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Project that provides support for Java property file translation.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@SpringBootApplication
@CommonsLog
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private MainService mainService;
    private final TranslationConfigurationReader configurationReader;

    public SpringBootConsoleApplication() {
        configurationReader = new TranslationConfigurationReader();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("STARTING THE BABYLON FROM DIRECTORY: " + System.getProperty("user.dir"));
        log.info("WITH ARGUMENTS: ");
        for (int i = 0; i < args.length; ++i) {
            log.info(String.format("args[%d]: %s",i ,args[i]));
        }
        Arguments arguments = parseArguments(args);
        try {
            log.info("Loading config file: '" + arguments.getConfigFileName() + "'");
            TranslationConfiguration configuration = configurationReader.readAndCheckConfiguration(arguments.getConfigFileName());
            mainService.startTranslation(arguments.getAction(), configuration, arguments.getGoogleSheetId());
        } catch (Exception e) {
            log.error("BABYLON ERROR: ", e);
            System.exit(-1);
        }
    }

    /**
     * Validates and parsing command line arguments. If validation failed, program will be terminated.
     * @param args
     * @return
     */
    public static Arguments parseArguments(String... args) {
        if (args.length != 3) {
            log.error("Invalid input arguments, required: ");
            printRequiredArguments();
            System.exit(-1);
        }
        Arguments arguments = new Arguments();
        try {
            arguments.setAction(Action.valueOf(args[0].toUpperCase()));
        } catch (IllegalArgumentException e) {
            String validActions = Arrays.stream(Action.values())
                    .map(action -> "\"" + action.name() + "\"")
                    .collect(Collectors.joining(" or "));
            String msg = String.format("Unexpected value of first argument: \"%s\". Valid values is %s", args[0], validActions);
            throw new IllegalArgumentException(msg);
        }
        arguments.setConfigFileName(args[1]);
        arguments.setGoogleSheetId(args[2]);
        return arguments;
    }

    private static void printRequiredArguments() {
        log.info("1 - expected action (import, export)");
        log.info("2 - path to translator-config.json file");
        log.info("3 - ID of the google sheet (e.g. 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc)");
    }

    /**
     * Crate for program arguments.
     * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
     */
    @Data
    public static class Arguments {

        /**
         * See {@link Action}
         */
        private Action action;

        /**
         * FileName and relative path to the Json configuration file.
         */
        private String configFileName;

        /**
         * Id of the target google spreadsheet.
         */
        private String googleSheetId;
    }

}
