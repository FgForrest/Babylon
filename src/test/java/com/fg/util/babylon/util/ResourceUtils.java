package com.fg.util.babylon.util;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;

/**
 * Utilities to treat (test) resources as files.
 *
 * @author VKR
 */
public class ResourceUtils {

    /**
     * Loads resource and copies its content to a file with same name in given directory.
     *
     * @param resourceName name of resource to load, will be used for newly created file
     * @param createIn directory where the file will be created
     * @param useClassLoaderOf classloader of this class will be used to load the resource, the resource must be relative to this class
     * @return newly created file
     * @throws IOException if content of resource cannot be copied to the file
     */
    public static File loadRelativeResourceAsFile(String resourceName, Path createIn, Class useClassLoaderOf) throws IOException {
        Resource msgFileResource = new ClassRelativeResourceLoader(useClassLoaderOf).getResource(resourceName);
        return resourceToFile(msgFileResource, createIn);
    }

    /**
     * Copies resource content to a file with same name in given directory.
     *
     * @param resource resource to be copied
     * @param createIn directory where the file will be created
     * @return newly created file
     * @throws IOException if content of resource cannot be copied to the file
     */
    public static File resourceToFile(Resource resource, Path createIn) throws IOException {
        Objects.requireNonNull(resource.getFilename());

        String[] resourceNameAndSuffix = resource.getFilename().split("\\.");
        String fileName = resourceNameAndSuffix[0];
        String suffix;
        if (resourceNameAndSuffix.length > 1) {
            suffix = "." + resourceNameAndSuffix[1];
        } else {
            suffix = null;
        }

        File tempFile = File.createTempFile(fileName, suffix, createIn.toFile());
        tempFile.deleteOnExit();
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(resource.getInputStream(), out);
        }
        return tempFile;
    }


}
