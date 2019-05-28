package com.fg.util.translator;

import com.fg.util.translator.entity.Arguments;
import com.fg.util.translator.service.TranslationService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Utility project to manage translations on projects.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@SpringBootApplication
@CommonsLog
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private TranslationService translationService;

    public static void main(String[] args) {
        log.info("STARTING THE TRANSLATOR");
        SpringApplication.run(SpringBootConsoleApplication.class, args);
        log.info("TRANSLATOR FINISHED");
    }

    @Override
    public void run(String... args) {
        log.info("EXECUTING THE TRANSLATOR WITH ARGUMENTS: ");
        for (int i = 0; i < args.length; ++i) {
            log.info(String.format("args[%d]: %s",i ,args[i]));
        }
        Arguments arguments = parseArguments();
        try {
            translationService.startTranslation(arguments);
        } catch (Exception e) {
            log.error("TRANSLATOR ERROR: ", e);
        }
    }

    /**
     * Validates and parsing command line arguments. If validation failed, program will be terminated.
     * @param args
     * @return
     */
    private Arguments parseArguments(String... args) {
        if (args.length != 2) {
            log.error("Invalid input arguments, required: ");
            printRequiredArguments();
            System.exit(0);
        }
        Arguments arguments = new Arguments();
        arguments.setConfigFileName(args[0]);
        arguments.setGoogleSheetId(args[1]);
        return arguments;
    }

    private void printRequiredArguments() {
        log.info("1 - path to translator-config.json file");
        log.info("2 - ID of the google sheet (e.g. 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc)");
    }
}
