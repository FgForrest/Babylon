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



import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ECMAScript6Parser}.
 */
public interface ECMAScript6Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(ECMAScript6Parser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(ECMAScript6Parser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteral(ECMAScript6Parser.NumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteral(ECMAScript6Parser.NumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#regularExpressionLiteral}.
	 * @param ctx the parse tree
	 */
	void enterRegularExpressionLiteral(ECMAScript6Parser.RegularExpressionLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#regularExpressionLiteral}.
	 * @param ctx the parse tree
	 */
	void exitRegularExpressionLiteral(ECMAScript6Parser.RegularExpressionLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#bindingIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterBindingIdentifier(ECMAScript6Parser.BindingIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#bindingIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitBindingIdentifier(ECMAScript6Parser.BindingIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#labelIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterLabelIdentifier(ECMAScript6Parser.LabelIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#labelIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitLabelIdentifier(ECMAScript6Parser.LabelIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(ECMAScript6Parser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(ECMAScript6Parser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#coverParenthesizedExpressionAndArrowParameterList}.
	 * @param ctx the parse tree
	 */
	void enterCoverParenthesizedExpressionAndArrowParameterList(ECMAScript6Parser.CoverParenthesizedExpressionAndArrowParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#coverParenthesizedExpressionAndArrowParameterList}.
	 * @param ctx the parse tree
	 */
	void exitCoverParenthesizedExpressionAndArrowParameterList(ECMAScript6Parser.CoverParenthesizedExpressionAndArrowParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ECMAScript6Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ECMAScript6Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(ECMAScript6Parser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(ECMAScript6Parser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#elementList}.
	 * @param ctx the parse tree
	 */
	void enterElementList(ECMAScript6Parser.ElementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#elementList}.
	 * @param ctx the parse tree
	 */
	void exitElementList(ECMAScript6Parser.ElementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#elementElision}.
	 * @param ctx the parse tree
	 */
	void enterElementElision(ECMAScript6Parser.ElementElisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#elementElision}.
	 * @param ctx the parse tree
	 */
	void exitElementElision(ECMAScript6Parser.ElementElisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#elision}.
	 * @param ctx the parse tree
	 */
	void enterElision(ECMAScript6Parser.ElisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#elision}.
	 * @param ctx the parse tree
	 */
	void exitElision(ECMAScript6Parser.ElisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#spreadElement}.
	 * @param ctx the parse tree
	 */
	void enterSpreadElement(ECMAScript6Parser.SpreadElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#spreadElement}.
	 * @param ctx the parse tree
	 */
	void exitSpreadElement(ECMAScript6Parser.SpreadElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(ECMAScript6Parser.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(ECMAScript6Parser.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#propertyDefinitionList}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDefinitionList(ECMAScript6Parser.PropertyDefinitionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#propertyDefinitionList}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDefinitionList(ECMAScript6Parser.PropertyDefinitionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#propertyDefinition}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDefinition(ECMAScript6Parser.PropertyDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#propertyDefinition}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDefinition(ECMAScript6Parser.PropertyDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#propertyName}.
	 * @param ctx the parse tree
	 */
	void enterPropertyName(ECMAScript6Parser.PropertyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#propertyName}.
	 * @param ctx the parse tree
	 */
	void exitPropertyName(ECMAScript6Parser.PropertyNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#literalPropertyName}.
	 * @param ctx the parse tree
	 */
	void enterLiteralPropertyName(ECMAScript6Parser.LiteralPropertyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#literalPropertyName}.
	 * @param ctx the parse tree
	 */
	void exitLiteralPropertyName(ECMAScript6Parser.LiteralPropertyNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#computedPropertyName}.
	 * @param ctx the parse tree
	 */
	void enterComputedPropertyName(ECMAScript6Parser.ComputedPropertyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#computedPropertyName}.
	 * @param ctx the parse tree
	 */
	void exitComputedPropertyName(ECMAScript6Parser.ComputedPropertyNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#coverInitializedName}.
	 * @param ctx the parse tree
	 */
	void enterCoverInitializedName(ECMAScript6Parser.CoverInitializedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#coverInitializedName}.
	 * @param ctx the parse tree
	 */
	void exitCoverInitializedName(ECMAScript6Parser.CoverInitializedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(ECMAScript6Parser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(ECMAScript6Parser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#templateLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTemplateLiteral(ECMAScript6Parser.TemplateLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#templateLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTemplateLiteral(ECMAScript6Parser.TemplateLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#templateSpans}.
	 * @param ctx the parse tree
	 */
	void enterTemplateSpans(ECMAScript6Parser.TemplateSpansContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#templateSpans}.
	 * @param ctx the parse tree
	 */
	void exitTemplateSpans(ECMAScript6Parser.TemplateSpansContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#templateMiddleList}.
	 * @param ctx the parse tree
	 */
	void enterTemplateMiddleList(ECMAScript6Parser.TemplateMiddleListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#templateMiddleList}.
	 * @param ctx the parse tree
	 */
	void exitTemplateMiddleList(ECMAScript6Parser.TemplateMiddleListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#memberExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpression(ECMAScript6Parser.MemberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#memberExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpression(ECMAScript6Parser.MemberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#superProperty}.
	 * @param ctx the parse tree
	 */
	void enterSuperProperty(ECMAScript6Parser.SuperPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#superProperty}.
	 * @param ctx the parse tree
	 */
	void exitSuperProperty(ECMAScript6Parser.SuperPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#newTarget}.
	 * @param ctx the parse tree
	 */
	void enterNewTarget(ECMAScript6Parser.NewTargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#newTarget}.
	 * @param ctx the parse tree
	 */
	void exitNewTarget(ECMAScript6Parser.NewTargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#callExpressionLRR}.
	 * @param ctx the parse tree
	 */
	void enterCallExpressionLRR(ECMAScript6Parser.CallExpressionLRRContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#callExpressionLRR}.
	 * @param ctx the parse tree
	 */
	void exitCallExpressionLRR(ECMAScript6Parser.CallExpressionLRRContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(ECMAScript6Parser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(ECMAScript6Parser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(ECMAScript6Parser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(ECMAScript6Parser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#newExpressionRest}.
	 * @param ctx the parse tree
	 */
	void enterNewExpressionRest(ECMAScript6Parser.NewExpressionRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#newExpressionRest}.
	 * @param ctx the parse tree
	 */
	void exitNewExpressionRest(ECMAScript6Parser.NewExpressionRestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExpression}
	 * labeled alternative in {@link ECMAScript6Parser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpression(ECMAScript6Parser.CallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExpression}
	 * labeled alternative in {@link ECMAScript6Parser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpression(ECMAScript6Parser.CallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code superCallExpression}
	 * labeled alternative in {@link ECMAScript6Parser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 */
	void enterSuperCallExpression(ECMAScript6Parser.SuperCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code superCallExpression}
	 * labeled alternative in {@link ECMAScript6Parser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 */
	void exitSuperCallExpression(ECMAScript6Parser.SuperCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link ECMAScript6Parser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(ECMAScript6Parser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link ECMAScript6Parser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(ECMAScript6Parser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(ECMAScript6Parser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(ECMAScript6Parser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(ECMAScript6Parser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(ECMAScript6Parser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(ECMAScript6Parser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(ECMAScript6Parser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(ECMAScript6Parser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(ECMAScript6Parser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(ECMAScript6Parser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(ECMAScript6Parser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#assignmentPattern}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentPattern(ECMAScript6Parser.AssignmentPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#assignmentPattern}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentPattern(ECMAScript6Parser.AssignmentPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#objectAssignmentPattern}.
	 * @param ctx the parse tree
	 */
	void enterObjectAssignmentPattern(ECMAScript6Parser.ObjectAssignmentPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#objectAssignmentPattern}.
	 * @param ctx the parse tree
	 */
	void exitObjectAssignmentPattern(ECMAScript6Parser.ObjectAssignmentPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#arrayAssignmentPattern}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignmentPattern(ECMAScript6Parser.ArrayAssignmentPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#arrayAssignmentPattern}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignmentPattern(ECMAScript6Parser.ArrayAssignmentPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#assignmentPropertyList}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentPropertyList(ECMAScript6Parser.AssignmentPropertyListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#assignmentPropertyList}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentPropertyList(ECMAScript6Parser.AssignmentPropertyListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#assignmentElementList}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentElementList(ECMAScript6Parser.AssignmentElementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#assignmentElementList}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentElementList(ECMAScript6Parser.AssignmentElementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#assignmentElisionElement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentElisionElement(ECMAScript6Parser.AssignmentElisionElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#assignmentElisionElement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentElisionElement(ECMAScript6Parser.AssignmentElisionElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#assignmentProperty}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentProperty(ECMAScript6Parser.AssignmentPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#assignmentProperty}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentProperty(ECMAScript6Parser.AssignmentPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#assignmentElement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentElement(ECMAScript6Parser.AssignmentElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#assignmentElement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentElement(ECMAScript6Parser.AssignmentElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#assignmentRestElement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentRestElement(ECMAScript6Parser.AssignmentRestElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#assignmentRestElement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentRestElement(ECMAScript6Parser.AssignmentRestElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void enterExpressionSequence(ECMAScript6Parser.ExpressionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void exitExpressionSequence(ECMAScript6Parser.ExpressionSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ECMAScript6Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ECMAScript6Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(ECMAScript6Parser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(ECMAScript6Parser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#hoistableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterHoistableDeclaration(ECMAScript6Parser.HoistableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#hoistableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitHoistableDeclaration(ECMAScript6Parser.HoistableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ECMAScript6Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ECMAScript6Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(ECMAScript6Parser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(ECMAScript6Parser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#lexicalDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLexicalDeclaration(ECMAScript6Parser.LexicalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#lexicalDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLexicalDeclaration(ECMAScript6Parser.LexicalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#letOrConst}.
	 * @param ctx the parse tree
	 */
	void enterLetOrConst(ECMAScript6Parser.LetOrConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#letOrConst}.
	 * @param ctx the parse tree
	 */
	void exitLetOrConst(ECMAScript6Parser.LetOrConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#bindingList}.
	 * @param ctx the parse tree
	 */
	void enterBindingList(ECMAScript6Parser.BindingListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#bindingList}.
	 * @param ctx the parse tree
	 */
	void exitBindingList(ECMAScript6Parser.BindingListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#lexicalBinding}.
	 * @param ctx the parse tree
	 */
	void enterLexicalBinding(ECMAScript6Parser.LexicalBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#lexicalBinding}.
	 * @param ctx the parse tree
	 */
	void exitLexicalBinding(ECMAScript6Parser.LexicalBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void enterVariableStatement(ECMAScript6Parser.VariableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void exitVariableStatement(ECMAScript6Parser.VariableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationList(ECMAScript6Parser.VariableDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationList(ECMAScript6Parser.VariableDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(ECMAScript6Parser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(ECMAScript6Parser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#bindingPattern}.
	 * @param ctx the parse tree
	 */
	void enterBindingPattern(ECMAScript6Parser.BindingPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#bindingPattern}.
	 * @param ctx the parse tree
	 */
	void exitBindingPattern(ECMAScript6Parser.BindingPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#objectBindingPattern}.
	 * @param ctx the parse tree
	 */
	void enterObjectBindingPattern(ECMAScript6Parser.ObjectBindingPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#objectBindingPattern}.
	 * @param ctx the parse tree
	 */
	void exitObjectBindingPattern(ECMAScript6Parser.ObjectBindingPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#arrayBindingPattern}.
	 * @param ctx the parse tree
	 */
	void enterArrayBindingPattern(ECMAScript6Parser.ArrayBindingPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#arrayBindingPattern}.
	 * @param ctx the parse tree
	 */
	void exitArrayBindingPattern(ECMAScript6Parser.ArrayBindingPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#bindingPropertyList}.
	 * @param ctx the parse tree
	 */
	void enterBindingPropertyList(ECMAScript6Parser.BindingPropertyListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#bindingPropertyList}.
	 * @param ctx the parse tree
	 */
	void exitBindingPropertyList(ECMAScript6Parser.BindingPropertyListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#bindingElementList}.
	 * @param ctx the parse tree
	 */
	void enterBindingElementList(ECMAScript6Parser.BindingElementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#bindingElementList}.
	 * @param ctx the parse tree
	 */
	void exitBindingElementList(ECMAScript6Parser.BindingElementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#bindingElisionElement}.
	 * @param ctx the parse tree
	 */
	void enterBindingElisionElement(ECMAScript6Parser.BindingElisionElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#bindingElisionElement}.
	 * @param ctx the parse tree
	 */
	void exitBindingElisionElement(ECMAScript6Parser.BindingElisionElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#bindingProperty}.
	 * @param ctx the parse tree
	 */
	void enterBindingProperty(ECMAScript6Parser.BindingPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#bindingProperty}.
	 * @param ctx the parse tree
	 */
	void exitBindingProperty(ECMAScript6Parser.BindingPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#bindingElement}.
	 * @param ctx the parse tree
	 */
	void enterBindingElement(ECMAScript6Parser.BindingElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#bindingElement}.
	 * @param ctx the parse tree
	 */
	void exitBindingElement(ECMAScript6Parser.BindingElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#singleNameBinding}.
	 * @param ctx the parse tree
	 */
	void enterSingleNameBinding(ECMAScript6Parser.SingleNameBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#singleNameBinding}.
	 * @param ctx the parse tree
	 */
	void exitSingleNameBinding(ECMAScript6Parser.SingleNameBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#bindingRestElement}.
	 * @param ctx the parse tree
	 */
	void enterBindingRestElement(ECMAScript6Parser.BindingRestElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#bindingRestElement}.
	 * @param ctx the parse tree
	 */
	void exitBindingRestElement(ECMAScript6Parser.BindingRestElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(ECMAScript6Parser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(ECMAScript6Parser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(ECMAScript6Parser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(ECMAScript6Parser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(ECMAScript6Parser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(ECMAScript6Parser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(ECMAScript6Parser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(ECMAScript6Parser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(ECMAScript6Parser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(ECMAScript6Parser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(ECMAScript6Parser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(ECMAScript6Parser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForVarStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForVarStatement(ECMAScript6Parser.ForVarStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForVarStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForVarStatement(ECMAScript6Parser.ForVarStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForLCStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForLCStatement(ECMAScript6Parser.ForLCStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForLCStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForLCStatement(ECMAScript6Parser.ForLCStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForInStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForInStatement(ECMAScript6Parser.ForInStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForInStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForInStatement(ECMAScript6Parser.ForInStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForVarInStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForVarInStatement(ECMAScript6Parser.ForVarInStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForVarInStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForVarInStatement(ECMAScript6Parser.ForVarInStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForCLInStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForCLInStatement(ECMAScript6Parser.ForCLInStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForCLInStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForCLInStatement(ECMAScript6Parser.ForCLInStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForOfStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForOfStatement(ECMAScript6Parser.ForOfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForOfStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForOfStatement(ECMAScript6Parser.ForOfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForVarOfStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForVarOfStatement(ECMAScript6Parser.ForVarOfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForVarOfStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForVarOfStatement(ECMAScript6Parser.ForVarOfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForCLOfStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForCLOfStatement(ECMAScript6Parser.ForCLOfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForCLOfStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForCLOfStatement(ECMAScript6Parser.ForCLOfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterForDeclaration(ECMAScript6Parser.ForDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitForDeclaration(ECMAScript6Parser.ForDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#forBinding}.
	 * @param ctx the parse tree
	 */
	void enterForBinding(ECMAScript6Parser.ForBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#forBinding}.
	 * @param ctx the parse tree
	 */
	void exitForBinding(ECMAScript6Parser.ForBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(ECMAScript6Parser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(ECMAScript6Parser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(ECMAScript6Parser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(ECMAScript6Parser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(ECMAScript6Parser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(ECMAScript6Parser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#withStatement}.
	 * @param ctx the parse tree
	 */
	void enterWithStatement(ECMAScript6Parser.WithStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#withStatement}.
	 * @param ctx the parse tree
	 */
	void exitWithStatement(ECMAScript6Parser.WithStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(ECMAScript6Parser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(ECMAScript6Parser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(ECMAScript6Parser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(ECMAScript6Parser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#caseClauses}.
	 * @param ctx the parse tree
	 */
	void enterCaseClauses(ECMAScript6Parser.CaseClausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#caseClauses}.
	 * @param ctx the parse tree
	 */
	void exitCaseClauses(ECMAScript6Parser.CaseClausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#caseClause}.
	 * @param ctx the parse tree
	 */
	void enterCaseClause(ECMAScript6Parser.CaseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#caseClause}.
	 * @param ctx the parse tree
	 */
	void exitCaseClause(ECMAScript6Parser.CaseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void enterDefaultClause(ECMAScript6Parser.DefaultClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void exitDefaultClause(ECMAScript6Parser.DefaultClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#labelledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabelledStatement(ECMAScript6Parser.LabelledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#labelledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabelledStatement(ECMAScript6Parser.LabelledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#labelledItem}.
	 * @param ctx the parse tree
	 */
	void enterLabelledItem(ECMAScript6Parser.LabelledItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#labelledItem}.
	 * @param ctx the parse tree
	 */
	void exitLabelledItem(ECMAScript6Parser.LabelledItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(ECMAScript6Parser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(ECMAScript6Parser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(ECMAScript6Parser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(ECMAScript6Parser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#catchBlock}.
	 * @param ctx the parse tree
	 */
	void enterCatchBlock(ECMAScript6Parser.CatchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#catchBlock}.
	 * @param ctx the parse tree
	 */
	void exitCatchBlock(ECMAScript6Parser.CatchBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(ECMAScript6Parser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(ECMAScript6Parser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#catchParameter}.
	 * @param ctx the parse tree
	 */
	void enterCatchParameter(ECMAScript6Parser.CatchParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#catchParameter}.
	 * @param ctx the parse tree
	 */
	void exitCatchParameter(ECMAScript6Parser.CatchParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#debuggerStatement}.
	 * @param ctx the parse tree
	 */
	void enterDebuggerStatement(ECMAScript6Parser.DebuggerStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#debuggerStatement}.
	 * @param ctx the parse tree
	 */
	void exitDebuggerStatement(ECMAScript6Parser.DebuggerStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(ECMAScript6Parser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(ECMAScript6Parser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#strictFormalParameters}.
	 * @param ctx the parse tree
	 */
	void enterStrictFormalParameters(ECMAScript6Parser.StrictFormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#strictFormalParameters}.
	 * @param ctx the parse tree
	 */
	void exitStrictFormalParameters(ECMAScript6Parser.StrictFormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(ECMAScript6Parser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(ECMAScript6Parser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(ECMAScript6Parser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(ECMAScript6Parser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#functionRestParameter}.
	 * @param ctx the parse tree
	 */
	void enterFunctionRestParameter(ECMAScript6Parser.FunctionRestParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#functionRestParameter}.
	 * @param ctx the parse tree
	 */
	void exitFunctionRestParameter(ECMAScript6Parser.FunctionRestParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(ECMAScript6Parser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(ECMAScript6Parser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(ECMAScript6Parser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(ECMAScript6Parser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#arrowFunction}.
	 * @param ctx the parse tree
	 */
	void enterArrowFunction(ECMAScript6Parser.ArrowFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#arrowFunction}.
	 * @param ctx the parse tree
	 */
	void exitArrowFunction(ECMAScript6Parser.ArrowFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#arrowParameters}.
	 * @param ctx the parse tree
	 */
	void enterArrowParameters(ECMAScript6Parser.ArrowParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#arrowParameters}.
	 * @param ctx the parse tree
	 */
	void exitArrowParameters(ECMAScript6Parser.ArrowParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#conciseBody}.
	 * @param ctx the parse tree
	 */
	void enterConciseBody(ECMAScript6Parser.ConciseBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#conciseBody}.
	 * @param ctx the parse tree
	 */
	void exitConciseBody(ECMAScript6Parser.ConciseBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void enterMethodDefinition(ECMAScript6Parser.MethodDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void exitMethodDefinition(ECMAScript6Parser.MethodDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#getterPrefix}.
	 * @param ctx the parse tree
	 */
	void enterGetterPrefix(ECMAScript6Parser.GetterPrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#getterPrefix}.
	 * @param ctx the parse tree
	 */
	void exitGetterPrefix(ECMAScript6Parser.GetterPrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#setterPrefix}.
	 * @param ctx the parse tree
	 */
	void enterSetterPrefix(ECMAScript6Parser.SetterPrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#setterPrefix}.
	 * @param ctx the parse tree
	 */
	void exitSetterPrefix(ECMAScript6Parser.SetterPrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#propertySetParameterList}.
	 * @param ctx the parse tree
	 */
	void enterPropertySetParameterList(ECMAScript6Parser.PropertySetParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#propertySetParameterList}.
	 * @param ctx the parse tree
	 */
	void exitPropertySetParameterList(ECMAScript6Parser.PropertySetParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#generatorMethod}.
	 * @param ctx the parse tree
	 */
	void enterGeneratorMethod(ECMAScript6Parser.GeneratorMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#generatorMethod}.
	 * @param ctx the parse tree
	 */
	void exitGeneratorMethod(ECMAScript6Parser.GeneratorMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#generatorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGeneratorDeclaration(ECMAScript6Parser.GeneratorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#generatorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGeneratorDeclaration(ECMAScript6Parser.GeneratorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#yieldExpression}.
	 * @param ctx the parse tree
	 */
	void enterYieldExpression(ECMAScript6Parser.YieldExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#yieldExpression}.
	 * @param ctx the parse tree
	 */
	void exitYieldExpression(ECMAScript6Parser.YieldExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(ECMAScript6Parser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(ECMAScript6Parser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(ECMAScript6Parser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(ECMAScript6Parser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#classElement}.
	 * @param ctx the parse tree
	 */
	void enterClassElement(ECMAScript6Parser.ClassElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#classElement}.
	 * @param ctx the parse tree
	 */
	void exitClassElement(ECMAScript6Parser.ClassElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ECMAScript6Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ECMAScript6Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#sourceElements}.
	 * @param ctx the parse tree
	 */
	void enterSourceElements(ECMAScript6Parser.SourceElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#sourceElements}.
	 * @param ctx the parse tree
	 */
	void exitSourceElements(ECMAScript6Parser.SourceElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#sourceElement}.
	 * @param ctx the parse tree
	 */
	void enterSourceElement(ECMAScript6Parser.SourceElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#sourceElement}.
	 * @param ctx the parse tree
	 */
	void exitSourceElement(ECMAScript6Parser.SourceElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(ECMAScript6Parser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(ECMAScript6Parser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#importClause}.
	 * @param ctx the parse tree
	 */
	void enterImportClause(ECMAScript6Parser.ImportClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#importClause}.
	 * @param ctx the parse tree
	 */
	void exitImportClause(ECMAScript6Parser.ImportClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#importedDefaultBinding}.
	 * @param ctx the parse tree
	 */
	void enterImportedDefaultBinding(ECMAScript6Parser.ImportedDefaultBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#importedDefaultBinding}.
	 * @param ctx the parse tree
	 */
	void exitImportedDefaultBinding(ECMAScript6Parser.ImportedDefaultBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#nameSpaceImport}.
	 * @param ctx the parse tree
	 */
	void enterNameSpaceImport(ECMAScript6Parser.NameSpaceImportContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#nameSpaceImport}.
	 * @param ctx the parse tree
	 */
	void exitNameSpaceImport(ECMAScript6Parser.NameSpaceImportContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#namedImports}.
	 * @param ctx the parse tree
	 */
	void enterNamedImports(ECMAScript6Parser.NamedImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#namedImports}.
	 * @param ctx the parse tree
	 */
	void exitNamedImports(ECMAScript6Parser.NamedImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(ECMAScript6Parser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(ECMAScript6Parser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#importsList}.
	 * @param ctx the parse tree
	 */
	void enterImportsList(ECMAScript6Parser.ImportsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#importsList}.
	 * @param ctx the parse tree
	 */
	void exitImportsList(ECMAScript6Parser.ImportsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#importSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterImportSpecifier(ECMAScript6Parser.ImportSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#importSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitImportSpecifier(ECMAScript6Parser.ImportSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#moduleSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterModuleSpecifier(ECMAScript6Parser.ModuleSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#moduleSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitModuleSpecifier(ECMAScript6Parser.ModuleSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#importedBinding}.
	 * @param ctx the parse tree
	 */
	void enterImportedBinding(ECMAScript6Parser.ImportedBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#importedBinding}.
	 * @param ctx the parse tree
	 */
	void exitImportedBinding(ECMAScript6Parser.ImportedBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#exportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExportDeclaration(ECMAScript6Parser.ExportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#exportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExportDeclaration(ECMAScript6Parser.ExportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#exportClause}.
	 * @param ctx the parse tree
	 */
	void enterExportClause(ECMAScript6Parser.ExportClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#exportClause}.
	 * @param ctx the parse tree
	 */
	void exitExportClause(ECMAScript6Parser.ExportClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#exportsList}.
	 * @param ctx the parse tree
	 */
	void enterExportsList(ECMAScript6Parser.ExportsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#exportsList}.
	 * @param ctx the parse tree
	 */
	void exitExportsList(ECMAScript6Parser.ExportsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#exportSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterExportSpecifier(ECMAScript6Parser.ExportSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#exportSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitExportSpecifier(ECMAScript6Parser.ExportSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#reservedKeyword}.
	 * @param ctx the parse tree
	 */
	void enterReservedKeyword(ECMAScript6Parser.ReservedKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#reservedKeyword}.
	 * @param ctx the parse tree
	 */
	void exitReservedKeyword(ECMAScript6Parser.ReservedKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link ECMAScript6Parser#eos}.
	 * @param ctx the parse tree
	 */
	void enterEos(ECMAScript6Parser.EosContext ctx);
	/**
	 * Exit a parse tree produced by {@link ECMAScript6Parser#eos}.
	 * @param ctx the parse tree
	 */
	void exitEos(ECMAScript6Parser.EosContext ctx);
}
