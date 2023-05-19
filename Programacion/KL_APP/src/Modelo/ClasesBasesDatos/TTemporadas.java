package Modelo.ClasesBasesDatos;

import Modelo.ClasesObjetos.Equipo;
import Modelo.ClasesObjetos.Temporada;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class TTemporadas {

    public static void insertar(Temporada temp) throws Exception
    {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("insert into temporadas values (?,?,?,?)");
        ps.setDate(1, Date.valueOf(temp.getFechaInicio()));
        ps.setDate(2, Date.valueOf(temp.getFechaFin()));
        ps.setString(3, temp.getEstado().toString());
        ps.setString(4, temp.getPeriodo().toString());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static int update(Temporada temp) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update temporadas set fecha_inicio = ?, fecha_fin = ?, estado = ?, periodo = ? where id_temporada = ?`");
        ps.setDate(1, Date.valueOf(temp.getFechaInicio()));
        ps.setDate(2, Date.valueOf(temp.getFechaFin()));
        ps.setString(3, temp.getEstado().toString());
        ps.setString(4, temp.getPeriodo().toString());
        ps.setInt(5,temp.getID());
        int n = ps.executeUpdate();
        BaseDato.cerrarConexion();
        return n;
    }

    public static int delete(Temporada temp) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("delete from temporadas where id_temporada = ?");
        ps.setInt(1,temp.getID());
        int n=ps.executeUpdate();
        BaseDato.cerrarConexion();
        return n;
    }

    public static ArrayList<Temporada> buscarTodo() throws Exception {
        ArrayList<Temporada> listaTemporadas = new ArrayList<>();
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from temporadas");
        ResultSet resultado = ps.executeQuery();
        Temporada temporada;
        Temporada.tEstado tEstado;
        Temporada.tPeriodo tPeriodo;
        while (resultado.next())
        {
            if (resultado.getString("estado").equalsIgnoreCase("ABIERTO"))
                tEstado = Temporada.tEstado.ABIERTO;
            else tEstado = Temporada.tEstado.CERRADO;

            if (resultado.getString("periodo").equalsIgnoreCase("INV"))
                tPeriodo = Temporada.tPeriodo.INV;
            else tPeriodo = Temporada.tPeriodo.VER;

            temporada = new Temporada(resultado.getInt("id_temporada"), resultado.getDate("fecha_inicio").toLocalDate(), resultado.getDate("fecha_fin").toLocalDate(), tEstado, tPeriodo);
            listaTemporadas.add(temporada);
        }
        BaseDato.cerrarConexion();
        return listaTemporadas;
    }

    public static Temporada buscarTemporada(Temporada temp) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from temporadas where fecha_inicio = ? and fecha_fin = ?");
        ps.setDate(1, Date.valueOf(temp.getFechaInicio()));
        ps.setDate(2, Date.valueOf(temp.getFechaFin()));
        ResultSet resultado = ps.executeQuery();
        Temporada temporada;
        if (resultado.next())
        {
            temporada = new Temporada();
            temporada.setID(resultado.getInt("id_temporada"));
        }
        else
            temporada = null;
        BaseDato.cerrarConexion();
        return temporada;
    }
    public static Temporada buscarPorID(Temporada temp) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from temporadas where id_temporada=?");
        ps.setInt(1, temp.getID());
        ResultSet resultado = ps.executeQuery();
        Temporada temporada;
        if (resultado.next())
        {
            temporada = new Temporada();
            temporada.setID(resultado.getInt("id_temporada"));
            temporada.setEstado(Temporada.tEstado.valueOf(resultado.getString("estado")));
            temporada.setPeriodo(Temporada.tPeriodo.valueOf(resultado.getString("periodo")));
            temporada.setFechaFin(resultado.getDate("fecha_fin").toLocalDate());
            temporada.setFechaInicio(resultado.getDate("fecha_inicio").toLocalDate());
        }
        else
            temporada = null;
        BaseDato.cerrarConexion();
        return temporada;
    }

    public static Temporada buscarUltimaTemporada() throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from temporadas where id_temporada=(select max(id_temporada) from temporadas)");
        ResultSet resultado = ps.executeQuery();
        Temporada temporada;
        if (resultado.next())
        {
            temporada = new Temporada();
            temporada.setID(resultado.getInt("id_temporada"));
            temporada.setEstado(Temporada.tEstado.valueOf(resultado.getString("estado")));
            temporada.setPeriodo(Temporada.tPeriodo.valueOf(resultado.getString("periodo")));
            temporada.setFechaFin(resultado.getDate("fecha_fin").toLocalDate());
            temporada.setFechaInicio(resultado.getDate("fecha_inicio").toLocalDate());
        }
        else
            temporada = null;
        BaseDato.cerrarConexion();
        return temporada;
    }

    // Aunque no sea un crud de la tabla de Temporadas
    // Es la tabla de clasificacion de la temporada

    public static ArrayList<Object> buscarClasificacion() throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select rownum, nombre, victorias, derrotas, goles_a_favor, goles_en_contra, diferencia_goles from clasificacion");
        ResultSet resultado = ps.executeQuery();
        // Arrays coincidentes
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        ArrayList<Integer> listaVictorias = new ArrayList<>();
        ArrayList<Integer> listaDerrotas = new ArrayList<>();
        ArrayList<Integer> listaGolesFavor = new ArrayList<>();
        ArrayList<Integer> listaGolesContra = new ArrayList<>();
        ArrayList<Integer> listaDiferenciaGoles = new ArrayList<>();
        ArrayList<Integer> listaPosicion = new ArrayList<>();

        // Array contenedor de los anteriores
        ArrayList<Object> listaArrays = new ArrayList<>();
        while (resultado.next()){
            Equipo equipo = new Equipo();
            equipo.setNombre(resultado.getString("nombre"));
            equipo = TEquipo.buscarPorNombre(equipo);
            listaEquipos.add(equipo);

            int victorias = resultado.getInt("victorias");
            listaVictorias.add(victorias);

            int derrotas = resultado.getInt("derrotas");
            listaDerrotas.add(derrotas);

            int golesFavor = resultado.getInt("goles_a_favor");
            listaGolesFavor.add(golesFavor);

            int golesContra = resultado.getInt("goles_en_contra");
            listaGolesContra.add(golesContra);

            int diferenciaGoles = resultado.getInt("diferencia_goles");
            listaDiferenciaGoles.add(diferenciaGoles);

            int posicion = resultado.getInt("rownum");
            listaPosicion.add(posicion);
        }
        BaseDato.cerrarConexion();
        listaArrays.add(listaEquipos);
        listaArrays.add(listaVictorias);
        listaArrays.add(listaDerrotas);
        listaArrays.add(listaGolesFavor);
        listaArrays.add(listaGolesContra);
        listaArrays.add(listaDiferenciaGoles);
        listaArrays.add(listaPosicion);
        return listaArrays;
    }

}
