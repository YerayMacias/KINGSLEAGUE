package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vEquipoJugadores {
    private JPanel pPrincipal;
    private JLabel jlNombreEquipo;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfPosicion;
    private JTextField tfTipoJugador;
    private JButton bInicio;
    private JButton bFinal;
    private JButton bAtras;

    public JTextField getTfNombre() {
        return tfNombre;
    }

    public JTextField getTfApellido() {
        return tfApellido;
    }

    public JTextField getTfPosicion() {
        return tfPosicion;
    }

    public JTextField getTfTipoJugador() {
        return tfTipoJugador;
    }

    private JButton bSiguiente;

    public vEquipoJugadores(String equipo) throws Exception {

        jlNombreEquipo.setText(equipo);

        tfNombre.setText(Main.getNombreSelect());
        tfApellido.setText(Main.getApellidoSelect());
        tfPosicion.setText(Main.getPosicionSelect());
        tfTipoJugador.setText(Main.getTipoJugadorSelect());

        bAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.posteriorJugador();
                if (Main.contadorJugador() < 0) {
                    Main.ultimoJugador();
                    tfNombre.setText(Main.getNombreSelect());
                    tfApellido.setText(Main.getApellidoSelect());
                    tfPosicion.setText(Main.getPosicionSelect());
                    tfTipoJugador.setText(Main.getTipoJugadorSelect());
                } else {
                    tfNombre.setText(Main.getNombreSelect());
                    tfApellido.setText(Main.getApellidoSelect());
                    tfPosicion.setText(Main.getPosicionSelect());
                    tfTipoJugador.setText(Main.getTipoJugadorSelect());
                }


            }
        });
        bSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.siguienteJugador();
                 if (Main.contadorJugador() > 9) {
                    Main.primerJugador();
                    tfNombre.setText(Main.getNombreSelect());
                    tfApellido.setText(Main.getApellidoSelect());
                    tfPosicion.setText(Main.getPosicionSelect());
                    tfTipoJugador.setText(Main.getTipoJugadorSelect());
                } else {
                    tfNombre.setText(Main.getNombreSelect());
                    tfApellido.setText(Main.getApellidoSelect());
                    tfPosicion.setText(Main.getPosicionSelect());
                    tfTipoJugador.setText(Main.getTipoJugadorSelect());
                }

            }
        });
        bInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.primerJugador();
                tfNombre.setText(Main.getNombreSelect());
                tfApellido.setText(Main.getApellidoSelect());
                tfPosicion.setText(Main.getPosicionSelect());
                tfTipoJugador.setText(Main.getTipoJugadorSelect());
            }
        });
        bFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ultimoJugador();
                tfNombre.setText(Main.getNombreSelect());
                tfApellido.setText(Main.getApellidoSelect());
                tfPosicion.setText(Main.getPosicionSelect());
                tfTipoJugador.setText(Main.getTipoJugadorSelect());
            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public static void main(String[] args) {

    }
}