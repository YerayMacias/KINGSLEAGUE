package Modelo.ClasesObjetos;

import java.time.LocalDate;

/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class Temporada {
    /**
     * ID autoincremental
     */
    private int ID;
    /**
     * Fecha de inicio de la Temporada
     */
    private LocalDate fechaInicio;
    /**
     * Fecha de finalizacion de la temporada
     */
    private LocalDate fechaFin;
    public enum tPeriodo {VER, INV}
    /**
     * Periodo de la temporada(invierno o verano)
     */
    private tPeriodo periodo;
    public enum tEstado {ABIERTO, CERRADO}

    /**
     * Estado de la inscription(abierta o cerrada) de la temporada
     */
    private tEstado estado;

    /**
     * Constructor vacio de Temporada
     */
    public Temporada() {
    }

    /**
     * Constructor completo de temporada
     * Para instanciar una Temporada con todos sus atributos
     * @param ID
     * @param fechaInicio
     * @param fechaFin
     * @param estado
     * @param periodo
     */
    public Temporada(int ID, LocalDate fechaInicio, LocalDate fechaFin, tEstado estado, tPeriodo periodo) {
        this.ID = ID;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.periodo = periodo;
    }

    /**
     * Constructor con fechaInicio y fechaFin de Temporada
     * Para busquedas
     * @param fechaInicio
     * @param fechaFin
     */
    public Temporada(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Constructor solo con el ID de Temporada
     * Para busquedas
     * @param ID
     */
    public Temporada(int ID) {
        this.ID = ID;
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