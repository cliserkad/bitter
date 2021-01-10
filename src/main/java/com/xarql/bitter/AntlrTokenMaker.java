package com.xarql.bitter;

import com.xarql.kdl.antlr.kdlLexerModified;
import org.antlr.v4.runtime.Lexer;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenImpl;
import org.fife.ui.rsyntaxtextarea.TokenMakerBase;

import javax.swing.text.Segment;
import java.util.LinkedList;
import java.util.List;

public abstract class AntlrTokenMaker extends TokenMakerBase {

    public Token toList(Segment text, int offset, List<org.antlr.v4.runtime.Token> tokens) {
        if(tokens.isEmpty()) {
            return null;
        } else {
            var firstToken = tokens.get(0);
            var token = new TokenImpl(
                    text,
                    text.offset + firstToken.getStartIndex(),
                    text.offset + firstToken.getStartIndex() + firstToken.getText().length() - 1,
                    offset + firstToken.getStartIndex(),
                    firstToken.getType(),
                    0);
            token.setNextToken(toList(text, offset, tokens.subList(1, tokens.size())));
            return token;
        }
    }

    @Override
    public Token getTokenList(Segment text, int initialTokenType, int offset) {
        if(text == null) {
            throw new IllegalArgumentException();
        }
        var lexer = genAntlrLexer(text.toString());
        lexer.removeErrorListeners();
        lexer.addErrorListener(new SyntaxErrorHandler());
        var tokens = new LinkedList<org.antlr.v4.runtime.Token>();
        while (!lexer._hitEOF) {
            tokens.add(lexer.nextToken());
        }
        return toList(text, offset, tokens);
    }

    public abstract Lexer genAntlrLexer(String code);

}
