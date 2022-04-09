package view.components.chatsView.components.listOfUsers;

import entity.User;
import view.commonComponents.LabelCustom;
import view.components.chatsView.components.CustomDot;
import view.utils.Colors;
import view.utils.Fonts;
import view.viewListeners.MouseClickedListener;

import javax.swing.*;
import java.awt.*;

public class UsersButton extends JRadioButton {
    private final User user;

    public UsersButton(User user) {
        this.user = user;
        initialize();
    }

    void initialize() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(Colors.buttonColor);
        setUI(new CustomDot(user.getImage().toString()));
        addMouseListener(new MouseClickedListener(this));
        addChangeListener(new MouseClickedListener(this));

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 100;

        var name = new LabelCustom(user.getName() + " " + user.getSurname());
        name.setFont(Fonts.commonFontBold);
        constraints.gridx = 0;
        constraints.insets = new Insets(10, 70, 10, 0);
        add(name, constraints);

        var userLogin = new LabelCustom(user.getUserLogin());
        userLogin.setForeground(Colors.fontExtraColor);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0, 70, 10, 10);
        add(userLogin, constraints);
    }
}
