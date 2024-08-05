package appThread;

import layout.AbstractAppLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeThread implements Runnable {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public TimeThread(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    @Override
    public void run() {
        while (true) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
            String dateTime = dateFormat.format(new Date());
            appLayout.getHeader().getDateAndTimeLabel().setText(dateTime);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
