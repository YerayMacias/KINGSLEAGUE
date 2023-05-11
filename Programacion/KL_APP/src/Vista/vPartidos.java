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
    private JPanel pPartidos;
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

    public vPartidos(String admin) {
        if (!admin.equalsIgnoreCase("S"))
            ocultarCosasAdmin();
        miCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();;
                Main.crearVentanaLogin();
            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }

}
