package Modelo.ClasesBasesDatos;

import Modelo.ClasesObjetos.XML;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class TXMLs {
    /**
     * Para buscar el xml de ultima Jornada
     * @return Objeto XML
     * @throws SQLException
     */
    public static XML buscarUltimaJornada() throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from temp_xml_ultimajornada where fecha_expiracion >= ? and rownum=1 order by fecha_expiracion desc");
        ps.setDate(1, Date.valueOf(LocalDate.now()));
        ResultSet resultado = ps.executeQuery();
        XML xml = null;
        if (resultado.next()){
            xml = new XML(resultado.getString("resultado"), resultado.getDate("fecha_expiracion").toLocalDate());
        } else {
            BaseDato.generarXMLUltimaJornada();
            buscarUltimaJornada();
        }
        BaseDato.cerrarConexion();
        return xml;
    }

    /**
     * Para buscar el XML de todas las jornadas
     * @return Objeto XML
     * @throws Exception
     */
    public static XML buscarTodasJornada() throws Exception{
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from temp_xml_jornadas where fecha_expiracion >= ? and rownum=1 order by fecha_expiracion desc");
        ps.setDate(1, Date.valueOf(LocalDate.now()));
        ResultSet resultado = ps.executeQuery();
        XML xml = null;
        if (resultado.next()){
            xml = new XML(resultado.getString("resultado"), resultado.getDate("fecha_expiracion").toLocalDate());
        } else {
            BaseDato.generarXMLJornadas();
            buscarTodasJornada();
        }
        BaseDato.cerrarConexion();
        return xml;
    }

    /**
     * Para buscar el xml de Clasificacion
     * @return Objeto XML
     * @throws Exception
     */
    public static XML buscarClasificacion() throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from temp_xml_clasificacion where fecha_expiracion >= ? and rownum=1 order by fecha_expiracion desc");
        ps.setDate(1, Date.valueOf(LocalDate.now()));
        ResultSet resultado = ps.executeQuery();
        XML xml = null;
        if (resultado.next()){
            xml = new XML(resultado.getString("resultado"), resultado.getDate("fecha_expiracion").toLocalDate());
        } else {
            BaseDato.generarXMLClasificacion();
            buscarClasificacion();
        }
        BaseDato.cerrarConexion();
        return xml;
    }

    /**
     * Para buscar la fecha de Expiracion
     * @param tipo Tipo de XML (ultima_jornada, todas_jornadas y clasificacion)
     * @return
     * @throws Exception
     */
    public static boolean buscarFechaExpiracion(String tipo) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps;
        switch (tipo){
            case "ultima" -> {
                ps = BaseDato.getCon().prepareStatement("select * from temp_xml_ultimajornada where rownum=1 order by fecha_expiracion desc");
                ResultSet resultado = ps.executeQuery();
                if (resultado.next()){
                    LocalDate ahora = LocalDate.now();
                    LocalDate fechaExpiracion = resultado.getDate("fecha_expiracion").toLocalDate();
                    if (fechaExpiracion.isBefore(ahora)){
                        return true;
                    }
                } else {
                    BaseDato.generarXMLUltimaJornada();
                    buscarUltimaJornada();
                }
            }
            case "todas" -> {
                ps = BaseDato.getCon().prepareStatement("select * from temp_xml_jornadas where rownum=1 order by fecha_expiracion desc");
                ResultSet resultado = ps.executeQuery();
                if (resultado.next()){
                    LocalDate ahora = LocalDate.now();
                    LocalDate fechaExpiracion = resultado.getDate("fecha_expiracion").toLocalDate();
                    if (fechaExpiracion.isBefore(ahora)){
                        return true;
                    }
                } else {
                    BaseDato.generarXMLJornadas();
                    buscarTodasJornada();
                }

            }
            case "clasi" -> {
                ps = BaseDato.getCon().prepareStatement("select * from temp_xml_clasificacion where rownum=1 order by fecha_expiracion desc");
                ResultSet resultado = ps.executeQuery();
                if (resultado.next()){
                    LocalDate ahora = LocalDate.now();
                    LocalDate fechaExpiracion = resultado.getDate("fecha_expiracion").toLocalDate();
                    if (fechaExpiracion.isBefore(ahora)){
                        return true;
                    }
                } else {
                    BaseDato.generarXMLClasificacion();
                    buscarClasificacion();
                }
            }
        }
        return false;
    }

}
