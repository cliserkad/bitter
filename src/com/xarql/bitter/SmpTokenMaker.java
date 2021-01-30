package com.xarql.bitter;

import com.xarql.smp.antlr.SimpleLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;

public class SmpTokenMaker extends AntlrTokenMaker {

	@Override
	public Lexer genAntlrLexer(String code) {
		return new SimpleLexer(CharStreams.fromString(code));
	}

}
