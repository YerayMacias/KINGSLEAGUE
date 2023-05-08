package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDato {
    private static Connection con;
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

    public static void cerrarConexion(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Problemas con la base de datos " + e.getMessage());
        }
    }
    public static Connection getCon(){
        return con;
    }
}
