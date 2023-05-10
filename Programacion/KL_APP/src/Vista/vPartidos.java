package Vista;

import javax.swing.*;

public class vPartidos {
    private JPanel pMenu;
    private JLabel lNombre;
    private JPanel pCombo;
    private JComboBox cbJornadas;
    private JPanel pPrincipal;
    private JPanel pPartidos;
    private JPanel pHeader;
    private JPanel pContenedor;

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vPartidos");
        frame.setContentPane(new vPartidos().getpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
