package Vista.CRUDTemporadas;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class dBuscarTemporada extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton consultarTodosButton;
    private JPanel pTodos;
    private JTextArea taCJT;
    private JComboBox cbFechaInicio;
    private JTextArea taFechaInicio;
    private JComboBox cbEstado;
    private JTextArea taEstado;
    private JComboBox cbID;
    private JTextArea taID;
    private JTextArea taPeriodo;
    private JTextArea taFechaFin;
    private JComboBox cbFechaFin;
    private JComboBox cbPeriodo;

    public dBuscarTemporada() {
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
        cbFechaInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fecha = cbFechaInicio.getSelectedItem().toString();

                    String datos = Main.buscarTodasLasTemporadasFechaInicio(fecha);
                    if (datos == null) {
                        throw new Exception("No se encuentra la informacion de la Temporada");
                    } else {
                        taFechaInicio.setText(datos);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        cbFechaFin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fecha = cbFechaFin.getSelectedItem().toString();

                    String datos = Main.buscarTodasLasTemporadasFechaFin(fecha);
                    if (datos == null) {
                        throw new Exception("No se encuentra la informacion de la Temporada");
                    } else {
                        taFechaFin.setText(datos);
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
                    String id_temporada = cbID.getSelectedItem().toString();

                    String datos = Main.buscarTodasLasTemporadasID(id_temporada);
                    if (datos == null) {
                        throw new Exception("No se encuentra la informacion de la Temporada");
                    } else {
                        taID.setText(datos);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cbEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String estado = cbEstado.getSelectedItem().toString();

                    String datos = Main.buscarTodasLasTemporadasPorEstado(estado);
                    if (datos == null) {
                        throw new Exception("No se encuentra la informacion de la Temporada");
                    } else {
                        taEstado.setText(datos);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        cbPeriodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String periodo = cbPeriodo.getSelectedItem().toString();

                    String datos = Main.buscarTodasLasTemporadasPorPeriodo(periodo);
                    if (datos == null) {
                        throw new Exception("No se encuentra la informacion de la Temporada");
                    } else {
                        taPeriodo.setText(datos);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
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
        taFechaInicio.setEditable(false);
        taFechaFin.setEditable(false);
        taID.setEditable(false);
        taEstado.setEditable(false);
        taPeriodo.setEditable(false);

        pTodos.add(new JScrollPane(taCJT));
        taCJT.setRows(20);
        taCJT.setColumns(40);
        taCJT.setLineWrap(true);

    }

    public static void main(String[] args) {
        dBuscarTemporada dialog = new dBuscarTemporada();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
