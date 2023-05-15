package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vPartidos {
    private JPanel pMenu;
    private JLabel lNombre;
    private JPanel pCombo;
    private JComboBox cbJornadas;
    private JPanel pPrincipal;
    private JPanel pHeader;
    private JPanel pContenedor;
    private JMenuItem miBaseDatos;
    private JMenuItem miUsuarios;
    private JLabel lNombreMenu;
    private JLabel lTipoUsuario;
    private JMenuItem miPerfil;
    private JMenuItem miPanel;
    private JMenuItem miCerrarSesion;
    private JMenuItem miClasificacion;
    private JMenuItem miPartidos;
    private JMenuItem miEquipo;
    private JScrollPane spScroll;
    private JPanel pPartidos;

    public vPartidos(String admin) {
        if (!admin.equalsIgnoreCase("S"))
            ocultarCosasAdmin();
        inicializar();
        miCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();
                Main.crearVentanaLogin();
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
                Main.crearVentanaClasificacion(admin);
            }
        });

        miPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();
                Main.crearVentanaPartidos(admin);
            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void inicializar() {
        lNombreMenu.setText(Main.buscarNombre());
        lNombre.setText(Main.buscarNombre());
        if (Main.buscarAdmin().equalsIgnoreCase("S")) {
            lTipoUsuario.setText("Administrador");
        } else {
            lTipoUsuario.setText("Usuario");
        }
    }
    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }

}
