package com.fg.util.babylon.processor;

import com.fg.util.babylon.enums.Action;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;

/**
 * Processor for {@link Action#IMPORT} action.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Component
@CommonsLog
public class ImportProcessor extends BaseProcessor {

    @Override
    protected void processTranslation() throws IOException {
        // TODO: import...
        throw new NotImplementedException();
        // TODO: Save created data file to disk.
//        JsonUtils.objToJsonFile(new File(configuration.getDataFileName()), getOrCreateDataFile(), true);
    }
}
