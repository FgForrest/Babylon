package one.edee.babylon.export.translator;

import com.theokanning.openai.OpenAiHttpException;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import one.edee.babylon.config.SupportedTranslators;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

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
public class OpenAiTranslator implements Translator {

    OpenAiService service = null;

    @Override
    public void init(@NotNull String apiKey) {
        service = new OpenAiService(apiKey);
    }

    @SneakyThrows
    @Override
    public List<String> translate(@Nullable String defaultLang, @NotNull List<String> original, @NotNull String lang) {
        Assert.notNull(service, "Init method with api key has to be called before translation!");

        String systemMessage = System.getProperty("babylon.opanai.systemMessage");
        String formattedSystemMessage = String.format(
                ofNullable(systemMessage)
                        .orElse("You are translator that translate eshop messages from %s to %s. If you cannot translate it, return original text. Texts to translate are combined by '~'. Split input by comma, translate and return in same format."),
                defaultLang,
                lang);


        String joined = String.join("~", original);
        List<ChatMessage> messages = Arrays.asList(
                new ChatMessage("system", formattedSystemMessage),
                new ChatMessage("user", joined)
        );

        ChatCompletionResult chatCompletion;
        try{
            chatCompletion = service.createChatCompletion(
                    ChatCompletionRequest
                            .builder()
                            .model(ofNullable(System.getProperty("babylon.opanai.model")).orElse("gpt-3.5-turbo-16k-0613"))
                            .messages(
                                    messages
                            )
                            .build()
            );

        }catch (OpenAiHttpException e){
            if (e.getMessage().contains("Please try again in 20s")){
                log.info("Rate limit reached, will try again in 20 secs! Translate in progress " + original);
                Thread.sleep(20_000);
                return translate(defaultLang, original, lang);
            }
            throw e;
        }
        String result = chatCompletion.getChoices().get(0).getMessage().getContent();
        List<String> output = Arrays.stream(result.split("~")).collect(Collectors.toList());
        Assert.isTrue(output.size() == original.size(), "Size not equal " + joined + " " + result);
        return output;
    }

    @Override
    public SupportedTranslators getSupportedTranslator() {
        return SupportedTranslators.OPENAI;
    }
}
