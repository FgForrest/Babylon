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



import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ECMAScript6Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ECMAScript6Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(ECMAScript6Parser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#numericLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteral(ECMAScript6Parser.NumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#regularExpressionLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularExpressionLiteral(ECMAScript6Parser.RegularExpressionLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#bindingIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingIdentifier(ECMAScript6Parser.BindingIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#labelIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelIdentifier(ECMAScript6Parser.LabelIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(ECMAScript6Parser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#coverParenthesizedExpressionAndArrowParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoverParenthesizedExpressionAndArrowParameterList(ECMAScript6Parser.CoverParenthesizedExpressionAndArrowParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(ECMAScript6Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(ECMAScript6Parser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#elementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementList(ECMAScript6Parser.ElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#elementElision}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementElision(ECMAScript6Parser.ElementElisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#elision}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElision(ECMAScript6Parser.ElisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#spreadElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpreadElement(ECMAScript6Parser.SpreadElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#objectLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteral(ECMAScript6Parser.ObjectLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#propertyDefinitionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyDefinitionList(ECMAScript6Parser.PropertyDefinitionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#propertyDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyDefinition(ECMAScript6Parser.PropertyDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#propertyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyName(ECMAScript6Parser.PropertyNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#literalPropertyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralPropertyName(ECMAScript6Parser.LiteralPropertyNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#computedPropertyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputedPropertyName(ECMAScript6Parser.ComputedPropertyNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#coverInitializedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoverInitializedName(ECMAScript6Parser.CoverInitializedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(ECMAScript6Parser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#templateLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateLiteral(ECMAScript6Parser.TemplateLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#templateSpans}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateSpans(ECMAScript6Parser.TemplateSpansContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#templateMiddleList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateMiddleList(ECMAScript6Parser.TemplateMiddleListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#memberExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExpression(ECMAScript6Parser.MemberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#superProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperProperty(ECMAScript6Parser.SuperPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#newTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewTarget(ECMAScript6Parser.NewTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#callExpressionLRR}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpressionLRR(ECMAScript6Parser.CallExpressionLRRContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(ECMAScript6Parser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(ECMAScript6Parser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#newExpressionRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpressionRest(ECMAScript6Parser.NewExpressionRestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpression}
	 * labeled alternative in {@link ECMAScript6Parser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpression(ECMAScript6Parser.CallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code superCallExpression}
	 * labeled alternative in {@link ECMAScript6Parser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperCallExpression(ECMAScript6Parser.SuperCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link ECMAScript6Parser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(ECMAScript6Parser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(ECMAScript6Parser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(ECMAScript6Parser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#binaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpression(ECMAScript6Parser.BinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(ECMAScript6Parser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(ECMAScript6Parser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#assignmentPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentPattern(ECMAScript6Parser.AssignmentPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#objectAssignmentPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectAssignmentPattern(ECMAScript6Parser.ObjectAssignmentPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#arrayAssignmentPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignmentPattern(ECMAScript6Parser.ArrayAssignmentPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#assignmentPropertyList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentPropertyList(ECMAScript6Parser.AssignmentPropertyListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#assignmentElementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentElementList(ECMAScript6Parser.AssignmentElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#assignmentElisionElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentElisionElement(ECMAScript6Parser.AssignmentElisionElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#assignmentProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentProperty(ECMAScript6Parser.AssignmentPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#assignmentElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentElement(ECMAScript6Parser.AssignmentElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#assignmentRestElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentRestElement(ECMAScript6Parser.AssignmentRestElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#expressionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSequence(ECMAScript6Parser.ExpressionSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ECMAScript6Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(ECMAScript6Parser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#hoistableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHoistableDeclaration(ECMAScript6Parser.HoistableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ECMAScript6Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(ECMAScript6Parser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#lexicalDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexicalDeclaration(ECMAScript6Parser.LexicalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#letOrConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetOrConst(ECMAScript6Parser.LetOrConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#bindingList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingList(ECMAScript6Parser.BindingListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#lexicalBinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexicalBinding(ECMAScript6Parser.LexicalBindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#variableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableStatement(ECMAScript6Parser.VariableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#variableDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationList(ECMAScript6Parser.VariableDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(ECMAScript6Parser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#bindingPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingPattern(ECMAScript6Parser.BindingPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#objectBindingPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectBindingPattern(ECMAScript6Parser.ObjectBindingPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#arrayBindingPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayBindingPattern(ECMAScript6Parser.ArrayBindingPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#bindingPropertyList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingPropertyList(ECMAScript6Parser.BindingPropertyListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#bindingElementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingElementList(ECMAScript6Parser.BindingElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#bindingElisionElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingElisionElement(ECMAScript6Parser.BindingElisionElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#bindingProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingProperty(ECMAScript6Parser.BindingPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#bindingElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingElement(ECMAScript6Parser.BindingElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#singleNameBinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleNameBinding(ECMAScript6Parser.SingleNameBindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#bindingRestElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingRestElement(ECMAScript6Parser.BindingRestElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(ECMAScript6Parser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(ECMAScript6Parser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(ECMAScript6Parser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(ECMAScript6Parser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(ECMAScript6Parser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(ECMAScript6Parser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForVarStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForVarStatement(ECMAScript6Parser.ForVarStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForLCStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLCStatement(ECMAScript6Parser.ForLCStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForInStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInStatement(ECMAScript6Parser.ForInStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForVarInStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForVarInStatement(ECMAScript6Parser.ForVarInStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForCLInStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCLInStatement(ECMAScript6Parser.ForCLInStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForOfStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForOfStatement(ECMAScript6Parser.ForOfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForVarOfStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForVarOfStatement(ECMAScript6Parser.ForVarOfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForCLOfStatement}
	 * labeled alternative in {@link ECMAScript6Parser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCLOfStatement(ECMAScript6Parser.ForCLOfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#forDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDeclaration(ECMAScript6Parser.ForDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#forBinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForBinding(ECMAScript6Parser.ForBindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(ECMAScript6Parser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(ECMAScript6Parser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(ECMAScript6Parser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#withStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStatement(ECMAScript6Parser.WithStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(ECMAScript6Parser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBlock(ECMAScript6Parser.CaseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#caseClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseClauses(ECMAScript6Parser.CaseClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#caseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseClause(ECMAScript6Parser.CaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#defaultClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultClause(ECMAScript6Parser.DefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#labelledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelledStatement(ECMAScript6Parser.LabelledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#labelledItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelledItem(ECMAScript6Parser.LabelledItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(ECMAScript6Parser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(ECMAScript6Parser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#catchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchBlock(ECMAScript6Parser.CatchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(ECMAScript6Parser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#catchParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchParameter(ECMAScript6Parser.CatchParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#debuggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDebuggerStatement(ECMAScript6Parser.DebuggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(ECMAScript6Parser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#strictFormalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrictFormalParameters(ECMAScript6Parser.StrictFormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(ECMAScript6Parser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(ECMAScript6Parser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#functionRestParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionRestParameter(ECMAScript6Parser.FunctionRestParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(ECMAScript6Parser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(ECMAScript6Parser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#arrowFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFunction(ECMAScript6Parser.ArrowFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#arrowParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowParameters(ECMAScript6Parser.ArrowParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#conciseBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConciseBody(ECMAScript6Parser.ConciseBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#methodDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDefinition(ECMAScript6Parser.MethodDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#getterPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetterPrefix(ECMAScript6Parser.GetterPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#setterPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetterPrefix(ECMAScript6Parser.SetterPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#propertySetParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertySetParameterList(ECMAScript6Parser.PropertySetParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#generatorMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratorMethod(ECMAScript6Parser.GeneratorMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#generatorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratorDeclaration(ECMAScript6Parser.GeneratorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#yieldExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldExpression(ECMAScript6Parser.YieldExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(ECMAScript6Parser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(ECMAScript6Parser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#classElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassElement(ECMAScript6Parser.ClassElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ECMAScript6Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#sourceElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceElements(ECMAScript6Parser.SourceElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#sourceElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceElement(ECMAScript6Parser.SourceElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(ECMAScript6Parser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#importClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportClause(ECMAScript6Parser.ImportClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#importedDefaultBinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportedDefaultBinding(ECMAScript6Parser.ImportedDefaultBindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#nameSpaceImport}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameSpaceImport(ECMAScript6Parser.NameSpaceImportContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#namedImports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedImports(ECMAScript6Parser.NamedImportsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(ECMAScript6Parser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#importsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportsList(ECMAScript6Parser.ImportsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#importSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportSpecifier(ECMAScript6Parser.ImportSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#moduleSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleSpecifier(ECMAScript6Parser.ModuleSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#importedBinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportedBinding(ECMAScript6Parser.ImportedBindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#exportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportDeclaration(ECMAScript6Parser.ExportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#exportClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportClause(ECMAScript6Parser.ExportClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#exportsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportsList(ECMAScript6Parser.ExportsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#exportSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportSpecifier(ECMAScript6Parser.ExportSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#reservedKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReservedKeyword(ECMAScript6Parser.ReservedKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link ECMAScript6Parser#eos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEos(ECMAScript6Parser.EosContext ctx);
}
