package Vista;

import javax.swing.*;

public class vPrincipal {
    private JPanel pPrincipal;
    private JPanel pMenu;
    private JPanel pDatos;
    private JPanel pPartidos;

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vPrincipal");
        frame.setContentPane(new vPrincipal().getpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
