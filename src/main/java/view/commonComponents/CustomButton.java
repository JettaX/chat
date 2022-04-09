package view.commonComponents;

import view.utils.Colors;
import view.utils.Fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButton extends JButton {

    private boolean over;

    public CustomButton(String label) {
        super(label);
        initialize();
    }

    void initialize() {
        setFocusPainted(false);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createEmptyBorder());
        setForeground(Colors.fontColor);
        setFont(Fonts.commonFont);
        setBackground(Colors.buttonColor);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(Colors.buttonClickColor);
                setContentAreaFilled(false);
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                if (over) {
                    setBackground(Colors.buttonOverColor);
                    setContentAreaFilled(true);
                } else {
                    setBackground(Colors.buttonColor);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setContentAreaFilled(true);
                setBackground(Colors.buttonOverColor);
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setContentAreaFilled(true);
                setBackground(Colors.buttonColor);
                over = false;
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


}
