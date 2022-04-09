package controller;

import entity.Chat;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatButtonListener implements ActionListener {

    private final Chat chat;
    private final MainView mainView;

    public ChatButtonListener(Chat chat, MainView mainView) {
        this.chat = chat;
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainView.chatWindowViewInit(chat, false);
    }
}
