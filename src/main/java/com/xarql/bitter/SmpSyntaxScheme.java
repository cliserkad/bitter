package com.xarql.bitter;

import org.fife.ui.rsyntaxtextarea.Style;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;

import java.awt.*;

import static com.xarql.smp.antlr.SimpleLexer.*;

public class SmpSyntaxScheme extends SyntaxScheme {

	public SmpSyntaxScheme() {
		super(true);
	}

	@Override
	public Style getStyle(int index) {
		final var style = new Style();
		final Color color;
		switch(index) {
			case NULL:
			case TRUE:
			case FALSE:
				color = new Color(139, 233, 253);
				break;
			case COMMENT:
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
