package Modelo.ClasesBasesDatos;

import Modelo.ClasesObjetos.Equipo;
import Modelo.ClasesObjetos.Presidente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TPresidente {

    public static void insert(Presidente presidente) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("INSERT INTO PRESIDENTES (nombre,apellido,dni,ID_EQUIPO) values (?,?,?,?)");
        ps.setString(1, presidente.getNombre());
        ps.setString(2, presidente.getApellido());
        ps.setString(3, presidente.getDNI());
        ps.setInt(4, presidente.getEquipo().getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static void delete(Presidente presidente) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("DELETE FROM PRESIDENTES where dni = ?");
        ps.setString(1, presidente.getDNI());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }


    public static void update(Presidente presidente) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update PRESIDENTES set id_equipo = ? where ID_PRESIDENTE = ?");
        ps.setInt(1, presidente.getEquipo().getID());
        ps.setInt(2, presidente.getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }


    public static ArrayList<Presidente> buscarTodos() throws Exception {
        BaseDato.abrirConexion();
        ArrayList<Presidente> listaPresidentes = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from presidentes");
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Presidente presidente = new Presidente(result.getInt("id_presidente"), result.getString("nombre"), result.getString("apellido"), result.getString("dni"), TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))));
            listaPresidentes.add(presidente);
        }
        return listaPresidentes;
    }

    public static Presidente buscarPorDNI(Presidente presidente) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from presidentes where dni=?");
        ps.setString(1, presidente.getDNI());
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            presidente = new Presidente(result.getInt("id_presidente"), result.getString("nombre"), result.getString("apellido"), result.getString("dni"), TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))));
        } else
            throw new Exception("Staff no encontrado");
        return presidente;
    }
}
