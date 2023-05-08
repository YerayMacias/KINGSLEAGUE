package Modelo;

public class Usuario {
    private int ID;
    private String username;
    private String email;
    private String password;
    private String tipoUsuario;

    public Usuario() {
    }

    public Usuario(int ID, String username, String email, String password, String tipoUsuario) {
        this.ID = ID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
