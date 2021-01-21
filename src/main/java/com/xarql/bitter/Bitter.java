package com.xarql.bitter;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.folding.FoldParserManager;

/**
 * An epic text editor
 */
public class Bitter extends JFrame {
	private static final long serialVersionUID = -7097067406931407761L;

	public final MenuBar menuBar;
	public final JTabbedPane tabbedPane;

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (final Exception e) {
				e.printStackTrace();
			}
			new Bitter().setVisible(true);
		});
	}

	public Bitter() {
		setTitle("Bitter");
		setLayout(new GridLayout(1, 2));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(Settings.INITIAL.preferredSize());

		final var atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
		atmf.putMapping("text/kdl", "com.xarql.bitter.KdlTokenMaker");

		final var leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout());
		add(leftPane);

		menuBar = new MenuBar(this);
		leftPane.add(menuBar, BorderLayout.NORTH);

		tabbedPane = new JTabbedPane();
		leftPane.add(tabbedPane);

		final var initialTab = new EditorPane(this);
		tabbedPane.add(initialTab, "document");
		menuBar.editor = initialTab;

		final var printStreamPane = new PrintStreamPane();
		System.setOut(printStreamPane.getPrintStream());
		System.setErr(printStreamPane.getPrintStream());
		final var logPanel = new JPanel(new BorderLayout());
		final var terminalMenu = new JMenuBar();
		terminalMenu.add(new JMenu("Terminal"));
		logPanel.add(terminalMenu, BorderLayout.NORTH);
		logPanel.add(printStreamPane.pane());
		add(logPanel);

		pack();
		setLocationRelativeTo(null);
	}

}
