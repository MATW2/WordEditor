package find;

import Interfaces.IFindNext;
import layout.AbstractAppLayout;
import layout.findGui.AbstractFindGui;

import javax.swing.*;

public class FindNext implements IFindNext {
    private AbstractAppLayout appLayout;
    private AbstractFindGui findGui;
    private int startIndex = 0;
    private int selectStart;
    private int selectEnd;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public AbstractFindGui getFindGui() {
        return findGui;
    }

    public int getStartIndex() {
        return startIndex;
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

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setSelectStart(int selectStart) {
        this.selectStart = selectStart;
    }

    public void setSelectEnd(int selectEnd) {
        this.selectEnd = selectEnd;
    }

    public FindNext(AbstractAppLayout appLayout, AbstractFindGui findGui) {
        this.appLayout = appLayout;
        this.findGui = findGui;
    }

    @Override
    public void findNext() {
        if (!findGui.getFindTextField().getText().isEmpty()) {
            selectStart = appLayout.getMainContent().getTextPane().getText().replace("\n", "").indexOf(findGui.getFindTextField().getText(), startIndex);
            selectEnd = selectStart + findGui.getFindTextField().getText().length();
            appLayout.getMainContent().getTextPane().select(selectStart, selectEnd);
            startIndex = selectEnd;
            int caretPosition = appLayout.getMainContent().getTextPane().getCaretPosition();
            caretPosition = caretPosition - findGui.getFindTextField().getText().length();
            if (caretPosition == 0) {
                appLayout.getMainContent().getTextPane().select(0, 0);
            }
            if (selectStart == -1) {
                JOptionPane.showMessageDialog(null, "\nWordEditor zakończył przeszukiwanie dokumentu.", "WordEditor", JOptionPane.INFORMATION_MESSAGE);
                startIndex = 0;
            }
        }
    }
}
