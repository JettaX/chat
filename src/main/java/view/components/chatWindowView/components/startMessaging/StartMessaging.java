package view.components.chatWindowView.components.startMessaging;

import controller.StartMessagingButtonListener;
import entity.User;
import view.MainView;
import view.components.chatWindowView.components.chatHeader.TransparentButton;
import view.utils.Colors;
import view.utils.Fonts;

import javax.swing.*;
import java.awt.*;

public class StartMessaging extends JPanel {
    private final User user;
    private final MainView mainview;

    public StartMessaging(User user, MainView mainview) {
        this.mainview = mainview;
        this.user = user;
        initialize();
    }

    private void initialize() {
        setBorder(BorderFactory.createMatteBorder(1,0,0,0, Color.BLACK));
        setBackground(Colors.secondColor);
        setPreferredSize(new Dimension(0, 49));

        var transparentButton = new TransparentButton("Star Messaging");
        transparentButton.setFont(Fonts.commonFontBold);
        transparentButton.addActionListener(new StartMessagingButtonListener(user, mainview));

        setLayout(new GridLayout(1,1));
        add(transparentButton);
    }
}
