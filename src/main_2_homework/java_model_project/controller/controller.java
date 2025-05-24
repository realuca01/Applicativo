package controller;

import model.*;

import java.time.LocalDate;
import java.util.*;

public class controller {

    private List<Utente> utenti;
    private Utente utenteLoggato;

    public controller() {
        utenti = new ArrayList<>();
        // Utente goliardico per test
        Utente u = new Utente(1, "luca", "javabello");
        utenti.add(u);
    }

    public boolean login(String username, String password) {
        for (Utente u : utenti) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                utenteLoggato = u;
                return true;
            }
        }
        return false;
    }

    public Utente getUtenteLoggato() {
        return utenteLoggato;
    }

    public List<Bacheca> getBacheche() {
        return utenteLoggato.getBacheche();
    }

    public void aggiungiBacheca(Bacheca b) {
        utenteLoggato.getBacheche().add(b);
    }

    public void aggiungiToDo(Bacheca bacheca, ToDo t) {
        bacheca.aggiungiToDo(t);
    }

    public void rimuoviToDo(Bacheca bacheca, ToDo t) {
        bacheca.rimuoviToDo(t);
    }

    public List<ToDo> getToDoScadenzaOggi() {
        List<ToDo> scaduti = new ArrayList<>();
        for (Bacheca b : getBacheche()) {
            for (ToDo t : b.getToDoList()) {
                if (t.getDataScadenza() != null && t.getDataScadenza().isEqual(LocalDate.now())) {
                    scaduti.add(t);
                }
            }
        }
        return scaduti;
    }

    public List<ToDo> cercaToDoPerTitolo(String parolaChiave) {
        List<ToDo> trovati = new ArrayList<>();
        for (Bacheca b : getBacheche()) {
            for (ToDo t : b.getToDoList()) {
                if (t.getTitolo().toLowerCase().contains(parolaChiave.toLowerCase())) {
                    trovati.add(t);
                }
            }
        }
        return trovati;
    }
}
