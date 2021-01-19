package com.xarql.bitter;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class ComponentFactory {

	public static RSyntaxTextArea newRSyntaxTextArea() {
		RSyntaxTextArea area = new RSyntaxTextArea();
		area.setColumns(120);
		area.setRows(35);
		area.setTabSize(2);
		area.setCodeFoldingEnabled(true);
		area.setMarkOccurrences(true);
		area.setForeground(Bitter.FOREGROUND_COLOR);
		area.setBackground(Bitter.BACKGROUND_COLOR);
		area.setCurrentLineHighlightColor(Bitter.CURRENT_LINE_COLOR);
		area.setSelectionColor(Bitter.SELECTION_COLOR);
		return area;
	}

}
