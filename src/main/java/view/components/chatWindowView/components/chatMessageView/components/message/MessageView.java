package view.components.chatWindowView.components.chatMessageView.components.message;

import entity.Message;
import view.commonComponents.LabelCustom;
import view.components.chatWindowView.components.chatMessageView.ChatMessageView;
import view.utils.Colors;
import view.utils.Fonts;

import javax.swing.*;
import java.awt.*;

public class MessageView extends JPanel {
    private Message message;
    private boolean isOwner;
    private ChatMessageView messageView;

    public MessageView(Message message, boolean isOwner, ChatMessageView messageView) {
        this.message = message;
        this.isOwner = isOwner;
        this.messageView = messageView;

        initialize();
    }

    private void initialize() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        var messageText = new JTextArea(message.getText());
        var messageLength = getFontMetrics(Fonts.commonFont).stringWidth(message.getText());
        messageText.setSize(new Dimension(Math.min(messageLength + 10, 470), 1));
        messageText.setFont(Fonts.commonFont);
        messageText.setForeground(Colors.fontColor);
        messageText.setOpaque(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setBorder(BorderFactory.createEmptyBorder());
        messageText.setEditable(false);
        messageText.setDragEnabled(true);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        add(messageText, constraints);

        var dataLabel =
                new LabelCustom(message.getTime().getHour() + ":" + message.getTime().getMinute());
        dataLabel.setForeground(Colors.fontExtraColor);

        constraints.gridx = 1;
        constraints.gridy = messageLength > 600 ? 1 : 0;
        constraints.insets = new Insets(messageLength > 600 ? 0 : 10, messageLength > 600 ? 0 : 10, 10, 10);
        add(dataLabel, constraints);

    }

    @Override
    protected void paintComponent(Graphics g) {
        if (isOwner) {
            g.setColor(Colors.markColor);
        } else {
            g.setColor(Colors.secondColor);
        }
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 15, 15);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        if (isOwner) {
            g.setColor(Colors.markColor);
        } else {
            g.setColor(Colors.secondColor);
        }
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 15, 15);
    }
}
