package one.edee.babylon.msgfile;

import org.apache.commons.io.FilenameUtils;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility methods that deal with i18n files in some way.
 * Methods here should be moved else eventually and this class deleted.
 */
public class TranslationFileUtils {
    private static final Pattern pattern = Pattern.compile("\\.([a-z]{2})\\.");

    /**
     * Get file name like primaryPropFilePath + ("_" + mutation if is not null or empty) + possible original extension of primaryPropFilePath.
     * @param primaryPropFilePath path to the primary mutation file
     * @param mutation mutation of the file what you want
     * @return correct file name for mutation
     */
    public static String getFileNameForTranslation(String primaryPropFilePath, String mutation) {
        if (StringUtils.isEmpty(mutation)) {
            return primaryPropFilePath;
        }
        String fileExtension = FilenameUtils.getExtension(primaryPropFilePath);

        if (!StringUtils.isEmpty(fileExtension)){
            fileExtension = "." + fileExtension;
            if (fileExtension.equalsIgnoreCase(".ts")){

                String mutationFileName = FilenameUtils.removeExtension(primaryPropFilePath);
                // Define a callback function to perform the replacement
                Matcher matcher = pattern.matcher(mutationFileName);
                StringBuffer updatedString = new StringBuffer();
                while (matcher.find()) {
                    matcher.appendReplacement(updatedString, "." + mutation + ".");
                }
                matcher.appendTail(updatedString);
                updatedString.append(fileExtension);

                return updatedString.toString();
            }
        }
        String fileMutation = "_" + mutation;

        String mutationFileName = FilenameUtils.removeExtension(primaryPropFilePath);
        mutationFileName += fileMutation + fileExtension;
        return mutationFileName;
    }

}
