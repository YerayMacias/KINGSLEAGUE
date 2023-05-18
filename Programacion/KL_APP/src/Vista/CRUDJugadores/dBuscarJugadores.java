package Vista.CRUDJugadores;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class dBuscarJugadores extends JDialog {
    private JPanel contentPane;
    private JButton bConsultar;
    private JComboBox cbID;
    private JComboBox cbDNI;
    private JButton cancelarButton;
    private JButton aceptarButton;
    private JTextArea taCTJ;
    private JTextArea taCJID;
    private JTextArea taCJDNI;
    private JButton buttonOK;
    private JButton buttonCancel;

    public dBuscarJugadores() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
        bConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String datos = null;
                try {
                    datos = Main.buscarTodosJugadores();
                    taCTJ.setText(datos);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cbID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id_jugador = cbID.getSelectedItem().toString();

                    String datos = Main.buscarTodosLosJugadorPorID(id_jugador);
                    if (datos == null) {
                        throw new Exception("No se encuentra la informacion del Jugador");
                    } else {
                        taCJID.setText(datos);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cbDNI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              try {
                  String dni = cbDNI.getSelectedItem().toString();

                  String datos = Main.buscarTodosLosJugadorPorDNI(dni);

                  if (datos == null) {
                      throw new Exception("No se encuentra la informacion del Jugador");
                  } else {
                      taCJDNI.setText(datos);
                  }
              } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null,ex.getMessage());
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
        dBuscarJugadores dialog = new dBuscarJugadores();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
