package layout.findGui;

import javax.swing.*;
import java.awt.*;

public class FindGuiStyle {
    private AbstractFindGui findGui;
    private Font aerialFont14;
    private Font aerialFontBold14;

    public AbstractFindGui getFindGui() {
        return findGui;
    }

    public Font getAerialFont14() {
        return aerialFont14;
    }

    public Font getAerialFontBold14() {
        return aerialFontBold14;
    }

    public void setFindGui(AbstractFindGui findGui) {
        this.findGui = findGui;
    }

    public void setAerialFont14(Font aerialFont14) {
        this.aerialFont14 = aerialFont14;
    }

    public void setAerialFontBold14(Font aerialFontBold14) {
        this.aerialFontBold14 = aerialFontBold14;
    }

    public FindGuiStyle(AbstractFindGui findGui) {
        this.findGui = findGui;
        init();
    }

    private void init() {
        aerialFont14 = new Font("Arial", Font.PLAIN, 14);
        aerialFontBold14 = new Font("Arial", Font.BOLD, 14);
        addstyleButton(findGui.findButton);
        addstyleButton(findGui.findNextButton);
        addstyleButton(findGui.replaceButton);
        addstyleButton(findGui.replaceAllButton);
        addstyleLabel(findGui.findLabel);
        addstyleLabel(findGui.replaceLabel);
        addstyleTextField(findGui.findTextField);
        addstyleTextField(findGui.replaceTextField);
    }

    private void addstyleButton(JButton name) {
        name.setFocusable(false);
    }

    private void addstyleLabel(JLabel name) {
        name.setFont(aerialFontBold14);
    }

    private void addstyleTextField(JTextField name) {
        name.setFont(aerialFont14);
    }
}
