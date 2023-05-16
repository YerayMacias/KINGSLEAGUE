package Modelo.ClasesBasesDatos;

import Modelo.ClasesObjetos.Equipo;
import Modelo.ClasesObjetos.Jornada;
import Modelo.ClasesObjetos.Partido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TPartido {

    public static void insert(Partido partido) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("INSERT INTO PARTIDOS (TIPO_PARTIDO, HORA, ID_JORNADA, ID_EQUIPO_GANADOR) VALUES (?,?,?,?);");
        ps.setString(1, partido.getTipoPartido().toString());
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
        ps.setString(1, partido.getTipoPartido().toString()   );
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
            Partido.tPartido tipoPartido;
            if (result.getString("tipo_partido").equalsIgnoreCase("FR"))
                tipoPartido = Partido.tPartido.FR;
            else tipoPartido = Partido.tPartido.PO;

            Partido partido = new Partido(result.getInt("id_partido"),tipoPartido,result.getString("hora"), TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_ganador"))),TJornadas.buscarPorID(new Jornada(result.getInt("id_jornada"))));
            listaPartidos.add(partido);
        }
        return listaPartidos;
    }

    public static ArrayList<Partido> buscarPorIDJornada(Partido partido) throws Exception {
        BaseDato.abrirConexion();
        ArrayList<Partido> listaPartidos = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from equipos where id_jornada = ?");
        ps.setInt(1,partido.getJornada().getID());
        ResultSet result = ps.executeQuery();
        Partido partido2;
        while (result.next())
        {
            partido2 = new Partido();
            partido2.setID(result.getInt("id_partido"));
            Partido.tPartido tipoPartido;
            if (result.getString("tipo_partido").equalsIgnoreCase("FR"))
                tipoPartido = Partido.tPartido.FR;
            else tipoPartido = Partido.tPartido.PO;
            partido2.setTipoPartido(tipoPartido);
            partido2.setHora(result.getString("hora"));
            partido2.setJornada(TJornadas.buscarPorID(new Jornada(result.getInt("id_jornada"))));
            partido2.setEquipoGanador(TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_ganador"))));
        }
        return listaPartidos;
    }

    public static Partido buscarPorIDPartido(Partido partido) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("SELECT * FROM PARTIDOS WHERE ID_PARTIDO = ?");
        ps.setInt(1, partido.getID());
        ResultSet result = ps.executeQuery();
        Partido.tPartido tPartido;
        if (result.next()){
            if (result.getString("tipo_partido").equalsIgnoreCase("FR")) tPartido = Partido.tPartido.FR;
            else tPartido = Partido.tPartido.PO;
            partido = new Partido(result.getInt("id_partido"), tPartido, result.getString("hora"), TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))), TJornadas.buscarPorID(new Jornada(result.getInt("id_jornada"))));
        }
        BaseDato.cerrarConexion();
        return partido;
    }

}
