package view;

import controller.CheckAuthListener;
import view.commonComponents.CustomButton;
import view.commonComponents.JTextFieldRound;
import view.commonComponents.LabelCustom;
import view.utils.Colors;

import javax.swing.*;
import java.awt.*;

public class AuthView extends JPanel {
    private final MainView mainView;
    private JTextFieldRound loginField;
    private JTextFieldRound passwordField;

    public AuthView(MainView mainView) {
        this.mainView = mainView;
        initialize();
    }

    private void initialize() {
        setBackground(Colors.commonColor);
        setLayout(new GridBagLayout());

        var panel = new JPanel(new GridLayout(5, 1, 0, 10));
        panel.setBackground(Colors.commonColor);
        panel.setPreferredSize(new Dimension(300, 250));

        loginField = new JTextFieldRound(20);
        var loginLabel = new LabelCustom("Login");

        passwordField = new JTextFieldRound(20);
        var passwordLabel = new LabelCustom("Password");

        loginField.addKeyListener(new CheckAuthListener(mainView, loginField, passwordField,
                this));
        passwordField.addKeyListener(new CheckAuthListener(mainView, loginField, passwordField,
                this));

        var checkButton = new CustomButton("Sign in");
        checkButton.addActionListener(new CheckAuthListener(mainView, loginField, passwordField,
                this));

        panel.add(loginLabel);
        panel.add(loginField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(checkButton);
        add(panel);
    }

    public void removeFields() {
        loginField.setText("");
        passwordField.setText("");
    }
}
