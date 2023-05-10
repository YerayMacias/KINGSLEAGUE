package Vista;

import javax.swing.*;

public class vClasificacion {
    private JPanel pMenu;
    private JLabel lNombre;
    private JPanel pCombo;
    private JPanel pClasificacion;
    private JPanel pTitulo;
    private JPanel pHeader;
    private JPanel pPrincipal;
    private JMenu mEquipos;
    private JMenu mPartidos;
    private JMenu mClasificacion;

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vClasificacion");
        frame.setContentPane(new vClasificacion().getpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
