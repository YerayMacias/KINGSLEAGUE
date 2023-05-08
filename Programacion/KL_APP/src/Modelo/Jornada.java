package Modelo;

import java.time.LocalDate;

public class Jornada {
    private int ID;
    private int numJornada;
    private LocalDate fecha;
    private Temporada temporada;

    public Jornada() {
    }

    /**
     *
     * Constructor completo de Jornada
     * Para instanciar una jornada con todos los atributos
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
}
