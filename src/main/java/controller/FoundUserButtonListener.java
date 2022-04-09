package controller;

import entity.User;
import repository.ChatRepositoryInMemory;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoundUserButtonListener implements ActionListener {
    private final User friendUser;
    private final MainView mainView;

    public FoundUserButtonListener(User friendUser, MainView mainView) {
        this.mainView = mainView;
        this.friendUser = friendUser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var chat = ChatRepositoryInMemory.getChatByOwnerIdAndFriendId(mainView.getUserOwner().getUserLogin(),
                friendUser.getUserLogin());
        if (chat != null) {
            mainView.chatWindowViewInit(chat, false);
        } else {
            mainView.startChattingWindowViewInit(friendUser);
        }
    }
}
