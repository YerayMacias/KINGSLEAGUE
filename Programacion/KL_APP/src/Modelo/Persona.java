package Modelo;

/**
 * @author
 * @version 1.0
 */
public class Persona {
    private int ID;
    private String nombre;
    private String apellido;
    private String DNI;

    public Persona() {
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
