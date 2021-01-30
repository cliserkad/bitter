package com.xarql.bitter;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class SyntaxErrorHandler extends BaseErrorListener {

	@Override
	public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol, final int line, final int column, final String msg, final RecognitionException e) {
		System.out.println(msg + " on line " + line + " at column " + column);
	}

}
