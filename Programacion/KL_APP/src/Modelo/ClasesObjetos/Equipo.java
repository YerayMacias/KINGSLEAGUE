package Modelo.ClasesObjetos;

import java.net.URL;

/**
 * @author
 * @version 1.0
 */
public class Equipo {
    private int ID;
    private String nombre;
    private double presupuesto;
    private String color;
    private URL url;

    public Equipo() {
    }

    /**
     * Constructor parcial de Equipo
     * Para instanciar un equipo con ID, nombre y presupuesto
     * @param ID
     * @param nombre
     * @param presupuesto
     */
    public Equipo(int ID, String nombre, double presupuesto) {
        this.ID = ID;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }

    /**
     * Constructor completo de Equipo
     * Para instanciar un equipo con todos los atributos
     * @param ID
     * @param nombre
     * @param presupuesto
     * @param color
     * @param url
     */
    public Equipo(int ID, String nombre, double presupuesto, String color, URL url) {
        this.ID = ID;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.color = color;
        this.url = url;
    }

    /**
     * Contructor solo de id
     * Para selects
     * @param ID
     */
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
