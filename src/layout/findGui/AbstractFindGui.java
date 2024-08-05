package layout.findGui;

import layout.AbstractAppLayout;

import javax.swing.*;

public abstract class AbstractFindGui extends JDialog {
    protected AbstractAppLayout appLayout;
    protected JLabel findLabel;
    protected JLabel replaceLabel;
    protected JTextField findTextField;
    protected JTextField replaceTextField;
    protected JButton findButton;
    protected JButton findNextButton;
    protected JButton replaceButton;
    protected JButton replaceAllButton;
    protected JButton cancelButton;

    public JLabel getFindLabel() {
        return findLabel;
    }

    public JLabel getReplaceLabel() {
        return replaceLabel;
    }

    public JTextField getFindTextField() {
        return findTextField;
    }

    public JTextField getReplaceTextField() {
        return replaceTextField;
    }

    public JButton getFindButton() {
        return findButton;
    }

    public JButton getFindNextButton() {
        return findNextButton;
    }

    public JButton getReplaceButton() {
        return replaceButton;
    }

    public JButton getReplaceAllButton() {
        return replaceAllButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }


    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setFindLabel(JLabel findLabel) {
        this.findLabel = findLabel;
    }

    public void setReplaceLabel(JLabel replaceLabel) {
        this.replaceLabel = replaceLabel;
    }

    public void setFindTextField(JTextField findTextField) {
        this.findTextField = findTextField;
    }

    public void setReplaceTextField(JTextField replaceTextField) {
        this.replaceTextField = replaceTextField;
    }

    public void setFindButton(JButton findButton) {
        this.findButton = findButton;
    }

    public void setFindNextButton(JButton findNextButton) {
        this.findNextButton = findNextButton;
    }

    public void setReplaceButton(JButton replaceButton) {
        this.replaceButton = replaceButton;
    }

    public void setReplaceAllButton(JButton replaceAllButton) {
        this.replaceAllButton = replaceAllButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public AbstractFindGui(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public abstract void initWindow();
}
