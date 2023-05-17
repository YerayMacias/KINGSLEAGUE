package Controlador;
import Modelo.ClasesBasesDatos.TJornadas;
import Modelo.ClasesBasesDatos.TTemporadas;
import Modelo.ClasesBasesDatos.*;
import Modelo.ClasesObjetos.*;


import Vista.*;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
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
    public static JFrame vPerfil;
    public static Usuario usuario;
    private static ArrayList<Jornada> listaJornadas;
    private static ArrayList<Equipo> listaEquipos;
    private static ArrayList<Integer> listaVictorias;
    private static ArrayList<Integer> listaDerrotas;
    private static ArrayList<Integer> listaPosicion;

    private static int posicion;
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
        /*try {
            buscarClasificacion();
            crearVentanaPrueba();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
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

    public static void crearVentanaClasificacion(String admin) throws Exception {
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

    public static void crearVentanaPerfil(String admin) {
        vPerfil = new JFrame("vPerfil");
        vPerfil.setContentPane(new vPerfil(admin).getpPrincipal());
        vPerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPerfil.pack();
        vPerfil.setVisible(true);
    }


    public static void validarUsuario(String nombre, String password) throws Exception {
        usuario = TUsuarios.buscarPorUsernamePassword(new Usuario(nombre, password));
        if (usuario != null){
            if (usuario.getAdmin().toString().equalsIgnoreCase("S")) Main.crearVentanaPrincipal("S");
            else Main.crearVentanaPrincipal("N");
        } else throw new Exception("El usuario o la contraseña son incorrectos");
    }

    public static void buscarJornadasTemporada() throws Exception {
        Jornada jornada = new Jornada();
        jornada.setTemporada(TTemporadas.buscarPorID(new Temporada(1)));
        listaJornadas = TJornadas.buscarPorTemporada(jornada);

        posicion = listaJornadas.size() -1;
    }

    public static JPanel crearPanelesJornadas() throws Exception {
        JLabel labelTitulo = new JLabel();
        JPanel panelPartido;
        JPanel panelContenedor = new JPanel(new GridLayout(7, 1));

        labelTitulo.setText("JORNADA " + String.valueOf(listaJornadas.get(posicion).getNumJornada()));
        labelTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        labelTitulo.setFont(new Font("Arial",1, 19));

        panelContenedor.add(labelTitulo);
        for (int y = 0; y < listaJornadas.get(posicion).getListaPartidos().size(); y++) {
            panelPartido = new JPanel(new GridLayout(1, 3));

            PartidoLocal partidoLocal = TPartidosLocales.buscarPorPartido(new PartidoLocal(listaJornadas.get(posicion).getListaPartidos().get(y)));

            PartidoVisitante partidoVisitante = TPartidosVisitantes.buscarPorPartido(new PartidoVisitante(listaJornadas.get(posicion).getListaPartidos().get(y)));

            panelPartido.add(new JLabel(partidoLocal.getEquipo().getNombre(), SwingConstants.CENTER));
            panelPartido.add(new JLabel(partidoLocal.getGoles() + " - " + partidoVisitante.getGoles(), SwingConstants.CENTER));
            panelPartido.add(new JLabel(partidoVisitante.getEquipo().getNombre(), SwingConstants.CENTER));

            panelContenedor.add(panelPartido);
        }
        return panelContenedor;
    }

    public static void crearVentanaPrueba() throws Exception {
        JFrame frame = new JFrame("vLogin");
        frame.setContentPane(crearPanelesClasificacion());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static ArrayList<String> rellenarComboJornadas(){
        ArrayList<String> itemsCombo = new ArrayList<>();
        listaJornadas.forEach(item -> itemsCombo.add("Jornada " + item.getNumJornada()));
        return itemsCombo;
    }

    public static void actualizarPosicion(int cBoxPosicion){
        posicion = cBoxPosicion;
    }

    public static void actualizarVPartidos(){
        SwingUtilities.updateComponentTreeUI(vPartidos);
    }
    public static String buscarNombre() {
        return usuario.getUsername();
    }

    public static String buscarAdmin() {
        return usuario.getAdmin().toString();
    }
    public static String buscarCorreo(){
        return usuario.getEmail();
    }

    public static void registrarUsuario(String username, String email, String password, Usuario.tUsuario admin) throws Exception {
        usuario = new Usuario(username, email, password, admin);
        TUsuarios.insert(usuario);
    }
    public static void updateUsuario(String username, String email, String password) throws Exception {
        usuario = TUsuarios.buscarPorUsername(new Usuario(username));
        usuario.setEmail(email);
        usuario.setPassword(password);
        TUsuarios.update(usuario);
    }

    public static String getPassAdm() throws Exception {
        Usuario usuarioAdm = TUsuarios.buscarPorUsername(new Usuario("ADMIN"));
        return usuarioAdm.getPassword();
    }

    public static String getPassUser(String usuario) throws Exception {
        Usuario user = TUsuarios.buscarPorUsername(new Usuario(usuario));
        return user.getPassword();
    }

    public static void buscarClasificacion() throws Exception {
        ArrayList<Object> listaArrays = TTemporadas.buscarClasificacion();
        listaEquipos = (ArrayList<Equipo>) listaArrays.get(0);
        listaVictorias = (ArrayList<Integer>) listaArrays.get(1);
        listaDerrotas = (ArrayList<Integer>) listaArrays.get(2);
        listaPosicion = (ArrayList<Integer>) listaArrays.get(3);
    }

    public static JPanel crearPanelesClasificacion(){
        GridLayout gridLayout = new GridLayout();
        gridLayout.setColumns(1);
        gridLayout.setRows(listaDerrotas.size() +1 );
        JPanel panelContenedor = new JPanel(gridLayout);
        JLabel label = new JLabel("CLASIFICACION KING'S LEAGUE", SwingConstants.CENTER);
        label.setFont(new Font("Arial", 1, 24));
        panelContenedor.add(label);
        for (int x = 0; x < listaEquipos.size(); x++) {
            JPanel panelPosicion = new JPanel(new GridLayout(1,4));
            panelPosicion.add(new JLabel(listaPosicion.get(x).toString()));
            panelPosicion.add(new JLabel(listaEquipos.get(x).getNombre()));
            panelPosicion.add(new JLabel(listaVictorias.get(x).toString(), SwingConstants.CENTER));
            panelPosicion.add(new JLabel(listaDerrotas.get(x).toString(), SwingConstants.CENTER));
            panelContenedor.add(panelPosicion);
        }
        return panelContenedor;
    }

    public static void buscarEquipos() throws Exception {
        listaEquipos = TEquipo.buscarTodos();
    }

    public static ArrayList<String> getNombreEquipos(){
        ArrayList<String> listaNombres = new ArrayList<>();
        listaEquipos.forEach(equipo -> listaNombres.add(equipo.getNombre()));
        return listaNombres;
    }

    public static ArrayList<URL> getURLImagen(){
        ArrayList<URL> listaURL = new ArrayList<>();
        listaEquipos.forEach(equipo -> listaURL.add(equipo.getUrl()));
        return listaURL;
    }
}