package com.xarql.bitter;

import org.fife.rsta.ui.CollapsibleSectionPanel;
import org.fife.rsta.ui.GoToDialog;
import org.fife.rsta.ui.SizeGripIcon;
import org.fife.rsta.ui.search.*;
import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;
import org.fife.ui.rtextarea.SearchResult;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Hello world!
 *
 */
public class Bitter extends JFrame implements SearchListener {
    public static final Color BACKGROUND_COLOR = new Color(40, 42, 54);
    public static final Color FOREGROUND_COLOR = new Color(248, 248, 242);
    public static final Color CURRENT_LINE_COLOR = new Color(68, 71, 90);
    public static final Color SELECTION_COLOR = CURRENT_LINE_COLOR;

    private final RSyntaxTextArea textArea;
    private final ReplaceDialog replaceDialog;
    private final StatusBar statusBar;

    public static void main( String[] args ) {
        // Start all Swing applications on the EDT.
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Bitter().setVisible(true);
        });
    }

    private Bitter() {

        replaceDialog = new ReplaceDialog(this, this);

        JPanel initialArea = new JPanel(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        setContentPane(tabbedPane);
        tabbedPane.add(initialArea, "Document 1");

        PrintStreamArea printStreamArea = new PrintStreamArea();
        System.setOut(printStreamArea.getPrintStream());
        System.setErr(printStreamArea.getPrintStream());
        JScrollPane logScrollArea = new JScrollPane(printStreamArea.area());
        JPanel logPanel = new JPanel(new BorderLayout());
        logPanel.add(logScrollArea);
        tabbedPane.add(logPanel, "terminal");

        setJMenuBar(createMenuBar());

        textArea = ComponentFactory.newRSyntaxTextArea();
        textArea.setSyntaxScheme(new KdlSyntaxScheme());
        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
        atmf.putMapping("text/kdl", "com.xarql.bitter.KdlTokenMaker");
        textArea.setSyntaxEditingStyle("text/kdl");

        RTextScrollPane sp = new RTextScrollPane(textArea);
        initialArea.add(sp);

        ErrorStrip errorStrip = new ErrorStrip(textArea);
        initialArea.add(errorStrip, BorderLayout.LINE_END);

        statusBar = new StatusBar();
        initialArea.add(statusBar, BorderLayout.SOUTH);

        setTitle("Bitter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }


    private void addItem(Action a, ButtonGroup bg, JMenu menu) {
        JRadioButtonMenuItem item = new JRadioButtonMenuItem(a);
        bg.add(item);
        menu.add(item);
    }


    private JMenuBar createMenuBar() {
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("Text");
        menu.add(new JMenuItem(new ShowReplaceDialogAction()));
        menu.add(new JMenuItem(new GoToLineAction()));
        menu.addSeparator();
        mb.add(menu);
        return mb;
    }

    @Override
    public String getSelectedText() {
        return textArea.getSelectedText();
    }

    /**
     * Listens for events from our search dialogs and actually does the dirty
     * work.
     */
    @Override
    public void searchEvent(SearchEvent e) {

        SearchEvent.Type type = e.getType();
        SearchContext context = e.getSearchContext();
        SearchResult result;

        switch (type) {
            default: // Prevent FindBugs warning later
            case MARK_ALL:
                result = SearchEngine.markAll(textArea, context);
                break;
            case FIND:
                result = SearchEngine.find(textArea, context);
                if (!result.wasFound() || result.isWrapped()) {
                    UIManager.getLookAndFeel().provideErrorFeedback(textArea);
                }
                break;
            case REPLACE:
                result = SearchEngine.replace(textArea, context);
                if (!result.wasFound() || result.isWrapped()) {
                    UIManager.getLookAndFeel().provideErrorFeedback(textArea);
                }
                break;
            case REPLACE_ALL:
                result = SearchEngine.replaceAll(textArea, context);
                JOptionPane.showMessageDialog(null, result.getCount() +
                        " occurrences replaced.");
                break;
        }

        String text;
        if (result.wasFound()) {
            text = "Text found; occurrences marked: " + result.getMarkedCount();
        }
        else if (type==SearchEvent.Type.MARK_ALL) {
            if (result.getMarkedCount()>0) {
                text = "Occurrences marked: " + result.getMarkedCount();
            }
            else {
                text = "";
            }
        }
        else {
            text = "Text not found";
        }
        statusBar.setLabel(text);

    }

    /**
     * Opens the "Go to Line" dialog.
     */
    private class GoToLineAction extends AbstractAction {

        GoToLineAction() {
            super("Go To Line...");
            int c = getToolkit().getMenuShortcutKeyMaskEx();
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_L, c));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (replaceDialog.isVisible()) {
                replaceDialog.setVisible(false);
            }
            GoToDialog dialog = new GoToDialog(Bitter.this);
            dialog.setMaxLineNumberAllowed(textArea.getLineCount());
            dialog.setVisible(true);
            int line = dialog.getLineNumber();
            if (line>0) {
                try {
                    textArea.setCaretPosition(textArea.getLineStartOffset(line-1));
                } catch (BadLocationException ble) { // Never happens
                    UIManager.getLookAndFeel().provideErrorFeedback(textArea);
                    ble.printStackTrace();
                }
            }
        }

    }

    /**
     * Shows the Replace dialog.
     */
    private class ShowReplaceDialogAction extends AbstractAction {

        ShowReplaceDialogAction() {
            super("Replace...");
            int c = getToolkit().getMenuShortcutKeyMask();
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, c));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            replaceDialog.setVisible(true);
        }

    }

    /**
     * The status bar for this application.
     */
    private static class StatusBar extends JPanel {

        private final JLabel label;

        StatusBar() {
            label = new JLabel("Ready");
            setLayout(new BorderLayout());
            add(label, BorderLayout.LINE_START);
            add(new JLabel(new SizeGripIcon()), BorderLayout.LINE_END);
        }

        void setLabel(String label) {
            this.label.setText(label);
        }

    }

}
