package model;

import java.util.ArrayList;
import java.util.List;

public class Bacheca {
    private String titolo;
    private String descrizione;
    private TipoBacheca tipo;
    private List<ToDo> toDoList = new ArrayList<>();

    public Bacheca(String titolo, String descrizione, TipoBacheca tipo) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.tipo = tipo;
    }

    public void aggiungiToDo(ToDo todo) {
        toDoList.add(todo);
    }

    @Override
    public String toString() {
        return "Bacheca{titolo='" + titolo + "', descrizione='" + descrizione + "', tipo=" + tipo + ", toDoList=" + toDoList + "}";
    }
}