package com.xarql.bitter;

import org.fife.rsta.ui.EscapableDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;

import static com.xarql.bitter.Util.formatForFile;

public class FileDialog extends EscapableDialog implements ActionListener {
	public static final String SAVE_AS = "Save As";
	public static final String OPEN = "Open";

	public final JFileChooser fileChooser;
	public final EditorPane editor;
	public Mode mode;
	private int result;

	public FileDialog(final Frame owner, final EditorPane editor) {
		super(owner, FileDialog.class.getSimpleName(), true);
		this.editor = editor;
		fileChooser = new JFileChooser();
		fileChooser.addActionListener(this);
		fileChooser.setFileHidingEnabled(!editor.settings.filesHidden);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setMultiSelectionEnabled(false);
		result = -1;
		pack();
	}

	public void perform(Mode mode) {
		this.mode = mode;
		setVisible(true);
	}

	@Override
	protected void escapePressed() {
		fileChooser.cancelSelection();
	}

	@Override
	public void setVisible(boolean b) {
		if(b) {
			if(mode == Mode.SAVE_AS) {
				fileChooser.setDialogTitle(SAVE_AS);
				result = fileChooser.showSaveDialog(this);
			} else if(mode == Mode.OPEN) {
				fileChooser.setDialogTitle(OPEN);
				result = fileChooser.showOpenDialog(this);
			} else if(mode == Mode.SAVE) {
				save();
			} else if(mode == Mode.RELOAD) {
				reload();
			}
		}
		else
			fileChooser.setVisible(false);
	}

	public void save() {
		mode = Mode.SAVE;
		if(editor.getFile() == null) {
			mode = Mode.SAVE_AS;
			setVisible(true);
		} else {
			write();
		}
	}

	private void write() {
		try {
			editor.textArea.setText(formatForFile(editor.textArea.getText()));
			Files.write(editor.getFile().toPath(), editor.textArea.getText().getBytes());
			System.out.println("Wrote " + editor.textArea.getText().getBytes().length + " bytes to " + editor.getFile());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void reload() {
		mode = Mode.RELOAD;
		if(editor.getFile() == null) {
			mode = Mode.OPEN;
			setVisible(true);
		} else {
			read();
		}
	}

	private void read() {
		try {
			final String text = new String(Files.readAllBytes(editor.getFile().toPath()));
			editor.textArea.setText(text);
			System.out.println("Read " + editor.textArea.getText().getBytes().length + " bytes from " + editor.getFile());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JFileChooser) {
			if(result == JFileChooser.APPROVE_OPTION) {
				if (mode == Mode.SAVE_AS) {
					editor.setFile(fileChooser.getSelectedFile());
					System.out.println(fileChooser.getSelectedFile());
					write();
				} else if (mode == Mode.OPEN) {
					editor.setFile(fileChooser.getSelectedFile());
					read();
				} else {
					System.err.println("File picker mode not recognized");
				}
			} else if(result == JFileChooser.ERROR_OPTION) {
				System.err.println("File selection dialog failed");
			} else {
				System.out.println("File not saved. Location is " + editor.getFile());
			}
		}
	}

	public enum Mode {
		SAVE(), SAVE_AS(), RELOAD(), OPEN();
	}

}
