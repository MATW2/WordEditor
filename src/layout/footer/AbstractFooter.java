package layout.footer;

import javax.swing.*;

public abstract class AbstractFooter {
    protected JPanel footerPanel;
    protected JLabel lineLabel;
    protected JLabel kolLabel;
    protected String[] charsets;

    public JPanel getFooterPanel() {
        return footerPanel;
    }

    public JLabel getLineLabel() {
        return lineLabel;
    }

    public JLabel getKolLabel() {
        return kolLabel;
    }

    public void setFooterPanel(JPanel footerPanel) {
        this.footerPanel = footerPanel;
    }

    public void setLineLabel(JLabel lineLabel) {
        this.lineLabel = lineLabel;
    }

    public void setKolLabel(JLabel kolLabel) {
        this.kolLabel = kolLabel;
    }

    public void setCharsets(String[] charsets) {
        this.charsets = charsets;
    }

    public AbstractFooter() {
    }

    public abstract JPanel addToMain();
}
