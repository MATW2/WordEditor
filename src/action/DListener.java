package action;

import Interfaces.IClear;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public record DListener(IClear clear) implements DocumentListener {
    @Override
    public void insertUpdate(DocumentEvent e) {
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        SwingUtilities.invokeLater(clear::clear);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
}



