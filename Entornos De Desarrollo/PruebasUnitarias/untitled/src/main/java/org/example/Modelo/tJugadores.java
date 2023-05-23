package org.example.Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class tJugadores {

    public static int insert(Jugador jugador) throws Exception{
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("insert into jugadores(nombre, apellido, dni, posicion, tipo_jugador) values (?,?,?,?,?)");
        ps.setString(1, jugador.getNombre());
        ps.setString(2, jugador.getApellido());
        ps.setString(3, jugador.getDNI());
        ps.setString(4, jugador.getPosicion().toString());
        ps.setString(5, jugador.getTipoJugador().toString());
        int n = ps.executeUpdate();
        BaseDato.cerrarConexion();
        return n;
    }

    public static Jugador buscarPorDNI(Jugador jugador) throws Exception{
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from jugadores where dni=?");
        ps.setString(1, jugador.getDNI());
        ResultSet result = ps.executeQuery();
        if (result.next()){
            Jugador.tPosicion tPosicion = null;
            switch (result.getString("posicion")){
                case "DC" -> tPosicion = Jugador.tPosicion.DC;
                case "DF" -> tPosicion = Jugador.tPosicion.DF;
                case "P" -> tPosicion = Jugador.tPosicion.P;
                case "MC" -> tPosicion = Jugador.tPosicion.MC;
            }
            Jugador.tTipoJugador tTipoJugador = null;
            switch (result.getString("tipo_jugador")){
                case "HABITUAL" -> tTipoJugador = Jugador.tTipoJugador.HABITUAL;
                case "WILDCARD" -> tTipoJugador = Jugador.tTipoJugador.WILDCARD;
            }
            jugador = new Jugador(result.getInt("id_jugador"), result.getString("nombre"), result.getString("apellido"), result.getString("dni"), tPosicion, tTipoJugador);
        }
        BaseDato.cerrarConexion();
        return jugador;
    }

    public static int delete(Jugador jugador) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("delete from jugadores where dni = ?");
        ps.setString(1, jugador.getDNI());
        int n = ps.executeUpdate();
        BaseDato.cerrarConexion();
        return n;
    }

    public static int update(Jugador jugador) throws Exception{
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update jugadores set nombre=?, " +
                "apellido=?, posicion=?, tipo_jugador=? where dni=?");
        ps.setString(1, jugador.getNombre());
        ps.setString(2, jugador.getApellido());
        ps.setString(3, jugador.getPosicion().toString());
        ps.setString(4, jugador.getTipoJugador().toString());
        ps.setString(5, jugador.getDNI());
        int n = ps.executeUpdate();
        BaseDato.cerrarConexion();
        return n;
    }

}
