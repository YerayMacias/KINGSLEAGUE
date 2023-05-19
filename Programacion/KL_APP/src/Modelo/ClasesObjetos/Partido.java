package Modelo.ClasesObjetos;

/**
 * @author
 * @version 1.0
 */
public class Partido {
    private int ID;
    public enum tPartido {FR,PO};
    private tPartido tipoPartido;
    private String hora;
    private Equipo local;
    private Equipo visitante;
    private int golesLocal;
    private int golesVisitante;
    private Jornada jornada;

    public Partido() {
    }

    public Partido(int ID) {
        this.ID = ID;
    }

    public Partido(int ID, tPartido tipoPartido, String hora, Equipo local, Equipo visitante, int golesLocal, int golesVisitante, Jornada jornada) {
        this.ID = ID;
        this.tipoPartido = tipoPartido;
        this.hora = hora;
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
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

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }
}
