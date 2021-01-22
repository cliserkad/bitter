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
			} else if(s.charAt(i) == '\t') {
				builder.append("\\t");
			} else if(s.charAt(i) == '\"') {
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
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == NEWLINE) {
				if(i > 1 && (s.charAt(i - 1) != NEWLINE || s.charAt(i - 2) != NEWLINE)) {
					builder.append(NEWLINE);
				}
				pastNewline = true;
			} else if(s.charAt(i) == SPACE && i > 0 && s.charAt(i - 1) == SPACE) {
				builder.append(TAB);
				i--;
			} else {
				if(pastNewline && Character.isWhitespace(s.charAt(i))) {
					// do nothing
				} else {
					builder.append(s.charAt(i));
					pastNewline = false;
				}
			}
		}
		builder.reverse();
		if(s.charAt(s.length() - 1) != NEWLINE)
			builder.append(NEWLINE);
		return builder.toString();
	}

}
