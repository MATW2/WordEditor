package font;

import layout.AbstractAppLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BoldFont extends StyledEditorKit.StyledTextAction {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public BoldFont(AbstractAppLayout appLayout) {
        super("font-bold");
        this.appLayout = appLayout;
    }

    public void actionPerformed(ActionEvent e) {
        JEditorPane editor = getEditor(e);
        if (editor != null) {
            StyledEditorKit kit = getStyledEditorKit(editor);
            MutableAttributeSet attr = kit.getInputAttributes();
            boolean bold = !StyleConstants.isBold(attr);
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setBold(sas, bold);
            setCharacterAttributes(editor, sas, false);
            if (bold) {
                appLayout.getHeader().getBoldButton().setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(51, 76, 45)));
            } else {
                appLayout.getHeader().getBoldButton().setBorder(new EmptyBorder(0, 0, 0, 0));
            }
        }
    }
}