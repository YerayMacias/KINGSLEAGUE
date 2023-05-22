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
import Modelo.ClasesBasesDatos.TUsuarios;
import Vista.*;
import Vista.CRUDEquipos.dActualizarEquipo;
import Vista.CRUDEquipos.dBorrarEquipo;
import Vista.CRUDEquipos.dBuscarEquipo;
import Vista.CRUDEquipos.dInsertarEquipo;
import Vista.CRUDEquiposJugadores.dActualizarEquiposJugadores;
import Vista.CRUDEquiposJugadores.dBorrarEquiposJugadores;
import Vista.CRUDEquiposJugadores.dBuscarEquiposJugadores;
import Vista.CRUDEquiposJugadores.dInsertarEquiposJugadores;
import Vista.CRUDEquiposStaff.dActualizarEquiposStaff;
import Vista.CRUDEquiposStaff.dBorrarEquiposStaff;
import Vista.CRUDEquiposStaff.dBuscarEquiposStaff;
import Vista.CRUDEquiposStaff.dInsertarEquiposStaff;
import Vista.CRUDJornada.dActualizarJornada;
import Vista.CRUDJornada.dBorrarJornada;
import Vista.CRUDJornada.dBuscarJornada;
import Vista.CRUDJornada.dInsertarJornada;
import Vista.CRUDJugadores.dBorrarJugadores;
import Vista.CRUDJugadores.dBuscarJugadores;
import Vista.CRUDJugadores.dInsertJugadores;
import Vista.CRUDJugadores.dActualizarJugadores;
import Vista.CRUDPartidos.dActualizarPartidos;
import Vista.CRUDPartidos.dBorrarPartidos;
import Vista.CRUDPartidos.dBuscarPartidos;
import Vista.CRUDPartidos.dInsertPartidos;
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
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class Main {
    /**
     * Variable global para la ventana Principal
     */
    public static JFrame vPrincipal;
    /**
     * Variable global para la ventana de Login
     */
    public static JFrame vLogin;
    /**
     * Variable global para la ventana de Registro
     */
    public static JFrame vRegistro;
    /**
     * Variable global para la ventana de Equipos
     */
    public static JFrame vEquipos;
    /**
     * Variable global para la ventana de Clasificacion
     */
    public static JFrame vClasificacion;
    /**
     * Variable global para la ventana de Partidos
     */
    public static JFrame vPartidos;
    /**
     * Variable global para la ventana de Equipos y Jugadores
     */
    public static JFrame vEquiposJugadores;
    /**
     * Variable global para el cuadro de diálogo de Insertar Jugadores
     */
    public static JDialog dInsertarJugadores;
    /**
     * Variable global para el cuadro de diálogo de Borrar Jugadores
     */
    public static JDialog dBorrarJugadores;
    /**
     * Variable global para el cuadro de diálogo de Modificar Jugadores
     */
    public static JDialog dUpdatearJugadores;
    /**
     * Variable global para el cuadro de diálogo de Buscar Jugadores
     */
    public static JDialog dBuscarJugadores;
    /**
     * Variable global para el cuadro de diálogo de Insertar Equipo
     */
    public static JDialog dInsertarEquipo;
    /**
     * Variable global para el cuadro de diálogo de Buscar Equipo
     */
    public static JDialog dBuscarEquipo;
    /**
     * Variable global para el cuadro de diálogo de Borrar Equipo
     */
    public static JDialog dBorrarEquipo;
    /**
     * Variable global para el cuadro de diálogo de Buscar Staff
     */
    public static JDialog dBuscarEquiposStaff;
    /**
     * Variable global para el cuadro de diálogo de Modificar Equipo
     */
    public static JDialog dActualizarEquipo;
    /**
     * Variable global para el cuadro de diálogo de Insertar Jornada
     */
    public static JDialog dInsertarJornada;
    /**
     * Variable global para el cuadro de diálogo de Borrar Jornada
     */
    public static JDialog dBorrarJornada;
    /**
     * Variable global para el cuadro de diálogo de Buscar Jornada
     */
    public static JDialog dBuscarJornada;
    /**
     * Variable global para el cuadro de diálogo de Borrar Equipos Jugadores
     */
    public static JDialog dBorrarEquiposJugadores;
    /**
     * Variable global para el cuadro de diálogo de Modificar Jornada
     */
    public static JDialog dActualizarJornada;
    /**
     * Variable global para el cuadro de diálogo de Insertar Presindetes
     */
    public static JDialog dInsertarPresidentes;
    /**
     * Variable global para el cuadro de diálogo de Borrar Presidentes
     */
    public static JDialog dBorrarPresidentes;
    /**
     * Variable global para el cuadro de diálogo de Buscar Presidentes
     */
    public static JDialog dBuscarPresidentes;
    /**
     * Variable global para el cuadro de diálogo de Modificar Presidentes
     */
    public static JDialog dActualizarPresidentes;
    /**
     * Variable global para el cuadro de diálogo de Insertar EquiposJugadores
     */
    public static JDialog dInsertarEquiposJugadores;
    /**
     * Variable global para el cuadro de diálogo de Modificar Staffs
     */
    public static JDialog dActualizarStaff;
    /**
     * Variable global para el cuadro de diálogo de Borrar Staffs
     */
    public static JDialog dBorrarStaff;
    /**
     * Variable global para el cuadro de diálogo de Buscar Staff
     */
    public static JDialog dBuscarStaff;
    /**
     * Variable global para el cuadro de diálogo de Insertar Staff
     */
    public static JDialog dInsertarStaff;
    /**
     * Variable global para la ventana Principal
     */
    public static JDialog dInsertarTemporada;
    /**
     * Variable global para el cuadro de diálogo de Insertar Temporada
     */
    public static JDialog dBuscarTemporada;
    /**
     * Variable global para el cuadro de diálogo de Buscar Temporada
     */
    public static JDialog dActualizarTemporada;
    /**
     * Variable global para el cuadro de diálogo de Modificar Temporada
     */
    public static JDialog dBorrarTemporada;
    /**
     * Variable global para el cuadro de diálogo de Modificar Usuario
     */
    public static JDialog dActualizarUsuario;
    /**
     * Variable global para el cuadro de diálogo de Insertar Usuario
     */
    public static JDialog dInsertarUsuario;
    /**
     * Variable global para el cuadro de diálogo de Borrar Usuario
     */
    public static JDialog dBorrarUsuario;
    /**
     * Variable global para el cuadro de diálogo de Modificar StaffEquipo
     */
    public static JDialog dActualizarEquiposStaff;
    /**
     * Variable global para el cuadro de diálogo de Buscar Usuario
     */
    public static JDialog dBuscarUsuarios;
    /**
     * Variable global para el cuadro de diálogo de Modificar EquiposJugadores
     */
    public static JDialog dActualizarEquiposJugadores;
    /**
     * Variable global para el cuadro de diálogo de Buscar EquiposJugadores
     */
    public static JDialog dBuscarEquiposJugadores;
    /**
     * Variable global para el cuadro de diálogo de Borrar EquiposStaff
     */
    public static JDialog dBorrarEquiposStaff;
    /**
     * Variable global para el cuadro de diálogo de Insertar EquipoStaff
     */
    public static JDialog dInsertarEquiposStaff;
    /**
     * Variable global para el cuadro de diálogo de Modificar Partido
     */
    public static JDialog dActualizarPartido;
    /**
     * Variable global para el cuadro de diálogo de Buscar Partidos
     */
    public static JDialog dBuscarPartidos;
    /**
     * Variable global para el cuadro de diálogo de Insertar Partidos
     */
    public static JDialog dInsertarPartido;
    /**
     * Variable global para el cuadro de diálogo de Borrar Partidos
     */
    public static JDialog dBorrarPartidos;
    /**
     * Variable global para el cuadro de diálogo de los informes
     */
    public static JDialog dInformes;
    /**
     * Variable global para la ventana del Prefil
     */
    public static JFrame vPerfil;
    /**
     * Variable global para la ventana de PlayOffs
     */
    public static JFrame vPlayOffs;
    /**
     * Variable global para la ventana del Panel de Administrador
     */
    public static JFrame vAdminPanel;
    /**
     * Variable global para la ventana de Equpos Jugadores
     */
    public static JFrame vEquipoJugadores;
    /**
     * Variable global de usuario
     */
    private static Usuario usuario;
    /**
     * Variable global de jugador
     */
    private static Jugador jugador;
    /**
     * Variable global de equipo
     */
    private static Equipo equipo;
    /**
     * Variable global de partido
     */
    private static Partido partido;
    /**
     * Variable global de presidente
     */
    private static Presidente presidente;
    /**
     * Variable global de staff
     */
    private static Staff staff;
    /**
     * Array global de jornadas
     */
    private static ArrayList<Jornada> listaJornadas;
    /**
     * Array global de partidos
     */
    private static ArrayList<Partido> listaPartidos;
    /**
     * Array global de jornadas equipos
     */
    public static ArrayList<Equipo> listaEquipos;
    /**
     * Array global de victorias
     */
    private static ArrayList<Integer> listaVictorias;
    /**
     * Array global de derrotas
     */
    private static ArrayList<Integer> listaDerrotas;
    /**
     * Array global de goles a favor
     */
    private static ArrayList<Integer> listaGolesFavor;
    /**
     * Array global de goles en contra
     */
    private static ArrayList<Integer> listaGolesContra;
    /**
     * Array global de diferencia de goles
     */
    private static ArrayList<Integer> listaDiferenciaGoles;
    /**
     * Array global de la posicion en la clasificacion
     */

    public static ArrayList<Integer> listaPosicion;
    /**
     * Array global de jugadores
     */

    private static ArrayList<Jugador> listaJugadores;
    /**
     * Array global de presidentes
     */
    private static ArrayList<Presidente> listaPresidente;
    /**
     * Array global de staffs
     */
    private static ArrayList<Staff> listaStaffs;
    /**
     * Variable global para la ventana Principal
     */
    private static ArrayList<Usuario> listaUsuarios;
    /**
     * Array global de usuarios
     */
    private static ArrayList<StaffEquipo> listaStaffEquipo;
    /**
     * Array global de temporadas
     */
    private static ArrayList<Temporada> listaTemporada;
    /**
     * Array global de staff
     */
    private static ArrayList<Staff> listaStaff;
    /**
     * Variable global el número de jugadores
     */
    private static int numJugador;
    /**
     * Variable global para la posicion de los arrys
     */

    private static int posicion;
    /**
     * Variable global de XML
     */
    private static XML xml;

    /**
     * Inicio del programa
     * Llamado a metodo de crearVentanaLogin
     * @param args
     */
    public static void main(String[] args) {
        crearVentanaLogin();
    }

    /**
     * Para crear la ventana de login
     */
    public static void crearVentanaLogin() {
        vLogin = new JFrame("vLogin");
        vLogin.setContentPane(new vLogin().getpPrincipal());
        vLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vLogin.pack();
        vLogin.setSize(830, 480);
        vLogin.setLocationRelativeTo(null);
        vLogin.setVisible(true);
    }
    /**
     * Para crear la ventana de registro
     */
    public static void crearVentanaRegistro() {
        vRegistro = new JFrame("vRegistro");
        vRegistro.setContentPane(new vRegistro().getpPrincipal());
        vRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vRegistro.pack();
        vRegistro.setSize(830, 680);
        vRegistro.setLocationRelativeTo(null);
        vRegistro.setVisible(true);
    }
    /**
     * Para crear la ventana que sale despues de iniciar sesion
     * @param admin Para saber si el usuario logueado es admin
     */
    public static void crearVentanaPrincipal(String admin) {
        vLogin.dispose();
        vPrincipal = new JFrame("vPrincipal");
        vPrincipal.setContentPane(new vPrincipal(admin).getpPrincipal());
        vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPrincipal.pack();
        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.setVisible(true);
    }
    /**
     * Para crear la ventana que de los partidos
     * @param admin Para saber si el usuario logueado es admin
     */
    public static void crearVentanaPartidos(String admin) {
        vPartidos = new JFrame("vPartidos");
        vPartidos.setContentPane(new vPartidos(admin).getpPrincipal());
        vPartidos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPartidos.pack();
        vPartidos.setLocationRelativeTo(null);
        vPartidos.setVisible(true);
    }

    /**
     * Para crear la ventana de la clasificación
     * @param admin Para saber si el usuario logueado es admin
     * @throws Exception
     */
    public static void crearVentanaClasificacion(String admin) throws Exception {
        vClasificacion = new JFrame("vClasificacion");
        vClasificacion.setContentPane(new vClasificacion(admin).getpPrincipal());
        vClasificacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vClasificacion.pack();
        vClasificacion.setLocationRelativeTo(null);
        vClasificacion.setVisible(true);
    }

    /**
     * Para crear la ventana de todos los equipos
     * @param admin Para saber si el usuario logueado es admin
     */
    public static void crearVentanaEquipos(String admin) {
        vEquipos = new JFrame("vEquipos");
        vEquipos.setContentPane(new vEquipos(admin).getpPrincipal());
        vEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vEquipos.pack();
        vEquipos.setLocationRelativeTo(null);
        vEquipos.setVisible(true);
    }

    /**
     * Para crear la ventana del perfil del usuario
     * @param admin Para saber si el usuario logueado es admin
     */
    public static void crearVentanaPerfil(String admin) {
        vPerfil = new JFrame("vPerfil");
        vPerfil.setContentPane(new vPerfil(admin).getpPrincipal());
        vPerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPerfil.pack();
        vPerfil.setVisible(true);
    }

    /**
     * Para crear la ventana del panel de administracion
     * @param admin
     */
    public static void crearVentanaPanelAdmin(String admin) {
        vAdminPanel = new JFrame("vAdminPanel");
        vAdminPanel.setContentPane(new vAdminPanel(admin).getpPrincipal());
        vAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vAdminPanel.pack();
        vAdminPanel.setLocationRelativeTo(null);
        vAdminPanel.setVisible(true);
    }

    /**
     * Para crear la ventana de los playoffs
     * @param admin Para saber si el usuario logueado es admin
     * @throws Exception
     */
    public static void crearVentanaPlayOffs(String admin) throws Exception {
        vPlayOffs = new JFrame("vPlayOffs");
        vPlayOffs.setContentPane(new vPlayOffs(admin).getpPrincipal());
        vPlayOffs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPlayOffs.pack();
        vPlayOffs.setVisible(true);
    }

    /**
     * Para validar un usuario al loguearse
     * @param nombre
     * @param password
     * @throws Exception
     */
    public static void validarUsuario(String nombre, String password) throws Exception {
        usuario = TUsuarios.buscarPorUsernamePassword(new Usuario(nombre, password));
        if (usuario != null) {
            if (usuario.getAdmin().toString().equalsIgnoreCase("S")) Main.crearVentanaPrincipal("S");
            else Main.crearVentanaPrincipal("N");
        } else throw new Exception("El usuario o la contraseña son incorrectos");
    }

    /**
     * Para buscar todas las jornadas de la temporada
     * Llamado a la base de datos
     * @throws Exception
     */
    public static void buscarJornadasTemporada() throws Exception {
        Jornada jornada = new Jornada();
        jornada.setTemporada(TTemporadas.buscarUltimaTemporada());
        listaJornadas = TJornadas.buscarPorTemporada(jornada);
        posicion = listaJornadas.size() - 1;
    }

    /**
     * Para la creacion de los paneles para la ventana de los partidos
     * @return Panel que tiene todos los paneles generados
     * @throws Exception
     */
    public static JPanel crearPanelesJornadas() throws Exception {
        JLabel labelTitulo = new JLabel();
        JPanel panelPartido;
        JPanel panelContenedor = new JPanel(new GridLayout(7, 1));

        labelTitulo.setText("JORNADA " + String.valueOf(listaJornadas.get(posicion).getNumJornada()));
        labelTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        labelTitulo.setFont(new Font("Arial", 1, 19));

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

    /**
     * Para rellenar una comboBox de la ventana de partidos
     * @return ArrayList con el string de Jornada más el numero de jornada
     */
    public static ArrayList<String> rellenarComboJornadas() {
        ArrayList<String> itemsCombo = new ArrayList<>();
        listaJornadas.forEach(item -> itemsCombo.add("Jornada " + item.getNumJornada()));
        return itemsCombo;
    }

    /**
     * Para actualizar la posicion a la hora de crear los paneles de para la ventana de partidos
     * @param cBoxPosicion Posicion selecciona en la comboBox
     */
    public static void actualizarPosicion(int cBoxPosicion) {
        posicion = cBoxPosicion;
    }

    /**
     * Para recargar o refrescar la ventana de los partidos
     */
    public static void actualizarVPartidos() {
        SwingUtilities.updateComponentTreeUI(vPartidos);
    }

    /**
     * Para devolver el nombre del usuario
     * @return
     */
    public static String buscarNombre() {
        return usuario.getUsername();
    }

    /**
     * Para devolver el tipo de usuario
     * @return
     */
    public static String buscarAdmin() {
        return usuario.getAdmin().toString();
    }

    /**
     * Para devolver el correo de usuario
     * @return
     */
    public static String buscarCorreo() {
        return usuario.getEmail();
    }

    /**
     * Para registrar un usuario nuevo
     * @param username
     * @param email
     * @param password
     * @param admin
     * @throws Exception
     */
    public static void registrarUsuario(String username, String email, String password, Usuario.tUsuario admin) throws Exception {
        usuario = new Usuario(username, email, password, admin);
        TUsuarios.insert(usuario);
    }

    /**
     * Para modificar el nombre y el email de un usuario
     * @param username
     * @param email
     * @throws Exception
     */
    public static void updateUsuario(String username, String email) throws Exception {
        usuario = TUsuarios.buscarPorUsername(new Usuario(username));
        usuario.setEmail(email);
        TUsuarios.update(usuario);
    }

    /**
     * Para modificar la contraseña de un usuario
     * @param username
     * @param password
     * @throws Exception
     */
    public static void updateUsuarioPass(String username, String password) throws Exception {
        usuario = TUsuarios.buscarPorUsername(new Usuario(username));
        usuario.setPassword(password);
        TUsuarios.update(usuario);
    }

    /**
     * Para devolver la contraseña del administrador con el nombre de usuario ADMIN
     * @return
     * @throws Exception
     */
    public static String getPassAdm() throws Exception {
        Usuario usuarioAdm = TUsuarios.buscarPorUsername(new Usuario("ADMIN"));
        return usuarioAdm.getPassword();
    }

    /**
     * Para devolver la contraseña del usuario
     * @param usuario nombre de usuario
     * @return
     * @throws Exception
     */
    public static String getPassUser(String usuario) throws Exception {
        Usuario user = TUsuarios.buscarPorUsername(new Usuario(usuario));
        return user.getPassword();
    }

    /**
     * Para buscar la clasificacion de la temporada
     * @throws Exception
     */
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

    /**
     * Para la creaccion de los paneles de la ventana de clasificacion
     * @return
     */
    public static JPanel crearPanelesClasificacion() {
        GridLayout gridLayout = new GridLayout();
        gridLayout.setColumns(1);
        gridLayout.setRows(listaDerrotas.size() + 2);
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
            JPanel panelPosicion = new JPanel(new GridLayout(1, 7));
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

    /**
     * Para buscar todos los equipos
     * @throws Exception
     */
    public static void buscarEquipos() throws Exception {
        listaEquipos = TEquipo.buscarTodos();
    }

    /**
     * Para devolver los nombres de los equipos
     * @return
     */
    public static ArrayList<String> getNombreEquipos() {
        ArrayList<String> listaNombres = new ArrayList<>();
        listaEquipos.forEach(equipo -> listaNombres.add(equipo.getNombre()));
        return listaNombres;
    }

    /**
     * Para devolver la URL del logo de los equipos
     * @return
     */
    public static ArrayList<URL> getURLImagen() {
        ArrayList<URL> listaURL = new ArrayList<>();
        listaEquipos.forEach(equipo -> listaURL.add(equipo.getUrl()));
        return listaURL;
    }

    /**
     * Para devolver el color de los equipos
     * @return
     */
    public static ArrayList<String> getColores() {
        ArrayList<String> listaColores = new ArrayList<>();
        listaEquipos.forEach(equipo -> listaColores.add(equipo.getColor()));
        return listaColores;
    }

    /**
     * Para insertar un nuevo jugador
     * @param nombre
     * @param apellido
     * @param DNI
     * @param posicion
     * @param tipoJugador
     * @throws Exception
     */
    public static void insertJugador(String nombre, String apellido, String DNI, String posicion, String tipoJugador) throws Exception {
        jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setApellido(apellido);
        jugador.setDNI(DNI);
        jugador.setPosicion(Jugador.tPosicion.valueOf(posicion));
        jugador.setTipoJugador(Jugador.tTipoJugador.valueOf(tipoJugador));
        tJugadores.insert(jugador);
    }

    /**
     * Para crear el cuadro de dialogo de insertar jugadores
     */
    public static void crearVentanaInsertJugador() {
        dInsertarJugadores = new dInsertJugadores();
        dInsertarJugadores.pack();
        dInsertarJugadores.setVisible(true);
        dInsertarJugadores.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de borrar jugadores
     */
    public static void crearVentanaBorrarJugadores() {
        dBorrarJugadores = new dBorrarJugadores();
        dBorrarJugadores.pack();
        dBorrarJugadores.setVisible(true);
        dBorrarJugadores.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de modificar jugadores
     */
    public static void crearVentanaActualizarJugadores() {
        dUpdatearJugadores = new dActualizarJugadores();
        dUpdatearJugadores.pack();
        dUpdatearJugadores.setVisible(true);
        dUpdatearJugadores.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de buscar jugadores
     */
    public static void crearVentanaBuscarjugadores() {
        dBuscarJugadores = new dBuscarJugadores();
        dBuscarJugadores.pack();
        dBuscarJugadores.setVisible(true);
        dBuscarJugadores.setLocationRelativeTo(vAdminPanel);
    }

    /**
     * Para crear el cuadro de dialogo de insertar equipo
     */
    public static void crearVentanaInsertEquipo() {
        dInsertarEquipo = new dInsertarEquipo();
        dInsertarEquipo.pack();
        dInsertarEquipo.setVisible(true);
        dInsertarEquipo.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de borrar equipo
     */
    public static void crearVentanaBorrarEquipo() {
        dBorrarEquipo = new dBorrarEquipo();
        dBorrarEquipo.pack();
        dBorrarEquipo.setVisible(true);
        dBorrarEquipo.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de modificar equipo
     */
    public static void crearVentanaUpdateEquipo() {
        dActualizarEquipo = new dActualizarEquipo();
        dActualizarEquipo.pack();
        dActualizarEquipo.setVisible(true);
        dActualizarEquipo.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de buscar equipo
     */
    public static void crearVentanaBuscarEquipo() {
        dBuscarEquipo = new dBuscarEquipo();
        dBuscarEquipo.pack();
        dBuscarEquipo.setVisible(true);
        dBuscarEquipo.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de insertar jornada
     */
    public static void crearVentanaInsertJornada() {
        dInsertarJornada = new dInsertarJornada();
        dInsertarJornada.pack();
        dInsertarJornada.setVisible(true);
        dInsertarJornada.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de borrar jornada
     */
    public static void crearVentanaBorrarJornada() {
        dBorrarJornada = new dBorrarJornada();
        dBorrarJornada.pack();
        dBorrarJornada.setVisible(true);
        dBorrarJornada.setLocationRelativeTo(vAdminPanel);
    }/**
     * Para crear el cuadro de dialogo de modificar jornada
     */
    public static void crearVentanaUpdateJornada() {
        dActualizarJornada = new dActualizarJornada();
        dActualizarJornada.pack();
        dActualizarJornada.setVisible(true);
        dActualizarJornada.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de buscar jornada
     */
    public static void crearVentanaBuscarJornada() {
        dBuscarJornada = new dBuscarJornada();
        dBuscarJornada.pack();
        dBuscarJornada.setVisible(true);
        dBuscarJornada.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de insertar presidente
     */
    public static void crearVentanaInsertarPresidente() {
        dInsertarPresidentes = new dInsertarPresidente();
        dInsertarPresidentes.pack();
        dInsertarPresidentes.setVisible(true);
        dInsertarPresidentes.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de borrar presidente
     */
    public static void crearVentanaBorrarPresidente() {
        dBorrarPresidentes = new dBorrarPresidente();
        dBorrarPresidentes.pack();
        dBorrarPresidentes.setVisible(true);
        dBorrarPresidentes.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de modificar presidente
     */
    public static void crearVentanaActualizarPresidente() {
        dActualizarPresidentes = new dActualizarPresidente();
        dActualizarPresidentes.pack();
        dActualizarPresidentes.setVisible(true);
        dActualizarPresidentes.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de buscar presidente
     */
    public static void crearVentanaBuscarPresidente() {
        dBuscarPresidentes = new dBuscarPresidente();
        dBuscarPresidentes.pack();
        dBuscarPresidentes.setVisible(true);
        dBuscarPresidentes.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de insertar staff
     */
    public static void crearVentanaInsertStaff() {
        dInsertarStaff = new dInsertarStaff();
        dInsertarStaff.pack();
        dInsertarStaff.setVisible(true);
        dInsertarStaff.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de borrar staff
     */
    public static void crearVentanaBorrarStaff() {
        dBorrarStaff = new dBorrarStaff();
        dBorrarStaff.pack();
        dBorrarStaff.setVisible(true);
        dBorrarStaff.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de modificar staff
     */
    public static void crearVentanaActualizarStaff() {
        dActualizarStaff = new dActualizarStaff();
        dActualizarStaff.pack();
        dActualizarStaff.setVisible(true);
        dActualizarStaff.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de buscar staff
     */
    public static void crearVentanaBuscarStaff() {
        dBuscarStaff = new dBuscarStaff();
        dBuscarStaff.pack();
        dBuscarStaff.setVisible(true);
        dBuscarStaff.setLocationRelativeTo(vAdminPanel);
    }

    /**
     * Para crear el cuadro de dialogo de insertar temporada
     */
    public static void crearVentanaInsertTemporada() {
        dInsertarTemporada = new dInsertarTemporada();
        dInsertarTemporada.pack();
        dInsertarTemporada.setVisible(true);
        dInsertarTemporada.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de borrar temporada
     */
    public static void crearVentanaBorrarTemporada() {
        dBorrarTemporada = new dBorrarTemporada();
        dBorrarTemporada.pack();
        dBorrarTemporada.setVisible(true);
        dBorrarTemporada.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de modificar temporada
     */
    public static void crearVentanaActualizarTemporada() {
        dActualizarTemporada = new dActualizarTemporada();
        dActualizarTemporada.pack();
        dActualizarTemporada.setVisible(true);
        dActualizarTemporada.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de buscar temporada
     */
    public static void crearVentanaBuscarTemporada() {
        dBuscarTemporada = new dBuscarTemporada();
        dBuscarTemporada.pack();
        dBuscarTemporada.setVisible(true);
        dBuscarTemporada.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de insertar usuario
     */
    public static void crearVentanaInsertUsuario() {
        dInsertarUsuario = new dInsertarUsuario();
        dInsertarUsuario.pack();
        dInsertarUsuario.setVisible(true);
        dInsertarUsuario.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de borrar usuario
     */
    public static void crearVentanaBorrarUsuario() {
        dBorrarUsuario = new dBorrarUsuario();
        dBorrarUsuario.pack();
        dBorrarUsuario.setVisible(true);
        dBorrarUsuario.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de modificar usuario
     */
    public static void crearVentanaActualizarUsuario() {
        dActualizarUsuario = new dActualizarUsuario();
        dActualizarUsuario.pack();
        dActualizarUsuario.setVisible(true);
        dActualizarUsuario.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de buscar usuario
     */
    public static void crearVentanaBuscarUsuarios() {
        dBuscarUsuarios = new dBuscarUsuarios();
        dBuscarUsuarios.pack();
        dBuscarUsuarios.setVisible(true);
        dBuscarUsuarios.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de modificar partido
     */
    public static void crearDialogoActualizarPartido(){
        dActualizarPartido = new dActualizarPartidos();
        dActualizarPartido.pack();
        dActualizarPartido.setVisible(true);
        dActualizarPartido.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de insertar partido
     */
    public static void crearDialogoInsertarPartido(){
        dInsertarPartido = new dInsertPartidos();
        dInsertarPartido.pack();
        dInsertarPartido.setVisible(true);
        dInsertarPartido.setLocationRelativeTo(vAdminPanel);

    }
    /**
     * Para crear el cuadro de dialogo de borrar partido
     */
    public static void crearDialogoBorrarPartidos(){
        dBorrarPartidos = new dBorrarPartidos();
        dBorrarPartidos.pack();
        dBorrarPartidos.setVisible(true);
        dBorrarPartidos.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de dialogo de buscar partido
     */
    public static void crearDialogoBuscarPartidos(){
        dBuscarPartidos = new dBuscarPartidos();
        dBuscarPartidos.pack();
        dBuscarPartidos.setVisible(true);
        dBuscarPartidos.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para borrar un jugador por dni
     * @param DNI
     */
    public static int borrarJugador(String DNI) throws Exception {
        jugador = new Jugador();
        jugador.setDNI(DNI);
        return tJugadores.delete(jugador);
    }

    /**
     * Para modificar un jugador
     * @param nombre
     * @param apellido
     * @param DNI
     * @param posicion
     * @param tipoJugador
     * @throws Exception
     */
    public static void actualizarJugador(String nombre, String apellido, String DNI, String posicion, String tipoJugador) throws Exception {
        jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setApellido(apellido);
        jugador.setDNI(DNI);
        jugador.setPosicion(Jugador.tPosicion.valueOf(posicion));
        jugador.setTipoJugador(Jugador.tTipoJugador.valueOf(tipoJugador));
        tJugadores.update(jugador);
    }

    /**
     * Para buscar y devolver los datos de todos los jugadores
     * @return
     * @throws Exception
     */
    public static String buscarTodosJugadores() throws Exception {
        ArrayList<Jugador> listaJugadores = tJugadores.buscarTodos();
        String datos = "";
        for (int x = 0; x < listaJugadores.size(); x++) {
            datos += "ID_JUGADOR" + listaJugadores.get(x).getID() + ":" + "\n" + "\n Nombre: " + listaJugadores.get(x).getNombre() + "\n Apellido: " + listaJugadores.get(x).getApellido()
                    + "\n DNI: " + listaJugadores.get(x).getDNI() + "\n Posicion: " + listaJugadores.get(x).getPosicion() + "\n TipoDeJugador: " + listaJugadores.get(x).getTipoJugador() + "\n" + "\n";
        }
        return datos;
    }

    /**
     * Para buscar y devolver los datos de un jugador por ID
     * @param id_jugador
     * @return
     * @throws Exception
     */
    public static String buscarTodosLosJugadorPorID(String id_jugador) throws Exception {
        jugador = new Jugador();
        jugador.setID(Integer.parseInt(id_jugador));
        String datos = "";
        jugador = tJugadores.buscarPorID(jugador);
        datos += "ID_JUGADOR" + jugador.getID() + "\n Nombre: " + jugador.getNombre() + "\n" + jugador.getApellido() + "\n Apellido: " + jugador.getApellido()
                + "\n DNI: " + jugador.getDNI() + "\n Posicion: " + jugador.getPosicion() + "\n TipoDeJugador: " + jugador.getTipoJugador();
        return datos;
    }

    /**
     * Para buscar y devolver los datos de un jugador por DNI
     * @param dni
     * @return
     * @throws Exception
     */
    public static String buscarTodosLosJugadorPorDNI(String dni) throws Exception {
        jugador = new Jugador();
        jugador.setDNI(dni);
        String datos = "";
        jugador = tJugadores.buscarPorDNI(jugador);
        datos += "ID_JUGADOR" + jugador.getID() + "\n Nombre: " + jugador.getNombre() + "\n" + jugador.getApellido() + "\n Apellido: " + jugador.getApellido()
                + "\n DNI: " + jugador.getDNI() + "\n Posicion: " + jugador.getPosicion() + "\n TipoDeJugador: " + jugador.getTipoJugador();
        return datos;
    }

    /**
     * Para insertar una nueva jornada
     * @param id_temporada
     * @param num_jornada
     * @param fecha
     * @throws Exception
     */
    public static void insertarJornada(int id_temporada, int num_jornada, String fecha) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Jornada jornada = new Jornada(num_jornada, LocalDate.parse(fecha, formatter));
        Temporada temporada = TTemporadas.buscarPorID(new Temporada(id_temporada));
        jornada.setTemporada(temporada);
        TJornadas.insert(jornada);
    }

    /**
     * Para borrar una jornada
     * @param id_jornada
     * @return
     * @throws Exception
     */
    public static int borrarJornada(int id_jornada) throws Exception {
        Jornada jornada = new Jornada();
        jornada.setID(id_jornada);
        return TJornadas.delete(jornada);
    }

    /**
     * Para modificar una jornada
     * @param id_temporada
     * @param num_jornada
     * @param fecha
     * @throws SQLException
     */
    public static void actualizarJornada(int id_temporada, int num_jornada, String fecha) throws SQLException {
        Jornada jornada = new Jornada();
        jornada.setTemporada(new Temporada(id_temporada));
        jornada.setNumJornada(num_jornada);
        jornada.setFecha(LocalDate.parse(fecha));
        TJornadas.update(jornada);
    }

    /**
     * Para buscar y devolver los datos de todas las jornadas
     * @return
     * @throws Exception
     */
    public static String buscarTodasLasJornadas() throws Exception {
        ArrayList<Jornada> listaJornadas = TJornadas.buscarTodo();
        String datos = "";
        for (int x = 0; x < listaJornadas.size(); x++) {
            datos += "\n ID_JORNADA" + listaJornadas.get(x).getID() + "\n\nTemporada: " + listaJornadas.get(x).getTemporada().getID() + "\nNºJornada: " + listaJornadas.get(x).getNumJornada() + "\nFecha: " + listaJornadas.get(x).getFecha() + "\n";
        }
        return datos;
    }

    /**
     * Para buscar una temporada por id
     * @param ID
     * @return
     * @throws Exception
     */
    public static String buscarTemporadaID (String ID) throws Exception {
        Temporada temporada = new Temporada();
        temporada.setID(Integer.parseInt(ID));
        String datos = "";
        temporada = TTemporadas.buscarPorID(temporada);
        datos += "ID_TEMPORADA" + temporada.getID() + "\n FECHA INICIO: " + temporada.getFechaInicio() + "\n FECHA FIN: " + temporada.getFechaFin();
        return datos;
    }

    /**
     * Para crear la ventana de los jugadores de un equipo
     * @param equipo
     * @throws Exception
     */
    public static void crearVentanaEquipoJugadores(String equipo) throws Exception {
        datosSeleccionarJugadorEquipo(equipo);
        vEquipoJugadores = new JFrame("vEquipoJugadores");
        vEquipoJugadores.setContentPane(new vEquipoJugadores(equipo).getpPrincipal());
        vEquipoJugadores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vEquipoJugadores.pack();
        vEquipoJugadores.setVisible(true);
    }

    /**
     * Para buscar y devolver los datos de un jugador en un equipo para la ventana de los jugadores de un equipo
     * @param equipo
     * @throws Exception
     */
    public static void datosSeleccionarJugadorEquipo(String equipo) throws Exception {
        Equipo equipo2 = new Equipo();
        equipo2.setNombre(equipo);
        Equipo equipo1 = TEquipo.buscarPorNombre(equipo2);
        listaJugadores = tJugadores.buscarPorEquipo(equipo1);
    }

    /**
     * Para devolver o modificar el nombre de un jugador en un equipo para la ventana de los jugadores de un equipo
     * @return
     */
    public static String getNombreSelect() {
        return listaJugadores.get(contadorJugador()).getNombre();
    }

    /**
     * Para devolver o modificar el apellido de un jugador en un equipo para la ventana de los jugadores de un equipo
     * @return
     */
    public static String getApellidoSelect() {
        return listaJugadores.get(contadorJugador()).getApellido();
    }
    /**
     * Para devolver o modificar la posicion de un jugador en un equipo para la ventana de los jugadores de un equipo
     * @return
     */
    public static String getPosicionSelect() {
        return String.valueOf(listaJugadores.get(contadorJugador()).getPosicion());
    }
    /**
     * Para devolver o modificar el tipo de un jugador en un equipo para la ventana de los jugadores de un equipo
     * @return
     */
    public static String getTipoJugadorSelect() {
        return String.valueOf(listaJugadores.get(contadorJugador()).getTipoJugador());
    }

    /**
     * Para devolver la posicion de los jugadores en la ventana de los jugadores de un equipo
     * @return
     */
    public static int contadorJugador() {
        return numJugador;
    }

    /**
     * Para pasar al siguiente jugador en la ventana de los jugadores de un equipo
     * @return
     */
    public static int siguienteJugador() {
        return numJugador = numJugador + 1;
    }
    /**
     * Para pasar al anterior jugador en la ventana de los jugadores de un equipo
     * @return
     */
    public static int posteriorJugador() {
        return numJugador = numJugador - 1;
    }
    /**
     * Para pasar al primer jugador en la ventana de los jugadores de un equipo
     * @return
     */
    public static int primerJugador() {
        return numJugador = 0;
    }
    /**
     * Para pasar al ultimo jugador en la ventana de los jugadores de un equipo
     * @return
     */
    public static int ultimoJugador() {
        return numJugador = 9;
    }

    // COMBOBOX BUSCAR JUGADORES **************************************

    /**
     * Para rellenar una comboBox con los ids de los jugadores
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearIdJugadores() throws Exception {
        listaJugadores = tJugadores.buscarTodos();
        ArrayList<String> listaIdJugadores = new ArrayList<>();
        listaJugadores.forEach(jugador1 -> listaIdJugadores.add(String.valueOf(jugador1.getID())));
        return listaIdJugadores;
    }
    /**
     * Para rellenar una comboBox con los dnis de los jugadores
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearDniJugadores() throws Exception {
        listaJugadores = tJugadores.buscarTodos();
        ArrayList<String> listaDNIJugadores = new ArrayList<>();
        listaJugadores.forEach(jugador1 -> listaDNIJugadores.add(jugador1.getDNI()));
        return listaDNIJugadores;
    }

    // COMBOBOX BUSCAR EQUIPOS **************************************
    /**
     * Para rellenar una comboBox con los ids de los equipos
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearIdEquipos() throws Exception {
        listaEquipos = TEquipo.buscarTodos();
        ArrayList<String> listaIdEquipos = new ArrayList<>();
        listaEquipos.forEach(id -> listaIdEquipos.add(String.valueOf(id.getID())));
        return listaIdEquipos;
    }
    /**
     * Para rellenar una comboBox con los nombres de los equipos
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearNombreEquipos() throws Exception {
        listaEquipos = TEquipo.buscarTodos();
        ArrayList<String> listaNombreEquipos = new ArrayList<>();
        listaEquipos.forEach(nombre -> listaNombreEquipos.add(nombre.getNombre()));
        return listaNombreEquipos;
    }


    // COMBOBOX BUSCAR PARTIDOS **************************************
    /**
     * Para rellenar una comboBox con los ids de los partidos
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearIdPartidos() throws Exception {
        listaPartidos = TPartido.buscarTodos();
        ArrayList<String> listaIdPartidos = new ArrayList<>();
        listaPartidos.forEach(id -> listaIdPartidos.add(String.valueOf(id.getID())));
        return listaIdPartidos;
    }
    /**
     * Para rellenar una comboBox con el tipo de los partidos
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearTipoPartidos() throws Exception {
        listaPartidos = TPartido.buscarTodos();
        ArrayList<String> listaTipoPartidos = new ArrayList<>();
        listaPartidos.forEach(tipo -> listaTipoPartidos.add(String.valueOf(tipo.getTipoPartido())));
        return listaTipoPartidos;
    }

    // COMBOBOX BUSCAR PRESIDENTE **************************************
    /**
     * Para rellenar una comboBox con los ids de los presidentes
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearIdPresidente() throws Exception {
        listaPresidente = TPresidente.buscarTodos();
        ArrayList<String> listaIdPresidentes = new ArrayList<>();
        listaPresidente.forEach(id -> listaIdPresidentes.add(String.valueOf(id.getID())));
        return listaIdPresidentes;
    }

    // COMBOBOX BUSCAR STAFF **************************************
    /**
     * Para rellenar una comboBox con los ids de los staffs
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearIdStaff() throws Exception {
        listaStaffs = tStaffs.buscarTodos();
        ArrayList<String> listaIdStaffs = new ArrayList<>();
        listaStaffs.forEach(id -> listaIdStaffs.add(String.valueOf(id.getID())));
        return listaIdStaffs;
    }

    // **************************************************************
    /**
     * Para rellenar una comboBox con las fechas de las jornadas
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearFechaJornadas() throws Exception {
        listaJornadas = TJornadas.buscarTodo();
        ArrayList<String> listaFechaJornadas = new ArrayList<>();
        listaJornadas.forEach(jornada -> listaFechaJornadas.add(String.valueOf(jornada.getFecha())));
        return listaFechaJornadas;
    }
    /**
     * Para rellenar una comboBox con los ids de las jornadas
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearIdJornada() throws Exception {
        listaJornadas = TJornadas.buscarTodo();
        ArrayList<String> listaJornadasID = new ArrayList<>();
        listaJornadas.forEach(jornada -> listaJornadasID.add(String.valueOf(jornada.getID())));
        return listaJornadasID;
    }
    /**
     * Para rellenar una comboBox con los ids de las temporadas
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearIDTemporada() throws Exception {
        listaTemporada = TTemporadas.buscarTodo();
        ArrayList<String> listaTemporadaID = new ArrayList<>();
        listaTemporada.forEach(temporada -> listaTemporadaID.add(String.valueOf(temporada.getID())));
        return listaTemporadaID;
    }
    /**
     * Para rellenar una comboBox con las fechas de inicio de las temporadas
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearFechaInicioTemporada() throws Exception {
        listaTemporada = TTemporadas.buscarTodo();
        ArrayList<String> listaTemporadaID = new ArrayList<>();
        listaTemporada.forEach(temporada -> listaTemporadaID.add(String.valueOf(temporada.getFechaInicio())));
        return listaTemporadaID;
    }/**
     * Para rellenar una comboBox con las fechas de fin de las temporadas
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearFechaFinTemporada() throws Exception {
        listaTemporada = TTemporadas.buscarTodo();
        ArrayList<String> listaTemporadaID = new ArrayList<>();
        listaTemporada.forEach(temporada -> listaTemporadaID.add(String.valueOf(temporada.getFechaFin())));
        return listaTemporadaID;
    }
    /**
     * Para rellenar una comboBox con los ids de los staff
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearStaff() throws Exception {
        listaStaff = tStaffs.buscarTodos();
        ArrayList<String> listaStaffID = new ArrayList<>();
        listaStaff.forEach(staff -> listaStaffID.add(String.valueOf(staff.getID())));
        return listaStaffID;
    }
    /**
     * Para rellenar una comboBox con los ids de los equipos de los staff
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearStaffEquipoID() throws Exception {
        listaStaffEquipo = TStaffEquipo.buscarTodos();
        ArrayList<String> listaStaffEquipoIDEquipo = new ArrayList<>();
        listaStaffEquipo.forEach(staffEquipo -> listaStaffEquipoIDEquipo.add(String.valueOf(staffEquipo.getEquipo().getID())));
        return listaStaffEquipoIDEquipo;
    }
    /**
     * Para rellenar una comboBox con los ids de los staffEquipo
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearStaffEquipoID2() throws Exception {
        listaStaffEquipo = TStaffEquipo.buscarTodos();
        ArrayList<String> listaStaffEquipoIDEquipo = new ArrayList<>();
        listaStaffEquipo.forEach(staffEquipo -> listaStaffEquipoIDEquipo.add(String.valueOf(staffEquipo.getStaff().getID())));
        return listaStaffEquipoIDEquipo;
    }
    /**
     * Para rellenar una comboBox con los dnis de los staffs
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearStaffDNI() throws Exception {
        listaStaff = tStaffs.buscarTodos();
        ArrayList<String> listaStaffDNI = new ArrayList<>();
        listaStaff.forEach(staff -> listaStaffDNI.add(String.valueOf(staff.getDNI())));
        return listaStaffDNI;
    }
    /**
     * Para rellenar una comboBox con los usernames de los usuarios
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearUsuarios() throws Exception {
        listaUsuarios = TUsuarios.buscarTodo();
        ArrayList<String> listaUsuariosUser = new ArrayList<>();
        listaUsuarios.forEach(user -> listaUsuariosUser.add(user.getUsername()));
        return listaUsuariosUser;
    }

    /**
     * Para obtener el ganador de un partido
     * @param partido
     * @return
     */
    public static int obtenerGanador(Partido partido) {
        if (partido.getGolesLocal() > partido.getGolesVisitante()) {
            return 1;
        } else if (partido.getGolesLocal() < partido.getGolesVisitante()) {
            return 2;
        }
        return 0;
    }

    /**
     * Para buscar y devolver los datos de todos los equipos
     * @return
     * @throws Exception
     */
    public static String buscarTodosEquipos() throws Exception {
        ArrayList<Equipo> listaEquipos = TEquipo.buscarTodos();
        String datos = "";
        for (int x = 0; x < listaEquipos.size(); x++) {
            datos += "\n ID_EQUIPO" + listaEquipos.get(x).getID() + "\n\nNombre: " + listaEquipos.get(x).getNombre() + "\nPresupuesto: " + listaEquipos.get(x).getPresupuesto() + "€\n";
        }
        return datos;
    }

    /**
     * Para buscar y devolver los datos del equipo por ID
     * @param id_equipo
     * @return
     * @throws Exception
     */
    public static String buscarTodosLosEquiposPorID(String id_equipo) throws Exception {
        equipo = new Equipo();
        equipo.setID(Integer.parseInt(id_equipo));
        String datos = "";
        equipo = TEquipo.buscarPorId(equipo);
        datos += "\n ID_EQUIPO" + equipo.getID() + "\n\nNombre: " + equipo.getNombre() + "\nPresupuesto: " + equipo.getPresupuesto() + "€\n";
        return datos;
    }

    /**
     * Para buscar y devolver los datos del equipo por nombre
     * @param nombre
     * @return
     * @throws Exception
     */
    public static String buscarTodosLosEquiposPorNombre(String nombre) throws Exception {
        equipo = new Equipo();
        equipo.setNombre(nombre);
        String datos = "";
        equipo = TEquipo.buscarPorNombre(equipo);
        datos += "\n ID_EQUIPO" + equipo.getID() + "\n\nNombre: " + equipo.getNombre() + "\nPresupuesto: " + equipo.getPresupuesto() + "€\n";
        return datos;
    }

    /**
     * Para buscar y devolver los datos de una jornada por fecha
     * @param fecha
     * @return
     * @throws Exception
     */
    public static String buscarJornadaFecha (String fecha) throws Exception {
        Jornada jornada = new Jornada();
        jornada.setFecha(LocalDate.parse(fecha));
        String datos = "";
        jornada = TJornadas.buscarPorFecha(jornada);
        datos += "ID_JORNADA" + jornada.getID() + "\n ID_TEMPORADA: " + jornada.getTemporada().getID() + "\n" + jornada.getNumJornada() + "\n Fecha: " + jornada.getFecha();
        return datos;
    }

    /**
     * Para buscar y devolver los datos de una jornada por ID
     * @param ID
     * @return
     * @throws Exception
     */
    public static String buscarJornadaID (String ID) throws Exception {
        Jornada jornada = new Jornada();
        jornada.setID(Integer.parseInt(ID));
        String datos = "";
        jornada = TJornadas.buscarPorID(jornada);
        datos += "ID_JORNADA" + jornada.getID() + "\n ID_TEMPORADA: " + jornada.getTemporada().getID() + "\n" + jornada.getNumJornada() + "\n Fecha: " + jornada.getFecha();
        return datos;
    }

    /**
     * Para insertar o registrar un usuario
     * @param email
     * @param username
     * @param password
     * @param tipo_usuario
     * @throws Exception
     */
    public static void insertarUsuario (String email, String username, String password, String
            tipo_usuario) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setAdmin(Usuario.tUsuario.valueOf(tipo_usuario));
        TUsuarios.insert(usuario);
    }

    /**
     * Para modificar un usuario
     * @param id_usuario
     * @param email
     * @param username
     * @param password
     * @param tipo_usuario
     * @throws Exception
     */
    public static void actualizarUsuario (String id_usuario, String email, String username, String password, String
            tipo_usuario) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setID(Integer.parseInt(id_usuario));
        usuario.setEmail(email);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setAdmin(Usuario.tUsuario.valueOf(tipo_usuario));
        TUsuarios.update(usuario);
    }

    /**
     * Para borrar un usuario
     * @param username
     * @return
     * @throws Exception
     */
    public static int borrarUsuario (String username) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        return TUsuarios.delete(usuario);
    }

    /**
     * Para buscar y devolver los datos de todos los usuarios
     * @return
     * @throws Exception
     */
    public static String buscarTodosUsuarios () throws Exception {
        ArrayList<Usuario> listaUsuarios = TUsuarios.buscarTodo();
        String datos = "";
        for (int x = 0; x < listaUsuarios.size(); x++) {
            datos += "\n ID_USUARIO" + listaUsuarios.get(x).getID() + "\n\nUsername: " + listaUsuarios.get(x).getUsername() + "\nEmail: " + listaUsuarios.get(x).getEmail() + "\nPassword: " + listaUsuarios.get(x).getPassword()
                    + "\n ADMIN" + listaUsuarios.get(x).getAdmin();
        }
        return datos;
    }

    /**
     * Para buscar y devolver los datos de un usuario por el username
     * @param user
     * @return
     * @throws Exception
     */
    public static String buscarTodosUsuariosPorUser (String user) throws Exception {
        Usuario username = new Usuario();
        username.setUsername(user);
        String datos = "";
        username = TUsuarios.buscarPorUsername(username);
        datos += "ID_USUARIO" + username.getID() + "\n EMAIL: " + usuario.getEmail() + "\n Usuario" + username.getUsername() + "\n Password: " + usuario.getPassword()
                + "\n USERNAME" + username.getUsername() + "\n ADMIN" + username.getAdmin();
        return datos;
    }

    /**
     * Para insertar una nueva temporada
     * @param fecha_inicio
     * @param fecha_fin
     * @param estado
     * @param periodo
     * @throws Exception
     */
    public static void insertarTemporada (String fecha_inicio, String fecha_fin, String estado, String periodo) throws
            Exception {
        Temporada temporada = new Temporada();
        temporada.setFechaInicio(LocalDate.parse(fecha_inicio));
        temporada.setFechaFin(LocalDate.parse(fecha_fin));
        temporada.setEstado(Temporada.tEstado.valueOf(estado));
        temporada.setPeriodo(Temporada.tPeriodo.valueOf(periodo));
        TTemporadas.insertar(temporada);
    }

    /**
     * Para modificar una temporada
     * @param id_temporada
     * @param fecha_inicio
     * @param fecha_fin
     * @param estado
     * @param periodo
     * @throws SQLException
     */
    public static void ActualizarTemporada (String id_temporada, String fecha_inicio, String fecha_fin, String
            estado, String periodo) throws SQLException {
        Temporada temporada = new Temporada();
        temporada.setID(Integer.parseInt(id_temporada));
        temporada.setFechaInicio(LocalDate.parse(fecha_inicio));
        temporada.setFechaFin(LocalDate.parse(fecha_fin));
        temporada.setEstado(Temporada.tEstado.valueOf(estado));
        temporada.setPeriodo(Temporada.tPeriodo.valueOf(periodo));
        TTemporadas.update(temporada);
    }

    /**
     * Para borrar una temporada
     * @param id_temporada
     * @return
     * @throws Exception
     */
    public static int borrarTemporada (String id_temporada) throws Exception {
        Temporada temporada = new Temporada();
        temporada.setID(Integer.parseInt(id_temporada));
        return TTemporadas.delete(temporada);
    }

    /**
     * Para buscar y devolver los datos de todas las temporadas
     * @return
     * @throws Exception
     */
    public static String buscarTodasLasTemporadas () throws Exception {
        ArrayList<Temporada> listaTemporadas = TTemporadas.buscarTodo();
        String datos = "";
        for (int x = 0; x < listaTemporadas.size(); x++) {
            datos += "\n ID_TEMPORAD" + listaTemporadas.get(x).getID() + "\n\nFechaInicio: " + listaTemporadas.get(x).getFechaInicio() + "\nFechaFin: " + listaTemporadas.get(x).getFechaFin()
                    + "\nEstado: " + listaTemporadas.get(x).getEstado() + "\nPeriodo" + listaTemporadas.get(x).getPeriodo();
        }
        return datos;
    }

    /**
     * Para insertar un nuevo staff
     * @param nombre
     * @param apellido
     * @param dni
     * @param rol
     * @throws Exception
     */
    public static void insertarStaff (String nombre, String apellido, String dni, String rol) throws Exception {
        Staff staff = new Staff();
        staff.setNombre(nombre);
        staff.setApellido(apellido);
        staff.setDNI(dni);
        staff.setRol(Staff.tROl.valueOf(rol));
        tStaffs.insert(staff);

    }

    /**
     * Para borrar un staff
     * @param dni
     * @return
     * @throws Exception
     */
    public static int borrarStaff (String dni) throws Exception {
        Staff staff = new Staff();
        staff.setDNI(dni);
        return tStaffs.delete(staff);
    }

    /**
     * Para modificasr un staff
     * @param idStaff
     * @param nombre
     * @param apellido
     * @param dni
     * @param rol
     * @throws Exception
     */
    public static void actualizarStaff (String idStaff, String nombre, String apellido, String dni, String rol) throws
            Exception {
        Staff staff = new Staff();
        staff.setID(Integer.parseInt(idStaff));
        staff.setNombre(nombre);
        staff.setApellido(apellido);
        staff.setDNI(dni);
        staff.setRol(Staff.tROl.valueOf(rol));
        tStaffs.update(staff);
    }

    /**
     * Para buscar y devolver los datos de todos los staffs
     * @return
     * @throws Exception
     */
    public static String buscarTodosStaff () throws Exception {
        ArrayList<Staff> listaStaff = tStaffs.buscarTodos();
        String datos = "";
        for (int x = 0; x < listaStaff.size(); x++) {
            datos += "\n ID_STAFF" + listaStaff.get(x).getID() + "\n\nNombre: " + listaStaff.get(x).getNombre() + "\nApellido: " + listaStaff.get(x).getApellido()
                    + "\nDNI: " + listaStaff.get(x).getDNI() + "\nRol" + listaStaff.get(x).getRol();
        }
        return datos;
    }

    /**
     * Para buscar y devolver los datos del staff por ID
     * @param id
     * @return
     * @throws Exception
     */
    public static String buscarStaffId (String id) throws Exception {
        Staff staff = new Staff();
        staff.setID(Integer.parseInt(id));
        String datos = "";
        staff = tStaffs.buscarPorId(staff);
        datos += "ID_STAFF" + staff.getID() + "\n Nombre: " + staff.getNombre() + "\n Apellido" + staff.getApellido() + "\n DNI: " + staff.getDNI()
                + "\n Rol" + staff.getRol();
        return datos;
    }

    /**
     * Para buscar y devolver los datos de un staff por DNI
     * @param dni
     * @return
     * @throws Exception
     */
    public static String buscarStaffDNI (String dni) throws Exception {
        Staff staff = new Staff();
        staff.setDNI(dni);
        String datos = "";
        staff = tStaffs.buscarPorDNI(staff);
        datos += "ID_STAFF" + staff.getID() + "\n Nombre: " + staff.getNombre() + "\n Apellido" + staff.getApellido() + "\n DNI: " + staff.getDNI()
                + "\n Rol" + staff.getRol();
        return datos;
    }

    /**
     * Para crear el cuadro de diálogo para insertar staffs en un equipo
     */
    public static void crearVentanaInsertarStaffEquipo (){
        dInsertarEquiposStaff = new dInsertarEquiposStaff();
        dInsertarEquiposStaff.pack();
        dInsertarEquiposStaff.setVisible(true);
        dInsertarEquiposStaff.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de diálogo para borrar staffs de un equipo
     */
    public static void crearVentanaBorrarStaffEquipo (){
        dBorrarEquiposStaff  = new dBorrarEquiposStaff();
        dBorrarEquiposStaff.pack();
        dBorrarEquiposStaff.setVisible(true);
        dBorrarEquiposStaff.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de diálogo para modificar staffs de un equipo
     */
    public static void crearVentanaActualizarStaffEquipo (){
        dActualizarEquiposStaff = new dActualizarEquiposStaff();
        dActualizarEquiposStaff.pack();
        dActualizarEquiposStaff.setVisible(true);
        dActualizarEquiposStaff.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de diálogo para buscar staffs en un equipo
     */
    public static void crearVentanaBuscarStaffEquipo (){
        dBuscarEquiposStaff = new dBuscarEquiposStaff();
        dBuscarEquiposStaff.pack();
        dBuscarEquiposStaff.setVisible(true);
        dBuscarEquiposStaff.setLocationRelativeTo(vAdminPanel);
    }

    /**
     * Para insertar un nuevo staff en un equipo
     * @param idEquipo
     * @param idStaff
     * @param sueldo
     * @param fechaInicio
     * @param fechaFin
     * @throws Exception
     */
    public static void insertarStaffEquipos (String idEquipo, String idStaff, String sueldo, String fechaInicio, String fechaFin) throws Exception {
        staff = tStaffs.buscarPorId(new Staff(Integer.parseInt(idStaff)));
        equipo = TEquipo.buscarPorId(new Equipo(Integer.parseInt(idEquipo)));
        StaffEquipo staffEquipo = new StaffEquipo(staff,equipo,LocalDate.parse(fechaInicio),LocalDate.parse(fechaFin),Double.parseDouble(sueldo));
        TStaffEquipo.insert(staffEquipo);
    }

    /**
     * Para modificar un staff en un equipo
     * @param idStaff
     * @param sueldo
     * @param fechaInicio
     * @param fechaFin
     * @throws Exception
     */
    public static void actualizarEquiposStaff (String idStaff, String sueldo, String fechaInicio, String fechaFin) throws Exception {
        staff = tStaffs.buscarPorId(new Staff(Integer.parseInt(idStaff)));
        StaffEquipo staffEquipo = new StaffEquipo(staff,LocalDate.parse(fechaInicio),LocalDate.parse(fechaFin),Double.parseDouble(sueldo));
        TStaffEquipo.update(staffEquipo);
    }

    /**
     * Para borrar un staff de un equipo
     * @param idStaff
     * @return
     * @throws Exception
     */
    public static int borrarStaffEquipo (String idStaff) throws Exception {
        staff = tStaffs.buscarPorId(new Staff(Integer.parseInt(idStaff)));
        StaffEquipo staffEquipo = new StaffEquipo(staff);
        return TStaffEquipo.delete(staffEquipo);
    }

    /**
     * Para buscar y devolver los datos de todos los staffs en equipos
     * @return
     * @throws Exception
     */
    public static String buscarTodosStaffEquipos() throws Exception {
        ArrayList<StaffEquipo> listaStaffEquipo = TStaffEquipo.buscarTodos();
        String datos = "";
        for (int x = 0; x < listaStaffEquipo.size(); x++) {
            datos += "\n ID_STAFF" + listaStaffEquipo.get(x).getStaff().getID() + "\n\nID_EQUIPO: " + listaStaffEquipo.get(x).getEquipo().getID() +
                    "\nSueldo: " + listaStaffEquipo.get(x).getSueldo() + "\nFechaInicio: " + listaStaffEquipo.get(x).getFechaInicio() + "\nFechaFin" + listaStaffEquipo.get(x).getFechaFin();
        }
        return datos;
    }

    /**
     * Para buscar y devolver los nombres de los equipos
     * @param nombre
     * @return
     * @throws Exception
     */
    public static String getNombreEquipoID (String nombre) throws Exception {
        equipo = new Equipo();
        equipo.setNombre(nombre);
        String datos = "";
        equipo = TEquipo.buscarPorNombre(equipo);
        datos += equipo.getNombre();
        return datos;
    }

    /**
     * Para insertar un nuevo equipo
     * @param nombre
     * @param presupuesto
     * @throws Exception
     */
    public static void insertEquipo (String nombre,double presupuesto) throws Exception {
        equipo = new Equipo();
        equipo.setNombre(nombre);
        equipo.setPresupuesto(presupuesto);
        TEquipo.insert(equipo);
    }

    /**
     * Para modificar un equipo
     * @param nombre
     * @param presupuesto
     * @throws Exception
     */
    public static void updateEquipo (String nombre,double presupuesto) throws Exception {
        equipo = new Equipo();
        equipo.setNombre(nombre);
        equipo.setPresupuesto(presupuesto);
        TEquipo.update(equipo);
    }

    /**
     * Para borrar un equipo por ID
     * @param id
     * @throws Exception
     */
    public static void deleteEquipo (Integer id) throws Exception {
        equipo = new Equipo();
        equipo.setID(id);
        TEquipo.update(equipo);
        TEquipo.delete(equipo);
    }

    /**
     * Para insertar un nuevo partido
     * @param tipoPartido
     * @param hora
     * @param local
     * @param visitante
     * @param golesLocal
     * @param golesVisitante
     * @param jornada
     * @throws Exception
     */
    public static void insertPartido(String tipoPartido, String hora, int local, int visitante, int golesLocal, int golesVisitante, int jornada) throws Exception {
        partido = new Partido();
        partido.setTipoPartido(Partido.tPartido.valueOf(tipoPartido));
        partido.setHora(hora);
        partido.setLocal(TEquipo.buscarPorId(new Equipo(local)));
        partido.setLocal(TEquipo.buscarPorId(new Equipo(visitante)));
        partido.setGolesLocal(golesLocal);
        partido.setGolesVisitante(golesVisitante);
        partido.setJornada(TJornadas.buscarPorID(new Jornada(jornada)));
        TPartido.insert(partido);
    }

    /**
     * Para modificar un partido
     * @param tipoPartido
     * @param hora
     * @param local
     * @param visitante
     * @param golesLocal
     * @param golesVisitante
     * @param jornada
     * @throws Exception
     */
    public static void updatePartido(String tipoPartido, String hora, int local, int visitante, int golesLocal, int golesVisitante, int jornada) throws Exception {
        partido = new Partido();
        partido.setTipoPartido(Partido.tPartido.valueOf(tipoPartido));
        partido.setHora(hora);
        partido.setLocal(TEquipo.buscarPorId(new Equipo(local)));
        partido.setLocal(TEquipo.buscarPorId(new Equipo(visitante)));
        partido.setGolesLocal(golesLocal);
        partido.setGolesVisitante(golesVisitante);
        partido.setJornada(TJornadas.buscarPorID(new Jornada(jornada)));
        TPartido.update(partido);
    }

    /**
     * Para borrar un partido
     * @param id
     * @throws Exception
     */
    public static void deletePartido (Integer id) throws Exception {
        partido = new Partido();
        partido.setID(id);
        TPartido.delete(partido);
    }

    /**
     * Para buscar y devolver los datos de todos los partidos
     * @return
     * @throws Exception
     */
    public static String buscarTodosPartidos () throws Exception {
        ArrayList<Partido> listaPartidos = TPartido.buscarTodos();
        String datos = "";
        for (int x = 0; x < listaPartidos.size(); x++) {
            datos += "\n ID_PARTIDO" + listaPartidos.get(x).getID() + "\n\nTipo Partido: " + listaPartidos.get(x).getTipoPartido() + "\nHora: " + listaPartidos.get(x).getHora()
                    + "\nEquipo Local: " + listaPartidos.get(x).getLocal() + "\nEquipo Visitante: " + listaPartidos.get(x).getVisitante() + "\nJornada: "
                    + listaPartidos.get(x).getJornada().getID() + "\n";
        }
        return datos;
    }

    /**
     * Para insertar un nuevo presidente
     * @param nombre
     * @param apellido
     * @param DNI
     * @param equipo
     * @throws Exception
     */
    public static void insertPresidente (String nombre, String apellido, String DNI,int equipo) throws Exception {
        presidente = new Presidente();
        presidente.setNombre(nombre);
        presidente.setApellido(apellido);
        presidente.setDNI(DNI);
        presidente.setEquipo(TEquipo.buscarPorId(new Equipo(equipo)));
        TPresidente.insert(presidente);
    }

    /**
     * Para modificar un presidente
     * @param ID
     * @param nombre
     * @param apellido
     * @param DNI
     * @param equipo
     * @throws Exception
     */
    public static void updatePresidente (int ID,String nombre, String apellido, String DNI,int equipo) throws Exception {
        presidente = new Presidente();
        presidente.setID(ID);
        presidente.setNombre(nombre);
        presidente.setApellido(apellido);
        presidente.setDNI(DNI);
        presidente.setEquipo(TEquipo.buscarPorId(new Equipo(equipo)));
        TPresidente.update(presidente);
    }

    /**
     * Para borrar un presidente
     * @param DNI
     * @throws Exception
     */
    public static void deletePresidente (String DNI) throws Exception {
        presidente = new Presidente();
        presidente.setDNI(DNI);
        TPresidente.delete(presidente);
    }

    /**
     * Para buscar y devolver los datos de todos los presidentes
     * @return
     * @throws Exception
     */
    public static String buscarTodosPresidentes () throws Exception {
        ArrayList<Presidente> listaPresidentes = TPresidente.buscarTodos();
        String datos = "";
        for (int x = 0; x < listaPresidentes.size(); x++) {
            datos += "\n ID_PRESIDENTE" + listaPresidentes.get(x).getID() + "\n\nNombre: " + listaPresidentes.get(x).getNombre() + "\nApellido: " + listaPresidentes.get(x).getApellido()
                    + "\nDNI: " + listaPresidentes.get(x).getDNI() + "\nEquipo :" + listaPresidentes.get(x).getEquipo().getID();
        }
        return datos;
    }

    /**
     * Para crear el cuadro de diálogo de los informes
     * @param tipo Para saber el tipo de informe
     */
    public static void crearDialogoInformes(String tipo){
        dInformes = new dInformes(tipo);
        dInformes.pack();
        dInformes.setVisible(true);
        dInformes.setLocationRelativeTo(vAdminPanel);
    }

    /**
     * Para ejecutar el PL/SQL de generar el calendario
     * @throws Exception
     */
    public static void generarCalendario() throws Exception {
        BaseDato.generarCalendario();
    }

    /**
     * Para ejecutar y devolver los datos del PL/SQL de verEnfrentamientos
     * @return
     * @throws Exception
     */
    public static ArrayList<ArrayList<Object>> verEnfrentamientos() throws Exception {
        return BaseDato.verEnfrentamientos();
    }
    /**
     * Para ejecutar y devolver los datos del PL/SQL del informe de los jugadores
     * @return
     * @throws SQLException
     */
    public static ArrayList<ArrayList<Object>> informeJugadores() throws SQLException {
        return BaseDato.obtener_datos_jugadores();
    }
    /**
     * Para ejecutar y devolver los datos del PL/SQL del informe de la clasificacion
     * @return
     * @throws Exception
     */
    public static ArrayList<ArrayList<Object>> informeClasificacion() throws Exception {
        return BaseDato.mostrarClasificacion();
    }

    /**
     * Para comprobar la fecha de expiracion
     * @param tipo Para saber de qué tipo de XML
     * @return
     * @throws Exception
     */
    public static boolean comprobarFechaExpiracion(String tipo) throws Exception {
        return TXMLs.buscarFechaExpiracion(tipo);
    }

    /**
     * Para crear el objeto de XML
     * @param tipo Para saber qué tipo de XML
     * @throws Exception
     */
    public static void crearObjetoXML(String tipo) throws Exception {
        switch (tipo){
            case "ultima" -> xml = TXMLs.buscarUltimaJornada();
            case "todas" -> xml = TXMLs.buscarTodasJornada();
            case "clasificacion" -> xml = TXMLs.buscarClasificacion();
        }

    }

    /**
     * Para convertir y guardar el archivo XML
     * @throws IOException
     */
    public static void convertirAXML() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            try {
                Document document = convertStringToDocument(xml.getXml());
                saveDocumentToFile(document, filePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Para convertir un Strig en un documento
     * @param xmlString
     * @return
     * @throws Exception
     */
    private static Document convertStringToDocument(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return (Document) builder.parse(new InputSource(new StringReader(xmlString)));
    }

    /**
     * Para guardar un documento
     * @param document
     * @param filePath
     * @throws IOException
     * @throws TransformerException
     * @throws TransformerException
     */
    private static void saveDocumentToFile(Document document, String filePath) throws IOException, TransformerException, TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource((Node) document);
        StreamResult result = new StreamResult(new FileWriter(filePath));
        transformer.transform(source, result);
    }

    /**
     * Para rellenar una combo con los DNIs de los presidentes
     * @return
     * @throws Exception
     */
    public static ArrayList<String> crearDniPresidente() throws Exception {
        listaPresidente = TPresidente.buscarTodos();
        ArrayList<String> listaDniPresidentes = new ArrayList<>();
        listaPresidente.forEach(dni -> listaDniPresidentes.add(dni.getDNI()));
        return listaDniPresidentes;
    }

    /**
     * Para buscar y devolver los datos de los presidentes por DNI
     * @param dni
     * @return
     * @throws Exception
     */
    public static String buscarDniPresidente (String dni) throws Exception {
        presidente = new Presidente();
        presidente.setDNI(dni);
        String datos = "";
        presidente = TPresidente.buscarPorDNI(presidente);
        datos += "\n ID_PRESIDENTE" + presidente.getID() + "\n\nNombre: " + presidente.getNombre() + "\nApellido: " + presidente.getApellido()
                + "\nDNI: " + presidente.getDNI() + "\nEquipo :" + presidente.getEquipo().getID();
        return datos;
    }

    /**
     * Para buscar y devolver los datos de los partidos por ID
     * @param id_partido
     * @return
     * @throws Exception
     */
    public static String buscarPartidosPorID(String id_partido) throws Exception {
        partido = new Partido();
        partido.setID(Integer.parseInt(id_partido));
        String datos = "";
        partido = TPartido.buscarPorIDPartido(partido);
        datos += "\n ID_PARTIDO" + partido.getID() + "\n\nTipo Partido: " + partido.getTipoPartido() + "\nHora: " + partido.getHora()
                + "\nEquipo Local: " + partido.getLocal().getNombre() + "\nEquipo Visitante: " + partido.getVisitante().getNombre() + "\nJornada: "
                + partido.getJornada().getID() + "\n";
        return datos;
    }

    /**
     * Para crear el cuadro de diálogo de insertar jugadores en un equipo
     */
    public static void dialogoJugadoresEquipo() {
        dInsertarEquiposJugadores  = new dInsertarEquiposJugadores();
        dInsertarEquiposJugadores.pack();
        dInsertarEquiposJugadores.setVisible(true);
        dInsertarEquiposJugadores.setLocationRelativeTo(vAdminPanel);
    }

    /**
     * Para crear el cuadro de diálogo de borrar jugadores en un equipo
     */
    public static void dialogoBorrarJugadoresEquipo() {
        dBorrarEquiposJugadores  = new dBorrarEquiposJugadores();
        dBorrarEquiposJugadores.pack();
        dBorrarEquiposJugadores.setVisible(true);
        dBorrarEquiposJugadores.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de diálogo de modificar jugadores en un equipo
     */
    public static void dialogoActualizarJugadoresEquipo() {
        dActualizarEquiposJugadores  = new dActualizarEquiposJugadores();
        dActualizarEquiposJugadores.pack();
        dActualizarEquiposJugadores.setVisible(true);
        dActualizarEquiposJugadores.setLocationRelativeTo(vAdminPanel);
    }
    /**
     * Para crear el cuadro de diálogo de buscar jugadores en un equipo
     */
    public static void dialogoBuscarJugadoresEquipo() {
        dBuscarEquiposJugadores  = new dBuscarEquiposJugadores();
        dBuscarEquiposJugadores.pack();
        dBuscarEquiposJugadores.setVisible(true);
        dBuscarEquiposJugadores.setLocationRelativeTo(vAdminPanel);
    }

    /**
     * Para insertar un nuevo jugador en un equipo
     * @param id_equipo
     * @param id_jugador
     * @param sueldo
     * @param fechaInicio
     * @param fechaFin
     * @param clausula
     * @throws Exception
     */
    public static void insertarEquiposJugadores(String id_equipo, String id_jugador , String sueldo,String fechaInicio,String fechaFin,String clausula) throws Exception {
        jugador = tJugadores.buscarPorID(new Jugador(Integer.parseInt(id_jugador)));
        equipo = TEquipo.buscarPorId(new Equipo(Integer.parseInt(id_equipo)));
        JugadorEquipo jugadorEquipo = new JugadorEquipo(jugador,equipo,LocalDate.parse(fechaInicio),LocalDate.parse(fechaFin),Double.parseDouble(sueldo),Double.parseDouble(clausula));
        TJugadorEquipo.insert(jugadorEquipo);
    }

    /**
     * Para borrar un jugador de un equipo
     * @param id_jugador
     * @throws Exception
     */
    public static void borrarEquiposJugadores(String id_jugador) throws Exception {
        jugador = tJugadores.buscarPorID(new Jugador(Integer.parseInt(id_jugador)));
        JugadorEquipo jugadorEquipo = new JugadorEquipo(jugador);
        TJugadorEquipo.delete(jugadorEquipo);
    }

    /**
     * Para modificar un jugador de un equipo
     * @param id_jugador
     * @param sueldo
     * @param fechaInicio
     * @param fechaFin
     * @param clausula
     * @throws Exception
     */
    public static void updateEquiposJugadores(String id_jugador , String sueldo,String fechaInicio,String fechaFin,String clausula) throws Exception {
        jugador = tJugadores.buscarPorID(new Jugador(Integer.parseInt(id_jugador)));
        JugadorEquipo jugadorEquipo = new JugadorEquipo(jugador,LocalDate.parse(fechaInicio),LocalDate.parse(fechaFin),Double.parseDouble(sueldo),Double.parseDouble(clausula));
        TJugadorEquipo.update(jugadorEquipo);
    }

    /**
     * Para busccar y devolver los datos de todos los jugadores de los equipos
     * @return
     * @throws Exception
     */
    public static String buscarEquiposJugadores() throws Exception {
        ArrayList<JugadorEquipo> listaJugadorEquipo = TJugadorEquipo.buscarTodos();
        String datos = "";
        for (int x = 0; x < listaJugadorEquipo.size(); x++) {
            datos += "\n ID_EQUIPO" + listaJugadorEquipo.get(x).getEquipo().getID() + "\n\nID_JUGADOR" +":" + listaJugadorEquipo.get(x).getJugador().getID()
                    + "\nSueldo: " + listaJugadorEquipo.get(x).getSueldo() + "\nFECHA INICIO: " + listaJugadorEquipo.get(x).getFechaInicio() + "\nFECHA FIN :" + listaJugadorEquipo.get(x).getFechaFin()
                    + "\nClausula" + listaJugadorEquipo.get(x).getClausula();
        }
        return datos;
    }

}