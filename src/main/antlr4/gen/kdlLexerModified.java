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
		COMMENT=1, BLOCK_COMMENT=2, WS=3, QUOTE=4, STRING_LIT=5, CHAR_LIT=6, TYPE=7, 
		CONST=8, MAIN=9, RETURN=10, USE=11, PATH=12, IF=13, ELSE=14, NULL=15, 
		ASSERT=16, WHILE=17, FOR=18, THIS=19, BOOLEAN=20, BYTE=21, SHORT=22, CHAR=23, 
		INT=24, FLOAT=25, LONG=26, DOUBLE=27, STRING=28, TRUE=29, FALSE=30, CURL_L=31, 
		CURL_R=32, PAREN_L=33, PAREN_R=34, BRACE_L=35, BRACE_R=36, DOT=37, SLASH=38, 
		COMMA=39, SEMICOLON=40, COLON=41, TILDE=42, QUESTION_MARK=43, NOT_EQUAL=44, 
		EQUAL=45, LESS_THAN=46, MORE_THAN=47, LESS_OR_EQUAL=48, MORE_OR_EQUAL=49, 
		ADDRESS_EQUAL=50, ADDRESS_NOT_EQUAL=51, IS_A=52, IS_NOT_A=53, PLUS=54, 
		MINUS=55, MULTIPLY=56, MODULUS=57, NOT=58, INCREMENT=59, DECREMENT=60, 
		BIT_SHIFT_LEFT=61, BIT_SHIFT_RIGHT=62, BIT_SHIFT_RIGHT_UNSIGNED=63, BIT_AND=64, 
		BIT_OR=65, BIT_XOR=66, AND=67, OR=68, XOR=69, HEX_LIT=70, BIN_LIT=71, 
		NUMBER=72, FRACTION=73, IDENTIFIER=74, UNMATCHED=75;
	public static final int
		EXTRA=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN", "EXTRA"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "BLOCK_COMMENT", "WS", "QUOTE", "STRING_LIT", "CHAR_LIT", 
			"TYPE", "CONST", "MAIN", "RETURN", "USE", "PATH", "IF", "ELSE", "NULL", 
			"ASSERT", "WHILE", "FOR", "THIS", "BOOLEAN", "BYTE", "SHORT", "CHAR", 
			"INT", "FLOAT", "LONG", "DOUBLE", "STRING", "TRUE", "FALSE", "CURL_L", 
			"CURL_R", "PAREN_L", "PAREN_R", "BRACE_L", "BRACE_R", "DOT", "SLASH", 
			"COMMA", "SEMICOLON", "COLON", "TILDE", "QUESTION_MARK", "NOT_EQUAL", 
			"EQUAL", "LESS_THAN", "MORE_THAN", "LESS_OR_EQUAL", "MORE_OR_EQUAL", 
			"ADDRESS_EQUAL", "ADDRESS_NOT_EQUAL", "IS_A", "IS_NOT_A", "PLUS", "MINUS", 
			"MULTIPLY", "MODULUS", "NOT", "INCREMENT", "DECREMENT", "BIT_SHIFT_LEFT", 
			"BIT_SHIFT_RIGHT", "BIT_SHIFT_RIGHT_UNSIGNED", "BIT_AND", "BIT_OR", "BIT_XOR", 
			"AND", "OR", "XOR", "HEX_LIT", "BIN_LIT", "NUMBER", "FRACTION", "IDENTIFIER", 
			"UNMATCHED"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'\"'", null, null, "'type'", "'const'", "'main'", 
			"'return'", "'use'", "'path'", "'if'", "'else'", "'null'", "'assert'", 
			"'while'", "'for'", "'this'", "'boolean'", "'byte'", "'short'", "'char'", 
			"'int'", "'float'", "'long'", "'double'", "'string'", "'true'", "'false'", 
			"'{'", "'}'", "'('", "')'", "'['", "']'", "'.'", "'/'", "','", "';'", 
			"':'", "'~'", "'?'", "'!='", "'='", "'<'", "'>'", "'<='", "'>='", "'@'", 
			"'!@'", "'#'", "'!#'", "'+'", "'-'", "'*'", "'%'", "'!'", "'++'", "'--'", 
			"'<<'", "'>>'", "'>>>'", "'&'", "'|'", "'^'", "'&&'", "'||'", "'^^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "BLOCK_COMMENT", "WS", "QUOTE", "STRING_LIT", "CHAR_LIT", 
			"TYPE", "CONST", "MAIN", "RETURN", "USE", "PATH", "IF", "ELSE", "NULL", 
			"ASSERT", "WHILE", "FOR", "THIS", "BOOLEAN", "BYTE", "SHORT", "CHAR", 
			"INT", "FLOAT", "LONG", "DOUBLE", "STRING", "TRUE", "FALSE", "CURL_L", 
			"CURL_R", "PAREN_L", "PAREN_R", "BRACE_L", "BRACE_R", "DOT", "SLASH", 
			"COMMA", "SEMICOLON", "COLON", "TILDE", "QUESTION_MARK", "NOT_EQUAL", 
			"EQUAL", "LESS_THAN", "MORE_THAN", "LESS_OR_EQUAL", "MORE_OR_EQUAL", 
			"ADDRESS_EQUAL", "ADDRESS_NOT_EQUAL", "IS_A", "IS_NOT_A", "PLUS", "MINUS", 
			"MULTIPLY", "MODULUS", "NOT", "INCREMENT", "DECREMENT", "BIT_SHIFT_LEFT", 
			"BIT_SHIFT_RIGHT", "BIT_SHIFT_RIGHT_UNSIGNED", "BIT_AND", "BIT_OR", "BIT_XOR", 
			"AND", "OR", "XOR", "HEX_LIT", "BIN_LIT", "NUMBER", "FRACTION", "IDENTIFIER", 
			"UNMATCHED"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2M\u01d4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\3\2\3\2\3\2\3\2\7\2\u009e\n\2\f\2\16\2\u00a1\13"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u00ab\n\3\f\3\16\3\u00ae\13\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\6\4\u00b6\n\4\r\4\16\4\u00b7\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\7\6\u00c2\n\6\f\6\16\6\u00c5\13\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3"+
		"*\3+\3+\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3\67\3\67\38\3"+
		"8\39\39\3:\3:\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3?\3@\3@\3@\3@\3"+
		"A\3A\3B\3B\3C\3C\3D\3D\3D\3E\3E\3E\3F\3F\3F\3G\3G\3G\3G\7G\u01b0\nG\f"+
		"G\16G\u01b3\13G\3H\3H\3H\3H\3H\7H\u01ba\nH\fH\16H\u01bd\13H\3I\3I\7I\u01c1"+
		"\nI\fI\16I\u01c4\13I\3J\3J\3J\3J\3K\3K\7K\u01cc\nK\fK\16K\u01cf\13K\3"+
		"L\3L\3L\3L\4\u009f\u00ac\2M\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a"+
		"\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087"+
		"E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\3\2\13\5\2\13"+
		"\f\17\17\"\"\4\2$$^^\5\2\62;CHch\3\2\62\63\5\2..\62\63aa\3\2\62;\5\2."+
		".\62;aa\n\2\13\f\17\17\"$\'.\60A]]__}\u0080\13\2\13\f\17\17\"$\'.\60\61"+
		"<A]]__}\u0080\2\u01dc\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2"+
		"\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2"+
		"w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2"+
		"\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2"+
		"\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\3\u0099\3\2\2\2\5\u00a6\3\2\2\2\7\u00b5"+
		"\3\2\2\2\t\u00bb\3\2\2\2\13\u00bd\3\2\2\2\r\u00c8\3\2\2\2\17\u00cc\3\2"+
		"\2\2\21\u00d1\3\2\2\2\23\u00d7\3\2\2\2\25\u00dc\3\2\2\2\27\u00e3\3\2\2"+
		"\2\31\u00e7\3\2\2\2\33\u00ec\3\2\2\2\35\u00ef\3\2\2\2\37\u00f4\3\2\2\2"+
		"!\u00f9\3\2\2\2#\u0100\3\2\2\2%\u0106\3\2\2\2\'\u010a\3\2\2\2)\u010f\3"+
		"\2\2\2+\u0117\3\2\2\2-\u011c\3\2\2\2/\u0122\3\2\2\2\61\u0127\3\2\2\2\63"+
		"\u012b\3\2\2\2\65\u0131\3\2\2\2\67\u0136\3\2\2\29\u013d\3\2\2\2;\u0144"+
		"\3\2\2\2=\u0149\3\2\2\2?\u014f\3\2\2\2A\u0151\3\2\2\2C\u0153\3\2\2\2E"+
		"\u0155\3\2\2\2G\u0157\3\2\2\2I\u0159\3\2\2\2K\u015b\3\2\2\2M\u015d\3\2"+
		"\2\2O\u015f\3\2\2\2Q\u0161\3\2\2\2S\u0163\3\2\2\2U\u0165\3\2\2\2W\u0167"+
		"\3\2\2\2Y\u0169\3\2\2\2[\u016c\3\2\2\2]\u016e\3\2\2\2_\u0170\3\2\2\2a"+
		"\u0172\3\2\2\2c\u0175\3\2\2\2e\u0178\3\2\2\2g\u017a\3\2\2\2i\u017d\3\2"+
		"\2\2k\u017f\3\2\2\2m\u0182\3\2\2\2o\u0184\3\2\2\2q\u0186\3\2\2\2s\u0188"+
		"\3\2\2\2u\u018a\3\2\2\2w\u018c\3\2\2\2y\u018f\3\2\2\2{\u0192\3\2\2\2}"+
		"\u0195\3\2\2\2\177\u0198\3\2\2\2\u0081\u019c\3\2\2\2\u0083\u019e\3\2\2"+
		"\2\u0085\u01a0\3\2\2\2\u0087\u01a2\3\2\2\2\u0089\u01a5\3\2\2\2\u008b\u01a8"+
		"\3\2\2\2\u008d\u01ab\3\2\2\2\u008f\u01b4\3\2\2\2\u0091\u01be\3\2\2\2\u0093"+
		"\u01c5\3\2\2\2\u0095\u01c9\3\2\2\2\u0097\u01d0\3\2\2\2\u0099\u009a\7\61"+
		"\2\2\u009a\u009b\7\61\2\2\u009b\u009f\3\2\2\2\u009c\u009e\13\2\2\2\u009d"+
		"\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u00a0\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7\f\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\b\2\2\2\u00a5\4\3\2\2\2\u00a6\u00a7\7\61\2"+
		"\2\u00a7\u00a8\7,\2\2\u00a8\u00ac\3\2\2\2\u00a9\u00ab\13\2\2\2\u00aa\u00a9"+
		"\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad"+
		"\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7,\2\2\u00b0\u00b1\7\61"+
		"\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\3\2\2\u00b3\6\3\2\2\2\u00b4\u00b6"+
		"\t\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\b\4\2\2\u00ba\b\3\2\2\2"+
		"\u00bb\u00bc\7$\2\2\u00bc\n\3\2\2\2\u00bd\u00c3\5\t\5\2\u00be\u00c2\n"+
		"\3\2\2\u00bf\u00c0\7^\2\2\u00c0\u00c2\13\2\2\2\u00c1\u00be\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\5\t\5\2\u00c7"+
		"\f\3\2\2\2\u00c8\u00c9\7)\2\2\u00c9\u00ca\13\2\2\2\u00ca\u00cb\7)\2\2"+
		"\u00cb\16\3\2\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7{\2\2\u00ce\u00cf\7"+
		"r\2\2\u00cf\u00d0\7g\2\2\u00d0\20\3\2\2\2\u00d1\u00d2\7e\2\2\u00d2\u00d3"+
		"\7q\2\2\u00d3\u00d4\7p\2\2\u00d4\u00d5\7u\2\2\u00d5\u00d6\7v\2\2\u00d6"+
		"\22\3\2\2\2\u00d7\u00d8\7o\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da\7k\2\2\u00da"+
		"\u00db\7p\2\2\u00db\24\3\2\2\2\u00dc\u00dd\7t\2\2\u00dd\u00de\7g\2\2\u00de"+
		"\u00df\7v\2\2\u00df\u00e0\7w\2\2\u00e0\u00e1\7t\2\2\u00e1\u00e2\7p\2\2"+
		"\u00e2\26\3\2\2\2\u00e3\u00e4\7w\2\2\u00e4\u00e5\7u\2\2\u00e5\u00e6\7"+
		"g\2\2\u00e6\30\3\2\2\2\u00e7\u00e8\7r\2\2\u00e8\u00e9\7c\2\2\u00e9\u00ea"+
		"\7v\2\2\u00ea\u00eb\7j\2\2\u00eb\32\3\2\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee"+
		"\7h\2\2\u00ee\34\3\2\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f2"+
		"\7u\2\2\u00f2\u00f3\7g\2\2\u00f3\36\3\2\2\2\u00f4\u00f5\7p\2\2\u00f5\u00f6"+
		"\7w\2\2\u00f6\u00f7\7n\2\2\u00f7\u00f8\7n\2\2\u00f8 \3\2\2\2\u00f9\u00fa"+
		"\7c\2\2\u00fa\u00fb\7u\2\2\u00fb\u00fc\7u\2\2\u00fc\u00fd\7g\2\2\u00fd"+
		"\u00fe\7t\2\2\u00fe\u00ff\7v\2\2\u00ff\"\3\2\2\2\u0100\u0101\7y\2\2\u0101"+
		"\u0102\7j\2\2\u0102\u0103\7k\2\2\u0103\u0104\7n\2\2\u0104\u0105\7g\2\2"+
		"\u0105$\3\2\2\2\u0106\u0107\7h\2\2\u0107\u0108\7q\2\2\u0108\u0109\7t\2"+
		"\2\u0109&\3\2\2\2\u010a\u010b\7v\2\2\u010b\u010c\7j\2\2\u010c\u010d\7"+
		"k\2\2\u010d\u010e\7u\2\2\u010e(\3\2\2\2\u010f\u0110\7d\2\2\u0110\u0111"+
		"\7q\2\2\u0111\u0112\7q\2\2\u0112\u0113\7n\2\2\u0113\u0114\7g\2\2\u0114"+
		"\u0115\7c\2\2\u0115\u0116\7p\2\2\u0116*\3\2\2\2\u0117\u0118\7d\2\2\u0118"+
		"\u0119\7{\2\2\u0119\u011a\7v\2\2\u011a\u011b\7g\2\2\u011b,\3\2\2\2\u011c"+
		"\u011d\7u\2\2\u011d\u011e\7j\2\2\u011e\u011f\7q\2\2\u011f\u0120\7t\2\2"+
		"\u0120\u0121\7v\2\2\u0121.\3\2\2\2\u0122\u0123\7e\2\2\u0123\u0124\7j\2"+
		"\2\u0124\u0125\7c\2\2\u0125\u0126\7t\2\2\u0126\60\3\2\2\2\u0127\u0128"+
		"\7k\2\2\u0128\u0129\7p\2\2\u0129\u012a\7v\2\2\u012a\62\3\2\2\2\u012b\u012c"+
		"\7h\2\2\u012c\u012d\7n\2\2\u012d\u012e\7q\2\2\u012e\u012f\7c\2\2\u012f"+
		"\u0130\7v\2\2\u0130\64\3\2\2\2\u0131\u0132\7n\2\2\u0132\u0133\7q\2\2\u0133"+
		"\u0134\7p\2\2\u0134\u0135\7i\2\2\u0135\66\3\2\2\2\u0136\u0137\7f\2\2\u0137"+
		"\u0138\7q\2\2\u0138\u0139\7w\2\2\u0139\u013a\7d\2\2\u013a\u013b\7n\2\2"+
		"\u013b\u013c\7g\2\2\u013c8\3\2\2\2\u013d\u013e\7u\2\2\u013e\u013f\7v\2"+
		"\2\u013f\u0140\7t\2\2\u0140\u0141\7k\2\2\u0141\u0142\7p\2\2\u0142\u0143"+
		"\7i\2\2\u0143:\3\2\2\2\u0144\u0145\7v\2\2\u0145\u0146\7t\2\2\u0146\u0147"+
		"\7w\2\2\u0147\u0148\7g\2\2\u0148<\3\2\2\2\u0149\u014a\7h\2\2\u014a\u014b"+
		"\7c\2\2\u014b\u014c\7n\2\2\u014c\u014d\7u\2\2\u014d\u014e\7g\2\2\u014e"+
		">\3\2\2\2\u014f\u0150\7}\2\2\u0150@\3\2\2\2\u0151\u0152\7\177\2\2\u0152"+
		"B\3\2\2\2\u0153\u0154\7*\2\2\u0154D\3\2\2\2\u0155\u0156\7+\2\2\u0156F"+
		"\3\2\2\2\u0157\u0158\7]\2\2\u0158H\3\2\2\2\u0159\u015a\7_\2\2\u015aJ\3"+
		"\2\2\2\u015b\u015c\7\60\2\2\u015cL\3\2\2\2\u015d\u015e\7\61\2\2\u015e"+
		"N\3\2\2\2\u015f\u0160\7.\2\2\u0160P\3\2\2\2\u0161\u0162\7=\2\2\u0162R"+
		"\3\2\2\2\u0163\u0164\7<\2\2\u0164T\3\2\2\2\u0165\u0166\7\u0080\2\2\u0166"+
		"V\3\2\2\2\u0167\u0168\7A\2\2\u0168X\3\2\2\2\u0169\u016a\7#\2\2\u016a\u016b"+
		"\7?\2\2\u016bZ\3\2\2\2\u016c\u016d\7?\2\2\u016d\\\3\2\2\2\u016e\u016f"+
		"\7>\2\2\u016f^\3\2\2\2\u0170\u0171\7@\2\2\u0171`\3\2\2\2\u0172\u0173\7"+
		">\2\2\u0173\u0174\7?\2\2\u0174b\3\2\2\2\u0175\u0176\7@\2\2\u0176\u0177"+
		"\7?\2\2\u0177d\3\2\2\2\u0178\u0179\7B\2\2\u0179f\3\2\2\2\u017a\u017b\7"+
		"#\2\2\u017b\u017c\7B\2\2\u017ch\3\2\2\2\u017d\u017e\7%\2\2\u017ej\3\2"+
		"\2\2\u017f\u0180\7#\2\2\u0180\u0181\7%\2\2\u0181l\3\2\2\2\u0182\u0183"+
		"\7-\2\2\u0183n\3\2\2\2\u0184\u0185\7/\2\2\u0185p\3\2\2\2\u0186\u0187\7"+
		",\2\2\u0187r\3\2\2\2\u0188\u0189\7\'\2\2\u0189t\3\2\2\2\u018a\u018b\7"+
		"#\2\2\u018bv\3\2\2\2\u018c\u018d\7-\2\2\u018d\u018e\7-\2\2\u018ex\3\2"+
		"\2\2\u018f\u0190\7/\2\2\u0190\u0191\7/\2\2\u0191z\3\2\2\2\u0192\u0193"+
		"\7>\2\2\u0193\u0194\7>\2\2\u0194|\3\2\2\2\u0195\u0196\7@\2\2\u0196\u0197"+
		"\7@\2\2\u0197~\3\2\2\2\u0198\u0199\7@\2\2\u0199\u019a\7@\2\2\u019a\u019b"+
		"\7@\2\2\u019b\u0080\3\2\2\2\u019c\u019d\7(\2\2\u019d\u0082\3\2\2\2\u019e"+
		"\u019f\7~\2\2\u019f\u0084\3\2\2\2\u01a0\u01a1\7`\2\2\u01a1\u0086\3\2\2"+
		"\2\u01a2\u01a3\7(\2\2\u01a3\u01a4\7(\2\2\u01a4\u0088\3\2\2\2\u01a5\u01a6"+
		"\7~\2\2\u01a6\u01a7\7~\2\2\u01a7\u008a\3\2\2\2\u01a8\u01a9\7`\2\2\u01a9"+
		"\u01aa\7`\2\2\u01aa\u008c\3\2\2\2\u01ab\u01ac\7\62\2\2\u01ac\u01ad\7z"+
		"\2\2\u01ad\u01b1\3\2\2\2\u01ae\u01b0\t\4\2\2\u01af\u01ae\3\2\2\2\u01b0"+
		"\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u008e\3\2"+
		"\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b5\7\62\2\2\u01b5\u01b6\7d\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7\u01bb\t\5\2\2\u01b8\u01ba\t\6\2\2\u01b9\u01b8\3\2"+
		"\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc"+
		"\u0090\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be\u01c2\t\7\2\2\u01bf\u01c1\t\b"+
		"\2\2\u01c0\u01bf\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2"+
		"\u01c3\3\2\2\2\u01c3\u0092\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c6\5\u0091"+
		"I\2\u01c6\u01c7\5K&\2\u01c7\u01c8\5\u0091I\2\u01c8\u0094\3\2\2\2\u01c9"+
		"\u01cd\n\t\2\2\u01ca\u01cc\n\n\2\2\u01cb\u01ca\3\2\2\2\u01cc\u01cf\3\2"+
		"\2\2\u01cd\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u0096\3\2\2\2\u01cf"+
		"\u01cd\3\2\2\2\u01d0\u01d1\13\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\b"+
		"L\2\2\u01d3\u0098\3\2\2\2\f\2\u009f\u00ac\u00b7\u00c1\u00c3\u01b1\u01bb"+
		"\u01c2\u01cd\3\2\4\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}