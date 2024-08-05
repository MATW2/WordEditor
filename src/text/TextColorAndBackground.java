package text;

import Interfaces.ITextBackgroundColor;
import Interfaces.ITextColor;
import layout.AbstractAppLayout;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class TextColorAndBackground implements ITextColor, ITextBackgroundColor {
    private AbstractAppLayout appLayout;
    private Color color;
    private MutableAttributeSet sas;
    private int selectionStart;
    private int selectionEnd;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public Color getColor() {
        return color;
    }

    public MutableAttributeSet getSas() {
        return sas;
    }

    public int getSelectionStart() {
        return selectionStart;
    }

    public int getSelectionEnd() {
        return selectionEnd;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSas(MutableAttributeSet sas) {
        this.sas = sas;
    }

    public void setSelectionStart(int selectionStart) {
        this.selectionStart = selectionStart;
    }

    public void setSelectionEnd(int selectionEnd) {
        this.selectionEnd = selectionEnd;
    }

    public TextColorAndBackground(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
        this.sas = new SimpleAttributeSet();
    }

    private void selectionText() {
        selectionStart = appLayout.getMainContent().getTextPane().getSelectionStart();
        selectionEnd = appLayout.getMainContent().getTextPane().getSelectionEnd();
        if (selectionStart == selectionEnd) {
            appLayout.getMainContent().getTextPane().setCharacterAttributes(sas, false);
        } else {
            appLayout.getMainContent().getTextPane().getStyledDocument().setCharacterAttributes(selectionStart, selectionEnd - selectionStart, sas, false);
        }
    }

    @Override
    public void addTextColor() {
        color = JColorChooser.showDialog(appLayout.getMainContent().getTextPane(), "Paleta kolorów", Color.BLACK);
        if (color != null) {
            appLayout.getHeader().getTextColorButton().setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, color));
            StyleConstants.setForeground(sas, color);
            selectionText();
        }
    }

    @Override
    public void addTextBackgroundColor() {
        color = JColorChooser.showDialog(appLayout.getMainContent().getTextPane(), "Paleta kolorów", Color.WHITE);
        if (color != null) {
            appLayout.getHeader().getTextBackgroundColorButton().setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, color));
            StyleConstants.setBackground(sas, color);
            selectionText();
        }
    }
}


