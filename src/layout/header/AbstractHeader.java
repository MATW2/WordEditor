package layout.header;

import javax.swing.*;
import java.util.ArrayList;

public abstract class AbstractHeader {
    protected JPanel mainHeaderPanel, wraperPanel;
    protected JPanel storagePanel, fontPanel, paragraphPanel, editPanel, insertTimePanel;
    protected JPanel groupTextPanel;
    protected JButton pastButton, cutButton, copyButton, replaceButton;
    protected JButton boldButton, italicButton, underlineButton, strikeButton, superscriptButton, subscriptButton, textColorButton, textBackgroundColorButton;
    protected JButton rightAlignButton, centerAlignButton, leftAlignButton, justificationButton, leftAlignmentButton, rightAlignmentButton;
    protected JButton searchButton, selectAllButton;
    protected JButton timeButton;
    protected String[] fontList;
    protected String[] fontSizeList;
    protected String[] lineSpacingList;
    protected JComboBox fontComboBox, sizeFontComboBox, lineSpacingComboBox;
    protected JLabel dateAndTimeLabel;

    public JPanel getMainHeaderPanel() {
        return mainHeaderPanel;
    }

    public JPanel getWraperPanel() {
        return wraperPanel;
    }

    public JPanel getStoragePanel() {
        return storagePanel;
    }

    public JPanel getFontPanel() {
        return fontPanel;
    }

    public JPanel getParagraphPanel() {
        return paragraphPanel;
    }

    public JPanel getEditPanel() {
        return editPanel;
    }

    public JPanel getInsertTimePanel() {
        return insertTimePanel;
    }

    public JPanel getGroupTextPanel() {
        return groupTextPanel;
    }

    public JButton getPastButton() {
        return pastButton;
    }

    public JButton getCutButton() {
        return cutButton;
    }

    public JButton getCopyButton() {
        return copyButton;
    }

    public JButton getReplaceButton() {
        return replaceButton;
    }

    public JButton getBoldButton() {
        return boldButton;
    }

    public JButton getItalicButton() {
        return italicButton;
    }

    public JButton getUnderlineButton() {
        return underlineButton;
    }

    public JButton getStrikeButton() {
        return strikeButton;
    }

    public JButton getSuperscriptButton() {
        return superscriptButton;
    }

    public JButton getSubscriptButton() {
        return subscriptButton;
    }

    public JButton getTextColorButton() {
        return textColorButton;
    }

    public JButton getTextBackgroundColorButton() {
        return textBackgroundColorButton;
    }

    public JButton getRightAlignButton() {
        return rightAlignButton;
    }

    public JButton getCenterAlignButton() {
        return centerAlignButton;
    }

    public JButton getLeftAlignButton() {
        return leftAlignButton;
    }

    public JButton getJustificationButton() {
        return justificationButton;
    }

    public JButton getLeftAlignmentButton() {
        return leftAlignmentButton;
    }

    public JButton getRightAlignmentButton() {
        return rightAlignmentButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getSelectAllButton() {
        return selectAllButton;
    }

    public JButton getTimeButton() {
        return timeButton;
    }

    public String[] getFontList() {
        return fontList;
    }

    public String[] getFontSizeList() {
        return fontSizeList;
    }

    public String[] getLineSpacingList() {
        return lineSpacingList;
    }

    public JComboBox getFontComboBox() {
        return fontComboBox;
    }

    public JComboBox getSizeFontComboBox() {
        return sizeFontComboBox;
    }

    public JComboBox getLineSpacingComboBox() {
        return lineSpacingComboBox;
    }

    public JLabel getDateAndTimeLabel() {
        return dateAndTimeLabel;
    }

    public void setMainHeaderPanel(JPanel mainHeaderPanel) {
        this.mainHeaderPanel = mainHeaderPanel;
    }

    public void setWraperPanel(JPanel wraperPanel) {
        this.wraperPanel = wraperPanel;
    }

    public void setStoragePanel(JPanel storagePanel) {
        this.storagePanel = storagePanel;
    }

    public void setFontPanel(JPanel fontPanel) {
        this.fontPanel = fontPanel;
    }

    public void setParagraphPanel(JPanel paragraphPanel) {
        this.paragraphPanel = paragraphPanel;
    }

    public void setEditPanel(JPanel editPanel) {
        this.editPanel = editPanel;
    }

    public void setInsertTimePanel(JPanel insertTimePanel) {
        this.insertTimePanel = insertTimePanel;
    }

    public void setGroupTextPanel(JPanel groupTextPanel) {
        this.groupTextPanel = groupTextPanel;
    }

    public void setPastButton(JButton pastButton) {
        this.pastButton = pastButton;
    }

    public void setCutButton(JButton cutButton) {
        this.cutButton = cutButton;
    }

    public void setCopyButton(JButton copyButton) {
        this.copyButton = copyButton;
    }

    public void setReplaceButton(JButton replaceButton) {
        this.replaceButton = replaceButton;
    }

    public void setBoldButton(JButton boldButton) {
        this.boldButton = boldButton;
    }

    public void setItalicButton(JButton italicButton) {
        this.italicButton = italicButton;
    }

    public void setUnderlineButton(JButton underlineButton) {
        this.underlineButton = underlineButton;
    }

    public void setStrikeButton(JButton strikeButton) {
        this.strikeButton = strikeButton;
    }

    public void setSuperscriptButton(JButton superscriptButton) {
        this.superscriptButton = superscriptButton;
    }

    public void setSubscriptButton(JButton subscriptButton) {
        this.subscriptButton = subscriptButton;
    }

    public void setTextColorButton(JButton textColorButton) {
        this.textColorButton = textColorButton;
    }

    public void setTextBackgroundColorButton(JButton textBackgroundColorButton) {
        this.textBackgroundColorButton = textBackgroundColorButton;
    }

    public void setRightAlignButton(JButton rightAlignButton) {
        this.rightAlignButton = rightAlignButton;
    }

    public void setCenterAlignButton(JButton centerAlignButton) {
        this.centerAlignButton = centerAlignButton;
    }

    public void setLeftAlignButton(JButton leftAlignButton) {
        this.leftAlignButton = leftAlignButton;
    }

    public void setJustificationButton(JButton justificationButton) {
        this.justificationButton = justificationButton;
    }

    public void setLeftAlignmentButton(JButton leftAlignmentButton) {
        this.leftAlignmentButton = leftAlignmentButton;
    }

    public void setRightAlignmentButton(JButton rightAlignmentButton) {
        this.rightAlignmentButton = rightAlignmentButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public void setSelectAllButton(JButton selectAllButton) {
        this.selectAllButton = selectAllButton;
    }

    public void setTimeButton(JButton timeButton) {
        this.timeButton = timeButton;
    }

    public void setFontList(String[] fontList) {
        this.fontList = fontList;
    }

    public void setFontSizeList(String[] fontSizeList) {
        this.fontSizeList = fontSizeList;
    }

    public void setLineSpacingList(String[] lineSpacingList) {
        this.lineSpacingList = lineSpacingList;
    }

    public void setFontComboBox(JComboBox fontComboBox) {
        this.fontComboBox = fontComboBox;
    }

    public void setSizeFontComboBox(JComboBox sizeFontComboBox) {
        this.sizeFontComboBox = sizeFontComboBox;
    }

    public void setLineSpacingComboBox(JComboBox lineSpacingComboBox) {
        this.lineSpacingComboBox = lineSpacingComboBox;
    }

    public void setDateAndTimeLabel(JLabel dateAndTimeLabel) {
        this.dateAndTimeLabel = dateAndTimeLabel;
    }

    public AbstractHeader() {
    }

    public abstract JPanel addTomain();
}
