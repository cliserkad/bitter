package com.xarql.bitter;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import com.xarql.kdl.antlr.kdlLexerModified;

public class KdlTokenMaker extends AntlrTokenMaker {

	@Override
	public Lexer genAntlrLexer(final String code) {
		return new kdlLexerModified(CharStreams.fromString(code));
	}

}
