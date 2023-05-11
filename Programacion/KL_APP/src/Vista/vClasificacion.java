package Vista;

import Controlador.Main;

import javax.swing.*;
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

    public vClasificacion(String admin) {
        if (!admin.equalsIgnoreCase("S"))
            ocultarCosasAdmin();
        miCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vClasificacion.dispose();;
                Main.crearVentanaLogin();
            }
        });
    }

    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }
    public JPanel getpPrincipal() {
        return pPrincipal;
    }



}
