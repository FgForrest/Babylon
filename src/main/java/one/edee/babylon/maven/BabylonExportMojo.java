package one.edee.babylon.maven;

import one.edee.babylon.enums.Action;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * @goal export
 * Babylon {@link Action#EXPORT} as maven plugin.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Mojo(name = "export", defaultPhase = LifecyclePhase.NONE, inheritByDefault = false, aggregator = true)
public class BabylonExportMojo extends BabylonExpImpBaseMojo {

    @Override
    protected Action getAction() {
        return Action.EXPORT;
    }
}
