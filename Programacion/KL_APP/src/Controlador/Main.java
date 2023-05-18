package Controlador;
import Modelo.ClasesBasesDatos.TJornadas;
import Modelo.ClasesBasesDatos.TTemporadas;
import Modelo.ClasesBasesDatos.*;
import Modelo.ClasesObjetos.*;


import Modelo.ClasesBasesDatos.TPartido;
import Modelo.ClasesObjetos.Equipo;
import Modelo.ClasesObjetos.Jornada;
import Modelo.ClasesObjetos.Partido;
import Modelo.ClasesObjetos.Usuario;
import Modelo.ClasesBasesDatos.TJornadas;
import Modelo.ClasesBasesDatos.TPartido;
import Modelo.ClasesBasesDatos.TTemporadas;
import Modelo.ClasesBasesDatos.TUsuarios;
import Modelo.ClasesObjetos.*;
import Vista.*;
import Vista.CRUDEquipos.dActualizarEquipo;
import Vista.CRUDEquipos.dBorrarEquipo;
import Vista.CRUDEquipos.dBuscarEquipo;
import Vista.CRUDEquipos.dInsertarEquipo;
import Vista.CRUDJornada.dActualizarJornada;
import Vista.CRUDJornada.dBorrarJornada;
import Vista.CRUDJornada.dBuscarJornada;
import Vista.CRUDJornada.dInsertarJornada;
import Vista.CRUDJugadores.dBorrarJugadores;
import Vista.CRUDJugadores.dBuscarJugadores;
import Vista.CRUDJugadores.dInsertJugadores;
import Vista.CRUDJugadores.dActualizarJugadores;
import Vista.CRUDPresidentes.dActualizarPresidente;
import Vista.CRUDPresidentes.dBorrarPresidente;
import Vista.CRUDPresidentes.dBuscarPresidente;
import Vista.CRUDPresidentes.dInsertarPresidente;
import Vista.CRUDStaffs.dActualizarStaff;
import Vista.CRUDStaffs.dBorrarStaff;
import Vista.CRUDStaffs.dBuscarStaff;
import Vista.CRUDStaffs.dInsertarStaff;
import Vista.CRUDTemporadas.dActualizarTemporada;
import Vista.CRUDTemporadas.dBorrarTemporada;
import Vista.CRUDTemporadas.dBuscarTemporada;
import Vista.CRUDTemporadas.dInsertarTemporada;
import Vista.CRUDUsuario.dActualizarUsuario;
import Vista.CRUDUsuario.dBorrarUsuario;
import Vista.CRUDUsuario.dBuscarUsuarios;
import Vista.CRUDUsuario.dInsertarUsuario;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
    public static JFrame vEquiposJugadores;
    public static JDialog dInsertarJugadores;
    public static JDialog dBorrarJugadores;
    public static JDialog dUpdatearJugadores;
    public static JDialog dBuscarJugadores;
    public static JDialog dInsertarEquipo;
    public static JDialog dBuscarEquipo;
    public static JDialog dBorrarEquipo;
    public static JDialog dActualizarEquipo;
    public static JDialog dInsertarJornada;
    public static JDialog dBorrarJornada;
    public static JDialog dBuscarJornada;
    public static JDialog dActualizarJornada;
    public static JDialog dInsertarPresidentes;
    public static JDialog dBorrarPresidentes;
    public static JDialog dBuscarPresidentes;
    public static JDialog dActualizarPresidentes;
    public static JDialog dActualizarStaff;
    public static JDialog dBorrarStaff;
    public static JDialog dBuscarStaff;
    public static JDialog dInsertarStaff;
    public static JDialog dInsertarTemporada;
    public static JDialog dBuscarTemporada;
    public static JDialog dActualizarTemporada;
    public static JDialog dBorrarTemporada;
    public static JDialog dActualizarUsuario;
    public static JDialog dInsertarUsuario;
    public static JDialog dBorrarUsuario;
    public static JDialog dBuscarUsuarios;
    public static JDialog dEquiposJugadores;
    public static JFrame vPerfil;
    public static JFrame vPlayOffs;
    public static JFrame vAdminPanel;
    public static JFrame vEquipoJugadores;
    private static Usuario usuario;
    private static Jugador jugador;
    private static ArrayList<Jornada> listaJornadas;
    public static ArrayList<Equipo> listaEquipos;
    private static ArrayList<Integer> listaVictorias;
    private static ArrayList<Integer> listaDerrotas;
    private static ArrayList<Integer> listaGolesFavor;
    private static ArrayList<Integer> listaGolesContra;
    private static ArrayList<Integer> listaDiferenciaGoles;

    public static ArrayList<Integer> listaPosicion;

    private static ArrayList<Jugador> listaJugadores;
    private static ArrayList<Usuario> listaUsuarios;
    private static int numJugador;

    private static int posicion;
    public static void main(String[] args){

        // Test para probar conexion con la base de datos

        /*try {
            BaseDato.abrirConexion();
            PreparedStatement ps = BaseDato.getCon().prepareStatement("Select * from equipos");
            ResultSet resultado = ps.executeQuery();
            while (resultado.next())
                System.out.println(resultado.getString("nombre"));
            BaseDato.cerrarConexion();
        } catch (Exception e){
            BaseDato.cerrarConexion();
            System.out.println("Error " + e.getMessage());
        }*/

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

    public static void crearVentanaPanelAdmin (String admin) {
        vAdminPanel = new JFrame("vAdminPanel");
        vAdminPanel.setContentPane(new vAdminPanel(admin).getpPrincipal());
        vAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vAdminPanel.pack();
        vAdminPanel.setVisible(true);
    }



    public static void crearVentanaPlayOffs(String admin) throws Exception {
        vPlayOffs = new JFrame("vPlayOffs");
        vPlayOffs.setContentPane(new vPlayOffs(admin).getpPrincipal());
        vPlayOffs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPlayOffs.pack();
        vPlayOffs.setVisible(true);
    }

    public static void crearDialogoEquiposJugadores(){
        dEquiposJugadores = new dEquiposJugadores();
        dEquiposJugadores.pack();
        dEquiposJugadores.setVisible(true);
    }
   /* public static void crearVentanaEquiposJugadores(){
        vEquiposJugadores = new JFrame("vRegistro");
        vEquiposJugadores.setContentPane(new vEquiposJugadores);
        vEquiposJugadores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vEquiposJugadores.pack();
        vEquiposJugadores.setLocationRelativeTo(null);
        vEquiposJugadores.setVisible(true);
    } */


    public static void validarUsuario(String nombre, String password) throws Exception {
        usuario = TUsuarios.buscarPorUsernamePassword(new Usuario(nombre, password));
        if (usuario != null){
            if (usuario.getAdmin().toString().equalsIgnoreCase("S")) Main.crearVentanaPrincipal("S");
            else Main.crearVentanaPrincipal("N");
        } else throw new Exception("El usuario o la contraseña son incorrectos");
    }

    public static void buscarJornadasTemporada() throws Exception {
        Jornada jornada = new Jornada();
        jornada.setTemporada(TTemporadas.buscarUltimaTemporada());
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


            Partido partido = TPartido.buscarPorIDPartido(new Partido(listaJornadas.get(posicion).getListaPartidos().get(y).getID()));

            panelPartido.add(new JLabel(partido.getLocal().getNombre(), SwingConstants.CENTER));
            panelPartido.add(new JLabel(partido.getGolesLocal() + " - " + partido.getGolesVisitante(), SwingConstants.CENTER));
            panelPartido.add(new JLabel(partido.getVisitante().getNombre(), SwingConstants.CENTER));

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
    public static void updateUsuario(String username, String email) throws Exception {
        usuario = TUsuarios.buscarPorUsername(new Usuario(username));
        usuario.setEmail(email);
        TUsuarios.update(usuario);
    }

    public static void updateUsuarioPass(String username, String password) throws Exception {
        usuario = TUsuarios.buscarPorUsername(new Usuario(username));
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
        listaGolesFavor = (ArrayList<Integer>) listaArrays.get(3);
        listaGolesContra = (ArrayList<Integer>) listaArrays.get(4);
        listaDiferenciaGoles = (ArrayList<Integer>) listaArrays.get(5);
        listaPosicion = (ArrayList<Integer>) listaArrays.get(6);
    }

    public static JPanel crearPanelesClasificacion(){
        GridLayout gridLayout = new GridLayout();
        gridLayout.setColumns(1);
        gridLayout.setRows(listaDerrotas.size() +2 );
        JPanel panelContenedor = new JPanel(gridLayout);
        JLabel label = new JLabel("CLASIFICACION KING'S LEAGUE", SwingConstants.CENTER);
        label.setFont(new Font("Arial", 1, 24));
        panelContenedor.add(label);

        // Leyenda

        JPanel panelLeyenda = new JPanel(new GridLayout(1, 7));
        panelLeyenda.add(new JLabel("POS", SwingConstants.CENTER));
        panelLeyenda.add(new JLabel("EQ", SwingConstants.CENTER));
        panelLeyenda.add(new JLabel("PG", SwingConstants.CENTER));
        panelLeyenda.add(new JLabel("PP", SwingConstants.CENTER));
        panelLeyenda.add(new JLabel("GF", SwingConstants.CENTER));
        panelLeyenda.add(new JLabel("GC", SwingConstants.CENTER));
        panelLeyenda.add(new JLabel("DG", SwingConstants.CENTER));
        panelContenedor.add(panelLeyenda);

        for (int x = 0; x < listaEquipos.size(); x++) {
            JPanel panelPosicion = new JPanel(new GridLayout(1,7));
            panelPosicion.add(new JLabel(listaPosicion.get(x).toString(), SwingConstants.CENTER));
            panelPosicion.add(new JLabel(listaEquipos.get(x).getNombre()));
            panelPosicion.add(new JLabel(listaVictorias.get(x).toString(), SwingConstants.CENTER));
            panelPosicion.add(new JLabel(listaDerrotas.get(x).toString(), SwingConstants.CENTER));
            panelPosicion.add(new JLabel(listaGolesFavor.get(x).toString(), SwingConstants.CENTER));
            panelPosicion.add(new JLabel(listaGolesContra.get(x).toString(), SwingConstants.CENTER));
            panelPosicion.add(new JLabel(listaDiferenciaGoles.get(x).toString(), SwingConstants.CENTER));
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

    public static ArrayList<String> getColores(){
        ArrayList<String> listaColores = new ArrayList<>();
        listaEquipos.forEach(equipo -> listaColores.add(equipo.getColor()));
        return listaColores;
    }

    public static void insertJugador(String nombre, String apellido, String DNI, String posicion, String tipoJugador) throws Exception {
        jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setApellido(apellido);
        jugador.setDNI(DNI);
        jugador.setPosicion(Jugador.tPosicion.valueOf(posicion));
        jugador.setTipoJugador(Jugador.tTipoJugador.valueOf(tipoJugador));
        tJugadores.insert(jugador);
    }
    public static void crearVentanaInsertJugador(String admin) {
        dInsertarJugadores  = new dInsertJugadores();
        dInsertarJugadores.pack();
        dInsertarJugadores.setVisible(true);
    }

    public static void crearVentanaBorrarJugadores(String admin) {
        dBorrarJugadores  = new dBorrarJugadores();
        dBorrarJugadores.pack();
        dBorrarJugadores.setVisible(true);
    }

    public static void crearVentanaActualizarJugadores(String admin) {
        dUpdatearJugadores  = new dActualizarJugadores();
        dUpdatearJugadores.pack();
        dUpdatearJugadores.setVisible(true);
    }

    public static void crearVentanaBuscarjugadores(String admin) {
        dBuscarJugadores  = new dBuscarJugadores();
        dBuscarJugadores.pack();
        dBuscarJugadores.setVisible(true);
    }

    public static void crearVentanaInsertEquipo(String admin) {
        dInsertarEquipo  = new dInsertarEquipo();
        dInsertarEquipo.pack();
        dInsertarEquipo.setVisible(true);
    }

    public static void crearVentanaBorrarEquipo(String admin) {
        dBorrarEquipo  = new dBorrarEquipo();
        dBorrarEquipo.pack();
        dBorrarEquipo.setVisible(true);
    }

    public static void crearVentanaUpdateEquipo(String admin) {
        dActualizarEquipo  = new dActualizarEquipo();
        dActualizarEquipo.pack();
        dActualizarEquipo.setVisible(true);
    }

    public static void crearVentanaBuscarEquipo(String admin) {
        dBuscarEquipo = new dBuscarEquipo();
        dBuscarEquipo.pack();
        dBuscarEquipo.setVisible(true);
    }

    public static void crearVentanaInsertJornada (String admin) {
        dInsertarJornada  = new dInsertarJornada();
        dInsertarJornada.pack();
        dInsertarJornada.setVisible(true);
    }
    public static void crearVentanaBorrarJornada (String admin) {
        dBorrarJornada  = new dBorrarJornada();
        dBorrarJornada.pack();
        dBorrarJornada.setVisible(true);
    }
    public static void crearVentanaUpdateJornada (String admin) {
        dActualizarJornada  = new dActualizarJornada();
        dActualizarJornada.pack();
        dActualizarJornada.setVisible(true);
    }
    public static void crearVentanaBuscarJornada (String admin) {
        dBuscarJornada  = new dBuscarJornada();
        dBuscarJornada.pack();
        dBuscarJornada.setVisible(true);
    }

    public static void crearVentanaInsertarPresidente (String admin) {
        dInsertarPresidentes  = new dInsertarPresidente();
        dInsertarPresidentes.pack();
        dInsertarPresidentes.setVisible(true);
    }
    public static void crearVentanaBorrarPresidente (String admin) {
        dBorrarPresidentes = new dBorrarPresidente();
        dBorrarPresidentes.pack();
        dBorrarPresidentes.setVisible(true);
        System.exit(0);
    }
    public static void crearVentanaActualizarPresidente (String admin) {
        dActualizarPresidentes = new dActualizarPresidente();
        dActualizarPresidentes.pack();
        dActualizarPresidentes.setVisible(true);
        System.exit(0);
    }
    public static void crearVentanaBuscarPresidente (String admin) {
        dBuscarPresidentes = new dBuscarPresidente();
        dBuscarPresidentes.pack();
        dBuscarPresidentes.setVisible(true);
        System.exit(0);
    }

    public static void crearVentanaInsertStaff (String admin) {
        dInsertarStaff  = new dInsertarStaff();
        dInsertarStaff.pack();
        dInsertarStaff.setVisible(true);
        System.exit(0);
    }
    public static void crearVentanaBorrarStaff (String admin) {
        dBorrarStaff  = new dBorrarStaff();
        dBorrarStaff.pack();
        dBorrarStaff.setVisible(true);
        System.exit(0);
    }
    public static void crearVentanaActualizarStaff(String admin) {
        dActualizarStaff  = new dActualizarStaff();
        dActualizarStaff.pack();
        dActualizarStaff.setVisible(true);
        System.exit(0);
    }
    public static void crearVentanaBuscarStaff (String admin) {
        dBuscarStaff  = new dBuscarStaff();
        dBuscarStaff.pack();
        dBuscarStaff.setVisible(true);
        System.exit(0);
    }


    public static void crearVentanaInsertTemporada(String admin) {
        dInsertarTemporada  = new dInsertarTemporada();
        dInsertarTemporada.pack();
        dInsertarTemporada.setVisible(true);
        System.exit(0);
    }

    public static void crearVentanaBorrarTemporada(String admin) {
        dBorrarTemporada  = new dBorrarTemporada();
        dBorrarTemporada.pack();
        dBorrarTemporada.setVisible(true);
        System.exit(0);
    }

    public static void crearVentanaActualizarTemporada(String admin) {
        dActualizarTemporada  = new dActualizarTemporada();
        dActualizarTemporada.pack();
        dActualizarTemporada.setVisible(true);
        System.exit(0);
    }

    public static void crearVentanaBuscarTemporada(String admin) {
        dBuscarTemporada  = new dBuscarTemporada();
        dBuscarTemporada.pack();
        dBuscarTemporada.setVisible(true);
        System.exit(0);
    }

    public static void crearVentanaInsertUsuario(String admin) {
        dInsertarUsuario  = new dInsertarUsuario();
        dInsertarUsuario.pack();
        dInsertarUsuario.setVisible(true);
        System.exit(0);
    }

    public static void crearVentanaBorrarUsuario(String admin) {
        dBorrarUsuario  = new dBorrarUsuario();
        dBorrarUsuario.pack();
        dBorrarUsuario.setVisible(true);
        System.exit(0);
    }

    public static void crearVentanaActualizarUsuario(String admin) {
        dActualizarUsuario  = new dActualizarUsuario();
        dActualizarUsuario.pack();
        dActualizarUsuario.setVisible(true);
        System.exit(0);
    }

    public static void crearVentanaBuscarUsuarios(String admin) {
        dBuscarUsuarios = new dBuscarUsuarios();
        dBuscarUsuarios.pack();
        dBuscarUsuarios.setVisible(true);
        System.exit(0);
    }

    public static int borrarJugador(String DNI) throws Exception {
        jugador = new Jugador();
        jugador.setDNI(DNI);
        return tJugadores.delete(jugador);
    }

    public static void actualizarJugador(String nombre, String apellido, String DNI, String posicion, String tipoJugador) throws Exception {
        jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setApellido(apellido);
        jugador.setDNI(DNI);
        jugador.setPosicion(Jugador.tPosicion.valueOf(posicion));
        jugador.setTipoJugador(Jugador.tTipoJugador.valueOf(tipoJugador));
        tJugadores.update(jugador);
    }

    public static String buscarTodosJugadores() throws Exception {
        ArrayList<Jugador> listaJugadores = tJugadores.buscarTodos();
        String datos = "";
        for (int x = 0 ; x < listaJugadores.size();x++) {
                datos += "ID_JUGADOR"  + listaJugadores.get(x).getID() + ":" + "\n"+ "\n Nombre: " + listaJugadores.get(x).getNombre() + "\n Apellido: " + listaJugadores.get(x).getApellido()
                        + "\n DNI: " + listaJugadores.get(x).getDNI() + "\n Posicion: " + listaJugadores.get(x).getPosicion() + "\n TipoDeJugador: " + listaJugadores.get(x).getTipoJugador() + "\n" +"\n";
        }
        return datos;
    }
    public static String buscarTodosLosJugadorPorID(String id_jugador) throws Exception {
        jugador = new Jugador();
        jugador.setID(Integer.parseInt(id_jugador));
        String datos = "";
        jugador = tJugadores.buscarPorID(jugador);
        datos += "ID_JUGADOR" + jugador.getID() + "\n Nombre: " + jugador.getNombre() + "\n" + jugador.getApellido() + "\n Apellido: " + jugador.getApellido()
                + "\n DNI: " + jugador.getDNI() + "\n Posicion: " + jugador.getPosicion() + "\n TipoDeJugador: " + jugador.getTipoJugador();
        return datos;
    }

    public static String buscarTodosLosJugadorPorDNI(String dni) throws Exception {
        jugador = new Jugador();
        jugador.setDNI(dni);
        String datos = "";
        jugador = tJugadores.buscarPorDNI(jugador);
        datos += "ID_JUGADOR" + jugador.getID() + "\n Nombre: " + jugador.getNombre() + "\n" + jugador.getApellido() + "\n Apellido: " + jugador.getApellido()
                + "\n DNI: " + jugador.getDNI() + "\n Posicion: " + jugador.getPosicion() + "\n TipoDeJugador: " + jugador.getTipoJugador();
        return datos;
    }


    public static void insertarJornada(int id_temporada, int num_jornada, String fecha) throws Exception {
        Jornada jornada = new Jornada(num_jornada,LocalDate.parse(fecha));
        jornada.setFecha(LocalDate.parse(fecha));
        Temporada temporada = TTemporadas.buscarPorID(new Temporada(id_temporada));
        jornada.setTemporada(temporada);
        TJornadas.insert(jornada);
    }

    public static int borrarJornada(int id_jornada) throws Exception {
        Jornada jornada = new Jornada();
        jornada.setID(id_jornada);
        return TJornadas.delete(jornada);
    }

    public static void actualizarJornada(int id_temporada, int num_jornada, String fecha) throws SQLException {
        Jornada jornada = new Jornada();
        jornada.setTemporada(new Temporada(id_temporada));
        jornada.setNumJornada(num_jornada);
        jornada.setFecha(LocalDate.parse(fecha));
        TJornadas.update(jornada);
    }

    public static String buscarTodasLasJornadas() throws Exception {
        ArrayList<Jornada> listaJornadas = TJornadas.buscarTodo();
        String datos = "";
        for (int x = 0 ; x < listaJornadas.size();x++) {
            datos += "\n ID_JORNADA" + listaJornadas.get(x).getID() + "\n\nTemporada: " + listaJornadas.get(x).getTemporada().getID() + "\nNºJornada: " + listaJornadas.get(x).getNumJornada() + "\nFecha: " + listaJornadas.get(x).getFecha() + "\n";
        }
        return datos;
    }

    public static void crearVentanaEquipoJugadores(String equipo) throws Exception {
        datosSeleccionarJugadorEquipo(equipo);
        vEquipoJugadores = new JFrame("vEquipoJugadores");
        vEquipoJugadores.setContentPane(new vEquipoJugadores(equipo).getpPrincipal());
        vEquipoJugadores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vEquipoJugadores.pack();
        vEquipoJugadores.setVisible(true);
    }

    public static void datosSeleccionarJugadorEquipo(String equipo) throws Exception {
        Equipo equipo2 = new Equipo();
        equipo2.setNombre(equipo);
        Equipo equipo1 = TEquipo.buscarPorNombre(equipo2);
        listaJugadores = tJugadores.buscarPorEquipo(equipo1);
    }

    public static String getNombreSelect() {
        return listaJugadores.get(contadorJugador()).getNombre();
    }

    public static String getApellidoSelect() {
        return listaJugadores.get(contadorJugador()).getApellido();
    }

    public static String getPosicionSelect() {
        return String.valueOf(listaJugadores.get(contadorJugador()).getPosicion());
    }

    public static String getTipoJugadorSelect() {
        return String.valueOf(listaJugadores.get(contadorJugador()).getTipoJugador());
    }

    public static int contadorJugador() {
        return numJugador;
    }

    public static int siguienteJugador() {
        return numJugador = numJugador + 1;
    }

    public static int posteriorJugador() {
        return numJugador = numJugador - 1;
    }

    public static int primerJugador() {
        return numJugador = 0;
    }

    public static int ultimoJugador() {
        return numJugador = 9;
    }

    // COMBOBOX BUSCAR JUGADORES **************************************
    public static ArrayList<String> crearIdJugadores() throws Exception {
        listaJugadores = tJugadores.buscarTodos();
        ArrayList<String> listaIdJugadores = new ArrayList<>();
        listaJugadores.forEach(jugador1 -> listaIdJugadores.add(String.valueOf(jugador1.getID())));
        return listaIdJugadores;
    }

    public static ArrayList<String> crearDniJugadores() throws Exception {
        listaJugadores = tJugadores.buscarTodos();
        ArrayList<String> listaDNIJugadores = new ArrayList<>();
        listaJugadores.forEach(jugador1 -> listaDNIJugadores.add(jugador1.getDNI()));
        return listaDNIJugadores;
    }

    public static ArrayList<String> crearFechaJornadas() throws Exception {
        listaJornadas = TJornadas.buscarTodo();
        ArrayList<String> listaFechaJornadas = new ArrayList<>();
        listaJornadas.forEach(jornada -> listaFechaJornadas.add(String.valueOf(jornada.getFecha())));
        return listaFechaJornadas;
    }

    public static ArrayList<String> crearIdJornada() throws Exception {
        listaJornadas = TJornadas.buscarTodo();
        ArrayList<String> listaJornadasID = new ArrayList<>();
        listaJornadas.forEach(jornada -> listaJornadasID.add(String.valueOf(jornada.getID())));
        return listaJornadasID;
    }

    public static ArrayList<String> crearUsuarios() throws Exception {
        listaUsuarios = TUsuarios.buscarTodo();
        ArrayList<String> listaUsuariosUser = new ArrayList<>();
        listaUsuarios.forEach(user -> listaUsuariosUser.add(user.getUsername()));
        return listaUsuariosUser;
    }

    public static int obtenerGanador(Partido partido) {
        if (partido.getGolesLocal() > partido.getGolesVisitante()) {
            return 1;
        } else if (partido.getGolesLocal() < partido.getGolesVisitante()) {
            return 2;
        }
        return 0;
    }

    public static String buscarJornadaFecha(String fecha) throws Exception {
        Jornada jornada = new Jornada();
        jornada.setFecha(LocalDate.parse(fecha));
        String datos = "";
        jornada = TJornadas.buscarPorFecha(jornada);
        datos += "ID_JORNADA" + jornada.getID() + "\n ID_TEMPORADA: " + jornada.getTemporada().getID() + "\n" + jornada.getNumJornada() + "\n Fecha: " + jornada.getFecha();
        return datos;
    }

    public static String buscarJornadaID(String ID) throws Exception {
        Jornada jornada = new Jornada();
        jornada.setID(Integer.parseInt(ID));
        String datos = "";
        jornada = TJornadas.buscarPorID(jornada);
        datos += "ID_JORNADA" + jornada.getID() + "\n ID_TEMPORADA: " + jornada.getTemporada().getID() + "\n" + jornada.getNumJornada() + "\n Fecha: " + jornada.getFecha();
        return datos;
    }

    public static void insertarUsuario(String id_usuario, String email, String username, String password,String tipo_usuario) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setID(Integer.parseInt(id_usuario));
        usuario.setEmail(email);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setAdmin(Usuario.tUsuario.valueOf(tipo_usuario));
        TUsuarios.insert(usuario);

    }

    public static void actualizarUsuario(String id_usuario, String email, String username, String password,String tipo_usuario) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setID(Integer.parseInt(id_usuario));
        usuario.setEmail(email);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setAdmin(Usuario.tUsuario.valueOf(tipo_usuario));
        TUsuarios.update(usuario);
    }

    public static int borrarUsuario(String username) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        return TUsuarios.delete(usuario);
    }

    public static String buscarTodosUsuarios() throws Exception {
        ArrayList<Usuario> listaUsuarios = TUsuarios.buscarTodo();
        String datos = "";
        for (int x = 0 ; x < listaUsuarios.size();x++) {
            datos += "\n ID_USUARIO" + listaUsuarios.get(x).getID() + "\n\nUsername: " + listaUsuarios.get(x).getUsername()+ "\nEmail: " + listaUsuarios.get(x).getEmail() + "\nPassword: " + listaUsuarios.get(x).getPassword()
                    + "\n ADMIN" + listaUsuarios.get(x).getAdmin();
        }
        return datos;
    }

    public static String buscarTodosUsuariosPorUser(String user) throws Exception {
        Usuario username = new Usuario();
        username.setUsername(user);
        String datos = "";
        username = TUsuarios.buscarPorUsername(username);
        datos += "ID_USUARIO" + username.getID() + "\n EMAIL: " + usuario.getEmail() + "\n Usuario" + username.getUsername() + "\n Password: " + usuario.getPassword()
        + "\n USERNAME" + username.getUsername() + "\n ADMIN" + username.getAdmin();
        return datos;
    }

   /* public static String buscarTodasLasJornadasPorTemporada(String temporada) throws Exception {
        Jornada jornada = new Jornada();
        ArrayList<Jugador> listaJornadas = TJornadas.buscarPorTemporada();
        String datos = "";
        for (int x = 0 ; x < listaJornadas.size();x++) {
            datos += "ID_JUGADOR"  + listaJugadores.get(x).getID() + ":" + "\n"+ "\n Nombre: " + listaJugadores.get(x).getNombre() + "\n Apellido: " + listaJugadores.get(x).getApellido()
                    + "\n DNI: " + listaJugadores.get(x).getDNI() + "\n Posicion: " + listaJugadores.get(x).getPosicion() + "\n TipoDeJugador: " + listaJugadores.get(x).getTipoJugador() + "\n" +"\n";
        }
        return datos;
    } */
}