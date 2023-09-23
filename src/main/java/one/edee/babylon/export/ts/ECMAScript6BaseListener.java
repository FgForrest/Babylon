// Generated from /www/p_java/babylon/src/main/java/one/edee/babylon/export/ts/ECMAScript6.g4 by ANTLR 4.13.1
package one.edee.babylon.export.ts;

/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2015 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2015 Sun Microsystems, Inc.
 */


import lombok.Getter;
import one.edee.babylon.export.ts.ECMAScript6Parser.ImportDeclarationContext;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.springframework.util.Assert;

import java.util.*;

/**
 */
@Getter
@SuppressWarnings("CheckReturnValue")
public class ECMAScript6BaseListener implements ECMAScript6Listener {
    private static final boolean DEBUG_LISTENER_METHODS = false;
    private static final String APOSTROPHE_CLEANING_REGEX = "['`].*?";

    private final Map<String, String> propertyDefinitions = new LinkedHashMap<>();
    private final List<String> imports = new LinkedList<>();


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPropertyDefinition(ECMAScript6Parser.PropertyDefinitionContext ctx) {

        int childCount = ctx.getChildCount();
        Assert.isTrue(childCount == 3, "There has to be property name, delimiter (:) and value! In: " + ctx.getText());
        String propertyName = cleanText(ctx.getChild(0));
        String propertyValue = cleanText(ctx.getChild(2));
        propertyDefinitions.put(propertyName, propertyValue);
    }

    @Override
    public void enterImportDeclaration(ImportDeclarationContext ctx) {
        imports.add(getNodeText(ctx));
    }

    private String cleanText(ParseTree child){
        String text = child.getText();
        if (text.matches(APOSTROPHE_CLEANING_REGEX) || (text.contains("\n") || text.contains("\r")))
            text = text.replaceAll("['`]", "");
        return text;
    }


    private String getNodeText(ImportDeclarationContext ctx){
        int childCount = ctx.getChildCount();
        if (childCount == 0) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();

            for(int i = 0; i < childCount; ++i) {
                if (i != 0) builder.append(" ");
                builder.append(ctx.getChild(i).getText());

            }
            return builder.toString();
        }
    }


    // OTHER METHODS

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBooleanLiteral(ECMAScript6Parser.BooleanLiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBooleanLiteral(ECMAScript6Parser.BooleanLiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterNumericLiteral(ECMAScript6Parser.NumericLiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitNumericLiteral(ECMAScript6Parser.NumericLiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterRegularExpressionLiteral(ECMAScript6Parser.RegularExpressionLiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitRegularExpressionLiteral(ECMAScript6Parser.RegularExpressionLiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBindingIdentifier(ECMAScript6Parser.BindingIdentifierContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBindingIdentifier(ECMAScript6Parser.BindingIdentifierContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterLabelIdentifier(ECMAScript6Parser.LabelIdentifierContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitLabelIdentifier(ECMAScript6Parser.LabelIdentifierContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPrimaryExpression(ECMAScript6Parser.PrimaryExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPrimaryExpression(ECMAScript6Parser.PrimaryExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterCoverParenthesizedExpressionAndArrowParameterList(ECMAScript6Parser.CoverParenthesizedExpressionAndArrowParameterListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitCoverParenthesizedExpressionAndArrowParameterList(ECMAScript6Parser.CoverParenthesizedExpressionAndArrowParameterListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterLiteral(ECMAScript6Parser.LiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitLiteral(ECMAScript6Parser.LiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterArrayLiteral(ECMAScript6Parser.ArrayLiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitArrayLiteral(ECMAScript6Parser.ArrayLiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterElementList(ECMAScript6Parser.ElementListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitElementList(ECMAScript6Parser.ElementListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterElementElision(ECMAScript6Parser.ElementElisionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitElementElision(ECMAScript6Parser.ElementElisionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterElision(ECMAScript6Parser.ElisionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitElision(ECMAScript6Parser.ElisionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterSpreadElement(ECMAScript6Parser.SpreadElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitSpreadElement(ECMAScript6Parser.SpreadElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterObjectLiteral(ECMAScript6Parser.ObjectLiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitObjectLiteral(ECMAScript6Parser.ObjectLiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPropertyDefinitionList(ECMAScript6Parser.PropertyDefinitionListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPropertyDefinitionList(ECMAScript6Parser.PropertyDefinitionListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPropertyDefinition(ECMAScript6Parser.PropertyDefinitionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPropertyName(ECMAScript6Parser.PropertyNameContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPropertyName(ECMAScript6Parser.PropertyNameContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterLiteralPropertyName(ECMAScript6Parser.LiteralPropertyNameContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitLiteralPropertyName(ECMAScript6Parser.LiteralPropertyNameContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterComputedPropertyName(ECMAScript6Parser.ComputedPropertyNameContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitComputedPropertyName(ECMAScript6Parser.ComputedPropertyNameContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterCoverInitializedName(ECMAScript6Parser.CoverInitializedNameContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitCoverInitializedName(ECMAScript6Parser.CoverInitializedNameContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterInitializer(ECMAScript6Parser.InitializerContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitInitializer(ECMAScript6Parser.InitializerContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterTemplateLiteral(ECMAScript6Parser.TemplateLiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitTemplateLiteral(ECMAScript6Parser.TemplateLiteralContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterTemplateSpans(ECMAScript6Parser.TemplateSpansContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitTemplateSpans(ECMAScript6Parser.TemplateSpansContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterTemplateMiddleList(ECMAScript6Parser.TemplateMiddleListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitTemplateMiddleList(ECMAScript6Parser.TemplateMiddleListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterMemberExpression(ECMAScript6Parser.MemberExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitMemberExpression(ECMAScript6Parser.MemberExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterSuperProperty(ECMAScript6Parser.SuperPropertyContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitSuperProperty(ECMAScript6Parser.SuperPropertyContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterNewTarget(ECMAScript6Parser.NewTargetContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitNewTarget(ECMAScript6Parser.NewTargetContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterCallExpressionLRR(ECMAScript6Parser.CallExpressionLRRContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitCallExpressionLRR(ECMAScript6Parser.CallExpressionLRRContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterArguments(ECMAScript6Parser.ArgumentsContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitArguments(ECMAScript6Parser.ArgumentsContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterArgumentList(ECMAScript6Parser.ArgumentListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitArgumentList(ECMAScript6Parser.ArgumentListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterNewExpressionRest(ECMAScript6Parser.NewExpressionRestContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitNewExpressionRest(ECMAScript6Parser.NewExpressionRestContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterCallExpression(ECMAScript6Parser.CallExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitCallExpression(ECMAScript6Parser.CallExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterSuperCallExpression(ECMAScript6Parser.SuperCallExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitSuperCallExpression(ECMAScript6Parser.SuperCallExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterNewExpression(ECMAScript6Parser.NewExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitNewExpression(ECMAScript6Parser.NewExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPostfixExpression(ECMAScript6Parser.PostfixExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPostfixExpression(ECMAScript6Parser.PostfixExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterUnaryExpression(ECMAScript6Parser.UnaryExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitUnaryExpression(ECMAScript6Parser.UnaryExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBinaryExpression(ECMAScript6Parser.BinaryExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBinaryExpression(ECMAScript6Parser.BinaryExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterConditionalExpression(ECMAScript6Parser.ConditionalExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitConditionalExpression(ECMAScript6Parser.ConditionalExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterAssignmentExpression(ECMAScript6Parser.AssignmentExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAssignmentExpression(ECMAScript6Parser.AssignmentExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterAssignmentPattern(ECMAScript6Parser.AssignmentPatternContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAssignmentPattern(ECMAScript6Parser.AssignmentPatternContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterObjectAssignmentPattern(ECMAScript6Parser.ObjectAssignmentPatternContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitObjectAssignmentPattern(ECMAScript6Parser.ObjectAssignmentPatternContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterArrayAssignmentPattern(ECMAScript6Parser.ArrayAssignmentPatternContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitArrayAssignmentPattern(ECMAScript6Parser.ArrayAssignmentPatternContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterAssignmentPropertyList(ECMAScript6Parser.AssignmentPropertyListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAssignmentPropertyList(ECMAScript6Parser.AssignmentPropertyListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterAssignmentElementList(ECMAScript6Parser.AssignmentElementListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAssignmentElementList(ECMAScript6Parser.AssignmentElementListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterAssignmentElisionElement(ECMAScript6Parser.AssignmentElisionElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAssignmentElisionElement(ECMAScript6Parser.AssignmentElisionElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterAssignmentProperty(ECMAScript6Parser.AssignmentPropertyContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAssignmentProperty(ECMAScript6Parser.AssignmentPropertyContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterAssignmentElement(ECMAScript6Parser.AssignmentElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAssignmentElement(ECMAScript6Parser.AssignmentElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterAssignmentRestElement(ECMAScript6Parser.AssignmentRestElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAssignmentRestElement(ECMAScript6Parser.AssignmentRestElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExpressionSequence(ECMAScript6Parser.ExpressionSequenceContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExpressionSequence(ECMAScript6Parser.ExpressionSequenceContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterStatement(ECMAScript6Parser.StatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitStatement(ECMAScript6Parser.StatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterDeclaration(ECMAScript6Parser.DeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitDeclaration(ECMAScript6Parser.DeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterHoistableDeclaration(ECMAScript6Parser.HoistableDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitHoistableDeclaration(ECMAScript6Parser.HoistableDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBlock(ECMAScript6Parser.BlockContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBlock(ECMAScript6Parser.BlockContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterStatementList(ECMAScript6Parser.StatementListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitStatementList(ECMAScript6Parser.StatementListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterLexicalDeclaration(ECMAScript6Parser.LexicalDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitLexicalDeclaration(ECMAScript6Parser.LexicalDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterLetOrConst(ECMAScript6Parser.LetOrConstContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitLetOrConst(ECMAScript6Parser.LetOrConstContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBindingList(ECMAScript6Parser.BindingListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBindingList(ECMAScript6Parser.BindingListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterLexicalBinding(ECMAScript6Parser.LexicalBindingContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitLexicalBinding(ECMAScript6Parser.LexicalBindingContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterVariableStatement(ECMAScript6Parser.VariableStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitVariableStatement(ECMAScript6Parser.VariableStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterVariableDeclarationList(ECMAScript6Parser.VariableDeclarationListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitVariableDeclarationList(ECMAScript6Parser.VariableDeclarationListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterVariableDeclaration(ECMAScript6Parser.VariableDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitVariableDeclaration(ECMAScript6Parser.VariableDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBindingPattern(ECMAScript6Parser.BindingPatternContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBindingPattern(ECMAScript6Parser.BindingPatternContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterObjectBindingPattern(ECMAScript6Parser.ObjectBindingPatternContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitObjectBindingPattern(ECMAScript6Parser.ObjectBindingPatternContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterArrayBindingPattern(ECMAScript6Parser.ArrayBindingPatternContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitArrayBindingPattern(ECMAScript6Parser.ArrayBindingPatternContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBindingPropertyList(ECMAScript6Parser.BindingPropertyListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBindingPropertyList(ECMAScript6Parser.BindingPropertyListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBindingElementList(ECMAScript6Parser.BindingElementListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBindingElementList(ECMAScript6Parser.BindingElementListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBindingElisionElement(ECMAScript6Parser.BindingElisionElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBindingElisionElement(ECMAScript6Parser.BindingElisionElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBindingProperty(ECMAScript6Parser.BindingPropertyContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBindingProperty(ECMAScript6Parser.BindingPropertyContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBindingElement(ECMAScript6Parser.BindingElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBindingElement(ECMAScript6Parser.BindingElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterSingleNameBinding(ECMAScript6Parser.SingleNameBindingContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitSingleNameBinding(ECMAScript6Parser.SingleNameBindingContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBindingRestElement(ECMAScript6Parser.BindingRestElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBindingRestElement(ECMAScript6Parser.BindingRestElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEmptyStatement(ECMAScript6Parser.EmptyStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEmptyStatement(ECMAScript6Parser.EmptyStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExpressionStatement(ECMAScript6Parser.ExpressionStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExpressionStatement(ECMAScript6Parser.ExpressionStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterIfStatement(ECMAScript6Parser.IfStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitIfStatement(ECMAScript6Parser.IfStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterDoWhileStatement(ECMAScript6Parser.DoWhileStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitDoWhileStatement(ECMAScript6Parser.DoWhileStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterWhileStatement(ECMAScript6Parser.WhileStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitWhileStatement(ECMAScript6Parser.WhileStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForStatement(ECMAScript6Parser.ForStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForStatement(ECMAScript6Parser.ForStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForVarStatement(ECMAScript6Parser.ForVarStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForVarStatement(ECMAScript6Parser.ForVarStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForLCStatement(ECMAScript6Parser.ForLCStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForLCStatement(ECMAScript6Parser.ForLCStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForInStatement(ECMAScript6Parser.ForInStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForInStatement(ECMAScript6Parser.ForInStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForVarInStatement(ECMAScript6Parser.ForVarInStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForVarInStatement(ECMAScript6Parser.ForVarInStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForCLInStatement(ECMAScript6Parser.ForCLInStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForCLInStatement(ECMAScript6Parser.ForCLInStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForOfStatement(ECMAScript6Parser.ForOfStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForOfStatement(ECMAScript6Parser.ForOfStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForVarOfStatement(ECMAScript6Parser.ForVarOfStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForVarOfStatement(ECMAScript6Parser.ForVarOfStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForCLOfStatement(ECMAScript6Parser.ForCLOfStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForCLOfStatement(ECMAScript6Parser.ForCLOfStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForDeclaration(ECMAScript6Parser.ForDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForDeclaration(ECMAScript6Parser.ForDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForBinding(ECMAScript6Parser.ForBindingContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForBinding(ECMAScript6Parser.ForBindingContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterContinueStatement(ECMAScript6Parser.ContinueStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitContinueStatement(ECMAScript6Parser.ContinueStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBreakStatement(ECMAScript6Parser.BreakStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBreakStatement(ECMAScript6Parser.BreakStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterReturnStatement(ECMAScript6Parser.ReturnStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitReturnStatement(ECMAScript6Parser.ReturnStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterWithStatement(ECMAScript6Parser.WithStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitWithStatement(ECMAScript6Parser.WithStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterSwitchStatement(ECMAScript6Parser.SwitchStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitSwitchStatement(ECMAScript6Parser.SwitchStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterCaseBlock(ECMAScript6Parser.CaseBlockContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitCaseBlock(ECMAScript6Parser.CaseBlockContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterCaseClauses(ECMAScript6Parser.CaseClausesContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitCaseClauses(ECMAScript6Parser.CaseClausesContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterCaseClause(ECMAScript6Parser.CaseClauseContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitCaseClause(ECMAScript6Parser.CaseClauseContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterDefaultClause(ECMAScript6Parser.DefaultClauseContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitDefaultClause(ECMAScript6Parser.DefaultClauseContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterLabelledStatement(ECMAScript6Parser.LabelledStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitLabelledStatement(ECMAScript6Parser.LabelledStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterLabelledItem(ECMAScript6Parser.LabelledItemContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitLabelledItem(ECMAScript6Parser.LabelledItemContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterThrowStatement(ECMAScript6Parser.ThrowStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitThrowStatement(ECMAScript6Parser.ThrowStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterTryStatement(ECMAScript6Parser.TryStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitTryStatement(ECMAScript6Parser.TryStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterCatchBlock(ECMAScript6Parser.CatchBlockContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitCatchBlock(ECMAScript6Parser.CatchBlockContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFinallyBlock(ECMAScript6Parser.FinallyBlockContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFinallyBlock(ECMAScript6Parser.FinallyBlockContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterCatchParameter(ECMAScript6Parser.CatchParameterContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitCatchParameter(ECMAScript6Parser.CatchParameterContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterDebuggerStatement(ECMAScript6Parser.DebuggerStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitDebuggerStatement(ECMAScript6Parser.DebuggerStatementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFunctionDeclaration(ECMAScript6Parser.FunctionDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFunctionDeclaration(ECMAScript6Parser.FunctionDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterStrictFormalParameters(ECMAScript6Parser.StrictFormalParametersContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitStrictFormalParameters(ECMAScript6Parser.StrictFormalParametersContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFormalParameters(ECMAScript6Parser.FormalParametersContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFormalParameters(ECMAScript6Parser.FormalParametersContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFormalParameterList(ECMAScript6Parser.FormalParameterListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFormalParameterList(ECMAScript6Parser.FormalParameterListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFunctionRestParameter(ECMAScript6Parser.FunctionRestParameterContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFunctionRestParameter(ECMAScript6Parser.FunctionRestParameterContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFormalParameter(ECMAScript6Parser.FormalParameterContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFormalParameter(ECMAScript6Parser.FormalParameterContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFunctionBody(ECMAScript6Parser.FunctionBodyContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFunctionBody(ECMAScript6Parser.FunctionBodyContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterArrowFunction(ECMAScript6Parser.ArrowFunctionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitArrowFunction(ECMAScript6Parser.ArrowFunctionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterArrowParameters(ECMAScript6Parser.ArrowParametersContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitArrowParameters(ECMAScript6Parser.ArrowParametersContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterConciseBody(ECMAScript6Parser.ConciseBodyContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitConciseBody(ECMAScript6Parser.ConciseBodyContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterMethodDefinition(ECMAScript6Parser.MethodDefinitionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitMethodDefinition(ECMAScript6Parser.MethodDefinitionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterGetterPrefix(ECMAScript6Parser.GetterPrefixContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitGetterPrefix(ECMAScript6Parser.GetterPrefixContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterSetterPrefix(ECMAScript6Parser.SetterPrefixContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitSetterPrefix(ECMAScript6Parser.SetterPrefixContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPropertySetParameterList(ECMAScript6Parser.PropertySetParameterListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPropertySetParameterList(ECMAScript6Parser.PropertySetParameterListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterGeneratorMethod(ECMAScript6Parser.GeneratorMethodContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitGeneratorMethod(ECMAScript6Parser.GeneratorMethodContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterGeneratorDeclaration(ECMAScript6Parser.GeneratorDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitGeneratorDeclaration(ECMAScript6Parser.GeneratorDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterYieldExpression(ECMAScript6Parser.YieldExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitYieldExpression(ECMAScript6Parser.YieldExpressionContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterClassDeclaration(ECMAScript6Parser.ClassDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitClassDeclaration(ECMAScript6Parser.ClassDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterClassBody(ECMAScript6Parser.ClassBodyContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitClassBody(ECMAScript6Parser.ClassBodyContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterClassElement(ECMAScript6Parser.ClassElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitClassElement(ECMAScript6Parser.ClassElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterProgram(ECMAScript6Parser.ProgramContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitProgram(ECMAScript6Parser.ProgramContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterSourceElements(ECMAScript6Parser.SourceElementsContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitSourceElements(ECMAScript6Parser.SourceElementsContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterSourceElement(ECMAScript6Parser.SourceElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitSourceElement(ECMAScript6Parser.SourceElementContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitImportDeclaration(ImportDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterImportClause(ECMAScript6Parser.ImportClauseContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitImportClause(ECMAScript6Parser.ImportClauseContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterImportedDefaultBinding(ECMAScript6Parser.ImportedDefaultBindingContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitImportedDefaultBinding(ECMAScript6Parser.ImportedDefaultBindingContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterNameSpaceImport(ECMAScript6Parser.NameSpaceImportContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitNameSpaceImport(ECMAScript6Parser.NameSpaceImportContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterNamedImports(ECMAScript6Parser.NamedImportsContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitNamedImports(ECMAScript6Parser.NamedImportsContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFromClause(ECMAScript6Parser.FromClauseContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFromClause(ECMAScript6Parser.FromClauseContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterImportsList(ECMAScript6Parser.ImportsListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitImportsList(ECMAScript6Parser.ImportsListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterImportSpecifier(ECMAScript6Parser.ImportSpecifierContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitImportSpecifier(ECMAScript6Parser.ImportSpecifierContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterModuleSpecifier(ECMAScript6Parser.ModuleSpecifierContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitModuleSpecifier(ECMAScript6Parser.ModuleSpecifierContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterImportedBinding(ECMAScript6Parser.ImportedBindingContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitImportedBinding(ECMAScript6Parser.ImportedBindingContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExportDeclaration(ECMAScript6Parser.ExportDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExportDeclaration(ECMAScript6Parser.ExportDeclarationContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExportClause(ECMAScript6Parser.ExportClauseContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExportClause(ECMAScript6Parser.ExportClauseContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExportsList(ECMAScript6Parser.ExportsListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExportsList(ECMAScript6Parser.ExportsListContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExportSpecifier(ECMAScript6Parser.ExportSpecifierContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExportSpecifier(ECMAScript6Parser.ExportSpecifierContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterReservedKeyword(ECMAScript6Parser.ReservedKeywordContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitReservedKeyword(ECMAScript6Parser.ReservedKeywordContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEos(ECMAScript6Parser.EosContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEos(ECMAScript6Parser.EosContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitTerminal(TerminalNode node) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitErrorNode(ErrorNode node) {
        if (DEBUG_LISTENER_METHODS) System.out.println(new RuntimeException().getStackTrace()[0].getMethodName());
    }
}
