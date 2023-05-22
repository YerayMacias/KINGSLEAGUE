package Modelo.ClasesObjetos;

import java.time.LocalDate;

/**
 * @author Explotacion de Iker
 * @version 1.0
 * @see Jugador
 * @see Equipo
 */
public class JugadorEquipo {
    /**
     * Objeto Jugador
     */
    private Jugador jugador;
    /**
     * Objeto Equipo
     */
    private Equipo equipo;
    /**
     * Fecha de inicio de contrato
     */
    private LocalDate fechaInicio;
    /**
     * Fecha de finalizacion de contrato
     */
    private LocalDate fechaFin;
    /**
     * Salario
     */
    private double sueldo;
    /**
     * Clausula de compra
     */
    private double clausula;

    /**
     * Constructor vacio de JugadorEquipo
     */
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
     */
    public JugadorEquipo(Jugador jugador, Equipo equipo, LocalDate fechaInicio, LocalDate fechaFin, double sueldo, double clausula) {
        this.jugador = jugador;
        this.equipo = equipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sueldo = sueldo;
        this.clausula = clausula;
    }

    /**
     * Constructor de JugadorEquipo sin equipo
     * @param jugador
     * @param fechaInicio
     * @param fechaFin
     * @param sueldo
     * @param clausula
     */
    public JugadorEquipo(Jugador jugador, LocalDate fechaInicio, LocalDate fechaFin, double sueldo, double clausula) {
        this.jugador = jugador;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sueldo = sueldo;
        this.clausula = clausula;
    }

    /**
     * Constructor de JugadorEquipo solo con el jugador
     * @param jugador
     */
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
