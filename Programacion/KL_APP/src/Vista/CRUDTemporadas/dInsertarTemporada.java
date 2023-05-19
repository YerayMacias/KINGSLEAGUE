package Vista.CRUDTemporadas;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class dInsertarTemporada extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfFechaInicio;
    private JTextField tfFechaFin;
    private JRadioButton rdAbierto;
    private JRadioButton rdCerrado;
    private JRadioButton rdINV;
    private JRadioButton rdVER;
    private String estado;
    private String periodo;

    public dInsertarTemporada() {
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
                    Main.insertarTemporada(tfFechaInicio.getText(),tfFechaFin.getText(),estado,periodo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        rdAbierto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rdAbierto.isSelected()){
                    estado = "ABIERTO";
                }
            }
        });
        rdCerrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rdCerrado.isSelected()){
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

    public static void main(String[] args) {
        dInsertarTemporada dialog = new dInsertarTemporada();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
