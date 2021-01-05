package one.edee.babylon.util.spring;

import one.edee.babylon.util.AntPathResourceLoader;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * Implementation of resource loader using Spring Core.
 */
public class SpringResourceLoader implements AntPathResourceLoader {

    private final PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();

    @NotNull
    @Override
    public Resource[] getResources(String antStylePath) throws IOException {
        return pathResolver.getResources(antStylePath);
    }

}
