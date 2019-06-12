package com.fg.util.babylon.maven.plugin;

import com.fg.util.babylon.SpringBootConsoleApplication;
import com.fg.util.babylon.enums.Action;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Base class for {@link Action#EXPORT} and {@link Action#IMPORT} actions running as maven plugin.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public abstract class BabylonExpImpBaseMojo extends AbstractMojo {

    /**
     * File name and relative path to the Json configuration file.
     */
    @Parameter(property = "config.file", required = true)
    private String configFileName;

    /**
     * Id of the target google spreadsheet.
     */
    @Parameter(property = "google.sheet.id", required = true)
    private String googleSheetId;

    @Override
    public void execute() {
        SpringBootConsoleApplication.main(getArguments());
    }

    private String[] getArguments() {
        String arg[] = new String[3];
        arg[0] = getAction().name();
        arg[1] = this.configFileName;
        arg[2] = this.googleSheetId;
        return arg;
    }

    abstract Action getAction();
}
