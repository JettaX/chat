package view.components.chatsView.components.searchPeople;

import controller.SearchCaretInputListener;
import controller.SearchInputKeyListener;
import view.MainView;
import view.commonComponents.JTextFieldRound;
import view.components.chatsView.ChatsView;
import view.utils.Colors;
import view.utils.Fonts;

import javax.swing.*;
import java.awt.*;

public class SearchPeople extends JPanel {
    private JTextFieldRound jTextField;
    private ChatsView chatsView;
    private MainView mainView;

    public SearchPeople(ChatsView chatsView, MainView mainView) {
        this.chatsView = chatsView;
        this.mainView = mainView;
        initialize();
    }

    private void initialize() {
        setBackground(Colors.secondColor);
        var messageLength = 300 / getFontMetrics(Fonts.commonFont).getMaxAscent();

        jTextField = new JTextFieldRound(messageLength);
        jTextField.setOpaque(false);
        jTextField.setBackground(Colors.thirdColor);
        jTextField.setBorder(BorderFactory.createLineBorder(Colors.secondColor, 5));
        jTextField.setCaretColor(Colors.fontColor);
        jTextField.setPreferredSize(new Dimension(getWidth(), 40));
        jTextField.addKeyListener(new SearchInputKeyListener(jTextField, chatsView, mainView));
        jTextField.addCaretListener(new SearchCaretInputListener(jTextField, chatsView));

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        add(jTextField);
    }
}
