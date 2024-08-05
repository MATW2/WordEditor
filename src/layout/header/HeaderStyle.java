package layout.header;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HeaderStyle {
    private AbstractHeader header;
    private Color colorDarkLightWhite;
    private Color colorLightDark;
    private Color colorBlack;
    private Color colorWhite;
    private Color colorGreen;
    private Color colorWhiteilver;
    private Color colorWhiteSilverLight;
    private Font timesNewRomanFont20, timesNewRomanFont16;
    private Dimension sizeComboBoxM;
    private Border borderEmpty;

    public AbstractHeader getHeader() {
        return header;
    }

    public Color getColorDarkLightWhite() {
        return colorDarkLightWhite;
    }

    public Color getColorLightDark() {
        return colorLightDark;
    }

    public Color getColorBlack() {
        return colorBlack;
    }

    public Color getColorWhite() {
        return colorWhite;
    }

    public Color getColorGreen() {
        return colorGreen;
    }

    public Color getColorWhiteilver() {
        return colorWhiteilver;
    }

    public Color getColorWhiteSilverLight() {
        return colorWhiteSilverLight;
    }

    public Font getTimesNewRomanFont20() {
        return timesNewRomanFont20;
    }

    public Font getTimesNewRomanFont16() {
        return timesNewRomanFont16;
    }

    public Dimension getSizeComboBoxM() {
        return sizeComboBoxM;
    }

    public Border getBorderEmpty() {
        return borderEmpty;
    }

    public void setColorGreen(Color colorGreen) {
        this.colorGreen = colorGreen;
    }

    public void setColorWhiteilver(Color colorWhiteilver) {
        this.colorWhiteilver = colorWhiteilver;
    }

    public void setColorWhiteSilverLight(Color colorWhiteSilverLight) {
        this.colorWhiteSilverLight = colorWhiteSilverLight;
    }

    public HeaderStyle(AbstractHeader header) {
        this.header = header;
        init();
        addStyle();
        addLabel();
    }

    private void init() {
        colorDarkLightWhite = new Color(246, 246, 246);
        colorBlack = new Color(0, 0, 0);
        colorLightDark = new Color(35, 32, 38);
        colorWhite = new Color(255, 255, 255);
        colorGreen = new Color(51, 76, 45);
        colorWhiteilver = new Color(240, 239, 240);
        colorWhiteSilverLight = new Color(244, 244, 244);

        timesNewRomanFont20 = new Font("Times New Roman", Font.BOLD, 20);
        timesNewRomanFont16 = new Font("Times New Roman", Font.BOLD, 16);

        sizeComboBoxM = new Dimension(60, 30);

        borderEmpty = new EmptyBorder(0, 0, 2, 0);
    }

    private void addStyle() {
        backgroundColorPanel(header.getMainHeaderPanel());
        backgroundColorPanel(header.getStoragePanel());
        backgroundColorPanel(header.getGroupTextPanel());
        backgroundColorPanel(header.getFontPanel());
        backgroundColorPanel(header.getParagraphPanel());
        backgroundColorPanel(header.getEditPanel());
        backgroundColorPanel(header.getInsertTimePanel());
        backgroundColorPanel(header.getWraperPanel());

        backgroundBorderLineColor(header.getMainHeaderPanel());

        styleButton(header.getSelectAllButton());
        styleButton(header.getCopyButton());
        styleButton(header.getPastButton());
        styleButton(header.getCutButton());
        styleButton(header.getReplaceButton());

        styleButton(header.getBoldButton());
        styleButton(header.getItalicButton());
        styleButton(header.getUnderlineButton());
        styleButton(header.getStrikeButton());
        styleButton(header.getSubscriptButton());
        styleButton(header.getSuperscriptButton());

        styleButton(header.getLeftAlignmentButton());
        styleButton(header.getRightAlignmentButton());
        styleButton(header.getLeftAlignButton());
        styleButton(header.getCenterAlignButton());
        styleButton(header.getRightAlignButton());
        styleButton(header.getJustificationButton());

        styleButton(header.getSearchButton());
        styleButton(header.getTimeButton());

        styleButtonFont(header.getCopyButton());
        styleButtonFont(header.getPastButton());
        styleButtonFont(header.getCutButton());
        styleButtonFont(header.getReplaceButton());
        styleButtonFont(header.getSearchButton());
        styleButtonFont(header.getSelectAllButton());

        styleSpecialButton(header.getTextColorButton(), colorBlack);
        styleSpecialButton(header.getTextBackgroundColorButton(), colorWhite);
        styleSpecialButton(header.getLeftAlignButton(), colorGreen);

        styleFontLabelDateAndTime(header.getDateAndTimeLabel());

        styleComboBoxL(header.getFontComboBox());

        styleComboBoxM(header.getSizeFontComboBox());
        styleComboBoxM(header.getLineSpacingComboBox());
    }

    public void backgroundColorPanel(JPanel name) {
        name.setBackground(colorWhiteilver);
    }

    public void backgroundBorderLineColor(JPanel name) {
        name.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, colorWhiteSilverLight));
    }

    public void styleButtonFont(JButton name) {
        name.setFont(timesNewRomanFont20);
        name.setForeground(colorLightDark);
    }

    public void styleFontLabelDateAndTime(JLabel name) {
        name.setFont(timesNewRomanFont16);
        name.setForeground(colorLightDark);
    }

    public void styleButton(JButton name) {
        name.setContentAreaFilled(false);
        name.setFocusable(false);
        name.setBorder(borderEmpty);
    }

    public void styleSpecialButton(JButton name, Color color) {
        name.setContentAreaFilled(false);
        name.setFocusable(false);
        name.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, color));
    }

    private void styleComboBoxM(JComboBox name) {
        name.setBackground(colorWhite);
        name.setFont(timesNewRomanFont16);
        name.setFocusable(false);
        name.setPreferredSize(sizeComboBoxM);
    }

    private void styleComboBoxL(JComboBox name) {
        name.setBackground(colorWhite);
        name.setFont(timesNewRomanFont16);
        name.setFocusable(false);
    }

    private void styleToolTip() {
        UIManager.put("ToolTip.background", colorWhite);
    }

    private void addLabel() {
        styleToolTip();
        header.getCopyButton().setToolTipText("Kopiuj tekst (Ctrl + C)");
        header.getPastButton().setToolTipText("Wklej tekst (Ctrl + V)");
        header.getCutButton().setToolTipText("Wytnij tekst (Ctrl + X)");
        header.getReplaceButton().setToolTipText("Zamień tekst");

        header.getBoldButton().setToolTipText("Pogrubienie");
        header.getItalicButton().setToolTipText("Kursywa");
        header.getUnderlineButton().setToolTipText("Podkreślenie");
        header.getStrikeButton().setToolTipText("Przekreślenie");
        header.getSubscriptButton().setToolTipText("Indeks dolny");
        header.getSuperscriptButton().setToolTipText("Indeks górny");

        header.getTextColorButton().setToolTipText("Kolor tekstu");
        header.getTextBackgroundColorButton().setToolTipText("Kolor wyróżnienia tekstu");

        header.getLeftAlignmentButton().setToolTipText("Zwiększ wcięcie");
        header.getRightAlignmentButton().setToolTipText("Zmniejsz wcięcie");

        header.getLeftAlignButton().setToolTipText("Wyrównanie tekstu do lewej");
        header.getCenterAlignButton().setToolTipText("Wyrównanie tekstu do środka");
        header.getRightAlignButton().setToolTipText("Wyrównanie tekstu do prawej");
        header.getJustificationButton().setToolTipText("Wyjustowanie");

        header.getSearchButton().setToolTipText("Szukaj");
        header.getSelectAllButton().setToolTipText("Zaznacz wszystko (Ctrl + A)");

        header.getTimeButton().setToolTipText("Wstaw datę i godzinę");

        header.getFontComboBox().setToolTipText("Rodzina czcionek");
        header.getSizeFontComboBox().setToolTipText("Rozmiar czionki");

        header.getLineSpacingComboBox().setToolTipText("Interlinia");
    }
}
