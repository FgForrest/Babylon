package com.fg.util.babylon.util.spring;

import com.fg.util.babylon.util.AntPathResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * Implementation of resource loader using Spring Core.
 */
public class SpringResourceLoader implements AntPathResourceLoader {

    private final PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();

    @Override
    public Resource[] getResources(String antStylePath) throws IOException {
        return pathResolver.getResources(antStylePath);
    }

}
