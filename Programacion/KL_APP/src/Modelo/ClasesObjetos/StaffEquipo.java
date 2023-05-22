package Modelo.ClasesObjetos;

import java.time.LocalDate;

/**
 * @author
 * @version 1.0
 */
public class StaffEquipo {
    private Staff staff;
    private Equipo equipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double sueldo;

    public StaffEquipo() {
    }

    /**
     * Constructor completo de StaffEquipo
     * Para instanciar un StaffEquipo con todos los atributos
     * @param staff Objeto Jugador
     * @param equipo Objeto Equipo
     * @param fechaInicio Inicio del contrato
     * @param fechaFin Fin del contrato
     * @param sueldo
     */
    public StaffEquipo(Staff staff, Equipo equipo, LocalDate fechaInicio, LocalDate fechaFin, double sueldo) {
        this.staff = staff;
        this.equipo = equipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sueldo = sueldo;
    }

    public StaffEquipo(Staff staff, LocalDate fechaInicio, LocalDate fechaFin, double sueldo) {
        this.staff = staff;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sueldo = sueldo;
    }

    public StaffEquipo(Staff staff) {
        this.staff = staff;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
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
