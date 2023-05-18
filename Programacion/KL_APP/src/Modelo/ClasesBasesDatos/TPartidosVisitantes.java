package Modelo.ClasesBasesDatos;

import Modelo.ClasesObjetos.Equipo;
import Modelo.ClasesObjetos.Partido;
import Modelo.ClasesObjetos.PartidoLocal;
import Modelo.ClasesObjetos.PartidoVisitante;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TPartidosVisitantes {
    public static PartidoVisitante buscarPorPartido(PartidoVisitante partidoVisitante) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("SELECT * FROM PARTIDOS_VISITANTES WHERE ID_PARTIDO = ?");
        ps.setInt(1, partidoVisitante.getPartido().getID());
        ResultSet result = ps.executeQuery();
        if (result.next()){
            partidoVisitante = new PartidoVisitante(partidoVisitante.getPartido(), TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))), result.getInt("goles"));
        }
        BaseDato.cerrarConexion();
        return partidoVisitante;
    }

    public static void insert(PartidoVisitante partidoVisitante) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("INSERT INTO PARTIDOS_VISITANTES (ID_PARTIDO, ID_EQUIPO, GOLES) VALUES (?,?,?)");
        ps.setInt(1, partidoVisitante.getPartido().getID());
        ps.setInt(2, partidoVisitante.getEquipo().getID());
        ps.setInt(3, partidoVisitante.getGoles());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static void delete(PartidoVisitante partidoVisitante) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("DELETE FROM PARTIDOS_VISITANTES WHERE ID_PARTIDO = ?)");
        ps.setInt(1, partidoVisitante.getPartido().getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static void update(int goles) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("UPDATE PARTIDOS_VISITANTES SET GOLES=?");
        ps.setInt(1, goles);
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static ArrayList<PartidoVisitante> buscarTodos() throws Exception {
        BaseDato.abrirConexion();
        ArrayList<PartidoVisitante> listaPartidosLocales = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("SELECT * FROM PARTIDOS_VISITANTES");
        ResultSet result = ps.executeQuery();
        PartidoVisitante partidoVisitante;
        while (result.next()){
            partidoVisitante = new PartidoVisitante(TPartido.buscarPorIDPartido(new Partido(result.getInt("id_partido"))), TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))), result.getInt("goles"));
            listaPartidosLocales.add(partidoVisitante);
        }
        BaseDato.cerrarConexion();
        return listaPartidosLocales;
    }
}
