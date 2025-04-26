package one.edee.babylon.export.translator;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import one.edee.babylon.config.SupportedTranslators;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.cloud.translate.Translate.TranslateOption.sourceLanguage;
import static com.google.cloud.translate.Translate.TranslateOption.targetLanguage;

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
public class GoogleTranslator implements Translator{

    Translate service = null;

    @Override
    public void init(@NotNull String apiKey) {
        service = TranslateOptions.newBuilder().setApiKey(apiKey).build().getService();

    }

    @Override
    public List<String> translate(@Nullable String defaultLang, @NotNull List<String> original, @NotNull String lang) {
        Assert.notNull(service, "Init method with api key has to be called before translation!");
        return service.translate(
                        original,
                        sourceLanguage(defaultLang),
                        targetLanguage(lang)
                )
                .stream()
                .map(Translation::getTranslatedText)
                .collect(Collectors.toList());
    }

    @Override
    public SupportedTranslators getSupportedTranslator() {
        return SupportedTranslators.GOOGLE;
    }
}
