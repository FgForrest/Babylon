package one.edee.babylon.properties;

import org.junit.Test;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class MultilinePropertyTest {

    @Test
    public void whenValueOfMultilinePropertyIsLoadedFromFileThenPropertyFileLineSeparatorIsReplacedWithSystemLineSeparator() throws Exception {
        InputStream propIS = getClassPathResourceStream("multiline.properties");
        FileActiveRecord props = new PropertyFileLoader().loadProperties(propIS);

        String expected = "<h3>Nahrajte soubor v jednom z níže uvedených formátů</h3>" + System.lineSeparator() +
                "  <p>Importovaný soubor může být pouze ve formátu CSV nebo XML dle níže uvedené specifikace.</p>";

        String multilineProp = props.get("orderImport.help.content").getValue();
        // Assuming value is of type String
        String multilinePropValue = multilineProp;

        assertEquals(expected, multilinePropValue);
    }

    private InputStream getClassPathResourceStream(String resourceRelativePath) {
        return this.getClass().getResourceAsStream(resourceRelativePath);
    }
}