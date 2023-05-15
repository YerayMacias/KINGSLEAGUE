package Controlador;

import Modelo.*;
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
        vClasificacion.setLocationRelativeTo(null);
        vClasificacion.pack();
        vClasificacion.setVisible(true);
    }

    public static void crearVentanaEquipos(String admin) {
        vEquipos = new JFrame("vEquipos");
        vEquipos.setContentPane(new vEquipos(admin).getpPrincipal());
        vEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vEquipos.setLocationRelativeTo(null);
        vEquipos.pack();
        vEquipos.setVisible(true);
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

    public static String buscarNombre() {
        return usuario.getUsername();
    }

    public static String buscarAdmin() {
        return usuario.getAdmin();
    }

    public static void crearPanelesJornadas(ArrayList<Partido> listaPartidos, ArrayList<Jornada> listaJornadas, ArrayList<Equipo> listaEquiposLocales, ArrayList<Equipo> listaEquiposVisitantes, ArrayList<Integer> listaGolesLocales, ArrayList<Integer> listaGolesVisitante){
        GridLayout grid = new GridLayout(7,1);
        JPanel panelJornada = new JPanel(grid);
        JPanel panelPartido = new JPanel(new GridLayout(1, 3));
        ArrayList<JPanel> panelesPartidos = new ArrayList<>();
        JLabel labelTitulo = new JLabel();
        JLabel labelNombreEquipoLocal = new JLabel();
        JLabel labelNombreEquipoVisitante = new JLabel();
        JLabel labelResultado = new JLabel();
        ArrayList<Integer> partidoJornadaPosicion = new ArrayList<>();
        int z = 0;
        for (int x = 0; x < listaPartidos.size(); x++) {
            labelTitulo.setText("JORNADA " + String.valueOf(listaJornadas.get(x).getNumJornada()));
            while (partidoJornadaPosicion.size() < 7){
                if (listaPartidos.get(z).getJornada().getID() == listaJornadas.get(x).getID()){
                    partidoJornadaPosicion.add(z);
                }
            }
            panelJornada.add(labelTitulo);
            for (int a = 0; a < partidoJornadaPosicion.size(); a++) {
                labelNombreEquipoLocal.setText(listaEquiposLocales.get(partidoJornadaPosicion.get(a)).getNombre());
                labelNombreEquipoVisitante.setText(listaEquiposVisitantes.get(partidoJornadaPosicion.get(a)).getNombre());
                labelResultado.setText(listaGolesLocales.get(z) + "-" + listaGolesVisitante.get(z));
                panelPartido.add(labelNombreEquipoLocal);
                panelPartido.add(labelResultado);
                panelPartido.add(labelNombreEquipoVisitante);
                panelJornada.add(panelPartido);
            }
            panelPartido.add(panelJornada);
        }
    }
}