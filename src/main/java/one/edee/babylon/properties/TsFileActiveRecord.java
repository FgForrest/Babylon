package one.edee.babylon.properties;

import one.edee.babylon.enums.PropertyType;
import one.edee.babylon.export.TsMessageLoader;
import one.edee.babylon.export.ts.ECMAScript6BaseListener;
import org.apache.commons.io.FilenameUtils;
import org.springframework.util.Assert;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * My own implementation for reading/writing of properties files. Implementation take care about precise format of file.
 * Keeps information about row number for each row which represents values: key and value, empty lines or comments
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class TsFileActiveRecord extends FileActiveRecord {

    /**
     * Loads properties from file by specified reader.
     * @param reader Some {@link Reader} implementation.
     * @throws IOException some exception derived from {@link IOException}
    */
    @Override
    public void load(Reader reader) throws IOException {
        Map<String, String> result = TsMessageLoader.dumpTsFile(reader);

        for (Map.Entry<String, String> entry : result.entrySet()) {
            String input = entry.getValue();
            AbstractProperty property = new TsAttribute(
                    input.contains("\n") || input.contains("\r")
                            ? PropertyType.MULTILINE
                            : PropertyType.VALUE, input);
            put(entry.getKey(), property);
        }
    }

    /**
     * Saves properties into file by specified writer.
     * @param writer Some {@link Writer} implementation.
     * @throws IOException some exception derived from {@link IOException}
    */
    @Override
    public void save(Writer writer, String primaryPropFilePath) throws IOException {


        ECMAScript6BaseListener loadedFile = TsMessageLoader.loadFile(primaryPropFilePath);
        Assert.notNull(loadedFile,"Cannot load primary file on path:" + primaryPropFilePath);
        List<String> imports = loadedFile.getImports();

        String baseName = FilenameUtils.getBaseName(primaryPropFilePath);
        baseName = baseName.contains(".") ? baseName.substring(0, baseName.indexOf(".")) : baseName;

        BufferedWriter bufferedWriter = (writer instanceof BufferedWriter) ? (BufferedWriter) writer : new BufferedWriter(writer);


        for (String tsImport : imports) {
            bufferedWriter.write(tsImport);
            bufferedWriter.newLine();
        }

        bufferedWriter.write("const "+baseName+" = {");
        bufferedWriter.newLine();

        synchronized (this) {
            for (Map.Entry<String, AbstractProperty> entry : entrySet()) {
                String key = entry.getKey();
                AbstractProperty value = entry.getValue();
                String keyDelimiter = key.matches("\\[.*]") ? "" : "'";

                bufferedWriter.write("    " + keyDelimiter + key + keyDelimiter +": "+ value.getQuotedValue() + ",");
                bufferedWriter.newLine();
            }
        }

        bufferedWriter.write("};");
        bufferedWriter.newLine();
        bufferedWriter.write("export default "+baseName+";");

        bufferedWriter.flush();
    }

}
