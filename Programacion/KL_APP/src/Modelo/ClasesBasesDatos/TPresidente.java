package Modelo.ClasesBasesDatos;

import Modelo.ClasesObjetos.Equipo;
import Modelo.ClasesObjetos.Presidente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class TPresidente {
    /**
     * Para insertar un nuevo presidente
     * @param presidente Instancia de Presidente
     * @throws SQLException
     */
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

    /**
     * Para borrar un presidente
     * @param presidente Instancia de Presidente
     * @throws SQLException
     */
    public static void delete(Presidente presidente) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("DELETE FROM PRESIDENTES where dni = ?");
        ps.setString(1, presidente.getDNI());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    /**
     * Para updatear un presidente
     * @param presidente Instancia de Presidente
     * @throws Exception
     */
    public static void update(Presidente presidente) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update PRESIDENTES set id_equipo = ? where ID_PRESIDENTE = ?");
        ps.setInt(1, presidente.getEquipo().getID());
        ps.setInt(2, presidente.getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    /**
     * Para buscar todos los Presidentes
     * @return ArrayList de Presidente
     * @throws Exception
     */
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

    /**
     * Para buscar un presidente por DNI
     * @param presidente
     * @return Objeto Presidente
     * @throws Exception
     */
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
