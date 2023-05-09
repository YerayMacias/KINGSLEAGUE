package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TPartido {

    public static void insert(Partido partido) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("INSERT INTO PARTIDOS (TIPO_PARTIDO, HORA, ID_JORNADA, ID_EQUIPO_GANADOR) VALUES (?,?,?,?);");
        ps.setString(1, partido.getTipoPartido());
        ps.setString(2, partido.getHora());
        ps.setInt(3, partido.getJornada().getID());
        ps.setInt(4, partido.getEquipoGanador().getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static void delete(Partido partido) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("DELETE FROM PARTIDOS where id_jornada = ?");
        ps.setInt(1, partido.getJornada().getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }


    public static void update(Partido partido) throws Exception
    {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update PARTIDOS set TIPO_PARTIDO = ?, HORA = ?,ID_JORNADA= ?,ID_EQUIPO_GANADOR = ? where id_partido = ?");
        ps.setString(1, partido.getTipoPartido());
        ps.setString(2, partido.getHora());
        ps.setInt(3,partido.getJornada().getID());
        ps.setInt(4, partido.getEquipoGanador().getID());
        ps.setInt(5,partido.getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }


    public static ArrayList<Partido> buscarTodos() throws Exception {
        BaseDato.abrirConexion();
        ArrayList<Partido> listaPartidos = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from partidos");
        ResultSet result = ps.executeQuery();
        while (result.next()){
            Partido partido = new Partido(result.getInt("id_partido"),result.getString("tipo_partido"),result.getString("hora"), TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_ganador"))),TJornadas.buscarPorID(new Jornada(result.getInt("id_jornada"))));
            listaPartidos.add(partido);
        }
        return listaPartidos;
    }

    public static ArrayList<Partido> buscarPorID_Jornada(Partido partido) throws Exception {
        BaseDato.abrirConexion();
        ArrayList<Partido> listaPartidos = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from equipos where id_jornada = ?");
        ps.setInt(1,partido.getJornada().getID());
        ResultSet result = ps.executeQuery();
        Partido partido2;
        if (result.next())
        {
            partido2 = new Partido();
            partido2.setID(result.getInt("id_partido"));
            partido2.setTipoPartido(result.getString("tipo_partido"));
            partido2.setHora(result.getString("hora"));
            partido2.setJornada(TJornadas.buscarPorID(new Jornada(result.getInt("id_jornada"))));
            partido2.setEquipoGanador(TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_ganador"))));
        }
        else
            partido2 = null;
        return listaPartidos;
    }
}
