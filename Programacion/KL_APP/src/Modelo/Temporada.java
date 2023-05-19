package Modelo;

import java.time.LocalDate;

/**
 * @author
 * @version 1.0
 */
public class Temporada {
    private int ID;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    public enum tPeriodo {VER, INV}
    private tPeriodo periodo;
    public enum tEstado {ABIERTO, CERRADO}
    private tEstado estado;

    public Temporada() {
    }

    public Temporada(int ID, LocalDate fechaInicio, LocalDate fechaFin, tEstado estado, tPeriodo periodo) {
        this.ID = ID;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.periodo = periodo;
    }

    public Temporada(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public tPeriodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(tPeriodo periodo) {
        this.periodo = periodo;
    }

    public tEstado getEstado() {
        return estado;
    }

    public void setEstado(tEstado estado) {
        this.estado = estado;
    }
}