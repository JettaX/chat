package view.components.chatsView.components.listOfFriends;

import controller.ChatButtonListener;
import entity.User;
import repository.ChatRepositoryInMemory;
import view.MainView;
import view.utils.Colors;

import javax.swing.*;
import java.awt.*;

public class ListOfFriends extends JPanel {
    private final MainView mainView;
    private final User user;

    public ListOfFriends(User user, MainView mainView) {
        this.user = user;
        this.mainView = mainView;
        initialize();
    }

    private void initialize() {
        setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        setBackground(Colors.secondColor);

        var wrapper = new JPanel(new GridLayout(0, 1));

        addFriendOPanel(wrapper);
        add(wrapper);
    }

    private void addFriendOPanel(JPanel panel) {
        var list = ChatRepositoryInMemory.getAllChatsByUserId(user.getUserLogin());
        var group = new ButtonGroup();
        for (entity.Chat chat : list) {
            var button = new ChatsButton(chat);
            button.setPreferredSize(new Dimension(300, 80));
            button.addActionListener(new ChatButtonListener(chat, mainView));
            group.add(button);
            panel.add(button);
        }
    }
}
