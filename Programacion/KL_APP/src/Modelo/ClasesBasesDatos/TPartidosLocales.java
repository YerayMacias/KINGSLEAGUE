package Modelo.ClasesBasesDatos;


import Modelo.ClasesObjetos.Equipo;
import Modelo.ClasesObjetos.Partido;
import Modelo.ClasesObjetos.PartidoLocal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TPartidosLocales {
    public static PartidoLocal buscarPorPartido(PartidoLocal partidoLocal) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("SELECT * FROM PARTIDOSLOCALES WHERE ID_PARTIDO = ?");
        ps.setInt(1, partidoLocal.getPartido().getID());
        ResultSet result = ps.executeQuery();
        Partido.tPartido tPartido;
        if (result.next()){
            partidoLocal = new PartidoLocal(TPartido.buscarPorIDPartido(new Partido(result.getInt("id_partido"))), TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))), result.getInt("goles"));
        }
        BaseDato.cerrarConexion();
        return partidoLocal;
    }
}
