package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Ventana Principal de la Aplicación
 * @author Explotacion de Iker
 * @version 1.0
 */
public class vPrincipal {
    /**
     * Panel contenedor de todos los datos
     */
    private JPanel pPrincipal;
    /**
     * Label Nombre de Usuario
     */
    private JLabel lNombre;
    /**
     * Menu de Equipo
     */
    private JMenuItem miEquipo;
    /**
     * Menu de Partidos
     */
    private JMenuItem miPartidos;
    /**
     * Menu de Clasificacion
     */
    private JMenuItem miClasificacion;
    /**
     *
     * Menu de Panel de Usuario
     */
    private JMenuItem miPanel;
    /**
     * Label nombre de usuario panel
     */
    private JLabel lNombreMenu;
    /**
     * Label tipo de usuario panel
     */
    private JLabel lTipoUsuario;
    /**
     * Menu de Perfil
     */
    private JMenuItem miPerfil;
    /**
     * Menu de Cerrar Sesion
     */
    private JMenuItem miCerrarSesion;
    /**
     * Menu de Base de Datos
     */
    private JMenuItem miBaseDatos;
    /**
     * Menu de Usuarios
     */
    private JMenuItem miUsuarios;
    /**
     * Menu de Icono de Perfil
     */
    private JMenu mIconoPerfil;
    /**
     * Menu de PlayOffs
     */
    private JMenuItem miPlayOffs;
    private JPanel pTitulo;
    private JPanel pCombo;
    /**
     * Menu Principal
     */
    private JMenuItem miPrincipal;


    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    /**
     * Constructor de la ventana
     * @param admin Para ocultar cosas de administrador
     */
    public vPrincipal(String admin) {

        if (!admin.equalsIgnoreCase("S"))
            ocultarCosasAdmin();
        inicializar();
        miPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaPartidos(admin);
            }
        });

        miClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.crearVentanaClasificacion(admin);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        miCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPrincipal.dispose();;
                Main.crearVentanaLogin();

            }
        });

        miEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPrincipal.dispose();
                Main.crearVentanaEquipos(admin);
            }
        });

        miPlayOffs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPrincipal.dispose();
                try {
                    Main.crearVentanaPlayOffs(admin);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        miPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPrincipal.dispose();
                Main.crearVentanaPerfil(admin);
            }
        });

        miPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaPanelAdmin(admin);
            }
        });

        miPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaPrincipal(admin);
            }
        });

    }

    /**
     * Para inicializar los estilos y datos de la ventana
     */
    public void inicializar() {



        lNombreMenu.setText(Main.buscarNombre());
        lNombre.setText(Main.buscarNombre());
        if (Main.buscarAdmin().equalsIgnoreCase("S")) {
            lTipoUsuario.setText("Administrador");
        } else {
            lTipoUsuario.setText("Usuario");
        }

        miPrincipal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPlayOffs.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPartidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miClasificacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miBaseDatos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mIconoPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miUsuarios.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    /**
     * Para ocultar las cosas de administrador
     */
    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }

}
