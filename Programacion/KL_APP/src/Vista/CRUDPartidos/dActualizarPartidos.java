package Vista.CRUDPartidos;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class dActualizarPartidos extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbID;
    private JTextField tfHora;
    private JComboBox cbTipo;
    private JComboBox cbEquipoLocal;
    private JComboBox cbEquipoVisitante;
    private JTextField tfGolesLocal;
    private JTextField tfGolesVisitante;

    public dActualizarPartidos() {



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
       /*buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.updatePartido());
                    JOptionPane.showMessageDialog(null, "El Partido con ID " + cbID.getSelectedItem().toString() + " ha sido actualizado");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });*/
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
            ArrayList<String> nombreEquiposLocal = Main.crearNombreEquipos();
            nombreEquiposLocal.forEach(nombre -> cbEquipoLocal.addItem(nombre));
        } catch (Exception exc) {
            System.out.println("problemas");
        }

        try {
            ArrayList<String> nombreEquiposVisitante = Main.crearNombreEquipos();
            nombreEquiposVisitante.forEach(nombre -> cbEquipoVisitante.addItem(nombre));
        } catch (Exception exc) {
            System.out.println("problemas");
        }

        try {
            ArrayList<String> idCBox = Main.crearIdPartidos();
            idCBox.forEach(id -> cbID.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }

        try {
            ArrayList<String> tipoCBox = Main.crearTipoPartidos();
            tipoCBox.forEach(tipo -> cbTipo.addItem(tipo));
        } catch (Exception exc) {
            System.out.println("problemas");
        }
    }

    public static void main(String[] args) {
        dActualizarPartidos dialog = new dActualizarPartidos();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
