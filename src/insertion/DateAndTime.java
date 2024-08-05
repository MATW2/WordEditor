package insertion;

import Interfaces.IDateAndTime;
import layout.AbstractAppLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.text.*;
import java.awt.*;

public class DateAndTime implements IDateAndTime {
    private AbstractAppLayout appLayout;
    private Color colorWanted;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public Color getColorWanted() {
        return colorWanted;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public void setColorWanted(Color colorWanted) {
        this.colorWanted = colorWanted;
    }

    public DateAndTime(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
        colorWanted = new Color(51, 76, 45);
    }

    private boolean hasColorWanted(JButton button, Color colorWanted) {
        Border border = button.getBorder();
        Color borderColor = null;
        if (border instanceof MatteBorder) borderColor = ((MatteBorder) border).getMatteColor();
        return borderColor != null && borderColor.equals(colorWanted);
    }

    private Color colorTextAttribute(JButton nameButton) {
        Border border = nameButton.getBorder();
        Color borderColor = null;
        if (border instanceof MatteBorder) borderColor = ((MatteBorder) border).getMatteColor();
        return borderColor;
    }

    private SimpleAttributeSet setAttribute() {
        SimpleAttributeSet sas = new SimpleAttributeSet();

        String selectedFontSize = (String) appLayout.getHeader().getSizeFontComboBox().getSelectedItem();
        String selectedFont = (String) appLayout.getHeader().getFontComboBox().getSelectedItem();

        StyleConstants.setFontFamily(sas, selectedFont);
        StyleConstants.setFontSize(sas, Integer.parseInt(selectedFontSize));

        StyleConstants.setBold(sas, hasColorWanted(appLayout.getHeader().getBoldButton(), colorWanted));
        StyleConstants.setItalic(sas, hasColorWanted(appLayout.getHeader().getItalicButton(), colorWanted));
        StyleConstants.setUnderline(sas, hasColorWanted(appLayout.getHeader().getUnderlineButton(), colorWanted));
        StyleConstants.setStrikeThrough(sas, hasColorWanted(appLayout.getHeader().getStrikeButton(), colorWanted));
        StyleConstants.setSubscript(sas, hasColorWanted(appLayout.getHeader().getSubscriptButton(), colorWanted));
        StyleConstants.setSuperscript(sas, hasColorWanted(appLayout.getHeader().getSuperscriptButton(), colorWanted));
        StyleConstants.setForeground(sas, colorTextAttribute(appLayout.getHeader().getTextColorButton()));
        StyleConstants.setBackground(sas, colorTextAttribute(appLayout.getHeader().getTextBackgroundColorButton()));

        return sas;
    }

    @Override
    public void insertDataAndTime() {
        int caretPosition = appLayout.getMainContent().getTextPane().getCaretPosition();
        StyledDocument doc = appLayout.getMainContent().getTextPane().getStyledDocument();
        try {
            doc.insertString(caretPosition, " " + appLayout.getHeader().getDateAndTimeLabel().getText(), setAttribute());
        } catch (BadLocationException ex) {
            throw new RuntimeException(ex);
        }
    }
}
