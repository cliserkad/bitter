package com.xarql.bitter;

import com.xarql.smp.ParseData;

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
		final String tabby = replaceSpacesWithTabs(s);
		var builder = new StringBuilder();
		builder.ensureCapacity(tabby.length() + 1);
		boolean pastNewline = false;
		for(int i = tabby.length() - 1; i >= 0; i--) {
			if(tabby.charAt(i) == NEWLINE) {
				if(i > 0 && tabby.charAt(i - 1) != NEWLINE)
					builder.append(NEWLINE);
				pastNewline = true;
			} else {
				if(pastNewline && Character.isWhitespace(tabby.charAt(i))) {
					// do nothing
				} else {
					builder.append(tabby.charAt(i));
					pastNewline = false;
				}
			}
		}
		builder.reverse();
		if(tabby.charAt(tabby.length() - 1) != NEWLINE)
			builder.append(NEWLINE);
		return builder.toString();
	}

	public static String replaceSpacesWithTabs(final String s) {
		var builder = new StringBuilder();
		builder.ensureCapacity(s.length());
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == SPACE && s.charAt(i + 1) == SPACE) {
				builder.append(TAB);
				i++;
			} else
				builder.append(s.charAt(i));
		}
		builder.append(s.charAt(s.length() - 1));
		return builder.toString();
	}

}
