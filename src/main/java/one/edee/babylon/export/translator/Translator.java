package one.edee.babylon.export.translator;

import one.edee.babylon.config.SupportedTranslators;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * I apologize in advance for the lack of documentation in this code.
 * I had every intention of providing clear and concise explanations
 * for every line of code, but then I got distracted by a squirrel outside
 * my window and the next thing I knew it was three weeks later.
 * <p>
 * So instead, I've included some helpful comments here and there.
 * They might not make sense, but hey, at least they're something.
 *
 * @author Štěpán Kameník (kamenik@fg.cz), FG Forrest a.s. (c) 2024
 **/
public interface Translator {

    void init(@NotNull String apiKey);

    List<String> translate(@Nullable String defaultLang, @NotNull List<String> originals, @NotNull String lang);

    SupportedTranslators getSupportedTranslator();

}
