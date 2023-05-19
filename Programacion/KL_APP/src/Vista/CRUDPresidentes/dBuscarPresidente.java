package Vista.CRUDPresidentes;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class dBuscarPresidente extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel pTitulo;
    private JButton bConsultar;
    private JPanel pTodos;
    private JTextArea taTodos;
    private JComboBox cbID;
    private JTextArea taCJDNI;
    private JComboBox cbDNI;

    public dBuscarPresidente() {
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
                    datos = Main.buscarTodosPresidentes();
                    taTodos.setText(datos);
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
                    datos = Main.buscarDniPresidente(dni);
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
        dBuscarPresidente dialog = new dBuscarPresidente();
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
            ArrayList<String> idCBox = Main.crearIdPresidente();
            idCBox.forEach(id ->cbID.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }
        try {
            ArrayList<String> dniCBox = Main.crearDniPresidente();
            dniCBox.forEach(dni ->cbDNI.addItem(dni));
        } catch (Exception exc) {
            System.out.println("problemas");
        }


    }
}
