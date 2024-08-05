package action;

import Interfaces.ISelectAtribute;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public record CListener(ISelectAtribute selectAtribute) implements CaretListener {
    @Override
    public void caretUpdate(CaretEvent e) {
        selectAtribute.selectAtribute();
    }
}
