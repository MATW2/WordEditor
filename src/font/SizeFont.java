package font;

import Interfaces.ISizeFont;
import layout.AbstractAppLayout;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class SizeFont implements ISizeFont {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public SizeFont(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    @Override
    public void sizefont(String selectedFontSize) {
        if (selectedFontSize != null) {
            int newFontSize = Integer.parseInt(selectedFontSize);
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setFontSize(sas, newFontSize);
            appLayout.getMainContent().getTextPane().setCharacterAttributes(sas, false);
        }
    }
}
