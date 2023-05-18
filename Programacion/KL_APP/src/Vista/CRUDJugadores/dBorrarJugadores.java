package Vista.CRUDJugadores;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Controlador.*;
public class dBorrarJugadores extends JDialog {
    private JPanel contentPane;
    private JButton bBorrar;
    private JButton bCancelar;
    private JTextField tfDNI;

    public dBorrarJugadores() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(bBorrar);

        bBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        bCancelar.addActionListener(new ActionListener() {
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
        bBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pattern pat = Pattern.compile("[0-9]{8}[A-Za-z]");
                Matcher mat = pat.matcher(tfDNI.getText());
                if (!mat.matches()) {
                    JOptionPane.showMessageDialog(null, "DNI no válido");
                    tfDNI.setText("");
                    tfDNI.setBackground(Color.red);
                } else {
                    try {
                        Main.borrarJugador(tfDNI.getText());
                        JOptionPane.showMessageDialog(null," El jugador con dni " + tfDNI.getText() + " ha sido borrado");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

                //Main.borrarJugador(tfDNI.getText());

                // Main.borrarJugador(tfDNI.getText());

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
        dBorrarJugadores dialog = new dBorrarJugadores();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
