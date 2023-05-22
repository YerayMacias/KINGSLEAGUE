package Modelo.ClasesBasesDatos;

import Modelo.ClasesObjetos.Equipo;
import Modelo.ClasesObjetos.Jornada;
import Modelo.ClasesObjetos.Partido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class TPartido {
    /**
     * Para insertar un nuevo Partido
     * @param partido Instancia de Partido
     * @throws SQLException
     */
    public static void insert(Partido partido) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("INSERT INTO PARTIDOS (TIPO_PARTIDO, HORA, ID_JORNADA, ID_EQUIPO_LOCAL, " +
                "ID_EQUIPO_VISITANTE, GOLES_LOCAL, GOLES_VISITANTE) VALUES (?,?,?,?,?,?,?)");
        ps.setString(1, partido.getTipoPartido().toString());
        ps.setString(2, partido.getHora());
        ps.setInt(3, partido.getJornada().getID());
        ps.setInt(4, partido.getLocal().getID());
        ps.setInt(5, partido.getVisitante().getID());
        ps.setInt(6, partido.getGolesLocal());
        ps.setInt(7, partido.getGolesVisitante());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    /**
     * Para borrar un partido
     * @param partido Instancia de Partido
     * @throws SQLException
     */
    public static void delete(Partido partido) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("DELETE FROM PARTIDOS where id_partido = ?");
        ps.setInt(1, partido.getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    /**
     * Para updatear un partido
     * @param partido Instancia de Partido
     * @throws Exception
     */
    public static void update(Partido partido) throws Exception
    {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update PARTIDOS set TIPO_PARTIDO = ?, HORA = ?,ID_JORNADA= ?,ID_EQUIPO_LOCAL = ?, ID_EQUIPO_VISITANTE=?, GOLES_LOCAL=?, GOLES_VISITANTE=? where id_partido = ?");
        ps.setString(1, partido.getTipoPartido().toString());
        ps.setString(2, partido.getHora());
        ps.setInt(3,partido.getJornada().getID());
        ps.setInt(4, partido.getLocal().getID());
        ps.setInt(5, partido.getVisitante().getID());
        ps.setInt(6, partido.getGolesLocal());
        ps.setInt(7, partido.getGolesVisitante());
        ps.setInt(8,partido.getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    /**
     * Para buscar todos los Partidos
     * @return ArrayList de Partido
     * @throws Exception
     */
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

            Partido partido = new Partido(result.getInt("id_partido"),
                    tipoPartido,result.getString("hora"),
                    TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_local"))),
                    TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_visitante"))),
                    result.getInt("goles_local"),
                    result.getInt("goles_visitante"),
                    TJornadas.buscarPorID(new Jornada(result.getInt("id_jornada")))
                    );
            listaPartidos.add(partido);
        }
        return listaPartidos;
    }

    /**
     *
     * @param partido
     * @return
     * @throws Exception
     */
    public static ArrayList<Partido> buscarPorIDJornada(Partido partido) throws Exception {
        BaseDato.abrirConexion();
        ArrayList<Partido> listaPartidos = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from partidos where id_jornada = ?");
        ps.setInt(1,partido.getJornada().getID());
        ResultSet result = ps.executeQuery();

        while (result.next())
        {
            partido = new Partido();
            partido.setID(result.getInt("id_partido"));
            Partido.tPartido tipoPartido;

            if (result.getString("tipo_partido").equalsIgnoreCase("FR")) tipoPartido = Partido.tPartido.FR;
            else tipoPartido = Partido.tPartido.PO;

            partido.setTipoPartido(tipoPartido);
            partido.setHora(result.getString("hora"));
            partido.setJornada(TJornadas.buscarPorID(new Jornada(result.getInt("id_jornada"))));
            partido.setLocal(TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_local"))));
            partido.setVisitante(TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_visitante"))));
            partido.setGolesLocal(result.getInt("goles_local"));
            partido.setGolesVisitante(result.getInt("goles_visitante"));

            listaPartidos.add(partido);
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
            partido = new Partido(result.getInt("id_partido"),
                    tPartido,result.getString("hora"),
                    TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_local"))),
                    TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_visitante"))),
                    result.getInt("goles_local"),
                    result.getInt("goles_visitante"),
                    TJornadas.buscarPorID(new Jornada(result.getInt("id_jornada")))
            );
        }
        BaseDato.cerrarConexion();
        return partido;
    }

    public static Partido buscarSemis(Partido partido) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("SELECT * FROM PARTIDOS WHERE ID_JORNADA = 12 AND ID_EQUIPO_LOCAL = ? AND ID_EQUIPO_VISITANTE = ?");
        ps.setInt(1, partido.getLocal().getID());
        ps.setInt(2, partido.getVisitante().getID());
        ResultSet result = ps.executeQuery();
        Partido.tPartido tPartido;
        if (result.next()){
            if (result.getString("tipo_partido").equalsIgnoreCase("PO")) tPartido = Partido.tPartido.FR;
            else tPartido = Partido.tPartido.PO;
            partido = new Partido(result.getInt("id_partido"),
                    tPartido,result.getString("hora"),
                    TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_local"))),
                    TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_visitante"))),
                    result.getInt("goles_local"),
                    result.getInt("goles_visitante"),
                    TJornadas.buscarPorID(new Jornada(result.getInt("id_jornada")))
            );
        }
        BaseDato.cerrarConexion();
        return partido;
    }

    public static Partido buscarSemis2(Partido partido) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("SELECT * FROM PARTIDOS WHERE ID_JORNADA = 13 AND ID_EQUIPO_LOCAL = ? AND ID_EQUIPO_VISITANTE = ?");
        ps.setInt(1, partido.getLocal().getID());
        ps.setInt(2, partido.getVisitante().getID());
        ResultSet result = ps.executeQuery();
        Partido.tPartido tPartido;
        if (result.next()){
            if (result.getString("tipo_partido").equalsIgnoreCase("PO")) tPartido = Partido.tPartido.FR;
            else tPartido = Partido.tPartido.PO;
            partido = new Partido(result.getInt("id_partido"),
                    tPartido,result.getString("hora"),
                    TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_local"))),
                    TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo_visitante"))),
                    result.getInt("goles_local"),
                    result.getInt("goles_visitante"),
                    TJornadas.buscarPorID(new Jornada(result.getInt("id_jornada")))
            );
        }
        BaseDato.cerrarConexion();
        return partido;
    }
}
