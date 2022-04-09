package view.components.chatsView.components.listOfUsers;

import controller.FoundUserButtonListener;
import entity.User;
import view.MainView;
import view.utils.Colors;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListOfUsers extends JPanel {
    private final MainView mainView;
    private final List<User> list;

    public ListOfUsers(List<User> list, MainView mainView) {
        this.list = list;
        this.mainView = mainView;
        initialize();
    }

    private void initialize() {
        setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        setBackground(Colors.secondColor);

        var wrapper = new JPanel(new GridLayout(0, 1));

        addUsersOnPanel(wrapper);
        add(wrapper);
    }

    private void addUsersOnPanel(JPanel panel) {
        var group = new ButtonGroup();
        for (User foundUser : list) {
            var button = new UsersButton(foundUser);
            button.setPreferredSize(new Dimension(300, 80));
            button.addActionListener(new FoundUserButtonListener(foundUser, mainView));
            group.add(button);
            panel.add(button);
        }
    }
}
