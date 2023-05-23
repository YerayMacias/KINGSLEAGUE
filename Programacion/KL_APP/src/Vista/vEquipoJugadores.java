package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Ventana para ver la informacion de los jugadores de un equipo
 * @author Explotacion de Iker
 * @version 1.0
 */
public class vEquipoJugadores {
    /**
     * Panel que contendra todos los componentes
     */
    private JPanel pPrincipal;
    /**
     * Panel del nombre del equipo
     */
    private JLabel jlNombreEquipo;
    /**
     * Textfield del nombre
     */
    private JTextField tfNombre;
    /**
     * Textfield del apellido
     */
    private JTextField tfApellido;
    /**
     * Textfield de posicion del jugador
     */
    private JTextField tfPosicion;
    /**
     * Textfield del tipo de jugador
     */
    private JTextField tfTipoJugador;
    /**
     * Boton de ir al inicio
     */
    private JButton bInicio;
    /**
     * Boton de ir al final
     */
    private JButton bFinal;
    /**
     * Boton de ir ataras
     */
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

    /**
     * Boton de ir al siguiente
     */
    private JButton bSiguiente;
    /**
     * Boton de salir
     */
    private JButton bSalir;

    /**
     * Constructor de la ventana
     * @param equipo Para saber de que equipo son los datos
     * @throws Exception
     */
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
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vEquipoJugadores.dispose();
            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public static void main(String[] args) {

    }
}