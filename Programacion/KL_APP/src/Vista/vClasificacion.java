package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class vClasificacion {
    private JPanel pMenu;
    private JLabel lNombre;
    private JPanel pClasificacion;
    private JPanel pPrincipal;
    private JMenuItem miBaseDatos;
    private JLabel lNombreMenu;
    private JLabel lTipoUsuario;
    private JMenuItem miPerfil;
    private JMenuItem miPanel;
    private JMenuItem miCerrarSesion;
    private JMenuItem miUsuarios;
    private JMenuItem miClasificacion;
    private JMenuItem miPartidos;
    private JMenuItem miEquipo;
    private JMenu mIconoPerfil;
    private JPanel pTitulo;
    private JPanel pCombo;
    private JMenuItem miPlayOffs;
    private JMenuItem miPrincipal;

    /**
     * Constructor de la ventana
     * @param admin Para ocultar las cosas de administrador
     */
    public vClasificacion(String admin) {
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
                Main.vClasificacion.dispose();;
                Main.crearVentanaLogin();
            }
        });

        miEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vClasificacion.dispose();;
                Main.crearVentanaEquipos(admin);
            }
        });
        miPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vClasificacion.dispose();;
                Main.crearVentanaPanelAdmin(admin);
            }
        });

        miPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vClasificacion.dispose();;
                Main.crearVentanaPartidos(admin);
            }
        });

        miPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vClasificacion.dispose();
                Main.crearVentanaPrincipal(admin);
            }
        });

        miPlayOffs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vClasificacion.dispose();
                try {
                    Main.crearVentanaPlayOffs(admin);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    /**
     * Para inicializar los estilos de la ventana
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
        generarPanelClasificacion();
    }

    /**
     * Para añadir el panel de la clasificacion a la ventana
     * @throws Exception
     */
    public void generarPanelClasificacion() throws Exception {
        Main.buscarClasificacion();
        pClasificacion.add(Main.crearPanelesClasificacion());
    }

    /**
     * Para ocultar las cosas de administrador
     */
    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    /**
     * Para crear componentes
     */
    private void createUIComponents() {
        // TODO: place custom component creation code here
        pClasificacion = new JPanel(new GridLayout(2,1));
        pClasificacion.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
}
