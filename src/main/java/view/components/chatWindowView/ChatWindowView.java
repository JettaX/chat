package view.components.chatWindowView;

import entity.Chat;
import lombok.Getter;
import view.MainView;
import view.components.chatWindowView.components.chatHeader.ChatHeader;
import view.components.chatWindowView.components.chatInput.ChatInput;
import view.components.chatWindowView.components.chatMessageView.ChatMessageView;
import view.utils.Colors;

import javax.swing.*;
import java.awt.*;

public class ChatWindowView extends JPanel {

    private final Chat chat;
    private final MainView mainView;
    private ChatHeader chatHeader;
    private ChatInput chatInput;
    @Getter
    private ChatMessageView chatMessageView;

    public ChatWindowView(Chat chat, MainView mainView) {
        this.chat = chat;
        this.mainView = mainView;

        initialize();
    }

    private void initialize() {
        setBackground(Colors.commonColor);
        setLayout(new BorderLayout());

        chatHeader = new ChatHeader(chat.getFriendUser(), mainView);
        chatInput = new ChatInput(chat, mainView, this);
        chatMessageView = new ChatMessageView(chat);

        add(chatMessageView, BorderLayout.CENTER);
        add(chatInput, BorderLayout.SOUTH);
        add(chatHeader, BorderLayout.NORTH);
    }
}
