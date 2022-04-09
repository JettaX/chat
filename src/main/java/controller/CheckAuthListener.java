package controller;

import repository.UserRepositoryInMemory;
import repository.UserSecureRepositoryImpl;
import view.AuthView;
import view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CheckAuthListener implements ActionListener, KeyListener {
    private MainView mainView;
    private JTextField login;
    private JTextField password;
    private AuthView authView;

    public CheckAuthListener(MainView mainView, JTextField login, JTextField password, AuthView authView) {
        this.mainView = mainView;
        this.login = login;
        this.password = password;
        this.authView = authView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        action();
    }

    private void action() {
        if (UserSecureRepositoryImpl.checkAuth(login.getText(), password.getText())) {
            mainView.setUserOwner(UserRepositoryInMemory.getUserByUserLogin(login.getText()));
            mainView.removeAuthPanel();
            mainView.revalidate();
        } else {
            authView.removeFields();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            action();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
