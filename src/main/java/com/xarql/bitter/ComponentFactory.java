package com.xarql.bitter;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

public class ComponentFactory {

	public static RSyntaxTextArea textArea() {
		RSyntaxTextArea area = new RSyntaxTextArea();
		area.setColumns(0);
		area.setRows(1);
		area.setTabSize(2);
		area.setCodeFoldingEnabled(true);
		area.setMarkOccurrences(true);
		area.setForeground(Bitter.FOREGROUND_COLOR);
		area.setBackground(Bitter.BACKGROUND_COLOR);
		area.setCurrentLineHighlightColor(Bitter.CURRENT_LINE_COLOR);
		area.setSelectionColor(Bitter.SELECTION_COLOR);
		return area;
	}

	public static RTextScrollPane scrollableTextPane() {
		return new RTextScrollPane(textArea());
	}

}
