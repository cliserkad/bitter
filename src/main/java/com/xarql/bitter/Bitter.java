package com.xarql.bitter;

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
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static com.xarql.bitter.Util.asLiteral;

/**
 * An epic text editor
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
        replaceDialog = new ReplaceDialog(this, this);
        replaceDialog.actionPerformed(new ActionEvent("defaults", 0, "FlipWrap"));


        setTitle("Bitter");
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(640, 480));

        JPanel initialTab = new JPanel(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add(initialTab, "document");
        add(tabbedPane);

        PrintStreamPane printStreamPane = new PrintStreamPane();
        System.setOut(printStreamPane.getPrintStream());
        System.setErr(printStreamPane.getPrintStream());
        JPanel logPanel = new JPanel(new BorderLayout());
        logPanel.add(printStreamPane.pane());
        add(logPanel);

        setJMenuBar(createMenuBar());

        textArea = ComponentFactory.textArea();
        textArea.setSyntaxScheme(new KdlSyntaxScheme());
        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
        atmf.putMapping("text/kdl", "com.xarql.bitter.KdlTokenMaker");
        textArea.setSyntaxEditingStyle("text/kdl");
        initialTab.add(new RTextScrollPane(textArea));
        statusBar = new StatusBar();
        initialTab.add(statusBar, BorderLayout.SOUTH);

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

        final SearchEvent.Type type = e.getType();
        final SearchContext context = e.getSearchContext();
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
        if(result == null) {
            text = "Search result was null";
            UIManager.getLookAndFeel().provideErrorFeedback(textArea);
        } else if(result.wasFound()) {
            switch(type) {
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
            if(result.isWrapped())
                System.out.println("Search wrapped");
        } else {
            UIManager.getLookAndFeel().provideErrorFeedback(textArea);
            text = asLiteral(context.getSearchFor()) + " not found";
        }



        System.out.println(text);
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
            int c = getToolkit().getMenuShortcutKeyMaskEx();
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F, c));
            firePropertyChange(SearchContext.PROPERTY_SEARCH_WRAP, (byte) 0, (byte) 1);
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
