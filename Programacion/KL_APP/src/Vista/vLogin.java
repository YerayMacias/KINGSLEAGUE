package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vLogin {
    private JPanel pPrincipal;
    private JTextField tfNombre;
    private JPanel pInfo;
    private JButton bIniciarSesion;
    private JButton REGISTRATEButton;
    private JPasswordField pfPassword;

    public vLogin() {
        inicializar();
        tfNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNombre.setText("");
            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void inicializar() {
        tfNombre.setBorder(BorderFactory.createCompoundBorder(tfNombre.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));
        pfPassword.setBorder(BorderFactory.createCompoundBorder(pfPassword.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vLogin");
        frame.setContentPane(new vLogin().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
