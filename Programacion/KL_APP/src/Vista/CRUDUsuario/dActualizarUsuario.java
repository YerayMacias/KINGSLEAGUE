package Vista.CRUDUsuario;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class dActualizarUsuario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbID;
    private JTextField tfUser;
    private JTextField tfEmail;
    private JTextField tfPassword;
    private JRadioButton rdSI;
    private JRadioButton rdNO;
    private String tipo;

    public dActualizarUsuario() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        try {
            inicializar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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
                    Main.actualizarUsuario(tfEmail.getText(),tfPassword.getText(),tfUser.getText(),cbID.getSelectedItem().toString(),tipo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        rdSI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rdSI.isSelected()) {
                    tipo = "S";
                }
            }
        });
        rdNO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rdNO.isSelected()){
                    tipo = "N";
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

    private void inicializar() throws Exception {
        ArrayList<String> idCBox = Main.crearIdStaff();
        idCBox.forEach(id -> cbID.addItem(id));
    }

    public static void main(String[] args) {
        dActualizarUsuario dialog = new dActualizarUsuario();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
