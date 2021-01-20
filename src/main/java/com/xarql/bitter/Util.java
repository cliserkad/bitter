package com.xarql.bitter;

public class Util {

	public static final char QUOTE = '"';

	public static String asLiteral(String s) {
		final StringBuilder builder = new StringBuilder();
		builder.ensureCapacity(s.length() + 2);
		builder.append(QUOTE);
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '\n')
				builder.append("\\n");
			else if(s.charAt(i) == '\t')
				builder.append("\\t");
			else if(s.charAt(i) == '\"')
				builder.append("\\\"");
			else
				builder.append(s.charAt(i));
		}
		builder.append(QUOTE);
		return builder.toString();
	}

}
