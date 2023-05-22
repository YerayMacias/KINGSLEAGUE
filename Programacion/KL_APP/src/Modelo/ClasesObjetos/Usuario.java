package Modelo.ClasesObjetos;

/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class Usuario {
    /**
     * ID autoincremental
     */
    private int ID;
    /**
     * Nombre de usuario
     */
    private String username;
    /**
     * Correo electronico
     */
    private String email;
    /**
     * Contraseña
     */
    private String password;
    /**
     * Tipo de usuario(admin o no)
     */
    private tUsuario admin;

    public enum tUsuario {S, N};

    /**
     * Constructor vacio de usuario
     */
    public Usuario() {
    }

    /**
     * Constructor solo con el username de Usuario
     * @param username
     */
    public Usuario(String username) {
        this.username = username;
    }

    /**
     * Constrctor completo, menos el id, de usuario
     * @param username
     * @param email
     * @param password
     * @param admin
     */
    public Usuario(String username, String email, String password, tUsuario admin) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    /**
     * Constructor con username y password de Usuario
     * Para el Login
     * @param username
     * @param password
     */
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
    public Usuario(int ID, String username, String email, String password, tUsuario admin) {
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

    public tUsuario getAdmin() {
        return admin;
    }

    public void setAdmin(tUsuario admin) {
        this.admin = admin;
    }

}
