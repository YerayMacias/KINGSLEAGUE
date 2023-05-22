package Modelo.ClasesObjetos;

import java.net.URL;

/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class Equipo {
    /**
     * ID autoincremental
     */
    private int ID;
    /**
     * Nombre del equipo
     */
    private String nombre;
    /**
     * Presupuesto del equipo
     */
    private double presupuesto;
    /**
     * Color del equipo Hexadecimal
     */
    private String color;
    /**
     * URL del logo del equipo
     */
    private URL url;

    /**
     * Constructor vacio de Equipo
     */
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
