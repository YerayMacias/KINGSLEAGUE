package Modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TUsuarios {
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
