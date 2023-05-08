package Modelo;

public class Staff extends Persona{
    private String rol;

    public Staff() {
    }

    public Staff(int ID, String nombre, String apellido, String DNI, String rol) {
        super(ID, nombre, apellido, DNI);
        this.rol = rol;
    }

    public Staff(String rol) {
        this.rol = rol;
    }
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
