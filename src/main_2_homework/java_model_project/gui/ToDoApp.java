package gui;

import controller.controller;

import javax.swing.*;

public class ToDoApp extends JFrame {
    private controller controller;

    public ToDoApp() {
        controller = new controller();
        setSize(1280, 800); //Scelta della grandezza della finstra principale
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("ToDo");

        setContentPane(new LoginPanel(controller, this));
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}
