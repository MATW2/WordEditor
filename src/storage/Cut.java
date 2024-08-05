package storage;

import Interfaces.ICut;
import layout.AbstractAppLayout;

public class Cut implements ICut {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public Cut(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    @Override
    public void cut() {
        appLayout.getMainContent().getTextPane().cut();
    }
}
