package paragraph;

import Interfaces.ILetterSpacing;
import layout.AbstractAppLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;

public class LineSpacing implements ILetterSpacing {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public LineSpacing(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    @Override
    public void lineSpacing(String selectedSpacing) {
        if (selectedSpacing != null) {
            float newLineSpacing = Float.parseFloat(selectedSpacing);
            StyledDocument doc = appLayout.getMainContent().getTextPane().getStyledDocument();
            int caretPosition = appLayout.getMainContent().getTextPane().getCaretPosition();
            Element element = doc.getParagraphElement(caretPosition);
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setLineSpacing(sas, newLineSpacing - 1.0f);
            doc.setParagraphAttributes(element.getStartOffset(), element.getEndOffset() - element.getStartOffset(), sas, false);
        }
    }
}
