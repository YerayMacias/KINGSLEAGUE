package Modelo.ClasesObjetos;

/**
 * @author
 * @version 1.0
 */
public class PartidoVisitante {
    private Partido partido;
    private Equipo equipo;
    private int goles;

    public PartidoVisitante() {
    }

    /**
     * Constructor completo de PartidoVisitante
     * Para instanciar un PartidoVisitante con todos los atributos
     * @param partido
     * @param equipo
     * @param goles
     */
    public PartidoVisitante(Partido partido, Equipo equipo, int goles) {
        this.partido = partido;
        this.equipo = equipo;
        this.goles = goles;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo() {
        return equipo;
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
