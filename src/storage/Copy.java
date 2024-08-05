package storage;

import Interfaces.ICopy;
import layout.AbstractAppLayout;

public class Copy implements ICopy {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public Copy(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    @Override
    public void copy() {
        appLayout.getMainContent().getTextPane().copy();
    }
}
