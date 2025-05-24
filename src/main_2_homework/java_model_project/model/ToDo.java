package model;

import java.time.LocalDate;

public class ToDo {
    private String titolo;
    private LocalDate dataScadenza;
    private String descrizione;
    private StatoToDo stato;
    private int id;
    private ColoreSfondo colore;

    public ToDo(String titolo, LocalDate dataScadenza, String descrizione,
                StatoToDo stato, int id, ColoreSfondo colore) {
        this.titolo = titolo;
        this.dataScadenza = dataScadenza;
        this.descrizione = descrizione;
        this.stato = stato;
        this.id = id;
        this.colore = colore;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public boolean isScaduto() {
        return dataScadenza != null && dataScadenza.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return titolo;
    }

    // Getter
    public String getDescrizione() {
        return descrizione;
    }

    public StatoToDo getStato() {
        return stato;
    }

    public ColoreSfondo getColore() {
        return colore;
    }

    // Setter
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setStato(StatoToDo stato) {
        this.stato = stato;
    }

    public void setColore(ColoreSfondo colore) {
        this.colore = colore;
    }

}
