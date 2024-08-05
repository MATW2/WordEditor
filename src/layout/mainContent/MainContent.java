package layout.mainContent;

import word.wordEditorKit;

import javax.swing.*;
import java.awt.*;

public class MainContent extends AbstractMainContent {
    public MainContent() {
        super();
        init();
        addToPanel();
    }

    private void init() {
        mainTextPanel = new JPanel(new GridBagLayout());
        textPane = new JTextPane();
        textPane.setEditorKit(new wordEditorKit());
        scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        new MainContentStyle(this);
    }

    private void addToPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 0, 20);
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainTextPanel.add(scrollPane, gbc);
    }

    @Override
    public JPanel addToMain() {
        return mainTextPanel;
    }
}
