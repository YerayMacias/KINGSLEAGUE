package Modelo.ClasesBasesDatos;


import Modelo.ClasesObjetos.Equipo;
import Modelo.ClasesObjetos.Partido;
import Modelo.ClasesObjetos.PartidoLocal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TPartidosLocales {
    public static PartidoLocal buscarPorPartido(PartidoLocal partidoLocal) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("SELECT * FROM PARTIDOS_LOCALES WHERE ID_PARTIDO = ?");
        ps.setInt(1, partidoLocal.getPartido().getID());
        ResultSet result = ps.executeQuery();
        if (result.next()){
            partidoLocal = new PartidoLocal(partidoLocal.getPartido(), TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))), result.getInt("goles"));
        } else
            partidoLocal = null;
        BaseDato.cerrarConexion();
        return partidoLocal;
    }

    public static void insert(PartidoLocal partidoLocal) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("INSERT INTO PARTIDOS_LOCALES (ID_PARTIDO, ID_EQUIPO, GOLES) VALUES (?,?,?)");
        ps.setInt(1, partidoLocal.getPartido().getID());
        ps.setInt(2, partidoLocal.getEquipo().getID());
        ps.setInt(3, partidoLocal.getGoles());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static void delete(PartidoLocal partidoLocal) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("DELETE FROM PARTIDOS_LOCALES WHERE ID_PARTIDO = ?)");
        ps.setInt(1, partidoLocal.getPartido().getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static void update(int goles) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("UPDATE PARTIDOS_LOCALES SET GOLES=?");
        ps.setInt(1, goles);
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static ArrayList<PartidoLocal> buscarTodos() throws Exception {
        BaseDato.abrirConexion();
        ArrayList<PartidoLocal> listaPartidosLocales = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("SELECT * FROM PARTIDOS_LOCALES");
        ResultSet result = ps.executeQuery();
        PartidoLocal partidoLocal;
        while (result.next()){
            partidoLocal = new PartidoLocal(TPartido.buscarPorIDPartido(new Partido(result.getInt("id_partido"))), TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))), result.getInt("goles"));
            listaPartidosLocales.add(partidoLocal);
        }
        BaseDato.cerrarConexion();
        return listaPartidosLocales;
    }
}
