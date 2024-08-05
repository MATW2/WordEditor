package storage;

import Interfaces.ISelectAll;
import layout.AbstractAppLayout;

public class SelectAll implements ISelectAll {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public SelectAll(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    @Override
    public void selectAll() {
        appLayout.getMainContent().getTextPane().selectAll();
    }
}
