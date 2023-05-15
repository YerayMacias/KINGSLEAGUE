package Modelo.ClasesBaseDato;

import Modelo.ClasesBaseDato.Equipo;
import Modelo.ClasesBaseDato.Jornada;

/**
 * @author
 * @version 1.0
 */
public class Partido {
    private int ID;
    public enum tPartido {FR,PO};
    private tPartido tipoPartido;
    private String hora;
    private Equipo equipoGanador;
    private Jornada jornada;

    public Partido() {
    }

    public Partido(int ID) {
        this.ID = ID;
    }

    public Partido(int ID, tPartido tipoPartido, String hora, Equipo equipoGanador, Jornada jornada) {
        this.ID = ID;
        this.tipoPartido = tipoPartido;
        this.hora = hora;
        this.equipoGanador = equipoGanador;
        this.jornada = jornada;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public tPartido getTipoPartido() {
        return tipoPartido;
    }

    public void setTipoPartido(tPartido tipoPartido) {
        this.tipoPartido = tipoPartido;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Equipo getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }
}
