package find;

import Interfaces.ICancel;
import layout.findGui.AbstractFindGui;

public class Cancel implements ICancel {

    @Override
    public void cancel(AbstractFindGui findGui) {
        findGui.setVisible(false);
    }
}
