package model;

import java.util.ArrayList;
import java.util.List;

public class Bacheca {
    private String titolo;
    private String descrizione;
    private TipoBacheca tipo;
    private List<ToDo> toDoList;

    public Bacheca(String titolo, String descrizione, TipoBacheca tipo) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.toDoList = new ArrayList<>();
    }

    public String getTitolo() {
        return titolo;
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void aggiungiToDo(ToDo t) {
        toDoList.add(t);
    }

    public void rimuoviToDo(ToDo t) {
        toDoList.remove(t);
    }

    @Override
    public String toString() {
        return titolo;
    }
}
