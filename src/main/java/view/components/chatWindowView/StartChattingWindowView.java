package view.components.chatWindowView;

import entity.User;
import view.MainView;
import view.components.chatWindowView.components.chatHeader.ChatHeader;
import view.components.chatWindowView.components.startMessaging.StartMessaging;
import view.utils.Colors;

import javax.swing.*;
import java.awt.*;

public class StartChattingWindowView extends JPanel {
    private final User user;
    private final MainView mainview;

    public StartChattingWindowView(User user, MainView mainview) {
        this.mainview = mainview;
        this.user = user;
        initialize();
    }

    private void initialize() {
        setBackground(Colors.commonColor);
        setLayout(new BorderLayout());

        var chatHeader = new ChatHeader(user, mainview);
        var startMessaging = new StartMessaging(user, mainview);

        add(startMessaging, BorderLayout.SOUTH);
        add(chatHeader, BorderLayout.NORTH);
    }

}
