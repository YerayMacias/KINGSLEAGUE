package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class tJugadores {
    public static void insert(Jugador jugador) throws Exception{
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("insert into jugadores(nombre, apellido, dni, posicion, tipo_jugador) values (?,?,?,?,?)");
        ps.setString(1, jugador.getNombre());
        ps.setString(2, jugador.getApellido());
        ps.setString(3, jugador.getDNI());
        ps.setString(4, jugador.getPosicion());
        ps.setString(5, jugador.getTipoJugador());
        int n = ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static void update(Jugador jugador) throws Exception{
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update jugadores set nombre=?, apellido=?, dni=?, posicion=?, tipo_jugador=? where id_jugador=?");
        ps.setString(1, jugador.getNombre());
        ps.setString(2, jugador.getApellido());
        ps.setString(3, jugador.getDNI());
        ps.setString(4, jugador.getPosicion());
        ps.setString(5, jugador.getTipoJugador());
        ps.setInt(6, jugador.getID());
        int n = ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static Jugador buscarPorDNI(Jugador jugador) throws Exception{
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from jugadores where dni=?");
        ps.setString(1, jugador.getDNI());
        ResultSet result = ps.executeQuery();
        if (result.next()){
            jugador = new Jugador(result.getInt("id_jugador"), result.getString("nombre"), result.getString("apellido"), result.getString("dni"), result.getString("posicion"), result.getString("tipo_jugador"));
        } else
            throw new Exception("Jugador no encontrado");
        return jugador;
    }

    public static ArrayList<Jugador> buscarTodos() throws Exception{
        BaseDato.abrirConexion();
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from jugadores");
        ResultSet result = ps.executeQuery();
        while (result.next()){
            Jugador jugador = new Jugador(result.getInt("id_jugador"), result.getString("nombre"), result.getString("apellido"), result.getString("dni"), result.getString("posicion"), result.getString("tipo_jugador"));
            listaJugadores.add(jugador);
        }
        return listaJugadores;
    }

    public static void delete(Jugador jugador) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("delete from jugadores where dni = ?");
        ps.setString(1, jugador.getDNI());
        int n = ps.executeUpdate();
        BaseDato.cerrarConexion();
    }
}
