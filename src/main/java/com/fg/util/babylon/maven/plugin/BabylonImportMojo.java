package com.fg.util.babylon.maven.plugin;

import com.fg.util.babylon.enums.Action;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Babylon {@link Action#IMPORT} as maven plugin.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Mojo(name = "import", defaultPhase = LifecyclePhase.NONE, inheritByDefault = false, aggregator = true)
public class BabylonImportMojo extends BabylonExpImpBaseMojo {

    @Override
    Action getAction() {
        return Action.IMPORT;
    }
}
