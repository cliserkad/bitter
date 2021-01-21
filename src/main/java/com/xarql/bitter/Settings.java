package com.xarql.bitter;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import com.xarql.smp.ParseData;
import com.xarql.smp.ParseUtil;
import com.xarql.smp.Path;
import com.xarql.smp.PathMap;

public class Settings {

	public static final File SETTINGS_FILE = new File(System.getProperty("user.home"), "/bitter/settings.smp");
	public static final Settings INITIAL = new Settings();

	public static final boolean DEFAULT_WRAP_ENABLED = true;
	public static final boolean DEFAULT_WRAP_WORDS = true;
	public static final boolean DEFAULT_FILES_HIDDEN = true;

	public static final int DEFAULT_WIDTH = 640;
	public static final int DEFAULT_HEIGHT = 480;
	public static final int DEFAULT_TAB_SIZE = 2;

	public static final Color DEFAULT_BACKGROUND = new Color(40, 42, 54);
	public static final Color DEFAULT_FOREGROUND = new Color(248, 248, 242);
	public static final Color DEFAULT_CURRENT_LINE = new Color(68, 71, 90);
	public static final Color DEFAULT_SELECTION = DEFAULT_CURRENT_LINE.brighter();

	public final ParseData data;

	public final boolean wrapEnabled;
	public final boolean wrapWords;
	public final boolean filesHidden;

	public final int width;
	public final int height;
	public final int tabSize;
	public final int columns;
	public final int rows;

	public final Color background;
	public final Color foreground;
	public final Color currentLine;
	public final Color selection;

	public Settings() {
		data = ParseUtil.parse(SETTINGS_FILE);

		wrapEnabled = data.getBooleanOrDefault("wrap/enabled", DEFAULT_WRAP_ENABLED);
		wrapWords = data.getBooleanOrDefault("wrap/words", DEFAULT_WRAP_WORDS);
		filesHidden = data.getBooleanOrDefault("files/hidden", DEFAULT_FILES_HIDDEN);

		width = data.getIntOrDefault("width", DEFAULT_WIDTH);
		height = data.getIntOrDefault("height", DEFAULT_HEIGHT);
		tabSize = data.getIntOrDefault("tabSize", DEFAULT_TAB_SIZE);
		columns = data.getIntOrDefault("columns");
		rows = data.getIntOrDefault("rows");

		background = color("background", DEFAULT_BACKGROUND);
		foreground = color("foreground", DEFAULT_FOREGROUND);
		currentLine = color("currentLine", DEFAULT_CURRENT_LINE);
		selection = color("selection", DEFAULT_SELECTION);
	}

	public Color color(final String s, final Color backup) {
		final var path = new Path(s);
		final var r = data.getIntOrDefault(path.append("0"), -1);
		final var g = data.getIntOrDefault(path.append("1"), -1);
		final var b = data.getIntOrDefault(path.append("2"), -1);
		if((r | g | b) < 0)
			return backup;
		else
			return new Color(r, g, b);
	}

	public Dimension preferredSize() {
		return new Dimension(width, height);
	}

}
