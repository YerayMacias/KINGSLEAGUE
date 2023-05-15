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
    private JButton bRegistro;
    private JPasswordField pfPassword;
    private JButton button1;
    private JButton bVisible;
    private JLabel icono;
    private int contador;

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
        pfPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                pfPassword.setEchoChar('•');
            }
        });

        bIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validar(tfNombre.getText(), pfPassword.getText());
            }
        });
        bRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vLogin.dispose();
                Main.crearVentanaRegistro();
            }
        });
        bVisible.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                if (contador%2!=0) {
                    pfPassword.setEchoChar((char) 0);
                    // Icon icono = new ImageIcon("/src/assets/visible-on.png");
                    // bVisible.setIcon(icono);
                } else {
                    pfPassword.setEchoChar('•');
                }
            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void inicializar() {
        bVisible.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bRegistro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bVisible.requestFocus();
        tfNombre.setBorder(BorderFactory.createCompoundBorder(tfNombre.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));
        pfPassword.setBorder(BorderFactory.createCompoundBorder(pfPassword.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));
        pfPassword.setEchoChar((char) 0);

    }

    public void validar(String nombre, String password){
        // validar datos
        try {
            Main.validarUsuario(nombre, password);
            if (nombre.length() < 3)
                throw new Exception();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "FAILED LOGIN", JOptionPane.WARNING_MESSAGE);
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
