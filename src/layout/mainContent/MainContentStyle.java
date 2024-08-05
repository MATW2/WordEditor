package layout.mainContent;

import java.awt.*;

public class MainContentStyle {
    private AbstractMainContent mainContent;
    private Color colorWhiteSilver;

    public AbstractMainContent getMainContent() {
        return mainContent;
    }

    public Color getColorWhiteSilver() {
        return colorWhiteSilver;
    }

    public void setMainContent(AbstractMainContent mainContent) {
        this.mainContent = mainContent;
    }

    public void setColorWhiteSilver(Color colorWhiteSilver) {
        this.colorWhiteSilver = colorWhiteSilver;
    }

    public MainContentStyle(AbstractMainContent mainContent) {
        this.mainContent = mainContent;
        init();
        addStyle();
    }

    private void init() {
        colorWhiteSilver = new Color(240, 239, 240);
    }

    private void addStyle() {
        mainContent.getMainTextPanel().setBackground(colorWhiteSilver);
    }
}
