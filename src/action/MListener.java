package action;

import layout.AbstractAppLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public record MListener(AbstractAppLayout appLayout) implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton button) {
            button.setForeground(new Color(166, 171, 152));
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() instanceof JComboBox<?> comboBox) {
            comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton button) {
            button.setForeground(new Color(35, 32, 38));
            button.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
        if (e.getSource() instanceof JComboBox<?> comboBox) {
            comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }
}
