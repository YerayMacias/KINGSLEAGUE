package Modelo;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

import java.sql.*;

/**
 * @author
 * @version 1.0
 */
public class BaseDato {
    private static Connection con;
    public static Connection getCon(){
        return con;
    }

    /**
     * Abrir conexion con la base de datos
     */
    public static void abrirConexion(){
        try {
            String url = "jdbc:oracle:thin:@172.20.225.114:1521:ORCL";
            String pass = "eqdaw04";
            String user = "eqdaw04";
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e){
            System.out.println("Problemas con la base de datos " + e.getMessage());
        }
    }

    /**
     * Cerrar conexion con la base de datos
     */
    public static void cerrarConexion(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Problemas con la base de datos " + e.getMessage());
        }
    }

    /*
    public static void generarCalendario() throws Exception {
        abrirConexion();
        CallableStatement statement = con.prepareCall("{call KL_CALENDARIO.GENERAR_CALENDARIO()}");
        statement.execute();
        cerrarConexion();
    }

    public static void verEnfrentamientos() throws Exception {
        abrirConexion();
        CallableStatement statement = con.prepareCall("{call KL_CALENDARIO.VER_ENFRENTAMIENTOS(?)}");
        statement.registerOutParameter(1, OracleTypes.CURSOR);
        statement.execute();
        ResultSet result = ((OracleCallableStatement)statement).getCursor(1);
        while (result.next()){
            int idPartido = result.getInt("id_partido");
            String nombreLocal = result.getString("local");
            String nombreVisitante = result.getString("visitante");
            int idJornada = result.getInt("id_jornada");
            String hora = result.getString("hora");
            System.out.println("Partido: " + idPartido + " Local: " + nombreLocal + " Visitante: " + nombreVisitante + " Jornada: " + idJornada + " Hora: " + hora);
        }
        result.close();
        statement.close();
        cerrarConexion();
    }
    */
}
