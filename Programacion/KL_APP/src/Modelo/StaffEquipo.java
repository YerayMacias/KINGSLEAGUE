package Modelo;

import java.time.LocalDate;

public class StaffEquipo {
    private Staff jugador;
    private Equipo equipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double sueldo;

    public StaffEquipo() {
    }

    public StaffEquipo(Staff jugador, Equipo equipo, LocalDate fechaInicio, LocalDate fechaFin, double sueldo) {
        this.jugador = jugador;
        this.equipo = equipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sueldo = sueldo;
    }

    public Staff getJugador() {
        return jugador;
    }

    public void setJugador(Staff jugador) {
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
}
