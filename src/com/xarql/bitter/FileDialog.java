package com.xarql.bitter;

import org.fife.rsta.ui.EscapableDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileDialog extends EscapableDialog implements ActionListener {
	public static final String SAVE_AS = "Save As";
	public static final String OPEN = "Open";

	public final JFileChooser fileChooser;
	public final EditorPane editor;
	public Mode mode;
	private int result;

	public FileDialog(final Bitter bitter, final EditorPane editor) {
		super(bitter, FileDialog.class.getSimpleName(), true);
		this.editor = editor;
		fileChooser = new JFileChooser();
		fileChooser.addActionListener(this);
		fileChooser.setFileHidingEnabled(!editor.settings.filesHidden);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setSelectedFile(editor.settings.defaultFile);
		System.out.println(editor.settings.defaultFile);
		result = -1;
		pack();
	}

	public FileDialog perform(Mode mode) {
		this.mode = mode;
		setVisible(true);
		return this;
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

	public void write() {
		try {
			editor.updateTabName();
			editor.formatText();
			Files.write(editor.getFile().toPath(), editor.getText().getBytes());
			System.out.println("Wrote " + editor.getText().getBytes().length + " bytes to " + editor.getFile());
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

	public void read() {
		try {
			editor.updateTabName();
			editor.setText(new String(Files.readAllBytes(editor.getFile().toPath())));
			System.out.println("Read " + editor.getText().getBytes().length + " bytes from " + editor.getFile());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JFileChooser) {
			execute();
		}
	}

	public FileDialog execute() {
		if(result == JFileChooser.APPROVE_OPTION) {
			editor.setFile(fileChooser.getSelectedFile());
			if(mode == Mode.SAVE_AS || mode == Mode.SAVE)
				write();
			else if(mode == Mode.OPEN || mode == Mode.RELOAD)
				read();
			else
				System.err.println("File picker mode not recognized");
		} else if(result == JFileChooser.ERROR_OPTION) {
			System.err.println("File selection dialog failed, continuing anyway");
			result = JFileChooser.APPROVE_OPTION;
			execute();
		} else {
			System.out.println("File not saved. Location is " + editor.getFile());
		}
		return this;
	}

	public enum Mode {
		SAVE(), SAVE_AS(), RELOAD(), OPEN();
	}

}
