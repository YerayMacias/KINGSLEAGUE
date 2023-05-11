package Modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TEquiposJugadores {

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


    /* public static ArrayList<JugadorEquipo> buscarTodos() throws Exception {
        BaseDato.abrirConexion();
        ArrayList<JugadorEquipo> listaJugadoresEquipo = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from presidentes");
        ResultSet result = ps.executeQuery();
        while (result.next()){
            JugadorEquipo jugadorEquipo = new JugadorEquipo((tJugadores.buscarPorId(result.getInt("id_jugador"))));
            listaJugadoresEquipo.add(jugadorEquipo);
        }
        return listaJugadoresEquipo;
    }*/

    public static Presidente buscarPorDNI(Presidente presidente) throws Exception{
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from presidente where dni=?");
        ps.setString(1, presidente.getDNI());
        ResultSet result = ps.executeQuery();
        if (result.next()){
            presidente = new Presidente(result.getInt("id_presidente"), result.getString("nombre"), result.getString("apellido"), result.getString("dni"), TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))));
        } else
            throw new Exception("Staff no encontrado");
        return presidente;
    }
}
