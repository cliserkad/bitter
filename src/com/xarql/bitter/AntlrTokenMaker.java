package com.xarql.bitter;

import java.util.LinkedList;
import java.util.List;
import javax.swing.text.Segment;
import org.antlr.v4.runtime.Lexer;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenImpl;
import org.fife.ui.rsyntaxtextarea.TokenMakerBase;

public abstract class AntlrTokenMaker extends TokenMakerBase {

	public abstract Lexer genAntlrLexer(String code);

	@Override
	public Token getTokenList(final Segment text, final int initialTokenType, final int offset) {
		if(text == null) {
			throw new IllegalArgumentException();
		}
		final var lexer = genAntlrLexer(text.toString());
		lexer.removeErrorListeners();
		lexer.addErrorListener(new SyntaxErrorHandler());
		final var tokens = new LinkedList<org.antlr.v4.runtime.Token>();
		while(!lexer._hitEOF) {
			tokens.add(lexer.nextToken());
		}
		return toList(text, offset, tokens);
	}

	public Token toList(final Segment text, final int offset, final List<org.antlr.v4.runtime.Token> tokens) {
		if(tokens.isEmpty()) {
			return null;
		} else {
			final var firstToken = tokens.get(0);
			final var token = new TokenImpl(text, text.offset + firstToken.getStartIndex(), text.offset + firstToken.getStartIndex() + firstToken.getText().length() - 1,
					offset + firstToken.getStartIndex(), firstToken.getType(), 0);
			token.setNextToken(toList(text, offset, tokens.subList(1, tokens.size())));
			return token;
		}
	}

}
