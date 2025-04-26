package one.edee.babylon.export;

import lombok.extern.log4j.Log4j2;
import one.edee.babylon.export.ts.TypeScriptBabylonParserListener;
import one.edee.babylon.export.ts.gen.TypeScriptLexer;
import one.edee.babylon.export.ts.gen.TypeScriptParser;
import one.edee.babylon.msgfile.TranslationFileUtils;
import one.edee.babylon.util.FileUtils;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Log4j2
public class TsMessageLoader implements MessageLoader {

    public static final String TS_FILE_EXTENSION = ".ts";

    @Override
    public boolean canBeLoaded(String filePath) {
        return filePath.endsWith(TS_FILE_EXTENSION);
    }

    @Override
    public Map<String, String> loadPrimaryMessages(String filePath) {
        return ofNullable(loadFile(filePath))
                .map(TypeScriptBabylonParserListener::getPropertyDefinitions)
                .orElse(Collections.emptyMap());
    }

    @Override
    public Map<String, Map<String, String>> loadTranslations(String filePath, List<String> languages) {
        return languages
                .stream()
                .map(lang ->
                        new AbstractMap.SimpleEntry<>(
                                lang,
                                loadTranslations(filePath, lang)
                        )
                ).collect(Collectors.toMap(
                        AbstractMap.SimpleEntry::getKey,
                        AbstractMap.SimpleEntry::getValue)
                );
    }


    public static Map<String, String> dumpTsFile(Reader reader) throws IOException {
        return readTsFile(reader).getPropertyDefinitions();
    }

    public static TypeScriptBabylonParserListener readTsFile(Reader reader) throws IOException {
        CharStream input = CharStreams.fromReader(reader);

        TypeScriptLexer lexer = new TypeScriptLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypeScriptParser parser = new TypeScriptParser(tokens);
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                log.error("Cannot parse: " + s + " at line " + i + " with exception: " + e.getMessage());
            }
        });
        ParseTree tree = parser.program();

        TypeScriptBabylonParserListener listener = new TypeScriptBabylonParserListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        return listener;
    }

    private Map<String, String> loadTranslations(String filePath, String language) {
        String translationFilePath = TranslationFileUtils.getFileNameForTranslation(filePath, language);
        return ofNullable(loadFile(translationFilePath))
                .map(TypeScriptBabylonParserListener::getPropertyDefinitions)
                .orElse(Collections.emptyMap());
    }


    public static TypeScriptBabylonParserListener loadFile(String filePath) {
        if (FileUtils.exists(filePath)) {

            log.info("Processing ts file: " + filePath);
            try (Reader inputStreamReader = new FileReader(fileFromPath(filePath))) {
                return readTsFile(inputStreamReader);
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            }
        } else {
            return null;
        }
    }


    private static File fileFromPath(String path) {
        return FileUtils.fileFromPathOrThrow(path);
    }

}
