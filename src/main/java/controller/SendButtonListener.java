package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Chat;
import entity.Message;
import repository.ChatRepositoryInMemory;
import repository.ConnectionRepository;
import network.TCPConnection;
import network.TCPConnectionListener;
import view.MainView;
import view.components.chatWindowView.ChatWindowView;
import view.components.chatWindowView.components.chatInput.TextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SendButtonListener implements ActionListener, KeyListener, TCPConnectionListener {
    private TextArea text;
    private Chat chat;
    private ChatWindowView chatWindowView;
    private MainView mainView;

    public SendButtonListener(TextArea text, Chat chat, ChatWindowView chatWindowView, MainView mainView) {
        this.text = text;
        this.chat = chat;
        this.chatWindowView = chatWindowView;
        this.mainView = mainView;
    }

    private void sendMessage() {
        Message message = new Message(chat.getOwnerUser().getUserLogin(), chat.getFriendUser().getUserLogin(), text.getText());
        ChatRepositoryInMemory.addMessage(chat.getOwnerUser().getUserLogin(), chat.getFriendUser().getUserLogin(), message);
        text.setText("");
        chatWindowView.getChatMessageView().addMessage(message, true);

        if (ConnectionRepository.tcpConnection == null) {
            new TCPListener(mainView);
        }


        try {
            ConnectionRepository.tcpConnection.sendMessage(new ObjectMapper()
                    .writeValueAsString(message));
        } catch (JsonProcessingException e) {
            System.out.println("Can't parse message " + this.getClass());
        } catch (NullPointerException e) {
            System.out.println("connection not found " + this.getClass());
        }
    }

    private boolean isEmpty() {
        return text.getText().isBlank() || text.getText().equals("Write a message...");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isEmpty()) {
            return;
        }
        sendMessage();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.getKeyCode() == 10) {
            if (isEmpty()) {
                return;
            }
            sendMessage();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void onConnected(TCPConnection tcpConnection) {
        System.out.println("Ready");
    }

    @Override
    public void onReceiveMessage(TCPConnection tcpConnection, String value) {
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        System.out.println("Disconnect");
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println("Exception");
    }
}
