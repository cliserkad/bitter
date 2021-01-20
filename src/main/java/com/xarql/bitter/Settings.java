package com.xarql.bitter;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import com.xarql.smp.ParseUtil;
import com.xarql.smp.PathMap;

public class Settings {

	public static final File SETTINGS_FILE = new File(System.getProperty("user.home"), "/bitter/settings.smp");
	public static final Settings INITIAL = new Settings();

	public static final boolean DEFAULT_WRAP_ENABLED = true;
	public static final boolean DEFAULT_WRAP_WORDS = true;

	public static final int DEFAULT_WIDTH = 640;
	public static final int DEFAULT_HEIGHT = 480;
	public static final int DEFAULT_TAB_SIZE = 2;
	public static final int DEFAULT_COLUMNS = 0;
	public static final int DEFAULT_ROWS = 1;

	public static final Color DEFAULT_BACKGROUND = new Color(40, 42, 54);
	public static final Color DEFAULT_FOREGROUND = new Color(248, 248, 242);
	public static final Color DEFAULT_CURRENT_LINE = new Color(68, 71, 90);
	public static final Color DEFAULT_SELECTION = DEFAULT_CURRENT_LINE.brighter();

	public final PathMap<Object> data;

	public final boolean wrapEnabled;
	public final boolean wrapWords;

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

		wrapEnabled = (boolean) data.getOrDefault("wrap/enabled", DEFAULT_WRAP_ENABLED);
		wrapWords = (boolean) data.getOrDefault("wrap/words", DEFAULT_WRAP_WORDS);

		width = (int) data.getOrDefault("width", DEFAULT_WIDTH);
		height = (int) data.getOrDefault("height", DEFAULT_HEIGHT);
		tabSize = (int) data.getOrDefault("tabSize", DEFAULT_TAB_SIZE);
		columns = (int) data.getOrDefault("columns", DEFAULT_COLUMNS);
		rows = (int) data.getOrDefault("rows", DEFAULT_ROWS);

		background = color("background", DEFAULT_BACKGROUND);
		foreground = color("foreground", DEFAULT_FOREGROUND);
		currentLine = color("currentLine", DEFAULT_CURRENT_LINE);
		selection = color("selection", DEFAULT_SELECTION);
	}

	public Color color(final String path, final Color backup) {
		try {
			final var r = (int) data.get(path, "0");
			final var g = (int) data.get(path, "1");
			final var b = (int) data.get(path, "2");
			return new Color(r, g, b);
		} catch(final Exception e) {
			return backup;
		}
	}

	public Dimension preferredSize() {
		return new Dimension(width, height);
	}

}
