package Modelo.ClasesBasesDatos;

import Modelo.ClasesObjetos.Equipo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class TEquipo {
    /**
     * Para insertar un nuevo equipo
     * @param equipo Instancia de Equipo
     * @throws SQLException
     */
    public static void insert(Equipo equipo) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("INSERT INTO EQUIPOS (NOMBRE, PRESUPUESTO, COLOR, URL) VALUES (?, ?, ?, ?)");
        ps.setString(1, equipo.getNombre());
        ps.setDouble(2, equipo.getPresupuesto());
        ps.setString(3, equipo.getColor());
        ps.setString(4, equipo.getUrl().toString());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    /**
     * Para borrar un equipo
     * @param equipo Instancia de Equipo
     * @throws SQLException
     */
    public static void delete(Equipo equipo) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("DELETE FROM EQUIPOS where nombre = ?");
        ps.setString(1, equipo.getNombre());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    /**
     * Para updatear un equipo
     * @param equipos Instancia de Equipo
     * @throws Exception
     */
    public static void update(Equipo equipos) throws Exception
    {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update equipos set nombre = ?, presupuesto = ?, color=?, url=? where id_equipo = ?");
        ps.setString(1, equipos.getNombre());
        ps.setDouble(2, equipos.getPresupuesto());
        ps.setString(3, equipos.getColor());
        ps.setString(4, equipos.getUrl().toString());
        ps.setInt(5, equipos.getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    /**
     * Para buscar todos los Equipos
     * @return ArrayList de Objetos Equipo
     * @throws Exception
     */
    public static ArrayList<Equipo> buscarTodos() throws Exception {
        BaseDato.abrirConexion();
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from equipos");
        ResultSet result = ps.executeQuery();
        while (result.next()){
            Equipo equipo = new Equipo(result.getInt("id_equipo"),result.getString("nombre"),result.getLong("presupuesto"), result.getString("color"), result.getURL("url"));
            listaEquipos.add(equipo);
        }
        BaseDato.cerrarConexion();
        return listaEquipos;
    }

    /**
     * Para buscar Equipo por nombre
     * @param equipo
     * @return Objeto equipo
     * @throws Exception
     */
    public static Equipo buscarPorNombre(Equipo equipo) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from equipos where nombre = ?");
        ps.setString(1,equipo.getNombre());
        ResultSet result = ps.executeQuery();
        Equipo equipo2;
        if (result.next())
        {
            equipo2 = new Equipo();
            equipo2.setID(result.getInt("id_equipo"));
            equipo2.setNombre(result.getString("nombre"));
            equipo2.setPresupuesto(result.getDouble("presupuesto"));
            equipo2.setColor(result.getString("color"));
            equipo2.setUrl(result.getURL("url"));
        }
        else
            equipo2 = null;
        BaseDato.cerrarConexion();
        return equipo2;
    }

    /**
     * Para buscar por id_equipo
     * @param equipo
     * @return Objeto Equipo
     * @throws Exception
     */
    public static Equipo buscarPorId(Equipo equipo) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from equipos where id_equipo = ?");
        ps.setInt(1,equipo.getID());
        ResultSet result = ps.executeQuery();
        Equipo equipo2;
        if (result.next())
        {
            equipo2 = new Equipo();
            equipo2.setID(result.getInt("id_equipo"));
            equipo2.setNombre(result.getString("nombre"));
            equipo2.setPresupuesto(result.getLong("presupuesto"));
            equipo2.setColor(result.getString("color"));
            equipo2.setUrl(result.getURL("url"));
        }
        else
            equipo2 = null;
        BaseDato.cerrarConexion();
        return equipo2;
    }
}
