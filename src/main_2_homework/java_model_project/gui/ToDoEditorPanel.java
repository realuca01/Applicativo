package gui;

import controller.controller;
import model.Bacheca;
import model.ColoreSfondo;
import model.StatoToDo;
import model.ToDo;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class ToDoEditorPanel extends JPanel {
    private controller controller;
    private JFrame mainFrame;
    private Bacheca bacheca;
    private ToDo toDo; // null se nuovo

    public ToDoEditorPanel(controller controller, JFrame mainFrame, Bacheca bacheca, ToDo toDo) {
        this.controller = controller;
        this.mainFrame = mainFrame;
        this.bacheca = bacheca;
        this.toDo = toDo;
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(6, 2));

        JTextField titoloField = new JTextField(toDo != null ? toDo.getTitolo() : "");
        JTextField dataField = new JTextField(toDo != null && toDo.getDataScadenza() != null ? toDo.getDataScadenza().toString() : "");
        JTextField descrizioneField = new JTextField(toDo != null ? toDo.getDescrizione() : "");

        JComboBox<StatoToDo> statoBox = new JComboBox<>(StatoToDo.values());
        if(toDo != null) statoBox.setSelectedItem(toDo.getStato());

        JComboBox<ColoreSfondo> coloreBox = new JComboBox<>(ColoreSfondo.values());
        if(toDo != null) coloreBox.setSelectedItem(toDo.getColore());

        JButton saveBtn = new JButton("Salva");
        JButton cancelBtn = new JButton("Annulla");

        add(new JLabel("Titolo:"));
        add(titoloField);
        add(new JLabel("Data Scadenza (YYYY-MM-DD):"));
        add(dataField);
        add(new JLabel("Descrizione:"));
        add(descrizioneField);
        add(new JLabel("Stato:"));
        add(statoBox);
        add(new JLabel("Colore Sfondo:"));
        add(coloreBox);
        add(cancelBtn);
        add(saveBtn);

        saveBtn.addActionListener(e -> {
            try {
                String titolo = titoloField.getText();
                LocalDate dataScadenza = LocalDate.parse(dataField.getText());
                String descrizione = descrizioneField.getText();
                StatoToDo stato = (StatoToDo) statoBox.getSelectedItem();
                ColoreSfondo colore = (ColoreSfondo) coloreBox.getSelectedItem();

                if (toDo == null) {
                    ToDo nuovo = new ToDo(titolo, dataScadenza, descrizione, stato, (int)(Math.random()*10000), colore);
                    controller.aggiungiToDo(bacheca, nuovo);
                } else {
                    // Aggiorna ToDo esistente
                    toDo.setTitolo(titolo);
                    toDo.setDataScadenza(dataScadenza);
                    toDo.setDescrizione(descrizione);
                    toDo.setStato(stato);
                    toDo.setColore(colore);
                }

                // Chiudi finestra editor e aggiorna main
                SwingUtilities.getWindowAncestor(this).dispose();
                mainFrame.setContentPane(new DashboardPanel(controller, mainFrame));
                mainFrame.revalidate();
                mainFrame.repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Errore nei dati inseriti: " + ex.getMessage());
            }
        });

        cancelBtn.addActionListener(e -> {
            SwingUtilities.getWindowAncestor(this).dispose();
        });
    }
}
