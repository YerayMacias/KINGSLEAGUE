package Controlador;
import Modelo.ClasesBasesDatos.TJornadas;
import Modelo.ClasesBasesDatos.TTemporadas;
import Modelo.ClasesBasesDatos.*;
import Modelo.ClasesObjetos.*;


import Vista.*;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author
 * @version 1.0
 */
public class Main {

    public static JFrame vPrincipal;
    public static JFrame vLogin;
    public static JFrame vRegistro;
    public static JFrame vEquipos;
    public static JFrame vClasificacion;
    public static JFrame vPartidos;
    public static Usuario usuario;
    private static ArrayList<Jornada> listaJornadas;
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

        //crearVentanaLogin();
        try {
            BaseDato.abrirConexion();
            PreparedStatement ps = BaseDato.getCon().prepareStatement("SELECT * FROM equipos");
            ResultSet result = ps.executeQuery();
            while (result.next()){
                System.out.println(result.getString("nombre"));
            }
            BaseDato.cerrarConexion();
            // crearVentanaPrueba();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void crearVentanaLogin(){
        vLogin = new JFrame("vLogin");
        vLogin.setContentPane(new vLogin().getpPrincipal());
        vLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vLogin.pack();
        vLogin.setSize(830, 480);
        vLogin.setLocationRelativeTo(null);
        vLogin.setVisible(true);
    }

    public static void crearVentanaRegistro(){
        vRegistro = new JFrame("vRegistro");
        vRegistro.setContentPane(new vRegistro().getpPrincipal());
        vRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vRegistro.pack();
        vRegistro.setSize(830, 680);
        vRegistro.setLocationRelativeTo(null);
        vRegistro.setVisible(true);
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
        vPartidos.pack();
        vPartidos.setLocationRelativeTo(null);
        vPartidos.setVisible(true);
    }

    public static void crearVentanaClasificacion(String admin) {
        vClasificacion = new JFrame("vClasificacion");
        vClasificacion.setContentPane(new vClasificacion(admin).getpPrincipal());
        vClasificacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vClasificacion.pack();
        vClasificacion.setLocationRelativeTo(null);
        vClasificacion.setVisible(true);
    }

    public static void crearVentanaEquipos(String admin) {
        vEquipos = new JFrame("vEquipos");
        vEquipos.setContentPane(new vEquipos(admin).getpPrincipal());
        vEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vEquipos.pack();
        vEquipos.setLocationRelativeTo(null);
        vEquipos.setVisible(true);
    }


    public static void validarUsuario(String nombre, String password) throws Exception {
        usuario = TUsuarios.buscarPorUsernamePassword(new Usuario(nombre, password));
        if (usuario != null){
            if (usuario.getAdmin().toString().equalsIgnoreCase("S")) Main.crearVentanaPrincipal("S");
            else Main.crearVentanaPrincipal("N");
        } else throw new Exception("El usuario o la contraseña son incorrectos");
    }

    public static JPanel buscarJornadasTemporada() throws Exception {
        Jornada jornada = new Jornada();
        jornada.setTemporada(TTemporadas.buscarPorID(new Temporada(1)));
        listaJornadas = TJornadas.buscarPorTemporada(jornada);
        return crearPanelesUltimaJornada(listaJornadas);
    }

    public static JPanel crearPanelesUltimaJornada(ArrayList<Jornada> listaJornadas) throws Exception {
        JLabel labelTitulo = new JLabel();
        JPanel panelPartido;
        JPanel panelContenedor = new JPanel(new GridLayout(7, 1));

        int ultimaPosicion = listaJornadas.size() - 1;
        labelTitulo.setText("JORNADA " + String.valueOf(listaJornadas.get(listaJornadas.size() -1).getNumJornada()));
        panelContenedor.add(labelTitulo);
        for (int y = 0; y < listaJornadas.get(ultimaPosicion).getListaPartidos().size(); y++) {
            panelPartido = new JPanel(new GridLayout(1, 3));

            PartidoLocal partidoLocal = TPartidosLocales.buscarPorPartido(new PartidoLocal(listaJornadas.get(ultimaPosicion).getListaPartidos().get(y)));

            PartidoVisitante partidoVisitante = TPartidosVisitantes.buscarPorPartido(new PartidoVisitante(listaJornadas.get(ultimaPosicion).getListaPartidos().get(y)));

            panelPartido.add(new JLabel(partidoLocal.getEquipo().getNombre()));
            panelPartido.add(new JLabel(partidoLocal.getGoles() + " - " + partidoVisitante.getGoles()));
            panelPartido.add(new JLabel(partidoVisitante.getEquipo().getNombre()));

            panelContenedor.add(panelPartido);
        }
        return panelContenedor;
    }

    public static void crearVentanaPrueba() throws Exception {
        JFrame frame = new JFrame("vLogin");
        frame.setContentPane(buscarJornadasTemporada());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static String buscarNombre() {
        return usuario.getUsername();
    }

    public static String buscarAdmin() {
        return usuario.getAdmin().toString();
    }

    public static void registrarUsuario(String username, String email, String password, Usuario.tUsuario admin) throws Exception {
        usuario = new Usuario(username, email, password, admin);
        TUsuarios.insert(usuario);
    }

    public static String getPassAdm() throws Exception {
        Usuario usuarioAdm = TUsuarios.buscarPorUsername(new Usuario("ADMIN"));
        return usuarioAdm.getPassword();
    }

}