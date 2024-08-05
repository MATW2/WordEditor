package layout.footer;

import javax.swing.*;
import java.awt.*;

public class Footer extends AbstractFooter {
    public Footer() {
        super();
        init();
        addToPanel();
    }

    private void init() {
        footerPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING, 25, 5));
        lineLabel = new JLabel();
        kolLabel = new JLabel();
        new FooterStyle(this);
    }

    private void addToPanel() {
        footerPanel.add(lineLabel);
        footerPanel.add(kolLabel);
    }

    @Override
    public JPanel addToMain() {
        return footerPanel;
    }
}
