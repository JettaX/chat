package view.components.chatWindowView.components.chatHeader;

import controller.InfoButtonListener;
import entity.User;
import view.MainView;
import view.utils.Colors;
import view.utils.Fonts;

import javax.swing.*;
import java.awt.*;

public class ChatHeader extends JPanel {
    private final User user;
    private final MainView mainView;

    public ChatHeader(User user, MainView mainView) {
        this.mainView = mainView;
        this.user = user;
        initialize();
    }

    private void initialize() {
        setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
        setBackground(Colors.secondColor);
        setPreferredSize(new Dimension(0, 60));

        var transparentButton = new TransparentButton(user.getName() + " " + user.getSurname());
        transparentButton.setFont(Fonts.commonFontBold);
        transparentButton.addActionListener(new InfoButtonListener(user, mainView));

        setLayout(new GridLayout(1,1));
        add(transparentButton);
    }
}
