package Vista;

import javax.swing.*;

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

    public static void main(String[] args) {
        JFrame frame = new JFrame("vAdminPanel");
        frame.setContentPane(new vAdminPanel().getpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
