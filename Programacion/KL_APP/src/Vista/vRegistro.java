package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
    private int contador;

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
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void inicializar() {

        bVisible.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bVisible2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bVisibleAdm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bRegistro.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pfPasswordAdm.setVisible(false);
        bVisibleAdm.setVisible(false);

        tfNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tfNombre.setText("");
            }
        });
        tfEmail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tfEmail.setText("");
            }
        });

        pfPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                pfPassword.setText("");
            }
        });
        pfPassword.setEchoChar((char) 0);
        pfPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                pfPassword.setEchoChar('•');
            }
        });

        pfPassword2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                pfPassword2.setText("");
            }
        });
        pfPassword2.setEchoChar((char) 0);
        pfPassword2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                pfPassword2.setEchoChar('•');
            }
        });

        pfPasswordAdm.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                pfPasswordAdm.setText("");
            }
        });
        pfPasswordAdm.setEchoChar((char) 0);
        pfPasswordAdm.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {pfPasswordAdm.setEchoChar('•');
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


