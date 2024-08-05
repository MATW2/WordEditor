package action;

import Interfaces.IFontFamily;
import Interfaces.ISizeFont;
import layout.AbstractAppLayout;
import Interfaces.ILetterSpacing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public record IListener(AbstractAppLayout appLayout,
                        ISizeFont sizeFont,
                        IFontFamily fontFamily,
                        ILetterSpacing letterSpacing) implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == appLayout.getHeader().getSizeFontComboBox()) {
            String selectedSize = (String) appLayout.getHeader().getSizeFontComboBox().getSelectedItem();
            sizeFont.sizefont(selectedSize);
        }
        if (e.getSource() == appLayout.getHeader().getFontComboBox()) {
            String selectedFontFamily = (String) appLayout.getHeader().getFontComboBox().getSelectedItem();
            fontFamily.fontfamily(selectedFontFamily);
        }
        if (e.getSource() == appLayout.getHeader().getLineSpacingComboBox()) {
            String selectedSpacing = (String) appLayout.getHeader().getLineSpacingComboBox().getSelectedItem();
            letterSpacing.lineSpacing(selectedSpacing);
        }
    }
}
