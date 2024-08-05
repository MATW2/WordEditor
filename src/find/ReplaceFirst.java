package find;

import Interfaces.IReplaceFirst;
import layout.AbstractAppLayout;
import layout.findGui.AbstractFindGui;

import javax.swing.*;

public class ReplaceFirst implements IReplaceFirst {
    private AbstractAppLayout appLayout;
    private AbstractFindGui findGui;
    private int selectStart = -1;
    private int selectEnd;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public AbstractFindGui getFindGui() {
        return findGui;
    }

    public int getSelectStart() {
        return selectStart;
    }

    public int getSelectEnd() {
        return selectEnd;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public void setFindGui(AbstractFindGui findGui) {
        this.findGui = findGui;
    }

    public void setSelectStart(int selectStart) {
        this.selectStart = selectStart;
    }

    public void setSelectEnd(int selectEnd) {
        this.selectEnd = selectEnd;
    }

    public ReplaceFirst(AbstractAppLayout appLayout, AbstractFindGui findGui) {
        this.appLayout = appLayout;
        this.findGui = findGui;
    }

    @Override
    public void replaceFirst() {
        if (!findGui.getFindTextField().getText().isEmpty() && !findGui.getReplaceTextField().getText().isEmpty()) {
            selectStart = appLayout.getMainContent().getTextPane().getText().replace("\n", "").indexOf(findGui.getFindTextField().getText());
            selectEnd = selectStart + findGui.getFindTextField().getText().length();
            appLayout.getMainContent().getTextPane().select(selectStart, selectEnd);
            if (selectStart != -1) {
                appLayout.getMainContent().getTextPane().replaceSelection(findGui.getReplaceTextField().getText());
            } else {
                JOptionPane.showMessageDialog(null, "WordEditor zakończył przeszukiwanie dokumentu.", "WordEditor", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
