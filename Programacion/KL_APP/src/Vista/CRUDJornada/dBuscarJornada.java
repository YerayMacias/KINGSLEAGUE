package Vista.CRUDJornada;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class dBuscarJornada extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton consultarTodosButton;
    private JComboBox cbFecha;
    private JComboBox cbID;
    private JComboBox cbTemporada;
    private JTextArea taCJT;
    private JPanel pTodos;
    private JTextArea taFecha;
    private JTextArea taID;
    private JTextArea taTemporada;

    public dBuscarJornada() {
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
      /*  cbFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fecha = cbFecha.getSelectedItem().toString();

                    String datos = Main.buscarTodasLasJornadasFecha(fecha);
                    if (datos == null) {
                        throw new Exception("No se encuentra la informacion de la Jornada");
                    } else {
                        taFecha.setText(datos);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }); */
     /*   cbID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id_jornada = cbID.getSelectedItem().toString();

                    String datos = Main.buscarTodasLasJornadasID(id_jornada);
                    if (datos == null) {
                        throw new Exception("No se encuentra la informacion de la Jornada");
                    } else {
                        taID.setText(datos);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }); */
       /* cbTemporada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String temporada = cbID.getSelectedItem().toString();

                    String datos = Main.buscarTodasLasJornadasPorTemporada(temporada);
                    if (datos == null) {
                        throw new Exception("No se encuentra la informacion de la Jornada");
                    } else {
                        taTemporada.setText(datos);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }); */
        consultarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String datos = null;

                try {
                    datos = Main.buscarTodasLasJornadas();
                    taCJT.setText(datos);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void onOK() {
        // add your code here
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void inicializar() {

        taCJT.setEditable(false);
        taFecha.setEditable(false);
        taTemporada.setEditable(false);
        taID.setEditable(false);

        pTodos.add(new JScrollPane(taCJT));
        taCJT.setRows(20);
        taCJT.setColumns(40);
        taCJT.setLineWrap(true);

    }

    public static void main(String[] args) {
        dBuscarJornada dialog = new dBuscarJornada();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


}
