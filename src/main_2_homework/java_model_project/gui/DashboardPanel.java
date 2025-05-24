package gui;

import controller.controller;
import model.Bacheca;
import model.ToDo;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class DashboardPanel extends JPanel {
    private controller controller;
    private JFrame frame;

    public DashboardPanel(controller controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(1, 3, 10, 10));

        for (Bacheca b : controller.getBacheche()) {
            JPanel colonna = new JPanel();
            colonna.setLayout(new BoxLayout(colonna, BoxLayout.Y_AXIS));
            colonna.setBorder(BorderFactory.createTitledBorder(b.getTitolo()));

            for (ToDo t : b.getToDoList()) {
                JLabel lbl = new JLabel(t.getTitolo());
                if (t.getDataScadenza() != null && t.getDataScadenza().isBefore(LocalDate.now())) {
                    lbl.setForeground(Color.RED);
                }
                colonna.add(lbl);
            }

            JButton btnAdd = new JButton("Nuovo ToDo");
            btnAdd.addActionListener(e -> {
                JFrame editorFrame = new JFrame("Nuovo ToDo");
                editorFrame.setSize(400, 300);
                editorFrame.setContentPane(new ToDoEditorPanel(controller, frame, b, null));
                editorFrame.setLocationRelativeTo(frame);
                editorFrame.setVisible(true);
            });

            colonna.add(Box.createVerticalStrut(10));
            colonna.add(btnAdd);

            add(colonna);
        }
    }
}
