package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Para ver los partidos de la competicion
 * @author Explotacion de Iker
 * @version 1.0
 */
public class vPartidos {
    private JPanel pMenu;
    /**
     * Label del nombre
     */
    private JLabel lNombre;
    /**
     * ComboBox de las jornadas
     */
    private JComboBox cbJornadas;
    /**
     * Panel que tendra todos los componentes
     */
    private JPanel pPrincipal;
    /**
     * Menu de base de datos
     */
    private JMenuItem miBaseDatos;
    /**
     * Menu de usuarios
     */
    private JMenuItem miUsuarios;
    /**
     * Label para el nombre del menu
     */
    private JLabel lNombreMenu;
    /**
     * Label del tipo de usuario
     */
    private JLabel lTipoUsuario;
    /**
     * Menu del perfil del usuario
     */
    private JMenuItem miPerfil;
    /**
     * Menu del panel de admin
     */
    private JMenuItem miPanel;
    /**
     * Menu de cerrar sesion
     */
    private JMenuItem miCerrarSesion;
    /**
     * Menu de clasificacion
     */
    private JMenuItem miClasificacion;
    /**
     * Menu de partidos
     */
    private JMenuItem miPartidos;
    /**
     * Menu de equipos
     */
    private JMenuItem miEquipo;
    /**
     * Panel de los partidos
     */
    private JPanel pPartidos;
    /**
     * Menu del icono de perfil
     */
    private JMenu mIconoPerfil;
    private JPanel pTitulo;
    private JPanel pCombo;
    /**
     * Menu de los playoff
     */
    private JMenuItem miPlayOffs;
    /**
     * Menu de la ventana principal
     */
    private JMenuItem miPrincipal;

    /**
     * Constructor de la ventana
     * @param admin Para ocultar las cosas de administrador
     */
    public vPartidos(String admin) {
        if (!admin.equalsIgnoreCase("S"))
            ocultarCosasAdmin();
        try {
            inicializar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        miCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();
                Main.crearVentanaLogin();
            }
        });
        miPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();
                Main.crearVentanaPanelAdmin(admin);
            }
        });
        miEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();
                Main.crearVentanaEquipos(admin);
            }
        });

        miClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();
                try {
                    Main.crearVentanaClasificacion(admin);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        miPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();
                Main.crearVentanaPartidos(admin);
            }
        });

        miPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();
                Main.crearVentanaPrincipal(admin);
            }
        });

        miPlayOffs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();
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
                Main.vPartidos.dispose();
                Main.crearVentanaPerfil(admin);
            }
        });

        cbJornadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.actualizarPosicion(cbJornadas.getSelectedIndex());
                try {
                    pPartidos.removeAll();
                    pPartidos.add(Main.crearPanelesJornadas());
                    Main.actualizarVPartidos();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    /**
     * Para inicializar los estilos y datos de la ventana
     * @throws Exception
     */
    public void inicializar() throws Exception {
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

        Main.buscarJornadasTemporada();
        pPartidos.add(Main.crearPanelesJornadas());
        inicializarCombo();
    }

    /**
     * Para ocultar las cosas de administrador
     */
    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }

    /**
     * Para rellenar la comboBox de las jornadas
     */
    public void inicializarCombo(){
        ArrayList<String> itemsCombo = Main.rellenarComboJornadas();
        itemsCombo.forEach(item -> cbJornadas.addItem(item));
        cbJornadas.setSelectedIndex(-1);
    }

    /**
     * Para crear componentes
     */
    private void createUIComponents() {
        // TODO: place custom component creation code here
        pPartidos = new JPanel(new GridLayout(1,1));
    }
}
