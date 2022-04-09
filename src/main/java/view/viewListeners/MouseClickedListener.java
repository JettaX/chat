package view.viewListeners;

import view.utils.Colors;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickedListener extends MouseAdapter implements ChangeListener {
    private JRadioButton button;
    private boolean over;

    public MouseClickedListener(JRadioButton button) {
        this.button = button;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        button.setBackground(Colors.buttonClickColor);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (button.isSelected()) {
            button.setBackground(Colors.markColor);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (over) {
            button.setBackground(Colors.buttonOverColor);
        } else {
            button.setBackground(Colors.buttonColor);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (!button.isSelected()) {
            button.setBackground(Colors.buttonOverColor);
        }
        over = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (!button.isSelected()) {
            button.setBackground(Colors.buttonColor);
        }
        over = false;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (!button.isSelected()) {
            button.setBackground(Colors.buttonColor);
        }
    }
}
