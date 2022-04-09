package view.commonComponents;

import view.utils.Colors;
import view.utils.Fonts;

import javax.swing.*;
import java.awt.*;

public class JTextFieldRound extends JTextField {

    public JTextFieldRound(int columns) {
        super(columns);
        setForeground(Colors.fontColor);
        setFont(Fonts.commonFont);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Colors.thirdColor);
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 15, 15);
        super.paintComponent(g);
    }

    @Override
    public void paintBorder(Graphics g) {
        g.setColor(Colors.secondColor);
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 15, 15);
    }
}
