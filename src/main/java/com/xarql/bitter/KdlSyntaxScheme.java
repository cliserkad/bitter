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
                color = Color.CYAN;
                break;
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
                color = Color.ORANGE;
                break;
            case COMMENT:
                color = Color.GREEN;
                break;
            case STRING_LIT:
                color = Color.MAGENTA;
                break;
            default:
                color = Color.WHITE;
        }
        style.foreground = color;
        return style;
    }

}
