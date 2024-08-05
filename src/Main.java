import IconScale.IconScale;
import Interfaces.IIconScale;
import layout.AbstractAppLayout;
import layout.findGui.AbstractFindGui;
import layout.findGui.FindGui;
import layout.AppLayout;
import layout.footer.AbstractFooter;
import layout.footer.Footer;
import layout.header.AbstractHeader;
import layout.header.Header;
import layout.mainContent.AbstractMainContent;
import layout.mainContent.MainContent;
import layout.menuBar.AbstractMenu;
import layout.menuBar.Menu;
import listAction.ListAction;


public class Main {
    public static void main(String[] args) {
        IIconScale iconScale = new IconScale();
        AbstractMenu menuBar = new Menu();
        AbstractHeader header = new Header(iconScale);
        AbstractMainContent mainContent = new MainContent();
        AbstractFooter footer = new Footer();
        AbstractAppLayout appLayout = new AppLayout(menuBar, header, mainContent, footer);
        AbstractFindGui findGui = new FindGui(appLayout);
        new ListAction(appLayout, findGui);
        new Thread(new appThread.LineThread(appLayout)).start();
        new Thread(new appThread.KolumnThread(appLayout)).start();
        new Thread(new appThread.TimeThread(appLayout)).start();
    }
}