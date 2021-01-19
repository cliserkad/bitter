package com.xarql.bitter;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class PrintStreamArea {
	public static final String NOT_A_CHAR_ERROR = "The PrintStreamArea received input that could not be represented as a char[]";

	private final PrintStream printStream;
	private final AreaOutputStream output;

	public PrintStreamArea() {
		this.output = new AreaOutputStream();
		this.printStream = new PrintStream(output);
	}
	
	public PrintStream getPrintStream() {
		return printStream;
	}

	public JTextArea area() {
		return output.area;
	}

	private static class AreaOutputStream extends OutputStream {

		public final RSyntaxTextArea area = ComponentFactory.newRSyntaxTextArea();

		@Override
		public void write(int b) throws IOException {
			if(b > Character.MAX_CODE_POINT) {
				for(byte nb : NOT_A_CHAR_ERROR.getBytes())
					write(nb);
			} else {
				final char c = (char) b;
				final String s = c + "";
				area.append(s);
			}
		}

	}


}
