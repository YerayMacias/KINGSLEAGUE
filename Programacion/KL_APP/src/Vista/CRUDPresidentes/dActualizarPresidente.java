package Vista.CRUDPresidentes;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class dActualizarPresidente extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbID;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfDNI;
    private JComboBox cbEquipo;

    public dActualizarPresidente() {

        try {
            ArrayList<String> idCBox = Main.crearIdPresidente();
            idCBox.forEach(id -> cbID.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }

        try {
            ArrayList<String> equipoCBox = Main.crearIdEquipos();
            equipoCBox.forEach(id -> cbEquipo.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }

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
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.actualizarStaff(cbID.getSelectedItem().toString(),tfNombre.getText(),tfApellido.getText(),tfDNI.getText(), String.valueOf(cbEquipo.getSelectedItem()));
                    JOptionPane.showMessageDialog(null, "El Presidente con ID " + cbID.getSelectedItem().toString() + "ha sido actualizado");
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
        dActualizarPresidente dialog = new dActualizarPresidente();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
