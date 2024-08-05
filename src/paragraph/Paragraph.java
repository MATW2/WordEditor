package paragraph;

import Interfaces.IParagraph;
import layout.AbstractAppLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;

public class Paragraph implements IParagraph {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public Paragraph(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    @Override
    public void alignLeft() {
        paragraph(appLayout.getHeader().getLeftAlignButton(), appLayout.getHeader().getCenterAlignButton(), appLayout.getHeader().getRightAlignButton(), appLayout.getHeader().getJustificationButton(), StyleConstants.ALIGN_LEFT);
    }

    @Override
    public void alignCenter() {
        paragraph(appLayout.getHeader().getCenterAlignButton(), appLayout.getHeader().getLeftAlignButton(), appLayout.getHeader().getRightAlignButton(), appLayout.getHeader().getJustificationButton(), StyleConstants.ALIGN_CENTER);
    }

    @Override
    public void alignRight() {
        paragraph(appLayout.getHeader().getRightAlignButton(), appLayout.getHeader().getLeftAlignButton(), appLayout.getHeader().getCenterAlignButton(), appLayout.getHeader().getJustificationButton(), StyleConstants.ALIGN_RIGHT);
    }

    @Override
    public void alignJustified() {
        paragraph(appLayout.getHeader().getJustificationButton(), appLayout.getHeader().getLeftAlignButton(), appLayout.getHeader().getCenterAlignButton(), appLayout.getHeader().getRightAlignButton(), StyleConstants.ALIGN_JUSTIFIED);
    }

    private void paragraph(JButton nameButton, JButton nameButtonDel, JButton nameButtonDel2, JButton nameButtonDel3, int name) {
        StyledDocument doc = appLayout.getMainContent().getTextPane().getStyledDocument();
        int caretPosition = appLayout.getMainContent().getTextPane().getCaretPosition();
        Element element = doc.getParagraphElement(caretPosition);
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setAlignment(sas, name);
        doc.setParagraphAttributes(element.getStartOffset(), element.getEndOffset() - element.getStartOffset(), sas, false);
        AttributeSet as = element.getAttributes();

        if (StyleConstants.getAlignment(as) == name) {
            nameButton.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(51, 76, 45)));
            nameButtonDel.setBorder(new EmptyBorder(0, 0, 0, 0));
            nameButtonDel2.setBorder(new EmptyBorder(0, 0, 0, 0));
            nameButtonDel3.setBorder(new EmptyBorder(0, 0, 0, 0));
        }
    }
}
