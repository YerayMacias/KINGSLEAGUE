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
    private JMenu mEquipos;
    private JMenu mPartidos;
    private JMenu mClasificacion;

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public vPrincipal(String admin) {
        mPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // Main.crearVentanaPartidos();
            }
        });

        mClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // Main.crearVentanaClasificacion();
            }
        });

    }
}
