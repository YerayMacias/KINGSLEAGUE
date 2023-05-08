package Modelo;

public class Presidente extends Persona {
    private Equipo equipo;

    public Presidente() {
    }

    public Presidente(int ID, String nombre, String apellido, String DNI, Equipo equipo) {
        super(ID, nombre, apellido, DNI);
        this.equipo = equipo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
