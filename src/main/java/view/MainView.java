package view;

import controller.TCPListener;
import entity.Chat;
import entity.User;
import lombok.Getter;
import lombok.Setter;
import view.components.chatWindowView.ChatWindowView;
import view.components.chatWindowView.StartChattingWindowView;
import view.components.chatsView.ChatsView;
import view.utils.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainView extends JFrame {
    @Getter
    @Setter
    private User userOwner;
    private JPanel commonPanel;
    private ChatWindowView chatWindowView;
    private StartChattingWindowView startChattingWindowView;
    private ChatsView chatsView;
    private Chat checkChat;
    private User checkUser;
    private AuthView authView;
    // private SettingsView settingsView;


    public MainView() {
        initializeUser();

        setIconImage(new ImageIcon("src/main/resources/icon/Send.png").getImage());
        getRootPane().putClientProperty("JRootPane.titleBarBackground", Colors.thirdColor);
        getRootPane().putClientProperty("JRootPane.titleBarForeground", Colors.fontColor);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setPreferredSize(new Dimension(getWidth(), getHeight()));
                setMinimumSize(new Dimension(900, 400));
            }
        });
    }

    public void initializeUser() {
        authView = new AuthView(this);
        add(authView);
    }

    public void removeAuthPanel() {
        remove(authView);
        new TCPListener(this);
        initializer();
    }

    public void initializer() {
        if (commonPanel != null) {
            checkUser = null;
            checkChat = null;
            remove(commonPanel);
        }

        chatsView = new ChatsView(userOwner, this);
        //settingsView = new SettingsView();

        commonPanel = new JPanel(new BorderLayout());
        commonPanel.setBackground(Colors.commonColor);
        commonPanel.add(chatsView, BorderLayout.WEST);
        add(commonPanel);
    }

    public void chatWindowViewInit(Chat chat, boolean isReload) {
        if (chatWindowView != null) {
            if (!chat.equals(checkChat) || isReload) {
                commonPanel.remove(chatWindowView);
                revalidate();
            } else {
                return;
            }
        }
        if (startChattingWindowView != null) {
            commonPanel.remove(startChattingWindowView);
            revalidate();
        }
        checkChat = chat;
        chatWindowView = new ChatWindowView(chat, this);
        commonPanel.add(chatWindowView, BorderLayout.CENTER);
        pack();
    }

    public void startChattingWindowViewInit(User foundUser) {
        if (startChattingWindowView != null) {
            if (!foundUser.equals(checkUser)) {
                commonPanel.remove(startChattingWindowView);
                revalidate();
            } else {
                return;
            }
        }
        if (chatWindowView != null) {
            commonPanel.remove(chatWindowView);
            revalidate();
        }
        checkUser = foundUser;

        startChattingWindowView = new StartChattingWindowView(foundUser, this);
        commonPanel.add(startChattingWindowView, BorderLayout.CENTER);
        pack();
    }
}
