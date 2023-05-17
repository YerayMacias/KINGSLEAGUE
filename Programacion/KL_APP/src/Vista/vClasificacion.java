package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vClasificacion {
    private JPanel pMenu;
    private JLabel lNombre;
    private JPanel pCombo;
    private JPanel pClasificacion;
    private JPanel pTitulo;
    private JPanel pHeader;
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

        miPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vClasificacion.dispose();;
                Main.crearVentanaPartidos(admin);
            }
        });
    }

    public void inicializar() throws Exception {
        lNombreMenu.setText(Main.buscarNombre());
        lNombre.setText(Main.buscarNombre());
        if (Main.buscarAdmin().equalsIgnoreCase("S")) {
            lTipoUsuario.setText("Administrador");
        } else {
            lTipoUsuario.setText("Usuario");
        }

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
    public void generarPanelClasificacion() throws Exception {
        Main.buscarClasificacion();
        pClasificacion.add(Main.crearPanelesClasificacion());
    }

    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }
    public JPanel getpPrincipal() {
        return pPrincipal;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        pClasificacion = new JPanel(new GridLayout(1,1));
    }
}
