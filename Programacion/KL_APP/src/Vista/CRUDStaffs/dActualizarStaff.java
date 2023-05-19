package Vista.CRUDStaffs;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class dActualizarStaff extends JDialog {
    private JPanel contentPane;
    private JComboBox cbID;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfDNI;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfRol;

    public dActualizarStaff() {
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
                    Main.actualizarStaff(tfNombre.getText(),tfRol.getText(),tfApellido.getText(),tfRol.getText(),cbID.getSelectedItem().toString());
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
        dActualizarStaff dialog = new dActualizarStaff();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
