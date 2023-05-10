package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class vLogin {
    private JPanel pPrincipal;
    private JTextField tfNombre;
    private JPanel pInfo;
    private JButton bIniciarSesion;
    private JButton REGISTRATEButton;
    private JPasswordField pfPassword;
    private JButton button1;

    public vLogin() {
        inicializar();
        tfNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tfNombre.setText("");
            }
        });
        pfPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                pfPassword.setText("");
            }
        });
        bIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.abrirVentanaPrincipal();
            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void inicializar() {
        button1.requestFocus();
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
