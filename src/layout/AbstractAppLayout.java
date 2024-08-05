package layout;

import layout.footer.AbstractFooter;
import layout.header.AbstractHeader;
import layout.mainContent.AbstractMainContent;
import layout.menuBar.AbstractMenu;

import javax.swing.*;

public abstract class AbstractAppLayout extends JFrame {
    protected AbstractMenu menu;
    protected AbstractHeader header;
    protected AbstractMainContent mainContent;
    protected AbstractFooter footer;
    protected ImageIcon logo;

    public AbstractMenu getMenu() {
        return menu;
    }

    public AbstractHeader getHeader() {
        return header;
    }

    public AbstractMainContent getMainContent() {
        return mainContent;
    }

    public AbstractFooter getFooter() {
        return footer;
    }

    public ImageIcon getLogo() {
        return logo;
    }

    public void setMenu(AbstractMenu menu) {
        this.menu = menu;
    }

    public void setHeader(AbstractHeader header) {
        this.header = header;
    }

    public void setMainContent(AbstractMainContent mainContent) {
        this.mainContent = mainContent;
    }

    public void setFooter(AbstractFooter footer) {
        this.footer = footer;
    }

    public void setLogo(ImageIcon logo) {
        this.logo = logo;
    }

    public AbstractAppLayout(AbstractMenu menu, AbstractHeader header, AbstractMainContent mainContent, AbstractFooter footer) {
        super("WordEditor");
        this.menu = menu;
        this.header = header;
        this.mainContent = mainContent;
        this.footer = footer;
    }

    public abstract void init();

    public abstract void setLogo();
}
