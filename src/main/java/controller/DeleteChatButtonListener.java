package controller;

import entity.User;
import repository.ChatRepositoryInMemory;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteChatButtonListener implements ActionListener {
    private final User user;
    private final MainView mainView;

    public DeleteChatButtonListener(User user, MainView mainView) {
        this.mainView = mainView;
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ChatRepositoryInMemory.deleteChatByUserIdAndFriendId(mainView.getUserOwner().getUserLogin(), user.getUserLogin())) {
            mainView.initializer();
            mainView.revalidate();
        }
    }
}
