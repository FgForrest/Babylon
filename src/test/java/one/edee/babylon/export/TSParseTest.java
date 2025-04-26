package one.edee.babylon.export;

import lombok.extern.log4j.Log4j2;
import one.edee.babylon.export.ts.TypeScriptBabylonParserListener;
import one.edee.babylon.export.ts.gen.TypeScriptLexer;
import one.edee.babylon.export.ts.gen.TypeScriptParser;
import one.edee.babylon.msgfile.TranslationFileUtils;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class TSParseTest {


    @Test
    public void testParseByLex() throws IOException {
        CharStream input = CharStreams.fromFileName("src/test/resources/META-INF/09_mail_form/messages.ts");
        TypeScriptLexer lexer = new TypeScriptLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypeScriptParser parser = new TypeScriptParser(tokens);
        ParseTree tree = parser.program();


        TypeScriptBabylonParserListener listener = new TypeScriptBabylonParserListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);


        System.out.println(listener.getImports());
        System.out.println("/////////////////////////////////////");
        System.out.println(listener.getPropertyDefinitions());

    }

    @Test
    public void testRename(){
        String filePath = "some.cs.i18n.ts";
        log.info(filePath);
        String translation = TranslationFileUtils.getFileNameForTranslation(filePath, "en");
        log.info(translation);
        Assert.assertEquals("some.en.i18n.ts", translation);
    }


    @Test
    public void testParse() {
        // Define the path to your TypeScript file
        String filePath = "src/test/resources/META-INF/addresses/addresses.ts";

        // Create a Map to store the internationalization key-value pairs
        Map<String, String> i18nMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
//            Pattern pattern = Pattern.compile("'([^']+)'\\s*:\\s*'([^']+)'");
            Pattern pattern = Pattern.compile("'([^']+)':\\\\s*`(?:[^`]*`[^`]*`|[^`]+)`");

            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String key = matcher.group(1);
                    String value = matcher.group(2);
                    i18nMap.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(i18nMap);

//        // Now you can access the localized strings or CSS classes using the keys
//        String alwaysAvailableClass = i18nMap.get("availability.color.ALWAYS_AVAILABLE");
//        String contactHoursText = i18nMap.get("contact_hours");
//
//        // Example usage
//        System.out.println("CSS class for always available: " + alwaysAvailableClass);
//        System.out.println("Contact hours text: " + contactHoursText);
    }

}
