package layout.menuBar;

import javax.swing.*;

public class Menu extends AbstractMenu {
    public Menu() {
        super();
        init();
        file();
        edit();
        about();
        new MenuStyle(this);
    }

    public void init() {
        menuBar = new JMenuBar();

        menuFile = new JMenu("File");
        iNew = new JMenuItem("Nowy");
        iOpen = new JMenuItem("Otwórz...");
        iSave = new JMenuItem("Zapisz");
        iSaveAS = new JMenuItem("Zapisz jako...");
        iExit = new JMenuItem("Zakończ");

        menuEdit = new JMenu("Edycja");
        iUndo = new JMenuItem("Cofnij");
        iRedo = new JMenuItem("Przywróć");
        iCopy = new JMenuItem("Kpoiuj");
        iPast = new JMenuItem("Wklej");
        iCut = new JMenuItem("Wytnij");
        iSelectAll = new JMenuItem("Zaznacz wszystko");

        menuAbout = new JMenu("Informacje");
        iAbout = new JMenuItem("Informacje");
    }

    private void file() {
        menuBar.add(menuFile);
        menuFile.add(iNew);
        menuFile.add(iOpen);
        menuFile.add(iSave);
        menuFile.add(iSaveAS);
        menuFile.add(iExit);
    }

    private void edit() {
        menuBar.add(menuEdit);
        menuEdit.add(iUndo);
        menuEdit.add(iRedo);
        menuEdit.add(iCopy);
        menuEdit.add(iPast);
        menuEdit.add(iCut);
        menuEdit.add(iSelectAll);
    }

    private void about() {
        menuAbout.add(iAbout);
        menuBar.add(menuAbout);
    }

    @Override
    public JMenuBar addToMain() {
        return menuBar;
    }
}
