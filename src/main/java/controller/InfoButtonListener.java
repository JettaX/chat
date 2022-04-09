package controller;

import entity.User;
import view.MainView;
import view.dialogs.UserInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoButtonListener implements ActionListener {
    private final User user;
    private final MainView mainView;

    public InfoButtonListener(User user, MainView mainView) {
        this.mainView = mainView;
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new UserInfo(user, mainView);
    }
}
