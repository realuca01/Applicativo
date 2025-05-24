package model;
import java.util.List;
import java.util.ArrayList;


public class Utente {
    private int id;
    private String username;
    private String password;
    private List<Bacheca> bacheche;

    public Utente(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.bacheche = new ArrayList<>();

        // Bacheche predefinite
        bacheche.add(new Bacheca("Università", "Bacheca universitaria", TipoBacheca.UNIVERSITA));
        bacheche.add(new Bacheca("Lavoro", "Bacheca lavorativa", TipoBacheca.LAVORO));
        bacheche.add(new Bacheca("Tempo Libero", "Bacheca per il tempo libero", TipoBacheca.TEMPO_LIBERO));
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Bacheca> getBacheche() {
        return bacheche;
    }

    public void aggiungiBacheca(Bacheca b) {
        bacheche.add(b);
    }

    @Override
    public String toString() {
        return username;
    }
}
