package Vista.CRUDEquipos;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class dBorrarEquipo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbID;
    private JTextField tfNombre;
    private JButton bBorrar;

    public dBorrarEquipo() {

        try {
            ArrayList<String> idCBox = Main.crearIdEquipos();
            idCBox.forEach(id -> cbID.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }

        tfNombre.setEditable(false);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


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
        cbID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = cbID.getSelectedItem().toString();

                    String datos = Main.getNombreEquipoID(id);
                    if (datos == null) {
                        throw new Exception("No se encuentra la informacion del Equipo");
                    } else {
                        tfNombre.setText(datos);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.deleteEquipo(Integer.parseInt(cbID.getSelectedItem().toString()));
                    JOptionPane.showMessageDialog(null, "El Equipo" + tfNombre.getText() + " con ID " + cbID.getSelectedItem().toString() + " ha sido eliminado");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        dBorrarEquipo dialog = new dBorrarEquipo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
