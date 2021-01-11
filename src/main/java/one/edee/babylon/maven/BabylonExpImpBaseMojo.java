package one.edee.babylon.maven;

import one.edee.babylon.SpringBootConsoleApplication;
import one.edee.babylon.enums.Action;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Base class for {@link Action#EXPORT} and {@link Action#IMPORT} actions running as maven plugin.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public abstract class BabylonExpImpBaseMojo extends AbstractMojo {

    public static final String CONFIG_FILE_PARAM = "config.file";
    public static final String GOOGLE_SHEET_ID_PARAM = "google.sheet.id";

    /**
     * File name and relative path to the Json configuration file.
     */
    @Parameter(property = CONFIG_FILE_PARAM, required = true)
    private String configFileName;

    /**
     * Id of the target google spreadsheet.
     */
    @Parameter(property = GOOGLE_SHEET_ID_PARAM, required = true)
    private String googleSheetId;

    @Override
    public void execute() {
        SpringBootConsoleApplication.main(getArguments());
    }

    private String[] getArguments() {
        String[] arg = new String[3];
        arg[0] = getAction().name();
        arg[1] = this.configFileName;
        arg[2] = this.googleSheetId;
        return arg;
    }

    protected abstract Action getAction();

}
