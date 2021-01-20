package com.xarql.bitter;

import org.fife.ui.rtextarea.RTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class PrintStreamPane {
	public static final String NOT_A_CHAR_ERROR = "The PrintStreamArea received input that could not be represented as a char[]";

	private final PrintStream printStream;
	private final AreaOutputStream output;

	public PrintStreamPane() {
		this.output = new AreaOutputStream();
		this.printStream = new PrintStream(output);
	}
	
	public PrintStream getPrintStream() {
		return printStream;
	}

	public RTextScrollPane pane() {
		return output.pane;
	}

	public RTextArea area() {
		return output.pane.getTextArea();
	}

	private class AreaOutputStream extends OutputStream {

		public final RTextScrollPane pane = ComponentFactory.scrollableTextPane();

		@Override
		public void write(int b) {
			if(b > Character.MAX_CODE_POINT) {
				for(byte nb : NOT_A_CHAR_ERROR.getBytes())
					write(nb);
			} else {
				final char c = (char) b;
				final String s = c + "";
				area().append(s);
			}
		}

	}


}
