package storage;

import Interfaces.IPast;
import layout.AbstractAppLayout;

public class Past implements IPast {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public Past(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    @Override
    public void past() {
        appLayout.getMainContent().getTextPane().paste();
    }
}
