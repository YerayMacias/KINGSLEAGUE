package Controlador;

import Modelo.*;
import Vista.vClasificacion;
import Vista.vLogin;
import Vista.vPartidos;
import Vista.vPrincipal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author
 * @version 1.0
 */
public class Main {

    public static JFrame vPrincipal;
    public static JFrame vLogin;
    public static JFrame vEquipos;
    public static JFrame vClasificacion;
    public static JFrame vPartidos;
    public static Usuario usuario;
    public static void main(String[] args){

        // Test para probar conexion con la base de datos

       /* try {
            BaseDato.abrirConexion();
            PreparedStatement ps = BaseDato.getCon().prepareStatement("Select * from Jugadores");
            ResultSet resultado = ps.executeQuery();
            while (resultado.next())
                System.out.println(resultado.getString("nombre"));
            BaseDato.cerrarConexion();
        } catch (Exception e){
            BaseDato.cerrarConexion();
            System.out.println("Error");
        } */

        crearVentanaLogin();
    }
    public static void crearVentanaLogin(){
        vLogin = new JFrame("vLogin");
        vLogin.setContentPane(new vLogin().getpPrincipal());
        vLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vLogin.pack();
        vLogin.setLocationRelativeTo(null);
        vLogin.setVisible(true);
    }

    public static void crearVentanaPrincipal(String admin) {
        vLogin.dispose();
        vPrincipal = new JFrame("vPrincipal");
        vPrincipal.setContentPane(new vPrincipal(admin).getpPrincipal());
        vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPrincipal.pack();
        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.setVisible(true);
    }

    public static void crearVentanaPartidos(String admin) {
        vPartidos = new JFrame("vPartidos");
        vPartidos.setContentPane(new vPartidos(admin).getpPrincipal());
        vPartidos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPartidos.setLocationRelativeTo(null);
        vPartidos.pack();
        vPartidos.setVisible(true);
    }

    public static void crearVentanaClasificacion(String admin) {
        vClasificacion = new JFrame("vClasificacion");
        vClasificacion.setContentPane(new vClasificacion(admin).getpPrincipal());
        vClasificacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vClasificacion.setLocationRelativeTo(null);
        vClasificacion.pack();
        vClasificacion.setVisible(true);
    }


    public static void validarUsuario(String nombre, String password) throws Exception {
        usuario = TUsuarios.buscarPorUsernamePassword(new Usuario(nombre, password));
        if (usuario != null){
            if (usuario.getAdmin().equalsIgnoreCase("S")) Main.crearVentanaPrincipal("S");
            else Main.crearVentanaPrincipal("N");
        } else throw new Exception("El usuario o la contraseña son incorrectos");
    }

    public static void buscarPartidosTemporada() throws Exception {
        ArrayList<Object> listaTodos = TPartido.buscarPartidosTemporada();
        // Coincidentes
        ArrayList<Partido> listaPartidos = (ArrayList<Partido>) listaTodos.get(0);
        ArrayList<Jornada> listaJornadas = (ArrayList<Jornada>) listaTodos.get(0);
        ArrayList<Equipo> listaEquiposLocales = (ArrayList<Equipo>) listaTodos.get(0);
        ArrayList<Equipo> listaEquiposVisitantes = (ArrayList<Equipo>) listaTodos.get(0);
        ArrayList<Integer> listaGolesLocales = (ArrayList<Integer>) listaTodos.get(0);
        ArrayList<Integer> listaGolesVisitante = (ArrayList<Integer>) listaTodos.get(0);
        crearPanelesJornadas(listaPartidos, listaJornadas, listaEquiposLocales, listaEquiposVisitantes, listaGolesLocales, listaGolesVisitante);
    }

    public static void crearPanelesJornadas(ArrayList<Partido> listaPartidos, ArrayList<Jornada> listaJornadas, ArrayList<Equipo> listaEquiposLocales, ArrayList<Equipo> listaEquiposVisitantes, ArrayList<Integer> listaGolesLocales, ArrayList<Integer> listaGolesVisitante){
        GridLayout grid = new GridLayout(7,1);
        JPanel panelJornada = new JPanel(grid);
        JLabel labelTitulo = new JLabel();
        JLabel labelPartidos = new JLabel();
        for (int x = 0; x < listaPartidos.size(); x++) {
            
        }
    }
}