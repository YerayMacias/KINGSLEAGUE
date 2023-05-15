package Vista;

import Controlador.Main;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class vPrincipal {
    private JPanel pPrincipal;
    private JPanel pMenu;
    private JPanel pDatos;
    private JPanel pPartidos;
    private JLabel lNombre;
    private JMenu mPartidos;
    private JMenu mClasificacion;
    private JMenuItem miEquipo;
    private JMenuItem miPartidos;
    private JMenuItem miClasificacion;
    private JMenuItem miPanel;
    private JLabel lNombreMenu;
    private JLabel lTipoUsuario;
    private JMenuItem miPerfil;
    private JMenuItem miCerrarSesion;
    private JMenuItem miBaseDatos;
    private JMenuItem miUsuarios;
    private Usuario usuario;

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

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
                Main.crearVentanaClasificacion(admin);
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
