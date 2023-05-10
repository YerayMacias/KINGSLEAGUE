package Controlador;

import Modelo.BaseDato;
import Vista.vLogin;
import Vista.vPrincipal;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author
 * @version 1.0
 */
public class Main {

    private static JFrame vPrincipal;
    private static JFrame vLogin;
    public static void main(String[] args){
        // Test para probar conexion con la base de datos
        /*
        try {
            BaseDato.abrirConexion();
            PreparedStatement ps = BaseDato.getCon().prepareStatement("Select * from Jugadores");
            ResultSet resultado = ps.executeQuery();
            while (resultado.next())
                System.out.println(resultado.getString("nombre"));
        } catch (Exception e){
            System.out.println("Error");
        } */
        crearVentanaLogin();
    }
    public static void crearVentanaLogin(){
        vLogin = new JFrame("vLogin");
        vLogin.setContentPane(new vLogin().getpPrincipal());
        vLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vLogin.pack();
        vLogin.setVisible(true);
    }

    public static void abrirVentanaPrincipal() {
        vLogin.dispose();
        vPrincipal = new JFrame("vPrincipal");
        vPrincipal.setContentPane(new vPrincipal().getpPrincipal());
        vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.pack();
        vPrincipal.setVisible(true);
    }
}