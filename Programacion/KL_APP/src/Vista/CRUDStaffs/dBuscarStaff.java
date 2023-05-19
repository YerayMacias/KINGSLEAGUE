package Vista.CRUDStaffs;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class dBuscarStaff extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel pTitulo;
    private JButton bConsultar;
    private JPanel pTodos;
    private JTextArea taTodos;
    private JTextArea taCJID;
    private JComboBox cbID;
    private JTextArea taCJDNI;
    private JComboBox cbDNI;

    public dBuscarStaff() {
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
                    datos = Main.buscarTodosStaff();
                    taTodos.setText(datos);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cbID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = cbID.getSelectedItem().toString();

                String datos = null;
                try {
                    datos = Main.buscarStaffId(id);
                    taCJID.setText(datos);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cbDNI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dni = cbDNI.getSelectedItem().toString();

                String datos = null;
                try {
                    datos = Main.buscarStaffDNI(dni);
                    taCJDNI.setText(datos);
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
        dBuscarStaff dialog = new dBuscarStaff();
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
            ArrayList<String> idCBox = Main.crearStaff();
            idCBox.forEach(id ->cbID.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }
        try {
            ArrayList<String> idCBox = Main.crearStaffDNI();
            idCBox.forEach(dni ->cbDNI.addItem(dni));
        } catch (Exception exc) {
            System.out.println("problemas");
        }


    }
}
