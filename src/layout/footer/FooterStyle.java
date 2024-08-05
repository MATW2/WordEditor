package layout.footer;

import javax.swing.*;
import java.awt.*;

public class FooterStyle {
    private AbstractFooter footer;
    private Font timesNewRomanFont14;
    private Color colorWhiteSilver;
    private Color colorBlack;

    public AbstractFooter getFooter() {
        return footer;
    }

    public Font getTimesNewRomanFont14() {
        return timesNewRomanFont14;
    }

    public Color getColorWhiteSilver() {
        return colorWhiteSilver;
    }

    public Color getColorBlack() {
        return colorBlack;
    }

    public void setFooter(AbstractFooter footer) {
        this.footer = footer;
    }

    public void setTimesNewRomanFont14(Font timesNewRomanFont14) {
        this.timesNewRomanFont14 = timesNewRomanFont14;
    }

    public void setColorWhiteSilver(Color colorWhiteSilver) {
        this.colorWhiteSilver = colorWhiteSilver;
    }

    public void setColorBlack(Color colorBlack) {
        this.colorBlack = colorBlack;
    }

    public FooterStyle(AbstractFooter footer) {
        this.footer = footer;
        init();
        addStyle();
    }

    private void init() {
        colorWhiteSilver = new Color(240, 239, 240);
        colorBlack = new Color(35, 32, 38);
        timesNewRomanFont14 = new Font("Times New Roman", Font.BOLD, 14);
    }

    private void addStyle() {
        styleFontLabel(footer.getLineLabel());
        styleFontLabel(footer.getKolLabel());
        backgroundColorFooter(footer.getFooterPanel());
    }

    private void styleFontLabel(JLabel name) {
        name.setFont(timesNewRomanFont14);
        name.setForeground(colorBlack);
    }

    private void backgroundColorFooter(JPanel panel) {
        panel.setBackground(colorWhiteSilver);
    }
}
