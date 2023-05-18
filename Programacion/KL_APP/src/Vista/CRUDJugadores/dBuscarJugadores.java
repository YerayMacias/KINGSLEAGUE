package Vista.CRUDJugadores;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class dBuscarJugadores extends JDialog {
    private JPanel contentPane;
    private JButton bConsultar;
    private JComboBox cbID;
    private JComboBox cbDNI;
    private JTextArea taCTJ;
    private JTextArea taCJDNI;
    private JTextArea taCJID;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel pTitulo;
    private JPanel pTodos;
    private JTextArea taTodos;

    public dBuscarJugadores() {
        inicializar();
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
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        dBuscarJugadores dialog = new dBuscarJugadores();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void crearArrays() {
        try {
            ArrayList<String> idCBox = Main.crearIdJugadores();
            idCBox.forEach(id ->cbID.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }
        try {
            ArrayList<String> dniCBox = Main.crearDniJugadores();
            dniCBox.forEach(dni ->cbDNI.addItem(dni));
        } catch (Exception exc) {
            System.out.println("problemas");
        }
    }

    private void inicializar() {

        crearArrays();

        taCTJ.setEditable(false);
        taCJID.setEditable(false);
        taCJDNI.setEditable(false);

        pTodos.add(new JScrollPane(taCTJ));
        taCTJ.setRows(20);
        taCTJ.setColumns(40);
        taCTJ.setLineWrap(true);
    }
}
