package Vista.CRUDPresidentes;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dInsertarPresidente extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfDNI;
    private JComboBox cbEquipo;

    public dInsertarPresidente() {

        try {
            ArrayList<String> idCBox = Main.crearIdEquipos();
            idCBox.forEach(id -> cbEquipo.addItem(id));
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
                Pattern pat = Pattern.compile("[0-9]{8}[A-Za-z]");
                Matcher mat = pat.matcher(tfDNI.getText());

                if (mat.matches()) {
                    try {
                        Main.insertPresidente(tfNombre.getText(), tfApellido.getText(), tfDNI.getText(), (int) cbEquipo.getSelectedItem());
                        JOptionPane.showMessageDialog(null,"El Presidente " + tfNombre.getText() + " ha sido insertado");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El formato del dni no es correcto introduzcalo de la siguiente manera 12345678X");
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
        dInsertarPresidente dialog = new dInsertarPresidente();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
