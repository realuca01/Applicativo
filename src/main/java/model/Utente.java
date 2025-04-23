package model;

public class Utente {
    private int id;
    private String login;
    private String password;

    public Utente(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() { return id; }
    public String getLogin() { return login; }
    public String getPassword() { return password; }

    public void setId(int id) { this.id = id; }
    public void setLogin(String login) { this.login = login; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Utente{id=" + id + ", login='" + login + "', password='" + password + "'}";
    }
}