package one.edee.babylon.util;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PathUtils {

    /**
     * Gets all relative paths of files for given path by org.springframework.core.io.support.PathMatchingResourcePatternResolver.
     *
     * @param path Path can contains masked expressions for by org.springframework.core.io.support.PathMatchingResourcePatternResolver.
     * @return List of relative paths to files
     * @throws IOException some exception derived from {@link IOException}
     */
    public List<String> expandPath(String path, AntPathResourceLoader resourceLoader) throws IOException {
        Resource[] resources = resourceLoader.getResources("file:" + path);
        List<String> list = new ArrayList<>();
        String currentDir = System.getProperty("user.dir");
        for (Resource resource : resources) {
            String relativePath = resource.getFile().getPath();
            // If is it absolute path then parse relative path to current directory.
            if (relativePath.startsWith(currentDir)) {
                relativePath = relativePath.substring(currentDir.length() + 1);
            }
            list.add(relativePath);
        }
        return list;
    }

}
