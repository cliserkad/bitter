package com.xarql.bitter;

import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class Bitter extends JFrame {
    public static final Color BACKGROUND_COLOR = new Color(40, 42, 54);
    public static final Color FOREGROUND_COLOR = new Color(248, 248, 242);
    public static final Color CURRENT_LINE_COLOR = new Color(68, 71, 90);
    public static final Color SELECTION_COLOR = CURRENT_LINE_COLOR;

    public static void main( String[] args ) {
        // Start all Swing applications on the EDT.
        SwingUtilities.invokeLater(() -> {
            new Bitter().setVisible(true);
        });
    }

    public Bitter() {
        super("Bitter");

        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane scrollArea = new RTextScrollPane(textArea);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollArea);

        PrintStreamArea printStreamArea = new PrintStreamArea();
        System.setOut(printStreamArea.getPrintStream());
        System.setErr(printStreamArea.getPrintStream());
        JScrollPane logScrollArea = new JScrollPane(printStreamArea.area());
        JPanel logPanel = new JPanel(new BorderLayout());
        logPanel.add(logScrollArea);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("main", mainPanel);
        tabbedPane.add("log", logPanel);

        setContentPane(tabbedPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        textArea.setSyntaxScheme(new KdlSyntaxScheme());
        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
        atmf.putMapping("text/kdl", "com.xarql.bitter.KdlTokenMaker");
        textArea.setSyntaxEditingStyle("text/kdl");

        textArea.setBackground(BACKGROUND_COLOR);
        textArea.setCurrentLineHighlightColor(CURRENT_LINE_COLOR);
        textArea.setSelectionColor(SELECTION_COLOR);
    }

}
