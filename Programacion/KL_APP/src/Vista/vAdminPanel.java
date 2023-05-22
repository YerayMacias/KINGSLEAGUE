package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Explotacion de Iker
 * @version 1.0
 */
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
    private JButton SEinsert;
    private JButton SEDelete;
    private JButton SEUpdate;
    private JButton SEBuscar;
    private JButton bGenCal;
    private JButton bVerEnf;
    private JButton bInfJug;
    private JButton bInfCla;
    private JButton bUltJor;
    private JButton bAllJor;
    private JButton bClasi;
    private JButton JEinsert;
    private JButton JEUpdate;
    private JButton JEDelete;
    private JButton JEBuscar;
    private boolean expirado;

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public vAdminPanel (String admin) {
        inicialiar();
        if (!admin.equalsIgnoreCase("S"))
            ocultarCosasAdmin();
        miCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vAdminPanel.dispose();
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
                Main.crearVentanaInsertJugador();
            }
        });
        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarJugadores();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaActualizarJugadores();
            }
        });
        bBuscarTodosJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarjugadores();
            }
        });
        bInsertE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertEquipo();
            }
        });
        bDeleteE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarEquipo();
            }
        });
        bUpdateEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaUpdateEquipo();
            }
        });
        bBuscarTodosEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarEquipo();
            }
        });
        bInsertJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertJornada();
            }
        });
        bDeleteJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarJornada();
            }
        });
        bUpdateJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaUpdateJornada();
            }
        });
        bBuscarJornadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarJornada();
            }
        });
        bInsertarPres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertarPresidente();
            }
        });
        bDeletePres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarPresidente();
            }
        });
        bUpdatePres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaActualizarPresidente();
            }
        });
        bBuscarPres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarPresidente();
            }
        });
        bInsertS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertStaff();
            }
        });
        bDeleteS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarStaff();
            }
        });
        bUpdateS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaActualizarStaff();
            }
        });
        bBuscarTodosS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarStaff();
            }
        });
        bInserT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertTemporada();
            }
        });
        bDeteleT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarTemporada();
            }
        });
        bUpdateT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaActualizarTemporada();
            }
        });
        bBuscarTodosT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarTemporada();
            }
        });
        bInsertarU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertUsuario();
            }
        });
        bDeleteU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarUsuario();
            }
        });
        bUpdateU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaActualizarUsuario();
            }
        });
        bBuscarTodosu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarUsuarios();
            }
        });

        SEinsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertarStaffEquipo();
            }
        });
        SEDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarStaffEquipo();
            }
        });
        SEUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaActualizarStaffEquipo();
            }
        });
        SEBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBuscarStaffEquipo();
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
                        } else
                            JOptionPane.showMessageDialog(null, "No se puede generar el xml por que todavia no ha expirado");
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
                        if (!expirado) {
                            Main.crearObjetoXML("todas");
                            Main.convertirAXML();
                        } else
                            JOptionPane.showMessageDialog(null, "No se puede generar el xml por que todavia no ha expirado");
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
                        } else
                            JOptionPane.showMessageDialog(null, "No se puede generar el xml por que todavia no ha expirado");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

        bInsertarP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearDialogoInsertarPartido();
            }
        });
        bUpdateP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearDialogoActualizarPartido();
            }
        });
        bDeleteP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearDialogoBorrarPartidos();
            }
        });
        bBuscarTodosP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearDialogoBuscarPartidos();
            }
        });
        JEinsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dialogoJugadoresEquipo();
            }
        });
        JEDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dialogoBorrarJugadoresEquipo();
            }
        });
        JEUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dialogoActualizarJugadoresEquipo();
            }
        });
        JEBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dialogoBuscarJugadoresEquipo();
            }
        });
    }


        public void inicialiar(){
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
        private void createUIComponents () {
            // TODO: place custom component creation code here
        }
    }
