package exit;

import Interfaces.IExit;

public class Exit implements IExit {
    @Override
    public void exit() {
        System.exit(0);
    }
}
