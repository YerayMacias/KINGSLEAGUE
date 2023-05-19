package Vista.CRUDTemporadas;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class dActualizarTemporada extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbID;
    private JTextField tfFechaIncio;
    private JTextField tfFechaFin;
    private JRadioButton rdCERRADO;
    private JRadioButton rdABIERTO;
    private JRadioButton rdINV;
    private JRadioButton rdVER;
    private String estado;
    private String periodo;

    public dActualizarTemporada() {
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
                    Main.ActualizarTemporada(tfFechaFin.getText(),cbID.getSelectedItem().toString(),tfFechaFin.getText(),estado,periodo);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        rdABIERTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rdABIERTO.isSelected()){
                    estado = "ABIERTO";
                }
            }
        });
        rdCERRADO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rdCERRADO.isSelected()){
                    estado = "CERRADO";
                }
            }
        });
        rdINV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rdINV.isSelected()){
                    periodo = "INV";
                }
            }
        });
        rdVER.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rdVER.isSelected()){
                    periodo = "VER";
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
        ArrayList<String> idCBox = Main.crearIDTemporada();
        idCBox.forEach(id -> cbID.addItem(id));
    }
    public static void main(String[] args) {
        dActualizarTemporada dialog = new dActualizarTemporada();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
