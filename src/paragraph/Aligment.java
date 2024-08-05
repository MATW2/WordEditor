package paragraph;

import Interfaces.IAligment;
import layout.AbstractAppLayout;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Aligment implements IAligment {
    private AbstractAppLayout appLayout;
    private Float indent;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public Float getIndent() {
        return indent;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public void setIndent(Float indent) {
        this.indent = indent;
    }

    public Aligment(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
        indent = 0.0F;
    }

    @Override
    public void increasingIndent() {
        indent += 50.0F;
        float maxIndent = appLayout.getMainContent().getTextPane().getWidth() - 50.0F;

        if (indent > maxIndent) {
            indent = maxIndent;
        } else {
            alignment();
        }
    }

    @Override
    public void reducingIndent() {
        indent -= 50.0F;

        if (indent < 0.0F) {
            indent = 0.0F;
        } else {
            alignment();
        }
    }

    private void alignment() {
        StyledDocument doc = appLayout.getMainContent().getTextPane().getStyledDocument();
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setLeftIndent(sas, indent);
        doc.setParagraphAttributes(0, doc.getLength(), sas, false);
    }
}
