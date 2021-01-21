package com.xarql.bitter;

import java.io.OutputStream;
import java.io.PrintStream;
import org.fife.ui.rtextarea.RTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

public class PrintStreamPane {

	private class AreaOutputStream extends OutputStream {

		public final RTextScrollPane pane = ComponentFactory.scrollableTextPane(new Settings());

		@Override
		public void write(final int b) {
			if(b > Character.MAX_CODE_POINT) {
				for(final byte nb : NOT_A_CHAR_ERROR.getBytes()) {
					write(nb);
				}
			} else {
				final var c = (char) b;
				final var s = c + "";
				area().append(s);
			}
		}

	}

	public static final String NOT_A_CHAR_ERROR = "The PrintStreamArea received input that could not be represented as a char[]";
	private final PrintStream printStream;

	private final AreaOutputStream output;

	public PrintStreamPane() {
		output = new AreaOutputStream();
		printStream = new PrintStream(output);
	}

	public RTextArea area() {
		return output.pane.getTextArea();
	}

	public PrintStream getPrintStream() {
		return printStream;
	}

	public RTextScrollPane pane() {
		return output.pane;
	}

}
