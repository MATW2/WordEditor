package text;

import Interfaces.IClear;
import layout.AbstractAppLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;


public class Clear implements IClear {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public Clear(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    @Override
    public void clear() {
        if (appLayout.getMainContent().getTextPane().getText().isEmpty()) {
            SimpleAttributeSet sas = new SimpleAttributeSet();
            appLayout.getMainContent().getTextPane().setCharacterAttributes(sas, true);
        }
    }

    @Override
    public void clearLineSpacing() {
        appLayout.getHeader().getLineSpacingComboBox().setSelectedIndex(0);
    }

    @Override
    public void clearParagraph() {
        StyledDocument doc = appLayout.getMainContent().getTextPane().getStyledDocument();
        int caretPosition = appLayout.getMainContent().getTextPane().getCaretPosition();
        Element paragraphElement = doc.getParagraphElement(caretPosition);
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setAlignment(sas, StyleConstants.ALIGN_LEFT);
        doc.setParagraphAttributes(paragraphElement.getStartOffset(), paragraphElement.getEndOffset() - paragraphElement.getStartOffset(), sas, false);
        appLayout.getHeader().getLeftAlignButton().setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(51, 76, 45)));
        appLayout.getHeader().getCenterAlignButton().setBorder(new EmptyBorder(0, 0, 0, 0));
        appLayout.getHeader().getRightAlignButton().setBorder(new EmptyBorder(0, 0, 0, 0));
        appLayout.getHeader().getJustificationButton().setBorder(new EmptyBorder(0, 0, 0, 0));
    }
}
