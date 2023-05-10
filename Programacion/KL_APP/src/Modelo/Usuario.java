package Modelo;

/**
 * @author
 * @version 1.0
 */
public class Usuario {
    private int ID;
    private String username;
    private String email;
    private String password;
    private String admin;

    public Usuario() {
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Constructor completo de Usuario
     * Para instanciar un Usuario con todos los atributos
     * @param ID
     * @param username
     * @param email
     * @param password
     * @param admin S o N
     */
    public Usuario(int ID, String username, String email, String password, String admin) {
        this.ID = ID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.admin = admin;
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

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
