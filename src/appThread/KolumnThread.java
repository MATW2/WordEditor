package appThread;

import layout.AbstractAppLayout;

import javax.swing.text.Element;

public class KolumnThread implements Runnable {

    private AbstractAppLayout appLayout;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public KolumnThread(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    @Override
    public void run() {
        while (true) {
            int caretPosition = appLayout.getMainContent().getTextPane().getCaretPosition();
            Element element = appLayout.getMainContent().getTextPane().getDocument().getDefaultRootElement();
            int kol = element.getElementIndex(caretPosition);
            int lin = caretPosition - element.getElement(kol).getStartOffset();
            appLayout.getFooter().getKolLabel().setText("Kol " + lin);
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
