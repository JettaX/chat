package view.dialogs;

import controller.DeleteChatButtonListener;
import entity.User;
import view.MainView;
import view.commonComponents.CustomButton;
import view.commonComponents.LabelCustom;
import view.utils.Colors;

import javax.swing.*;
import java.awt.*;

public class UserInfo extends JDialog {
    private final User user;
    private final MainView mainView;

    public UserInfo(User user, MainView mainView) {
        this.mainView = mainView;
        this.user = user;
        initialize();
        pack();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getRootPane().putClientProperty("JRootPane.titleBarBackground", Colors.thirdColor);

        setLocation(
                mainView.getLocation().x + mainView.getWidth() / 2 - getWidth() / 2,
                mainView.getLocation().y + mainView.getHeight() / 2 - getHeight() / 2);
    }

    private void initialize() {
        var commonPanel = new JPanel();
        commonPanel.setBackground(Colors.commonColor);
        commonPanel.setLayout(new GridLayout(0, 1, 0, 20));

        var infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 100;
        constraints.insets = new Insets(10, 10, 10, 10);
        infoPanel.setBackground(Colors.secondColor);


        var labelName = new LabelCustom("Name");
        constraints.gridx = 0;
        constraints.gridy = 0;
        infoPanel.add(labelName, constraints);

        var name = new LabelCustom(user.getName());
        constraints.gridx = 1;
        constraints.gridy = 0;
        infoPanel.add(name, constraints);


        var labelSurname = new LabelCustom("Surname");
        constraints.gridx = 0;
        constraints.gridy = 1;
        infoPanel.add(labelSurname, constraints);

        var surname = new LabelCustom(user.getSurname());
        constraints.gridx = 1;
        constraints.gridy = 1;
        infoPanel.add(surname, constraints);


        var labelUserName = new LabelCustom("Username");
        constraints.gridx = 0;
        constraints.gridy = 2;
        infoPanel.add(labelUserName, constraints);

        var userName = new LabelCustom(user.getUserLogin());
        constraints.gridx = 1;
        constraints.gridy = 2;
        infoPanel.add(userName, constraints);

        commonPanel.add(infoPanel);

        var controlPanel = new JPanel(new GridLayout(0, 1));
        controlPanel.setBackground(Colors.secondColor);

        var deleteButton = new CustomButton("Delete chat");
        deleteButton.setFocusPainted(false);
        deleteButton.setBorderPainted(false);
        deleteButton.addActionListener(new DeleteChatButtonListener(user, mainView));
        deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        controlPanel.add(deleteButton);
        commonPanel.add(controlPanel);


        add(commonPanel);
        setVisible(true);
        pack();
    }
}
