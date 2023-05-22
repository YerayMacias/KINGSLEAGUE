package Modelo.ClasesObjetos;

/**
 * @author Explotacion de Iker
 * @version 1.0
 * @see Equipo
 * @see Jornada
 */
public class Partido {
    /**
     * ID autoincremental
     */
    private int ID;
    public enum tPartido {FR,PO};
    /**
     * Tipo de partido(Fase regular, playoff)
     */
    private tPartido tipoPartido;
    /**
     * Hora del partido
     */
    private String hora;
    /**
     * Equipo local(objeto)
     */
    private Equipo local;
    /**
     * Equipo Visitante(objeto)
     */
    private Equipo visitante;
    /**
     * Goles del local
     */
    private int golesLocal;
    /**
     * Goles del visitante
     */
    private int golesVisitante;
    /**
     * Objeto Jornada
     */
    private Jornada jornada;

    /**
     * Constructor vacio de Partido
     */
    public Partido() {
    }

    /**
     * Constructor solo con ID de partido
     * Para busquedas
     * @param ID
     */
    public Partido(int ID) {
        this.ID = ID;
    }

    /**
     * Constructor completo de Partido
     * Para instanciar un partidoi con todos sus atributos
     * @param ID
     * @param tipoPartido
     * @param hora
     * @param local
     * @param visitante
     * @param golesLocal
     * @param golesVisitante
     * @param jornada
     */
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
