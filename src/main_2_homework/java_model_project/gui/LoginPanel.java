package gui;

import controller.controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {
    private controller controller;
    private JFrame frame;

    public LoginPanel(controller controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(3, 1)); //Divido lo schermo in un unica colonna e tre righe

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginBtn = new JButton("Login");

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel(""));
        add(loginBtn);

        loginBtn.addActionListener((ActionEvent e) -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (controller.login(username, password)) {
                frame.setContentPane(new DashboardPanel(controller, frame));
                frame.revalidate();
                frame.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Login fallito, rivedere username e password");
            }
        });
    }
}
