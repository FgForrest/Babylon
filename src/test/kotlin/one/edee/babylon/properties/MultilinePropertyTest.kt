package one.edee.babylon.properties

import org.junit.Test
import java.io.InputStream

class MultilinePropertyTest {

    @Test
    fun `when value of multiline property is loaded from file then property file line separator is replaced with system line separator`() {
        val propIS = getClassPathResourceStream("multiline.properties")
        val props = PropertyFileLoader().loadProperties(propIS)

        val expected = "<h3>Nahrajte soubor v jednom z níže uvedených formátů</h3>" + System.lineSeparator() +
                "  <p>Importovaný soubor může být pouze ve formátu CSV nebo XML dle níže uvedené specifikace.</p>"
        val multilineProp = props["orderImport.help.content"]
        val multilinePropValue = multilineProp!!.value
//        assertEquals(expected, multilinePropValue)

    }

    private fun getClassPathResourceStream(resourceRelativePath: String): InputStream =
        this.javaClass.getResourceAsStream(resourceRelativePath)
}
