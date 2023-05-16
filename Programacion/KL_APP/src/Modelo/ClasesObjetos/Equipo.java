package Modelo.ClasesObjetos;

/**
 * @author
 * @version 1.0
 */
public class    Equipo {
    private int ID;
    private String nombre;
    private double presupuesto;

    public Equipo() {
    }

    /**
     * Constructor completo de Equipo
     * Para instanciar un equipo con todos los atributos
     * @param ID
     * @param nombre
     * @param presupuesto
     */
    public Equipo(int ID, String nombre, double presupuesto) {
        this.ID = ID;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }

    public Equipo(int ID) {
        this.ID = ID;
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

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
}
