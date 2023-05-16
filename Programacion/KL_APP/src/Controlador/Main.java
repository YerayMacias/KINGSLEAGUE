package Controlador;
import Modelo.ClasesBasesDatos.TJornadas;
import Modelo.ClasesBasesDatos.TTemporadas;
import Modelo.ClasesObjetos.*;
import Vista.*;

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
    public static JFrame vRegistro;
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
        usuario = Modelo.ClaseObjetos.TUsuarios.buscarPorUsernamePassword(new Usuario(nombre, password));
        if (usuario != null){
            if (usuario.getAdmin().toString().equalsIgnoreCase("S")) Main.crearVentanaPrincipal("S");
            else Main.crearVentanaPrincipal("N");
        } else throw new Exception("El usuario o la contraseña son incorrectos");
    }

    public static void buscarJornadasTemporada() throws Exception {
        Jornada jornada = new Jornada();
        jornada.setTemporada(TTemporadas.buscarPorID(new Temporada(1)));
        ArrayList<Jornada> listaJornadas = TJornadas.buscarPorTemporada(jornada);
        crearPanelesJornadas(listaJornadas);
    }

    public static void crearPanelesJornadas(ArrayList<Jornada> listaJornadas){
        JLabel labelTitulo = new JLabel();
        JPanel panelPartido;
        JPanel panelContenedor = new JPanel(new GridLayout(7, 1));
        for (int x = 0; x < listaJornadas.size(); x++) {
            labelTitulo.setText("JORNADA " + String.valueOf(listaJornadas.get(x).getNumJornada()));
            for (int y = 0; y < listaJornadas.get(x).getListaPartidos().size(); y++) {
                panelPartido = new JPanel(new GridLayout(1, 3));
                panelPartido.add(new JLabel(TPartidosLocales.buscarPorPartido()));
            }
        }
    }

    public static String buscarNombre() {
        return usuario.getUsername();
    }

    public static String buscarAdmin() {
        return usuario.getAdmin().toString();
    }

    public static void registrarUsuario(String username, String email, String password, Usuario.tUsuario admin) throws Exception {
        // Insertar
        usuario = new Usuario(username, email, password, admin);
        // .add
        TUsuarios.insert(usuario);
    }
}