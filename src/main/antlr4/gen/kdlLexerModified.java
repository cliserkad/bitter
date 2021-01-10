// Generated from C:/Users/bryan/Documents/bitter/src/main/antlr4\kdlLexerModified.g4 by ANTLR 4.9

	package com.xarql.kdl.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class kdlLexerModified extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, QUOTE=2, STRING_LIT=3, CHAR_LIT=4, TYPE=5, CONST=6, MAIN=7, RETURN=8, 
		USE=9, PATH=10, IF=11, ELSE=12, NULL=13, ASSERT=14, WHILE=15, FOR=16, 
		THIS=17, BOOLEAN=18, BYTE=19, SHORT=20, CHAR=21, INT=22, FLOAT=23, LONG=24, 
		DOUBLE=25, STRING=26, TRUE=27, FALSE=28, CURL_L=29, CURL_R=30, PAREN_L=31, 
		PAREN_R=32, BRACE_L=33, BRACE_R=34, DOT=35, SLASH=36, COMMA=37, SEMICOLON=38, 
		COLON=39, TILDE=40, QUESTION_MARK=41, NOT_EQUAL=42, EQUAL=43, LESS_THAN=44, 
		MORE_THAN=45, LESS_OR_EQUAL=46, MORE_OR_EQUAL=47, ADDRESS_EQUAL=48, ADDRESS_NOT_EQUAL=49, 
		IS_A=50, IS_NOT_A=51, PLUS=52, MINUS=53, MULTIPLY=54, MODULUS=55, NOT=56, 
		INCREMENT=57, DECREMENT=58, BIT_SHIFT_LEFT=59, BIT_SHIFT_RIGHT=60, BIT_SHIFT_RIGHT_UNSIGNED=61, 
		BIT_AND=62, BIT_OR=63, BIT_XOR=64, AND=65, OR=66, XOR=67, HEX_LIT=68, 
		BIN_LIT=69, NUMBER=70, FRACTION=71, IDENTIFIER=72, UNMATCHED=73, COMMENT_TEXT=74, 
		COMMENT=75;
	public static final int
		COMMENT_MODE=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "COMMENT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "QUOTE", "STRING_LIT", "CHAR_LIT", "TYPE", "CONST", "MAIN", "RETURN", 
			"USE", "PATH", "IF", "ELSE", "NULL", "ASSERT", "WHILE", "FOR", "THIS", 
			"BOOLEAN", "BYTE", "SHORT", "CHAR", "INT", "FLOAT", "LONG", "DOUBLE", 
			"STRING", "TRUE", "FALSE", "CURL_L", "CURL_R", "PAREN_L", "PAREN_R", 
			"BRACE_L", "BRACE_R", "DOT", "SLASH", "COMMA", "SEMICOLON", "COLON", 
			"TILDE", "QUESTION_MARK", "NOT_EQUAL", "EQUAL", "LESS_THAN", "MORE_THAN", 
			"LESS_OR_EQUAL", "MORE_OR_EQUAL", "ADDRESS_EQUAL", "ADDRESS_NOT_EQUAL", 
			"IS_A", "IS_NOT_A", "PLUS", "MINUS", "MULTIPLY", "MODULUS", "NOT", "INCREMENT", 
			"DECREMENT", "BIT_SHIFT_LEFT", "BIT_SHIFT_RIGHT", "BIT_SHIFT_RIGHT_UNSIGNED", 
			"BIT_AND", "BIT_OR", "BIT_XOR", "AND", "OR", "XOR", "HEX_LIT", "BIN_LIT", 
			"NUMBER", "FRACTION", "IDENTIFIER", "UNMATCHED", "COMMENT", "COMMENT_TEXT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'\"'", null, null, "'type'", "'const'", "'main'", "'return'", 
			"'use'", "'path'", "'if'", "'else'", "'null'", "'assert'", "'while'", 
			"'for'", "'this'", "'boolean'", "'byte'", "'short'", "'char'", "'int'", 
			"'float'", "'long'", "'double'", "'string'", "'true'", "'false'", "'{'", 
			"'}'", "'('", "')'", "'['", "']'", "'.'", "'/'", "','", "';'", "':'", 
			"'~'", "'?'", "'!='", "'='", "'<'", "'>'", "'<='", "'>='", "'@'", "'!@'", 
			"'#'", "'!#'", "'+'", "'-'", "'*'", "'%'", "'!'", "'++'", "'--'", "'<<'", 
			"'>>'", "'>>>'", "'&'", "'|'", "'^'", "'&&'", "'||'", "'^^'", null, null, 
			null, null, null, null, null, "'//'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "QUOTE", "STRING_LIT", "CHAR_LIT", "TYPE", "CONST", "MAIN", 
			"RETURN", "USE", "PATH", "IF", "ELSE", "NULL", "ASSERT", "WHILE", "FOR", 
			"THIS", "BOOLEAN", "BYTE", "SHORT", "CHAR", "INT", "FLOAT", "LONG", "DOUBLE", 
			"STRING", "TRUE", "FALSE", "CURL_L", "CURL_R", "PAREN_L", "PAREN_R", 
			"BRACE_L", "BRACE_R", "DOT", "SLASH", "COMMA", "SEMICOLON", "COLON", 
			"TILDE", "QUESTION_MARK", "NOT_EQUAL", "EQUAL", "LESS_THAN", "MORE_THAN", 
			"LESS_OR_EQUAL", "MORE_OR_EQUAL", "ADDRESS_EQUAL", "ADDRESS_NOT_EQUAL", 
			"IS_A", "IS_NOT_A", "PLUS", "MINUS", "MULTIPLY", "MODULUS", "NOT", "INCREMENT", 
			"DECREMENT", "BIT_SHIFT_LEFT", "BIT_SHIFT_RIGHT", "BIT_SHIFT_RIGHT_UNSIGNED", 
			"BIT_AND", "BIT_OR", "BIT_XOR", "AND", "OR", "XOR", "HEX_LIT", "BIN_LIT", 
			"NUMBER", "FRACTION", "IDENTIFIER", "UNMATCHED", "COMMENT_TEXT", "COMMENT"
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


	public kdlLexerModified(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "kdlLexerModified.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2M\u01c7\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\7\4\u00a3\n\4\f"+
		"\4\16\4\u00a6\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,"+
		"\3-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\63\3\63"+
		"\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3:\3;"+
		"\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3B\3C\3C"+
		"\3C\3D\3D\3D\3E\3E\3E\3E\7E\u0191\nE\fE\16E\u0194\13E\3F\3F\3F\3F\3F\7"+
		"F\u019b\nF\fF\16F\u019e\13F\3G\3G\7G\u01a2\nG\fG\16G\u01a5\13G\3H\3H\3"+
		"H\3H\3I\3I\7I\u01ad\nI\fI\16I\u01b0\13I\3J\6J\u01b3\nJ\rJ\16J\u01b4\3"+
		"K\3K\3K\3K\3K\3K\3L\7L\u01be\nL\fL\16L\u01c1\13L\3L\5L\u01c4\nL\3L\3L"+
		"\3\u01b4\2M\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34"+
		"\17\36\20 \21\"\22$\23&\24(\25*\26,\27.\30\60\31\62\32\64\33\66\348\35"+
		":\36<\37> @!B\"D#F$H%J&L\'N(P)R*T+V,X-Z.\\/^\60`\61b\62d\63f\64h\65j\66"+
		"l\67n8p9r:t;v<x=z>|?~@\u0080A\u0082B\u0084C\u0086D\u0088E\u008aF\u008c"+
		"G\u008eH\u0090I\u0092J\u0094K\u0096M\u0098L\4\2\3\f\5\2\13\f\17\17\"\""+
		"\4\2$$^^\5\2\62;CHch\3\2\62\63\5\2..\62\63aa\3\2\62;\5\2..\62;aa\b\2\13"+
		"\f\17\17\".\60A]_}\u0080\t\2\13\f\17\17\".\60\61<A]_}\u0080\3\2\f\f\2"+
		"\u01ce\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16"+
		"\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2"+
		"\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$"+
		"\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3"+
		"\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2"+
		"<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3"+
		"\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2"+
		"\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2"+
		"\2b\3\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n"+
		"\3\2\2\2\2p\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2"+
		"\2\2\2|\3\2\2\2\2~\3\2\2\2\2\u0080\3\2\2\2\2\u0082\3\2\2\2\2\u0084\3\2"+
		"\2\2\2\u0086\3\2\2\2\2\u0088\3\2\2\2\2\u008a\3\2\2\2\2\u008c\3\2\2\2\2"+
		"\u008e\3\2\2\2\2\u0090\3\2\2\2\2\u0092\3\2\2\2\2\u0094\3\2\2\2\2\u0096"+
		"\3\2\2\2\3\u0098\3\2\2\2\4\u009a\3\2\2\2\6\u009c\3\2\2\2\b\u009e\3\2\2"+
		"\2\n\u00a9\3\2\2\2\f\u00ad\3\2\2\2\16\u00b2\3\2\2\2\20\u00b8\3\2\2\2\22"+
		"\u00bd\3\2\2\2\24\u00c4\3\2\2\2\26\u00c8\3\2\2\2\30\u00cd\3\2\2\2\32\u00d0"+
		"\3\2\2\2\34\u00d5\3\2\2\2\36\u00da\3\2\2\2 \u00e1\3\2\2\2\"\u00e7\3\2"+
		"\2\2$\u00eb\3\2\2\2&\u00f0\3\2\2\2(\u00f8\3\2\2\2*\u00fd\3\2\2\2,\u0103"+
		"\3\2\2\2.\u0108\3\2\2\2\60\u010c\3\2\2\2\62\u0112\3\2\2\2\64\u0117\3\2"+
		"\2\2\66\u011e\3\2\2\28\u0125\3\2\2\2:\u012a\3\2\2\2<\u0130\3\2\2\2>\u0132"+
		"\3\2\2\2@\u0134\3\2\2\2B\u0136\3\2\2\2D\u0138\3\2\2\2F\u013a\3\2\2\2H"+
		"\u013c\3\2\2\2J\u013e\3\2\2\2L\u0140\3\2\2\2N\u0142\3\2\2\2P\u0144\3\2"+
		"\2\2R\u0146\3\2\2\2T\u0148\3\2\2\2V\u014a\3\2\2\2X\u014d\3\2\2\2Z\u014f"+
		"\3\2\2\2\\\u0151\3\2\2\2^\u0153\3\2\2\2`\u0156\3\2\2\2b\u0159\3\2\2\2"+
		"d\u015b\3\2\2\2f\u015e\3\2\2\2h\u0160\3\2\2\2j\u0163\3\2\2\2l\u0165\3"+
		"\2\2\2n\u0167\3\2\2\2p\u0169\3\2\2\2r\u016b\3\2\2\2t\u016d\3\2\2\2v\u0170"+
		"\3\2\2\2x\u0173\3\2\2\2z\u0176\3\2\2\2|\u0179\3\2\2\2~\u017d\3\2\2\2\u0080"+
		"\u017f\3\2\2\2\u0082\u0181\3\2\2\2\u0084\u0183\3\2\2\2\u0086\u0186\3\2"+
		"\2\2\u0088\u0189\3\2\2\2\u008a\u018c\3\2\2\2\u008c\u0195\3\2\2\2\u008e"+
		"\u019f\3\2\2\2\u0090\u01a6\3\2\2\2\u0092\u01aa\3\2\2\2\u0094\u01b2\3\2"+
		"\2\2\u0096\u01b6\3\2\2\2\u0098\u01bf\3\2\2\2\u009a\u009b\t\2\2\2\u009b"+
		"\5\3\2\2\2\u009c\u009d\7$\2\2\u009d\7\3\2\2\2\u009e\u00a4\5\6\3\2\u009f"+
		"\u00a3\n\3\2\2\u00a0\u00a1\7^\2\2\u00a1\u00a3\13\2\2\2\u00a2\u009f\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\5\6"+
		"\3\2\u00a8\t\3\2\2\2\u00a9\u00aa\7)\2\2\u00aa\u00ab\13\2\2\2\u00ab\u00ac"+
		"\7)\2\2\u00ac\13\3\2\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7{\2\2\u00af\u00b0"+
		"\7r\2\2\u00b0\u00b1\7g\2\2\u00b1\r\3\2\2\2\u00b2\u00b3\7e\2\2\u00b3\u00b4"+
		"\7q\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6\7u\2\2\u00b6\u00b7\7v\2\2\u00b7"+
		"\17\3\2\2\2\u00b8\u00b9\7o\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7k\2\2\u00bb"+
		"\u00bc\7p\2\2\u00bc\21\3\2\2\2\u00bd\u00be\7t\2\2\u00be\u00bf\7g\2\2\u00bf"+
		"\u00c0\7v\2\2\u00c0\u00c1\7w\2\2\u00c1\u00c2\7t\2\2\u00c2\u00c3\7p\2\2"+
		"\u00c3\23\3\2\2\2\u00c4\u00c5\7w\2\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7"+
		"g\2\2\u00c7\25\3\2\2\2\u00c8\u00c9\7r\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb"+
		"\7v\2\2\u00cb\u00cc\7j\2\2\u00cc\27\3\2\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf"+
		"\7h\2\2\u00cf\31\3\2\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7n\2\2\u00d2\u00d3"+
		"\7u\2\2\u00d3\u00d4\7g\2\2\u00d4\33\3\2\2\2\u00d5\u00d6\7p\2\2\u00d6\u00d7"+
		"\7w\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7n\2\2\u00d9\35\3\2\2\2\u00da\u00db"+
		"\7c\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd\7u\2\2\u00dd\u00de\7g\2\2\u00de"+
		"\u00df\7t\2\2\u00df\u00e0\7v\2\2\u00e0\37\3\2\2\2\u00e1\u00e2\7y\2\2\u00e2"+
		"\u00e3\7j\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7g\2\2"+
		"\u00e6!\3\2\2\2\u00e7\u00e8\7h\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea\7t\2"+
		"\2\u00ea#\3\2\2\2\u00eb\u00ec\7v\2\2\u00ec\u00ed\7j\2\2\u00ed\u00ee\7"+
		"k\2\2\u00ee\u00ef\7u\2\2\u00ef%\3\2\2\2\u00f0\u00f1\7d\2\2\u00f1\u00f2"+
		"\7q\2\2\u00f2\u00f3\7q\2\2\u00f3\u00f4\7n\2\2\u00f4\u00f5\7g\2\2\u00f5"+
		"\u00f6\7c\2\2\u00f6\u00f7\7p\2\2\u00f7\'\3\2\2\2\u00f8\u00f9\7d\2\2\u00f9"+
		"\u00fa\7{\2\2\u00fa\u00fb\7v\2\2\u00fb\u00fc\7g\2\2\u00fc)\3\2\2\2\u00fd"+
		"\u00fe\7u\2\2\u00fe\u00ff\7j\2\2\u00ff\u0100\7q\2\2\u0100\u0101\7t\2\2"+
		"\u0101\u0102\7v\2\2\u0102+\3\2\2\2\u0103\u0104\7e\2\2\u0104\u0105\7j\2"+
		"\2\u0105\u0106\7c\2\2\u0106\u0107\7t\2\2\u0107-\3\2\2\2\u0108\u0109\7"+
		"k\2\2\u0109\u010a\7p\2\2\u010a\u010b\7v\2\2\u010b/\3\2\2\2\u010c\u010d"+
		"\7h\2\2\u010d\u010e\7n\2\2\u010e\u010f\7q\2\2\u010f\u0110\7c\2\2\u0110"+
		"\u0111\7v\2\2\u0111\61\3\2\2\2\u0112\u0113\7n\2\2\u0113\u0114\7q\2\2\u0114"+
		"\u0115\7p\2\2\u0115\u0116\7i\2\2\u0116\63\3\2\2\2\u0117\u0118\7f\2\2\u0118"+
		"\u0119\7q\2\2\u0119\u011a\7w\2\2\u011a\u011b\7d\2\2\u011b\u011c\7n\2\2"+
		"\u011c\u011d\7g\2\2\u011d\65\3\2\2\2\u011e\u011f\7u\2\2\u011f\u0120\7"+
		"v\2\2\u0120\u0121\7t\2\2\u0121\u0122\7k\2\2\u0122\u0123\7p\2\2\u0123\u0124"+
		"\7i\2\2\u0124\67\3\2\2\2\u0125\u0126\7v\2\2\u0126\u0127\7t\2\2\u0127\u0128"+
		"\7w\2\2\u0128\u0129\7g\2\2\u01299\3\2\2\2\u012a\u012b\7h\2\2\u012b\u012c"+
		"\7c\2\2\u012c\u012d\7n\2\2\u012d\u012e\7u\2\2\u012e\u012f\7g\2\2\u012f"+
		";\3\2\2\2\u0130\u0131\7}\2\2\u0131=\3\2\2\2\u0132\u0133\7\177\2\2\u0133"+
		"?\3\2\2\2\u0134\u0135\7*\2\2\u0135A\3\2\2\2\u0136\u0137\7+\2\2\u0137C"+
		"\3\2\2\2\u0138\u0139\7]\2\2\u0139E\3\2\2\2\u013a\u013b\7_\2\2\u013bG\3"+
		"\2\2\2\u013c\u013d\7\60\2\2\u013dI\3\2\2\2\u013e\u013f\7\61\2\2\u013f"+
		"K\3\2\2\2\u0140\u0141\7.\2\2\u0141M\3\2\2\2\u0142\u0143\7=\2\2\u0143O"+
		"\3\2\2\2\u0144\u0145\7<\2\2\u0145Q\3\2\2\2\u0146\u0147\7\u0080\2\2\u0147"+
		"S\3\2\2\2\u0148\u0149\7A\2\2\u0149U\3\2\2\2\u014a\u014b\7#\2\2\u014b\u014c"+
		"\7?\2\2\u014cW\3\2\2\2\u014d\u014e\7?\2\2\u014eY\3\2\2\2\u014f\u0150\7"+
		">\2\2\u0150[\3\2\2\2\u0151\u0152\7@\2\2\u0152]\3\2\2\2\u0153\u0154\7>"+
		"\2\2\u0154\u0155\7?\2\2\u0155_\3\2\2\2\u0156\u0157\7@\2\2\u0157\u0158"+
		"\7?\2\2\u0158a\3\2\2\2\u0159\u015a\7B\2\2\u015ac\3\2\2\2\u015b\u015c\7"+
		"#\2\2\u015c\u015d\7B\2\2\u015de\3\2\2\2\u015e\u015f\7%\2\2\u015fg\3\2"+
		"\2\2\u0160\u0161\7#\2\2\u0161\u0162\7%\2\2\u0162i\3\2\2\2\u0163\u0164"+
		"\7-\2\2\u0164k\3\2\2\2\u0165\u0166\7/\2\2\u0166m\3\2\2\2\u0167\u0168\7"+
		",\2\2\u0168o\3\2\2\2\u0169\u016a\7\'\2\2\u016aq\3\2\2\2\u016b\u016c\7"+
		"#\2\2\u016cs\3\2\2\2\u016d\u016e\7-\2\2\u016e\u016f\7-\2\2\u016fu\3\2"+
		"\2\2\u0170\u0171\7/\2\2\u0171\u0172\7/\2\2\u0172w\3\2\2\2\u0173\u0174"+
		"\7>\2\2\u0174\u0175\7>\2\2\u0175y\3\2\2\2\u0176\u0177\7@\2\2\u0177\u0178"+
		"\7@\2\2\u0178{\3\2\2\2\u0179\u017a\7@\2\2\u017a\u017b\7@\2\2\u017b\u017c"+
		"\7@\2\2\u017c}\3\2\2\2\u017d\u017e\7(\2\2\u017e\177\3\2\2\2\u017f\u0180"+
		"\7~\2\2\u0180\u0081\3\2\2\2\u0181\u0182\7`\2\2\u0182\u0083\3\2\2\2\u0183"+
		"\u0184\7(\2\2\u0184\u0185\7(\2\2\u0185\u0085\3\2\2\2\u0186\u0187\7~\2"+
		"\2\u0187\u0188\7~\2\2\u0188\u0087\3\2\2\2\u0189\u018a\7`\2\2\u018a\u018b"+
		"\7`\2\2\u018b\u0089\3\2\2\2\u018c\u018d\7\62\2\2\u018d\u018e\7z\2\2\u018e"+
		"\u0192\3\2\2\2\u018f\u0191\t\4\2\2\u0190\u018f\3\2\2\2\u0191\u0194\3\2"+
		"\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u008b\3\2\2\2\u0194"+
		"\u0192\3\2\2\2\u0195\u0196\7\62\2\2\u0196\u0197\7d\2\2\u0197\u0198\3\2"+
		"\2\2\u0198\u019c\t\5\2\2\u0199\u019b\t\6\2\2\u019a\u0199\3\2\2\2\u019b"+
		"\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u008d\3\2"+
		"\2\2\u019e\u019c\3\2\2\2\u019f\u01a3\t\7\2\2\u01a0\u01a2\t\b\2\2\u01a1"+
		"\u01a0\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2"+
		"\2\2\u01a4\u008f\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01a7\5\u008eG\2\u01a7"+
		"\u01a8\5H$\2\u01a8\u01a9\5\u008eG\2\u01a9\u0091\3\2\2\2\u01aa\u01ae\n"+
		"\t\2\2\u01ab\u01ad\n\n\2\2\u01ac\u01ab\3\2\2\2\u01ad\u01b0\3\2\2\2\u01ae"+
		"\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u0093\3\2\2\2\u01b0\u01ae\3\2"+
		"\2\2\u01b1\u01b3\13\2\2\2\u01b2\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"\u01b5\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5\u0095\3\2\2\2\u01b6\u01b7\7\61"+
		"\2\2\u01b7\u01b8\7\61\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\bK\2\2\u01ba"+
		"\u01bb\bK\3\2\u01bb\u0097\3\2\2\2\u01bc\u01be\n\13\2\2\u01bd\u01bc\3\2"+
		"\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0"+
		"\u01c3\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c4\7\f\2\2\u01c3\u01c2\3\2"+
		"\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\bL\4\2\u01c6"+
		"\u0099\3\2\2\2\r\2\3\u00a2\u00a4\u0192\u019c\u01a3\u01ae\u01b4\u01bf\u01c3"+
		"\5\4\3\2\5\2\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}