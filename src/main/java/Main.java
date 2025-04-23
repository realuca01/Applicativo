package test;

import java.time.LocalDate;

import model.Bacheca;
import model.ColoreSfondo;
import model.StatoToDo;
import model.TipoBacheca;
import model.ToDo;
import model.Utente;

public class MainTest {
    public static void main(String[] args) {
        Utente u1 = new Utente(1, "luca.rea", "javatiodio");

        Bacheca b1 = new Bacheca("Esami", "Object", TipoBacheca.UNIVERSITA);
        
        ToDo t1 = new ToDo("Studiare Lso", LocalDate.of(2025, 5, 10), 
                "Da pagina 30 a 40", StatoToDo.NON_COMPLETATO, 1, ColoreSfondo.ROSSO);
        
        b1.aggiungiToDo(t1);

        System.out.println("Utente: " + u1);
        System.out.println("Bacheca: " + b1);
        System.out.println("ToDo: " + t1);
    }
}