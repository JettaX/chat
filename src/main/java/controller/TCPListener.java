package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Message;
import lombok.Setter;
import repository.ChatRepositoryInMemory;
import repository.ConnectionRepository;
import network.TCPConnection;
import network.TCPConnectionListener;
import view.MainView;
import view.components.chatWindowView.components.chatMessageView.ChatMessageView;

import java.io.IOException;

public class TCPListener implements TCPConnectionListener {
    @Setter
    private static ChatMessageView chatMessageView;
    private MainView mainView;

    public TCPListener(MainView mainView) {
        this.mainView = mainView;
        if (ConnectionRepository.tcpConnection != null) {
            ConnectionRepository.tcpConnection.disconnect();
        }
        try {
            ConnectionRepository.tcpConnection = new TCPConnection(this, "localhost", 8188);
        } catch (IOException e) {
            System.out.println("server not found " + this.getClass());
        }
    }

    @Override
    public void onConnected(TCPConnection tcpConnection) {
        System.out.println("Ready");
    }

    @Override
    public void onReceiveMessage(TCPConnection tcpConnection, String value) {
        Message message = null;
        try {
            message = new ObjectMapper().readerFor(Message.class).readValue(value);
        } catch (JsonProcessingException e) {
            System.out.println("Can't parse message " + this.getClass());
        }
        if (mainView.getUserOwner().getUserLogin().equals(message.getUserNameTo())) {
            ChatRepositoryInMemory.addMessage(message.getUserNameFrom(), message.getUserNameTo(), message);
            if (chatMessageView != null && chatMessageView.getChat().getFriendUser().getUserLogin().equals(message.getUserNameFrom())) {
                chatMessageView.addMessage(message, false);
                chatMessageView.revalidate();
            }
        }
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        System.out.println("Disconnect");
        tcpConnection.disconnect();
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println("Exception");
        new TCPListener(mainView);
    }
}
