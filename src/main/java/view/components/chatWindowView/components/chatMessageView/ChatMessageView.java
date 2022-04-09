package view.components.chatWindowView.components.chatMessageView;

import controller.TCPListener;
import entity.Chat;
import entity.Message;
import lombok.Getter;
import view.commonComponents.ScrollPane;
import view.components.chatWindowView.components.chatMessageView.components.message.MessageView;
import view.utils.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ChatMessageView extends JPanel {
    @Getter
    private final Chat chat;
    private ScrollPane pane;
    private JPanel panel;
    private int lastIndex = -1;

    public ChatMessageView(Chat chat) {
        this.chat = chat;
        initialize();
        TCPListener.setChatMessageView(this);

        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                pane.getVerticalScrollBar().setValue(pane.getVerticalScrollBar().getMaximum());
            }
        });
    }

    private void initialize() {
        setBackground(Colors.commonColor);
        setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Colors.commonColor);

        addMessages();

        pane = new ScrollPane(panel);
        pane.setBackground(Colors.commonColor);
        pane.getVerticalScrollBar().setUnitIncrement(10);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(pane);

    }

    private void createMessage(Message textMessage, boolean isOwner, int index) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100;

        var panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        var message = new MessageView(textMessage, isOwner, this);
        message.setOpaque(false);
        panel.add(message, isOwner ? BorderLayout.EAST : BorderLayout.WEST);
        constraints.gridy = index;
        constraints.insets = new Insets(5, 5, 5, 5);
        this.panel.add(panel, constraints);
        lastIndex = index;
    }

    private void addMessages() {
        for (int i = 0; i < chat.getMessages().size(); i++) {
            boolean isOwner = chat.getOwnerUser().getUserLogin().equals(chat.getMessages().get(i).getUserNameFrom());
            createMessage(chat.getMessages().get(i), isOwner, i);
        }
    }

    public void addMessage(Message textMessage, boolean isOwner) {
        createMessage(textMessage, isOwner, lastIndex + 1);
    }
}
