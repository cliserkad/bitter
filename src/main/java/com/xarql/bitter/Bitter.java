package com.xarql.bitter;

import javax.swing.*;
import java.awt.*;

/**
 * An epic text editor
 */
public class Bitter extends JFrame {
    public static final Color BACKGROUND_COLOR = new Color(40, 42, 54);
    public static final Color FOREGROUND_COLOR = new Color(248, 248, 242);
    public static final Color CURRENT_LINE_COLOR = new Color(68, 71, 90);
    public static final Color SELECTION_COLOR = CURRENT_LINE_COLOR.brighter();

    public static void main( String[] args ) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Bitter().setVisible(true);
        });
    }

    public Bitter() {
        setTitle("Bitter");
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(640, 480));

        EditorPane initialTab = new EditorPane(this);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add(initialTab, "document");
        add(tabbedPane);

        PrintStreamPane printStreamPane = new PrintStreamPane();
        System.setOut(printStreamPane.getPrintStream());
        System.setErr(printStreamPane.getPrintStream());
        JPanel logPanel = new JPanel(new BorderLayout());
        logPanel.add(printStreamPane.pane());
        add(logPanel);

        pack();
        setLocationRelativeTo(null);
    }

}
