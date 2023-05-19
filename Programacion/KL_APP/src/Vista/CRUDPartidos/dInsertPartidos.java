package Vista.CRUDPartidos;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class dInsertPartidos extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfHora;
    private JComboBox cbTipo;
    private JComboBox cbEquipoLocal;
    private JComboBox cbEquipoVisitante;
    private JTextField tfGolesLocal;
    private JTextField tfGolesVisitante;
    private JComboBox cbJornada;

    public dInsertPartidos() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        crearArrays();

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
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.insertPartido(cbTipo.getSelectedItem().toString(), tfHora.getText(), Integer.parseInt(cbEquipoLocal.getSelectedItem().toString()),
                            Integer.parseInt(cbEquipoLocal.getSelectedItem().toString()), Integer.parseInt(tfGolesLocal.getText()) , Integer.parseInt(tfGolesVisitante.getText()),
                            Integer.parseInt(tfGolesVisitante.getText()));
                    JOptionPane.showMessageDialog(null, "El Partido ha sido insertado");
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

    private void crearArrays() {
        try {
            ArrayList<String> idEquiposLocal = Main.crearIdEquipos();
            idEquiposLocal.forEach(id -> cbEquipoLocal.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }

        try {
            ArrayList<String> idEquiposVisitante = Main.crearIdEquipos();
            idEquiposVisitante.forEach(id -> cbEquipoVisitante.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }

        try {
            ArrayList<String> idCBox = Main.crearIdJornada();
            idCBox.forEach(id -> cbJornada.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }


    }

    public static void main(String[] args) {
        dInsertPartidos dialog = new dInsertPartidos();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
