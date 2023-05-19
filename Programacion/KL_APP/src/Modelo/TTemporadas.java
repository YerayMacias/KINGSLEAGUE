package Modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

}
