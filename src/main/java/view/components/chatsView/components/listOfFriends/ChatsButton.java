package view.components.chatsView.components.listOfFriends;

import entity.Chat;
import entity.Message;
import view.commonComponents.LabelCustom;
import view.components.chatsView.components.CustomDot;
import view.utils.Colors;
import view.utils.Fonts;
import view.viewListeners.MouseClickedListener;

import javax.swing.*;
import java.awt.*;

public class ChatsButton extends JRadioButton {
    private boolean over;
    private final Chat chat;
    private Message lastMessage;

    public ChatsButton(Chat chat) {
        this.chat = chat;
        initialize();
    }

    void initialize() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(Colors.buttonColor);
        setUI(new CustomDot(chat.getFriendUser().getImage().toString()));
        addMouseListener(new MouseClickedListener(this));
        addChangeListener(new MouseClickedListener(this));

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 100;

        var name = new LabelCustom(chat.getFriendUser().getName() + " " + chat.getFriendUser().getSurname());
        name.setFont(Fonts.commonFontBold);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 70, 10, 0);
        add(name, constraints);

        if (!chat.getMessages().isEmpty()) {

            lastMessage = chat.getMessages().get(chat.getMessages().size() - 1);

            var lastMessageTimeLabel =
                    new LabelCustom(lastMessage.getTime().getHour() + ":" + lastMessage.getTime().getMinute());
            lastMessageTimeLabel.setForeground(Colors.fontExtraColor);
            lastMessageTimeLabel.setHorizontalAlignment(RIGHT);
            constraints.gridx = 1;
            constraints.gridy = 0;
            constraints.weightx = 0;
            constraints.insets = new Insets(0, 10, 0, 10);
            add(lastMessageTimeLabel, constraints);

            var lastMessageLabel = new LabelCustom(lastMessage.getText());
            lastMessageLabel.setForeground(Colors.fontExtraColor);
            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.gridwidth = 2;
            constraints.insets = new Insets(0, 70, 10, 10);
            add(lastMessageLabel, constraints);
        }
    }
}
