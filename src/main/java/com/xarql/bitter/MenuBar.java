package com.xarql.bitter;

import org.fife.rsta.ui.GoToDialog;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.Key;

public class MenuBar extends JMenuBar {
	public static final String ELLIPSES = "...";

	public EditorPane editor;
	private final JFrame owner;

	public MenuBar(final JFrame owner) {
		super();
		this.owner = owner;

		final var text = new JMenu("Text");
		text.add(new JMenuItem(new ShowReplaceDialogAction()));
		text.add(new JMenuItem(new GoToLineAction()));
		add(text);

		final var file = new JMenu("File");
		file.add(new JMenuItem(new SaveAction()));
		file.add(new JMenuItem(new SaveAsAction()));
		file.add(new JMenuItem(new ReloadAction()));
		file.add(new JMenuItem(new OpenAction()));
		add(file);
	}

	private class SaveAction extends AbstractAction {
		SaveAction() {
			super("Save" + ELLIPSES);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			editor.fileDialog.perform(FileDialog.Mode.SAVE);
		}
	}

	private class SaveAsAction extends AbstractAction {
		SaveAsAction() {
			super(FileDialog.SAVE_AS + ELLIPSES);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			editor.fileDialog.perform(FileDialog.Mode.SAVE_AS);
		}
	}

	private class ReloadAction extends AbstractAction {
		ReloadAction() {
			super("Reload" + ELLIPSES);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			editor.fileDialog.perform(FileDialog.Mode.RELOAD);
		}
	}

	private class OpenAction extends AbstractAction {
		OpenAction() {
			super(FileDialog.OPEN + ELLIPSES);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			editor.fileDialog.perform(FileDialog.Mode.OPEN);
		}
	}

	/**
	 * Opens the "Go to Line" dialog.
	 */
	private class GoToLineAction extends AbstractAction {
		private static final long serialVersionUID = -5189937979427502507L;

		GoToLineAction() {
			super("Go To Line...");
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK));
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
			super("Find...");
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(final ActionEvent e) {
			editor.replaceDialog.setVisible(true);
		}

	}

}
