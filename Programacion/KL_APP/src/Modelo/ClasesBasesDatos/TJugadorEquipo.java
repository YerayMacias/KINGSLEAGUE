package Modelo.ClasesBasesDatos;

import Modelo.ClasesObjetos.Equipo;
import Modelo.ClasesObjetos.Jugador;
import Modelo.ClasesObjetos.JugadorEquipo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TJugadorEquipo {

    public static void insert(JugadorEquipo jugadorEquipo) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("INSERT INTO PLANTILLA  values (?,?,?,?,?,?)");
        ps.setInt(1, jugadorEquipo.getEquipo().getID());
        ps.setInt(2, jugadorEquipo.getJugador().getID());
        ps.setDouble(3,jugadorEquipo.getSueldo());
        ps.setDate(4, Date.valueOf(jugadorEquipo.getFechaInicio()));
        ps.setDate(5,Date.valueOf(jugadorEquipo.getFechaFin()));
        ps.setDouble(6,jugadorEquipo.getClausula());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static void delete(JugadorEquipo jugadorEquipo) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("DELETE FROM PLATILLA where ID_JUGADOR = ?");
        ps.setInt(1, jugadorEquipo.getJugador().getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }


    public static void update(JugadorEquipo jugadorEquipo) throws Exception
    {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update PLANTILLA set sueldo = ?, fecha_inicio = ?, fecha_fin = ?, clausula = ?  where ID_JUGADOR = ?");
        ps.setDouble(1, jugadorEquipo.getSueldo());
        ps.setDate(2, Date.valueOf(jugadorEquipo.getFechaInicio()));
        ps.setDate(3, Date.valueOf(jugadorEquipo.getFechaFin()));
        ps.setDouble(4, jugadorEquipo.getClausula());
        ps.setInt(5,jugadorEquipo.getJugador().getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }


    public static ArrayList<JugadorEquipo> buscarTodos() throws Exception {
        BaseDato.abrirConexion();
        ArrayList<JugadorEquipo> listaJugadoresEquipo = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from equipos_jugadores");
        ResultSet result = ps.executeQuery();
        while (result.next()){
            JugadorEquipo jugadorEquipo = new JugadorEquipo(tJugadores.buscarPorID(new Jugador(result.getInt("id_jugador"))),TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))), result.getDate("fecha_inicio").toLocalDate(), result.getDate("fecha_fin").toLocalDate(),result.getDouble("sueldo"),result.getDouble("clausula"));
            listaJugadoresEquipo.add(jugadorEquipo);
        }
        return listaJugadoresEquipo;
    }

    public static JugadorEquipo buscarPorId(JugadorEquipo jugadorEquipo) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from equipos_jugadores where id_jugador = ?");
        ps.setInt(1,jugadorEquipo.getEquipo().getID());
        ResultSet result = ps.executeQuery();
        JugadorEquipo jugadorEquipo2;
        if (result.next())
        {
            jugadorEquipo2 = new JugadorEquipo();
            jugadorEquipo2.setJugador(tJugadores.buscarPorID(new Jugador(result.getInt("id_jugador"))));
            jugadorEquipo2.setEquipo(TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))));
            jugadorEquipo2.setSueldo(result.getDouble("sueldo"));
            jugadorEquipo2.setFechaInicio(result.getDate("fecha_inicio").toLocalDate());
            jugadorEquipo2.setFechaFin(result.getDate("fecha_fin").toLocalDate());
            jugadorEquipo2.setClausula(result.getDouble("clausula"));
        }
        else
            jugadorEquipo2 = null;
        return jugadorEquipo2;
    }
}
