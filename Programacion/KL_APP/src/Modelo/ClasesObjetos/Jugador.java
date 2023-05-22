package Modelo.ClasesObjetos;

/**
 * @author
 * @version 1.0
 * @see Persona
 */
public class Jugador extends Persona {
    public enum tPosicion{DC, DF, P, MC}
    private tPosicion posicion;
    public enum tTipoJugador{HABITUAL,WILDCARD}
    private tTipoJugador tipoJugador;

    /**
     * Constructor sin ID y apellido de jugador
     * @param nombre
     * @param apellido
     * @param posicion
     * @param tipoJugador
     */
    public Jugador(String nombre, String apellido, tPosicion posicion, tTipoJugador tipoJugador) {
        super(nombre, apellido);
        this.posicion = posicion;
        this.tipoJugador = tipoJugador;
    }

    /**
     * Constructor vacio de Jugador
     */
    public Jugador() {
    }

    /**
     * Constructor solo con ID de jugador
     * Para busquedas
     * @param ID
     */
    public Jugador(int ID) {
        super(ID);
    }

    /**
     * Constructor completo de jugador
     * Para instanciar un jugador con todos sus atributos
     * @param ID
     * @param nombre
     * @param apellido
     * @param DNI
     * @param posicion
     * @param tipoJugador
     */
    public Jugador(int ID, String nombre, String apellido, String DNI, tPosicion posicion, tTipoJugador tipoJugador) {
        super(ID, nombre, apellido, DNI);
        this.posicion = posicion;
        this.tipoJugador = tipoJugador;
    }

    public tPosicion getPosicion() {
        return posicion;
    }

    public void setPosicion(tPosicion posicion) {
        this.posicion = posicion;
    }

    public tTipoJugador getTipoJugador() {
        return tipoJugador;
    }

    public void setTipoJugador(tTipoJugador tipoJugador) {
        this.tipoJugador = tipoJugador;
    }
}
