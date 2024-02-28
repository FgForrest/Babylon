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
    public static final String COMBINE_SHEET_PARAM = "combine.sheets";
    public static final String DEEPL_API_KEY_PARAM = "deepl.api.key";

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

    /**
     * Combine sheets param.
     */
    @Parameter(property = COMBINE_SHEET_PARAM)
    private Boolean combineSheets;

    /**
     * Deepl api key.
     */
    @Parameter(property = DEEPL_API_KEY_PARAM)
    private String deeplApiKey;

    @Override
    public void execute() {
        SpringBootConsoleApplication.main(getArguments());
    }

    private String[] getArguments() {
        String[] arg = new String[5];
        arg[0] = getAction().name();
        arg[1] = this.configFileName;
        arg[2] = this.googleSheetId;
        arg[3] = String.valueOf(this.combineSheets);
        arg[4] = this.deeplApiKey;
        return arg;
    }

    protected abstract Action getAction();

}
