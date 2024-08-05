package font;

import Interfaces.IFontFamily;
import layout.AbstractAppLayout;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class FontFamily implements IFontFamily {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public FontFamily(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    @Override
    public void fontfamily(String selectedFontFamily) {
        if (selectedFontFamily != null) {
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setFontFamily(sas, selectedFontFamily);
            appLayout.getMainContent().getTextPane().setCharacterAttributes(sas, false);
        }
    }
}
