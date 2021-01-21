package com.xarql.bitter;

import org.fife.rsta.ui.GoToDialog;
import org.fife.ui.rtextarea.SearchContext;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {

	public EditorPane editor;
	private final JFrame owner;

	public MenuBar(final JFrame owner) {
		super();
		this.owner = owner;
		final var menu = new JMenu("Text");
		menu.add(new JMenuItem(new ShowReplaceDialogAction()));
		menu.add(new JMenuItem(new GoToLineAction()));
		add(menu);
	}

	/**
	 * Opens the "Go to Line" dialog.
	 */
	private class GoToLineAction extends AbstractAction {
		private static final long serialVersionUID = -5189937979427502507L;

		GoToLineAction() {
			super("Go To Line...");
			final var c = getToolkit().getMenuShortcutKeyMaskEx();
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_G, c));
		}

		@Override
		public void actionPerformed(final ActionEvent e) {
			if (editor.replaceDialog.isVisible()) {
				editor.replaceDialog.setVisible(false);
			}
			final var dialog = new GoToDialog(owner);
			dialog.setMaxLineNumberAllowed(editor.textArea.getLineCount());
			dialog.setVisible(true);
			final var line = dialog.getLineNumber();
			if (line > 0) {
				try {
					editor.textArea.setCaretPosition(editor.textArea.getLineStartOffset(line - 1));
				} catch (final BadLocationException ble) { // Never happens
					UIManager.getLookAndFeel().provideErrorFeedback(editor.textArea);
					ble.printStackTrace();
				}
			}
		}

	}

	/**
	 * Shows the Replace dialog.
	 */
	private class ShowReplaceDialogAction extends AbstractAction {
		private static final long serialVersionUID = 3101786697029049708L;

		ShowReplaceDialogAction() {
			super("Replace...");
			final var c = getToolkit().getMenuShortcutKeyMaskEx();
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F, c));
			firePropertyChange(SearchContext.PROPERTY_SEARCH_WRAP, (byte) 0, (byte) 1);
		}

		@Override
		public void actionPerformed(final ActionEvent e) {
			editor.replaceDialog.setVisible(true);
		}

	}

}
