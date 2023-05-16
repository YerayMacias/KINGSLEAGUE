package Modelo.ClasesBasesDatos;

<<<<<<< Updated upstream

import Modelo.ClasesObjetos.BaseDato;
import Modelo.ClasesObjetos.Temporada;
=======
>>>>>>> Stashed changes
import Modelo.ClasesObjetos.Usuario;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.NavigableSet;

public class TUsuarios {
    public static void insert(Usuario usuario) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("INSERT INTO usuarios(username, email, password, admin) values(?,?,?,?)");
        ps.setString(1,usuario.getUsername());
        ps.setString(2,usuario.getEmail());
        ps.setString(3,usuario.getPassword());
        ps.setString(4,usuario.getAdmin().toString());
        ps.execute();
        BaseDato.cerrarConexion();
    }

    public static void update(Usuario usuario) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update usuarios set EMAIL = ?,USERNAME = ?, PASSWORD = ?,ADMIN = ? where id_usuario = ?");
        ps.setString(1,usuario.getEmail());
        ps.setString(2,usuario.getUsername());
        ps.setString(3,usuario.getPassword());
        ps.setString(4,usuario.getAdmin().toString());
        ps.setInt(5,usuario.getID());
        ps.execute();
        BaseDato.cerrarConexion();
    }

    public static void delete(Usuario usuario) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("delete from usuarios where username = ?");
        ps.setString(1,usuario.getUsername());
        ps.execute();
        BaseDato.cerrarConexion();
    }

    public static ArrayList<Usuario> buscarTodo() throws Exception {
        ArrayList<Usuario> listarUsuarios = new ArrayList<>();
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from usuarios");
        ResultSet resultado = ps.executeQuery();
        Usuario usuario;
        Usuario.tUsuario tUsuario;
        while (resultado.next())
        {
            if (resultado.getString("admin").equalsIgnoreCase("S"))
                tUsuario = Usuario.tUsuario.S;
            else
                tUsuario = Usuario.tUsuario.N;
            usuario = new Usuario(resultado.getInt("id_usuario"),resultado.getString("username"),resultado.getString("email"),resultado.getString("password"),tUsuario);
            listarUsuarios.add(usuario);
        }
        BaseDato.cerrarConexion();
        return listarUsuarios;
    }
    public static Usuario buscarPorUsernamePassword(Usuario usuario) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from usuarios where username = ? and password = ?");
        ps.setString(1, usuario.getUsername());
        ps.setString(2, usuario.getPassword());
        ResultSet resultado = ps.executeQuery();
        if (resultado.next())
        {
            usuario = new Usuario();
            usuario.setID(resultado.getInt("id_usuario"));
            usuario.setUsername(resultado.getString("username"));
            usuario.setPassword(resultado.getString("password"));
            usuario.setEmail(resultado.getString("email"));
            usuario.setAdmin(Usuario.tUsuario.valueOf(resultado.getString("admin")));
        }
        else
            usuario = null;
        BaseDato.cerrarConexion();
        return usuario;
    }
}