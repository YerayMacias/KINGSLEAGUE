package Controlador;

import Modelo.BaseDato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        // Test para probar conexion con la base de datos
        try {
            BaseDato.abrirConexion();
            PreparedStatement ps = BaseDato.getCon().prepareStatement("Select * from Jugadores");
            ResultSet resultado = ps.executeQuery();
            while (resultado.next())
                System.out.println(resultado.getString("nombre"));
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}