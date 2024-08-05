package text;

import layout.AbstractAppLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TextUnderline extends StyledEditorKit.StyledTextAction {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public TextUnderline(AbstractAppLayout appLayout) {
        super("font-Underline");
        this.appLayout = appLayout;
    }

    public void actionPerformed(ActionEvent e) {
        JEditorPane editor = getEditor(e);
        if (editor != null) {
            StyledEditorKit kit = getStyledEditorKit(editor);
            MutableAttributeSet attr = kit.getInputAttributes();
            boolean underline = !StyleConstants.isUnderline(attr);
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setUnderline(sas, underline);
            setCharacterAttributes(editor, sas, false);
            if (underline) {
                appLayout.getHeader().getUnderlineButton().setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(51, 76, 45)));
            } else {
                appLayout.getHeader().getUnderlineButton().setBorder(new EmptyBorder(0, 0, 0, 0));
            }
        }
    }
}

