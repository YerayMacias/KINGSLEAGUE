package Modelo.ClasesObjetos;

import java.time.LocalDate;

/**
 * @author
 * @version 1.0
 */
public class JugadorEquipo {
    private Jugador jugador;
    private Equipo equipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double sueldo;
    private double clausula;

    public JugadorEquipo() {
    }

    /**
     * Constructor completo de JugadorEquipo
     * Para instanciar un jugador que pertenece a un equipo con todos los atributos
     * @param jugador Objeto jugador
     * @param equipo Objeto equipo
     * @param fechaInicio Inicio del contrato
     * @param fechaFin Fin del contrato
     * @param sueldo
     * @param clausula
     * @see Jugador
     * @see Equipo
     */
    public JugadorEquipo(Jugador jugador, Equipo equipo, LocalDate fechaInicio, LocalDate fechaFin, double sueldo, double clausula) {
        this.jugador = jugador;
        this.equipo = equipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sueldo = sueldo;
        this.clausula = clausula;
    }

    public JugadorEquipo(Jugador jugador, LocalDate fechaInicio, LocalDate fechaFin, double sueldo, double clausula) {
        this.jugador = jugador;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sueldo = sueldo;
        this.clausula = clausula;
    }

    public JugadorEquipo(Jugador jugador) {
        this.jugador = jugador;
    }


    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getClausula() {
        return clausula;
    }

    public void setClausula(double clausula) {
        this.clausula = clausula;
    }
}
