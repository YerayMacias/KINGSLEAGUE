package Vista.CRUDEquipos;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class dInsertarEquipo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfNombre;
    private JTextField tfPresupuesto;

    public dInsertarEquipo() {
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
                    // Validaciones
                    Main.insertEquipo(tfNombre.getText(), Double.parseDouble(tfPresupuesto.getText()));
                    JOptionPane.showMessageDialog(null, "El Equipo " + tfNombre.getText() + " ha sido insertado");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getClass() + ex.getMessage());
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

    public static void main(String[] args) {
        dInsertarEquipo dialog = new dInsertarEquipo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
