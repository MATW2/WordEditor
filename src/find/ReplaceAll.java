package find;

import Interfaces.IReplaceAll;
import layout.AbstractAppLayout;
import layout.findGui.AbstractFindGui;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class ReplaceAll implements IReplaceAll {
    private AbstractAppLayout appLayout;
    private AbstractFindGui findGui;
    private int startIndex = 0;
    private int selectStart;

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

    public ReplaceAll(AbstractAppLayout appLayout, AbstractFindGui findGui) {
        this.appLayout = appLayout;
        this.findGui = findGui;
    }

    @Override
    public void replaceAll() {
        if (!findGui.getFindTextField().getText().isEmpty()) {
            if (!findGui.getFindTextField().getText().isEmpty() && !findGui.getReplaceTextField().getText().isEmpty()) {
                try {
                    selectStart = appLayout.getMainContent().getTextPane().getText().replace("\n", "").indexOf(findGui.getFindTextField().getText(), startIndex);
                    if (selectStart == -1) {
                        JOptionPane.showMessageDialog(null, "WordEditor zakończył przeszukiwanie dokumentu.", "WordEditor", JOptionPane.INFORMATION_MESSAGE);
                        startIndex = 0;
                    } else {
                        while (selectStart != -1) {
                            StyledDocument doc = appLayout.getMainContent().getTextPane().getStyledDocument();
                            AttributeSet as = doc.getCharacterElement(selectStart).getAttributes();
                            doc.remove(selectStart, findGui.getFindTextField().getText().length());
                            doc.insertString(selectStart, findGui.getReplaceTextField().getText(), as);
                            selectStart = appLayout.getMainContent().getTextPane().getText().replace("\n", "").indexOf(findGui.getFindTextField().getText(), selectStart + findGui.getReplaceTextField().getText().length());
                            if (selectStart == -1) {
                                JOptionPane.showMessageDialog(null, "WordEditor zakończył zamiane elemntów.", "WordEditor", JOptionPane.INFORMATION_MESSAGE);
                                startIndex = 0;
                            }
                        }
                    }
                } catch (BadLocationException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
