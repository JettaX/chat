package view.commonComponents;

import view.utils.Colors;
import view.utils.Fonts;

import javax.swing.*;

public class LabelCustom extends JLabel {

    public LabelCustom(String text) {
        super(text);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder());
        setFont(Fonts.commonFont);
        setForeground(Colors.fontColor);
    }
}
