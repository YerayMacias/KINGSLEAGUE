package Modelo;

/**
 * @author
 * @version 1.0
 */
public class PartidoLocal {
    private Partido partido;
    private Equipo equipo;
    private int goles;

    public PartidoLocal() {
    }

    /**
     * Constructor completo de PartidoLocal
     * Para instanciar un PartidoLocal con todos los atributos
     * @param partido
     * @param equipo
     * @param goles
     */
    public PartidoLocal(Partido partido, Equipo equipo, int goles) {
        this.partido = partido;
        this.equipo = equipo;
        this.goles = goles;
    }

    public Partido getPartido() {
        return partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
}
