package model;

import java.time.LocalDate;

public class ToDo {
    private String titolo;
    private LocalDate scadenza;
    private String link;
    private String descrizione;
    private String immagine;
    private StatoToDo stato;
    private int posizione;
    private ColoreSfondo sfondo;

    public ToDo(String titolo, LocalDate scadenza, String descrizione, StatoToDo stato, int posizione, ColoreSfondo sfondo) {
        this.titolo = titolo;
        this.scadenza = scadenza;
        this.descrizione = descrizione;
        this.stato = stato;
        this.posizione = posizione;
        this.sfondo = sfondo;
    }

    @Override
    public String toString() {
        return "ToDo{titolo='" + titolo + "', scadenza=" + scadenza + ", stato=" + stato + ", posizione=" + posizione + ", sfondo=" + sfondo + "}";
    }
}