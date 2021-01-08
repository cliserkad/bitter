package com.xarql.bitter;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class Bitter extends JFrame {
    
    public static void main( String[] args ) {
        // Start all Swing applications on the EDT.
        SwingUtilities.invokeLater(() -> {
            new Bitter().setVisible(true);
        });
    }

    public Bitter() {
        super("Bitter");

        JPanel cp = new JPanel(new BorderLayout());

        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        cp.add(sp);

        setContentPane(cp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

}
