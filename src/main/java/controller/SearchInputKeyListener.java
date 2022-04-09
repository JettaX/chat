package controller;

import entity.User;
import repository.UserRepositoryInMemory;
import view.MainView;
import view.components.chatsView.ChatsView;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class SearchInputKeyListener implements KeyListener {
    private JTextField jTextField;
    private ChatsView chatsView;
    private User user;
    private MainView mainView;

    public SearchInputKeyListener(JTextField jTextField, ChatsView chatsView, MainView mainView) {
        this.chatsView = chatsView;
        this.jTextField = jTextField;
        this.mainView = mainView;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10 && !jTextField.getText().isBlank() &&
                !jTextField.getText().equals(mainView.getUserOwner().getUserLogin())) {
            user = UserRepositoryInMemory.getUserByUserLogin(jTextField.getText());
            if (user != null) {
                chatsView.deletePanelWithPeople();
                chatsView.showResults(List.of(user));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
