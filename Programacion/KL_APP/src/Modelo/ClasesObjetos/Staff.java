package Modelo.ClasesObjetos;

/**
 * @author
 * @version 1.0
 */
public class Staff extends Persona{
    public enum tROl{ENTRENADOR1, ENTRENADOR2, ANALISTA}
    private tROl rol;

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
    public Staff(int ID, String nombre, String apellido, String DNI, tROl rol) {
        super(ID, nombre, apellido, DNI);
        this.rol = rol;
    }

    public Staff(int ID) {
        super(ID);
    }

    public Staff(tROl rol) {
        this.rol = rol;
    }

    public tROl getRol() {
        return rol;
    }

    public void setRol(tROl rol) {
        this.rol = rol;
    }
}
