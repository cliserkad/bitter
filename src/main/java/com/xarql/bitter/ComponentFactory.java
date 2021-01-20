package com.xarql.bitter;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

public class ComponentFactory {
	public static Settings settings = new Settings();

	public static RSyntaxTextArea textArea() {
		RSyntaxTextArea area = new RSyntaxTextArea();
		area.setColumns(settings.columns);
		area.setRows(settings.rows);
		area.setTabSize(settings.tabSize);
		area.setCodeFoldingEnabled(true);
		area.setMarkOccurrences(true);
		area.setForeground(settings.foreground);
		area.setBackground(settings.background);
		area.setCurrentLineHighlightColor(settings.currentLine);
		area.setSelectionColor(settings.selection);
		area.setLineWrap(settings.wrapEnabled);
		area.setWrapStyleWord(settings.wrapWords);
		return area;
	}

	public static RTextScrollPane scrollableTextPane() {
		return new RTextScrollPane(textArea());
	}

}
