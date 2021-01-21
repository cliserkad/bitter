package com.xarql.bitter;

import static com.xarql.bitter.Util.asLiteral;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.io.File;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;

import org.fife.rsta.ui.search.ReplaceDialog;
import org.fife.rsta.ui.search.SearchEvent;
import org.fife.rsta.ui.search.SearchListener;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rtextarea.SearchEngine;
import org.fife.ui.rtextarea.SearchResult;

public class EditorPane extends JPanel implements SearchListener {
	private static final long serialVersionUID = 132740111430332748L;

	public static final String KDL = "text/kdl";
	public static final String SMP = "text/smp";
	public static final String TXT = "text/txt";

	public final RSyntaxTextArea textArea;
	public final ReplaceDialog replaceDialog;
	public final FileDialog fileDialog;
	public final Settings settings;

	private File file;

	public EditorPane(final Frame owner) {
		setLayout(new BorderLayout());

		settings = new Settings();
		textArea = ComponentFactory.textArea(settings);
		textArea.setSyntaxScheme(new KdlSyntaxScheme());
		textArea.setSyntaxEditingStyle("text/kdl");
		add(new RTextScrollPane(textArea));

		replaceDialog = new ReplaceDialog(owner, this);
		fileDialog = new FileDialog(owner, this);
		file = null;
	}

	public File getFile() {
		return file;
	}

	public File setFile(final File file) {
		this.file = file;
		if(file.getName().endsWith(".smp"))
			setSyntax(SMP);
		else if(file.getName().endsWith(".kdl"))
			setSyntax(KDL);
		else
			setSyntax(TXT);
		return file;
	}

	public void setSyntax(String syntax) {
		syntax = syntax.trim();
		if(syntax.equalsIgnoreCase(SMP)) {
			textArea.setSyntaxScheme(new SmpSyntaxScheme());
			textArea.setSyntaxEditingStyle(SMP);
		} else if(syntax.equalsIgnoreCase(KDL)){
			textArea.setSyntaxScheme(new KdlSyntaxScheme());
			textArea.setSyntaxEditingStyle(KDL);
		} else {
			textArea.setSyntaxScheme(null);
			textArea.setSyntaxEditingStyle(null);
		}
	}

	private void addItem(final Action a, final ButtonGroup bg, final JMenu menu) {
		final var item = new JRadioButtonMenuItem(a);
		bg.add(item);
		menu.add(item);
	}

	@Override
	public String getSelectedText() {
		return textArea.getSelectedText();
	}

	/**
	 * Listens for events from our search dialogs and actually does the dirty work.
	 */
	@Override
	public void searchEvent(final SearchEvent e) {
		final var type = e.getType();
		final var context = e.getSearchContext();
		final SearchResult result;

		switch (type) {
			case MARK_ALL:
				result = SearchEngine.markAll(textArea, context);
				break;
			case FIND:
				result = SearchEngine.find(textArea, context);
				break;
			case REPLACE:
				result = SearchEngine.replace(textArea, context);
				break;
			case REPLACE_ALL:
				result = SearchEngine.replaceAll(textArea, context);
				break;
			default:
				result = null;
		}

		final String text;
		if (result == null) {
			text = "Search result was null";
			UIManager.getLookAndFeel().provideErrorFeedback(textArea);
		} else if (result.wasFound()) {
			switch (type) {
				case MARK_ALL:
					text = "Highlighted " + asLiteral(context.getSearchFor()) + " " + result.getCount() + " times.";
					break;
				case FIND:
					text = "Found " + asLiteral(context.getSearchFor());
					break;
				case REPLACE:
					text = "Replaced " + asLiteral(context.getSearchFor()) + " with " + asLiteral(context.getReplaceWith());
					break;
				case REPLACE_ALL:
					text = "Replaced " + asLiteral(context.getSearchFor()) + " with " + asLiteral(context.getReplaceWith()) + " " + result.getCount() + " times.";
					break;
				default:
					text = "Missing case in switch expression";
			}
			if (result.isWrapped()) {
				System.out.println("Search wrapped");
			}
		} else {
			UIManager.getLookAndFeel().provideErrorFeedback(textArea);
			text = asLiteral(context.getSearchFor()) + " not found";
		}

		System.out.println(text);
	}

}
