package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

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
    private JButton bInsertE;
    private JButton bDeleteE;
    private JButton bInsertJ;
    private JButton bDeleteJ;
    private JButton bInserT;
    private JButton bDeteleT;
    private JButton bUpdateT;
    private JButton bBuscarTodosT;
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
    private JButton bUpdateEquipos;
    private JButton bBuscarTodosEquipos;
    private JButton bBuscarJornadas;
    private JMenuItem miPrincipal;
    private JButton bGenCal;
    private JButton bVerEnf;
    private JButton bInfJug;
    private JButton bInfCla;
    private JButton bUltJor;
    private JButton bAllJor;
    private JButton bClasi;
    private boolean expirado;

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public vAdminPanel (String admin) {
        inicializar();
        if (!admin.equalsIgnoreCase("S"))
            ocultarCosasAdmin();
        miCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vAdminPanel.dispose();
                ;
                Main.crearVentanaLogin();
            }
        });

        miClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vAdminPanel.dispose();
                ;
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
                Main.vAdminPanel.dispose();
                ;
                Main.crearVentanaPartidos(admin);
            }
        });

        miEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vAdminPanel.dispose();
                ;
                Main.crearVentanaEquipos(admin);
            }
        });

        miPlayOffs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vAdminPanel.dispose();
                try {
                    Main.crearVentanaPlayOffs(admin);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        miPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vAdminPanel.dispose();
                Main.crearVentanaPerfil(admin);
            }
        });

        miPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vAdminPanel.dispose();
                Main.crearVentanaPrincipal(admin);
            }
        });

        bInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertJugador(admin);
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
        });
        bInsertE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertEquipo(admin);
            }
        });
        bDeleteE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarEquipo(admin);
            }
        });
        bUpdateEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaUpdateEquipo(admin);
            }
        });
        bBuscarTodosEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarEquipo(admin);
            }
        });
        bInsertJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertJornada(admin);
            }
        });
        bDeleteJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarJornada(admin);
            }
        });
        bUpdateJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaUpdateJornada(admin);
            }
        });
        bBuscarJornadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarJornada(admin);
            }
        });
        bInsertarPres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertarPresidente(admin);
            }
        });
        bDeletePres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarPresidente(admin);
            }
        });
        bUpdatePres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaActualizarPresidente(admin);
            }
        });
        bBuscarPres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarPresidente(admin);
            }
        });
        bInsertS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertStaff(admin);
            }
        });
        bDeleteS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarStaff(admin);
            }
        });
        bUpdateS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaActualizarStaff(admin);
            }
        });
        bBuscarTodosS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarStaff(admin);
            }
        });
        bInserT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertTemporada(admin);
            }
        });
        bDeteleT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarTemporada(admin);
            }
        });
        bUpdateT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaActualizarTemporada(admin);
            }
        });
        bBuscarTodosT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarTemporada(admin);
            }
        });
        bInsertarU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertUsuario(admin);
            }
        });
        bDeleteU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarUsuario(admin);
            }
        });
        bUpdateU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaActualizarUsuario(admin);
            }
        });
        bBuscarTodosu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarUsuarios(admin);
            }
        });

        bGenCal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.generarCalendario();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        bVerEnf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearDialogoInformes("enfrentamientos");
            }
        });

        bInfJug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearDialogoInformes("jugadores");
            }
        });

        bInfCla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearDialogoInformes("clasificacion");
            }
        });
        bUltJor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    expirado = Main.comprobarFechaExpiracion("ultima");
                    if (!expirado) {
                        Main.crearObjetoXML("ultima");
                        Main.convertirAXML();
                    } else JOptionPane.showMessageDialog(null, "No se puede generar el xml por que todavia no ha expirado");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bAllJor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    expirado = Main.comprobarFechaExpiracion("todas");
                    if (!expirado){
                        Main.crearObjetoXML("todas");
                        Main.convertirAXML();
                    } else JOptionPane.showMessageDialog(null, "No se puede generar el xml por que todavia no ha expirado");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        bClasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    expirado = Main.comprobarFechaExpiracion("clasificacion");
                    if (!expirado) {
                        Main.crearObjetoXML("clasificacion");
                        Main.convertirAXML();
                    } else JOptionPane.showMessageDialog(null, "No se puede generar el xml por que todavia no ha expirado");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }


        public void inicializar(){
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
        }

        public void ocultarCosasAdmin () {
            miPanel.setVisible(false);
            miBaseDatos.setVisible(false);
            miUsuarios.setVisible(false);
        }




        public void setpPrincipal (JPanel pPrincipal){
            this.pPrincipal = pPrincipal;
        }

        private void createUIComponents () {
            // TODO: place custom component creation code here
        }
    }

