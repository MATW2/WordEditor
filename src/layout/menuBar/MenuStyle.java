package layout.menuBar;

import java.awt.*;

public class MenuStyle {
    private AbstractMenu menu;
    private Color colorWhite;
    private Font aerialFont14;

    public AbstractMenu getMenu() {
        return menu;
    }

    public Color getColorWhite() {
        return colorWhite;
    }

    public Font getAerialFont14() {
        return aerialFont14;
    }

    public void setMenu(AbstractMenu menu) {
        this.menu = menu;
    }

    public void setColorWhite(Color colorWhite) {
        this.colorWhite = colorWhite;
    }

    public void setAerialFont14(Font aerialFont14) {
        this.aerialFont14 = aerialFont14;
    }

    public MenuStyle(AbstractMenu menu) {
        this.menu = menu;
        init();
        addStyleMenuBar();
        addStyleMenu();
        addStyleMenuItem();
    }

    private void init() {
        colorWhite = new Color(255, 255, 255);
        aerialFont14 = new Font("Arial", Font.BOLD, 14);
    }

    private void addStyleMenuBar() {
        menu.getMenuBar().setBackground(colorWhite);
    }

    private void addStyleMenuItem() {
        menu.getiNew().setFont(aerialFont14);
        menu.getiOpen().setFont(aerialFont14);
        menu.getiSave().setFont(aerialFont14);
        menu.getiSaveAS().setFont(aerialFont14);
        menu.getiExit().setFont(aerialFont14);
        menu.getiUndo().setFont(aerialFont14);
        menu.getiRedo().setFont(aerialFont14);
        menu.getiCopy().setFont(aerialFont14);
        menu.getiPast().setFont(aerialFont14);
        menu.getiSelectAll().setFont(aerialFont14);
        menu.getiCut().setFont(aerialFont14);
        menu.getiAbout().setFont(aerialFont14);
    }

    private void addStyleMenu() {
        menu.getMenuFile().setFont(aerialFont14);
        menu.getMenuEdit().setFont(aerialFont14);
        menu.getMenuAbout().setFont(aerialFont14);
    }
}
