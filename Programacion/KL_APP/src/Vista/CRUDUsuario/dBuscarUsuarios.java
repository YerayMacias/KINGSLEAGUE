package Vista.CRUDUsuario;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class dBuscarUsuarios extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton consultarButton;
    private JTextArea taTodos;
    private JPanel pTodos;
    private JPanel pTitulo;
    private JButton bConsultar;
    private JTextArea taUPN;
    private JComboBox cbUser;

    public dBuscarUsuarios() {
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
                try {
                    String datos = "";
                    datos = Main.buscarTodosUsuarios();
                    taTodos.setText(datos);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cbUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = cbUser.getSelectedItem().toString();

                String datos = null;
                try {
                    datos = Main.buscarTodosUsuariosPorUser(user);
                    taUPN.setText(datos);
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
        dBuscarUsuarios dialog = new dBuscarUsuarios();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public void inicializar() {
        taTodos.setEditable(false);

        pTodos.add(new JScrollPane(taTodos));
        taTodos.setRows(20);
        taTodos.setColumns(40);
        taTodos.setLineWrap(true);

        try {
            ArrayList<String> idCBox = Main.crearUsuarios();
            idCBox.forEach(user ->cbUser.addItem(user));
        } catch (Exception exc) {
            System.out.println("problemas");
        }

    }
}
