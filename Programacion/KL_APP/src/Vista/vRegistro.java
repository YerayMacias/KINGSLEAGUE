package Vista;

import Controlador.Main;
import Modelo.ClasesObjetos.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class vRegistro {
    private JPanel pInfo;
    private JButton bRegistro;
    private JTextField tfNombre;
    private JButton button1;
    private JPasswordField pfPassword;
    private JPasswordField pfPassword2;
    private JCheckBox ckAdmin;
    private JPanel pPrincipal;
    private JTextField tfEmail;
    private JPasswordField pfPasswordAdm;
    private JButton bVisible;
    private JButton bVisible2;
    private JButton bVisibleAdm;
    private JButton bAtras;
    private int contador;
    private String passAdm;

    /**
     * Constructor de la ventana, también tienes las validaciones
     */
    public vRegistro() {
        inicializar();
         ckAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ckAdmin.isSelected()) {
                    pfPasswordAdm.setVisible(true);
                    bVisibleAdm.setVisible(true);
                } else {
                    pfPasswordAdm.setVisible(false);
                    bVisibleAdm.setVisible(false);
                }
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
        bVisible2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                if (contador%2!=0) {
                    pfPassword2.setEchoChar((char) 0);
                    // Icon icono = new ImageIcon("/src/assets/visible-on.png");
                    // bVisible.setIcon(icono);
                } else {
                    pfPassword2.setEchoChar('•');
                }
            }
        });
        bVisibleAdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                if (contador%2!=0) {
                    pfPasswordAdm.setEchoChar((char) 0);
                    // Icon icono = new ImageIcon("/src/assets/visible-on.png");
                    // bVisible.setIcon(icono);
                } else {
                    pfPasswordAdm.setEchoChar('•');
                }
            }
        });

        bAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vRegistro.dispose();
                Main.crearVentanaLogin();
            }
        });
        bRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pattern pat = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
                Matcher mat = pat.matcher(tfEmail.getText());

                if (tfNombre.getText().isEmpty() || tfNombre.getText().equals("NOMBRE DE USUARIO")) {
                    JOptionPane.showMessageDialog(null, "El campo 'Nombre de Usuario' es obligatorio");
                    tfNombre.setForeground(Color.red);
                } else if (!mat.matches()) {
                    JOptionPane.showMessageDialog(null, "El email no tiene un formato válido (ejemplo@gmail.com)");
                    tfEmail.setForeground(Color.red);
                } else if (pfPassword.getText().isEmpty() || pfPassword.getText().equals("CONTRASEÑA") || pfPassword2.getText().equals("CONFIRMAR CONTRASEÑA")) {
                    JOptionPane.showMessageDialog(null, "El campo 'Contraseña' es obligatorio");
                    pfPassword.setForeground(Color.red);
                } else if (!pfPassword.getText().equals(pfPassword2.getText())) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                    pfPassword.setForeground(Color.red);
                    pfPassword2.setForeground(Color.red);
                } else if (ckAdmin.isSelected()) {
                    try {
                        passAdm = Main.getPassAdm();
                        if (!pfPasswordAdm.getText().equals(passAdm)) {
                            throw new Exception("La contraseña de Adminisrtador es incorrecta");
                        }
                        Main.registrarUsuario(tfNombre.getText(), tfEmail.getText(), pfPassword.getText(), Usuario.tUsuario.valueOf("S"));
                        JOptionPane.showMessageDialog(null, "El usuario " + tfNombre.getText() + " ha sido insertado");
                        pfPassword2.setForeground(Color.red);
                        pfPassword.setForeground(Color.red);
                        pfPasswordAdm.setForeground(Color.red);
                        tfEmail.setForeground(Color.red);
                        tfNombre.setForeground(Color.red);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "FAILED LOGIN", JOptionPane.WARNING_MESSAGE);
                        pfPasswordAdm.setForeground(Color.red);
                    }
                } else {
                    try {
                        Main.registrarUsuario(tfNombre.getText(), tfEmail.getText(), pfPassword.getText(), Usuario.tUsuario.valueOf("N"));
                        JOptionPane.showMessageDialog(null, "El usuario " + tfNombre.getText() + " ha sido insertado");
                        pfPassword2.setForeground(Color.red);
                        pfPassword.setForeground(Color.red);
                        tfEmail.setForeground(Color.red);
                        tfNombre.setForeground(Color.red);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(null, exc.getMessage());
                    }

                }
            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    /**
     * Para inicializar los datos y estilos de la ventana
     */
    public void inicializar() {

        bVisible.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bVisible2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bVisibleAdm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bRegistro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bAtras.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pfPassword.setEchoChar((char) 0);
        pfPassword2.setEchoChar((char) 0);
        pfPasswordAdm.setEchoChar((char) 0);

        pfPasswordAdm.setVisible(false);
        bVisibleAdm.setVisible(false);

        if (tfNombre.getText().trim().equals("NOMBRE DE USUARIO")) {
            tfNombre.setText("");
        }

        tfNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfNombre.getText().trim().equals("NOMBRE DE USUARIO")) {
                    tfNombre.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if(tfNombre.getText().isEmpty()) {
                    tfNombre.setText("NOMBRE DE USUARIO");
                }
            }
        });

        tfEmail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfEmail.getText().trim().equals("EMAIL")) {
                    tfEmail.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if(tfEmail.getText().isEmpty()) {
                   tfEmail.setText("EMAIL");
                }
            }
        });

        pfPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (pfPassword.getText().trim().equals("CONTRASEÑA")) {
                    pfPassword.setEchoChar('•');
                    pfPassword.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if(pfPassword.getText().isEmpty()) {
                    pfPassword.setText("CONTRASEÑA");
                }
            }
        });


        pfPassword2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (pfPassword2.getText().trim().equals("CONFIRMAR CONTRASEÑA")) {
                    pfPassword2.setEchoChar('•');
                    pfPassword2.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if(pfPassword2.getText().isEmpty()) {
                    pfPassword2.setText("CONFIRMAR CONTRASEÑA");
                }
            }
        });

        pfPasswordAdm.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (pfPasswordAdm.getText().trim().equals("CONTRASEÑA ADMINISTRADOR")) {
                    pfPasswordAdm.setEchoChar('•');
                    pfPasswordAdm.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if(pfPasswordAdm.getText().isEmpty()) {
                    pfPasswordAdm.setText("CONTRASEÑA ADMINISTRADOR");
                }
            }
        });

        tfNombre.setBorder(BorderFactory.createCompoundBorder(tfNombre.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));
        tfEmail.setBorder(BorderFactory.createCompoundBorder(tfEmail.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));
        pfPassword.setBorder(BorderFactory.createCompoundBorder(pfPassword2.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));
        pfPassword2.setBorder(BorderFactory.createCompoundBorder(pfPassword2.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));
        pfPasswordAdm.setBorder(BorderFactory.createCompoundBorder(pfPasswordAdm.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vRegistro");
        frame.setContentPane(new vRegistro().getpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


