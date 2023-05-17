package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vPlayOffs {
    private JLabel lNombre;
    private JMenuItem miBaseDatos;
    private JMenuItem miUsuarios;
    private JMenu mIconoPerfil;
    private JLabel lNombreMenu;
    private JLabel lTipoUsuario;
    private JMenuItem miPerfil;
    private JMenuItem miPanel;
    private JMenuItem miCerrarSesion;
    private JMenuItem miClasificacion;
    private JMenuItem miPartidos;
    private JMenuItem miEquipo;
    private JPanel pPrincipal;
    private JPanel pTitulo;
    private JPanel pCombo;
    private JPanel pDatos;
    private JPanel pCuartosIzqTop;
    private JPanel pFinal;
    private JPanel pCuartosDerTop;
    private JPanel pCuartosIzqBot;
    private JPanel pCuartosDerBot;
    private JPanel pFinalDer;
    private JPanel pFinalIzq;
    private JPanel pSemiIzqTop;
    private JPanel pSemiIzq;
    private JMenuItem miPlayOffs;

    public vPlayOffs(String admin) {

        inicializar();
        if (!admin.equalsIgnoreCase("S"))
            ocultarCosasAdmin();

        miPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPlayOffs.dispose();
                Main.crearVentanaPartidos(admin);
            }
        });

        miClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPlayOffs.dispose();
                try {
                    Main.crearVentanaClasificacion(admin);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        miEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPlayOffs.dispose();
                Main.crearVentanaEquipos(admin);
            }
        });

        miPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPlayOffs.dispose();
                Main.crearVentanaPerfil(admin);
            }
        });

        miCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPlayOffs.dispose();
                Main.crearVentanaLogin();
            }
        });
    }

    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }

    public void inicializar() {

        lNombreMenu.setText(Main.buscarNombre());
        lNombre.setText(Main.buscarNombre());

        if (Main.buscarAdmin().equalsIgnoreCase("S")) {
            lTipoUsuario.setText("Administrador");
        } else {
            lTipoUsuario.setText("Usuario");
        }

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

    public JPanel getpPrincipal() {
        return pPrincipal;
    }


}


