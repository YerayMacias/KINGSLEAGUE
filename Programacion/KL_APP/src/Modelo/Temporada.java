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
    private String periodo;
    private String estado;

    public Temporada() {
    }

    /**
     * Constructor completo de Temporada
     * Para instanciar un Temporada con todos los atributos
     * @param ID
     * @param fechaInicio
     * @param fechaFin
     * @param periodo INV(invierno) o VER(verano)
     * @param estado Abierto o Cerrado
     */
    public Temporada(int ID, LocalDate fechaInicio, LocalDate fechaFin, String periodo, String estado) {
        this.ID = ID;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.periodo = periodo;
        this.estado = estado;
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
