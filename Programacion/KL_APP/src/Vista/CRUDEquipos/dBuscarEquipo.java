package Vista.CRUDEquipos;

import Controlador.Main;
import Vista.CRUDJugadores.dBuscarJugadores;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class dBuscarEquipo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel pTitulo;
    private JButton bConsultar;
    private JPanel pTodos;
    private JTextArea taTodos;
    private JTextArea taCJNombre;
    private JComboBox cbNombre;
    private JTextArea taCJID;
    private JComboBox cbID;

    public dBuscarEquipo() {
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
                    datos = Main.buscarTodosEquipos();
                    taTodos.setText(datos);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cbNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = cbNombre.getSelectedItem().toString();

                    String datos = Main.buscarTodosLosEquiposPorNombre(nombre);
                    if (datos == null) {
                        throw new Exception("No se encuentra la informacion del Equipo");
                    } else {
                        taCJNombre.setText(datos);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cbID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = cbID.getSelectedItem().toString();

                    String datos = Main.buscarTodosLosJugadorPorID(id);

                    if (datos == null) {
                        throw new Exception("No se encuentra la informacion del Equipo");
                    } else {
                        taCJID.setText(datos);
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
            idCBox.forEach(id -> cbNombre.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }
        try {
            ArrayList<String> dniCBox = Main.crearDniJugadores();
            dniCBox.forEach(dni -> cbID.addItem(dni));
        } catch (Exception exc) {
            System.out.println("problemas");
        }
    }

    private void inicializar() {

        crearArrays();

        taTodos.setEditable(false);
        taCJID.setEditable(false);
        taCJNombre.setEditable(false);

        pTodos.add(new JScrollPane(taTodos));
        taTodos.setRows(20);
        taTodos.setColumns(40);
        taTodos.setLineWrap(true);
    }
}
