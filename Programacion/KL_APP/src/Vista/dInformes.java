package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

import Controlador.*;

/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class dInformes extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lInforme;
    private JScrollPane spTabla;
    private JTable tTabla;
    private String tipoGen;

    /**
     * Construcor del cuadro de diálogo
     * @param tipo para saber el tipo de informe
     */
    public dInformes(String tipo) {
        tipoGen = tipo;
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
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    /**
     * Para la creacion de componentes y de la tabla que contendra los datos de los informes
     * @throws Exception
     */
    private void createUIComponents() throws Exception {
        // TODO: place custom component creation code here
        lInforme = new JLabel(inicializarTitulo());
        ArrayList<ArrayList<Object>> datosTabla = inicializarArrays();
        DefaultTableModel dtm = new DefaultTableModel();
        String[] cabecera = inicializarCabecera();
        dtm.setColumnIdentifiers(cabecera);
        tTabla = new JTable(datosTabla.size(), datosTabla.get(0).size());
        tTabla.setModel(dtm);

        for (int x = 0; x < datosTabla.size(); x++) {
            Object[] temp = datosTabla.get(x).toArray();
            dtm.addRow(temp);
        }

    }

    /**
     * Para devolver los datos de los informes
     * @return
     * @throws Exception
     */
    private ArrayList<ArrayList<Object>> inicializarArrays() throws Exception{
        switch (tipoGen){
            case "enfrentamientos" -> {
                return Main.verEnfrentamientos();
            }
            case "jugadores" -> {
                return Main.informeJugadores();
            }
            case "clasificacion" -> {
                return Main.informeClasificacion();
            }
        }
        return null;
    }

    /**
     * Para generar las cabeceras de las tablas de informes
     * @return
     */
    private String[] inicializarCabecera() {
        String[] cabecera;
        switch (tipoGen) {
            case "enfrentamientos" -> {
                return cabecera = new String[]{"ID_PARTIDO", "LOCAL", "VISITANTE", "ID_JORNADA", "HORA"};
            }
            case "jugadores" -> {
                return cabecera = new String[]{"NOMBRE", "APELLIDO", "DNI", "POSICION", "EQUIPO", "SUELDO", "CLAUSULA"};
            }
            case "clasificacion" -> {
                return cabecera = new String[]{"EQUIPO", "VICTORIAS", "DERROTAS", "GOLES A FAVOR", "GOLES EN CONTRA", "DIFERENCIA DE GOLES"};
            }
        }
        return null;
    }

    /**
     * Para cambiar el texto del JLabel de título dependiendo del informe
     * @return
     */
    private String inicializarTitulo() {
        switch (tipoGen) {
            case "enfrentamientos" -> {
                return "VER ENFRENTAMIENTOS | KL";
            }
            case "jugadores" -> {
                return "INFORME JUGADORES | KL";
            }
            case "clasificacion" -> {
                return "INFORME CLASIFICACION | KL";
            }
        }
        return null;
    }
}
