package Modelo;

/**
 * @author
 * @version 1.0
 */
public class Partido {
    private int ID;
    private String tipoPartido;
    private String hora;
    private Equipo equipoGanador;
    private Jornada jornada;

    public Partido() {
    }

    /**
     * Constructor completo de Partido
     * Para instanciar un partido con todos los atributos
     * @param ID
     * @param tipoPartido
     * @param equipoGanador Objeto Equipo(Ganador)
     * @param jornada Objeto Jornada
     */
    public Partido(int ID, String tipoPartido, Equipo equipoGanador, Jornada jornada) {
        this.ID = ID;
        this.tipoPartido = tipoPartido;
        this.equipoGanador = equipoGanador;
        this.jornada = jornada;
    }

    public Partido(int ID, String tipoPartido, String hora, Equipo equipoGanador, Jornada jornada) {
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

    public String getTipoPartido() {
        return tipoPartido;
    }

    public void setTipoPartido(String tipoPartido) {
        this.tipoPartido = tipoPartido;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
