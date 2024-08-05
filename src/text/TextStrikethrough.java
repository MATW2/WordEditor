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

public class TextStrikethrough extends StyledEditorKit.StyledTextAction {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public TextStrikethrough(AbstractAppLayout appLayout) {
        super("font-Strikethrough");
        this.appLayout = appLayout;

    }

    public void actionPerformed(ActionEvent e) {
        JEditorPane editor = getEditor(e);
        if (editor != null) {
            StyledEditorKit kit = getStyledEditorKit(editor);
            MutableAttributeSet attr = kit.getInputAttributes();
            boolean strikeThrough = !StyleConstants.isStrikeThrough(attr);
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setStrikeThrough(sas, strikeThrough);
            setCharacterAttributes(editor, sas, false);
            if (strikeThrough) {
                appLayout.getHeader().getStrikeButton().setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(51, 76, 45)));
            } else {
                appLayout.getHeader().getStrikeButton().setBorder(new EmptyBorder(0, 0, 0, 0));
            }
        }
    }
}

