package Modelo.ClaseObjetos;

import Modelo.ClasesBaseDato.BaseDato;
import Modelo.ClasesBaseDato.Equipo;
import Modelo.ClasesBaseDato.Jornada;
import Modelo.ClasesBaseDato.Partido;

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
        if (result.next())
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

    public static ArrayList<Object> buscarPartidosTemporada() throws Exception{
        BaseDato.abrirConexion();
        // ArrayList coincidentes
        ArrayList<Partido> listaPartidos = new ArrayList<>();
        ArrayList<Jornada> listaJornadas = new ArrayList<>();
        ArrayList<Equipo> listaEquiposLocales = new ArrayList<>();
        ArrayList<Equipo> listaEquiposVisitantes = new ArrayList<>();
        ArrayList<Integer> listaGolesLocales = new ArrayList<>();
        ArrayList<Integer> listaGolesVisitante = new ArrayList<>();

        ArrayList<Object> listaTodos= new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("SELECT P.ID_PARTIDO, P.ID_JORNADA, EL.ID_EQUIPO, EV.ID_EQUIPO, PL.GOLES, PV.GOLES\n" +
                "FROM PARTIDOS P, EQUIPOS EL, EQUIPOS EV, PARTIDOS_LOCALES PL, PARTIDOS_VISITANTES PV\n" +
                "WHERE  P.ID_PARTIDO = PL.ID_PARTIDO AND P.ID_PARTIDO = PV.ID_PARTIDO\n" +
                "AND EL.ID_EQUIPO = PL.ID_EQUIPO AND EV.ID_EQUIPO = PV.ID_EQUIPO\n" +
                "AND P.ID_JORNADA IN (SELECT ID_JORNADA FROM JORNADAS WHERE ID_TEMPORADA = (SELECT MAX(ID_TEMPORADA) FROM TEMPORADAS))\n" +
                "ORDER BY P.ID_PARTIDO;");
        ResultSet result = ps.executeQuery();

        while (result.next()){
            listaPartidos.add(buscarPorIDPartido(new Partido(result.getInt("P.ID_PARTIDO"))));
            listaJornadas.add(TJornadas.buscarPorID(new Jornada(result.getInt("P.ID_JORNADA"))));
            listaEquiposLocales.add(TEquipo.buscarPorId(new Equipo(result.getInt("EL.ID_EQUIPO"))));
            listaEquiposVisitantes.add(TEquipo.buscarPorId(new Equipo(result.getInt("EV.ID_EQUIPO"))));
            listaGolesLocales.add(result.getInt("PL.GOLES"));
            listaGolesVisitante.add(result.getInt("PV.GOLES"));
        }
        BaseDato.cerrarConexion();
        listaTodos.add(listaPartidos);
        listaTodos.add(listaJornadas);
        listaTodos.add(listaEquiposLocales);
        listaTodos.add(listaEquiposVisitantes);
        listaTodos.add(listaGolesLocales);
        listaTodos.add(listaGolesVisitante);
        return listaTodos;
    }
}
