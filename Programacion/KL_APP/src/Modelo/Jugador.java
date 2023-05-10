package Modelo;

/**
 * @author
 * @version 1.0
 */
public class Jugador extends Persona{
    public enum tPosicion{DC, DF, P, MC}
    private tPosicion posicion;
    public enum tTipoJugador{HABITUAL,WILDCARD}
    private tTipoJugador tipoJugador;

    public Jugador() {
    }

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
