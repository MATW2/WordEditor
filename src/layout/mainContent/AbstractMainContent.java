package layout.mainContent;

import javax.swing.*;

public abstract class AbstractMainContent {
    protected JTextPane textPane;
    protected JScrollPane scrollPane;
    protected JPanel mainTextPanel;

    public JTextPane getTextPane() {
        return textPane;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JPanel getMainTextPanel() {
        return mainTextPanel;
    }

    public void setTextPane(JTextPane textPane) {
        this.textPane = textPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public void setMainTextPanel(JPanel mainTextPanel) {
        this.mainTextPanel = mainTextPanel;
    }

    public AbstractMainContent() {
    }

    public abstract JPanel addToMain();
}
