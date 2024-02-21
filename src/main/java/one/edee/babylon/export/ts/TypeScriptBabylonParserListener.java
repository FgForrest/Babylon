package one.edee.babylon.export.ts;

import lombok.Data;
import lombok.EqualsAndHashCode;
import one.edee.babylon.export.ts.gen.TypeScriptParser;
import one.edee.babylon.export.ts.gen.TypeScriptParserBaseListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.springframework.util.Assert;

import java.util.*;


@EqualsAndHashCode(callSuper = true)
@Data
public class TypeScriptBabylonParserListener extends TypeScriptParserBaseListener {

    private static final String APOSTROPHE_CLEANING_REGEX = "['`].*?";

    private final Set<String> propertyListDefName = new HashSet<>();
    private final Map<String, String> propertyDefinitions = new LinkedHashMap<>();
    private final List<String> imports = new LinkedList<>();

    @Override
    public void enterIdentifierOrKeyWord(TypeScriptParser.IdentifierOrKeyWordContext ctx) {
        propertyListDefName.add(ctx.getText());
    }

    @Override
    public void enterPropertyExpressionAssignment(TypeScriptParser.PropertyExpressionAssignmentContext ctx) {
        int childCount = ctx.getChildCount();
        Assert.isTrue(childCount == 3, "There has to be property name, delimiter (:) and value! In: " + ctx.getText());
        String propertyName = cleanText(ctx.getChild(0).getText());
        String propertyValue = cleanText(ctx.getChild(2).getText());
        propertyDefinitions.put(propertyName, propertyValue);
    }

    @Override
    public void enterComputedPropertyExpressionAssignment(TypeScriptParser.ComputedPropertyExpressionAssignmentContext ctx) {
        String[] split = ctx.getText().split(":");
        Assert.isTrue(split.length == 2, "There has to be property name, delimiter (:) and value! In: " + ctx.getText());
        String propertyName = cleanText(split[0]);
        String propertyValue = cleanText(split[1]);
        propertyDefinitions.put(propertyName, propertyValue);
    }

    @Override
    public void enterImportStatement(TypeScriptParser.ImportStatementContext ctx) {
        imports.add(getNodeText(ctx));
    }

    private String cleanText(String text) {
        if (text.matches(APOSTROPHE_CLEANING_REGEX) || (text.contains("\n") || text.contains("\r")))
            text = text.replaceAll("['`]", "");
        return text;
    }


    private String getNodeText(ParserRuleContext ctx) {
        int childCount = ctx.getChildCount();
        if (childCount == 0) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < childCount; ++i) {
                if (i != 0) builder.append(" ");
                builder.append(ctx.getChild(i).getText());

            }
            return builder.toString();
        }
    }


    // OTHER METHODS
}
