package com.xarql.bitter;

import com.xarql.kdl.antlr.kdlLexerModified;
import org.fife.ui.rsyntaxtextarea.Style;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;

import java.awt.*;

import static com.xarql.kdl.antlr.kdlLexerModified.*;

public class KdlSyntaxScheme extends SyntaxScheme {

    public KdlSyntaxScheme() {
        super(true);
    }

    @Override
    public Style getStyle(int index) {
        Style style = new Style();
        final Color color;
        switch(index) {
            case BOOLEAN:
            case BYTE:
            case SHORT:
            case CHAR:
            case INT:
            case FLOAT:
            case LONG:
            case DOUBLE:
            case STRING:
            case TYPE:
            case CONST:
            case MAIN:
            case RETURN:
            case USE:
            case PATH:
            case IF:
            case ELSE:
            case NULL:
            case ASSERT:
            case WHILE:
            case FOR:
            case THIS:
            case TRUE:
            case FALSE:
                color = new Color(139, 233, 253);
                break;
            case COMMENT:
            case COMMENT_TEXT:
                color = new Color(80, 250, 123);
                break;
            case STRING_LIT:
            case QUOTE:
                color = new Color(189, 147, 249);
                break;
            default:
                color = Color.WHITE;
        }
        style.foreground = color;
        return style;
    }

}
