package SelectAtribute;

import Interfaces.ISelectAtribute;
import layout.AbstractAppLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class SelectAttribute implements ISelectAtribute {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public SelectAttribute(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    @Override
    public void selectAtribute() {
        selectAttributesSwitch(appLayout.getMainContent().getTextPane().getSelectionStart() == appLayout.getMainContent().getTextPane().getSelectionEnd() ? 1 : -1);
    }

    private void selectAttributesSwitch(int number) {
        int caretPosition = appLayout.getMainContent().getTextPane().getCaretPosition();
        StyledDocument doc = appLayout.getMainContent().getTextPane().getStyledDocument();
        Element element = doc.getCharacterElement(caretPosition);
        if((caretPosition == element.getStartOffset())) {
            if(caretPosition == doc.getParagraphElement(caretPosition).getStartOffset()) element = doc.getCharacterElement(caretPosition - (number + 1));
            else element = doc.getCharacterElement(caretPosition - number);
        }
        AttributeSet as = element.getAttributes();

        buttonSelectAttribute(appLayout.getHeader().getBoldButton(), StyleConstants.isBold(as));
        buttonSelectAttribute(appLayout.getHeader().getItalicButton(), StyleConstants.isItalic(as));
        buttonSelectAttribute(appLayout.getHeader().getUnderlineButton(), StyleConstants.isUnderline(as));
        buttonSelectAttribute(appLayout.getHeader().getStrikeButton(), StyleConstants.isStrikeThrough(as));
        buttonWithBlockSelectAttribute(appLayout.getHeader().getSubscriptButton(), appLayout.getHeader().getSuperscriptButton(), StyleConstants.isSubscript(as));
        buttonWithBlockSelectAttribute(appLayout.getHeader().getSuperscriptButton(), appLayout.getHeader().getSubscriptButton(), StyleConstants.isSuperscript(as));

        alignSelectAttribute(appLayout.getHeader().getLeftAlignButton(), StyleConstants.getAlignment(as), 0);
        alignSelectAttribute(appLayout.getHeader().getCenterAlignButton(), StyleConstants.getAlignment(as), 1);
        alignSelectAttribute(appLayout.getHeader().getRightAlignButton(), StyleConstants.getAlignment(as), 2);
        alignSelectAttribute(appLayout.getHeader().getJustificationButton(), StyleConstants.getAlignment(as), 3);

        selectColorTextAttribute(appLayout.getHeader().getTextColorButton(), StyleConstants.getForeground(as));

        if (as.getAttribute(StyleConstants.Background) != null)
            selectColorTextAttribute(appLayout.getHeader().getTextBackgroundColorButton(), StyleConstants.getBackground(as));
        else
            appLayout.getHeader().getTextBackgroundColorButton().setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.WHITE));

        fontSizeSelectAttribute(StyleConstants.getFontSize(as));
        fontFamilySelectAttribute(StyleConstants.getFontFamily(as));
    }

    private void buttonSelectAttribute(JButton nameButton, Boolean is) {
        nameButton.setBorder(is ? BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(51, 76, 45)) : new EmptyBorder(0, 0, 0, 0));
    }

    private void buttonWithBlockSelectAttribute(JButton nameButton, JButton namebButtonBlock, Boolean is) {
        if (is) {
            nameButton.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(51, 76, 45)));
            namebButtonBlock.setEnabled(false);
        } else {
            nameButton.setBorder(new EmptyBorder(0, 0, 0, 0));
            namebButtonBlock.setEnabled(true);
        }
    }

    private void alignSelectAttribute(JButton nameButton, int alignment, int style) {
        nameButton.setBorder(alignment == style ? BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(51, 76, 45)) : new EmptyBorder(0, 0, 0, 0));
    }


    private void fontSizeSelectAttribute(int fontSize) {
        if (appLayout.getMainContent().getTextPane().getSelectionStart() == appLayout.getMainContent().getTextPane().getSelectionEnd()) {
            String selectedFontSize = (String) appLayout.getHeader().getSizeFontComboBox().getSelectedItem();
            String fontSizeString = String.valueOf(fontSize);
            if (!fontSizeString.equals(selectedFontSize))
                appLayout.getHeader().getSizeFontComboBox().setSelectedItem(fontSizeString);
        }
    }

    private void fontFamilySelectAttribute(String fontFamily) {
        if (appLayout.getMainContent().getTextPane().getSelectionStart() == appLayout.getMainContent().getTextPane().getSelectionEnd()) {
            String selectedFont = (String) appLayout.getHeader().getFontComboBox().getSelectedItem();
            if (!fontFamily.equals(selectedFont)) appLayout.getHeader().getFontComboBox().setSelectedItem(fontFamily);
            if (fontFamily.equals("Dialog")) appLayout.getHeader().getFontComboBox().setSelectedItem("Arial");
        }
    }

    private void selectColorTextAttribute(JButton nameButton, Color colorText) {
        Border border = nameButton.getBorder();
        Color borderColor = null;
        if (border instanceof MatteBorder) borderColor = ((MatteBorder) border).getMatteColor();
        if (!colorText.equals(borderColor))
            nameButton.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, colorText));
    }
}
