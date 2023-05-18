package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class vPerfil {
    private JLabel lNombre;
    private JMenuItem miBaseDatos;
    private JMenuItem miUsuarios;
    private JMenu mIconoPerfil;
    private JLabel lNombreMenu;
    private JLabel lTipoUsuario;
    private JMenuItem miPerfil;
    private JMenuItem miPanel;
    private JMenuItem miCerrarSesion;
    private JMenuItem miClasificacion;
    private JMenuItem miPartidos;
    private JMenuItem miEquipo;
    private JPanel pTitulo;
    private JPanel pCombo;
    private JPanel pInfo;
    private JPanel pPrincipal;
    private JLabel lNombreTitulo;
    private JPanel pDatos;
    private JLabel lTituloDatos;
    private JTextField tfNombre;
    private JTextField tfEmail;
    private JPasswordField pfPassNew;
    private JPasswordField pfPassNew2;
    private JPanel pGuardar2;
    private JButton bGuardarPass;
    private JLabel lTipoUsuarioTitulo;
    private JPasswordField pfPassVieja;
    private JButton bVisibleViejo;
    private JButton bVisibleNew;
    private JButton bVisibleNew2;
    private JButton bGuardarDatos;
    private JMenuItem miPlayOffs;
    private JMenuItem miPrincipal;
    private JMenu mPrincipal;
    private int contador;
    private String passUser;
    private String usuario;


    public vPerfil(String admin) {

        inicializar();

        bVisibleViejo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                if (contador%2!=0) {
                    pfPassVieja.setEchoChar((char) 0);
                    // Icon icono = new ImageIcon("/src/assets/visible-on.png");
                    // bVisible.setIcon(icono);
                } else {
                    pfPassVieja.setEchoChar('•');
                }
            }
        });

        miPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPerfil.dispose();;
                Main.crearVentanaPanelAdmin(admin);
            }
        });

        bVisibleNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                if (contador%2!=0) {
                    pfPassNew.setEchoChar((char) 0);
                    // Icon icono = new ImageIcon("/src/assets/visible-on.png");
                    // bVisible.setIcon(icono);
                } else {
                    pfPassNew.setEchoChar('•');
                }
            }
        });
        bVisibleNew2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                if (contador%2!=0) {
                    pfPassNew2.setEchoChar((char) 0);
                    // Icon icono = new ImageIcon("/src/assets/visible-on.png");
                    // bVisible.setIcon(icono);
                } else {
                    pfPassNew2.setEchoChar('•');
                }
            }
        });


        if (!admin.equalsIgnoreCase("S"))
            ocultarCosasAdmin();
        miCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPerfil.dispose();;
                Main.crearVentanaLogin();
            }
        });

        miClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPerfil.dispose();;
                try {
                    Main.crearVentanaClasificacion(admin);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        miPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPerfil.dispose();;
                Main.crearVentanaPartidos(admin);
            }
        });

        miEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPerfil.dispose();;
                Main.crearVentanaEquipos(admin);
            }
        });

        miPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPerfil.dispose();
                Main.crearVentanaPrincipal(admin);
            }
        });

        miPlayOffs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPerfil.dispose();
                try {
                    Main.crearVentanaPlayOffs(admin);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        bGuardarPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                 if (pfPassVieja.getText().isEmpty() || pfPassNew.getText().isEmpty() || pfPassNew2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Los campos de 'Contraseña' son obligatorios");
                } else if (!pfPassNew.getText().equals(pfPassNew2.getText())) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                    pfPassNew.setForeground(Color.red);
                    pfPassNew2.setForeground(Color.red);
                } else {
                    try {
                        usuario = Main.buscarNombre();
                        passUser = Main.getPassUser(usuario);
                        if (!pfPassVieja.getText().equals(passUser)) {
                            throw new Exception("La contraseña antigua es incorrecta");
                        }
                        Main.updateUsuarioPass(usuario, pfPassNew.getText());
                        JOptionPane.showMessageDialog(null, "Cambios realizados correctamente");
                        pfPassNew2.setForeground(null);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "FAILED CHANGES", JOptionPane.WARNING_MESSAGE);
                        pfPassVieja.setForeground(Color.red);
                        pfPassVieja.setBackground(new Color(217, 141, 141));
                    }

                }
            }
        });

        bGuardarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Pattern pat = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
                Matcher mat = pat.matcher(tfEmail.getText());

                if (pfPassVieja.getText().isEmpty() && pfPassNew.getText().isEmpty() && pfPassNew2.getText().isEmpty()) {
                    if (tfNombre.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "El campo 'Nombre de Usuario' es obligatorio");
                        tfNombre.setForeground(Color.red);
                    } else if (!mat.matches()) {
                        JOptionPane.showMessageDialog(null, "El email no tiene un formato válido (ejemplo@gmail.com)");
                        tfEmail.setForeground(Color.red);
                    } else {
                        try {
                            Main.updateUsuario(tfNombre.getText(), tfEmail.getText());
                            JOptionPane.showMessageDialog(null, "Cambios realizados correctamente");
                            tfNombre.setForeground(null);
                            tfEmail.setForeground(null);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }

            }

        });
    }

    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }

    public void inicializar() {

        tfNombre.setBorder(BorderFactory.createCompoundBorder(tfNombre.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));
        tfEmail.setBorder(BorderFactory.createCompoundBorder(tfEmail.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));
        pfPassVieja.setBorder(BorderFactory.createCompoundBorder(pfPassVieja.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));
        pfPassNew.setBorder(BorderFactory.createCompoundBorder(pfPassNew.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));
        pfPassNew2.setBorder(BorderFactory.createCompoundBorder(pfPassNew2.getBorder(),BorderFactory.createEmptyBorder(2,15,2,6)));

        tfEmail.setText(Main.buscarCorreo());
        tfNombre.setText(Main.buscarNombre());
        lNombreTitulo.setText(Main.buscarNombre());
        lNombreMenu.setText(Main.buscarNombre());
        lNombre.setText(Main.buscarNombre());

        if (Main.buscarAdmin().equalsIgnoreCase("S")) {
            lTipoUsuario.setText("Administrador");
            lTipoUsuarioTitulo.setText("ADMINISTRADOR");
        } else {
            lTipoUsuario.setText("Usuario");
            lTipoUsuarioTitulo.setText("USUARIO");
        }

        miPrincipal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bVisibleNew.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bVisibleNew2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bVisibleViejo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bGuardarPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPartidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miClasificacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miBaseDatos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mIconoPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miUsuarios.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

}

