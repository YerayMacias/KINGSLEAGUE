package Modelo.ClasesBasesDatos;

import Modelo.ClasesObjetos.Jornada;
import Modelo.ClasesObjetos.Partido;
import Modelo.ClasesObjetos.Temporada;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class TJornadas {
    /**
     * Para insertar una nueva Jornada
     * @param jorn Instancia de Jornada
     * @throws Exception
     */
    public static void insert(Jornada jorn) throws Exception
    {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("insert into jornadas(id_temporada, num_jornada, fecha) values (?,?,?)");
        ps.setInt(1, jorn.getTemporada().getID());
        ps.setInt(2, jorn.getNumJornada());
        ps.setDate(3, Date.valueOf(jorn.getFecha()));
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    /**
     * Para updatear una jornada
     * @param jorn Instancia de Jornada
     * @return
     * @throws SQLException
     */
    public static int update(Jornada jorn) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update jornadas set id_temporada = ?, num_jornada = ?, fecha = ? where id_jornada = ?`");
        ps.setInt(1, jorn.getTemporada().getID());
        ps.setInt(2, jorn.getNumJornada());
        ps.setDate(3, Date.valueOf(jorn.getFecha()));
        ps.setInt(4,jorn.getID());
        int n = ps.executeUpdate();
        BaseDato.cerrarConexion();
        return n;
    }

    /**
     * Para borrar una jornada
     * @param jorn Instancia de Jornada
     * @return
     * @throws Exception
     */
    public static int delete(Jornada jorn) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("delete from jornadas where id_jornada = ?");
        ps.setInt(1, jorn.getID());
        int n=ps.executeUpdate();
        BaseDato.cerrarConexion();
        return n;
    }

    /**
     * Para buscar todas las Jornadas
     * @return ArrayList de Jornada
     * @throws Exception
     */
    public static ArrayList<Jornada> buscarTodo() throws Exception {
        ArrayList<Jornada> listaJornadas = new ArrayList<>();
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from jornadas");
        ResultSet resultado = ps.executeQuery();
        Jornada jornada;
        while (resultado.next())
        {
            jornada = new Jornada(resultado.getInt("id_jornada"), resultado.getInt("num_jornada"), resultado.getDate("fecha").toLocalDate(), TTemporadas.buscarPorID(new Temporada(resultado.getInt("id_temporada"))));
            listaJornadas.add(jornada);
        }
        BaseDato.cerrarConexion();
        return listaJornadas;
    }

    /**
     * Para buscar una Jornada por fecha
     * @param jorn
     * @return
     * @throws Exception
     */
    public static Jornada buscarPorFecha(Jornada jorn) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from jornadas where fecha = ?");
        ps.setDate(1,Date.valueOf(jorn.getFecha()));
        ResultSet resultado = ps.executeQuery();
        Jornada jornada;
        if (resultado.next())
        {
            jornada = new Jornada();
            jornada.setID(resultado.getInt("id_jornada"));
            jornada.setTemporada(TTemporadas.buscarPorID(new Temporada(resultado.getInt("id_temporada"))));
            jornada.setNumJornada(resultado.getInt("num_jornada"));
            jornada.setFecha(resultado.getDate("fecha").toLocalDate());
        }
        else
            jornada = null;
        BaseDato.cerrarConexion();
        return jornada;
    }

    /**
     * Para buscar por id_jornada
     * @param jorn
     * @return
     * @throws Exception
     */
    public static Jornada buscarPorID(Jornada jorn) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from jornadas where id_jornada = ?");
        ps.setInt(1,jorn.getID());
        ResultSet resultado = ps.executeQuery();
        Jornada jornada;
        if (resultado.next())
        {
            jornada = new Jornada();
            jornada.setID(resultado.getInt("id_jornada"));
            jornada.setTemporada(TTemporadas.buscarPorID(new Temporada(resultado.getInt("id_temporada"))));
            jornada.setNumJornada(resultado.getInt("num_jornada"));
            jornada.setFecha(resultado.getDate("fecha").toLocalDate());
        }
        else
            jornada = null;
        BaseDato.cerrarConexion();
        return jornada;
    }

    /**
     * Para buscar por Temporada
     * @param jornada
     * @return
     * @throws Exception
     */
    public static ArrayList<Jornada> buscarPorTemporada(Jornada jornada) throws Exception {
        BaseDato.abrirConexion();
        ArrayList<Jornada> listaJornadas = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from jornadas where id_temporada = ?");
        ps.setInt(1,jornada.getTemporada().getID());
        ResultSet resultado = ps.executeQuery();
        while (resultado.next()){
            jornada = new Jornada(resultado.getInt("id_jornada"), resultado.getInt("num_jornada"), resultado.getDate("fecha").toLocalDate(), TTemporadas.buscarPorID(new Temporada(resultado.getInt("id_temporada"))));
            Partido partido = new Partido();
            partido.setJornada(jornada);
            ArrayList<Partido> listaPartidos = TPartido.buscarPorIDJornada(partido);
            jornada.setListaPartidos(listaPartidos);
            listaJornadas.add(jornada);
        }
        BaseDato.cerrarConexion();
        return listaJornadas;
    }

}
