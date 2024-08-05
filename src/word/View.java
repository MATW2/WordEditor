package word;

import javax.swing.text.Element;
import javax.swing.text.LabelView;

public class View extends LabelView {
    public View(Element elem) {
        super(elem);
    }

    @Override
    public float getMinimumSpan(int axis) {
        if (axis == javax.swing.text.View.X_AXIS) {
            return 0;
        }
        return super.getMinimumSpan(axis);
    }

}