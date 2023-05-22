package Vista;

import Controlador.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class vEquipos {
    private JLabel lNombre;
    private JMenuItem miBaseDatos;
    private JMenuItem miUsuarios;
    private JLabel lNombreMenu;
    private JLabel lTipoUsuario;
    private JMenuItem miPerfil;
    private JMenuItem miPanel;
    private JMenuItem miCerrarSesion;
    private JMenuItem miClasificacion;
    private JMenuItem miPartidos;
    private JMenuItem miEquipo;
    private JButton b1KFC;
    private JPanel pPrincipal;
    private JMenu mIconoPerfil;
    private JPanel pSecundario;
    private JMenuItem miPlayOffs;
    private JMenuItem miPrincipal;
    private JPanel pTitulo;
    private JPanel pCombo;
    private JButton bAniquiladoresFC;
    private JButton bElBarrio;
    private JButton bJijantesFC;
    private JButton bKunisports;
    private JButton bLosTroncos;
    private JButton bPioFC;
    private JButton bPorcinosFC;
    private JButton bRayoDeBarcelona;
    private JButton bSaiyansFC;
    private JButton bUltimateMostoles;
    private JButton bXbuyerTeam;

    private String nombreEquipo;

    /**
     * Constructor de la ventana
     * @param admin Para ocultar las cosas de administrador
     */
    public vEquipos(String admin) {
        inicializar();
         if (!admin.equalsIgnoreCase("S"))
             ocultarCosasAdmin();
         miCerrarSesion.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 Main.vEquipos.dispose();
                 Main.crearVentanaLogin();
             }
         });

         miClasificacion.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 Main.vEquipos.dispose();
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
                 Main.vEquipos.dispose();
                 Main.crearVentanaPartidos(admin);
             }
         });

        miPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vEquipos.dispose();
                Main.crearVentanaPrincipal(admin);
            }
        });

        miPlayOffs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vEquipos.dispose();
                try {
                    Main.crearVentanaPlayOffs(admin);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        miPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vEquipos.dispose();;
                Main.crearVentanaPanelAdmin(admin);
            }
        });

        miPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vEquipos.dispose();
                Main.crearVentanaPerfil(admin);
            }
        });


     }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    /**
     * Para ocultar las cosas de administrador
     */
    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }

    /**
     * Para inicializar los datos de la ventana
     */
    public void inicializar() {
        lNombreMenu.setText(Main.buscarNombre());
        lNombre.setText(Main.buscarNombre());
        if (Main.buscarAdmin().equalsIgnoreCase("S")) {
            lTipoUsuario.setText("Administrador");
        } else {
            lTipoUsuario.setText("Usuario");
        }


        miPrincipal.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        try {
            crearBotonesEquipos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Para crear los botones de los equipos
     * @throws Exception
     */

    public void crearBotonesEquipos() throws Exception {
        Main.buscarEquipos();
        // Coincidentes
        ArrayList<String> listaNombres = Main.getNombreEquipos();
        ArrayList<URL> listaURL = Main.getURLImagen();
        ArrayList<String> listaColores = Main.getColores();

        JButton bEquipo;
        for (int x = 0; x < listaNombres.size(); x++) {
            Image img;
            try {
                BufferedImage bufferedImage = ImageIO.read(listaURL.get(x));
                img = bufferedImage.getScaledInstance(80, 80, Image.SCALE_DEFAULT);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ImageIcon imageIcon = new ImageIcon(img);
            bEquipo = new JButton(listaNombres.get(x), new ImageIcon(img));
            int posicion = x;
            bEquipo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nombreEquipo = listaNombres.get(posicion);
                    try {
                        Main.crearVentanaEquipoJugadores(nombreEquipo);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            bEquipo.setBackground(new Color(hex(listaColores.get(x))));
            bEquipo.setForeground(Color.WHITE);
            bEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            pSecundario.add(bEquipo);
        }
    }

    /**
     * Para convertir hexadecimal a rgb
     * @param color_hex
     * @return
     */
    private int hex( String color_hex ) {
        String color = color_hex.substring(1, color_hex.length());
        return Integer.parseInt(color,  16 );
    }

    /**
     * Para crear componentes
     */
    private void createUIComponents() {
        // TODO: place custom component creation code here
        pSecundario = new JPanel(new GridLayout(4,4,4,4));
        pSecundario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    }
}
