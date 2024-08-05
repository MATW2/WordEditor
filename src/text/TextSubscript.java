package text;

import layout.AbstractAppLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TextSubscript extends StyledEditorKit.StyledTextAction {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public TextSubscript(AbstractAppLayout appLayout) {
        super("font-Subscript");
        this.appLayout = appLayout;
    }

    public void actionPerformed(ActionEvent e) {
        JEditorPane editor = getEditor(e);
        if (editor != null) {
            StyledEditorKit kit = getStyledEditorKit(editor);
            MutableAttributeSet attr = kit.getInputAttributes();
            boolean subscript = !StyleConstants.isSubscript(attr);
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setSubscript(sas, subscript);
            setCharacterAttributes(editor, sas, false);
            if (subscript) {
                appLayout.getHeader().getSubscriptButton().setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(51, 76, 45)));
                appLayout.getHeader().getSuperscriptButton().setEnabled(false);
            } else {
                appLayout.getHeader().getSubscriptButton().setBorder(new EmptyBorder(0, 0, 0, 0));
                appLayout.getHeader().getSuperscriptButton().setEnabled(true);
            }
        }
    }
}
