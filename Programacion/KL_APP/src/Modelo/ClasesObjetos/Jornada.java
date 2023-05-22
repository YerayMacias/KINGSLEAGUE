package Modelo.ClasesObjetos;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Explotacion de Iker
 * @version 1.0
 * @see Partido
 * @see Temporada
 */
public class Jornada {
    private int ID;
    private int numJornada;
    private LocalDate fecha;
    private Temporada temporada;
    private ArrayList<Partido> listaPartidos;

    /**
     * Constructor de jornada vacio
     */
    public Jornada() {
    }

    /**
     * Constructor de Jornada solo con ID
     * Para busquedas
     * @param ID
     */
    public Jornada(int ID) {
        this.ID = ID;
    }

    /**
     * Constructor completo de Jornada menos los partidos
     * Para instanciar una jornada con todos los atributos menos la lista de partidos
     * @param ID
     * @param numJornada
     * @param fecha
     * @param temporada Objeto Temporada
     */
    public Jornada(int ID, int numJornada, LocalDate fecha, Temporada temporada) {
        this.ID = ID;
        this.numJornada = numJornada;
        this.fecha = fecha;
        this.temporada = temporada;
    }

    /**
     * Constructor completo de Jornada
     * Para instanciar una jornada con todos los atributos
     * @param ID
     * @param numJornada
     * @param fecha
     * @param temporada
     * @param listaPartidos
     */
    public Jornada(int ID, int numJornada, LocalDate fecha, Temporada temporada, ArrayList<Partido> listaPartidos) {
        this.ID = ID;
        this.numJornada = numJornada;
        this.fecha = fecha;
        this.temporada = temporada;
        this.listaPartidos = listaPartidos;
    }

    /**
     * Constructor de jornada con numero de jornada y fecha
     * @param numJornada
     * @param fecha
     */
    public Jornada(int numJornada, LocalDate fecha) {
        this.numJornada = numJornada;
        this.fecha = fecha;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public ArrayList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(ArrayList<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }
}
