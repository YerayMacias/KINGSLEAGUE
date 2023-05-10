package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Pattern;

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
                pfPassword.setText("");
            }
        });
        bIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validar(tfNombre.getText(), pfPassword.getText());
                Main.crearVentanaPrincipal();
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

    public void validar(String nombre, String contraseña){
        // validar datos
        try {
            if (nombre.length() < 3)
                throw new Exception();
        } catch (Exception e){
            System.out.println("Problemas con: " + e.getMessage());
        }
        try {
            //Main.validarUsuario(nombre, contraseña);
        } catch (Exception e) {
            System.out.println("Problemas " + e.getMessage());;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vLogin");
        frame.setContentPane(new vLogin().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
