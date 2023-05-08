package Modelo;

/**
 * @author
 * @version 1.0
 */
public class Staff extends Persona{
    private String rol;

    public Staff() {
    }

    /**
     * Constructor completo de Staff
     * Para instanciar un Staff con todos los atributos
     * @param ID
     * @param nombre
     * @param apellido
     * @param DNI
     * @param rol
     */
    public Staff(int ID, String nombre, String apellido, String DNI, String rol) {
        super(ID, nombre, apellido, DNI);
        this.rol = rol;
    }

    public Staff(String rol) {
        this.rol = rol;
    }
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
