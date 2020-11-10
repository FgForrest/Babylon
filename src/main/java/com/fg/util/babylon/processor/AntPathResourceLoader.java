package com.fg.util.babylon.processor;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * Loads resources given a path, supporting Ant-style patterns such as:
 * <pre class="code">
 * /WEB-INF/*-context.xml
 * com/mycompany/**&#47;applicationContext.xml
 * file:C:/some/path/*-context.xml
 * classpath:com/mycompany/**&#47;applicationContext.xml
 * </pre>
 *
 * Specifies the resource loading contract of {@link ExportProcessor}.
 *
 * @see PathMatchingResourcePatternResolver
 */
public interface AntPathResourceLoader {

    /**
     * Resolve the given path (with Ant-style patterns) into Resource objects.
     *
     * @return the corresponding Resource objects
     */
    public Resource[] getResources(String antStylePath) throws IOException;

}
