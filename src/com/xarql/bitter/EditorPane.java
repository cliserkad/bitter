package com.xarql.bitter;

import static com.xarql.bitter.Util.asLiteral;
import static com.xarql.bitter.Util.formatForFile;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.io.File;
import java.util.Objects;
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
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rtextarea.SearchEngine;
import org.fife.ui.rtextarea.SearchResult;

public class EditorPane extends JPanel implements SearchListener {
	private static final long serialVersionUID = 132740111430332748L;

	public static final String KDL = "text/kdl";
	public static final String SMP = "text/smp";
	public static final String TXT = "text/txt";

	public final Bitter owner;
	public final RSyntaxTextArea textArea;
	public final ReplaceDialog replaceDialog;
	public final FileDialog fileDialog;
	public final Settings settings;

	private File file;

	public EditorPane(final Bitter owner) {
		setLayout(new BorderLayout());

		settings = new Settings();
		textArea = ComponentFactory.textArea(settings);
		resetSyntax();
		add(new RTextScrollPane(textArea));

		this.owner = owner;
		replaceDialog = new ReplaceDialog(owner, this);
		fileDialog = new FileDialog(owner, this);
		file = null;
	}

	public EditorPane updateTabName() {
		if(owner != null)
			owner.tabbedPane.setTitleAt(owner.tabbedPane.indexOfComponent(this), getFile().getName());
		return this;
	}

	public File getFile() {
		return file;
	}

	public File setFile(final File file) {
		if(file == null)
			throw new NullPointerException();
		this.file = file;
		if(file.getName().endsWith(".smp"))
			setSyntax(SMP);
		else if(file.getName().endsWith(".kdl"))
			setSyntax(KDL);
		else
			resetSyntax();
		return file;
	}

	public String getText() {
		return textArea.getText();
	}

	public EditorPane setText(final String text) {
		textArea.setText(formatForFile(text));
		return this;
	}

	public EditorPane formatText() {
		setText(getText());
		return this;
	}

	public void resetSyntax() {
		textArea.setSyntaxScheme(new SyntaxScheme(true));
		textArea.setSyntaxEditingStyle(TXT);
	}

	public void setSyntax(String syntax) {
		if(syntax == null) {
			resetSyntax();
		}
		else {
			syntax = syntax.trim();
			if (syntax.equalsIgnoreCase(SMP)) {
				textArea.setSyntaxScheme(new SmpSyntaxScheme());
				textArea.setSyntaxEditingStyle(SMP);
			} else if (syntax.equalsIgnoreCase(KDL)) {
				textArea.setSyntaxScheme(new KdlSyntaxScheme());
				textArea.setSyntaxEditingStyle(KDL);
			} else {
				resetSyntax();
			}
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

	@Override
	public boolean equals(Object object) {
		if(this == object)
			return true;
		else if(object instanceof EditorPane) {
			EditorPane that = (EditorPane) object;
			return that.owner == owner && that.textArea == textArea;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(owner, textArea);
	}

}
