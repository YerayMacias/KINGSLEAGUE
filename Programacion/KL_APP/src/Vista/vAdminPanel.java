package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class vAdminPanel {
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
    private JPanel pPrincipal;
    private JButton bInsert;
    private JButton bDelete;
    private JButton bBuscarDNI;
    private JButton bBuscarPorID;
    private JButton bInsertE;
    private JButton bDeleteE;
    private JButton bBuscarPorIDE;
    private JButton bBuscarNombreE;
    private JButton bInsertJ;
    private JButton bDeleteJ;
    private JButton bInserT;
    private JButton bDeteleT;
    private JButton bUpdateT;
    private JButton bBuscarTodosT;
    private JButton bBuscarPorTemporadaT;
    private JButton bBuscarPorIDT;
    private JButton bInsertarP;
    private JButton bDeleteP;
    private JButton bUpdateP;
    private JButton bBuscarTodosP;
    private JButton bBuscarPorIDPartido;
    private JButton bInsertarPres;
    private JButton bDeletePres;
    private JButton bUpdatePres;
    private JButton bBuscarPres;
    private JButton bInsertS;
    private JButton bDeleteS;
    private JButton bUpdateS;
    private JButton bBuscarTodosS;
    private JButton bInsertarU;
    private JButton bDeleteU;
    private JButton bUpdateU;
    private JButton bBuscarTodosu;
    private JButton bBuscarPorUsuario;
    private JButton bUpdateJ;
    private JButton updateButton;
    private JButton bBuscarTodosJ;
    private JPanel pTitulo;
    private JPanel pCombo;
    private JMenuItem miPlayOffs;

    public vAdminPanel (String admin) {
        inicializar();
        if (!admin.equalsIgnoreCase("S"))
            ocultarCosasAdmin();
       /* miCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vAdminPanel.dispose();;
                Main.crearVentanaLogin();
            }
        });

        miClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vAdminPanel.dispose();;
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
                Main.vAdminPanel.dispose();;
                Main.crearVentanaPartidos(admin);
            }
        });

        miEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vAdminPanel.dispose();;
                Main.crearVentanaEquipos(admin);
            }
        });

        miPlayOffs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vAdminPanel.dispose();
                Main.crearVentanaPlayOffs(admin);
            }
        });

        miPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vAdminPanel.dispose();;
                Main.crearVentanaPerfil(admin);
            }
        });
        /*
        bInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertsJugadores(admin);
            }
        });
        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarJugadores(admin);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaActualizarJugadores(admin);
            }
        });
        bBuscarTodosJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarjugadores(admin);
            }
        });*/
    }


   public void inicializar() {
       if (Main.buscarAdmin().equalsIgnoreCase("S")) {
           lTipoUsuario.setText("Administrador");
       } else {
           lTipoUsuario.setText("Usuario");
       }

       miPlayOffs.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }


    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void setpPrincipal(JPanel pPrincipal) {
        this.pPrincipal = pPrincipal;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
