package Vista.CRUDJornada;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;

public class dInsertarJornada extends JDialog {
    private JPanel contentPane;
    private JButton bInsertar;
    private JButton buttonCancel;
    private JTextField tfNumJornada;
    private JTextField tfFecha;
    private JComboBox cbPosicion;
    private JSpinner spTemporada;
    private JSpinner spNumJornada;

    public dInsertarJornada() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(bInsertar);

        bInsertar.addActionListener(new ActionListener() {
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
        bInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.insertarJornada((int) spTemporada.getValue(),(int) spNumJornada.getValue(),tfFecha.getText());
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
        dInsertarJornada dialog = new dInsertarJornada();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
