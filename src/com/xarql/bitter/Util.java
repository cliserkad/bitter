package com.xarql.bitter;

public class Util {

	public static final char QUOTE = '"';
	public static final char NEWLINE = '\n';
	public static final char SPACE = ' ';
	public static final char TAB = '\t';

	public static String asLiteral(final String s) {
		final var builder = new StringBuilder();
		builder.ensureCapacity(s.length() + 2);
		builder.append(QUOTE);
		for(var i = 0; i < s.length(); i++) {
			if(s.charAt(i) == NEWLINE) {
				builder.append("\\n");
			} else if(s.charAt(i) == TAB) {
				builder.append("\\t");
			} else if(s.charAt(i) == QUOTE) {
				builder.append("\\\"");
			} else {
				builder.append(s.charAt(i));
			}
		}
		builder.append(QUOTE);
		return builder.toString();
	}

	public static String formatForFile(final String s) {
		var builder = new StringBuilder();
		builder.ensureCapacity(s.length() + 1);
		boolean pastNewline = false;
		boolean pastMeaningfulChar = false;
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == NEWLINE) {
				pastNewline = true;
				if(pastMeaningfulChar && (s.charAt(i - 1) != NEWLINE || s.charAt(i - 2) != NEWLINE))
					builder.append(NEWLINE);
			} else if(!Character.isWhitespace(s.charAt(i)) || !pastNewline) {
				if(pastMeaningfulChar && s.charAt(i) == SPACE && s.charAt(i - 1) == SPACE) {
					builder.append(TAB);
					i--;
				} else
					builder.append(s.charAt(i));
				pastMeaningfulChar = true;
				pastNewline = false;
			}
		}
		builder.reverse();
		if(builder.length() > 0 && builder.charAt(builder.length() - 1) != NEWLINE)
			builder.append(NEWLINE);
		return builder.toString();
	}

}
