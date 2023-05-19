package Vista.CRUDPartidos;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class dBuscarPartidos extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel pTitulo;
    private JButton bConsultar;
    private JPanel pTodos;
    private JTextArea taTodos;
    private JTextArea taCJID;
    private JComboBox cbID;

    public dBuscarPartidos() {
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
                    datos = Main.buscarTodosPartidos();
                    taTodos.setText(datos);
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

                    String datos = Main.buscarPartidosPorID(id);

                    if (datos == null) {
                        throw new Exception("No se encuentra la informacion del Partido");
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
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        dBuscarPartidos dialog = new dBuscarPartidos();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void crearArrays() {

        try {
            ArrayList<String> idCBox = Main.crearIdPartidos();
            idCBox.forEach(id -> cbID.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }
    }

    private void inicializar() {

        crearArrays();

        taTodos.setEditable(false);
        taCJID.setEditable(false);

        pTodos.add(new JScrollPane(taTodos));
        taTodos.setRows(20);
        taTodos.setColumns(40);
        taTodos.setLineWrap(true);
    }

}
