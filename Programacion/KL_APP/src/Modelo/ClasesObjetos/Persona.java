package Modelo.ClasesObjetos;

/**
 * Clase padre de Jugador, Presidente y Equipo
 * @author Explotacion de Iker
 * @version 1.0
 * @see Jugador
 * @see Presidente
 * @see Staff
 */
public class Persona {
    /**
     * ID autoincremental
     */
    private int ID;
    /**
     * Nombre de la persona
     */
    private String nombre;
    /**
     * Apellido de la persona
     */
    private String apellido;
    /**
     * DNI de la persona
     */
    private String DNI;

    /**
     * Constructor vacio
     */
    public Persona() {
    }

    /**
     * Constructor con nombre y apellido
     * @param nombre
     * @param apellido
     */
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     * Constructor solo con ID
     * @param ID
     */
    public Persona(int ID) {
        this.ID = ID;
    }

    /**
     * Constructor completo de Persona
     * Para instanciar una Persona con todos los atributos
     * @param ID
     * @param nombre
     * @param apellido
     * @param DNI
     */
    public Persona(int ID, String nombre, String apellido, String DNI) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
