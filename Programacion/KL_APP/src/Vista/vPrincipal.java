package Vista;

import Controlador.Main;

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

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public vPrincipal(String admin) {
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

        /* public void validar(String admin) {

        }*/
    }
}
