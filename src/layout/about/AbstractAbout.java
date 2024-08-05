package layout.about;

import layout.AbstractAppLayout;

import javax.swing.*;

public abstract class AbstractAbout extends JDialog {
    protected AbstractAppLayout appLayout;
    protected JLabel nameProjectLabel;
    protected JLabel descriptionLabel;
    protected JLabel authorLabel;
    protected JLabel versionLabel;
    protected JPanel nameProjectPanel;
    protected JPanel infoPanel;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public JLabel getNameProjectLabel() {
        return nameProjectLabel;
    }

    public JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    public JLabel getAuthorLabel() {
        return authorLabel;
    }

    public JLabel getVersionLabel() {
        return versionLabel;
    }

    public JPanel getNameProjectPanel() {
        return nameProjectPanel;
    }

    public JPanel getInfoPanel() {
        return infoPanel;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public void setNameProjectLabel(JLabel nameProjectLabel) {
        this.nameProjectLabel = nameProjectLabel;
    }

    public void setDescriptionLabel(JLabel descriptionLabel) {
        this.descriptionLabel = descriptionLabel;
    }

    public void setAuthorLabel(JLabel authorLabel) {
        this.authorLabel = authorLabel;
    }

    public void setVersionLabel(JLabel versionLabel) {
        this.versionLabel = versionLabel;
    }

    public void setNameProjectPanel(JPanel nameProjectPanel) {
        this.nameProjectPanel = nameProjectPanel;
    }

    public void setInfoPanel(JPanel infoPanel) {
        this.infoPanel = infoPanel;
    }

    public AbstractAbout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public abstract void initWindow();
}
