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
    private JPanel pTitulo;
    private JPanel pCombo;
    private JPanel pEquiposGeneral;
    private JPanel pColumnaIzq;
    private JPanel pJijantes;
    private JPanel pPIO;
    private JPanel p1KFC;
    private JButton b1KFC;
    private JPanel pSaiyans;
    private JPanel pKuni;
    private JPanel pPorcinos;
    private JPanel pAniquiladores;
    private JPanel pMostoles;
    private JPanel pColumnaCentral;
    private JPanel pColumnaDer;
    private JPanel pTroncos;
    private JPanel pRayo;
    private JPanel pBarrio;
    private JPanel pBuyer;
    private JPanel pPrincipal;
    private JScrollPane spScroll;
    private JMenu mIconoPerfil;
    private JPanel pSecundario;
    private JMenuItem miPlayOffs;
    private JMenuItem miPrincipal;
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

    int numEquipo;
    // private J

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

        b1KFC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numEquipo = 1;
                    Main.crearVentanaEquipoJugadores(b1KFC.getText(), numEquipo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bAniquiladoresFC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numEquipo = 2;
                    Main.crearVentanaEquipoJugadores(bAniquiladoresFC.getText(), numEquipo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bElBarrio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numEquipo = 3;
                    Main.crearVentanaEquipoJugadores(bElBarrio.getText(), numEquipo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bJijantesFC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numEquipo = 4;
                    Main.crearVentanaEquipoJugadores(bJijantesFC.getText(), numEquipo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bKunisports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numEquipo = 5;
                    Main.crearVentanaEquipoJugadores(bKunisports.getText(), numEquipo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bLosTroncos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numEquipo = 6;
                    Main.crearVentanaEquipoJugadores(bLosTroncos.getText(), numEquipo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bPioFC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numEquipo = 7;
                    Main.crearVentanaEquipoJugadores(bPioFC.getText(), numEquipo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bPorcinosFC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numEquipo = 8;
                    Main.crearVentanaEquipoJugadores(bPorcinosFC.getText(), numEquipo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bRayoDeBarcelona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numEquipo = 9;
                    Main.crearVentanaEquipoJugadores(bRayoDeBarcelona.getText(), numEquipo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bSaiyansFC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numEquipo = 10;
                    Main.crearVentanaEquipoJugadores(bSaiyansFC.getText(), numEquipo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bUltimateMostoles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numEquipo = 11;
                    Main.crearVentanaEquipoJugadores(bUltimateMostoles.getText(), numEquipo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bXbuyerTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numEquipo = 12;
                    Main.crearVentanaEquipoJugadores(bXbuyerTeam.getText(), numEquipo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
     }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }

    public void inicializar() {
        lNombreMenu.setText(Main.buscarNombre());
        lNombre.setText(Main.buscarNombre());
        if (Main.buscarAdmin().equalsIgnoreCase("S")) {
            lTipoUsuario.setText("Administrador");
        } else {
            lTipoUsuario.setText("Usuario");
        }

        spScroll.getVerticalScrollBar().setUnitIncrement(20);

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
                    String nombre = listaNombres.get(posicion);
                    //Main.crearVentanaEquiposJugadores(nombre);
                }
            });
            bEquipo.setBackground(new Color(hex(listaColores.get(x))));
            bEquipo.setForeground(Color.WHITE);
            bEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            pSecundario.add(bEquipo);
        }
    }

    private int hex( String color_hex ) {
        String color = color_hex.substring(1, color_hex.length());
        return Integer.parseInt(color,  16 );
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        pSecundario = new JPanel(new GridLayout(4,4,4,4));
        pSecundario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    }
}
