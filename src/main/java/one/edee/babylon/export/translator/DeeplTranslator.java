package one.edee.babylon.export.translator;

import com.deepl.api.TextResult;
import com.deepl.api.TextTranslationOptions;
import com.deepl.api.Translator;
import lombok.extern.log4j.Log4j2;
import one.edee.babylon.config.SupportedTranslators;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

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
@Component
@Log4j2
public class DeeplTranslator implements one.edee.babylon.export.translator.Translator {

    Translator service = null;

    @Override
    public void init(@NotNull String apiKey) {
        service = new Translator(apiKey);

    }

    @Override
    public List<String> translate(@Nullable String defaultLang, @NotNull List<String> original, @NotNull String lang) {
        Assert.notNull(service, "Init method with api key has to be called before translation!");

        if (lang.equals("en")) {
            lang = "en-GB";
        }
        try {
            return service.translateText(
                            original,
                            defaultLang,
                            lang,
                            new TextTranslationOptions()
                                    .setContext("You are eshop translator. Do not translate text from other languages then source lang, or technical texts."))
                    .stream()
                    .map(TextResult::getText)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Cannot translate " + original + " to lang: " + lang);
            return null;
        }
    }

    @Override
    public SupportedTranslators getSupportedTranslator() {
        return SupportedTranslators.DEEPL;
    }
}
