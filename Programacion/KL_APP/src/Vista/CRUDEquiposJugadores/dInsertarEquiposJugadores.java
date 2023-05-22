package Vista.CRUDEquiposJugadores;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class dInsertarEquiposJugadores extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfSueldo;
    private JTextField tfFechaInicio;
    private JComboBox cbEquipo;
    private JComboBox cbJugador;
    private JTextField tfFechaFin;
    private JTextField tfClausula;

    public dInsertarEquiposJugadores() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        inicializar();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.insertarEquiposJugadores(cbEquipo.getSelectedItem().toString(),cbJugador.getSelectedItem().toString(),tfSueldo.getText(),tfFechaInicio.getText(),tfFechaFin.getText(),tfClausula.getText());
                    JOptionPane.showInputDialog(null,"Jugador insertado correctamente");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        dInsertarEquiposJugadores dialog = new dInsertarEquiposJugadores();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public void inicializar() {
        try {
            ArrayList<String> idCBox = Main.crearIdJugadores();
            idCBox.forEach(idJugador -> cbJugador.addItem(idJugador));
        } catch (Exception exc) {
            System.out.println("problemas");
        }
        try {
            ArrayList<String> idCBox = Main.crearIdEquipos();
            idCBox.forEach(idEquipo-> cbEquipo.addItem(idEquipo));
        } catch (Exception exc) {
            System.out.println("problemas");
        }
    }
}
