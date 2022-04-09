package view.components.chatWindowView.components.chatHeader;

import view.utils.Colors;
import view.utils.Fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class TransparentButton extends JButton {

    public TransparentButton(String label) {
        super(label);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setBackground(Colors.secondColor);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(Colors.secondColor);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                setBackground(Colors.secondColor);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                setBackground(Colors.secondColor);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                setBackground(Colors.secondColor);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(Colors.secondColor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(Colors.secondColor);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Colors.secondColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Colors.secondColor);
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBorder(BorderFactory.createEmptyBorder());
        setForeground(Colors.fontColor);
        setFont(Fonts.commonFont);
    }
}
