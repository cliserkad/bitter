package com.xarql.bitter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class PrintStreamArea {
	public static final String NOT_A_CHAR_ERROR = "The PrintStreamArea received input that could not be represented as a char[]";
	public static final Color DEFAULT_BACKGROUND_COLOR = Color.DARK_GRAY;
	public static final Color DEFAULT_FOREGROUND_COLOR = Color.RED;

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

		public final JTextArea area;

		AreaOutputStream() {
			area = new JTextArea();
			area.setBackground(DEFAULT_BACKGROUND_COLOR);
			area.setForeground(DEFAULT_FOREGROUND_COLOR);
			area.setEnabled(false);
		}

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
