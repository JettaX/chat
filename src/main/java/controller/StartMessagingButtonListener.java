package controller;

import entity.Chat;
import entity.User;
import repository.ChatRepositoryInMemory;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMessagingButtonListener implements ActionListener {
    private final User friendUser;
    private final MainView mainView;

    public StartMessagingButtonListener(User friendUser, MainView mainView) {
        this.friendUser = friendUser;
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var chat = new Chat(mainView.getUserOwner(), friendUser);
        ChatRepositoryInMemory.saveChat(chat);
        mainView.chatWindowViewInit(chat, false);
    }
}
