package Vista;

import Controlador.Main;
import Modelo.ClasesBasesDatos.TTemporadas;
import Modelo.ClasesObjetos.Equipo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JLabel lPosicion1;
    private JLabel lPosicion8;
    private JLabel lPosicion4;
    private JLabel lPosicion5;
    private JLabel lPosicion2;
    private JLabel lPosicion7;
    private JLabel lPosicion3;
    private JLabel lPosicion6;
    private JLabel lEquipo1;
    private JLabel lEquipo8;
    private JLabel lEquipo4;
    private JLabel lEquipo5;
    private JLabel lEquipo2;
    private JLabel lEquipo7;
    private JLabel lEquipo3;
    private JLabel lEquipo6;
    private JLabel lEquipoSemiIzqTop;
    private JLabel lEquipoSemiIzqBot;
    private JLabel lEquipoSemiDerTop;
    private JLabel lEquipoSemiDerBot;
    private JLabel lEquipoFinalDer;
    private JLabel lEquipoFinalIzq;
    private JMenuItem miPrincipal;

    public vPlayOffs(String admin) throws Exception {
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

        miPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPlayOffs.dispose();
                Main.crearVentanaPrincipal(admin);
            }
        });
    }

    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }

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

        datos();
    }

    public void datos() throws Exception {

        ArrayList<Object> listaArrays = TTemporadas.buscarClasificacion();
        Main.listaEquipos = (ArrayList<Equipo>) listaArrays.get(0);
        Main.listaPosicion = (ArrayList<Integer>) listaArrays.get(6);

        lPosicion1.setText(Main.listaPosicion.get(0).toString());
        lEquipo1.setText(Main.listaEquipos.get(0).getNombre());
        lPosicion8.setText(Main.listaPosicion.get(7).toString());
        lEquipo8.setText(Main.listaEquipos.get(7).getNombre());

        lPosicion4.setText(Main.listaPosicion.get(3).toString());
        lEquipo4.setText(Main.listaEquipos.get(3).getNombre());
        lPosicion5.setText(Main.listaPosicion.get(4).toString());
        lEquipo5.setText(Main.listaEquipos.get(4).getNombre());

        lPosicion2.setText(Main.listaPosicion.get(1).toString());
        lEquipo2.setText(Main.listaEquipos.get(1).getNombre());
        lPosicion7.setText(Main.listaPosicion.get(6).toString());
        lEquipo7.setText(Main.listaEquipos.get(6).getNombre());

        lPosicion3.setText(Main.listaPosicion.get(2).toString());
        lEquipo3.setText(Main.listaEquipos.get(2).getNombre());
        lPosicion6.setText(Main.listaPosicion.get(5).toString());
        lEquipo6.setText(Main.listaEquipos.get(5).getNombre());

    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }


}


