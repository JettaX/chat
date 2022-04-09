package view.components.chatWindowView.components.chatInput;

import view.utils.Colors;
import view.utils.Fonts;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextArea extends JTextArea {

    public TextArea() {
        setBackground(Colors.secondColor);
        setForeground(Colors.fontColor);
        setFont(Fonts.commonFont);
        setLineWrap(true);
        setAutoscrolls(true);
        setCaretColor(Colors.fontColor);


        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals("Write a message...")) {
                    setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
    }
}
