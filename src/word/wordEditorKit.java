package word;

import javax.swing.text.*;

public class wordEditorKit extends StyledEditorKit implements ViewFactory {
    @Override
    public ViewFactory getViewFactory() {
        return this;
    }

    @Override
    public javax.swing.text.View create(Element elem) {
        String kind = elem.getName();
        if (kind != null) {
            if (kind.equals(AbstractDocument.ContentElementName)) {
                return new View(elem);
            } else if (kind.equals(AbstractDocument.ParagraphElementName)) {
                return new ParagraphView(elem);
            } else if (kind.equals(AbstractDocument.SectionElementName)) {
                return new BoxView(elem, javax.swing.text.View.Y_AXIS);
            } else if (kind.equals(StyleConstants.ComponentElementName)) {
                return new ComponentView(elem);
            } else if (kind.equals(StyleConstants.IconElementName)) {
                return new IconView(elem);
            }
        }

        return new LabelView(elem);
    }
}