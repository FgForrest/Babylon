package com.fg.util.babylon.properties;

import com.fg.util.babylon.enums.PropertyType;
import com.google.common.io.LineReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * My own implementation for reading/writing of properties files. Implementation take care about precise format of file.
 * Keeps information about row number for each row which represents values: key and value, empty lines or comments
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class PropertyFileActiveRecord extends LinkedHashMap<String, Property> {

    /**
     * Loads properties from file by specified reader.
     * @param reader Some {@link Reader} implementation.
     * @throws IOException some exception derived from {@link IOException}
    */
    public void load(Reader reader) throws IOException {
        loadByLineReader(new LineReader(reader));
    }

    /**
     * Saves properties into file by specified writer.
     * @param writer Some {@link Writer} implementation.
     * @throws IOException some exception derived from {@link IOException}
    */
    public void save(Writer writer) throws IOException {
        saveByBufferedWriter((writer instanceof BufferedWriter) ? (BufferedWriter)writer : new BufferedWriter(writer));
    }

    private void loadByLineReader(LineReader lr) throws IOException {
        synchronized (this) {
            int row = 1;
            while (true) {
                String line = lr.readLine();
                if (line == null) {
                    break;
                }
                Map.Entry<String, Property> entry = parseProperty(line, row, lr);
                put(entry.getKey(), entry.getValue());
                // In case of PropValueMultiLine row number must be incremented by lines count of PropValueMultiLine.
                if (entry.getValue().isPropValueMultiLine()) {
                    row += entry.getValue().getRowCount();
                } else {
                    row++;
                }
            }
        }
    }

    private void saveByBufferedWriter(BufferedWriter bw) throws IOException {
        synchronized (this) {
            for (Iterator<Map.Entry<String, Property>> iterator = entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<String, Property> e = iterator.next();
                String key = e.getKey();
                Property value = e.getValue();
                if (value.isPropValue() || value.isPropValueMultiLine()) {
                    bw.write(key + "=" + e.getValue().getValue());
                    // Break line on all rows except last one.
                    if (iterator.hasNext()) {
                        bw.newLine();
                    }
                }
                if (value.isPropEmptyLine()) {
                    bw.newLine();
                    continue;
                }
                if (value.isPropComment()) {
                    bw.write(e.getValue().getValue());
                    if (iterator.hasNext()) {
                        bw.newLine();
                    }
                }
            }
        }
        bw.flush();
    }

    /**
     * Parsing one property into correct map entry with correct subclass of {@link Property} class for one line in properties file.
     * @param line current line from file, from given row number
     * @param row actual row, in case of PropValueMultiLine can be increment by its row count
     * @param lr line reader is used for reading multi-line properties values escaped by '\'
     * @return map entry with key and value.
     */
    private Map.Entry<String, Property> parseProperty(String line, int row, LineReader lr) throws IOException {
        line = line.trim();
        if (line.contains("=")) {
            // key=value
            String[] keyAndVal = line.split("=",2);
            return createPropValueEntry(keyAndVal, lr);
        } else if (line.isEmpty()) {
            Property propEmptyLine = new Property(PropertyType.EMPTY, "");
            return new SimpleEntry<>("" + row, propEmptyLine);
        } else if (line.startsWith("#") || line.startsWith("!")) {
            Property propComment = new Property(PropertyType.COMMENT, line);
            return new SimpleEntry<>("" + row, propComment);
        } else {
            Property propUnknown = new Property(PropertyType.UNKNOWN, line);
            return new SimpleEntry<>("" + row, propUnknown);
        }
    }

    /**
     * Creates property entry with key and value. Can produce map of {@link Property} instances with type {@link PropertyType#VALUE}
     * or {@link PropertyType#MULTILINE}.
     * @param keyAndVal {@link String} array where 0th element is key and 1th element is value.
     * @param lr line reader is used for reading multi-line properties values escaped by '\'
     * @return map entry with key and value.
     */
    private Map.Entry<String, Property> createPropValueEntry(String[] keyAndVal, LineReader lr) throws IOException {
        Property propValue;
        String key = keyAndVal[0].trim();
        String value = keyAndVal.length > 1 ? keyAndVal[1].trim() : "";
        if (!value.endsWith(Property.MULTILINE_SEPARATOR)) {
            propValue = new Property(PropertyType.VALUE, value);
        } else {
            Property multiLine = new Property(PropertyType.MULTILINE, value);
            multiLine.addLine(value);
            // Adds rest of lines of this multiline value.
            while(true) {
                String line = lr.readLine();
                if (!line.trim().isEmpty()) {
                    multiLine.addLine(line);
                }
                // If end of multi line value is reached.
                if (!line.endsWith(Property.MULTILINE_SEPARATOR) || line.trim().isEmpty()) {
                    break;
                }
            }
            propValue = multiLine;
        }
        return new SimpleEntry<>(key, propValue);
    }

}
