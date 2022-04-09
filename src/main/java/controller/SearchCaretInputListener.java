package controller;

import view.components.chatsView.ChatsView;
import view.commonComponents.JTextFieldRound;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class SearchCaretInputListener implements CaretListener {
    private final JTextFieldRound jTextFieldRound;
    private final ChatsView chatsView;
    private boolean isErase = false;

    public SearchCaretInputListener(JTextFieldRound jTextFieldRound, ChatsView chatsView) {
        this.chatsView = chatsView;
        this.jTextFieldRound = jTextFieldRound;
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        if (!jTextFieldRound.getText().isBlank() && !isErase) {
            isErase = true;
            return;
        }
        if (jTextFieldRound.getText().isBlank() && isErase) {
            isErase = false;
            chatsView.deletePanelWithPeople();
            chatsView.addPanelWithFriends();
        }
    }
}
