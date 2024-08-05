package appThread;

import layout.AbstractAppLayout;

import javax.swing.text.Element;

public class LineThread implements Runnable {
    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public LineThread(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    @Override
    public void run() {
        while (true) {
            int caretPosition = appLayout.getMainContent().getTextPane().getCaretPosition();
            Element element = appLayout.getMainContent().getTextPane().getDocument().getDefaultRootElement();
            int kol = element.getElementIndex(caretPosition) + 1;
            appLayout.getFooter().getLineLabel().setText("Lin " + kol);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
