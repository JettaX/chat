package view.components.chatWindowView.components.chatInput;

import controller.SendButtonListener;
import entity.Chat;
import view.MainView;
import view.commonComponents.CustomButton;
import view.commonComponents.ScrollPane;
import view.components.chatWindowView.ChatWindowView;
import view.utils.Colors;
import view.utils.ScaleImages;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ChatInput extends JPanel {
    private final Chat chat;
    private final MainView mainView;
    private ChatWindowView chatWindowView;

    public ChatInput(Chat chat, MainView mainView, ChatWindowView chatWindowView) {
        this.chat = chat;
        this.mainView = mainView;
        this.chatWindowView = chatWindowView;
        initialize();
    }

    private void initialize() {
        setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        setBackground(Colors.secondColor);
        setPreferredSize(new Dimension(0, 50));

        var text = new TextArea();
        text.setToolTipText("Write a message...");
        text.setText("Write a message...");
        text.setMargin(new Insets(15, 10, 10, 0));
        text.addKeyListener(new SendButtonListener(text, chat, chatWindowView, mainView));

        var button = new CustomButton("");
        try {
            button.setIcon(new ScaleImages().getNewImage("src/main/resources/icon/Send.png", 30, 30));
        } catch (IOException e) {
            e.printStackTrace();
        }
        button.setPreferredSize(new Dimension(50, 45));
        button.addActionListener(new SendButtonListener(text, chat, chatWindowView, mainView));

        JScrollPane scroll = new ScrollPane(text);
        scroll.getVerticalScrollBar().setUnitIncrement(2);

        setLayout(new BorderLayout());
        add(button, BorderLayout.EAST);
        add(scroll, BorderLayout.CENTER);
    }
}
