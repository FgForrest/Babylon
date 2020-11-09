package com.fg.util.babylon;

import com.fg.util.babylon.entity.Arguments;
import com.fg.util.babylon.enums.Action;
import com.fg.util.babylon.service.GoogleSheetService;
import com.fg.util.babylon.service.TranslationService;
import lombok.extern.apachecommons.CommonsLog;
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

    private TranslationService translationService;

    public SpringBootConsoleApplication() {
        this.translationService = new TranslationService(new GoogleSheetService());
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
            translationService.startTranslation(arguments);
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
    private Arguments parseArguments(String... args) {
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

    private void printRequiredArguments() {
        log.info("1 - expected action (import, export)");
        log.info("2 - path to translator-config.json file");
        log.info("3 - ID of the google sheet (e.g. 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc)");
    }
}
