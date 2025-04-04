package one.edee.babylon.config;

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
public enum SupportedTranslators {

    /**
     * @see one.edee.babylon.export.translator.GoogleTranslator
     */
    GOOGLE,

    /**
     * @see one.edee.babylon.export.translator.DeeplTranslator
     */
    DEEPL,

    /**
     * @see one.edee.babylon.export.translator.OpenAiTranslator
     */
    OPENAI
}
