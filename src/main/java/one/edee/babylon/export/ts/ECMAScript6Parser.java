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



import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ECMAScript6Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITESPACE=1, EOL=2, COMMENT_LINE=3, COMMENT_DOC=4, COMMENT_BLOCK=5, COMMENT_SHEBANG=6,
		KEYWORD_BREAK=7, KEYWORD_DO=8, KEYWORD_IN=9, KEYWORD_TYPEOF=10, KEYWORD_CASE=11,
		KEYWORD_ELSE=12, KEYWORD_INSTANCEOF=13, KEYWORD_VAR=14, KEYWORD_CATCH=15,
		KEYWORD_EXPORT=16, KEYWORD_NEW=17, KEYWORD_VOID=18, KEYWORD_CLASS=19,
		KEYWORD_EXTENDS=20, KEYWORD_RETURN=21, KEYWORD_WHILE=22, KEYWORD_CONST=23,
		KEYWORD_FINALLY=24, KEYWORD_SUPER=25, KEYWORD_WITH=26, KEYWORD_CONTINUE=27,
		KEYWORD_FOR=28, KEYWORD_OF=29, KEYWORD_SWITCH=30, KEYWORD_YIELD=31, KEYWORD_DEBUGGER=32,
		KEYWORD_FUNCTION=33, KEYWORD_THIS=34, KEYWORD_DEFAULT=35, KEYWORD_IF=36,
		KEYWORD_THROW=37, KEYWORD_DELETE=38, KEYWORD_IMPORT=39, KEYWORD_TRY=40,
		RESERVED_ENUM=41, RESERVED_AWAIT=42, RESERVED_IMPLEMENTS=43, RESERVED_PACKAGE=44,
		RESERVED_PROTECTED=45, RESERVED_INTERFACE=46, RESERVED_PRIVATE=47, RESERVED_PUBLIC=48,
		RESERVED_STATIC=49, RESERVED_LET=50, RESERVED_AS=51, RESERVED_FROM=52,
		BRACKET_LEFT_PAREN=53, BRACKET_RIGHT_PAREN=54, BRACKET_LEFT_CURLY=55,
		BRACKET_RIGHT_CURLY=56, BRACKET_LEFT_BRACKET=57, BRACKET_RIGHT_BRACKET=58,
		PUNCTUATOR_DOT=59, PUNCTUATOR_ELLIPSIS=60, PUNCTUATOR_SEMICOLON=61, PUNCTUATOR_COMMA=62,
		PUNCTUATOR_LOWER=63, PUNCTUATOR_GREATER=64, PUNCTUATOR_LOWER_EQUALS=65,
		PUNCTUATOR_GREATER_EQUALS=66, PUNCTUATOR_EQUALS=67, PUNCTUATOR_NOT_EQUALS=68,
		PUNCTUATOR_EQUALS_EXACTLY=69, PUNCTUATOR_NOT_EQUALS_EXACTLY=70, PUNCTUATOR_PLUS=71,
		PUNCTUATOR_MINUS=72, PUNCTUATOR_MULTIPLICATION=73, PUNCTUATOR_DIVISION=74,
		PUNCTUATOR_DIVISION_ASSIGNMENT=75, PUNCTUATOR_MODULUS=76, PUNCTUATOR_INCREMENT=77,
		PUNCTUATOR_DECREMENT=78, PUNCTUATOR_LEFT_SHIFT_ARITHMETIC=79, PUNCTUATOR_RIGHT_SHIFT_ARITHMETIC=80,
		PUNCTUATOR_RIGHT_SHIFT=81, PUNCTUATOR_BITWISE_AND=82, PUNCTUATOR_BITWISE_OR=83,
		PUNCTUATOR_BITWISE_XOR=84, PUNCTUATOR_NOT=85, PUNCTUATOR_BITWISE_NOT=86,
		PUNCTUATOR_AND=87, PUNCTUATOR_OR=88, PUNCTUATOR_TERNARY=89, PUNCTUATOR_COLON=90,
		PUNCTUATOR_ASSIGNMENT=91, PUNCTUATOR_PLUS_ASSIGNMENT=92, PUNCTUATOR_MINUS_ASSIGNMENT=93,
		PUNCTUATOR_MULTIPLICATION_ASSIGNMENT=94, PUNCTUATOR_MODULUS_ASSIGNMENT=95,
		PUNCTUATOR_LEFT_SHIFT_ARITHMETIC_ASSIGNMENT=96, PUNCTUATOR_RIGHT_SHIFT_ARITHMETIC_ASSIGNMENT=97,
		PUNCTUATOR_RIGHT_SHIFT_ASSIGNMENT=98, PUNCTUATOR_BITWISE_AND_ASSIGNMENT=99,
		PUNCTUATOR_BITWISE_OR_ASSIGNMENT=100, PUNCTUATOR_BITWISE_XOR_ASSIGNMENT=101,
		PUNCTUATOR_ARROW=102, LITERAL_NULL=103, LITERAL_TRUE=104, LITERAL_FALSE=105,
		NUMERIC_DECIMAL=106, NUMERIC_INTEGER=107, NUMERIC_BINARY=108, NUMERIC_OCTAL=109,
		NUMERIC_HEX=110, STRING=111, REGULAR_EXPRESSION=112, TEMPLATE_HEAD=113,
		TEMPLATE_NOSUBSTITUTION=114, TEMPLATE_MIDDLE=115, TEMPLATE_TAIL=116, IDENTIFIER=117,
		ERROR=118;
	public static final int
		RULE_booleanLiteral = 0, RULE_numericLiteral = 1, RULE_regularExpressionLiteral = 2,
		RULE_bindingIdentifier = 3, RULE_labelIdentifier = 4, RULE_primaryExpression = 5,
		RULE_coverParenthesizedExpressionAndArrowParameterList = 6, RULE_literal = 7,
		RULE_arrayLiteral = 8, RULE_elementList = 9, RULE_elementElision = 10,
		RULE_elision = 11, RULE_spreadElement = 12, RULE_objectLiteral = 13, RULE_propertyDefinitionList = 14,
		RULE_propertyDefinition = 15, RULE_propertyName = 16, RULE_literalPropertyName = 17,
		RULE_computedPropertyName = 18, RULE_coverInitializedName = 19, RULE_initializer = 20,
		RULE_templateLiteral = 21, RULE_templateSpans = 22, RULE_templateMiddleList = 23,
		RULE_memberExpression = 24, RULE_superProperty = 25, RULE_newTarget = 26,
		RULE_callExpressionLRR = 27, RULE_arguments = 28, RULE_argumentList = 29,
		RULE_newExpressionRest = 30, RULE_leftHandSideExpression = 31, RULE_postfixExpression = 32,
		RULE_unaryExpression = 33, RULE_binaryExpression = 34, RULE_conditionalExpression = 35,
		RULE_assignmentExpression = 36, RULE_assignmentPattern = 37, RULE_objectAssignmentPattern = 38,
		RULE_arrayAssignmentPattern = 39, RULE_assignmentPropertyList = 40, RULE_assignmentElementList = 41,
		RULE_assignmentElisionElement = 42, RULE_assignmentProperty = 43, RULE_assignmentElement = 44,
		RULE_assignmentRestElement = 45, RULE_expressionSequence = 46, RULE_statement = 47,
		RULE_declaration = 48, RULE_hoistableDeclaration = 49, RULE_block = 50,
		RULE_statementList = 51, RULE_lexicalDeclaration = 52, RULE_letOrConst = 53,
		RULE_bindingList = 54, RULE_lexicalBinding = 55, RULE_variableStatement = 56,
		RULE_variableDeclarationList = 57, RULE_variableDeclaration = 58, RULE_bindingPattern = 59,
		RULE_objectBindingPattern = 60, RULE_arrayBindingPattern = 61, RULE_bindingPropertyList = 62,
		RULE_bindingElementList = 63, RULE_bindingElisionElement = 64, RULE_bindingProperty = 65,
		RULE_bindingElement = 66, RULE_singleNameBinding = 67, RULE_bindingRestElement = 68,
		RULE_emptyStatement = 69, RULE_expressionStatement = 70, RULE_ifStatement = 71,
		RULE_iterationStatement = 72, RULE_forDeclaration = 73, RULE_forBinding = 74,
		RULE_continueStatement = 75, RULE_breakStatement = 76, RULE_returnStatement = 77,
		RULE_withStatement = 78, RULE_switchStatement = 79, RULE_caseBlock = 80,
		RULE_caseClauses = 81, RULE_caseClause = 82, RULE_defaultClause = 83,
		RULE_labelledStatement = 84, RULE_labelledItem = 85, RULE_throwStatement = 86,
		RULE_tryStatement = 87, RULE_catchBlock = 88, RULE_finallyBlock = 89,
		RULE_catchParameter = 90, RULE_debuggerStatement = 91, RULE_functionDeclaration = 92,
		RULE_strictFormalParameters = 93, RULE_formalParameters = 94, RULE_formalParameterList = 95,
		RULE_functionRestParameter = 96, RULE_formalParameter = 97, RULE_functionBody = 98,
		RULE_arrowFunction = 99, RULE_arrowParameters = 100, RULE_conciseBody = 101,
		RULE_methodDefinition = 102, RULE_getterPrefix = 103, RULE_setterPrefix = 104,
		RULE_propertySetParameterList = 105, RULE_generatorMethod = 106, RULE_generatorDeclaration = 107,
		RULE_yieldExpression = 108, RULE_classDeclaration = 109, RULE_classBody = 110,
		RULE_classElement = 111, RULE_program = 112, RULE_sourceElements = 113,
		RULE_sourceElement = 114, RULE_importDeclaration = 115, RULE_importClause = 116,
		RULE_importedDefaultBinding = 117, RULE_nameSpaceImport = 118, RULE_namedImports = 119,
		RULE_fromClause = 120, RULE_importsList = 121, RULE_importSpecifier = 122,
		RULE_moduleSpecifier = 123, RULE_importedBinding = 124, RULE_exportDeclaration = 125,
		RULE_exportClause = 126, RULE_exportsList = 127, RULE_exportSpecifier = 128,
		RULE_reservedKeyword = 129, RULE_eos = 130;
	private static String[] makeRuleNames() {
		return new String[] {
			"booleanLiteral", "numericLiteral", "regularExpressionLiteral", "bindingIdentifier",
			"labelIdentifier", "primaryExpression", "coverParenthesizedExpressionAndArrowParameterList",
			"literal", "arrayLiteral", "elementList", "elementElision", "elision",
			"spreadElement", "objectLiteral", "propertyDefinitionList", "propertyDefinition",
			"propertyName", "literalPropertyName", "computedPropertyName", "coverInitializedName",
			"initializer", "templateLiteral", "templateSpans", "templateMiddleList",
			"memberExpression", "superProperty", "newTarget", "callExpressionLRR",
			"arguments", "argumentList", "newExpressionRest", "leftHandSideExpression",
			"postfixExpression", "unaryExpression", "binaryExpression", "conditionalExpression",
			"assignmentExpression", "assignmentPattern", "objectAssignmentPattern",
			"arrayAssignmentPattern", "assignmentPropertyList", "assignmentElementList",
			"assignmentElisionElement", "assignmentProperty", "assignmentElement",
			"assignmentRestElement", "expressionSequence", "statement", "declaration",
			"hoistableDeclaration", "block", "statementList", "lexicalDeclaration",
			"letOrConst", "bindingList", "lexicalBinding", "variableStatement", "variableDeclarationList",
			"variableDeclaration", "bindingPattern", "objectBindingPattern", "arrayBindingPattern",
			"bindingPropertyList", "bindingElementList", "bindingElisionElement",
			"bindingProperty", "bindingElement", "singleNameBinding", "bindingRestElement",
			"emptyStatement", "expressionStatement", "ifStatement", "iterationStatement",
			"forDeclaration", "forBinding", "continueStatement", "breakStatement",
			"returnStatement", "withStatement", "switchStatement", "caseBlock", "caseClauses",
			"caseClause", "defaultClause", "labelledStatement", "labelledItem", "throwStatement",
			"tryStatement", "catchBlock", "finallyBlock", "catchParameter", "debuggerStatement",
			"functionDeclaration", "strictFormalParameters", "formalParameters",
			"formalParameterList", "functionRestParameter", "formalParameter", "functionBody",
			"arrowFunction", "arrowParameters", "conciseBody", "methodDefinition",
			"getterPrefix", "setterPrefix", "propertySetParameterList", "generatorMethod",
			"generatorDeclaration", "yieldExpression", "classDeclaration", "classBody",
			"classElement", "program", "sourceElements", "sourceElement", "importDeclaration",
			"importClause", "importedDefaultBinding", "nameSpaceImport", "namedImports",
			"fromClause", "importsList", "importSpecifier", "moduleSpecifier", "importedBinding",
			"exportDeclaration", "exportClause", "exportsList", "exportSpecifier",
			"reservedKeyword", "eos"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "'break'", "'do'", "'in'",
			"'typeof'", "'case'", "'else'", "'instanceof'", "'var'", "'catch'", "'export'",
			"'new'", "'void'", "'class'", "'extends'", "'return'", "'while'", "'const'",
			"'finally'", "'super'", "'with'", "'continue'", "'for'", "'of'", "'switch'",
			"'yield'", "'debugger'", "'function'", "'this'", "'default'", "'if'",
			"'throw'", "'delete'", "'import'", "'try'", "'enum'", "'await'", "'implements'",
			"'package'", "'protected'", "'interface'", "'private'", "'public'", "'static'",
			"'let'", "'as'", "'from'", "'('", "')'", "'{'", "'}'", "'['", "']'",
			"'.'", "'...'", "';'", "','", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='",
			"'==='", "'!=='", "'+'", "'-'", "'*'", "'/'", "'/='", "'%'", "'++'",
			"'--'", "'<<'", "'>>'", "'>>>'", "'&'", "'|'", "'^'", "'!'", "'~'", "'&&'",
			"'||'", "'?'", "':'", "'='", "'+='", "'-='", "'*='", "'%='", "'<<='",
			"'>>='", "'>>>='", "'&='", "'|='", "'^='", "'=>'", "'null'", "'true'",
			"'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHITESPACE", "EOL", "COMMENT_LINE", "COMMENT_DOC", "COMMENT_BLOCK",
			"COMMENT_SHEBANG", "KEYWORD_BREAK", "KEYWORD_DO", "KEYWORD_IN", "KEYWORD_TYPEOF",
			"KEYWORD_CASE", "KEYWORD_ELSE", "KEYWORD_INSTANCEOF", "KEYWORD_VAR",
			"KEYWORD_CATCH", "KEYWORD_EXPORT", "KEYWORD_NEW", "KEYWORD_VOID", "KEYWORD_CLASS",
			"KEYWORD_EXTENDS", "KEYWORD_RETURN", "KEYWORD_WHILE", "KEYWORD_CONST",
			"KEYWORD_FINALLY", "KEYWORD_SUPER", "KEYWORD_WITH", "KEYWORD_CONTINUE",
			"KEYWORD_FOR", "KEYWORD_OF", "KEYWORD_SWITCH", "KEYWORD_YIELD", "KEYWORD_DEBUGGER",
			"KEYWORD_FUNCTION", "KEYWORD_THIS", "KEYWORD_DEFAULT", "KEYWORD_IF",
			"KEYWORD_THROW", "KEYWORD_DELETE", "KEYWORD_IMPORT", "KEYWORD_TRY", "RESERVED_ENUM",
			"RESERVED_AWAIT", "RESERVED_IMPLEMENTS", "RESERVED_PACKAGE", "RESERVED_PROTECTED",
			"RESERVED_INTERFACE", "RESERVED_PRIVATE", "RESERVED_PUBLIC", "RESERVED_STATIC",
			"RESERVED_LET", "RESERVED_AS", "RESERVED_FROM", "BRACKET_LEFT_PAREN",
			"BRACKET_RIGHT_PAREN", "BRACKET_LEFT_CURLY", "BRACKET_RIGHT_CURLY", "BRACKET_LEFT_BRACKET",
			"BRACKET_RIGHT_BRACKET", "PUNCTUATOR_DOT", "PUNCTUATOR_ELLIPSIS", "PUNCTUATOR_SEMICOLON",
			"PUNCTUATOR_COMMA", "PUNCTUATOR_LOWER", "PUNCTUATOR_GREATER", "PUNCTUATOR_LOWER_EQUALS",
			"PUNCTUATOR_GREATER_EQUALS", "PUNCTUATOR_EQUALS", "PUNCTUATOR_NOT_EQUALS",
			"PUNCTUATOR_EQUALS_EXACTLY", "PUNCTUATOR_NOT_EQUALS_EXACTLY", "PUNCTUATOR_PLUS",
			"PUNCTUATOR_MINUS", "PUNCTUATOR_MULTIPLICATION", "PUNCTUATOR_DIVISION",
			"PUNCTUATOR_DIVISION_ASSIGNMENT", "PUNCTUATOR_MODULUS", "PUNCTUATOR_INCREMENT",
			"PUNCTUATOR_DECREMENT", "PUNCTUATOR_LEFT_SHIFT_ARITHMETIC", "PUNCTUATOR_RIGHT_SHIFT_ARITHMETIC",
			"PUNCTUATOR_RIGHT_SHIFT", "PUNCTUATOR_BITWISE_AND", "PUNCTUATOR_BITWISE_OR",
			"PUNCTUATOR_BITWISE_XOR", "PUNCTUATOR_NOT", "PUNCTUATOR_BITWISE_NOT",
			"PUNCTUATOR_AND", "PUNCTUATOR_OR", "PUNCTUATOR_TERNARY", "PUNCTUATOR_COLON",
			"PUNCTUATOR_ASSIGNMENT", "PUNCTUATOR_PLUS_ASSIGNMENT", "PUNCTUATOR_MINUS_ASSIGNMENT",
			"PUNCTUATOR_MULTIPLICATION_ASSIGNMENT", "PUNCTUATOR_MODULUS_ASSIGNMENT",
			"PUNCTUATOR_LEFT_SHIFT_ARITHMETIC_ASSIGNMENT", "PUNCTUATOR_RIGHT_SHIFT_ARITHMETIC_ASSIGNMENT",
			"PUNCTUATOR_RIGHT_SHIFT_ASSIGNMENT", "PUNCTUATOR_BITWISE_AND_ASSIGNMENT",
			"PUNCTUATOR_BITWISE_OR_ASSIGNMENT", "PUNCTUATOR_BITWISE_XOR_ASSIGNMENT",
			"PUNCTUATOR_ARROW", "LITERAL_NULL", "LITERAL_TRUE", "LITERAL_FALSE",
			"NUMERIC_DECIMAL", "NUMERIC_INTEGER", "NUMERIC_BINARY", "NUMERIC_OCTAL",
			"NUMERIC_HEX", "STRING", "REGULAR_EXPRESSION", "TEMPLATE_HEAD", "TEMPLATE_NOSUBSTITUTION",
			"TEMPLATE_MIDDLE", "TEMPLATE_TAIL", "IDENTIFIER", "ERROR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ECMAScript6.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private static String TARGET_IDENT = "target";

	    private boolean lineTerminatorAhead() {

	        // Get the token ahead of the current index.
	        int possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 1;
	        if (possibleIndexEosToken > -1) {
	            Token ahead = _input.get(possibleIndexEosToken);

	            if (ahead.getChannel() == Lexer.HIDDEN) {
	                return true;
	            }
	        }
	        return false;
	    }

	public ECMAScript6Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode LITERAL_TRUE() { return getToken(ECMAScript6Parser.LITERAL_TRUE, 0); }
		public TerminalNode LITERAL_FALSE() { return getToken(ECMAScript6Parser.LITERAL_FALSE, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_la = _input.LA(1);
			if ( !(_la==LITERAL_TRUE || _la==LITERAL_FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumericLiteralContext extends ParserRuleContext {
		public TerminalNode NUMERIC_DECIMAL() { return getToken(ECMAScript6Parser.NUMERIC_DECIMAL, 0); }
		public TerminalNode NUMERIC_INTEGER() { return getToken(ECMAScript6Parser.NUMERIC_INTEGER, 0); }
		public TerminalNode NUMERIC_BINARY() { return getToken(ECMAScript6Parser.NUMERIC_BINARY, 0); }
		public TerminalNode NUMERIC_OCTAL() { return getToken(ECMAScript6Parser.NUMERIC_OCTAL, 0); }
		public TerminalNode NUMERIC_HEX() { return getToken(ECMAScript6Parser.NUMERIC_HEX, 0); }
		public NumericLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitNumericLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitNumericLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericLiteralContext numericLiteral() throws RecognitionException {
		NumericLiteralContext _localctx = new NumericLiteralContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_numericLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_la = _input.LA(1);
			if ( !(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & 31L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RegularExpressionLiteralContext extends ParserRuleContext {
		public TerminalNode REGULAR_EXPRESSION() { return getToken(ECMAScript6Parser.REGULAR_EXPRESSION, 0); }
		public RegularExpressionLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regularExpressionLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterRegularExpressionLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitRegularExpressionLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitRegularExpressionLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegularExpressionLiteralContext regularExpressionLiteral() throws RecognitionException {
		RegularExpressionLiteralContext _localctx = new RegularExpressionLiteralContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_regularExpressionLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(REGULAR_EXPRESSION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BindingIdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public BindingIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterBindingIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitBindingIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitBindingIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingIdentifierContext bindingIdentifier() throws RecognitionException {
		BindingIdentifierContext _localctx = new BindingIdentifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bindingIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabelIdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public LabelIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterLabelIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitLabelIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitLabelIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelIdentifierContext labelIdentifier() throws RecognitionException {
		LabelIdentifierContext _localctx = new LabelIdentifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_labelIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode KEYWORD_THIS() { return getToken(ECMAScript6Parser.KEYWORD_THIS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public ObjectLiteralContext objectLiteral() {
			return getRuleContext(ObjectLiteralContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public GeneratorDeclarationContext generatorDeclaration() {
			return getRuleContext(GeneratorDeclarationContext.class,0);
		}
		public RegularExpressionLiteralContext regularExpressionLiteral() {
			return getRuleContext(RegularExpressionLiteralContext.class,0);
		}
		public TemplateLiteralContext templateLiteral() {
			return getRuleContext(TemplateLiteralContext.class,0);
		}
		public CoverParenthesizedExpressionAndArrowParameterListContext coverParenthesizedExpressionAndArrowParameterList() {
			return getRuleContext(CoverParenthesizedExpressionAndArrowParameterListContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitPrimaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_primaryExpression);
		try {
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				match(KEYWORD_THIS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(274);
				literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(275);
				arrayLiteral();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(276);
				objectLiteral();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(277);
				functionDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(278);
				classDeclaration();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(279);
				generatorDeclaration();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(280);
				regularExpressionLiteral();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(281);
				templateLiteral();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(282);
				coverParenthesizedExpressionAndArrowParameterList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CoverParenthesizedExpressionAndArrowParameterListContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode PUNCTUATOR_ELLIPSIS() { return getToken(ECMAScript6Parser.PUNCTUATOR_ELLIPSIS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public TerminalNode PUNCTUATOR_COMMA() { return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, 0); }
		public CoverParenthesizedExpressionAndArrowParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coverParenthesizedExpressionAndArrowParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterCoverParenthesizedExpressionAndArrowParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitCoverParenthesizedExpressionAndArrowParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitCoverParenthesizedExpressionAndArrowParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoverParenthesizedExpressionAndArrowParameterListContext coverParenthesizedExpressionAndArrowParameterList() throws RecognitionException {
		CoverParenthesizedExpressionAndArrowParameterListContext _localctx = new CoverParenthesizedExpressionAndArrowParameterListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_coverParenthesizedExpressionAndArrowParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(BRACKET_LEFT_PAREN);
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(286);
				expressionSequence();
				}
				break;
			case 2:
				{
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 189151487179228160L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 87956635304131L) != 0)) {
					{
					setState(287);
					expressionSequence();
					setState(288);
					match(PUNCTUATOR_COMMA);
					}
				}

				setState(292);
				match(PUNCTUATOR_ELLIPSIS);
				setState(293);
				match(IDENTIFIER);
				}
				break;
			}
			setState(296);
			match(BRACKET_RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode LITERAL_NULL() { return getToken(ECMAScript6Parser.LITERAL_NULL, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public NumericLiteralContext numericLiteral() {
			return getRuleContext(NumericLiteralContext.class,0);
		}
		public TerminalNode STRING() { return getToken(ECMAScript6Parser.STRING, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_literal);
		try {
			setState(302);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LITERAL_NULL:
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				match(LITERAL_NULL);
				}
				break;
			case LITERAL_TRUE:
			case LITERAL_FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				booleanLiteral();
				}
				break;
			case NUMERIC_DECIMAL:
			case NUMERIC_INTEGER:
			case NUMERIC_BINARY:
			case NUMERIC_OCTAL:
			case NUMERIC_HEX:
				enterOuterAlt(_localctx, 3);
				{
				setState(300);
				numericLiteral();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(301);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_LEFT_BRACKET, 0); }
		public ElementListContext elementList() {
			return getRuleContext(ElementListContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_BRACKET, 0); }
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrayLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(BRACKET_LEFT_BRACKET);
			setState(305);
			elementList();
			setState(306);
			match(BRACKET_RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementListContext extends ParserRuleContext {
		public List<AssignmentExpressionContext> assignmentExpression() {
			return getRuleContexts(AssignmentExpressionContext.class);
		}
		public AssignmentExpressionContext assignmentExpression(int i) {
			return getRuleContext(AssignmentExpressionContext.class,i);
		}
		public List<SpreadElementContext> spreadElement() {
			return getRuleContexts(SpreadElementContext.class);
		}
		public SpreadElementContext spreadElement(int i) {
			return getRuleContext(SpreadElementContext.class,i);
		}
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public List<ElementElisionContext> elementElision() {
			return getRuleContexts(ElementElisionContext.class);
		}
		public ElementElisionContext elementElision(int i) {
			return getRuleContext(ElementElisionContext.class,i);
		}
		public ElementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterElementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitElementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitElementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementListContext elementList() throws RecognitionException {
		ElementListContext _localctx = new ElementListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(311);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(308);
					if (!(_input.LA(1) != BRACKET_RIGHT_BRACKET)) throw new FailedPredicateException(this, "_input.LA(1) != BRACKET_RIGHT_BRACKET");
					setState(309);
					elementElision();
					}
					break;
				case 2:
					{
					setState(310);
					if (!(_input.LA(1) == BRACKET_RIGHT_BRACKET)) throw new FailedPredicateException(this, "_input.LA(1) == BRACKET_RIGHT_BRACKET");
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(313);
				assignmentExpression();
				}
				break;
			case 3:
				{
				setState(314);
				spreadElement();
				}
				break;
			}
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUNCTUATOR_COMMA) {
				{
				{
				setState(317);
				match(PUNCTUATOR_COMMA);
				setState(325);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(321);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						setState(318);
						if (!(_input.LA(1) != BRACKET_RIGHT_BRACKET)) throw new FailedPredicateException(this, "_input.LA(1) != BRACKET_RIGHT_BRACKET");
						setState(319);
						elementElision();
						}
						break;
					case 2:
						{
						setState(320);
						if (!(_input.LA(1) == BRACKET_RIGHT_BRACKET)) throw new FailedPredicateException(this, "_input.LA(1) == BRACKET_RIGHT_BRACKET");
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(323);
					assignmentExpression();
					}
					break;
				case 3:
					{
					setState(324);
					spreadElement();
					}
					break;
				}
				}
				}
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementElisionContext extends ParserRuleContext {
		public ElementElisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementElision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterElementElision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitElementElision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitElementElision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementElisionContext elementElision() throws RecognitionException {
		ElementElisionContext _localctx = new ElementElisionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_elementElision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElisionContext extends ParserRuleContext {
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public ElisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterElision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitElision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitElision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElisionContext elision() throws RecognitionException {
		ElisionContext _localctx = new ElisionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_elision);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(334);
				match(PUNCTUATOR_COMMA);
				}
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PUNCTUATOR_COMMA );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpreadElementContext extends ParserRuleContext {
		public TerminalNode PUNCTUATOR_ELLIPSIS() { return getToken(ECMAScript6Parser.PUNCTUATOR_ELLIPSIS, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public SpreadElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spreadElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterSpreadElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitSpreadElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitSpreadElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpreadElementContext spreadElement() throws RecognitionException {
		SpreadElementContext _localctx = new SpreadElementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_spreadElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(PUNCTUATOR_ELLIPSIS);
			setState(340);
			assignmentExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectLiteralContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_LEFT_CURLY, 0); }
		public TerminalNode BRACKET_RIGHT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_CURLY, 0); }
		public PropertyDefinitionListContext propertyDefinitionList() {
			return getRuleContext(PropertyDefinitionListContext.class,0);
		}
		public TerminalNode PUNCTUATOR_COMMA() { return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, 0); }
		public ObjectLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterObjectLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitObjectLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitObjectLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectLiteralContext objectLiteral() throws RecognitionException {
		ObjectLiteralContext _localctx = new ObjectLiteralContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_objectLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(BRACKET_LEFT_CURLY);
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(343);
				propertyDefinitionList();
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_COMMA) {
					{
					setState(344);
					match(PUNCTUATOR_COMMA);
					}
				}

				}
				break;
			}
			setState(349);
			match(BRACKET_RIGHT_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyDefinitionListContext extends ParserRuleContext {
		public List<PropertyDefinitionContext> propertyDefinition() {
			return getRuleContexts(PropertyDefinitionContext.class);
		}
		public PropertyDefinitionContext propertyDefinition(int i) {
			return getRuleContext(PropertyDefinitionContext.class,i);
		}
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public PropertyDefinitionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDefinitionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterPropertyDefinitionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitPropertyDefinitionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitPropertyDefinitionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyDefinitionListContext propertyDefinitionList() throws RecognitionException {
		PropertyDefinitionListContext _localctx = new PropertyDefinitionListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_propertyDefinitionList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			propertyDefinition();
			setState(356);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(352);
					match(PUNCTUATOR_COMMA);
					setState(353);
					propertyDefinition();
					}
					}
				}
				setState(358);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyDefinitionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public CoverInitializedNameContext coverInitializedName() {
			return getRuleContext(CoverInitializedNameContext.class,0);
		}
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public TerminalNode PUNCTUATOR_COLON() { return getToken(ECMAScript6Parser.PUNCTUATOR_COLON, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public MethodDefinitionContext methodDefinition() {
			return getRuleContext(MethodDefinitionContext.class,0);
		}
		public PropertyDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterPropertyDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitPropertyDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitPropertyDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyDefinitionContext propertyDefinition() throws RecognitionException {
		PropertyDefinitionContext _localctx = new PropertyDefinitionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_propertyDefinition);
		try {
			setState(366);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(359);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(360);
				coverInitializedName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(361);
				propertyName();
				setState(362);
				match(PUNCTUATOR_COLON);
				setState(363);
				assignmentExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(365);
				methodDefinition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyNameContext extends ParserRuleContext {
		public LiteralPropertyNameContext literalPropertyName() {
			return getRuleContext(LiteralPropertyNameContext.class,0);
		}
		public ComputedPropertyNameContext computedPropertyName() {
			return getRuleContext(ComputedPropertyNameContext.class,0);
		}
		public PropertyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterPropertyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitPropertyName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitPropertyName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyNameContext propertyName() throws RecognitionException {
		PropertyNameContext _localctx = new PropertyNameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_propertyName);
		try {
			setState(370);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERIC_DECIMAL:
			case NUMERIC_INTEGER:
			case NUMERIC_BINARY:
			case NUMERIC_OCTAL:
			case NUMERIC_HEX:
			case STRING:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				literalPropertyName();
				}
				break;
			case BRACKET_LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(369);
				computedPropertyName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralPropertyNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public TerminalNode STRING() { return getToken(ECMAScript6Parser.STRING, 0); }
		public NumericLiteralContext numericLiteral() {
			return getRuleContext(NumericLiteralContext.class,0);
		}
		public LiteralPropertyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalPropertyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterLiteralPropertyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitLiteralPropertyName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitLiteralPropertyName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralPropertyNameContext literalPropertyName() throws RecognitionException {
		LiteralPropertyNameContext _localctx = new LiteralPropertyNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_literalPropertyName);
		try {
			setState(375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(372);
				match(IDENTIFIER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				match(STRING);
				}
				break;
			case NUMERIC_DECIMAL:
			case NUMERIC_INTEGER:
			case NUMERIC_BINARY:
			case NUMERIC_OCTAL:
			case NUMERIC_HEX:
				enterOuterAlt(_localctx, 3);
				{
				setState(374);
				numericLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComputedPropertyNameContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_LEFT_BRACKET, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_BRACKET, 0); }
		public ComputedPropertyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_computedPropertyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterComputedPropertyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitComputedPropertyName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitComputedPropertyName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComputedPropertyNameContext computedPropertyName() throws RecognitionException {
		ComputedPropertyNameContext _localctx = new ComputedPropertyNameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_computedPropertyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			match(BRACKET_LEFT_BRACKET);
			setState(378);
			assignmentExpression();
			setState(379);
			match(BRACKET_RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CoverInitializedNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public CoverInitializedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coverInitializedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterCoverInitializedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitCoverInitializedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitCoverInitializedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoverInitializedNameContext coverInitializedName() throws RecognitionException {
		CoverInitializedNameContext _localctx = new CoverInitializedNameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_coverInitializedName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(IDENTIFIER);
			setState(382);
			initializer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerContext extends ParserRuleContext {
		public TerminalNode PUNCTUATOR_ASSIGNMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_ASSIGNMENT, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(PUNCTUATOR_ASSIGNMENT);
			setState(385);
			assignmentExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateLiteralContext extends ParserRuleContext {
		public TerminalNode TEMPLATE_NOSUBSTITUTION() { return getToken(ECMAScript6Parser.TEMPLATE_NOSUBSTITUTION, 0); }
		public TerminalNode TEMPLATE_HEAD() { return getToken(ECMAScript6Parser.TEMPLATE_HEAD, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TemplateSpansContext templateSpans() {
			return getRuleContext(TemplateSpansContext.class,0);
		}
		public TemplateLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterTemplateLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitTemplateLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitTemplateLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateLiteralContext templateLiteral() throws RecognitionException {
		TemplateLiteralContext _localctx = new TemplateLiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_templateLiteral);
		try {
			setState(392);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEMPLATE_NOSUBSTITUTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				match(TEMPLATE_NOSUBSTITUTION);
				}
				break;
			case TEMPLATE_HEAD:
				enterOuterAlt(_localctx, 2);
				{
				setState(388);
				match(TEMPLATE_HEAD);
				setState(389);
				expressionSequence();
				setState(390);
				templateSpans();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateSpansContext extends ParserRuleContext {
		public TerminalNode TEMPLATE_TAIL() { return getToken(ECMAScript6Parser.TEMPLATE_TAIL, 0); }
		public TemplateMiddleListContext templateMiddleList() {
			return getRuleContext(TemplateMiddleListContext.class,0);
		}
		public TemplateSpansContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateSpans; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterTemplateSpans(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitTemplateSpans(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitTemplateSpans(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateSpansContext templateSpans() throws RecognitionException {
		TemplateSpansContext _localctx = new TemplateSpansContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_templateSpans);
		try {
			setState(398);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEMPLATE_TAIL:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				match(TEMPLATE_TAIL);
				}
				break;
			case TEMPLATE_MIDDLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				templateMiddleList(0);
				setState(396);
				match(TEMPLATE_TAIL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateMiddleListContext extends ParserRuleContext {
		public TerminalNode TEMPLATE_MIDDLE() { return getToken(ECMAScript6Parser.TEMPLATE_MIDDLE, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TemplateMiddleListContext templateMiddleList() {
			return getRuleContext(TemplateMiddleListContext.class,0);
		}
		public TemplateMiddleListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateMiddleList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterTemplateMiddleList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitTemplateMiddleList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitTemplateMiddleList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateMiddleListContext templateMiddleList() throws RecognitionException {
		return templateMiddleList(0);
	}

	private TemplateMiddleListContext templateMiddleList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TemplateMiddleListContext _localctx = new TemplateMiddleListContext(_ctx, _parentState);
		TemplateMiddleListContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_templateMiddleList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(401);
			match(TEMPLATE_MIDDLE);
			setState(402);
			expressionSequence();
			}
			_ctx.stop = _input.LT(-1);
			setState(409);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TemplateMiddleListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_templateMiddleList);
					setState(404);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(405);
					match(TEMPLATE_MIDDLE);
					setState(406);
					expressionSequence();
					}
					}
				}
				setState(411);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberExpressionContext extends ParserRuleContext {
		public SuperPropertyContext superProperty() {
			return getRuleContext(SuperPropertyContext.class,0);
		}
		public NewTargetContext newTarget() {
			return getRuleContext(NewTargetContext.class,0);
		}
		public TerminalNode KEYWORD_NEW() { return getToken(ECMAScript6Parser.KEYWORD_NEW, 0); }
		public MemberExpressionContext memberExpression() {
			return getRuleContext(MemberExpressionContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode BRACKET_LEFT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_LEFT_BRACKET, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_BRACKET, 0); }
		public TerminalNode PUNCTUATOR_DOT() { return getToken(ECMAScript6Parser.PUNCTUATOR_DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public TemplateLiteralContext templateLiteral() {
			return getRuleContext(TemplateLiteralContext.class,0);
		}
		public MemberExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterMemberExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitMemberExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitMemberExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberExpressionContext memberExpression() throws RecognitionException {
		return memberExpression(0);
	}

	private MemberExpressionContext memberExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MemberExpressionContext _localctx = new MemberExpressionContext(_ctx, _parentState);
		MemberExpressionContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_memberExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(413);
				superProperty();
				}
				break;
			case 2:
				{
				setState(414);
				newTarget();
				}
				break;
			case 3:
				{
				setState(415);
				match(KEYWORD_NEW);
				setState(416);
				memberExpression(0);
				setState(417);
				arguments();
				}
				break;
			case 4:
				{
				setState(419);
				primaryExpression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(434);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(432);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new MemberExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_memberExpression);
						setState(422);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(423);
						match(BRACKET_LEFT_BRACKET);
						setState(424);
						expressionSequence();
						setState(425);
						match(BRACKET_RIGHT_BRACKET);
						}
						break;
					case 2:
						{
						_localctx = new MemberExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_memberExpression);
						setState(427);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(428);
						match(PUNCTUATOR_DOT);
						setState(429);
						match(IDENTIFIER);
						}
						break;
					case 3:
						{
						_localctx = new MemberExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_memberExpression);
						setState(430);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(431);
						templateLiteral();
						}
						break;
					}
					}
				}
				setState(436);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SuperPropertyContext extends ParserRuleContext {
		public TerminalNode KEYWORD_SUPER() { return getToken(ECMAScript6Parser.KEYWORD_SUPER, 0); }
		public TerminalNode BRACKET_LEFT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_LEFT_BRACKET, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_BRACKET, 0); }
		public TerminalNode PUNCTUATOR_DOT() { return getToken(ECMAScript6Parser.PUNCTUATOR_DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public SuperPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterSuperProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitSuperProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitSuperProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuperPropertyContext superProperty() throws RecognitionException {
		SuperPropertyContext _localctx = new SuperPropertyContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_superProperty);
		try {
			setState(445);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				match(KEYWORD_SUPER);
				setState(438);
				match(BRACKET_LEFT_BRACKET);
				setState(439);
				expressionSequence();
				setState(440);
				match(BRACKET_RIGHT_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(442);
				match(KEYWORD_SUPER);
				setState(443);
				match(PUNCTUATOR_DOT);
				setState(444);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NewTargetContext extends ParserRuleContext {
		public Token ident;
		public TerminalNode KEYWORD_NEW() { return getToken(ECMAScript6Parser.KEYWORD_NEW, 0); }
		public TerminalNode PUNCTUATOR_DOT() { return getToken(ECMAScript6Parser.PUNCTUATOR_DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public NewTargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newTarget; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterNewTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitNewTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitNewTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewTargetContext newTarget() throws RecognitionException {
		NewTargetContext _localctx = new NewTargetContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_newTarget);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			match(KEYWORD_NEW);
			setState(448);
			match(PUNCTUATOR_DOT);
			setState(449);
			((NewTargetContext)_localctx).ident = match(IDENTIFIER);
			setState(450);
			if (!(TARGET_IDENT.equals((((NewTargetContext)_localctx).ident!=null?((NewTargetContext)_localctx).ident.getText():null)))) throw new FailedPredicateException(this, "TARGET_IDENT.equals($ident.text)");
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallExpressionLRRContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public CallExpressionLRRContext callExpressionLRR() {
			return getRuleContext(CallExpressionLRRContext.class,0);
		}
		public TerminalNode BRACKET_LEFT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_LEFT_BRACKET, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_BRACKET, 0); }
		public TerminalNode PUNCTUATOR_DOT() { return getToken(ECMAScript6Parser.PUNCTUATOR_DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public TemplateLiteralContext templateLiteral() {
			return getRuleContext(TemplateLiteralContext.class,0);
		}
		public CallExpressionLRRContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callExpressionLRR; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterCallExpressionLRR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitCallExpressionLRR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitCallExpressionLRR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallExpressionLRRContext callExpressionLRR() throws RecognitionException {
		CallExpressionLRRContext _localctx = new CallExpressionLRRContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_callExpressionLRR);
		try {
			setState(467);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(452);
				arguments();
				setState(453);
				callExpressionLRR();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(455);
				match(BRACKET_LEFT_BRACKET);
				setState(456);
				expressionSequence();
				setState(457);
				match(BRACKET_RIGHT_BRACKET);
				setState(458);
				callExpressionLRR();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(460);
				match(PUNCTUATOR_DOT);
				setState(461);
				match(IDENTIFIER);
				setState(462);
				callExpressionLRR();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(463);
				templateLiteral();
				setState(464);
				callExpressionLRR();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(BRACKET_LEFT_PAREN);
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1342072991786075136L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 87956635304131L) != 0)) {
				{
				setState(470);
				argumentList();
				}
			}

			setState(473);
			match(BRACKET_RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public List<AssignmentExpressionContext> assignmentExpression() {
			return getRuleContexts(AssignmentExpressionContext.class);
		}
		public AssignmentExpressionContext assignmentExpression(int i) {
			return getRuleContext(AssignmentExpressionContext.class,i);
		}
		public List<TerminalNode> PUNCTUATOR_ELLIPSIS() { return getTokens(ECMAScript6Parser.PUNCTUATOR_ELLIPSIS); }
		public TerminalNode PUNCTUATOR_ELLIPSIS(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_ELLIPSIS, i);
		}
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNCTUATOR_ELLIPSIS) {
				{
				setState(475);
				match(PUNCTUATOR_ELLIPSIS);
				}
			}

			setState(478);
			assignmentExpression();
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUNCTUATOR_COMMA) {
				{
				{
				setState(479);
				match(PUNCTUATOR_COMMA);
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_ELLIPSIS) {
					{
					setState(480);
					match(PUNCTUATOR_ELLIPSIS);
					}
				}

				setState(483);
				assignmentExpression();
				}
				}
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NewExpressionRestContext extends ParserRuleContext {
		public MemberExpressionContext memberExpression() {
			return getRuleContext(MemberExpressionContext.class,0);
		}
		public TerminalNode KEYWORD_NEW() { return getToken(ECMAScript6Parser.KEYWORD_NEW, 0); }
		public NewExpressionRestContext newExpressionRest() {
			return getRuleContext(NewExpressionRestContext.class,0);
		}
		public NewExpressionRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpressionRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterNewExpressionRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitNewExpressionRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitNewExpressionRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpressionRestContext newExpressionRest() throws RecognitionException {
		NewExpressionRestContext _localctx = new NewExpressionRestContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_newExpressionRest);
		try {
			setState(492);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(489);
				memberExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(490);
				match(KEYWORD_NEW);
				setState(491);
				newExpressionRest();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LeftHandSideExpressionContext extends ParserRuleContext {
		public LeftHandSideExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftHandSideExpression; }

		public LeftHandSideExpressionContext() { }
		public void copyFrom(LeftHandSideExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallExpressionContext extends LeftHandSideExpressionContext {
		public MemberExpressionContext memberExpression() {
			return getRuleContext(MemberExpressionContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public CallExpressionLRRContext callExpressionLRR() {
			return getRuleContext(CallExpressionLRRContext.class,0);
		}
		public CallExpressionContext(LeftHandSideExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SuperCallExpressionContext extends LeftHandSideExpressionContext {
		public TerminalNode KEYWORD_SUPER() { return getToken(ECMAScript6Parser.KEYWORD_SUPER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public CallExpressionLRRContext callExpressionLRR() {
			return getRuleContext(CallExpressionLRRContext.class,0);
		}
		public SuperCallExpressionContext(LeftHandSideExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterSuperCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitSuperCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitSuperCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewExpressionContext extends LeftHandSideExpressionContext {
		public TerminalNode KEYWORD_NEW() { return getToken(ECMAScript6Parser.KEYWORD_NEW, 0); }
		public NewExpressionRestContext newExpressionRest() {
			return getRuleContext(NewExpressionRestContext.class,0);
		}
		public NewExpressionContext(LeftHandSideExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitNewExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitNewExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftHandSideExpressionContext leftHandSideExpression() throws RecognitionException {
		LeftHandSideExpressionContext _localctx = new LeftHandSideExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_leftHandSideExpression);
		try {
			setState(506);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				_localctx = new CallExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(494);
				memberExpression(0);
				setState(498);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(495);
					arguments();
					setState(496);
					callExpressionLRR();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new SuperCallExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(500);
				match(KEYWORD_SUPER);
				setState(501);
				arguments();
				setState(502);
				callExpressionLRR();
				}
				break;
			case 3:
				_localctx = new NewExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(504);
				match(KEYWORD_NEW);
				setState(505);
				newExpressionRest();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixExpressionContext extends ParserRuleContext {
		public Token type;
		public LeftHandSideExpressionContext leftHandSideExpression() {
			return getRuleContext(LeftHandSideExpressionContext.class,0);
		}
		public TerminalNode PUNCTUATOR_INCREMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_INCREMENT, 0); }
		public TerminalNode PUNCTUATOR_DECREMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_DECREMENT, 0); }
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitPostfixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitPostfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_postfixExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			leftHandSideExpression();
			setState(510);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(509);
				((PostfixExpressionContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PUNCTUATOR_INCREMENT || _la==PUNCTUATOR_DECREMENT) ) {
					((PostfixExpressionContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpressionContext extends ParserRuleContext {
		public Token type;
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode KEYWORD_DELETE() { return getToken(ECMAScript6Parser.KEYWORD_DELETE, 0); }
		public TerminalNode KEYWORD_VOID() { return getToken(ECMAScript6Parser.KEYWORD_VOID, 0); }
		public TerminalNode KEYWORD_TYPEOF() { return getToken(ECMAScript6Parser.KEYWORD_TYPEOF, 0); }
		public TerminalNode PUNCTUATOR_INCREMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_INCREMENT, 0); }
		public TerminalNode PUNCTUATOR_DECREMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_DECREMENT, 0); }
		public TerminalNode PUNCTUATOR_PLUS() { return getToken(ECMAScript6Parser.PUNCTUATOR_PLUS, 0); }
		public TerminalNode PUNCTUATOR_MINUS() { return getToken(ECMAScript6Parser.PUNCTUATOR_MINUS, 0); }
		public TerminalNode PUNCTUATOR_BITWISE_NOT() { return getToken(ECMAScript6Parser.PUNCTUATOR_BITWISE_NOT, 0); }
		public TerminalNode PUNCTUATOR_NOT() { return getToken(ECMAScript6Parser.PUNCTUATOR_NOT, 0); }
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_unaryExpression);
		int _la;
		try {
			setState(515);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEYWORD_NEW:
			case KEYWORD_CLASS:
			case KEYWORD_SUPER:
			case KEYWORD_FUNCTION:
			case KEYWORD_THIS:
			case BRACKET_LEFT_PAREN:
			case BRACKET_LEFT_CURLY:
			case BRACKET_LEFT_BRACKET:
			case LITERAL_NULL:
			case LITERAL_TRUE:
			case LITERAL_FALSE:
			case NUMERIC_DECIMAL:
			case NUMERIC_INTEGER:
			case NUMERIC_BINARY:
			case NUMERIC_OCTAL:
			case NUMERIC_HEX:
			case STRING:
			case REGULAR_EXPRESSION:
			case TEMPLATE_HEAD:
			case TEMPLATE_NOSUBSTITUTION:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(512);
				postfixExpression();
				}
				break;
			case KEYWORD_TYPEOF:
			case KEYWORD_VOID:
			case KEYWORD_DELETE:
			case PUNCTUATOR_PLUS:
			case PUNCTUATOR_MINUS:
			case PUNCTUATOR_INCREMENT:
			case PUNCTUATOR_DECREMENT:
			case PUNCTUATOR_NOT:
			case PUNCTUATOR_BITWISE_NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(513);
				((UnaryExpressionContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 274878170112L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 49347L) != 0)) ) {
					((UnaryExpressionContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(514);
				unaryExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExpressionContext extends ParserRuleContext {
		public BinaryExpressionContext left;
		public Token operator;
		public BinaryExpressionContext right;
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public List<BinaryExpressionContext> binaryExpression() {
			return getRuleContexts(BinaryExpressionContext.class);
		}
		public BinaryExpressionContext binaryExpression(int i) {
			return getRuleContext(BinaryExpressionContext.class,i);
		}
		public TerminalNode PUNCTUATOR_MULTIPLICATION() { return getToken(ECMAScript6Parser.PUNCTUATOR_MULTIPLICATION, 0); }
		public TerminalNode PUNCTUATOR_DIVISION() { return getToken(ECMAScript6Parser.PUNCTUATOR_DIVISION, 0); }
		public TerminalNode PUNCTUATOR_MODULUS() { return getToken(ECMAScript6Parser.PUNCTUATOR_MODULUS, 0); }
		public TerminalNode PUNCTUATOR_PLUS() { return getToken(ECMAScript6Parser.PUNCTUATOR_PLUS, 0); }
		public TerminalNode PUNCTUATOR_MINUS() { return getToken(ECMAScript6Parser.PUNCTUATOR_MINUS, 0); }
		public TerminalNode PUNCTUATOR_LEFT_SHIFT_ARITHMETIC() { return getToken(ECMAScript6Parser.PUNCTUATOR_LEFT_SHIFT_ARITHMETIC, 0); }
		public TerminalNode PUNCTUATOR_RIGHT_SHIFT_ARITHMETIC() { return getToken(ECMAScript6Parser.PUNCTUATOR_RIGHT_SHIFT_ARITHMETIC, 0); }
		public TerminalNode PUNCTUATOR_RIGHT_SHIFT() { return getToken(ECMAScript6Parser.PUNCTUATOR_RIGHT_SHIFT, 0); }
		public TerminalNode PUNCTUATOR_LOWER() { return getToken(ECMAScript6Parser.PUNCTUATOR_LOWER, 0); }
		public TerminalNode PUNCTUATOR_GREATER() { return getToken(ECMAScript6Parser.PUNCTUATOR_GREATER, 0); }
		public TerminalNode PUNCTUATOR_LOWER_EQUALS() { return getToken(ECMAScript6Parser.PUNCTUATOR_LOWER_EQUALS, 0); }
		public TerminalNode PUNCTUATOR_GREATER_EQUALS() { return getToken(ECMAScript6Parser.PUNCTUATOR_GREATER_EQUALS, 0); }
		public TerminalNode KEYWORD_INSTANCEOF() { return getToken(ECMAScript6Parser.KEYWORD_INSTANCEOF, 0); }
		public TerminalNode KEYWORD_IN() { return getToken(ECMAScript6Parser.KEYWORD_IN, 0); }
		public TerminalNode PUNCTUATOR_EQUALS() { return getToken(ECMAScript6Parser.PUNCTUATOR_EQUALS, 0); }
		public TerminalNode PUNCTUATOR_NOT_EQUALS() { return getToken(ECMAScript6Parser.PUNCTUATOR_NOT_EQUALS, 0); }
		public TerminalNode PUNCTUATOR_EQUALS_EXACTLY() { return getToken(ECMAScript6Parser.PUNCTUATOR_EQUALS_EXACTLY, 0); }
		public TerminalNode PUNCTUATOR_NOT_EQUALS_EXACTLY() { return getToken(ECMAScript6Parser.PUNCTUATOR_NOT_EQUALS_EXACTLY, 0); }
		public TerminalNode PUNCTUATOR_BITWISE_AND() { return getToken(ECMAScript6Parser.PUNCTUATOR_BITWISE_AND, 0); }
		public TerminalNode PUNCTUATOR_BITWISE_XOR() { return getToken(ECMAScript6Parser.PUNCTUATOR_BITWISE_XOR, 0); }
		public TerminalNode PUNCTUATOR_BITWISE_OR() { return getToken(ECMAScript6Parser.PUNCTUATOR_BITWISE_OR, 0); }
		public TerminalNode PUNCTUATOR_AND() { return getToken(ECMAScript6Parser.PUNCTUATOR_AND, 0); }
		public TerminalNode PUNCTUATOR_OR() { return getToken(ECMAScript6Parser.PUNCTUATOR_OR, 0); }
		public BinaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterBinaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitBinaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitBinaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryExpressionContext binaryExpression() throws RecognitionException {
		return binaryExpression(0);
	}

	private BinaryExpressionContext binaryExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BinaryExpressionContext _localctx = new BinaryExpressionContext(_ctx, _parentState);
		BinaryExpressionContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_binaryExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(518);
			unaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(543);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(541);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpression);
						setState(520);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(521);
						((BinaryExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 11L) != 0)) ) {
							((BinaryExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(522);
						((BinaryExpressionContext)_localctx).right = binaryExpression(8);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpression);
						setState(523);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(524);
						((BinaryExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PUNCTUATOR_PLUS || _la==PUNCTUATOR_MINUS) ) {
							((BinaryExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(525);
						((BinaryExpressionContext)_localctx).right = binaryExpression(7);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpression);
						setState(526);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(527);
						((BinaryExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 7L) != 0)) ) {
							((BinaryExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(528);
						((BinaryExpressionContext)_localctx).right = binaryExpression(6);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpression);
						setState(529);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(530);
						((BinaryExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 270215977642229777L) != 0)) ) {
							((BinaryExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(531);
						((BinaryExpressionContext)_localctx).right = binaryExpression(5);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpression);
						setState(532);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(533);
						((BinaryExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 15L) != 0)) ) {
							((BinaryExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(534);
						((BinaryExpressionContext)_localctx).right = binaryExpression(4);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpression);
						setState(535);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(536);
						((BinaryExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 7L) != 0)) ) {
							((BinaryExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(537);
						((BinaryExpressionContext)_localctx).right = binaryExpression(3);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpression);
						setState(538);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(539);
						((BinaryExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PUNCTUATOR_AND || _la==PUNCTUATOR_OR) ) {
							((BinaryExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(540);
						((BinaryExpressionContext)_localctx).right = binaryExpression(2);
						}
						break;
					}
					}
				}
				setState(545);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext consequent;
		public AssignmentExpressionContext alternate;
		public BinaryExpressionContext binaryExpression() {
			return getRuleContext(BinaryExpressionContext.class,0);
		}
		public TerminalNode PUNCTUATOR_TERNARY() { return getToken(ECMAScript6Parser.PUNCTUATOR_TERNARY, 0); }
		public TerminalNode PUNCTUATOR_COLON() { return getToken(ECMAScript6Parser.PUNCTUATOR_COLON, 0); }
		public List<AssignmentExpressionContext> assignmentExpression() {
			return getRuleContexts(AssignmentExpressionContext.class);
		}
		public AssignmentExpressionContext assignmentExpression(int i) {
			return getRuleContext(AssignmentExpressionContext.class,i);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitConditionalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_conditionalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			binaryExpression(0);
			setState(552);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(547);
				match(PUNCTUATOR_TERNARY);
				setState(548);
				((ConditionalExpressionContext)_localctx).consequent = assignmentExpression();
				setState(549);
				match(PUNCTUATOR_COLON);
				setState(550);
				((ConditionalExpressionContext)_localctx).alternate = assignmentExpression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext right;
		public AssignmentPatternContext assignmentPattern() {
			return getRuleContext(AssignmentPatternContext.class,0);
		}
		public TerminalNode PUNCTUATOR_ASSIGNMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_ASSIGNMENT, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public LeftHandSideExpressionContext leftHandSideExpression() {
			return getRuleContext(LeftHandSideExpressionContext.class,0);
		}
		public TerminalNode PUNCTUATOR_DIVISION_ASSIGNMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_DIVISION_ASSIGNMENT, 0); }
		public TerminalNode PUNCTUATOR_PLUS_ASSIGNMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_PLUS_ASSIGNMENT, 0); }
		public TerminalNode PUNCTUATOR_MINUS_ASSIGNMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_MINUS_ASSIGNMENT, 0); }
		public TerminalNode PUNCTUATOR_MULTIPLICATION_ASSIGNMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_MULTIPLICATION_ASSIGNMENT, 0); }
		public TerminalNode PUNCTUATOR_MODULUS_ASSIGNMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_MODULUS_ASSIGNMENT, 0); }
		public TerminalNode PUNCTUATOR_LEFT_SHIFT_ARITHMETIC_ASSIGNMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_LEFT_SHIFT_ARITHMETIC_ASSIGNMENT, 0); }
		public TerminalNode PUNCTUATOR_RIGHT_SHIFT_ARITHMETIC_ASSIGNMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_RIGHT_SHIFT_ARITHMETIC_ASSIGNMENT, 0); }
		public TerminalNode PUNCTUATOR_RIGHT_SHIFT_ASSIGNMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_RIGHT_SHIFT_ASSIGNMENT, 0); }
		public TerminalNode PUNCTUATOR_BITWISE_AND_ASSIGNMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_BITWISE_AND_ASSIGNMENT, 0); }
		public TerminalNode PUNCTUATOR_BITWISE_OR_ASSIGNMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_BITWISE_OR_ASSIGNMENT, 0); }
		public TerminalNode PUNCTUATOR_BITWISE_XOR_ASSIGNMENT() { return getToken(ECMAScript6Parser.PUNCTUATOR_BITWISE_XOR_ASSIGNMENT, 0); }
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ArrowFunctionContext arrowFunction() {
			return getRuleContext(ArrowFunctionContext.class,0);
		}
		public YieldExpressionContext yieldExpression() {
			return getRuleContext(YieldExpressionContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_assignmentExpression);
		int _la;
		try {
			setState(565);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(554);
				assignmentPattern();
				setState(555);
				match(PUNCTUATOR_ASSIGNMENT);
				setState(556);
				((AssignmentExpressionContext)_localctx).right = assignmentExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(558);
				leftHandSideExpression();
				setState(559);
				_la = _input.LA(1);
				if ( !(((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 134152193L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(560);
				((AssignmentExpressionContext)_localctx).right = assignmentExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(562);
				conditionalExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(563);
				arrowFunction();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(564);
				yieldExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentPatternContext extends ParserRuleContext {
		public ObjectAssignmentPatternContext objectAssignmentPattern() {
			return getRuleContext(ObjectAssignmentPatternContext.class,0);
		}
		public ArrayAssignmentPatternContext arrayAssignmentPattern() {
			return getRuleContext(ArrayAssignmentPatternContext.class,0);
		}
		public AssignmentPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterAssignmentPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitAssignmentPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitAssignmentPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentPatternContext assignmentPattern() throws RecognitionException {
		AssignmentPatternContext _localctx = new AssignmentPatternContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_assignmentPattern);
		try {
			setState(569);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_LEFT_CURLY:
				enterOuterAlt(_localctx, 1);
				{
				setState(567);
				objectAssignmentPattern();
				}
				break;
			case BRACKET_LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(568);
				arrayAssignmentPattern();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectAssignmentPatternContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_LEFT_CURLY, 0); }
		public TerminalNode BRACKET_RIGHT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_CURLY, 0); }
		public AssignmentPropertyListContext assignmentPropertyList() {
			return getRuleContext(AssignmentPropertyListContext.class,0);
		}
		public TerminalNode PUNCTUATOR_COMMA() { return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, 0); }
		public ObjectAssignmentPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectAssignmentPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterObjectAssignmentPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitObjectAssignmentPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitObjectAssignmentPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectAssignmentPatternContext objectAssignmentPattern() throws RecognitionException {
		ObjectAssignmentPatternContext _localctx = new ObjectAssignmentPatternContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_objectAssignmentPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			match(BRACKET_LEFT_CURLY);
			setState(576);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & 1188387351672389633L) != 0)) {
				{
				setState(572);
				assignmentPropertyList();
				setState(574);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_COMMA) {
					{
					setState(573);
					match(PUNCTUATOR_COMMA);
					}
				}

				}
			}

			setState(578);
			match(BRACKET_RIGHT_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAssignmentPatternContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_LEFT_BRACKET, 0); }
		public TerminalNode BRACKET_RIGHT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_BRACKET, 0); }
		public ElisionContext elision() {
			return getRuleContext(ElisionContext.class,0);
		}
		public AssignmentRestElementContext assignmentRestElement() {
			return getRuleContext(AssignmentRestElementContext.class,0);
		}
		public AssignmentElementListContext assignmentElementList() {
			return getRuleContext(AssignmentElementListContext.class,0);
		}
		public TerminalNode PUNCTUATOR_COMMA() { return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, 0); }
		public ArrayAssignmentPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAssignmentPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterArrayAssignmentPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitArrayAssignmentPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitArrayAssignmentPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAssignmentPatternContext arrayAssignmentPattern() throws RecognitionException {
		ArrayAssignmentPatternContext _localctx = new ArrayAssignmentPatternContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_arrayAssignmentPattern);
		int _la;
		try {
			setState(603);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(580);
				match(BRACKET_LEFT_BRACKET);
				setState(582);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_COMMA) {
					{
					setState(581);
					elision();
					}
				}

				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_ELLIPSIS) {
					{
					setState(584);
					assignmentRestElement();
					}
				}

				setState(587);
				match(BRACKET_RIGHT_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(588);
				match(BRACKET_LEFT_BRACKET);
				setState(589);
				assignmentElementList();
				setState(590);
				match(BRACKET_RIGHT_BRACKET);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(592);
				match(BRACKET_LEFT_BRACKET);
				setState(593);
				assignmentElementList();
				setState(594);
				match(PUNCTUATOR_COMMA);
				setState(596);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_COMMA) {
					{
					setState(595);
					elision();
					}
				}

				setState(599);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_ELLIPSIS) {
					{
					setState(598);
					assignmentRestElement();
					}
				}

				setState(601);
				match(BRACKET_RIGHT_BRACKET);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentPropertyListContext extends ParserRuleContext {
		public List<AssignmentPropertyContext> assignmentProperty() {
			return getRuleContexts(AssignmentPropertyContext.class);
		}
		public AssignmentPropertyContext assignmentProperty(int i) {
			return getRuleContext(AssignmentPropertyContext.class,i);
		}
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public AssignmentPropertyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentPropertyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterAssignmentPropertyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitAssignmentPropertyList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitAssignmentPropertyList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentPropertyListContext assignmentPropertyList() throws RecognitionException {
		AssignmentPropertyListContext _localctx = new AssignmentPropertyListContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_assignmentPropertyList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			assignmentProperty();
			setState(610);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(606);
					match(PUNCTUATOR_COMMA);
					setState(607);
					assignmentProperty();
					}
					}
				}
				setState(612);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentElementListContext extends ParserRuleContext {
		public List<AssignmentElisionElementContext> assignmentElisionElement() {
			return getRuleContexts(AssignmentElisionElementContext.class);
		}
		public AssignmentElisionElementContext assignmentElisionElement(int i) {
			return getRuleContext(AssignmentElisionElementContext.class,i);
		}
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public AssignmentElementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentElementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterAssignmentElementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitAssignmentElementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitAssignmentElementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentElementListContext assignmentElementList() throws RecognitionException {
		AssignmentElementListContext _localctx = new AssignmentElementListContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_assignmentElementList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(613);
			assignmentElisionElement();
			setState(618);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(614);
					match(PUNCTUATOR_COMMA);
					setState(615);
					assignmentElisionElement();
					}
					}
				}
				setState(620);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentElisionElementContext extends ParserRuleContext {
		public AssignmentElementContext assignmentElement() {
			return getRuleContext(AssignmentElementContext.class,0);
		}
		public ElisionContext elision() {
			return getRuleContext(ElisionContext.class,0);
		}
		public AssignmentElisionElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentElisionElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterAssignmentElisionElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitAssignmentElisionElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitAssignmentElisionElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentElisionElementContext assignmentElisionElement() throws RecognitionException {
		AssignmentElisionElementContext _localctx = new AssignmentElisionElementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_assignmentElisionElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNCTUATOR_COMMA) {
				{
				setState(621);
				elision();
				}
			}

			setState(624);
			assignmentElement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentPropertyContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public TerminalNode PUNCTUATOR_COLON() { return getToken(ECMAScript6Parser.PUNCTUATOR_COLON, 0); }
		public AssignmentElementContext assignmentElement() {
			return getRuleContext(AssignmentElementContext.class,0);
		}
		public AssignmentPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterAssignmentProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitAssignmentProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitAssignmentProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentPropertyContext assignmentProperty() throws RecognitionException {
		AssignmentPropertyContext _localctx = new AssignmentPropertyContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_assignmentProperty);
		int _la;
		try {
			setState(634);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(626);
				match(IDENTIFIER);
				setState(628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_ASSIGNMENT) {
					{
					setState(627);
					initializer();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(630);
				propertyName();
				setState(631);
				match(PUNCTUATOR_COLON);
				setState(632);
				assignmentElement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentElementContext extends ParserRuleContext {
		public LeftHandSideExpressionContext leftHandSideExpression() {
			return getRuleContext(LeftHandSideExpressionContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public AssignmentElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterAssignmentElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitAssignmentElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitAssignmentElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentElementContext assignmentElement() throws RecognitionException {
		AssignmentElementContext _localctx = new AssignmentElementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_assignmentElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			leftHandSideExpression();
			setState(638);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNCTUATOR_ASSIGNMENT) {
				{
				setState(637);
				initializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentRestElementContext extends ParserRuleContext {
		public TerminalNode PUNCTUATOR_ELLIPSIS() { return getToken(ECMAScript6Parser.PUNCTUATOR_ELLIPSIS, 0); }
		public LeftHandSideExpressionContext leftHandSideExpression() {
			return getRuleContext(LeftHandSideExpressionContext.class,0);
		}
		public AssignmentRestElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentRestElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterAssignmentRestElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitAssignmentRestElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitAssignmentRestElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentRestElementContext assignmentRestElement() throws RecognitionException {
		AssignmentRestElementContext _localctx = new AssignmentRestElementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_assignmentRestElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			match(PUNCTUATOR_ELLIPSIS);
			setState(641);
			leftHandSideExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionSequenceContext extends ParserRuleContext {
		public List<AssignmentExpressionContext> assignmentExpression() {
			return getRuleContexts(AssignmentExpressionContext.class);
		}
		public AssignmentExpressionContext assignmentExpression(int i) {
			return getRuleContext(AssignmentExpressionContext.class,i);
		}
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public ExpressionSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterExpressionSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitExpressionSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitExpressionSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionSequenceContext expressionSequence() throws RecognitionException {
		ExpressionSequenceContext _localctx = new ExpressionSequenceContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_expressionSequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(643);
			assignmentExpression();
			setState(648);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(644);
					match(PUNCTUATOR_COMMA);
					setState(645);
					assignmentExpression();
					}
					}
				}
				setState(650);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VariableStatementContext variableStatement() {
			return getRuleContext(VariableStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public WithStatementContext withStatement() {
			return getRuleContext(WithStatementContext.class,0);
		}
		public LabelledStatementContext labelledStatement() {
			return getRuleContext(LabelledStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public DebuggerStatementContext debuggerStatement() {
			return getRuleContext(DebuggerStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_statement);
		try {
			setState(666);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(651);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(652);
				variableStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(653);
				emptyStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(654);
				expressionStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(655);
				ifStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(656);
				iterationStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(657);
				switchStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(658);
				continueStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(659);
				breakStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(660);
				returnStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(661);
				withStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(662);
				labelledStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(663);
				throwStatement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(664);
				tryStatement();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(665);
				debuggerStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public HoistableDeclarationContext hoistableDeclaration() {
			return getRuleContext(HoistableDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public LexicalDeclarationContext lexicalDeclaration() {
			return getRuleContext(LexicalDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_declaration);
		try {
			setState(671);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEYWORD_FUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(668);
				hoistableDeclaration();
				}
				break;
			case KEYWORD_CLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(669);
				classDeclaration();
				}
				break;
			case KEYWORD_CONST:
			case RESERVED_LET:
				enterOuterAlt(_localctx, 3);
				{
				setState(670);
				lexicalDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HoistableDeclarationContext extends ParserRuleContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public GeneratorDeclarationContext generatorDeclaration() {
			return getRuleContext(GeneratorDeclarationContext.class,0);
		}
		public HoistableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hoistableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterHoistableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitHoistableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitHoistableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HoistableDeclarationContext hoistableDeclaration() throws RecognitionException {
		HoistableDeclarationContext _localctx = new HoistableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_hoistableDeclaration);
		try {
			setState(675);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(673);
				functionDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(674);
				generatorDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_LEFT_CURLY, 0); }
		public TerminalNode BRACKET_RIGHT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_CURLY, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
			match(BRACKET_LEFT_CURLY);
			setState(679);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(678);
				statementList();
				}
				break;
			}
			setState(681);
			match(BRACKET_RIGHT_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitStatementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_statementList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(685);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
					case 1:
						{
						setState(683);
						statement();
						}
						break;
					case 2:
						{
						setState(684);
						declaration();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(687);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LexicalDeclarationContext extends ParserRuleContext {
		public LetOrConstContext letOrConst() {
			return getRuleContext(LetOrConstContext.class,0);
		}
		public BindingListContext bindingList() {
			return getRuleContext(BindingListContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public LexicalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexicalDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterLexicalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitLexicalDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitLexicalDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LexicalDeclarationContext lexicalDeclaration() throws RecognitionException {
		LexicalDeclarationContext _localctx = new LexicalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_lexicalDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(689);
			letOrConst();
			setState(690);
			bindingList();
			setState(691);
			eos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LetOrConstContext extends ParserRuleContext {
		public TerminalNode RESERVED_LET() { return getToken(ECMAScript6Parser.RESERVED_LET, 0); }
		public TerminalNode KEYWORD_CONST() { return getToken(ECMAScript6Parser.KEYWORD_CONST, 0); }
		public LetOrConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letOrConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterLetOrConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitLetOrConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitLetOrConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetOrConstContext letOrConst() throws RecognitionException {
		LetOrConstContext _localctx = new LetOrConstContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_letOrConst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(693);
			_la = _input.LA(1);
			if ( !(_la==KEYWORD_CONST || _la==RESERVED_LET) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BindingListContext extends ParserRuleContext {
		public List<LexicalBindingContext> lexicalBinding() {
			return getRuleContexts(LexicalBindingContext.class);
		}
		public LexicalBindingContext lexicalBinding(int i) {
			return getRuleContext(LexicalBindingContext.class,i);
		}
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public BindingListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterBindingList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitBindingList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitBindingList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingListContext bindingList() throws RecognitionException {
		BindingListContext _localctx = new BindingListContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_bindingList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(695);
			lexicalBinding();
			setState(700);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(696);
					match(PUNCTUATOR_COMMA);
					setState(697);
					lexicalBinding();
					}
					}
				}
				setState(702);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LexicalBindingContext extends ParserRuleContext {
		public BindingIdentifierContext bindingIdentifier() {
			return getRuleContext(BindingIdentifierContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public BindingPatternContext bindingPattern() {
			return getRuleContext(BindingPatternContext.class,0);
		}
		public LexicalBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexicalBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterLexicalBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitLexicalBinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitLexicalBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LexicalBindingContext lexicalBinding() throws RecognitionException {
		LexicalBindingContext _localctx = new LexicalBindingContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_lexicalBinding);
		try {
			setState(711);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(703);
				bindingIdentifier();
				setState(705);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(704);
					initializer();
					}
					break;
				}
				}
				break;
			case BRACKET_LEFT_CURLY:
			case BRACKET_LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(707);
				bindingPattern();
				setState(709);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
				case 1:
					{
					setState(708);
					initializer();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableStatementContext extends ParserRuleContext {
		public TerminalNode KEYWORD_VAR() { return getToken(ECMAScript6Parser.KEYWORD_VAR, 0); }
		public VariableDeclarationListContext variableDeclarationList() {
			return getRuleContext(VariableDeclarationListContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public VariableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterVariableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitVariableStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitVariableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableStatementContext variableStatement() throws RecognitionException {
		VariableStatementContext _localctx = new VariableStatementContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_variableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(713);
			match(KEYWORD_VAR);
			setState(714);
			variableDeclarationList();
			setState(715);
			eos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationListContext extends ParserRuleContext {
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public VariableDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterVariableDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitVariableDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitVariableDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationListContext variableDeclarationList() throws RecognitionException {
		VariableDeclarationListContext _localctx = new VariableDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_variableDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
			variableDeclaration();
			setState(722);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(718);
					match(PUNCTUATOR_COMMA);
					setState(719);
					variableDeclaration();
					}
					}
				}
				setState(724);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public Token ident;
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public ReservedKeywordContext reservedKeyword() {
			return getRuleContext(ReservedKeywordContext.class,0);
		}
		public BindingPatternContext bindingPattern() {
			return getRuleContext(BindingPatternContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_variableDeclaration);
		try {
			setState(737);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(725);
				((VariableDeclarationContext)_localctx).ident = match(IDENTIFIER);
				setState(727);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(726);
					initializer();
					}
					break;
				}
				}
				break;
			case RESERVED_ENUM:
			case RESERVED_AWAIT:
			case RESERVED_IMPLEMENTS:
			case RESERVED_PACKAGE:
			case RESERVED_PROTECTED:
			case RESERVED_INTERFACE:
			case RESERVED_PRIVATE:
			case RESERVED_PUBLIC:
			case RESERVED_STATIC:
			case RESERVED_LET:
			case RESERVED_AS:
			case RESERVED_FROM:
				enterOuterAlt(_localctx, 2);
				{
				setState(729);
				reservedKeyword();
				setState(731);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(730);
					initializer();
					}
					break;
				}
				}
				break;
			case BRACKET_LEFT_CURLY:
			case BRACKET_LEFT_BRACKET:
				enterOuterAlt(_localctx, 3);
				{
				setState(733);
				bindingPattern();
				setState(735);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(734);
					initializer();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BindingPatternContext extends ParserRuleContext {
		public ObjectBindingPatternContext objectBindingPattern() {
			return getRuleContext(ObjectBindingPatternContext.class,0);
		}
		public ArrayBindingPatternContext arrayBindingPattern() {
			return getRuleContext(ArrayBindingPatternContext.class,0);
		}
		public BindingPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterBindingPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitBindingPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitBindingPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingPatternContext bindingPattern() throws RecognitionException {
		BindingPatternContext _localctx = new BindingPatternContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_bindingPattern);
		try {
			setState(741);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_LEFT_CURLY:
				enterOuterAlt(_localctx, 1);
				{
				setState(739);
				objectBindingPattern();
				}
				break;
			case BRACKET_LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(740);
				arrayBindingPattern();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectBindingPatternContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_LEFT_CURLY, 0); }
		public TerminalNode BRACKET_RIGHT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_CURLY, 0); }
		public BindingPropertyListContext bindingPropertyList() {
			return getRuleContext(BindingPropertyListContext.class,0);
		}
		public TerminalNode PUNCTUATOR_COMMA() { return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, 0); }
		public ObjectBindingPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectBindingPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterObjectBindingPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitObjectBindingPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitObjectBindingPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectBindingPatternContext objectBindingPattern() throws RecognitionException {
		ObjectBindingPatternContext _localctx = new ObjectBindingPatternContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_objectBindingPattern);
		try {
			setState(754);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(743);
				match(BRACKET_LEFT_CURLY);
				setState(744);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(745);
				match(BRACKET_LEFT_CURLY);
				setState(746);
				bindingPropertyList();
				setState(747);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(749);
				match(BRACKET_LEFT_CURLY);
				setState(750);
				bindingPropertyList();
				setState(751);
				match(PUNCTUATOR_COMMA);
				setState(752);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayBindingPatternContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_LEFT_BRACKET, 0); }
		public TerminalNode BRACKET_RIGHT_BRACKET() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_BRACKET, 0); }
		public ElisionContext elision() {
			return getRuleContext(ElisionContext.class,0);
		}
		public BindingRestElementContext bindingRestElement() {
			return getRuleContext(BindingRestElementContext.class,0);
		}
		public BindingElementListContext bindingElementList() {
			return getRuleContext(BindingElementListContext.class,0);
		}
		public TerminalNode PUNCTUATOR_COMMA() { return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, 0); }
		public ArrayBindingPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayBindingPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterArrayBindingPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitArrayBindingPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitArrayBindingPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayBindingPatternContext arrayBindingPattern() throws RecognitionException {
		ArrayBindingPatternContext _localctx = new ArrayBindingPatternContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_arrayBindingPattern);
		int _la;
		try {
			setState(779);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(756);
				match(BRACKET_LEFT_BRACKET);
				setState(758);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_COMMA) {
					{
					setState(757);
					elision();
					}
				}

				setState(761);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_ELLIPSIS) {
					{
					setState(760);
					bindingRestElement();
					}
				}

				setState(763);
				match(BRACKET_RIGHT_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(764);
				match(BRACKET_LEFT_BRACKET);
				setState(765);
				bindingElementList();
				setState(766);
				match(BRACKET_RIGHT_BRACKET);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(768);
				match(BRACKET_LEFT_BRACKET);
				setState(769);
				bindingElementList();
				setState(770);
				match(PUNCTUATOR_COMMA);
				setState(772);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_COMMA) {
					{
					setState(771);
					elision();
					}
				}

				setState(775);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_ELLIPSIS) {
					{
					setState(774);
					bindingRestElement();
					}
				}

				setState(777);
				match(BRACKET_RIGHT_BRACKET);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BindingPropertyListContext extends ParserRuleContext {
		public List<BindingPropertyContext> bindingProperty() {
			return getRuleContexts(BindingPropertyContext.class);
		}
		public BindingPropertyContext bindingProperty(int i) {
			return getRuleContext(BindingPropertyContext.class,i);
		}
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public BindingPropertyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingPropertyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterBindingPropertyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitBindingPropertyList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitBindingPropertyList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingPropertyListContext bindingPropertyList() throws RecognitionException {
		BindingPropertyListContext _localctx = new BindingPropertyListContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_bindingPropertyList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(781);
			bindingProperty();
			setState(786);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(782);
					match(PUNCTUATOR_COMMA);
					setState(783);
					bindingProperty();
					}
					}
				}
				setState(788);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BindingElementListContext extends ParserRuleContext {
		public List<BindingElisionElementContext> bindingElisionElement() {
			return getRuleContexts(BindingElisionElementContext.class);
		}
		public BindingElisionElementContext bindingElisionElement(int i) {
			return getRuleContext(BindingElisionElementContext.class,i);
		}
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public BindingElementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingElementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterBindingElementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitBindingElementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitBindingElementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingElementListContext bindingElementList() throws RecognitionException {
		BindingElementListContext _localctx = new BindingElementListContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_bindingElementList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(789);
			bindingElisionElement();
			setState(794);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(790);
					match(PUNCTUATOR_COMMA);
					setState(791);
					bindingElisionElement();
					}
					}
				}
				setState(796);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BindingElisionElementContext extends ParserRuleContext {
		public BindingElementContext bindingElement() {
			return getRuleContext(BindingElementContext.class,0);
		}
		public ElisionContext elision() {
			return getRuleContext(ElisionContext.class,0);
		}
		public BindingElisionElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingElisionElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterBindingElisionElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitBindingElisionElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitBindingElisionElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingElisionElementContext bindingElisionElement() throws RecognitionException {
		BindingElisionElementContext _localctx = new BindingElisionElementContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_bindingElisionElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNCTUATOR_COMMA) {
				{
				setState(797);
				elision();
				}
			}

			setState(800);
			bindingElement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BindingPropertyContext extends ParserRuleContext {
		public SingleNameBindingContext singleNameBinding() {
			return getRuleContext(SingleNameBindingContext.class,0);
		}
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public TerminalNode PUNCTUATOR_COLON() { return getToken(ECMAScript6Parser.PUNCTUATOR_COLON, 0); }
		public BindingElementContext bindingElement() {
			return getRuleContext(BindingElementContext.class,0);
		}
		public BindingPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterBindingProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitBindingProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitBindingProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingPropertyContext bindingProperty() throws RecognitionException {
		BindingPropertyContext _localctx = new BindingPropertyContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_bindingProperty);
		try {
			setState(807);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(802);
				singleNameBinding();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(803);
				propertyName();
				setState(804);
				match(PUNCTUATOR_COLON);
				setState(805);
				bindingElement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BindingElementContext extends ParserRuleContext {
		public SingleNameBindingContext singleNameBinding() {
			return getRuleContext(SingleNameBindingContext.class,0);
		}
		public BindingPatternContext bindingPattern() {
			return getRuleContext(BindingPatternContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public BindingElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterBindingElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitBindingElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitBindingElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingElementContext bindingElement() throws RecognitionException {
		BindingElementContext _localctx = new BindingElementContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_bindingElement);
		int _la;
		try {
			setState(814);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(809);
				singleNameBinding();
				}
				break;
			case BRACKET_LEFT_CURLY:
			case BRACKET_LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(810);
				bindingPattern();
				setState(812);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_ASSIGNMENT) {
					{
					setState(811);
					initializer();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SingleNameBindingContext extends ParserRuleContext {
		public BindingIdentifierContext bindingIdentifier() {
			return getRuleContext(BindingIdentifierContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public SingleNameBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleNameBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterSingleNameBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitSingleNameBinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitSingleNameBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleNameBindingContext singleNameBinding() throws RecognitionException {
		SingleNameBindingContext _localctx = new SingleNameBindingContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_singleNameBinding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(816);
			bindingIdentifier();
			setState(818);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNCTUATOR_ASSIGNMENT) {
				{
				setState(817);
				initializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BindingRestElementContext extends ParserRuleContext {
		public TerminalNode PUNCTUATOR_ELLIPSIS() { return getToken(ECMAScript6Parser.PUNCTUATOR_ELLIPSIS, 0); }
		public BindingIdentifierContext bindingIdentifier() {
			return getRuleContext(BindingIdentifierContext.class,0);
		}
		public BindingRestElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingRestElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterBindingRestElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitBindingRestElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitBindingRestElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingRestElementContext bindingRestElement() throws RecognitionException {
		BindingRestElementContext _localctx = new BindingRestElementContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_bindingRestElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(820);
			match(PUNCTUATOR_ELLIPSIS);
			setState(821);
			bindingIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyStatementContext extends ParserRuleContext {
		public TerminalNode PUNCTUATOR_SEMICOLON() { return getToken(ECMAScript6Parser.PUNCTUATOR_SEMICOLON, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(823);
			match(PUNCTUATOR_SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(825);
			if (!( _input.LA(1) != BRACKET_LEFT_CURLY && _input.LA(1) != KEYWORD_FUNCTION && _input.LA(1) != KEYWORD_CLASS && _input.LA(1) != RESERVED_LET )) throw new FailedPredicateException(this, " _input.LA(1) != BRACKET_LEFT_CURLY && _input.LA(1) != KEYWORD_FUNCTION && _input.LA(1) != KEYWORD_CLASS && _input.LA(1) != RESERVED_LET ");
			setState(826);
			expressionSequence();
			setState(827);
			eos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public ExpressionSequenceContext test;
		public StatementContext consequent;
		public StatementContext alternate;
		public TerminalNode KEYWORD_IF() { return getToken(ECMAScript6Parser.KEYWORD_IF, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode KEYWORD_ELSE() { return getToken(ECMAScript6Parser.KEYWORD_ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(829);
			match(KEYWORD_IF);
			setState(830);
			match(BRACKET_LEFT_PAREN);
			setState(831);
			((IfStatementContext)_localctx).test = expressionSequence();
			setState(832);
			match(BRACKET_RIGHT_PAREN);
			setState(833);
			((IfStatementContext)_localctx).consequent = statement();
			setState(836);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				{
				setState(834);
				match(KEYWORD_ELSE);
				setState(835);
				((IfStatementContext)_localctx).alternate = statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IterationStatementContext extends ParserRuleContext {
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }

		public IterationStatementContext() { }
		public void copyFrom(IterationStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForVarOfStatementContext extends IterationStatementContext {
		public ForBindingContext left;
		public AssignmentExpressionContext right;
		public StatementContext body;
		public TerminalNode KEYWORD_FOR() { return getToken(ECMAScript6Parser.KEYWORD_FOR, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public TerminalNode KEYWORD_VAR() { return getToken(ECMAScript6Parser.KEYWORD_VAR, 0); }
		public TerminalNode KEYWORD_OF() { return getToken(ECMAScript6Parser.KEYWORD_OF, 0); }
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public ForBindingContext forBinding() {
			return getRuleContext(ForBindingContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForVarOfStatementContext(IterationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterForVarOfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitForVarOfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitForVarOfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForVarStatementContext extends IterationStatementContext {
		public VariableDeclarationListContext init;
		public ExpressionSequenceContext test;
		public ExpressionSequenceContext update;
		public StatementContext body;
		public TerminalNode KEYWORD_FOR() { return getToken(ECMAScript6Parser.KEYWORD_FOR, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public TerminalNode KEYWORD_VAR() { return getToken(ECMAScript6Parser.KEYWORD_VAR, 0); }
		public List<TerminalNode> PUNCTUATOR_SEMICOLON() { return getTokens(ECMAScript6Parser.PUNCTUATOR_SEMICOLON); }
		public TerminalNode PUNCTUATOR_SEMICOLON(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_SEMICOLON, i);
		}
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public VariableDeclarationListContext variableDeclarationList() {
			return getRuleContext(VariableDeclarationListContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionSequenceContext> expressionSequence() {
			return getRuleContexts(ExpressionSequenceContext.class);
		}
		public ExpressionSequenceContext expressionSequence(int i) {
			return getRuleContext(ExpressionSequenceContext.class,i);
		}
		public ForVarStatementContext(IterationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterForVarStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitForVarStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitForVarStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForVarInStatementContext extends IterationStatementContext {
		public VariableDeclarationContext left;
		public ExpressionSequenceContext right;
		public StatementContext body;
		public TerminalNode KEYWORD_FOR() { return getToken(ECMAScript6Parser.KEYWORD_FOR, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public TerminalNode KEYWORD_VAR() { return getToken(ECMAScript6Parser.KEYWORD_VAR, 0); }
		public TerminalNode KEYWORD_IN() { return getToken(ECMAScript6Parser.KEYWORD_IN, 0); }
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForVarInStatementContext(IterationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterForVarInStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitForVarInStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitForVarInStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForCLOfStatementContext extends IterationStatementContext {
		public ForDeclarationContext left;
		public AssignmentExpressionContext right;
		public StatementContext body;
		public TerminalNode KEYWORD_FOR() { return getToken(ECMAScript6Parser.KEYWORD_FOR, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public TerminalNode KEYWORD_OF() { return getToken(ECMAScript6Parser.KEYWORD_OF, 0); }
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public ForDeclarationContext forDeclaration() {
			return getRuleContext(ForDeclarationContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForCLOfStatementContext(IterationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterForCLOfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitForCLOfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitForCLOfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForLCStatementContext extends IterationStatementContext {
		public ExpressionSequenceContext test;
		public ExpressionSequenceContext update;
		public StatementContext body;
		public TerminalNode KEYWORD_FOR() { return getToken(ECMAScript6Parser.KEYWORD_FOR, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public LexicalDeclarationContext lexicalDeclaration() {
			return getRuleContext(LexicalDeclarationContext.class,0);
		}
		public TerminalNode PUNCTUATOR_SEMICOLON() { return getToken(ECMAScript6Parser.PUNCTUATOR_SEMICOLON, 0); }
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionSequenceContext> expressionSequence() {
			return getRuleContexts(ExpressionSequenceContext.class);
		}
		public ExpressionSequenceContext expressionSequence(int i) {
			return getRuleContext(ExpressionSequenceContext.class,i);
		}
		public ForLCStatementContext(IterationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterForLCStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitForLCStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitForLCStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForCLInStatementContext extends IterationStatementContext {
		public ForDeclarationContext left;
		public ExpressionSequenceContext right;
		public StatementContext body;
		public TerminalNode KEYWORD_FOR() { return getToken(ECMAScript6Parser.KEYWORD_FOR, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public TerminalNode KEYWORD_IN() { return getToken(ECMAScript6Parser.KEYWORD_IN, 0); }
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public ForDeclarationContext forDeclaration() {
			return getRuleContext(ForDeclarationContext.class,0);
		}
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForCLInStatementContext(IterationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterForCLInStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitForCLInStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitForCLInStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends IterationStatementContext {
		public TerminalNode KEYWORD_WHILE() { return getToken(ECMAScript6Parser.KEYWORD_WHILE, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(IterationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends IterationStatementContext {
		public ExpressionSequenceContext init;
		public ExpressionSequenceContext test;
		public ExpressionSequenceContext update;
		public StatementContext body;
		public TerminalNode KEYWORD_FOR() { return getToken(ECMAScript6Parser.KEYWORD_FOR, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public List<TerminalNode> PUNCTUATOR_SEMICOLON() { return getTokens(ECMAScript6Parser.PUNCTUATOR_SEMICOLON); }
		public TerminalNode PUNCTUATOR_SEMICOLON(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_SEMICOLON, i);
		}
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionSequenceContext> expressionSequence() {
			return getRuleContexts(ExpressionSequenceContext.class);
		}
		public ExpressionSequenceContext expressionSequence(int i) {
			return getRuleContext(ExpressionSequenceContext.class,i);
		}
		public ForStatementContext(IterationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileStatementContext extends IterationStatementContext {
		public TerminalNode KEYWORD_DO() { return getToken(ECMAScript6Parser.KEYWORD_DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode KEYWORD_WHILE() { return getToken(ECMAScript6Parser.KEYWORD_WHILE, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public DoWhileStatementContext(IterationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitDoWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForInStatementContext extends IterationStatementContext {
		public LeftHandSideExpressionContext left;
		public ExpressionSequenceContext right;
		public StatementContext body;
		public TerminalNode KEYWORD_FOR() { return getToken(ECMAScript6Parser.KEYWORD_FOR, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public TerminalNode KEYWORD_IN() { return getToken(ECMAScript6Parser.KEYWORD_IN, 0); }
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public LeftHandSideExpressionContext leftHandSideExpression() {
			return getRuleContext(LeftHandSideExpressionContext.class,0);
		}
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForInStatementContext(IterationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterForInStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitForInStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitForInStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForOfStatementContext extends IterationStatementContext {
		public LeftHandSideExpressionContext left;
		public AssignmentExpressionContext right;
		public StatementContext body;
		public TerminalNode KEYWORD_FOR() { return getToken(ECMAScript6Parser.KEYWORD_FOR, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public TerminalNode KEYWORD_OF() { return getToken(ECMAScript6Parser.KEYWORD_OF, 0); }
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public LeftHandSideExpressionContext leftHandSideExpression() {
			return getRuleContext(LeftHandSideExpressionContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForOfStatementContext(IterationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterForOfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitForOfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitForOfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_iterationStatement);
		int _la;
		try {
			setState(945);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				_localctx = new DoWhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(838);
				match(KEYWORD_DO);
				setState(839);
				statement();
				setState(840);
				match(KEYWORD_WHILE);
				setState(841);
				match(BRACKET_LEFT_PAREN);
				setState(842);
				expressionSequence();
				setState(843);
				match(BRACKET_RIGHT_PAREN);
				setState(844);
				eos();
				}
				break;
			case 2:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(846);
				match(KEYWORD_WHILE);
				setState(847);
				match(BRACKET_LEFT_PAREN);
				setState(848);
				expressionSequence();
				setState(849);
				match(BRACKET_RIGHT_PAREN);
				setState(850);
				statement();
				}
				break;
			case 3:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(852);
				match(KEYWORD_FOR);
				setState(853);
				match(BRACKET_LEFT_PAREN);
				setState(855);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 189151487179228160L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 87956635304131L) != 0)) {
					{
					setState(854);
					((ForStatementContext)_localctx).init = expressionSequence();
					}
				}

				setState(857);
				match(PUNCTUATOR_SEMICOLON);
				setState(859);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 189151487179228160L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 87956635304131L) != 0)) {
					{
					setState(858);
					((ForStatementContext)_localctx).test = expressionSequence();
					}
				}

				setState(861);
				match(PUNCTUATOR_SEMICOLON);
				setState(863);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 189151487179228160L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 87956635304131L) != 0)) {
					{
					setState(862);
					((ForStatementContext)_localctx).update = expressionSequence();
					}
				}

				setState(865);
				match(BRACKET_RIGHT_PAREN);
				setState(866);
				((ForStatementContext)_localctx).body = statement();
				}
				break;
			case 4:
				_localctx = new ForVarStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(867);
				match(KEYWORD_FOR);
				setState(868);
				match(BRACKET_LEFT_PAREN);
				setState(869);
				match(KEYWORD_VAR);
				setState(870);
				((ForVarStatementContext)_localctx).init = variableDeclarationList();
				setState(871);
				match(PUNCTUATOR_SEMICOLON);
				setState(873);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 189151487179228160L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 87956635304131L) != 0)) {
					{
					setState(872);
					((ForVarStatementContext)_localctx).test = expressionSequence();
					}
				}

				setState(875);
				match(PUNCTUATOR_SEMICOLON);
				setState(877);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 189151487179228160L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 87956635304131L) != 0)) {
					{
					setState(876);
					((ForVarStatementContext)_localctx).update = expressionSequence();
					}
				}

				setState(879);
				match(BRACKET_RIGHT_PAREN);
				setState(880);
				((ForVarStatementContext)_localctx).body = statement();
				}
				break;
			case 5:
				_localctx = new ForLCStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(882);
				match(KEYWORD_FOR);
				setState(883);
				match(BRACKET_LEFT_PAREN);
				setState(884);
				lexicalDeclaration();
				setState(886);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 189151487179228160L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 87956635304131L) != 0)) {
					{
					setState(885);
					((ForLCStatementContext)_localctx).test = expressionSequence();
					}
				}

				setState(888);
				match(PUNCTUATOR_SEMICOLON);
				setState(890);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 189151487179228160L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 87956635304131L) != 0)) {
					{
					setState(889);
					((ForLCStatementContext)_localctx).update = expressionSequence();
					}
				}

				setState(892);
				match(BRACKET_RIGHT_PAREN);
				setState(893);
				((ForLCStatementContext)_localctx).body = statement();
				}
				break;
			case 6:
				_localctx = new ForInStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(895);
				match(KEYWORD_FOR);
				setState(896);
				match(BRACKET_LEFT_PAREN);
				setState(897);
				((ForInStatementContext)_localctx).left = leftHandSideExpression();
				setState(898);
				match(KEYWORD_IN);
				setState(899);
				((ForInStatementContext)_localctx).right = expressionSequence();
				setState(900);
				match(BRACKET_RIGHT_PAREN);
				setState(901);
				((ForInStatementContext)_localctx).body = statement();
				}
				break;
			case 7:
				_localctx = new ForVarInStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(903);
				match(KEYWORD_FOR);
				setState(904);
				match(BRACKET_LEFT_PAREN);
				setState(905);
				match(KEYWORD_VAR);
				setState(906);
				((ForVarInStatementContext)_localctx).left = variableDeclaration();
				setState(907);
				match(KEYWORD_IN);
				setState(908);
				((ForVarInStatementContext)_localctx).right = expressionSequence();
				setState(909);
				match(BRACKET_RIGHT_PAREN);
				setState(910);
				((ForVarInStatementContext)_localctx).body = statement();
				}
				break;
			case 8:
				_localctx = new ForCLInStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(912);
				match(KEYWORD_FOR);
				setState(913);
				match(BRACKET_LEFT_PAREN);
				setState(914);
				((ForCLInStatementContext)_localctx).left = forDeclaration();
				setState(915);
				match(KEYWORD_IN);
				setState(916);
				((ForCLInStatementContext)_localctx).right = expressionSequence();
				setState(917);
				match(BRACKET_RIGHT_PAREN);
				setState(918);
				((ForCLInStatementContext)_localctx).body = statement();
				}
				break;
			case 9:
				_localctx = new ForOfStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(920);
				match(KEYWORD_FOR);
				setState(921);
				match(BRACKET_LEFT_PAREN);
				setState(922);
				((ForOfStatementContext)_localctx).left = leftHandSideExpression();
				setState(923);
				match(KEYWORD_OF);
				setState(924);
				((ForOfStatementContext)_localctx).right = assignmentExpression();
				setState(925);
				match(BRACKET_RIGHT_PAREN);
				setState(926);
				((ForOfStatementContext)_localctx).body = statement();
				}
				break;
			case 10:
				_localctx = new ForVarOfStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(928);
				match(KEYWORD_FOR);
				setState(929);
				match(BRACKET_LEFT_PAREN);
				setState(930);
				match(KEYWORD_VAR);
				setState(931);
				((ForVarOfStatementContext)_localctx).left = forBinding();
				setState(932);
				match(KEYWORD_OF);
				setState(933);
				((ForVarOfStatementContext)_localctx).right = assignmentExpression();
				setState(934);
				match(BRACKET_RIGHT_PAREN);
				setState(935);
				((ForVarOfStatementContext)_localctx).body = statement();
				}
				break;
			case 11:
				_localctx = new ForCLOfStatementContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(937);
				match(KEYWORD_FOR);
				setState(938);
				match(BRACKET_LEFT_PAREN);
				setState(939);
				((ForCLOfStatementContext)_localctx).left = forDeclaration();
				setState(940);
				match(KEYWORD_OF);
				setState(941);
				((ForCLOfStatementContext)_localctx).right = assignmentExpression();
				setState(942);
				match(BRACKET_RIGHT_PAREN);
				setState(943);
				((ForCLOfStatementContext)_localctx).body = statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForDeclarationContext extends ParserRuleContext {
		public LetOrConstContext letOrConst() {
			return getRuleContext(LetOrConstContext.class,0);
		}
		public ForBindingContext forBinding() {
			return getRuleContext(ForBindingContext.class,0);
		}
		public ForDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterForDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitForDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitForDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForDeclarationContext forDeclaration() throws RecognitionException {
		ForDeclarationContext _localctx = new ForDeclarationContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_forDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(947);
			letOrConst();
			setState(948);
			forBinding();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForBindingContext extends ParserRuleContext {
		public BindingIdentifierContext bindingIdentifier() {
			return getRuleContext(BindingIdentifierContext.class,0);
		}
		public BindingPatternContext bindingPattern() {
			return getRuleContext(BindingPatternContext.class,0);
		}
		public ForBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterForBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitForBinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitForBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForBindingContext forBinding() throws RecognitionException {
		ForBindingContext _localctx = new ForBindingContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_forBinding);
		try {
			setState(952);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(950);
				bindingIdentifier();
				}
				break;
			case BRACKET_LEFT_CURLY:
			case BRACKET_LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(951);
				bindingPattern();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode KEYWORD_CONTINUE() { return getToken(ECMAScript6Parser.KEYWORD_CONTINUE, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public LabelIdentifierContext labelIdentifier() {
			return getRuleContext(LabelIdentifierContext.class,0);
		}
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(954);
			match(KEYWORD_CONTINUE);
			setState(956);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				{
				setState(955);
				labelIdentifier();
				}
				break;
			}
			setState(958);
			eos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode KEYWORD_BREAK() { return getToken(ECMAScript6Parser.KEYWORD_BREAK, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public LabelIdentifierContext labelIdentifier() {
			return getRuleContext(LabelIdentifierContext.class,0);
		}
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(960);
			match(KEYWORD_BREAK);
			setState(962);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				{
				setState(961);
				labelIdentifier();
				}
				break;
			}
			setState(964);
			eos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode KEYWORD_RETURN() { return getToken(ECMAScript6Parser.KEYWORD_RETURN, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(966);
			match(KEYWORD_RETURN);
			setState(968);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				{
				setState(967);
				expressionSequence();
				}
				break;
			}
			setState(970);
			eos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WithStatementContext extends ParserRuleContext {
		public ExpressionSequenceContext object;
		public StatementContext body;
		public TerminalNode KEYWORD_WITH() { return getToken(ECMAScript6Parser.KEYWORD_WITH, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WithStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterWithStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitWithStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitWithStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithStatementContext withStatement() throws RecognitionException {
		WithStatementContext _localctx = new WithStatementContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_withStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(972);
			match(KEYWORD_WITH);
			setState(973);
			match(BRACKET_LEFT_PAREN);
			setState(974);
			((WithStatementContext)_localctx).object = expressionSequence();
			setState(975);
			match(BRACKET_RIGHT_PAREN);
			setState(976);
			((WithStatementContext)_localctx).body = statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode KEYWORD_SWITCH() { return getToken(ECMAScript6Parser.KEYWORD_SWITCH, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public CaseBlockContext caseBlock() {
			return getRuleContext(CaseBlockContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitSwitchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_switchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(978);
			match(KEYWORD_SWITCH);
			setState(979);
			match(BRACKET_LEFT_PAREN);
			setState(980);
			expressionSequence();
			setState(981);
			match(BRACKET_RIGHT_PAREN);
			setState(982);
			caseBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseBlockContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_LEFT_CURLY, 0); }
		public TerminalNode BRACKET_RIGHT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_CURLY, 0); }
		public List<CaseClausesContext> caseClauses() {
			return getRuleContexts(CaseClausesContext.class);
		}
		public CaseClausesContext caseClauses(int i) {
			return getRuleContext(CaseClausesContext.class,i);
		}
		public DefaultClauseContext defaultClause() {
			return getRuleContext(DefaultClauseContext.class,0);
		}
		public CaseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterCaseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitCaseBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitCaseBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseBlockContext caseBlock() throws RecognitionException {
		CaseBlockContext _localctx = new CaseBlockContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_caseBlock);
		int _la;
		try {
			setState(999);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(984);
				match(BRACKET_LEFT_CURLY);
				setState(986);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KEYWORD_CASE) {
					{
					setState(985);
					caseClauses(0);
					}
				}

				setState(988);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(989);
				match(BRACKET_LEFT_CURLY);
				setState(991);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KEYWORD_CASE) {
					{
					setState(990);
					caseClauses(0);
					}
				}

				setState(993);
				defaultClause();
				setState(995);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KEYWORD_CASE) {
					{
					setState(994);
					caseClauses(0);
					}
				}

				setState(997);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseClausesContext extends ParserRuleContext {
		public CaseClauseContext caseClause() {
			return getRuleContext(CaseClauseContext.class,0);
		}
		public CaseClausesContext caseClauses() {
			return getRuleContext(CaseClausesContext.class,0);
		}
		public CaseClausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseClauses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterCaseClauses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitCaseClauses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitCaseClauses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseClausesContext caseClauses() throws RecognitionException {
		return caseClauses(0);
	}

	private CaseClausesContext caseClauses(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CaseClausesContext _localctx = new CaseClausesContext(_ctx, _parentState);
		CaseClausesContext _prevctx = _localctx;
		int _startState = 162;
		enterRecursionRule(_localctx, 162, RULE_caseClauses, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1002);
			caseClause();
			}
			_ctx.stop = _input.LT(-1);
			setState(1008);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CaseClausesContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_caseClauses);
					setState(1004);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1005);
					caseClause();
					}
					}
				}
				setState(1010);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseClauseContext extends ParserRuleContext {
		public TerminalNode KEYWORD_CASE() { return getToken(ECMAScript6Parser.KEYWORD_CASE, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode PUNCTUATOR_COLON() { return getToken(ECMAScript6Parser.PUNCTUATOR_COLON, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public CaseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterCaseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitCaseClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitCaseClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseClauseContext caseClause() throws RecognitionException {
		CaseClauseContext _localctx = new CaseClauseContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_caseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1011);
			match(KEYWORD_CASE);
			setState(1012);
			expressionSequence();
			setState(1013);
			match(PUNCTUATOR_COLON);
			setState(1015);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(1014);
				statementList();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultClauseContext extends ParserRuleContext {
		public TerminalNode KEYWORD_DEFAULT() { return getToken(ECMAScript6Parser.KEYWORD_DEFAULT, 0); }
		public TerminalNode PUNCTUATOR_COLON() { return getToken(ECMAScript6Parser.PUNCTUATOR_COLON, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public DefaultClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterDefaultClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitDefaultClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitDefaultClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultClauseContext defaultClause() throws RecognitionException {
		DefaultClauseContext _localctx = new DefaultClauseContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_defaultClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1017);
			match(KEYWORD_DEFAULT);
			setState(1018);
			match(PUNCTUATOR_COLON);
			setState(1020);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				{
				setState(1019);
				statementList();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabelledStatementContext extends ParserRuleContext {
		public LabelIdentifierContext labelIdentifier() {
			return getRuleContext(LabelIdentifierContext.class,0);
		}
		public TerminalNode PUNCTUATOR_COLON() { return getToken(ECMAScript6Parser.PUNCTUATOR_COLON, 0); }
		public LabelledItemContext labelledItem() {
			return getRuleContext(LabelledItemContext.class,0);
		}
		public LabelledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterLabelledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitLabelledStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitLabelledStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelledStatementContext labelledStatement() throws RecognitionException {
		LabelledStatementContext _localctx = new LabelledStatementContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_labelledStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1022);
			labelIdentifier();
			setState(1023);
			match(PUNCTUATOR_COLON);
			setState(1024);
			labelledItem();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabelledItemContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public LabelledItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelledItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterLabelledItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitLabelledItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitLabelledItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelledItemContext labelledItem() throws RecognitionException {
		LabelledItemContext _localctx = new LabelledItemContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_labelledItem);
		try {
			setState(1028);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1026);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1027);
				functionDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ThrowStatementContext extends ParserRuleContext {
		public TerminalNode KEYWORD_THROW() { return getToken(ECMAScript6Parser.KEYWORD_THROW, 0); }
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitThrowStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitThrowStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1030);
			match(KEYWORD_THROW);
			setState(1031);
			expressionSequence();
			setState(1032);
			eos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TryStatementContext extends ParserRuleContext {
		public TerminalNode KEYWORD_TRY() { return getToken(ECMAScript6Parser.KEYWORD_TRY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchBlockContext catchBlock() {
			return getRuleContext(CatchBlockContext.class,0);
		}
		public FinallyBlockContext finallyBlock() {
			return getRuleContext(FinallyBlockContext.class,0);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterTryStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitTryStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitTryStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_tryStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1034);
			match(KEYWORD_TRY);
			setState(1035);
			block();
			setState(1041);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				{
				setState(1036);
				catchBlock();
				}
				break;
			case 2:
				{
				setState(1037);
				finallyBlock();
				}
				break;
			case 3:
				{
				setState(1038);
				catchBlock();
				setState(1039);
				finallyBlock();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CatchBlockContext extends ParserRuleContext {
		public TerminalNode KEYWORD_CATCH() { return getToken(ECMAScript6Parser.KEYWORD_CATCH, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public CatchParameterContext catchParameter() {
			return getRuleContext(CatchParameterContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterCatchBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitCatchBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitCatchBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchBlockContext catchBlock() throws RecognitionException {
		CatchBlockContext _localctx = new CatchBlockContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_catchBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1043);
			match(KEYWORD_CATCH);
			setState(1044);
			match(BRACKET_LEFT_PAREN);
			setState(1045);
			catchParameter();
			setState(1046);
			match(BRACKET_RIGHT_PAREN);
			setState(1047);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FinallyBlockContext extends ParserRuleContext {
		public TerminalNode KEYWORD_FINALLY() { return getToken(ECMAScript6Parser.KEYWORD_FINALLY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterFinallyBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitFinallyBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitFinallyBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinallyBlockContext finallyBlock() throws RecognitionException {
		FinallyBlockContext _localctx = new FinallyBlockContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_finallyBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1049);
			match(KEYWORD_FINALLY);
			setState(1050);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CatchParameterContext extends ParserRuleContext {
		public BindingIdentifierContext bindingIdentifier() {
			return getRuleContext(BindingIdentifierContext.class,0);
		}
		public BindingPatternContext bindingPattern() {
			return getRuleContext(BindingPatternContext.class,0);
		}
		public CatchParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterCatchParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitCatchParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitCatchParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchParameterContext catchParameter() throws RecognitionException {
		CatchParameterContext _localctx = new CatchParameterContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_catchParameter);
		try {
			setState(1054);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1052);
				bindingIdentifier();
				}
				break;
			case BRACKET_LEFT_CURLY:
			case BRACKET_LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1053);
				bindingPattern();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DebuggerStatementContext extends ParserRuleContext {
		public TerminalNode KEYWORD_DEBUGGER() { return getToken(ECMAScript6Parser.KEYWORD_DEBUGGER, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public DebuggerStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_debuggerStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterDebuggerStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitDebuggerStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitDebuggerStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DebuggerStatementContext debuggerStatement() throws RecognitionException {
		DebuggerStatementContext _localctx = new DebuggerStatementContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_debuggerStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1056);
			match(KEYWORD_DEBUGGER);
			setState(1057);
			eos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public String idName = null;
		public TerminalNode KEYWORD_FUNCTION() { return getToken(ECMAScript6Parser.KEYWORD_FUNCTION, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public TerminalNode BRACKET_LEFT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_LEFT_CURLY, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_CURLY, 0); }
		public BindingIdentifierContext bindingIdentifier() {
			return getRuleContext(BindingIdentifierContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1059);
			match(KEYWORD_FUNCTION);
			setState(1061);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1060);
				bindingIdentifier();
				}
			}

			setState(1063);
			match(BRACKET_LEFT_PAREN);
			setState(1064);
			formalParameters();
			setState(1065);
			match(BRACKET_RIGHT_PAREN);
			setState(1066);
			match(BRACKET_LEFT_CURLY);
			setState(1067);
			functionBody();
			setState(1068);
			match(BRACKET_RIGHT_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StrictFormalParametersContext extends ParserRuleContext {
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public StrictFormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strictFormalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterStrictFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitStrictFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitStrictFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrictFormalParametersContext strictFormalParameters() throws RecognitionException {
		StrictFormalParametersContext _localctx = new StrictFormalParametersContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_strictFormalParameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1070);
			formalParameters();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParametersContext extends ParserRuleContext {
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1073);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 55)) & ~0x3f) == 0 && ((1L << (_la - 55)) & 4611686018427387941L) != 0)) {
				{
				setState(1072);
				formalParameterList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterListContext extends ParserRuleContext {
		public FunctionRestParameterContext functionRestParameter() {
			return getRuleContext(FunctionRestParameterContext.class,0);
		}
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_formalParameterList);
		int _la;
		try {
			int _alt;
			setState(1088);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PUNCTUATOR_ELLIPSIS:
				enterOuterAlt(_localctx, 1);
				{
				setState(1075);
				functionRestParameter();
				}
				break;
			case BRACKET_LEFT_CURLY:
			case BRACKET_LEFT_BRACKET:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1076);
				formalParameter();
				setState(1081);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1077);
						match(PUNCTUATOR_COMMA);
						setState(1078);
						formalParameter();
						}
						}
					}
					setState(1083);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
				}
				setState(1086);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNCTUATOR_COMMA) {
					{
					setState(1084);
					match(PUNCTUATOR_COMMA);
					setState(1085);
					functionRestParameter();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionRestParameterContext extends ParserRuleContext {
		public BindingRestElementContext bindingRestElement() {
			return getRuleContext(BindingRestElementContext.class,0);
		}
		public FunctionRestParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionRestParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterFunctionRestParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitFunctionRestParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitFunctionRestParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionRestParameterContext functionRestParameter() throws RecognitionException {
		FunctionRestParameterContext _localctx = new FunctionRestParameterContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_functionRestParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1090);
			bindingRestElement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterContext extends ParserRuleContext {
		public BindingElementContext bindingElement() {
			return getRuleContext(BindingElementContext.class,0);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1092);
			bindingElement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionBodyContext extends ParserRuleContext {
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitFunctionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitFunctionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_functionBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1095);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				{
				setState(1094);
				statementList();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrowFunctionContext extends ParserRuleContext {
		public ArrowParametersContext arrowParameters() {
			return getRuleContext(ArrowParametersContext.class,0);
		}
		public TerminalNode PUNCTUATOR_ARROW() { return getToken(ECMAScript6Parser.PUNCTUATOR_ARROW, 0); }
		public ConciseBodyContext conciseBody() {
			return getRuleContext(ConciseBodyContext.class,0);
		}
		public ArrowFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrowFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterArrowFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitArrowFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitArrowFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrowFunctionContext arrowFunction() throws RecognitionException {
		ArrowFunctionContext _localctx = new ArrowFunctionContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_arrowFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1097);
			arrowParameters();
			setState(1098);
			match(PUNCTUATOR_ARROW);
			setState(1099);
			conciseBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrowParametersContext extends ParserRuleContext {
		public BindingIdentifierContext bindingIdentifier() {
			return getRuleContext(BindingIdentifierContext.class,0);
		}
		public AssignmentPatternContext assignmentPattern() {
			return getRuleContext(AssignmentPatternContext.class,0);
		}
		public CoverParenthesizedExpressionAndArrowParameterListContext coverParenthesizedExpressionAndArrowParameterList() {
			return getRuleContext(CoverParenthesizedExpressionAndArrowParameterListContext.class,0);
		}
		public ArrowParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrowParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterArrowParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitArrowParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitArrowParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrowParametersContext arrowParameters() throws RecognitionException {
		ArrowParametersContext _localctx = new ArrowParametersContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_arrowParameters);
		try {
			setState(1104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1101);
				bindingIdentifier();
				}
				break;
			case BRACKET_LEFT_CURLY:
			case BRACKET_LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1102);
				assignmentPattern();
				}
				break;
			case BRACKET_LEFT_PAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(1103);
				coverParenthesizedExpressionAndArrowParameterList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConciseBodyContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode BRACKET_LEFT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_LEFT_CURLY, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_CURLY, 0); }
		public ConciseBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conciseBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterConciseBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitConciseBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitConciseBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConciseBodyContext conciseBody() throws RecognitionException {
		ConciseBodyContext _localctx = new ConciseBodyContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_conciseBody);
		try {
			setState(1111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1106);
				assignmentExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1107);
				match(BRACKET_LEFT_CURLY);
				setState(1108);
				functionBody();
				setState(1109);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDefinitionContext extends ParserRuleContext {
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public StrictFormalParametersContext strictFormalParameters() {
			return getRuleContext(StrictFormalParametersContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public TerminalNode BRACKET_LEFT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_LEFT_CURLY, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_CURLY, 0); }
		public GeneratorMethodContext generatorMethod() {
			return getRuleContext(GeneratorMethodContext.class,0);
		}
		public GetterPrefixContext getterPrefix() {
			return getRuleContext(GetterPrefixContext.class,0);
		}
		public SetterPrefixContext setterPrefix() {
			return getRuleContext(SetterPrefixContext.class,0);
		}
		public PropertySetParameterListContext propertySetParameterList() {
			return getRuleContext(PropertySetParameterListContext.class,0);
		}
		public MethodDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterMethodDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitMethodDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitMethodDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDefinitionContext methodDefinition() throws RecognitionException {
		MethodDefinitionContext _localctx = new MethodDefinitionContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_methodDefinition);
		try {
			setState(1139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1113);
				propertyName();
				setState(1114);
				match(BRACKET_LEFT_PAREN);
				setState(1115);
				strictFormalParameters();
				setState(1116);
				match(BRACKET_RIGHT_PAREN);
				setState(1117);
				match(BRACKET_LEFT_CURLY);
				setState(1118);
				functionBody();
				setState(1119);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1121);
				generatorMethod();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1122);
				getterPrefix();
				setState(1123);
				propertyName();
				setState(1124);
				match(BRACKET_LEFT_PAREN);
				setState(1125);
				match(BRACKET_RIGHT_PAREN);
				setState(1126);
				match(BRACKET_LEFT_CURLY);
				setState(1127);
				functionBody();
				setState(1128);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1130);
				setterPrefix();
				setState(1131);
				propertyName();
				setState(1132);
				match(BRACKET_LEFT_PAREN);
				setState(1133);
				propertySetParameterList();
				setState(1134);
				match(BRACKET_RIGHT_PAREN);
				setState(1135);
				match(BRACKET_LEFT_CURLY);
				setState(1136);
				functionBody();
				setState(1137);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GetterPrefixContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public GetterPrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getterPrefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterGetterPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitGetterPrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitGetterPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetterPrefixContext getterPrefix() throws RecognitionException {
		GetterPrefixContext _localctx = new GetterPrefixContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_getterPrefix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1141);
			if (!("get".equals(_input.LT(1).getText()))) throw new FailedPredicateException(this, "\"get\".equals(_input.LT(1).getText())");
			setState(1142);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetterPrefixContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public SetterPrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setterPrefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterSetterPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitSetterPrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitSetterPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetterPrefixContext setterPrefix() throws RecognitionException {
		SetterPrefixContext _localctx = new SetterPrefixContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_setterPrefix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1144);
			if (!("set".equals(_input.LT(1).getText()))) throw new FailedPredicateException(this, "\"set\".equals(_input.LT(1).getText())");
			setState(1145);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertySetParameterListContext extends ParserRuleContext {
		public FormalParameterContext formalParameter() {
			return getRuleContext(FormalParameterContext.class,0);
		}
		public PropertySetParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertySetParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterPropertySetParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitPropertySetParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitPropertySetParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertySetParameterListContext propertySetParameterList() throws RecognitionException {
		PropertySetParameterListContext _localctx = new PropertySetParameterListContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_propertySetParameterList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1147);
			formalParameter();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GeneratorMethodContext extends ParserRuleContext {
		public TerminalNode PUNCTUATOR_MULTIPLICATION() { return getToken(ECMAScript6Parser.PUNCTUATOR_MULTIPLICATION, 0); }
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public StrictFormalParametersContext strictFormalParameters() {
			return getRuleContext(StrictFormalParametersContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public TerminalNode BRACKET_LEFT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_LEFT_CURLY, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_CURLY, 0); }
		public GeneratorMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generatorMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterGeneratorMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitGeneratorMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitGeneratorMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneratorMethodContext generatorMethod() throws RecognitionException {
		GeneratorMethodContext _localctx = new GeneratorMethodContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_generatorMethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1149);
			match(PUNCTUATOR_MULTIPLICATION);
			setState(1150);
			propertyName();
			setState(1151);
			match(BRACKET_LEFT_PAREN);
			setState(1152);
			strictFormalParameters();
			setState(1153);
			match(BRACKET_RIGHT_PAREN);
			setState(1154);
			match(BRACKET_LEFT_CURLY);
			setState(1155);
			functionBody();
			setState(1156);
			match(BRACKET_RIGHT_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GeneratorDeclarationContext extends ParserRuleContext {
		public TerminalNode KEYWORD_FUNCTION() { return getToken(ECMAScript6Parser.KEYWORD_FUNCTION, 0); }
		public TerminalNode PUNCTUATOR_MULTIPLICATION() { return getToken(ECMAScript6Parser.PUNCTUATOR_MULTIPLICATION, 0); }
		public TerminalNode BRACKET_LEFT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_LEFT_PAREN, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_PAREN() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_PAREN, 0); }
		public TerminalNode BRACKET_LEFT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_LEFT_CURLY, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_CURLY, 0); }
		public BindingIdentifierContext bindingIdentifier() {
			return getRuleContext(BindingIdentifierContext.class,0);
		}
		public GeneratorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generatorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterGeneratorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitGeneratorDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitGeneratorDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneratorDeclarationContext generatorDeclaration() throws RecognitionException {
		GeneratorDeclarationContext _localctx = new GeneratorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_generatorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1158);
			match(KEYWORD_FUNCTION);
			setState(1159);
			match(PUNCTUATOR_MULTIPLICATION);
			setState(1161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1160);
				bindingIdentifier();
				}
			}

			setState(1163);
			match(BRACKET_LEFT_PAREN);
			setState(1164);
			formalParameters();
			setState(1165);
			match(BRACKET_RIGHT_PAREN);
			setState(1166);
			match(BRACKET_LEFT_CURLY);
			setState(1167);
			functionBody();
			setState(1168);
			match(BRACKET_RIGHT_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YieldExpressionContext extends ParserRuleContext {
		public TerminalNode KEYWORD_YIELD() { return getToken(ECMAScript6Parser.KEYWORD_YIELD, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode PUNCTUATOR_MULTIPLICATION() { return getToken(ECMAScript6Parser.PUNCTUATOR_MULTIPLICATION, 0); }
		public YieldExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yieldExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterYieldExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitYieldExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitYieldExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YieldExpressionContext yieldExpression() throws RecognitionException {
		YieldExpressionContext _localctx = new YieldExpressionContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_yieldExpression);
		try {
			setState(1176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1170);
				match(KEYWORD_YIELD);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1171);
				match(KEYWORD_YIELD);
				setState(1172);
				assignmentExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1173);
				match(KEYWORD_YIELD);
				setState(1174);
				match(PUNCTUATOR_MULTIPLICATION);
				setState(1175);
				assignmentExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationContext extends ParserRuleContext {
		public BindingIdentifierContext id;
		public LeftHandSideExpressionContext extend;
		public TerminalNode KEYWORD_CLASS() { return getToken(ECMAScript6Parser.KEYWORD_CLASS, 0); }
		public TerminalNode BRACKET_LEFT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_LEFT_CURLY, 0); }
		public TerminalNode BRACKET_RIGHT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_CURLY, 0); }
		public TerminalNode KEYWORD_EXTENDS() { return getToken(ECMAScript6Parser.KEYWORD_EXTENDS, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public BindingIdentifierContext bindingIdentifier() {
			return getRuleContext(BindingIdentifierContext.class,0);
		}
		public LeftHandSideExpressionContext leftHandSideExpression() {
			return getRuleContext(LeftHandSideExpressionContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1178);
			match(KEYWORD_CLASS);
			setState(1180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1179);
				((ClassDeclarationContext)_localctx).id = bindingIdentifier();
				}
			}

			setState(1184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_EXTENDS) {
				{
				setState(1182);
				match(KEYWORD_EXTENDS);
				setState(1183);
				((ClassDeclarationContext)_localctx).extend = leftHandSideExpression();
				}
			}

			setState(1186);
			match(BRACKET_LEFT_CURLY);
			setState(1188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				{
				setState(1187);
				classBody();
				}
				break;
			}
			setState(1190);
			match(BRACKET_RIGHT_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassElementContext> classElement() {
			return getRuleContexts(ClassElementContext.class);
		}
		public ClassElementContext classElement(int i) {
			return getRuleContext(ClassElementContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_classBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1193);
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1192);
					classElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassElementContext extends ParserRuleContext {
		public MethodDefinitionContext methodDefinition() {
			return getRuleContext(MethodDefinitionContext.class,0);
		}
		public TerminalNode RESERVED_STATIC() { return getToken(ECMAScript6Parser.RESERVED_STATIC, 0); }
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public ClassElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterClassElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitClassElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitClassElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassElementContext classElement() throws RecognitionException {
		ClassElementContext _localctx = new ClassElementContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_classElement);
		try {
			setState(1201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1197);
				methodDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1198);
				match(RESERVED_STATIC);
				setState(1199);
				methodDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1200);
				emptyStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ECMAScript6Parser.EOF, 0); }
		public SourceElementsContext sourceElements() {
			return getRuleContext(SourceElementsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				{
				setState(1203);
				sourceElements();
				}
				break;
			}
			setState(1206);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SourceElementsContext extends ParserRuleContext {
		public List<SourceElementContext> sourceElement() {
			return getRuleContexts(SourceElementContext.class);
		}
		public SourceElementContext sourceElement(int i) {
			return getRuleContext(SourceElementContext.class,i);
		}
		public SourceElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterSourceElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitSourceElements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitSourceElements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceElementsContext sourceElements() throws RecognitionException {
		SourceElementsContext _localctx = new SourceElementsContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_sourceElements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1209);
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1208);
					sourceElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SourceElementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ImportDeclarationContext importDeclaration() {
			return getRuleContext(ImportDeclarationContext.class,0);
		}
		public ExportDeclarationContext exportDeclaration() {
			return getRuleContext(ExportDeclarationContext.class,0);
		}
		public SourceElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterSourceElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitSourceElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitSourceElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceElementContext sourceElement() throws RecognitionException {
		SourceElementContext _localctx = new SourceElementContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_sourceElement);
		try {
			setState(1217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1213);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1214);
				declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1215);
				importDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1216);
				exportDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportDeclarationContext extends ParserRuleContext {
		public TerminalNode KEYWORD_IMPORT() { return getToken(ECMAScript6Parser.KEYWORD_IMPORT, 0); }
		public ImportClauseContext importClause() {
			return getRuleContext(ImportClauseContext.class,0);
		}
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public TerminalNode PUNCTUATOR_SEMICOLON() { return getToken(ECMAScript6Parser.PUNCTUATOR_SEMICOLON, 0); }
		public ModuleSpecifierContext moduleSpecifier() {
			return getRuleContext(ModuleSpecifierContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_importDeclaration);
		try {
			setState(1228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1219);
				match(KEYWORD_IMPORT);
				setState(1220);
				importClause();
				setState(1221);
				fromClause();
				setState(1222);
				match(PUNCTUATOR_SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1224);
				match(KEYWORD_IMPORT);
				setState(1225);
				moduleSpecifier();
				setState(1226);
				match(PUNCTUATOR_SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportClauseContext extends ParserRuleContext {
		public ImportedDefaultBindingContext importedDefaultBinding() {
			return getRuleContext(ImportedDefaultBindingContext.class,0);
		}
		public NameSpaceImportContext nameSpaceImport() {
			return getRuleContext(NameSpaceImportContext.class,0);
		}
		public NamedImportsContext namedImports() {
			return getRuleContext(NamedImportsContext.class,0);
		}
		public TerminalNode PUNCTUATOR_COMMA() { return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, 0); }
		public ImportClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterImportClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitImportClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitImportClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportClauseContext importClause() throws RecognitionException {
		ImportClauseContext _localctx = new ImportClauseContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_importClause);
		try {
			setState(1241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1230);
				importedDefaultBinding();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1231);
				nameSpaceImport();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1232);
				namedImports();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1233);
				importedDefaultBinding();
				setState(1234);
				match(PUNCTUATOR_COMMA);
				setState(1235);
				nameSpaceImport();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1237);
				importedDefaultBinding();
				setState(1238);
				match(PUNCTUATOR_COMMA);
				setState(1239);
				namedImports();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportedDefaultBindingContext extends ParserRuleContext {
		public ImportedBindingContext importedBinding() {
			return getRuleContext(ImportedBindingContext.class,0);
		}
		public ImportedDefaultBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importedDefaultBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterImportedDefaultBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitImportedDefaultBinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitImportedDefaultBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportedDefaultBindingContext importedDefaultBinding() throws RecognitionException {
		ImportedDefaultBindingContext _localctx = new ImportedDefaultBindingContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_importedDefaultBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1243);
			importedBinding();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NameSpaceImportContext extends ParserRuleContext {
		public TerminalNode PUNCTUATOR_MULTIPLICATION() { return getToken(ECMAScript6Parser.PUNCTUATOR_MULTIPLICATION, 0); }
		public TerminalNode RESERVED_AS() { return getToken(ECMAScript6Parser.RESERVED_AS, 0); }
		public ImportedBindingContext importedBinding() {
			return getRuleContext(ImportedBindingContext.class,0);
		}
		public NameSpaceImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameSpaceImport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterNameSpaceImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitNameSpaceImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitNameSpaceImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameSpaceImportContext nameSpaceImport() throws RecognitionException {
		NameSpaceImportContext _localctx = new NameSpaceImportContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_nameSpaceImport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1245);
			match(PUNCTUATOR_MULTIPLICATION);
			setState(1246);
			match(RESERVED_AS);
			setState(1247);
			importedBinding();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NamedImportsContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_LEFT_CURLY, 0); }
		public TerminalNode BRACKET_RIGHT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_CURLY, 0); }
		public ImportsListContext importsList() {
			return getRuleContext(ImportsListContext.class,0);
		}
		public TerminalNode PUNCTUATOR_COMMA() { return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, 0); }
		public NamedImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedImports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterNamedImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitNamedImports(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitNamedImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedImportsContext namedImports() throws RecognitionException {
		NamedImportsContext _localctx = new NamedImportsContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_namedImports);
		try {
			setState(1260);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1249);
				match(BRACKET_LEFT_CURLY);
				setState(1250);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1251);
				match(BRACKET_LEFT_CURLY);
				setState(1252);
				importsList();
				setState(1253);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1255);
				match(BRACKET_LEFT_CURLY);
				setState(1256);
				importsList();
				setState(1257);
				match(PUNCTUATOR_COMMA);
				setState(1258);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FromClauseContext extends ParserRuleContext {
		public TerminalNode RESERVED_FROM() { return getToken(ECMAScript6Parser.RESERVED_FROM, 0); }
		public ModuleSpecifierContext moduleSpecifier() {
			return getRuleContext(ModuleSpecifierContext.class,0);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitFromClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitFromClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_fromClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1262);
			match(RESERVED_FROM);
			setState(1263);
			moduleSpecifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportsListContext extends ParserRuleContext {
		public List<ImportSpecifierContext> importSpecifier() {
			return getRuleContexts(ImportSpecifierContext.class);
		}
		public ImportSpecifierContext importSpecifier(int i) {
			return getRuleContext(ImportSpecifierContext.class,i);
		}
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public ImportsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterImportsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitImportsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitImportsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportsListContext importsList() throws RecognitionException {
		ImportsListContext _localctx = new ImportsListContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_importsList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1265);
			importSpecifier();
			setState(1270);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1266);
					match(PUNCTUATOR_COMMA);
					setState(1267);
					importSpecifier();
					}
					}
				}
				setState(1272);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportSpecifierContext extends ParserRuleContext {
		public ImportedBindingContext importedBinding() {
			return getRuleContext(ImportedBindingContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ECMAScript6Parser.IDENTIFIER, 0); }
		public TerminalNode RESERVED_AS() { return getToken(ECMAScript6Parser.RESERVED_AS, 0); }
		public ImportSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterImportSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitImportSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitImportSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportSpecifierContext importSpecifier() throws RecognitionException {
		ImportSpecifierContext _localctx = new ImportSpecifierContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_importSpecifier);
		try {
			setState(1277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1273);
				importedBinding();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1274);
				match(IDENTIFIER);
				setState(1275);
				match(RESERVED_AS);
				setState(1276);
				importedBinding();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleSpecifierContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ECMAScript6Parser.STRING, 0); }
		public ModuleSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterModuleSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitModuleSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitModuleSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleSpecifierContext moduleSpecifier() throws RecognitionException {
		ModuleSpecifierContext _localctx = new ModuleSpecifierContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_moduleSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1279);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportedBindingContext extends ParserRuleContext {
		public BindingIdentifierContext bindingIdentifier() {
			return getRuleContext(BindingIdentifierContext.class,0);
		}
		public ImportedBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importedBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterImportedBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitImportedBinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitImportedBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportedBindingContext importedBinding() throws RecognitionException {
		ImportedBindingContext _localctx = new ImportedBindingContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_importedBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1281);
			bindingIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExportDeclarationContext extends ParserRuleContext {
		public TerminalNode KEYWORD_EXPORT() { return getToken(ECMAScript6Parser.KEYWORD_EXPORT, 0); }
		public TerminalNode PUNCTUATOR_MULTIPLICATION() { return getToken(ECMAScript6Parser.PUNCTUATOR_MULTIPLICATION, 0); }
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public TerminalNode PUNCTUATOR_SEMICOLON() { return getToken(ECMAScript6Parser.PUNCTUATOR_SEMICOLON, 0); }
		public ExportClauseContext exportClause() {
			return getRuleContext(ExportClauseContext.class,0);
		}
		public VariableStatementContext variableStatement() {
			return getRuleContext(VariableStatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode KEYWORD_DEFAULT() { return getToken(ECMAScript6Parser.KEYWORD_DEFAULT, 0); }
		public HoistableDeclarationContext hoistableDeclaration() {
			return getRuleContext(HoistableDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ExportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exportDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterExportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitExportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitExportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExportDeclarationContext exportDeclaration() throws RecognitionException {
		ExportDeclarationContext _localctx = new ExportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_exportDeclaration);
		try {
			setState(1312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1283);
				match(KEYWORD_EXPORT);
				setState(1284);
				match(PUNCTUATOR_MULTIPLICATION);
				setState(1285);
				fromClause();
				setState(1286);
				match(PUNCTUATOR_SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1288);
				match(KEYWORD_EXPORT);
				setState(1289);
				exportClause();
				setState(1290);
				fromClause();
				setState(1291);
				match(PUNCTUATOR_SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1293);
				match(KEYWORD_EXPORT);
				setState(1294);
				exportClause();
				setState(1295);
				match(PUNCTUATOR_SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1297);
				match(KEYWORD_EXPORT);
				setState(1298);
				variableStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1299);
				match(KEYWORD_EXPORT);
				setState(1300);
				declaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1301);
				match(KEYWORD_EXPORT);
				setState(1302);
				match(KEYWORD_DEFAULT);
				setState(1303);
				hoistableDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1304);
				match(KEYWORD_EXPORT);
				setState(1305);
				match(KEYWORD_DEFAULT);
				setState(1306);
				classDeclaration();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1307);
				match(KEYWORD_EXPORT);
				setState(1308);
				match(KEYWORD_DEFAULT);
				setState(1309);
				assignmentExpression();
				setState(1310);
				match(PUNCTUATOR_SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExportClauseContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_LEFT_CURLY, 0); }
		public TerminalNode BRACKET_RIGHT_CURLY() { return getToken(ECMAScript6Parser.BRACKET_RIGHT_CURLY, 0); }
		public ExportsListContext exportsList() {
			return getRuleContext(ExportsListContext.class,0);
		}
		public TerminalNode PUNCTUATOR_COMMA() { return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, 0); }
		public ExportClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exportClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterExportClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitExportClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitExportClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExportClauseContext exportClause() throws RecognitionException {
		ExportClauseContext _localctx = new ExportClauseContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_exportClause);
		try {
			setState(1325);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1314);
				match(BRACKET_LEFT_CURLY);
				setState(1315);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1316);
				match(BRACKET_LEFT_CURLY);
				setState(1317);
				exportsList();
				setState(1318);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1320);
				match(BRACKET_LEFT_CURLY);
				setState(1321);
				exportsList();
				setState(1322);
				match(PUNCTUATOR_COMMA);
				setState(1323);
				match(BRACKET_RIGHT_CURLY);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExportsListContext extends ParserRuleContext {
		public List<ExportSpecifierContext> exportSpecifier() {
			return getRuleContexts(ExportSpecifierContext.class);
		}
		public ExportSpecifierContext exportSpecifier(int i) {
			return getRuleContext(ExportSpecifierContext.class,i);
		}
		public List<TerminalNode> PUNCTUATOR_COMMA() { return getTokens(ECMAScript6Parser.PUNCTUATOR_COMMA); }
		public TerminalNode PUNCTUATOR_COMMA(int i) {
			return getToken(ECMAScript6Parser.PUNCTUATOR_COMMA, i);
		}
		public ExportsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exportsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterExportsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitExportsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitExportsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExportsListContext exportsList() throws RecognitionException {
		ExportsListContext _localctx = new ExportsListContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_exportsList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1327);
			exportSpecifier();
			setState(1332);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1328);
					match(PUNCTUATOR_COMMA);
					setState(1329);
					exportSpecifier();
					}
					}
				}
				setState(1334);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExportSpecifierContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(ECMAScript6Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ECMAScript6Parser.IDENTIFIER, i);
		}
		public List<TerminalNode> KEYWORD_DEFAULT() { return getTokens(ECMAScript6Parser.KEYWORD_DEFAULT); }
		public TerminalNode KEYWORD_DEFAULT(int i) {
			return getToken(ECMAScript6Parser.KEYWORD_DEFAULT, i);
		}
		public TerminalNode RESERVED_AS() { return getToken(ECMAScript6Parser.RESERVED_AS, 0); }
		public ExportSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exportSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterExportSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitExportSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitExportSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExportSpecifierContext exportSpecifier() throws RecognitionException {
		ExportSpecifierContext _localctx = new ExportSpecifierContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_exportSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1335);
			_la = _input.LA(1);
			if ( !(_la==KEYWORD_DEFAULT || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RESERVED_AS) {
				{
				setState(1336);
				match(RESERVED_AS);
				setState(1337);
				_la = _input.LA(1);
				if ( !(_la==KEYWORD_DEFAULT || _la==IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReservedKeywordContext extends ParserRuleContext {
		public TerminalNode RESERVED_ENUM() { return getToken(ECMAScript6Parser.RESERVED_ENUM, 0); }
		public TerminalNode RESERVED_AWAIT() { return getToken(ECMAScript6Parser.RESERVED_AWAIT, 0); }
		public TerminalNode RESERVED_IMPLEMENTS() { return getToken(ECMAScript6Parser.RESERVED_IMPLEMENTS, 0); }
		public TerminalNode RESERVED_PACKAGE() { return getToken(ECMAScript6Parser.RESERVED_PACKAGE, 0); }
		public TerminalNode RESERVED_PROTECTED() { return getToken(ECMAScript6Parser.RESERVED_PROTECTED, 0); }
		public TerminalNode RESERVED_INTERFACE() { return getToken(ECMAScript6Parser.RESERVED_INTERFACE, 0); }
		public TerminalNode RESERVED_PRIVATE() { return getToken(ECMAScript6Parser.RESERVED_PRIVATE, 0); }
		public TerminalNode RESERVED_PUBLIC() { return getToken(ECMAScript6Parser.RESERVED_PUBLIC, 0); }
		public TerminalNode RESERVED_STATIC() { return getToken(ECMAScript6Parser.RESERVED_STATIC, 0); }
		public TerminalNode RESERVED_LET() { return getToken(ECMAScript6Parser.RESERVED_LET, 0); }
		public TerminalNode RESERVED_AS() { return getToken(ECMAScript6Parser.RESERVED_AS, 0); }
		public TerminalNode RESERVED_FROM() { return getToken(ECMAScript6Parser.RESERVED_FROM, 0); }
		public ReservedKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reservedKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterReservedKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitReservedKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitReservedKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReservedKeywordContext reservedKeyword() throws RecognitionException {
		ReservedKeywordContext _localctx = new ReservedKeywordContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_reservedKeyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1340);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 9005000231485440L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EosContext extends ParserRuleContext {
		public TerminalNode PUNCTUATOR_SEMICOLON() { return getToken(ECMAScript6Parser.PUNCTUATOR_SEMICOLON, 0); }
		public TerminalNode EOF() { return getToken(ECMAScript6Parser.EOF, 0); }
		public EosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).enterEos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ECMAScript6Listener ) ((ECMAScript6Listener)listener).exitEos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ECMAScript6Visitor ) return ((ECMAScript6Visitor<? extends T>)visitor).visitEos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EosContext eos() throws RecognitionException {
		EosContext _localctx = new EosContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_eos);
		try {
			setState(1345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1342);
				match(PUNCTUATOR_SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1343);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1344);
				if (!(_input.LA(1) == BRACKET_RIGHT_CURLY || _input.LA(1) == BRACKET_LEFT_CURLY || lineTerminatorAhead())) throw new FailedPredicateException(this, "_input.LA(1) == BRACKET_RIGHT_CURLY || _input.LA(1) == BRACKET_LEFT_CURLY || lineTerminatorAhead()");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return elementList_sempred((ElementListContext)_localctx, predIndex);
		case 23:
			return templateMiddleList_sempred((TemplateMiddleListContext)_localctx, predIndex);
		case 24:
			return memberExpression_sempred((MemberExpressionContext)_localctx, predIndex);
		case 26:
			return newTarget_sempred((NewTargetContext)_localctx, predIndex);
		case 34:
			return binaryExpression_sempred((BinaryExpressionContext)_localctx, predIndex);
		case 70:
			return expressionStatement_sempred((ExpressionStatementContext)_localctx, predIndex);
		case 81:
			return caseClauses_sempred((CaseClausesContext)_localctx, predIndex);
		case 103:
			return getterPrefix_sempred((GetterPrefixContext)_localctx, predIndex);
		case 104:
			return setterPrefix_sempred((SetterPrefixContext)_localctx, predIndex);
		case 130:
			return eos_sempred((EosContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean elementList_sempred(ElementListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return _input.LA(1) != BRACKET_RIGHT_BRACKET;
		case 1:
			return _input.LA(1) == BRACKET_RIGHT_BRACKET;
		case 2:
			return _input.LA(1) != BRACKET_RIGHT_BRACKET;
		case 3:
			return _input.LA(1) == BRACKET_RIGHT_BRACKET;
		}
		return true;
	}
	private boolean templateMiddleList_sempred(TemplateMiddleListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean memberExpression_sempred(MemberExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean newTarget_sempred(NewTargetContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return TARGET_IDENT.equals((((NewTargetContext)_localctx).ident!=null?((NewTargetContext)_localctx).ident.getText():null));
		}
		return true;
	}
	private boolean binaryExpression_sempred(BinaryExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 5);
		case 12:
			return precpred(_ctx, 4);
		case 13:
			return precpred(_ctx, 3);
		case 14:
			return precpred(_ctx, 2);
		case 15:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expressionStatement_sempred(ExpressionStatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return  _input.LA(1) != BRACKET_LEFT_CURLY && _input.LA(1) != KEYWORD_FUNCTION && _input.LA(1) != KEYWORD_CLASS && _input.LA(1) != RESERVED_LET ;
		}
		return true;
	}
	private boolean caseClauses_sempred(CaseClausesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean getterPrefix_sempred(GetterPrefixContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return "get".equals(_input.LT(1).getText());
		}
		return true;
	}
	private boolean setterPrefix_sempred(SetterPrefixContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return "set".equals(_input.LT(1).getText());
		}
		return true;
	}
	private boolean eos_sempred(EosContext _localctx, int predIndex) {
		switch (predIndex) {
		case 20:
			return _input.LA(1) == BRACKET_RIGHT_CURLY || _input.LA(1) == BRACKET_LEFT_CURLY || lineTerminatorAhead();
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001v\u0544\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"+
		"U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007Y\u0002"+
		"Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007^\u0002"+
		"_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007c\u0002"+
		"d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007h\u0002"+
		"i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007m\u0002"+
		"n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007r\u0002"+
		"s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007w\u0002"+
		"x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002{\u0007{\u0002|\u0007|\u0002"+
		"}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f\u0002\u0080\u0007\u0080"+
		"\u0002\u0081\u0007\u0081\u0002\u0082\u0007\u0082\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u011c\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u0123\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006\u0127\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u012f\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\t\u0138\b\t\u0001\t\u0001\t\u0003"+
		"\t\u013c\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0142\b\t\u0001\t"+
		"\u0001\t\u0003\t\u0146\b\t\u0005\t\u0148\b\t\n\t\f\t\u014b\t\t\u0001\n"+
		"\u0001\n\u0001\u000b\u0004\u000b\u0150\b\u000b\u000b\u000b\f\u000b\u0151"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0003\r\u015a\b\r\u0003"+
		"\r\u015c\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u0163\b\u000e\n\u000e\f\u000e\u0166\t\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u016f\b\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u0173\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0178\b\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u0189\b\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u018f\b\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0198"+
		"\b\u0017\n\u0017\f\u0017\u019b\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018"+
		"\u01a5\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018"+
		"\u01b1\b\u0018\n\u0018\f\u0018\u01b4\t\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003"+
		"\u0019\u01be\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01d4\b\u001b\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u01d8\b\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0003\u001d\u01dd\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003"+
		"\u001d\u01e2\b\u001d\u0001\u001d\u0005\u001d\u01e5\b\u001d\n\u001d\f\u001d"+
		"\u01e8\t\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u01ed\b"+
		"\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u01f3"+
		"\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0003\u001f\u01fb\b\u001f\u0001 \u0001 \u0003 \u01ff\b \u0001!"+
		"\u0001!\u0001!\u0003!\u0204\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\""+
		"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0005\"\u021e\b\"\n\"\f\"\u0221\t\"\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0003#\u0229\b#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u0236\b$\u0001%\u0001%\u0003"+
		"%\u023a\b%\u0001&\u0001&\u0001&\u0003&\u023f\b&\u0003&\u0241\b&\u0001"+
		"&\u0001&\u0001\'\u0001\'\u0003\'\u0247\b\'\u0001\'\u0003\'\u024a\b\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003"+
		"\'\u0255\b\'\u0001\'\u0003\'\u0258\b\'\u0001\'\u0001\'\u0003\'\u025c\b"+
		"\'\u0001(\u0001(\u0001(\u0005(\u0261\b(\n(\f(\u0264\t(\u0001)\u0001)\u0001"+
		")\u0005)\u0269\b)\n)\f)\u026c\t)\u0001*\u0003*\u026f\b*\u0001*\u0001*"+
		"\u0001+\u0001+\u0003+\u0275\b+\u0001+\u0001+\u0001+\u0001+\u0003+\u027b"+
		"\b+\u0001,\u0001,\u0003,\u027f\b,\u0001-\u0001-\u0001-\u0001.\u0001.\u0001"+
		".\u0005.\u0287\b.\n.\f.\u028a\t.\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0003"+
		"/\u029b\b/\u00010\u00010\u00010\u00030\u02a0\b0\u00011\u00011\u00031\u02a4"+
		"\b1\u00012\u00012\u00032\u02a8\b2\u00012\u00012\u00013\u00013\u00043\u02ae"+
		"\b3\u000b3\f3\u02af\u00014\u00014\u00014\u00014\u00015\u00015\u00016\u0001"+
		"6\u00016\u00056\u02bb\b6\n6\f6\u02be\t6\u00017\u00017\u00037\u02c2\b7"+
		"\u00017\u00017\u00037\u02c6\b7\u00037\u02c8\b7\u00018\u00018\u00018\u0001"+
		"8\u00019\u00019\u00019\u00059\u02d1\b9\n9\f9\u02d4\t9\u0001:\u0001:\u0003"+
		":\u02d8\b:\u0001:\u0001:\u0003:\u02dc\b:\u0001:\u0001:\u0003:\u02e0\b"+
		":\u0003:\u02e2\b:\u0001;\u0001;\u0003;\u02e6\b;\u0001<\u0001<\u0001<\u0001"+
		"<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0003<\u02f3\b<\u0001"+
		"=\u0001=\u0003=\u02f7\b=\u0001=\u0003=\u02fa\b=\u0001=\u0001=\u0001=\u0001"+
		"=\u0001=\u0001=\u0001=\u0001=\u0001=\u0003=\u0305\b=\u0001=\u0003=\u0308"+
		"\b=\u0001=\u0001=\u0003=\u030c\b=\u0001>\u0001>\u0001>\u0005>\u0311\b"+
		">\n>\f>\u0314\t>\u0001?\u0001?\u0001?\u0005?\u0319\b?\n?\f?\u031c\t?\u0001"+
		"@\u0003@\u031f\b@\u0001@\u0001@\u0001A\u0001A\u0001A\u0001A\u0001A\u0003"+
		"A\u0328\bA\u0001B\u0001B\u0001B\u0003B\u032d\bB\u0003B\u032f\bB\u0001"+
		"C\u0001C\u0003C\u0333\bC\u0001D\u0001D\u0001D\u0001E\u0001E\u0001F\u0001"+
		"F\u0001F\u0001F\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0003"+
		"G\u0345\bG\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001"+
		"H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0003H\u0358"+
		"\bH\u0001H\u0001H\u0003H\u035c\bH\u0001H\u0001H\u0003H\u0360\bH\u0001"+
		"H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0003H\u036a\bH\u0001"+
		"H\u0001H\u0003H\u036e\bH\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001"+
		"H\u0003H\u0377\bH\u0001H\u0001H\u0003H\u037b\bH\u0001H\u0001H\u0001H\u0001"+
		"H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001"+
		"H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001"+
		"H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001"+
		"H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001"+
		"H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0003"+
		"H\u03b2\bH\u0001I\u0001I\u0001I\u0001J\u0001J\u0003J\u03b9\bJ\u0001K\u0001"+
		"K\u0003K\u03bd\bK\u0001K\u0001K\u0001L\u0001L\u0003L\u03c3\bL\u0001L\u0001"+
		"L\u0001M\u0001M\u0003M\u03c9\bM\u0001M\u0001M\u0001N\u0001N\u0001N\u0001"+
		"N\u0001N\u0001N\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001P\u0001"+
		"P\u0003P\u03db\bP\u0001P\u0001P\u0001P\u0003P\u03e0\bP\u0001P\u0001P\u0003"+
		"P\u03e4\bP\u0001P\u0001P\u0003P\u03e8\bP\u0001Q\u0001Q\u0001Q\u0001Q\u0001"+
		"Q\u0005Q\u03ef\bQ\nQ\fQ\u03f2\tQ\u0001R\u0001R\u0001R\u0001R\u0003R\u03f8"+
		"\bR\u0001S\u0001S\u0001S\u0003S\u03fd\bS\u0001T\u0001T\u0001T\u0001T\u0001"+
		"U\u0001U\u0003U\u0405\bU\u0001V\u0001V\u0001V\u0001V\u0001W\u0001W\u0001"+
		"W\u0001W\u0001W\u0001W\u0001W\u0003W\u0412\bW\u0001X\u0001X\u0001X\u0001"+
		"X\u0001X\u0001X\u0001Y\u0001Y\u0001Y\u0001Z\u0001Z\u0003Z\u041f\bZ\u0001"+
		"[\u0001[\u0001[\u0001\\\u0001\\\u0003\\\u0426\b\\\u0001\\\u0001\\\u0001"+
		"\\\u0001\\\u0001\\\u0001\\\u0001\\\u0001]\u0001]\u0001^\u0003^\u0432\b"+
		"^\u0001_\u0001_\u0001_\u0001_\u0005_\u0438\b_\n_\f_\u043b\t_\u0001_\u0001"+
		"_\u0003_\u043f\b_\u0003_\u0441\b_\u0001`\u0001`\u0001a\u0001a\u0001b\u0003"+
		"b\u0448\bb\u0001c\u0001c\u0001c\u0001c\u0001d\u0001d\u0001d\u0003d\u0451"+
		"\bd\u0001e\u0001e\u0001e\u0001e\u0001e\u0003e\u0458\be\u0001f\u0001f\u0001"+
		"f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001"+
		"f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001"+
		"f\u0001f\u0001f\u0001f\u0003f\u0474\bf\u0001g\u0001g\u0001g\u0001h\u0001"+
		"h\u0001h\u0001i\u0001i\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001"+
		"j\u0001j\u0001j\u0001k\u0001k\u0001k\u0003k\u048a\bk\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001l\u0001l\u0001l\u0001l\u0001l\u0001"+
		"l\u0003l\u0499\bl\u0001m\u0001m\u0003m\u049d\bm\u0001m\u0001m\u0003m\u04a1"+
		"\bm\u0001m\u0001m\u0003m\u04a5\bm\u0001m\u0001m\u0001n\u0004n\u04aa\b"+
		"n\u000bn\fn\u04ab\u0001o\u0001o\u0001o\u0001o\u0003o\u04b2\bo\u0001p\u0003"+
		"p\u04b5\bp\u0001p\u0001p\u0001q\u0004q\u04ba\bq\u000bq\fq\u04bb\u0001"+
		"r\u0001r\u0001r\u0001r\u0003r\u04c2\br\u0001s\u0001s\u0001s\u0001s\u0001"+
		"s\u0001s\u0001s\u0001s\u0001s\u0003s\u04cd\bs\u0001t\u0001t\u0001t\u0001"+
		"t\u0001t\u0001t\u0001t\u0001t\u0001t\u0001t\u0001t\u0003t\u04da\bt\u0001"+
		"u\u0001u\u0001v\u0001v\u0001v\u0001v\u0001w\u0001w\u0001w\u0001w\u0001"+
		"w\u0001w\u0001w\u0001w\u0001w\u0001w\u0001w\u0003w\u04ed\bw\u0001x\u0001"+
		"x\u0001x\u0001y\u0001y\u0001y\u0005y\u04f5\by\ny\fy\u04f8\ty\u0001z\u0001"+
		"z\u0001z\u0001z\u0003z\u04fe\bz\u0001{\u0001{\u0001|\u0001|\u0001}\u0001"+
		"}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001"+
		"}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001"+
		"}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0003}\u0521\b}\u0001"+
		"~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001"+
		"~\u0003~\u052e\b~\u0001\u007f\u0001\u007f\u0001\u007f\u0005\u007f\u0533"+
		"\b\u007f\n\u007f\f\u007f\u0536\t\u007f\u0001\u0080\u0001\u0080\u0001\u0080"+
		"\u0003\u0080\u053b\b\u0080\u0001\u0081\u0001\u0081\u0001\u0082\u0001\u0082"+
		"\u0001\u0082\u0003\u0082\u0542\b\u0082\u0001\u0082\u0000\u0004.0D\u00a2"+
		"\u0083\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
		"\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0"+
		"\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8"+
		"\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0"+
		"\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8"+
		"\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0000\u000f\u0001\u0000hi\u0001\u0000"+
		"jn\u0001\u0000MN\u0006\u0000\n\n\u0012\u0012&&GHMNUV\u0002\u0000IJLL\u0001"+
		"\u0000GH\u0001\u0000OQ\u0003\u0000\t\t\r\r?B\u0001\u0000CF\u0001\u0000"+
		"RT\u0001\u0000WX\u0002\u0000KK[e\u0002\u0000\u0017\u001722\u0002\u0000"+
		"##uu\u0001\u0000)4\u0594\u0000\u0106\u0001\u0000\u0000\u0000\u0002\u0108"+
		"\u0001\u0000\u0000\u0000\u0004\u010a\u0001\u0000\u0000\u0000\u0006\u010c"+
		"\u0001\u0000\u0000\u0000\b\u010e\u0001\u0000\u0000\u0000\n\u011b\u0001"+
		"\u0000\u0000\u0000\f\u011d\u0001\u0000\u0000\u0000\u000e\u012e\u0001\u0000"+
		"\u0000\u0000\u0010\u0130\u0001\u0000\u0000\u0000\u0012\u013b\u0001\u0000"+
		"\u0000\u0000\u0014\u014c\u0001\u0000\u0000\u0000\u0016\u014f\u0001\u0000"+
		"\u0000\u0000\u0018\u0153\u0001\u0000\u0000\u0000\u001a\u0156\u0001\u0000"+
		"\u0000\u0000\u001c\u015f\u0001\u0000\u0000\u0000\u001e\u016e\u0001\u0000"+
		"\u0000\u0000 \u0172\u0001\u0000\u0000\u0000\"\u0177\u0001\u0000\u0000"+
		"\u0000$\u0179\u0001\u0000\u0000\u0000&\u017d\u0001\u0000\u0000\u0000("+
		"\u0180\u0001\u0000\u0000\u0000*\u0188\u0001\u0000\u0000\u0000,\u018e\u0001"+
		"\u0000\u0000\u0000.\u0190\u0001\u0000\u0000\u00000\u01a4\u0001\u0000\u0000"+
		"\u00002\u01bd\u0001\u0000\u0000\u00004\u01bf\u0001\u0000\u0000\u00006"+
		"\u01d3\u0001\u0000\u0000\u00008\u01d5\u0001\u0000\u0000\u0000:\u01dc\u0001"+
		"\u0000\u0000\u0000<\u01ec\u0001\u0000\u0000\u0000>\u01fa\u0001\u0000\u0000"+
		"\u0000@\u01fc\u0001\u0000\u0000\u0000B\u0203\u0001\u0000\u0000\u0000D"+
		"\u0205\u0001\u0000\u0000\u0000F\u0222\u0001\u0000\u0000\u0000H\u0235\u0001"+
		"\u0000\u0000\u0000J\u0239\u0001\u0000\u0000\u0000L\u023b\u0001\u0000\u0000"+
		"\u0000N\u025b\u0001\u0000\u0000\u0000P\u025d\u0001\u0000\u0000\u0000R"+
		"\u0265\u0001\u0000\u0000\u0000T\u026e\u0001\u0000\u0000\u0000V\u027a\u0001"+
		"\u0000\u0000\u0000X\u027c\u0001\u0000\u0000\u0000Z\u0280\u0001\u0000\u0000"+
		"\u0000\\\u0283\u0001\u0000\u0000\u0000^\u029a\u0001\u0000\u0000\u0000"+
		"`\u029f\u0001\u0000\u0000\u0000b\u02a3\u0001\u0000\u0000\u0000d\u02a5"+
		"\u0001\u0000\u0000\u0000f\u02ad\u0001\u0000\u0000\u0000h\u02b1\u0001\u0000"+
		"\u0000\u0000j\u02b5\u0001\u0000\u0000\u0000l\u02b7\u0001\u0000\u0000\u0000"+
		"n\u02c7\u0001\u0000\u0000\u0000p\u02c9\u0001\u0000\u0000\u0000r\u02cd"+
		"\u0001\u0000\u0000\u0000t\u02e1\u0001\u0000\u0000\u0000v\u02e5\u0001\u0000"+
		"\u0000\u0000x\u02f2\u0001\u0000\u0000\u0000z\u030b\u0001\u0000\u0000\u0000"+
		"|\u030d\u0001\u0000\u0000\u0000~\u0315\u0001\u0000\u0000\u0000\u0080\u031e"+
		"\u0001\u0000\u0000\u0000\u0082\u0327\u0001\u0000\u0000\u0000\u0084\u032e"+
		"\u0001\u0000\u0000\u0000\u0086\u0330\u0001\u0000\u0000\u0000\u0088\u0334"+
		"\u0001\u0000\u0000\u0000\u008a\u0337\u0001\u0000\u0000\u0000\u008c\u0339"+
		"\u0001\u0000\u0000\u0000\u008e\u033d\u0001\u0000\u0000\u0000\u0090\u03b1"+
		"\u0001\u0000\u0000\u0000\u0092\u03b3\u0001\u0000\u0000\u0000\u0094\u03b8"+
		"\u0001\u0000\u0000\u0000\u0096\u03ba\u0001\u0000\u0000\u0000\u0098\u03c0"+
		"\u0001\u0000\u0000\u0000\u009a\u03c6\u0001\u0000\u0000\u0000\u009c\u03cc"+
		"\u0001\u0000\u0000\u0000\u009e\u03d2\u0001\u0000\u0000\u0000\u00a0\u03e7"+
		"\u0001\u0000\u0000\u0000\u00a2\u03e9\u0001\u0000\u0000\u0000\u00a4\u03f3"+
		"\u0001\u0000\u0000\u0000\u00a6\u03f9\u0001\u0000\u0000\u0000\u00a8\u03fe"+
		"\u0001\u0000\u0000\u0000\u00aa\u0404\u0001\u0000\u0000\u0000\u00ac\u0406"+
		"\u0001\u0000\u0000\u0000\u00ae\u040a\u0001\u0000\u0000\u0000\u00b0\u0413"+
		"\u0001\u0000\u0000\u0000\u00b2\u0419\u0001\u0000\u0000\u0000\u00b4\u041e"+
		"\u0001\u0000\u0000\u0000\u00b6\u0420\u0001\u0000\u0000\u0000\u00b8\u0423"+
		"\u0001\u0000\u0000\u0000\u00ba\u042e\u0001\u0000\u0000\u0000\u00bc\u0431"+
		"\u0001\u0000\u0000\u0000\u00be\u0440\u0001\u0000\u0000\u0000\u00c0\u0442"+
		"\u0001\u0000\u0000\u0000\u00c2\u0444\u0001\u0000\u0000\u0000\u00c4\u0447"+
		"\u0001\u0000\u0000\u0000\u00c6\u0449\u0001\u0000\u0000\u0000\u00c8\u0450"+
		"\u0001\u0000\u0000\u0000\u00ca\u0457\u0001\u0000\u0000\u0000\u00cc\u0473"+
		"\u0001\u0000\u0000\u0000\u00ce\u0475\u0001\u0000\u0000\u0000\u00d0\u0478"+
		"\u0001\u0000\u0000\u0000\u00d2\u047b\u0001\u0000\u0000\u0000\u00d4\u047d"+
		"\u0001\u0000\u0000\u0000\u00d6\u0486\u0001\u0000\u0000\u0000\u00d8\u0498"+
		"\u0001\u0000\u0000\u0000\u00da\u049a\u0001\u0000\u0000\u0000\u00dc\u04a9"+
		"\u0001\u0000\u0000\u0000\u00de\u04b1\u0001\u0000\u0000\u0000\u00e0\u04b4"+
		"\u0001\u0000\u0000\u0000\u00e2\u04b9\u0001\u0000\u0000\u0000\u00e4\u04c1"+
		"\u0001\u0000\u0000\u0000\u00e6\u04cc\u0001\u0000\u0000\u0000\u00e8\u04d9"+
		"\u0001\u0000\u0000\u0000\u00ea\u04db\u0001\u0000\u0000\u0000\u00ec\u04dd"+
		"\u0001\u0000\u0000\u0000\u00ee\u04ec\u0001\u0000\u0000\u0000\u00f0\u04ee"+
		"\u0001\u0000\u0000\u0000\u00f2\u04f1\u0001\u0000\u0000\u0000\u00f4\u04fd"+
		"\u0001\u0000\u0000\u0000\u00f6\u04ff\u0001\u0000\u0000\u0000\u00f8\u0501"+
		"\u0001\u0000\u0000\u0000\u00fa\u0520\u0001\u0000\u0000\u0000\u00fc\u052d"+
		"\u0001\u0000\u0000\u0000\u00fe\u052f\u0001\u0000\u0000\u0000\u0100\u0537"+
		"\u0001\u0000\u0000\u0000\u0102\u053c\u0001\u0000\u0000\u0000\u0104\u0541"+
		"\u0001\u0000\u0000\u0000\u0106\u0107\u0007\u0000\u0000\u0000\u0107\u0001"+
		"\u0001\u0000\u0000\u0000\u0108\u0109\u0007\u0001\u0000\u0000\u0109\u0003"+
		"\u0001\u0000\u0000\u0000\u010a\u010b\u0005p\u0000\u0000\u010b\u0005\u0001"+
		"\u0000\u0000\u0000\u010c\u010d\u0005u\u0000\u0000\u010d\u0007\u0001\u0000"+
		"\u0000\u0000\u010e\u010f\u0005u\u0000\u0000\u010f\t\u0001\u0000\u0000"+
		"\u0000\u0110\u011c\u0005\"\u0000\u0000\u0111\u011c\u0005u\u0000\u0000"+
		"\u0112\u011c\u0003\u000e\u0007\u0000\u0113\u011c\u0003\u0010\b\u0000\u0114"+
		"\u011c\u0003\u001a\r\u0000\u0115\u011c\u0003\u00b8\\\u0000\u0116\u011c"+
		"\u0003\u00dam\u0000\u0117\u011c\u0003\u00d6k\u0000\u0118\u011c\u0003\u0004"+
		"\u0002\u0000\u0119\u011c\u0003*\u0015\u0000\u011a\u011c\u0003\f\u0006"+
		"\u0000\u011b\u0110\u0001\u0000\u0000\u0000\u011b\u0111\u0001\u0000\u0000"+
		"\u0000\u011b\u0112\u0001\u0000\u0000\u0000\u011b\u0113\u0001\u0000\u0000"+
		"\u0000\u011b\u0114\u0001\u0000\u0000\u0000\u011b\u0115\u0001\u0000\u0000"+
		"\u0000\u011b\u0116\u0001\u0000\u0000\u0000\u011b\u0117\u0001\u0000\u0000"+
		"\u0000\u011b\u0118\u0001\u0000\u0000\u0000\u011b\u0119\u0001\u0000\u0000"+
		"\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011c\u000b\u0001\u0000\u0000"+
		"\u0000\u011d\u0126\u00055\u0000\u0000\u011e\u0127\u0003\\.\u0000\u011f"+
		"\u0120\u0003\\.\u0000\u0120\u0121\u0005>\u0000\u0000\u0121\u0123\u0001"+
		"\u0000\u0000\u0000\u0122\u011f\u0001\u0000\u0000\u0000\u0122\u0123\u0001"+
		"\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u0125\u0005"+
		"<\u0000\u0000\u0125\u0127\u0005u\u0000\u0000\u0126\u011e\u0001\u0000\u0000"+
		"\u0000\u0126\u0122\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000"+
		"\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128\u0129\u00056\u0000\u0000"+
		"\u0129\r\u0001\u0000\u0000\u0000\u012a\u012f\u0005g\u0000\u0000\u012b"+
		"\u012f\u0003\u0000\u0000\u0000\u012c\u012f\u0003\u0002\u0001\u0000\u012d"+
		"\u012f\u0005o\u0000\u0000\u012e\u012a\u0001\u0000\u0000\u0000\u012e\u012b"+
		"\u0001\u0000\u0000\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012e\u012d"+
		"\u0001\u0000\u0000\u0000\u012f\u000f\u0001\u0000\u0000\u0000\u0130\u0131"+
		"\u00059\u0000\u0000\u0131\u0132\u0003\u0012\t\u0000\u0132\u0133\u0005"+
		":\u0000\u0000\u0133\u0011\u0001\u0000\u0000\u0000\u0134\u0135\u0004\t"+
		"\u0000\u0000\u0135\u0138\u0003\u0014\n\u0000\u0136\u0138\u0004\t\u0001"+
		"\u0000\u0137\u0134\u0001\u0000\u0000\u0000\u0137\u0136\u0001\u0000\u0000"+
		"\u0000\u0138\u013c\u0001\u0000\u0000\u0000\u0139\u013c\u0003H$\u0000\u013a"+
		"\u013c\u0003\u0018\f\u0000\u013b\u0137\u0001\u0000\u0000\u0000\u013b\u0139"+
		"\u0001\u0000\u0000\u0000\u013b\u013a\u0001\u0000\u0000\u0000\u013c\u0149"+
		"\u0001\u0000\u0000\u0000\u013d\u0145\u0005>\u0000\u0000\u013e\u013f\u0004"+
		"\t\u0002\u0000\u013f\u0142\u0003\u0014\n\u0000\u0140\u0142\u0004\t\u0003"+
		"\u0000\u0141\u013e\u0001\u0000\u0000\u0000\u0141\u0140\u0001\u0000\u0000"+
		"\u0000\u0142\u0146\u0001\u0000\u0000\u0000\u0143\u0146\u0003H$\u0000\u0144"+
		"\u0146\u0003\u0018\f\u0000\u0145\u0141\u0001\u0000\u0000\u0000\u0145\u0143"+
		"\u0001\u0000\u0000\u0000\u0145\u0144\u0001\u0000\u0000\u0000\u0146\u0148"+
		"\u0001\u0000\u0000\u0000\u0147\u013d\u0001\u0000\u0000\u0000\u0148\u014b"+
		"\u0001\u0000\u0000\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u0149\u014a"+
		"\u0001\u0000\u0000\u0000\u014a\u0013\u0001\u0000\u0000\u0000\u014b\u0149"+
		"\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d\u0015"+
		"\u0001\u0000\u0000\u0000\u014e\u0150\u0005>\u0000\u0000\u014f\u014e\u0001"+
		"\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u014f\u0001"+
		"\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u0152\u0017\u0001"+
		"\u0000\u0000\u0000\u0153\u0154\u0005<\u0000\u0000\u0154\u0155\u0003H$"+
		"\u0000\u0155\u0019\u0001\u0000\u0000\u0000\u0156\u015b\u00057\u0000\u0000"+
		"\u0157\u0159\u0003\u001c\u000e\u0000\u0158\u015a\u0005>\u0000\u0000\u0159"+
		"\u0158\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a"+
		"\u015c\u0001\u0000\u0000\u0000\u015b\u0157\u0001\u0000\u0000\u0000\u015b"+
		"\u015c\u0001\u0000\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d"+
		"\u015e\u00058\u0000\u0000\u015e\u001b\u0001\u0000\u0000\u0000\u015f\u0164"+
		"\u0003\u001e\u000f\u0000\u0160\u0161\u0005>\u0000\u0000\u0161\u0163\u0003"+
		"\u001e\u000f\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0163\u0166\u0001"+
		"\u0000\u0000\u0000\u0164\u0162\u0001\u0000\u0000\u0000\u0164\u0165\u0001"+
		"\u0000\u0000\u0000\u0165\u001d\u0001\u0000\u0000\u0000\u0166\u0164\u0001"+
		"\u0000\u0000\u0000\u0167\u016f\u0005u\u0000\u0000\u0168\u016f\u0003&\u0013"+
		"\u0000\u0169\u016a\u0003 \u0010\u0000\u016a\u016b\u0005Z\u0000\u0000\u016b"+
		"\u016c\u0003H$\u0000\u016c\u016f\u0001\u0000\u0000\u0000\u016d\u016f\u0003"+
		"\u00ccf\u0000\u016e\u0167\u0001\u0000\u0000\u0000\u016e\u0168\u0001\u0000"+
		"\u0000\u0000\u016e\u0169\u0001\u0000\u0000\u0000\u016e\u016d\u0001\u0000"+
		"\u0000\u0000\u016f\u001f\u0001\u0000\u0000\u0000\u0170\u0173\u0003\"\u0011"+
		"\u0000\u0171\u0173\u0003$\u0012\u0000\u0172\u0170\u0001\u0000\u0000\u0000"+
		"\u0172\u0171\u0001\u0000\u0000\u0000\u0173!\u0001\u0000\u0000\u0000\u0174"+
		"\u0178\u0005u\u0000\u0000\u0175\u0178\u0005o\u0000\u0000\u0176\u0178\u0003"+
		"\u0002\u0001\u0000\u0177\u0174\u0001\u0000\u0000\u0000\u0177\u0175\u0001"+
		"\u0000\u0000\u0000\u0177\u0176\u0001\u0000\u0000\u0000\u0178#\u0001\u0000"+
		"\u0000\u0000\u0179\u017a\u00059\u0000\u0000\u017a\u017b\u0003H$\u0000"+
		"\u017b\u017c\u0005:\u0000\u0000\u017c%\u0001\u0000\u0000\u0000\u017d\u017e"+
		"\u0005u\u0000\u0000\u017e\u017f\u0003(\u0014\u0000\u017f\'\u0001\u0000"+
		"\u0000\u0000\u0180\u0181\u0005[\u0000\u0000\u0181\u0182\u0003H$\u0000"+
		"\u0182)\u0001\u0000\u0000\u0000\u0183\u0189\u0005r\u0000\u0000\u0184\u0185"+
		"\u0005q\u0000\u0000\u0185\u0186\u0003\\.\u0000\u0186\u0187\u0003,\u0016"+
		"\u0000\u0187\u0189\u0001\u0000\u0000\u0000\u0188\u0183\u0001\u0000\u0000"+
		"\u0000\u0188\u0184\u0001\u0000\u0000\u0000\u0189+\u0001\u0000\u0000\u0000"+
		"\u018a\u018f\u0005t\u0000\u0000\u018b\u018c\u0003.\u0017\u0000\u018c\u018d"+
		"\u0005t\u0000\u0000\u018d\u018f\u0001\u0000\u0000\u0000\u018e\u018a\u0001"+
		"\u0000\u0000\u0000\u018e\u018b\u0001\u0000\u0000\u0000\u018f-\u0001\u0000"+
		"\u0000\u0000\u0190\u0191\u0006\u0017\uffff\uffff\u0000\u0191\u0192\u0005"+
		"s\u0000\u0000\u0192\u0193\u0003\\.\u0000\u0193\u0199\u0001\u0000\u0000"+
		"\u0000\u0194\u0195\n\u0001\u0000\u0000\u0195\u0196\u0005s\u0000\u0000"+
		"\u0196\u0198\u0003\\.\u0000\u0197\u0194\u0001\u0000\u0000\u0000\u0198"+
		"\u019b\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000\u0199"+
		"\u019a\u0001\u0000\u0000\u0000\u019a/\u0001\u0000\u0000\u0000\u019b\u0199"+
		"\u0001\u0000\u0000\u0000\u019c\u019d\u0006\u0018\uffff\uffff\u0000\u019d"+
		"\u01a5\u00032\u0019\u0000\u019e\u01a5\u00034\u001a\u0000\u019f\u01a0\u0005"+
		"\u0011\u0000\u0000\u01a0\u01a1\u00030\u0018\u0000\u01a1\u01a2\u00038\u001c"+
		"\u0000\u01a2\u01a5\u0001\u0000\u0000\u0000\u01a3\u01a5\u0003\n\u0005\u0000"+
		"\u01a4\u019c\u0001\u0000\u0000\u0000\u01a4\u019e\u0001\u0000\u0000\u0000"+
		"\u01a4\u019f\u0001\u0000\u0000\u0000\u01a4\u01a3\u0001\u0000\u0000\u0000"+
		"\u01a5\u01b2\u0001\u0000\u0000\u0000\u01a6\u01a7\n\u0007\u0000\u0000\u01a7"+
		"\u01a8\u00059\u0000\u0000\u01a8\u01a9\u0003\\.\u0000\u01a9\u01aa\u0005"+
		":\u0000\u0000\u01aa\u01b1\u0001\u0000\u0000\u0000\u01ab\u01ac\n\u0006"+
		"\u0000\u0000\u01ac\u01ad\u0005;\u0000\u0000\u01ad\u01b1\u0005u\u0000\u0000"+
		"\u01ae\u01af\n\u0005\u0000\u0000\u01af\u01b1\u0003*\u0015\u0000\u01b0"+
		"\u01a6\u0001\u0000\u0000\u0000\u01b0\u01ab\u0001\u0000\u0000\u0000\u01b0"+
		"\u01ae\u0001\u0000\u0000\u0000\u01b1\u01b4\u0001\u0000\u0000\u0000\u01b2"+
		"\u01b0\u0001\u0000\u0000\u0000\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3"+
		"1\u0001\u0000\u0000\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b5\u01b6"+
		"\u0005\u0019\u0000\u0000\u01b6\u01b7\u00059\u0000\u0000\u01b7\u01b8\u0003"+
		"\\.\u0000\u01b8\u01b9\u0005:\u0000\u0000\u01b9\u01be\u0001\u0000\u0000"+
		"\u0000\u01ba\u01bb\u0005\u0019\u0000\u0000\u01bb\u01bc\u0005;\u0000\u0000"+
		"\u01bc\u01be\u0005u\u0000\u0000\u01bd\u01b5\u0001\u0000\u0000\u0000\u01bd"+
		"\u01ba\u0001\u0000\u0000\u0000\u01be3\u0001\u0000\u0000\u0000\u01bf\u01c0"+
		"\u0005\u0011\u0000\u0000\u01c0\u01c1\u0005;\u0000\u0000\u01c1\u01c2\u0005"+
		"u\u0000\u0000\u01c2\u01c3\u0004\u001a\b\u0001\u01c35\u0001\u0000\u0000"+
		"\u0000\u01c4\u01c5\u00038\u001c\u0000\u01c5\u01c6\u00036\u001b\u0000\u01c6"+
		"\u01d4\u0001\u0000\u0000\u0000\u01c7\u01c8\u00059\u0000\u0000\u01c8\u01c9"+
		"\u0003\\.\u0000\u01c9\u01ca\u0005:\u0000\u0000\u01ca\u01cb\u00036\u001b"+
		"\u0000\u01cb\u01d4\u0001\u0000\u0000\u0000\u01cc\u01cd\u0005;\u0000\u0000"+
		"\u01cd\u01ce\u0005u\u0000\u0000\u01ce\u01d4\u00036\u001b\u0000\u01cf\u01d0"+
		"\u0003*\u0015\u0000\u01d0\u01d1\u00036\u001b\u0000\u01d1\u01d4\u0001\u0000"+
		"\u0000\u0000\u01d2\u01d4\u0001\u0000\u0000\u0000\u01d3\u01c4\u0001\u0000"+
		"\u0000\u0000\u01d3\u01c7\u0001\u0000\u0000\u0000\u01d3\u01cc\u0001\u0000"+
		"\u0000\u0000\u01d3\u01cf\u0001\u0000\u0000\u0000\u01d3\u01d2\u0001\u0000"+
		"\u0000\u0000\u01d47\u0001\u0000\u0000\u0000\u01d5\u01d7\u00055\u0000\u0000"+
		"\u01d6\u01d8\u0003:\u001d\u0000\u01d7\u01d6\u0001\u0000\u0000\u0000\u01d7"+
		"\u01d8\u0001\u0000\u0000\u0000\u01d8\u01d9\u0001\u0000\u0000\u0000\u01d9"+
		"\u01da\u00056\u0000\u0000\u01da9\u0001\u0000\u0000\u0000\u01db\u01dd\u0005"+
		"<\u0000\u0000\u01dc\u01db\u0001\u0000\u0000\u0000\u01dc\u01dd\u0001\u0000"+
		"\u0000\u0000\u01dd\u01de\u0001\u0000\u0000\u0000\u01de\u01e6\u0003H$\u0000"+
		"\u01df\u01e1\u0005>\u0000\u0000\u01e0\u01e2\u0005<\u0000\u0000\u01e1\u01e0"+
		"\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2\u01e3"+
		"\u0001\u0000\u0000\u0000\u01e3\u01e5\u0003H$\u0000\u01e4\u01df\u0001\u0000"+
		"\u0000\u0000\u01e5\u01e8\u0001\u0000\u0000\u0000\u01e6\u01e4\u0001\u0000"+
		"\u0000\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7;\u0001\u0000\u0000"+
		"\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000\u01e9\u01ed\u00030\u0018\u0000"+
		"\u01ea\u01eb\u0005\u0011\u0000\u0000\u01eb\u01ed\u0003<\u001e\u0000\u01ec"+
		"\u01e9\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001\u0000\u0000\u0000\u01ed"+
		"=\u0001\u0000\u0000\u0000\u01ee\u01f2\u00030\u0018\u0000\u01ef\u01f0\u0003"+
		"8\u001c\u0000\u01f0\u01f1\u00036\u001b\u0000\u01f1\u01f3\u0001\u0000\u0000"+
		"\u0000\u01f2\u01ef\u0001\u0000\u0000\u0000\u01f2\u01f3\u0001\u0000\u0000"+
		"\u0000\u01f3\u01fb\u0001\u0000\u0000\u0000\u01f4\u01f5\u0005\u0019\u0000"+
		"\u0000\u01f5\u01f6\u00038\u001c\u0000\u01f6\u01f7\u00036\u001b\u0000\u01f7"+
		"\u01fb\u0001\u0000\u0000\u0000\u01f8\u01f9\u0005\u0011\u0000\u0000\u01f9"+
		"\u01fb\u0003<\u001e\u0000\u01fa\u01ee\u0001\u0000\u0000\u0000\u01fa\u01f4"+
		"\u0001\u0000\u0000\u0000\u01fa\u01f8\u0001\u0000\u0000\u0000\u01fb?\u0001"+
		"\u0000\u0000\u0000\u01fc\u01fe\u0003>\u001f\u0000\u01fd\u01ff\u0007\u0002"+
		"\u0000\u0000\u01fe\u01fd\u0001\u0000\u0000\u0000\u01fe\u01ff\u0001\u0000"+
		"\u0000\u0000\u01ffA\u0001\u0000\u0000\u0000\u0200\u0204\u0003@ \u0000"+
		"\u0201\u0202\u0007\u0003\u0000\u0000\u0202\u0204\u0003B!\u0000\u0203\u0200"+
		"\u0001\u0000\u0000\u0000\u0203\u0201\u0001\u0000\u0000\u0000\u0204C\u0001"+
		"\u0000\u0000\u0000\u0205\u0206\u0006\"\uffff\uffff\u0000\u0206\u0207\u0003"+
		"B!\u0000\u0207\u021f\u0001\u0000\u0000\u0000\u0208\u0209\n\u0007\u0000"+
		"\u0000\u0209\u020a\u0007\u0004\u0000\u0000\u020a\u021e\u0003D\"\b\u020b"+
		"\u020c\n\u0006\u0000\u0000\u020c\u020d\u0007\u0005\u0000\u0000\u020d\u021e"+
		"\u0003D\"\u0007\u020e\u020f\n\u0005\u0000\u0000\u020f\u0210\u0007\u0006"+
		"\u0000\u0000\u0210\u021e\u0003D\"\u0006\u0211\u0212\n\u0004\u0000\u0000"+
		"\u0212\u0213\u0007\u0007\u0000\u0000\u0213\u021e\u0003D\"\u0005\u0214"+
		"\u0215\n\u0003\u0000\u0000\u0215\u0216\u0007\b\u0000\u0000\u0216\u021e"+
		"\u0003D\"\u0004\u0217\u0218\n\u0002\u0000\u0000\u0218\u0219\u0007\t\u0000"+
		"\u0000\u0219\u021e\u0003D\"\u0003\u021a\u021b\n\u0001\u0000\u0000\u021b"+
		"\u021c\u0007\n\u0000\u0000\u021c\u021e\u0003D\"\u0002\u021d\u0208\u0001"+
		"\u0000\u0000\u0000\u021d\u020b\u0001\u0000\u0000\u0000\u021d\u020e\u0001"+
		"\u0000\u0000\u0000\u021d\u0211\u0001\u0000\u0000\u0000\u021d\u0214\u0001"+
		"\u0000\u0000\u0000\u021d\u0217\u0001\u0000\u0000\u0000\u021d\u021a\u0001"+
		"\u0000\u0000\u0000\u021e\u0221\u0001\u0000\u0000\u0000\u021f\u021d\u0001"+
		"\u0000\u0000\u0000\u021f\u0220\u0001\u0000\u0000\u0000\u0220E\u0001\u0000"+
		"\u0000\u0000\u0221\u021f\u0001\u0000\u0000\u0000\u0222\u0228\u0003D\""+
		"\u0000\u0223\u0224\u0005Y\u0000\u0000\u0224\u0225\u0003H$\u0000\u0225"+
		"\u0226\u0005Z\u0000\u0000\u0226\u0227\u0003H$\u0000\u0227\u0229\u0001"+
		"\u0000\u0000\u0000\u0228\u0223\u0001\u0000\u0000\u0000\u0228\u0229\u0001"+
		"\u0000\u0000\u0000\u0229G\u0001\u0000\u0000\u0000\u022a\u022b\u0003J%"+
		"\u0000\u022b\u022c\u0005[\u0000\u0000\u022c\u022d\u0003H$\u0000\u022d"+
		"\u0236\u0001\u0000\u0000\u0000\u022e\u022f\u0003>\u001f\u0000\u022f\u0230"+
		"\u0007\u000b\u0000\u0000\u0230\u0231\u0003H$\u0000\u0231\u0236\u0001\u0000"+
		"\u0000\u0000\u0232\u0236\u0003F#\u0000\u0233\u0236\u0003\u00c6c\u0000"+
		"\u0234\u0236\u0003\u00d8l\u0000\u0235\u022a\u0001\u0000\u0000\u0000\u0235"+
		"\u022e\u0001\u0000\u0000\u0000\u0235\u0232\u0001\u0000\u0000\u0000\u0235"+
		"\u0233\u0001\u0000\u0000\u0000\u0235\u0234\u0001\u0000\u0000\u0000\u0236"+
		"I\u0001\u0000\u0000\u0000\u0237\u023a\u0003L&\u0000\u0238\u023a\u0003"+
		"N\'\u0000\u0239\u0237\u0001\u0000\u0000\u0000\u0239\u0238\u0001\u0000"+
		"\u0000\u0000\u023aK\u0001\u0000\u0000\u0000\u023b\u0240\u00057\u0000\u0000"+
		"\u023c\u023e\u0003P(\u0000\u023d\u023f\u0005>\u0000\u0000\u023e\u023d"+
		"\u0001\u0000\u0000\u0000\u023e\u023f\u0001\u0000\u0000\u0000\u023f\u0241"+
		"\u0001\u0000\u0000\u0000\u0240\u023c\u0001\u0000\u0000\u0000\u0240\u0241"+
		"\u0001\u0000\u0000\u0000\u0241\u0242\u0001\u0000\u0000\u0000\u0242\u0243"+
		"\u00058\u0000\u0000\u0243M\u0001\u0000\u0000\u0000\u0244\u0246\u00059"+
		"\u0000\u0000\u0245\u0247\u0003\u0016\u000b\u0000\u0246\u0245\u0001\u0000"+
		"\u0000\u0000\u0246\u0247\u0001\u0000\u0000\u0000\u0247\u0249\u0001\u0000"+
		"\u0000\u0000\u0248\u024a\u0003Z-\u0000\u0249\u0248\u0001\u0000\u0000\u0000"+
		"\u0249\u024a\u0001\u0000\u0000\u0000\u024a\u024b\u0001\u0000\u0000\u0000"+
		"\u024b\u025c\u0005:\u0000\u0000\u024c\u024d\u00059\u0000\u0000\u024d\u024e"+
		"\u0003R)\u0000\u024e\u024f\u0005:\u0000\u0000\u024f\u025c\u0001\u0000"+
		"\u0000\u0000\u0250\u0251\u00059\u0000\u0000\u0251\u0252\u0003R)\u0000"+
		"\u0252\u0254\u0005>\u0000\u0000\u0253\u0255\u0003\u0016\u000b\u0000\u0254"+
		"\u0253\u0001\u0000\u0000\u0000\u0254\u0255\u0001\u0000\u0000\u0000\u0255"+
		"\u0257\u0001\u0000\u0000\u0000\u0256\u0258\u0003Z-\u0000\u0257\u0256\u0001"+
		"\u0000\u0000\u0000\u0257\u0258\u0001\u0000\u0000\u0000\u0258\u0259\u0001"+
		"\u0000\u0000\u0000\u0259\u025a\u0005:\u0000\u0000\u025a\u025c\u0001\u0000"+
		"\u0000\u0000\u025b\u0244\u0001\u0000\u0000\u0000\u025b\u024c\u0001\u0000"+
		"\u0000\u0000\u025b\u0250\u0001\u0000\u0000\u0000\u025cO\u0001\u0000\u0000"+
		"\u0000\u025d\u0262\u0003V+\u0000\u025e\u025f\u0005>\u0000\u0000\u025f"+
		"\u0261\u0003V+\u0000\u0260\u025e\u0001\u0000\u0000\u0000\u0261\u0264\u0001"+
		"\u0000\u0000\u0000\u0262\u0260\u0001\u0000\u0000\u0000\u0262\u0263\u0001"+
		"\u0000\u0000\u0000\u0263Q\u0001\u0000\u0000\u0000\u0264\u0262\u0001\u0000"+
		"\u0000\u0000\u0265\u026a\u0003T*\u0000\u0266\u0267\u0005>\u0000\u0000"+
		"\u0267\u0269\u0003T*\u0000\u0268\u0266\u0001\u0000\u0000\u0000\u0269\u026c"+
		"\u0001\u0000\u0000\u0000\u026a\u0268\u0001\u0000\u0000\u0000\u026a\u026b"+
		"\u0001\u0000\u0000\u0000\u026bS\u0001\u0000\u0000\u0000\u026c\u026a\u0001"+
		"\u0000\u0000\u0000\u026d\u026f\u0003\u0016\u000b\u0000\u026e\u026d\u0001"+
		"\u0000\u0000\u0000\u026e\u026f\u0001\u0000\u0000\u0000\u026f\u0270\u0001"+
		"\u0000\u0000\u0000\u0270\u0271\u0003X,\u0000\u0271U\u0001\u0000\u0000"+
		"\u0000\u0272\u0274\u0005u\u0000\u0000\u0273\u0275\u0003(\u0014\u0000\u0274"+
		"\u0273\u0001\u0000\u0000\u0000\u0274\u0275\u0001\u0000\u0000\u0000\u0275"+
		"\u027b\u0001\u0000\u0000\u0000\u0276\u0277\u0003 \u0010\u0000\u0277\u0278"+
		"\u0005Z\u0000\u0000\u0278\u0279\u0003X,\u0000\u0279\u027b\u0001\u0000"+
		"\u0000\u0000\u027a\u0272\u0001\u0000\u0000\u0000\u027a\u0276\u0001\u0000"+
		"\u0000\u0000\u027bW\u0001\u0000\u0000\u0000\u027c\u027e\u0003>\u001f\u0000"+
		"\u027d\u027f\u0003(\u0014\u0000\u027e\u027d\u0001\u0000\u0000\u0000\u027e"+
		"\u027f\u0001\u0000\u0000\u0000\u027fY\u0001\u0000\u0000\u0000\u0280\u0281"+
		"\u0005<\u0000\u0000\u0281\u0282\u0003>\u001f\u0000\u0282[\u0001\u0000"+
		"\u0000\u0000\u0283\u0288\u0003H$\u0000\u0284\u0285\u0005>\u0000\u0000"+
		"\u0285\u0287\u0003H$\u0000\u0286\u0284\u0001\u0000\u0000\u0000\u0287\u028a"+
		"\u0001\u0000\u0000\u0000\u0288\u0286\u0001\u0000\u0000\u0000\u0288\u0289"+
		"\u0001\u0000\u0000\u0000\u0289]\u0001\u0000\u0000\u0000\u028a\u0288\u0001"+
		"\u0000\u0000\u0000\u028b\u029b\u0003d2\u0000\u028c\u029b\u0003p8\u0000"+
		"\u028d\u029b\u0003\u008aE\u0000\u028e\u029b\u0003\u008cF\u0000\u028f\u029b"+
		"\u0003\u008eG\u0000\u0290\u029b\u0003\u0090H\u0000\u0291\u029b\u0003\u009e"+
		"O\u0000\u0292\u029b\u0003\u0096K\u0000\u0293\u029b\u0003\u0098L\u0000"+
		"\u0294\u029b\u0003\u009aM\u0000\u0295\u029b\u0003\u009cN\u0000\u0296\u029b"+
		"\u0003\u00a8T\u0000\u0297\u029b\u0003\u00acV\u0000\u0298\u029b\u0003\u00ae"+
		"W\u0000\u0299\u029b\u0003\u00b6[\u0000\u029a\u028b\u0001\u0000\u0000\u0000"+
		"\u029a\u028c\u0001\u0000\u0000\u0000\u029a\u028d\u0001\u0000\u0000\u0000"+
		"\u029a\u028e\u0001\u0000\u0000\u0000\u029a\u028f\u0001\u0000\u0000\u0000"+
		"\u029a\u0290\u0001\u0000\u0000\u0000\u029a\u0291\u0001\u0000\u0000\u0000"+
		"\u029a\u0292\u0001\u0000\u0000\u0000\u029a\u0293\u0001\u0000\u0000\u0000"+
		"\u029a\u0294\u0001\u0000\u0000\u0000\u029a\u0295\u0001\u0000\u0000\u0000"+
		"\u029a\u0296\u0001\u0000\u0000\u0000\u029a\u0297\u0001\u0000\u0000\u0000"+
		"\u029a\u0298\u0001\u0000\u0000\u0000\u029a\u0299\u0001\u0000\u0000\u0000"+
		"\u029b_\u0001\u0000\u0000\u0000\u029c\u02a0\u0003b1\u0000\u029d\u02a0"+
		"\u0003\u00dam\u0000\u029e\u02a0\u0003h4\u0000\u029f\u029c\u0001\u0000"+
		"\u0000\u0000\u029f\u029d\u0001\u0000\u0000\u0000\u029f\u029e\u0001\u0000"+
		"\u0000\u0000\u02a0a\u0001\u0000\u0000\u0000\u02a1\u02a4\u0003\u00b8\\"+
		"\u0000\u02a2\u02a4\u0003\u00d6k\u0000\u02a3\u02a1\u0001\u0000\u0000\u0000"+
		"\u02a3\u02a2\u0001\u0000\u0000\u0000\u02a4c\u0001\u0000\u0000\u0000\u02a5"+
		"\u02a7\u00057\u0000\u0000\u02a6\u02a8\u0003f3\u0000\u02a7\u02a6\u0001"+
		"\u0000\u0000\u0000\u02a7\u02a8\u0001\u0000\u0000\u0000\u02a8\u02a9\u0001"+
		"\u0000\u0000\u0000\u02a9\u02aa\u00058\u0000\u0000\u02aae\u0001\u0000\u0000"+
		"\u0000\u02ab\u02ae\u0003^/\u0000\u02ac\u02ae\u0003`0\u0000\u02ad\u02ab"+
		"\u0001\u0000\u0000\u0000\u02ad\u02ac\u0001\u0000\u0000\u0000\u02ae\u02af"+
		"\u0001\u0000\u0000\u0000\u02af\u02ad\u0001\u0000\u0000\u0000\u02af\u02b0"+
		"\u0001\u0000\u0000\u0000\u02b0g\u0001\u0000\u0000\u0000\u02b1\u02b2\u0003"+
		"j5\u0000\u02b2\u02b3\u0003l6\u0000\u02b3\u02b4\u0003\u0104\u0082\u0000"+
		"\u02b4i\u0001\u0000\u0000\u0000\u02b5\u02b6\u0007\f\u0000\u0000\u02b6"+
		"k\u0001\u0000\u0000\u0000\u02b7\u02bc\u0003n7\u0000\u02b8\u02b9\u0005"+
		">\u0000\u0000\u02b9\u02bb\u0003n7\u0000\u02ba\u02b8\u0001\u0000\u0000"+
		"\u0000\u02bb\u02be\u0001\u0000\u0000\u0000\u02bc\u02ba\u0001\u0000\u0000"+
		"\u0000\u02bc\u02bd\u0001\u0000\u0000\u0000\u02bdm\u0001\u0000\u0000\u0000"+
		"\u02be\u02bc\u0001\u0000\u0000\u0000\u02bf\u02c1\u0003\u0006\u0003\u0000"+
		"\u02c0\u02c2\u0003(\u0014\u0000\u02c1\u02c0\u0001\u0000\u0000\u0000\u02c1"+
		"\u02c2\u0001\u0000\u0000\u0000\u02c2\u02c8\u0001\u0000\u0000\u0000\u02c3"+
		"\u02c5\u0003v;\u0000\u02c4\u02c6\u0003(\u0014\u0000\u02c5\u02c4\u0001"+
		"\u0000\u0000\u0000\u02c5\u02c6\u0001\u0000\u0000\u0000\u02c6\u02c8\u0001"+
		"\u0000\u0000\u0000\u02c7\u02bf\u0001\u0000\u0000\u0000\u02c7\u02c3\u0001"+
		"\u0000\u0000\u0000\u02c8o\u0001\u0000\u0000\u0000\u02c9\u02ca\u0005\u000e"+
		"\u0000\u0000\u02ca\u02cb\u0003r9\u0000\u02cb\u02cc\u0003\u0104\u0082\u0000"+
		"\u02ccq\u0001\u0000\u0000\u0000\u02cd\u02d2\u0003t:\u0000\u02ce\u02cf"+
		"\u0005>\u0000\u0000\u02cf\u02d1\u0003t:\u0000\u02d0\u02ce\u0001\u0000"+
		"\u0000\u0000\u02d1\u02d4\u0001\u0000\u0000\u0000\u02d2\u02d0\u0001\u0000"+
		"\u0000\u0000\u02d2\u02d3\u0001\u0000\u0000\u0000\u02d3s\u0001\u0000\u0000"+
		"\u0000\u02d4\u02d2\u0001\u0000\u0000\u0000\u02d5\u02d7\u0005u\u0000\u0000"+
		"\u02d6\u02d8\u0003(\u0014\u0000\u02d7\u02d6\u0001\u0000\u0000\u0000\u02d7"+
		"\u02d8\u0001\u0000\u0000\u0000\u02d8\u02e2\u0001\u0000\u0000\u0000\u02d9"+
		"\u02db\u0003\u0102\u0081\u0000\u02da\u02dc\u0003(\u0014\u0000\u02db\u02da"+
		"\u0001\u0000\u0000\u0000\u02db\u02dc\u0001\u0000\u0000\u0000\u02dc\u02e2"+
		"\u0001\u0000\u0000\u0000\u02dd\u02df\u0003v;\u0000\u02de\u02e0\u0003("+
		"\u0014\u0000\u02df\u02de\u0001\u0000\u0000\u0000\u02df\u02e0\u0001\u0000"+
		"\u0000\u0000\u02e0\u02e2\u0001\u0000\u0000\u0000\u02e1\u02d5\u0001\u0000"+
		"\u0000\u0000\u02e1\u02d9\u0001\u0000\u0000\u0000\u02e1\u02dd\u0001\u0000"+
		"\u0000\u0000\u02e2u\u0001\u0000\u0000\u0000\u02e3\u02e6\u0003x<\u0000"+
		"\u02e4\u02e6\u0003z=\u0000\u02e5\u02e3\u0001\u0000\u0000\u0000\u02e5\u02e4"+
		"\u0001\u0000\u0000\u0000\u02e6w\u0001\u0000\u0000\u0000\u02e7\u02e8\u0005"+
		"7\u0000\u0000\u02e8\u02f3\u00058\u0000\u0000\u02e9\u02ea\u00057\u0000"+
		"\u0000\u02ea\u02eb\u0003|>\u0000\u02eb\u02ec\u00058\u0000\u0000\u02ec"+
		"\u02f3\u0001\u0000\u0000\u0000\u02ed\u02ee\u00057\u0000\u0000\u02ee\u02ef"+
		"\u0003|>\u0000\u02ef\u02f0\u0005>\u0000\u0000\u02f0\u02f1\u00058\u0000"+
		"\u0000\u02f1\u02f3\u0001\u0000\u0000\u0000\u02f2\u02e7\u0001\u0000\u0000"+
		"\u0000\u02f2\u02e9\u0001\u0000\u0000\u0000\u02f2\u02ed\u0001\u0000\u0000"+
		"\u0000\u02f3y\u0001\u0000\u0000\u0000\u02f4\u02f6\u00059\u0000\u0000\u02f5"+
		"\u02f7\u0003\u0016\u000b\u0000\u02f6\u02f5\u0001\u0000\u0000\u0000\u02f6"+
		"\u02f7\u0001\u0000\u0000\u0000\u02f7\u02f9\u0001\u0000\u0000\u0000\u02f8"+
		"\u02fa\u0003\u0088D\u0000\u02f9\u02f8\u0001\u0000\u0000\u0000\u02f9\u02fa"+
		"\u0001\u0000\u0000\u0000\u02fa\u02fb\u0001\u0000\u0000\u0000\u02fb\u030c"+
		"\u0005:\u0000\u0000\u02fc\u02fd\u00059\u0000\u0000\u02fd\u02fe\u0003~"+
		"?\u0000\u02fe\u02ff\u0005:\u0000\u0000\u02ff\u030c\u0001\u0000\u0000\u0000"+
		"\u0300\u0301\u00059\u0000\u0000\u0301\u0302\u0003~?\u0000\u0302\u0304"+
		"\u0005>\u0000\u0000\u0303\u0305\u0003\u0016\u000b\u0000\u0304\u0303\u0001"+
		"\u0000\u0000\u0000\u0304\u0305\u0001\u0000\u0000\u0000\u0305\u0307\u0001"+
		"\u0000\u0000\u0000\u0306\u0308\u0003\u0088D\u0000\u0307\u0306\u0001\u0000"+
		"\u0000\u0000\u0307\u0308\u0001\u0000\u0000\u0000\u0308\u0309\u0001\u0000"+
		"\u0000\u0000\u0309\u030a\u0005:\u0000\u0000\u030a\u030c\u0001\u0000\u0000"+
		"\u0000\u030b\u02f4\u0001\u0000\u0000\u0000\u030b\u02fc\u0001\u0000\u0000"+
		"\u0000\u030b\u0300\u0001\u0000\u0000\u0000\u030c{\u0001\u0000\u0000\u0000"+
		"\u030d\u0312\u0003\u0082A\u0000\u030e\u030f\u0005>\u0000\u0000\u030f\u0311"+
		"\u0003\u0082A\u0000\u0310\u030e\u0001\u0000\u0000\u0000\u0311\u0314\u0001"+
		"\u0000\u0000\u0000\u0312\u0310\u0001\u0000\u0000\u0000\u0312\u0313\u0001"+
		"\u0000\u0000\u0000\u0313}\u0001\u0000\u0000\u0000\u0314\u0312\u0001\u0000"+
		"\u0000\u0000\u0315\u031a\u0003\u0080@\u0000\u0316\u0317\u0005>\u0000\u0000"+
		"\u0317\u0319\u0003\u0080@\u0000\u0318\u0316\u0001\u0000\u0000\u0000\u0319"+
		"\u031c\u0001\u0000\u0000\u0000\u031a\u0318\u0001\u0000\u0000\u0000\u031a"+
		"\u031b\u0001\u0000\u0000\u0000\u031b\u007f\u0001\u0000\u0000\u0000\u031c"+
		"\u031a\u0001\u0000\u0000\u0000\u031d\u031f\u0003\u0016\u000b\u0000\u031e"+
		"\u031d\u0001\u0000\u0000\u0000\u031e\u031f\u0001\u0000\u0000\u0000\u031f"+
		"\u0320\u0001\u0000\u0000\u0000\u0320\u0321\u0003\u0084B\u0000\u0321\u0081"+
		"\u0001\u0000\u0000\u0000\u0322\u0328\u0003\u0086C\u0000\u0323\u0324\u0003"+
		" \u0010\u0000\u0324\u0325\u0005Z\u0000\u0000\u0325\u0326\u0003\u0084B"+
		"\u0000\u0326\u0328\u0001\u0000\u0000\u0000\u0327\u0322\u0001\u0000\u0000"+
		"\u0000\u0327\u0323\u0001\u0000\u0000\u0000\u0328\u0083\u0001\u0000\u0000"+
		"\u0000\u0329\u032f\u0003\u0086C\u0000\u032a\u032c\u0003v;\u0000\u032b"+
		"\u032d\u0003(\u0014\u0000\u032c\u032b\u0001\u0000\u0000\u0000\u032c\u032d"+
		"\u0001\u0000\u0000\u0000\u032d\u032f\u0001\u0000\u0000\u0000\u032e\u0329"+
		"\u0001\u0000\u0000\u0000\u032e\u032a\u0001\u0000\u0000\u0000\u032f\u0085"+
		"\u0001\u0000\u0000\u0000\u0330\u0332\u0003\u0006\u0003\u0000\u0331\u0333"+
		"\u0003(\u0014\u0000\u0332\u0331\u0001\u0000\u0000\u0000\u0332\u0333\u0001"+
		"\u0000\u0000\u0000\u0333\u0087\u0001\u0000\u0000\u0000\u0334\u0335\u0005"+
		"<\u0000\u0000\u0335\u0336\u0003\u0006\u0003\u0000\u0336\u0089\u0001\u0000"+
		"\u0000\u0000\u0337\u0338\u0005=\u0000\u0000\u0338\u008b\u0001\u0000\u0000"+
		"\u0000\u0339\u033a\u0004F\u0010\u0000\u033a\u033b\u0003\\.\u0000\u033b"+
		"\u033c\u0003\u0104\u0082\u0000\u033c\u008d\u0001\u0000\u0000\u0000\u033d"+
		"\u033e\u0005$\u0000\u0000\u033e\u033f\u00055\u0000\u0000\u033f\u0340\u0003"+
		"\\.\u0000\u0340\u0341\u00056\u0000\u0000\u0341\u0344\u0003^/\u0000\u0342"+
		"\u0343\u0005\f\u0000\u0000\u0343\u0345\u0003^/\u0000\u0344\u0342\u0001"+
		"\u0000\u0000\u0000\u0344\u0345\u0001\u0000\u0000\u0000\u0345\u008f\u0001"+
		"\u0000\u0000\u0000\u0346\u0347\u0005\b\u0000\u0000\u0347\u0348\u0003^"+
		"/\u0000\u0348\u0349\u0005\u0016\u0000\u0000\u0349\u034a\u00055\u0000\u0000"+
		"\u034a\u034b\u0003\\.\u0000\u034b\u034c\u00056\u0000\u0000\u034c\u034d"+
		"\u0003\u0104\u0082\u0000\u034d\u03b2\u0001\u0000\u0000\u0000\u034e\u034f"+
		"\u0005\u0016\u0000\u0000\u034f\u0350\u00055\u0000\u0000\u0350\u0351\u0003"+
		"\\.\u0000\u0351\u0352\u00056\u0000\u0000\u0352\u0353\u0003^/\u0000\u0353"+
		"\u03b2\u0001\u0000\u0000\u0000\u0354\u0355\u0005\u001c\u0000\u0000\u0355"+
		"\u0357\u00055\u0000\u0000\u0356\u0358\u0003\\.\u0000\u0357\u0356\u0001"+
		"\u0000\u0000\u0000\u0357\u0358\u0001\u0000\u0000\u0000\u0358\u0359\u0001"+
		"\u0000\u0000\u0000\u0359\u035b\u0005=\u0000\u0000\u035a\u035c\u0003\\"+
		".\u0000\u035b\u035a\u0001\u0000\u0000\u0000\u035b\u035c\u0001\u0000\u0000"+
		"\u0000\u035c\u035d\u0001\u0000\u0000\u0000\u035d\u035f\u0005=\u0000\u0000"+
		"\u035e\u0360\u0003\\.\u0000\u035f\u035e\u0001\u0000\u0000\u0000\u035f"+
		"\u0360\u0001\u0000\u0000\u0000\u0360\u0361\u0001\u0000\u0000\u0000\u0361"+
		"\u0362\u00056\u0000\u0000\u0362\u03b2\u0003^/\u0000\u0363\u0364\u0005"+
		"\u001c\u0000\u0000\u0364\u0365\u00055\u0000\u0000\u0365\u0366\u0005\u000e"+
		"\u0000\u0000\u0366\u0367\u0003r9\u0000\u0367\u0369\u0005=\u0000\u0000"+
		"\u0368\u036a\u0003\\.\u0000\u0369\u0368\u0001\u0000\u0000\u0000\u0369"+
		"\u036a\u0001\u0000\u0000\u0000\u036a\u036b\u0001\u0000\u0000\u0000\u036b"+
		"\u036d\u0005=\u0000\u0000\u036c\u036e\u0003\\.\u0000\u036d\u036c\u0001"+
		"\u0000\u0000\u0000\u036d\u036e\u0001\u0000\u0000\u0000\u036e\u036f\u0001"+
		"\u0000\u0000\u0000\u036f\u0370\u00056\u0000\u0000\u0370\u0371\u0003^/"+
		"\u0000\u0371\u03b2\u0001\u0000\u0000\u0000\u0372\u0373\u0005\u001c\u0000"+
		"\u0000\u0373\u0374\u00055\u0000\u0000\u0374\u0376\u0003h4\u0000\u0375"+
		"\u0377\u0003\\.\u0000\u0376\u0375\u0001\u0000\u0000\u0000\u0376\u0377"+
		"\u0001\u0000\u0000\u0000\u0377\u0378\u0001\u0000\u0000\u0000\u0378\u037a"+
		"\u0005=\u0000\u0000\u0379\u037b\u0003\\.\u0000\u037a\u0379\u0001\u0000"+
		"\u0000\u0000\u037a\u037b\u0001\u0000\u0000\u0000\u037b\u037c\u0001\u0000"+
		"\u0000\u0000\u037c\u037d\u00056\u0000\u0000\u037d\u037e\u0003^/\u0000"+
		"\u037e\u03b2\u0001\u0000\u0000\u0000\u037f\u0380\u0005\u001c\u0000\u0000"+
		"\u0380\u0381\u00055\u0000\u0000\u0381\u0382\u0003>\u001f\u0000\u0382\u0383"+
		"\u0005\t\u0000\u0000\u0383\u0384\u0003\\.\u0000\u0384\u0385\u00056\u0000"+
		"\u0000\u0385\u0386\u0003^/\u0000\u0386\u03b2\u0001\u0000\u0000\u0000\u0387"+
		"\u0388\u0005\u001c\u0000\u0000\u0388\u0389\u00055\u0000\u0000\u0389\u038a"+
		"\u0005\u000e\u0000\u0000\u038a\u038b\u0003t:\u0000\u038b\u038c\u0005\t"+
		"\u0000\u0000\u038c\u038d\u0003\\.\u0000\u038d\u038e\u00056\u0000\u0000"+
		"\u038e\u038f\u0003^/\u0000\u038f\u03b2\u0001\u0000\u0000\u0000\u0390\u0391"+
		"\u0005\u001c\u0000\u0000\u0391\u0392\u00055\u0000\u0000\u0392\u0393\u0003"+
		"\u0092I\u0000\u0393\u0394\u0005\t\u0000\u0000\u0394\u0395\u0003\\.\u0000"+
		"\u0395\u0396\u00056\u0000\u0000\u0396\u0397\u0003^/\u0000\u0397\u03b2"+
		"\u0001\u0000\u0000\u0000\u0398\u0399\u0005\u001c\u0000\u0000\u0399\u039a"+
		"\u00055\u0000\u0000\u039a\u039b\u0003>\u001f\u0000\u039b\u039c\u0005\u001d"+
		"\u0000\u0000\u039c\u039d\u0003H$\u0000\u039d\u039e\u00056\u0000\u0000"+
		"\u039e\u039f\u0003^/\u0000\u039f\u03b2\u0001\u0000\u0000\u0000\u03a0\u03a1"+
		"\u0005\u001c\u0000\u0000\u03a1\u03a2\u00055\u0000\u0000\u03a2\u03a3\u0005"+
		"\u000e\u0000\u0000\u03a3\u03a4\u0003\u0094J\u0000\u03a4\u03a5\u0005\u001d"+
		"\u0000\u0000\u03a5\u03a6\u0003H$\u0000\u03a6\u03a7\u00056\u0000\u0000"+
		"\u03a7\u03a8\u0003^/\u0000\u03a8\u03b2\u0001\u0000\u0000\u0000\u03a9\u03aa"+
		"\u0005\u001c\u0000\u0000\u03aa\u03ab\u00055\u0000\u0000\u03ab\u03ac\u0003"+
		"\u0092I\u0000\u03ac\u03ad\u0005\u001d\u0000\u0000\u03ad\u03ae\u0003H$"+
		"\u0000\u03ae\u03af\u00056\u0000\u0000\u03af\u03b0\u0003^/\u0000\u03b0"+
		"\u03b2\u0001\u0000\u0000\u0000\u03b1\u0346\u0001\u0000\u0000\u0000\u03b1"+
		"\u034e\u0001\u0000\u0000\u0000\u03b1\u0354\u0001\u0000\u0000\u0000\u03b1"+
		"\u0363\u0001\u0000\u0000\u0000\u03b1\u0372\u0001\u0000\u0000\u0000\u03b1"+
		"\u037f\u0001\u0000\u0000\u0000\u03b1\u0387\u0001\u0000\u0000\u0000\u03b1"+
		"\u0390\u0001\u0000\u0000\u0000\u03b1\u0398\u0001\u0000\u0000\u0000\u03b1"+
		"\u03a0\u0001\u0000\u0000\u0000\u03b1\u03a9\u0001\u0000\u0000\u0000\u03b2"+
		"\u0091\u0001\u0000\u0000\u0000\u03b3\u03b4\u0003j5\u0000\u03b4\u03b5\u0003"+
		"\u0094J\u0000\u03b5\u0093\u0001\u0000\u0000\u0000\u03b6\u03b9\u0003\u0006"+
		"\u0003\u0000\u03b7\u03b9\u0003v;\u0000\u03b8\u03b6\u0001\u0000\u0000\u0000"+
		"\u03b8\u03b7\u0001\u0000\u0000\u0000\u03b9\u0095\u0001\u0000\u0000\u0000"+
		"\u03ba\u03bc\u0005\u001b\u0000\u0000\u03bb\u03bd\u0003\b\u0004\u0000\u03bc"+
		"\u03bb\u0001\u0000\u0000\u0000\u03bc\u03bd\u0001\u0000\u0000\u0000\u03bd"+
		"\u03be\u0001\u0000\u0000\u0000\u03be\u03bf\u0003\u0104\u0082\u0000\u03bf"+
		"\u0097\u0001\u0000\u0000\u0000\u03c0\u03c2\u0005\u0007\u0000\u0000\u03c1"+
		"\u03c3\u0003\b\u0004\u0000\u03c2\u03c1\u0001\u0000\u0000\u0000\u03c2\u03c3"+
		"\u0001\u0000\u0000\u0000\u03c3\u03c4\u0001\u0000\u0000\u0000\u03c4\u03c5"+
		"\u0003\u0104\u0082\u0000\u03c5\u0099\u0001\u0000\u0000\u0000\u03c6\u03c8"+
		"\u0005\u0015\u0000\u0000\u03c7\u03c9\u0003\\.\u0000\u03c8\u03c7\u0001"+
		"\u0000\u0000\u0000\u03c8\u03c9\u0001\u0000\u0000\u0000\u03c9\u03ca\u0001"+
		"\u0000\u0000\u0000\u03ca\u03cb\u0003\u0104\u0082\u0000\u03cb\u009b\u0001"+
		"\u0000\u0000\u0000\u03cc\u03cd\u0005\u001a\u0000\u0000\u03cd\u03ce\u0005"+
		"5\u0000\u0000\u03ce\u03cf\u0003\\.\u0000\u03cf\u03d0\u00056\u0000\u0000"+
		"\u03d0\u03d1\u0003^/\u0000\u03d1\u009d\u0001\u0000\u0000\u0000\u03d2\u03d3"+
		"\u0005\u001e\u0000\u0000\u03d3\u03d4\u00055\u0000\u0000\u03d4\u03d5\u0003"+
		"\\.\u0000\u03d5\u03d6\u00056\u0000\u0000\u03d6\u03d7\u0003\u00a0P\u0000"+
		"\u03d7\u009f\u0001\u0000\u0000\u0000\u03d8\u03da\u00057\u0000\u0000\u03d9"+
		"\u03db\u0003\u00a2Q\u0000\u03da\u03d9\u0001\u0000\u0000\u0000\u03da\u03db"+
		"\u0001\u0000\u0000\u0000\u03db\u03dc\u0001\u0000\u0000\u0000\u03dc\u03e8"+
		"\u00058\u0000\u0000\u03dd\u03df\u00057\u0000\u0000\u03de\u03e0\u0003\u00a2"+
		"Q\u0000\u03df\u03de\u0001\u0000\u0000\u0000\u03df\u03e0\u0001\u0000\u0000"+
		"\u0000\u03e0\u03e1\u0001\u0000\u0000\u0000\u03e1\u03e3\u0003\u00a6S\u0000"+
		"\u03e2\u03e4\u0003\u00a2Q\u0000\u03e3\u03e2\u0001\u0000\u0000\u0000\u03e3"+
		"\u03e4\u0001\u0000\u0000\u0000\u03e4\u03e5\u0001\u0000\u0000\u0000\u03e5"+
		"\u03e6\u00058\u0000\u0000\u03e6\u03e8\u0001\u0000\u0000\u0000\u03e7\u03d8"+
		"\u0001\u0000\u0000\u0000\u03e7\u03dd\u0001\u0000\u0000\u0000\u03e8\u00a1"+
		"\u0001\u0000\u0000\u0000\u03e9\u03ea\u0006Q\uffff\uffff\u0000\u03ea\u03eb"+
		"\u0003\u00a4R\u0000\u03eb\u03f0\u0001\u0000\u0000\u0000\u03ec\u03ed\n"+
		"\u0001\u0000\u0000\u03ed\u03ef\u0003\u00a4R\u0000\u03ee\u03ec\u0001\u0000"+
		"\u0000\u0000\u03ef\u03f2\u0001\u0000\u0000\u0000\u03f0\u03ee\u0001\u0000"+
		"\u0000\u0000\u03f0\u03f1\u0001\u0000\u0000\u0000\u03f1\u00a3\u0001\u0000"+
		"\u0000\u0000\u03f2\u03f0\u0001\u0000\u0000\u0000\u03f3\u03f4\u0005\u000b"+
		"\u0000\u0000\u03f4\u03f5\u0003\\.\u0000\u03f5\u03f7\u0005Z\u0000\u0000"+
		"\u03f6\u03f8\u0003f3\u0000\u03f7\u03f6\u0001\u0000\u0000\u0000\u03f7\u03f8"+
		"\u0001\u0000\u0000\u0000\u03f8\u00a5\u0001\u0000\u0000\u0000\u03f9\u03fa"+
		"\u0005#\u0000\u0000\u03fa\u03fc\u0005Z\u0000\u0000\u03fb\u03fd\u0003f"+
		"3\u0000\u03fc\u03fb\u0001\u0000\u0000\u0000\u03fc\u03fd\u0001\u0000\u0000"+
		"\u0000\u03fd\u00a7\u0001\u0000\u0000\u0000\u03fe\u03ff\u0003\b\u0004\u0000"+
		"\u03ff\u0400\u0005Z\u0000\u0000\u0400\u0401\u0003\u00aaU\u0000\u0401\u00a9"+
		"\u0001\u0000\u0000\u0000\u0402\u0405\u0003^/\u0000\u0403\u0405\u0003\u00b8"+
		"\\\u0000\u0404\u0402\u0001\u0000\u0000\u0000\u0404\u0403\u0001\u0000\u0000"+
		"\u0000\u0405\u00ab\u0001\u0000\u0000\u0000\u0406\u0407\u0005%\u0000\u0000"+
		"\u0407\u0408\u0003\\.\u0000\u0408\u0409\u0003\u0104\u0082\u0000\u0409"+
		"\u00ad\u0001\u0000\u0000\u0000\u040a\u040b\u0005(\u0000\u0000\u040b\u0411"+
		"\u0003d2\u0000\u040c\u0412\u0003\u00b0X\u0000\u040d\u0412\u0003\u00b2"+
		"Y\u0000\u040e\u040f\u0003\u00b0X\u0000\u040f\u0410\u0003\u00b2Y\u0000"+
		"\u0410\u0412\u0001\u0000\u0000\u0000\u0411\u040c\u0001\u0000\u0000\u0000"+
		"\u0411\u040d\u0001\u0000\u0000\u0000\u0411\u040e\u0001\u0000\u0000\u0000"+
		"\u0412\u00af\u0001\u0000\u0000\u0000\u0413\u0414\u0005\u000f\u0000\u0000"+
		"\u0414\u0415\u00055\u0000\u0000\u0415\u0416\u0003\u00b4Z\u0000\u0416\u0417"+
		"\u00056\u0000\u0000\u0417\u0418\u0003d2\u0000\u0418\u00b1\u0001\u0000"+
		"\u0000\u0000\u0419\u041a\u0005\u0018\u0000\u0000\u041a\u041b\u0003d2\u0000"+
		"\u041b\u00b3\u0001\u0000\u0000\u0000\u041c\u041f\u0003\u0006\u0003\u0000"+
		"\u041d\u041f\u0003v;\u0000\u041e\u041c\u0001\u0000\u0000\u0000\u041e\u041d"+
		"\u0001\u0000\u0000\u0000\u041f\u00b5\u0001\u0000\u0000\u0000\u0420\u0421"+
		"\u0005 \u0000\u0000\u0421\u0422\u0003\u0104\u0082\u0000\u0422\u00b7\u0001"+
		"\u0000\u0000\u0000\u0423\u0425\u0005!\u0000\u0000\u0424\u0426\u0003\u0006"+
		"\u0003\u0000\u0425\u0424\u0001\u0000\u0000\u0000\u0425\u0426\u0001\u0000"+
		"\u0000\u0000\u0426\u0427\u0001\u0000\u0000\u0000\u0427\u0428\u00055\u0000"+
		"\u0000\u0428\u0429\u0003\u00bc^\u0000\u0429\u042a\u00056\u0000\u0000\u042a"+
		"\u042b\u00057\u0000\u0000\u042b\u042c\u0003\u00c4b\u0000\u042c\u042d\u0005"+
		"8\u0000\u0000\u042d\u00b9\u0001\u0000\u0000\u0000\u042e\u042f\u0003\u00bc"+
		"^\u0000\u042f\u00bb\u0001\u0000\u0000\u0000\u0430\u0432\u0003\u00be_\u0000"+
		"\u0431\u0430\u0001\u0000\u0000\u0000\u0431\u0432\u0001\u0000\u0000\u0000"+
		"\u0432\u00bd\u0001\u0000\u0000\u0000\u0433\u0441\u0003\u00c0`\u0000\u0434"+
		"\u0439\u0003\u00c2a\u0000\u0435\u0436\u0005>\u0000\u0000\u0436\u0438\u0003"+
		"\u00c2a\u0000\u0437\u0435\u0001\u0000\u0000\u0000\u0438\u043b\u0001\u0000"+
		"\u0000\u0000\u0439\u0437\u0001\u0000\u0000\u0000\u0439\u043a\u0001\u0000"+
		"\u0000\u0000\u043a\u043e\u0001\u0000\u0000\u0000\u043b\u0439\u0001\u0000"+
		"\u0000\u0000\u043c\u043d\u0005>\u0000\u0000\u043d\u043f\u0003\u00c0`\u0000"+
		"\u043e\u043c\u0001\u0000\u0000\u0000\u043e\u043f\u0001\u0000\u0000\u0000"+
		"\u043f\u0441\u0001\u0000\u0000\u0000\u0440\u0433\u0001\u0000\u0000\u0000"+
		"\u0440\u0434\u0001\u0000\u0000\u0000\u0441\u00bf\u0001\u0000\u0000\u0000"+
		"\u0442\u0443\u0003\u0088D\u0000\u0443\u00c1\u0001\u0000\u0000\u0000\u0444"+
		"\u0445\u0003\u0084B\u0000\u0445\u00c3\u0001\u0000\u0000\u0000\u0446\u0448"+
		"\u0003f3\u0000\u0447\u0446\u0001\u0000\u0000\u0000\u0447\u0448\u0001\u0000"+
		"\u0000\u0000\u0448\u00c5\u0001\u0000\u0000\u0000\u0449\u044a\u0003\u00c8"+
		"d\u0000\u044a\u044b\u0005f\u0000\u0000\u044b\u044c\u0003\u00cae\u0000"+
		"\u044c\u00c7\u0001\u0000\u0000\u0000\u044d\u0451\u0003\u0006\u0003\u0000"+
		"\u044e\u0451\u0003J%\u0000\u044f\u0451\u0003\f\u0006\u0000\u0450\u044d"+
		"\u0001\u0000\u0000\u0000\u0450\u044e\u0001\u0000\u0000\u0000\u0450\u044f"+
		"\u0001\u0000\u0000\u0000\u0451\u00c9\u0001\u0000\u0000\u0000\u0452\u0458"+
		"\u0003H$\u0000\u0453\u0454\u00057\u0000\u0000\u0454\u0455\u0003\u00c4"+
		"b\u0000\u0455\u0456\u00058\u0000\u0000\u0456\u0458\u0001\u0000\u0000\u0000"+
		"\u0457\u0452\u0001\u0000\u0000\u0000\u0457\u0453\u0001\u0000\u0000\u0000"+
		"\u0458\u00cb\u0001\u0000\u0000\u0000\u0459\u045a\u0003 \u0010\u0000\u045a"+
		"\u045b\u00055\u0000\u0000\u045b\u045c\u0003\u00ba]\u0000\u045c\u045d\u0005"+
		"6\u0000\u0000\u045d\u045e\u00057\u0000\u0000\u045e\u045f\u0003\u00c4b"+
		"\u0000\u045f\u0460\u00058\u0000\u0000\u0460\u0474\u0001\u0000\u0000\u0000"+
		"\u0461\u0474\u0003\u00d4j\u0000\u0462\u0463\u0003\u00ceg\u0000\u0463\u0464"+
		"\u0003 \u0010\u0000\u0464\u0465\u00055\u0000\u0000\u0465\u0466\u00056"+
		"\u0000\u0000\u0466\u0467\u00057\u0000\u0000\u0467\u0468\u0003\u00c4b\u0000"+
		"\u0468\u0469\u00058\u0000\u0000\u0469\u0474\u0001\u0000\u0000\u0000\u046a"+
		"\u046b\u0003\u00d0h\u0000\u046b\u046c\u0003 \u0010\u0000\u046c\u046d\u0005"+
		"5\u0000\u0000\u046d\u046e\u0003\u00d2i\u0000\u046e\u046f\u00056\u0000"+
		"\u0000\u046f\u0470\u00057\u0000\u0000\u0470\u0471\u0003\u00c4b\u0000\u0471"+
		"\u0472\u00058\u0000\u0000\u0472\u0474\u0001\u0000\u0000\u0000\u0473\u0459"+
		"\u0001\u0000\u0000\u0000\u0473\u0461\u0001\u0000\u0000\u0000\u0473\u0462"+
		"\u0001\u0000\u0000\u0000\u0473\u046a\u0001\u0000\u0000\u0000\u0474\u00cd"+
		"\u0001\u0000\u0000\u0000\u0475\u0476\u0004g\u0012\u0000\u0476\u0477\u0005"+
		"u\u0000\u0000\u0477\u00cf\u0001\u0000\u0000\u0000\u0478\u0479\u0004h\u0013"+
		"\u0000\u0479\u047a\u0005u\u0000\u0000\u047a\u00d1\u0001\u0000\u0000\u0000"+
		"\u047b\u047c\u0003\u00c2a\u0000\u047c\u00d3\u0001\u0000\u0000\u0000\u047d"+
		"\u047e\u0005I\u0000\u0000\u047e\u047f\u0003 \u0010\u0000\u047f\u0480\u0005"+
		"5\u0000\u0000\u0480\u0481\u0003\u00ba]\u0000\u0481\u0482\u00056\u0000"+
		"\u0000\u0482\u0483\u00057\u0000\u0000\u0483\u0484\u0003\u00c4b\u0000\u0484"+
		"\u0485\u00058\u0000\u0000\u0485\u00d5\u0001\u0000\u0000\u0000\u0486\u0487"+
		"\u0005!\u0000\u0000\u0487\u0489\u0005I\u0000\u0000\u0488\u048a\u0003\u0006"+
		"\u0003\u0000\u0489\u0488\u0001\u0000\u0000\u0000\u0489\u048a\u0001\u0000"+
		"\u0000\u0000\u048a\u048b\u0001\u0000\u0000\u0000\u048b\u048c\u00055\u0000"+
		"\u0000\u048c\u048d\u0003\u00bc^\u0000\u048d\u048e\u00056\u0000\u0000\u048e"+
		"\u048f\u00057\u0000\u0000\u048f\u0490\u0003\u00c4b\u0000\u0490\u0491\u0005"+
		"8\u0000\u0000\u0491\u00d7\u0001\u0000\u0000\u0000\u0492\u0499\u0005\u001f"+
		"\u0000\u0000\u0493\u0494\u0005\u001f\u0000\u0000\u0494\u0499\u0003H$\u0000"+
		"\u0495\u0496\u0005\u001f\u0000\u0000\u0496\u0497\u0005I\u0000\u0000\u0497"+
		"\u0499\u0003H$\u0000\u0498\u0492\u0001\u0000\u0000\u0000\u0498\u0493\u0001"+
		"\u0000\u0000\u0000\u0498\u0495\u0001\u0000\u0000\u0000\u0499\u00d9\u0001"+
		"\u0000\u0000\u0000\u049a\u049c\u0005\u0013\u0000\u0000\u049b\u049d\u0003"+
		"\u0006\u0003\u0000\u049c\u049b\u0001\u0000\u0000\u0000\u049c\u049d\u0001"+
		"\u0000\u0000\u0000\u049d\u04a0\u0001\u0000\u0000\u0000\u049e\u049f\u0005"+
		"\u0014\u0000\u0000\u049f\u04a1\u0003>\u001f\u0000\u04a0\u049e\u0001\u0000"+
		"\u0000\u0000\u04a0\u04a1\u0001\u0000\u0000\u0000\u04a1\u04a2\u0001\u0000"+
		"\u0000\u0000\u04a2\u04a4\u00057\u0000\u0000\u04a3\u04a5\u0003\u00dcn\u0000"+
		"\u04a4\u04a3\u0001\u0000\u0000\u0000\u04a4\u04a5\u0001\u0000\u0000\u0000"+
		"\u04a5\u04a6\u0001\u0000\u0000\u0000\u04a6\u04a7\u00058\u0000\u0000\u04a7"+
		"\u00db\u0001\u0000\u0000\u0000\u04a8\u04aa\u0003\u00deo\u0000\u04a9\u04a8"+
		"\u0001\u0000\u0000\u0000\u04aa\u04ab\u0001\u0000\u0000\u0000\u04ab\u04a9"+
		"\u0001\u0000\u0000\u0000\u04ab\u04ac\u0001\u0000\u0000\u0000\u04ac\u00dd"+
		"\u0001\u0000\u0000\u0000\u04ad\u04b2\u0003\u00ccf\u0000\u04ae\u04af\u0005"+
		"1\u0000\u0000\u04af\u04b2\u0003\u00ccf\u0000\u04b0\u04b2\u0003\u008aE"+
		"\u0000\u04b1\u04ad\u0001\u0000\u0000\u0000\u04b1\u04ae\u0001\u0000\u0000"+
		"\u0000\u04b1\u04b0\u0001\u0000\u0000\u0000\u04b2\u00df\u0001\u0000\u0000"+
		"\u0000\u04b3\u04b5\u0003\u00e2q\u0000\u04b4\u04b3\u0001\u0000\u0000\u0000"+
		"\u04b4\u04b5\u0001\u0000\u0000\u0000\u04b5\u04b6\u0001\u0000\u0000\u0000"+
		"\u04b6\u04b7\u0005\u0000\u0000\u0001\u04b7\u00e1\u0001\u0000\u0000\u0000"+
		"\u04b8\u04ba\u0003\u00e4r\u0000\u04b9\u04b8\u0001\u0000\u0000\u0000\u04ba"+
		"\u04bb\u0001\u0000\u0000\u0000\u04bb\u04b9\u0001\u0000\u0000\u0000\u04bb"+
		"\u04bc\u0001\u0000\u0000\u0000\u04bc\u00e3\u0001\u0000\u0000\u0000\u04bd"+
		"\u04c2\u0003^/\u0000\u04be\u04c2\u0003`0\u0000\u04bf\u04c2\u0003\u00e6"+
		"s\u0000\u04c0\u04c2\u0003\u00fa}\u0000\u04c1\u04bd\u0001\u0000\u0000\u0000"+
		"\u04c1\u04be\u0001\u0000\u0000\u0000\u04c1\u04bf\u0001\u0000\u0000\u0000"+
		"\u04c1\u04c0\u0001\u0000\u0000\u0000\u04c2\u00e5\u0001\u0000\u0000\u0000"+
		"\u04c3\u04c4\u0005\'\u0000\u0000\u04c4\u04c5\u0003\u00e8t\u0000\u04c5"+
		"\u04c6\u0003\u00f0x\u0000\u04c6\u04c7\u0005=\u0000\u0000\u04c7\u04cd\u0001"+
		"\u0000\u0000\u0000\u04c8\u04c9\u0005\'\u0000\u0000\u04c9\u04ca\u0003\u00f6"+
		"{\u0000\u04ca\u04cb\u0005=\u0000\u0000\u04cb\u04cd\u0001\u0000\u0000\u0000"+
		"\u04cc\u04c3\u0001\u0000\u0000\u0000\u04cc\u04c8\u0001\u0000\u0000\u0000"+
		"\u04cd\u00e7\u0001\u0000\u0000\u0000\u04ce\u04da\u0003\u00eau\u0000\u04cf"+
		"\u04da\u0003\u00ecv\u0000\u04d0\u04da\u0003\u00eew\u0000\u04d1\u04d2\u0003"+
		"\u00eau\u0000\u04d2\u04d3\u0005>\u0000\u0000\u04d3\u04d4\u0003\u00ecv"+
		"\u0000\u04d4\u04da\u0001\u0000\u0000\u0000\u04d5\u04d6\u0003\u00eau\u0000"+
		"\u04d6\u04d7\u0005>\u0000\u0000\u04d7\u04d8\u0003\u00eew\u0000\u04d8\u04da"+
		"\u0001\u0000\u0000\u0000\u04d9\u04ce\u0001\u0000\u0000\u0000\u04d9\u04cf"+
		"\u0001\u0000\u0000\u0000\u04d9\u04d0\u0001\u0000\u0000\u0000\u04d9\u04d1"+
		"\u0001\u0000\u0000\u0000\u04d9\u04d5\u0001\u0000\u0000\u0000\u04da\u00e9"+
		"\u0001\u0000\u0000\u0000\u04db\u04dc\u0003\u00f8|\u0000\u04dc\u00eb\u0001"+
		"\u0000\u0000\u0000\u04dd\u04de\u0005I\u0000\u0000\u04de\u04df\u00053\u0000"+
		"\u0000\u04df\u04e0\u0003\u00f8|\u0000\u04e0\u00ed\u0001\u0000\u0000\u0000"+
		"\u04e1\u04e2\u00057\u0000\u0000\u04e2\u04ed\u00058\u0000\u0000\u04e3\u04e4"+
		"\u00057\u0000\u0000\u04e4\u04e5\u0003\u00f2y\u0000\u04e5\u04e6\u00058"+
		"\u0000\u0000\u04e6\u04ed\u0001\u0000\u0000\u0000\u04e7\u04e8\u00057\u0000"+
		"\u0000\u04e8\u04e9\u0003\u00f2y\u0000\u04e9\u04ea\u0005>\u0000\u0000\u04ea"+
		"\u04eb\u00058\u0000\u0000\u04eb\u04ed\u0001\u0000\u0000\u0000\u04ec\u04e1"+
		"\u0001\u0000\u0000\u0000\u04ec\u04e3\u0001\u0000\u0000\u0000\u04ec\u04e7"+
		"\u0001\u0000\u0000\u0000\u04ed\u00ef\u0001\u0000\u0000\u0000\u04ee\u04ef"+
		"\u00054\u0000\u0000\u04ef\u04f0\u0003\u00f6{\u0000\u04f0\u00f1\u0001\u0000"+
		"\u0000\u0000\u04f1\u04f6\u0003\u00f4z\u0000\u04f2\u04f3\u0005>\u0000\u0000"+
		"\u04f3\u04f5\u0003\u00f4z\u0000\u04f4\u04f2\u0001\u0000\u0000\u0000\u04f5"+
		"\u04f8\u0001\u0000\u0000\u0000\u04f6\u04f4\u0001\u0000\u0000\u0000\u04f6"+
		"\u04f7\u0001\u0000\u0000\u0000\u04f7\u00f3\u0001\u0000\u0000\u0000\u04f8"+
		"\u04f6\u0001\u0000\u0000\u0000\u04f9\u04fe\u0003\u00f8|\u0000\u04fa\u04fb"+
		"\u0005u\u0000\u0000\u04fb\u04fc\u00053\u0000\u0000\u04fc\u04fe\u0003\u00f8"+
		"|\u0000\u04fd\u04f9\u0001\u0000\u0000\u0000\u04fd\u04fa\u0001\u0000\u0000"+
		"\u0000\u04fe\u00f5\u0001\u0000\u0000\u0000\u04ff\u0500\u0005o\u0000\u0000"+
		"\u0500\u00f7\u0001\u0000\u0000\u0000\u0501\u0502\u0003\u0006\u0003\u0000"+
		"\u0502\u00f9\u0001\u0000\u0000\u0000\u0503\u0504\u0005\u0010\u0000\u0000"+
		"\u0504\u0505\u0005I\u0000\u0000\u0505\u0506\u0003\u00f0x\u0000\u0506\u0507"+
		"\u0005=\u0000\u0000\u0507\u0521\u0001\u0000\u0000\u0000\u0508\u0509\u0005"+
		"\u0010\u0000\u0000\u0509\u050a\u0003\u00fc~\u0000\u050a\u050b\u0003\u00f0"+
		"x\u0000\u050b\u050c\u0005=\u0000\u0000\u050c\u0521\u0001\u0000\u0000\u0000"+
		"\u050d\u050e\u0005\u0010\u0000\u0000\u050e\u050f\u0003\u00fc~\u0000\u050f"+
		"\u0510\u0005=\u0000\u0000\u0510\u0521\u0001\u0000\u0000\u0000\u0511\u0512"+
		"\u0005\u0010\u0000\u0000\u0512\u0521\u0003p8\u0000\u0513\u0514\u0005\u0010"+
		"\u0000\u0000\u0514\u0521\u0003`0\u0000\u0515\u0516\u0005\u0010\u0000\u0000"+
		"\u0516\u0517\u0005#\u0000\u0000\u0517\u0521\u0003b1\u0000\u0518\u0519"+
		"\u0005\u0010\u0000\u0000\u0519\u051a\u0005#\u0000\u0000\u051a\u0521\u0003"+
		"\u00dam\u0000\u051b\u051c\u0005\u0010\u0000\u0000\u051c\u051d\u0005#\u0000"+
		"\u0000\u051d\u051e\u0003H$\u0000\u051e\u051f\u0005=\u0000\u0000\u051f"+
		"\u0521\u0001\u0000\u0000\u0000\u0520\u0503\u0001\u0000\u0000\u0000\u0520"+
		"\u0508\u0001\u0000\u0000\u0000\u0520\u050d\u0001\u0000\u0000\u0000\u0520"+
		"\u0511\u0001\u0000\u0000\u0000\u0520\u0513\u0001\u0000\u0000\u0000\u0520"+
		"\u0515\u0001\u0000\u0000\u0000\u0520\u0518\u0001\u0000\u0000\u0000\u0520"+
		"\u051b\u0001\u0000\u0000\u0000\u0521\u00fb\u0001\u0000\u0000\u0000\u0522"+
		"\u0523\u00057\u0000\u0000\u0523\u052e\u00058\u0000\u0000\u0524\u0525\u0005"+
		"7\u0000\u0000\u0525\u0526\u0003\u00fe\u007f\u0000\u0526\u0527\u00058\u0000"+
		"\u0000\u0527\u052e\u0001\u0000\u0000\u0000\u0528\u0529\u00057\u0000\u0000"+
		"\u0529\u052a\u0003\u00fe\u007f\u0000\u052a\u052b\u0005>\u0000\u0000\u052b"+
		"\u052c\u00058\u0000\u0000\u052c\u052e\u0001\u0000\u0000\u0000\u052d\u0522"+
		"\u0001\u0000\u0000\u0000\u052d\u0524\u0001\u0000\u0000\u0000\u052d\u0528"+
		"\u0001\u0000\u0000\u0000\u052e\u00fd\u0001\u0000\u0000\u0000\u052f\u0534"+
		"\u0003\u0100\u0080\u0000\u0530\u0531\u0005>\u0000\u0000\u0531\u0533\u0003"+
		"\u0100\u0080\u0000\u0532\u0530\u0001\u0000\u0000\u0000\u0533\u0536\u0001"+
		"\u0000\u0000\u0000\u0534\u0532\u0001\u0000\u0000\u0000\u0534\u0535\u0001"+
		"\u0000\u0000\u0000\u0535\u00ff\u0001\u0000\u0000\u0000\u0536\u0534\u0001"+
		"\u0000\u0000\u0000\u0537\u053a\u0007\r\u0000\u0000\u0538\u0539\u00053"+
		"\u0000\u0000\u0539\u053b\u0007\r\u0000\u0000\u053a\u0538\u0001\u0000\u0000"+
		"\u0000\u053a\u053b\u0001\u0000\u0000\u0000\u053b\u0101\u0001\u0000\u0000"+
		"\u0000\u053c\u053d\u0007\u000e\u0000\u0000\u053d\u0103\u0001\u0000\u0000"+
		"\u0000\u053e\u0542\u0005=\u0000\u0000\u053f\u0542\u0005\u0000\u0000\u0001"+
		"\u0540\u0542\u0004\u0082\u0014\u0000\u0541\u053e\u0001\u0000\u0000\u0000"+
		"\u0541\u053f\u0001\u0000\u0000\u0000\u0541\u0540\u0001\u0000\u0000\u0000"+
		"\u0542\u0105\u0001\u0000\u0000\u0000\u0085\u011b\u0122\u0126\u012e\u0137"+
		"\u013b\u0141\u0145\u0149\u0151\u0159\u015b\u0164\u016e\u0172\u0177\u0188"+
		"\u018e\u0199\u01a4\u01b0\u01b2\u01bd\u01d3\u01d7\u01dc\u01e1\u01e6\u01ec"+
		"\u01f2\u01fa\u01fe\u0203\u021d\u021f\u0228\u0235\u0239\u023e\u0240\u0246"+
		"\u0249\u0254\u0257\u025b\u0262\u026a\u026e\u0274\u027a\u027e\u0288\u029a"+
		"\u029f\u02a3\u02a7\u02ad\u02af\u02bc\u02c1\u02c5\u02c7\u02d2\u02d7\u02db"+
		"\u02df\u02e1\u02e5\u02f2\u02f6\u02f9\u0304\u0307\u030b\u0312\u031a\u031e"+
		"\u0327\u032c\u032e\u0332\u0344\u0357\u035b\u035f\u0369\u036d\u0376\u037a"+
		"\u03b1\u03b8\u03bc\u03c2\u03c8\u03da\u03df\u03e3\u03e7\u03f0\u03f7\u03fc"+
		"\u0404\u0411\u041e\u0425\u0431\u0439\u043e\u0440\u0447\u0450\u0457\u0473"+
		"\u0489\u0498\u049c\u04a0\u04a4\u04ab\u04b1\u04b4\u04bb\u04c1\u04cc\u04d9"+
		"\u04ec\u04f6\u04fd\u0520\u052d\u0534\u053a\u0541";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
