package Modelo;

public class Jugador extends Persona{
    private String posicion;
    private String tipoJugador;

    public Jugador() {
    }

    /**
     * Constructor completo de Jugador
     * Para instanciar un jugador con todos los atributos
     * @param ID
     * @param nombre
     * @param apellido
     * @param DNI
     * @param posicion
     * @param tipoJugador
     */
    public Jugador(int ID, String nombre, String apellido, String DNI, String posicion, String tipoJugador) {
        super(ID, nombre, apellido, DNI);
        this.posicion = posicion;
        this.tipoJugador = tipoJugador;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getTipoJugador() {
        return tipoJugador;
    }

    public void setTipoJugador(String tipoJugador) {
        this.tipoJugador = tipoJugador;
    }
}
