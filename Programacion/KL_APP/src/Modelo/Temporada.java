package Modelo;

import java.time.LocalDate;

public class Temporada {
    private int ID;
    private LocalDate fechaInicio;
    private LocalDate fechaSalida;
    private String periodo;
    private String estado;

    public Temporada() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Temporada(int ID, LocalDate fechaInicio, LocalDate fechaSalida, String periodo, String estado) {
        this.ID = ID;
        this.fechaInicio = fechaInicio;
        this.fechaSalida = fechaSalida;
        this.periodo = periodo;
        this.estado = estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
