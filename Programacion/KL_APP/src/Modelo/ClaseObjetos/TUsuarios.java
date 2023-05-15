package Modelo.ClaseObjetos;

import Modelo.ClasesBaseDato.BaseDato;
import Modelo.ClasesBaseDato.Usuario;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.NavigableSet;

public class TUsuarios {
    public static void insert(Usuario usuario) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("INSERT INTO usuarios(username, email, password, admin) values(?,?,?,?);");
        ps.setString(1,usuario.getUsername());
        ps.setString(2,usuario.getEmail());
        ps.setString(3,usuario.getPassword());
        ps.setString(4,usuario.getAdmin());
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
            usuario.setAdmin(resultado.getString("admin"));
        }
        else
            usuario = null;
        BaseDato.cerrarConexion();
        return usuario;
    }
}
