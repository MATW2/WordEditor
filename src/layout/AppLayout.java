package layout;

import layout.footer.AbstractFooter;
import layout.header.AbstractHeader;
import layout.mainContent.AbstractMainContent;
import layout.menuBar.AbstractMenu;

import javax.swing.*;
import java.awt.*;

public class AppLayout extends AbstractAppLayout {
    public AppLayout(AbstractMenu menu, AbstractHeader header, AbstractMainContent mainContent, AbstractFooter footer) {
        super(menu, header, mainContent, footer);
        init();
    }

    @Override
    public void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setSize(1300, 400);
        setLogo();

        setJMenuBar(menu.addToMain());
        getContentPane().add(header.addTomain(), BorderLayout.NORTH);
        getContentPane().add(mainContent.addToMain(), BorderLayout.CENTER);
        getContentPane().add(footer.addToMain(), BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void setLogo() {
        try {
            logo = new ImageIcon(ClassLoader.getSystemResource("icon/Logo.png"));
        } catch (Exception ex) {
            logo = new ImageIcon(ClassLoader.getSystemResource(""));
        }
        setIconImage(logo.getImage());
    }
}
