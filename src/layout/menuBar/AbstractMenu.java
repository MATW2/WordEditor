package layout.menuBar;

import javax.swing.*;

public abstract class AbstractMenu {
    protected JMenuBar menuBar;
    protected JMenu menuFile;
    protected JMenu menuEdit;
    protected JMenu menuAbout;
    protected JMenuItem iNew;
    protected JMenuItem iOpen;
    protected JMenuItem iSave;
    protected JMenuItem iSaveAS;
    protected JMenuItem iExit;
    protected JMenuItem iUndo;
    protected JMenuItem iRedo;
    protected JMenuItem iCopy;
    protected JMenuItem iCut;
    protected JMenuItem iPast;
    protected JMenuItem iSelectAll;
    protected JMenuItem iAbout;

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public JMenu getMenuFile() {
        return menuFile;
    }

    public JMenu getMenuEdit() {
        return menuEdit;
    }

    public JMenu getMenuAbout() {
        return menuAbout;
    }

    public JMenuItem getiNew() {
        return iNew;
    }

    public JMenuItem getiOpen() {
        return iOpen;
    }

    public JMenuItem getiSave() {
        return iSave;
    }

    public JMenuItem getiSaveAS() {
        return iSaveAS;
    }

    public JMenuItem getiExit() {
        return iExit;
    }

    public JMenuItem getiUndo() {
        return iUndo;
    }

    public JMenuItem getiRedo() {
        return iRedo;
    }

    public JMenuItem getiCopy() {
        return iCopy;
    }

    public JMenuItem getiCut() {
        return iCut;
    }

    public JMenuItem getiPast() {
        return iPast;
    }

    public JMenuItem getiSelectAll() {
        return iSelectAll;
    }

    public JMenuItem getiAbout() {
        return iAbout;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public void setMenuFile(JMenu menuFile) {
        this.menuFile = menuFile;
    }

    public void setMenuEdit(JMenu menuEdit) {
        this.menuEdit = menuEdit;
    }

    public void setMenuAbout(JMenu menuAbout) {
        this.menuAbout = menuAbout;
    }

    public void setiNew(JMenuItem iNew) {
        this.iNew = iNew;
    }

    public void setiOpen(JMenuItem iOpen) {
        this.iOpen = iOpen;
    }

    public void setiSave(JMenuItem iSave) {
        this.iSave = iSave;
    }

    public void setiSaveAS(JMenuItem iSaveAS) {
        this.iSaveAS = iSaveAS;
    }

    public void setiExit(JMenuItem iExit) {
        this.iExit = iExit;
    }

    public void setiUndo(JMenuItem iUndo) {
        this.iUndo = iUndo;
    }

    public void setiRedo(JMenuItem iRedo) {
        this.iRedo = iRedo;
    }

    public void setiCopy(JMenuItem iCopy) {
        this.iCopy = iCopy;
    }

    public void setiCut(JMenuItem iCut) {
        this.iCut = iCut;
    }

    public void setiPast(JMenuItem iPast) {
        this.iPast = iPast;
    }

    public void setiSelectAll(JMenuItem iSelectAll) {
        this.iSelectAll = iSelectAll;
    }

    public void setiAbout(JMenuItem iAbout) {
        this.iAbout = iAbout;
    }

    public AbstractMenu() {
    }

    public abstract JMenuBar addToMain();
}
