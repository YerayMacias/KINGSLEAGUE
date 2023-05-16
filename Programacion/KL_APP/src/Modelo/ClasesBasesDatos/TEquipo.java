package Modelo.ClasesBasesDatos;

import Modelo.ClasesObjetos.Equipo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TEquipo {

    public static void insert(Equipo equipo) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("INSERT INTO EQUIPOS (NOMBRE, PRESUPUESTO) VALUES (?, ?);");
        ps.setString(1, equipo.getNombre());
        ps.setDouble(2, equipo.getPresupuesto());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static void delete(Equipo equipo) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("DELETE FROM EQUIPOS where nombre = ?");
        ps.setString(1, equipo.getNombre());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }


    public static void update(Equipo equipos) throws Exception
    {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update equipos set nombre = ?, presupuesto = ? where id_equipo = ?");
        ps.setString(1, equipos.getNombre());
        ps.setDouble(2, equipos.getPresupuesto());
        ps.setInt(3, equipos.getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }


    public static ArrayList<Equipo> buscarTodos() throws Exception {
        BaseDato.abrirConexion();
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from equipos");
        ResultSet result = ps.executeQuery();
        while (result.next()){
            Equipo equipo = new Equipo(result.getInt("id_equipo"),result.getString("nombre"),result.getLong("presupuesto"));
            listaEquipos.add(equipo);
        }
        return listaEquipos;
    }

    public static ArrayList<Equipo> buscarPorNombre(Equipo equipo) throws Exception {
        BaseDato.abrirConexion();
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from equipos where nombre = ?");
        ps.setString(1,equipo.getNombre());
        ResultSet result = ps.executeQuery();
        Equipo equipo2;
        if (result.next())
        {
            equipo2 = new Equipo();
            equipo2.setID(result.getInt("id_equipo"));
            equipo2.setNombre(result.getString("nombre"));
            equipo2.setPresupuesto(result.getLong("presupuesto"));
        }
        else
            equipo2 = null;
        return listaEquipos;
    }

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
        }
        else
            equipo2 = null;
        return equipo2;
    }
}
