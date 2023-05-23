package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Ventana del panel de administrador
 * @author Explotacion de Iker
 * @version 1.0
 */
public class vAdminPanel {
    /**
     * Label del nombre
     */
    private JLabel lNombre;
    /**
     * Menu Item de base de datos
     */
    private JMenuItem miBaseDatos;
    /**
     * Menu item de Usuarios
     */
    private JMenuItem miUsuarios;
    /**
     * Menu item de icono de perfil
     */
    private JMenu mIconoPerfil;
    /**
     * Label del nombre de menu
     */
    private JLabel lNombreMenu;
    /**
     * Label del tipo de usuario
     */
    private JLabel lTipoUsuario;
    /**
     * Menu item del perfil
     */
    private JMenuItem miPerfil;
    /**
     * Menu item del panel de admin
     */
    private JMenuItem miPanel;
    /**
     * Menu Item de cerrar sesion
     */
    private JMenuItem miCerrarSesion;
    /**
     * Menu Item de la clasificacion
     */
    private JMenuItem miClasificacion;
    /**
     * Menu item de partidos
     */
    private JMenuItem miPartidos;
    /**
     * Menu item del equipo
     */
    private JMenuItem miEquipo;
    /**
     * Panel principal donde estaran todos los componentes
     */
    private JPanel pPrincipal;
    /**
     * Boton insert jugadores
     */
    private JButton bInsert;
    /**
     * Boton borrar jugador
     */
    private JButton bDelete;
    /**
     * Botono insertar equipo
     */
    private JButton bInsertE;
    /**
     * Boton borrar equipo
     */
    private JButton bDeleteE;
    /**
     * Boton Insertar Jugadores
     */
    private JButton bInsertJ;
    /**
     * Boton borrar Jornada
     */
    private JButton bDeleteJ;
    /**
     * Boton insertar jornada
     */
    private JButton bInserT;
    /**
     * Boton borrar temporada
     */
    private JButton bDeteleT;
    /**
     * Boton modificar temporada
     */
    private JButton bUpdateT;
    /**
     * Boton buscar todas las temporadas
     */
    private JButton bBuscarTodosT;
    /**
     * Boton insertar partido
     */
    private JButton bInsertarP;
    /**
     * Boton borrar partido
     */
    private JButton bDeleteP;
    /**
     * Boton modificar partido
     */
    private JButton bUpdateP;
    /**
     * Boton buscar todos los partidos
     */
    private JButton bBuscarTodosP;
    /**
     * Boton insertar presidente
     */
    private JButton bInsertarPres;
    /**
     * Boton borrar presidente
     */
    private JButton bDeletePres;
    /**
     * Boton modificar presidente
     */
    private JButton bUpdatePres;
    /**
     * Boton buscar presidentes
     */
    private JButton bBuscarPres;
    /**
     * Boton insert staff
     */
    private JButton bInsertS;
    /**
     * Boton borrar staff
     */
    private JButton bDeleteS;
    /**
     * Boton actualizar staff
     */
    private JButton bUpdateS;
    /**
     * Boton buscar todos los staffs
     */
    private JButton bBuscarTodosS;
    /**
     * Boton insertar usuario
     */
    private JButton bInsertarU;
    /**
     * Boton borrar usuario
     */
    private JButton bDeleteU;
    /**
     * Boton modificar usuario
     */
    private JButton bUpdateU;
    /**
     * Boton buscar todos los usuarios
     */
    private JButton bBuscarTodosu;
    /**
     * Boton modificar jugadores
     */
    private JButton bUpdateJ;
    /**
     * Boton modificar jugadores
     */
    private JButton updateButton;
    /**
     * Boton buscar todas las jornadas
     */
    private JButton bBuscarTodosJ;
    /**
     * Panel del titulo
     */
    private JPanel pTitulo;
    /**
     * Panel de las comboBox
     */
    private JPanel pCombo;
    /**
     * Menu item de los playoffs
     */
    private JMenuItem miPlayOffs;
    /**
     * Botono modificar equipos
     */
    private JButton bUpdateEquipos;
    /**
     * Boton buscar todos los equipos
     */
    private JButton bBuscarTodosEquipos;
    /**
     * Boton buscar jornadas
     */
    private JButton bBuscarJornadas;
    /**
     * Menu item de la ventana principal
     */
    private JMenuItem miPrincipal;
    /**
     * Boton insertar StaffEquipo
     */
    private JButton SEinsert;
    /**
     * Boton borrar StaffEquipo
     */
    private JButton SEDelete;
    /**
     * Boton modificar StaffEquipo
     */
    private JButton SEUpdate;
    /**
     * Boton buscar staffequipo
     */
    private JButton SEBuscar;
    /**
     * Boton generar el calendario
     */
    private JButton bGenCal;
    /**
     * Boton para ver enfrentamientos
     */
    private JButton bVerEnf;
    /**
     * Boton para ver el Informe de los jugadores
     */
    private JButton bInfJug;
    /**
     * Boton para ver el Informe clasificacion
     */
    private JButton bInfCla;
    /**
     * Boton para ultima jornada
     */
    private JButton bUltJor;
    /**
     * Boton para todas las jornadas
     */
    private JButton bAllJor;
    /**
     * Boton de la clasificacion
     */
    private JButton bClasi;
    /**
     * Boton insertar jugador equipo
     */
    private JButton JEinsert;
    /**
     * Boton modificar equipo
     */
    private JButton JEUpdate;
    /**
     * Boton borrar jugador equipo
     */
    private JButton JEDelete;
    /**
     * Boton buscar jugador equipo
     */
    private JButton JEBuscar;
    /**
     * Variable global para comprobar la fecha de expiracion
     */
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
