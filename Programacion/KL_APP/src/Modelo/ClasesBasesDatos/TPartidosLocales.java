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
        PreparedStatement ps = BaseDato.getCon().prepareStatement("SELECT * FROM PARTIDOS_LOCALES WHERE ID_PARTIDO = ?");
        ps.setInt(1, partidoLocal.getPartido().getID());
        ResultSet result = ps.executeQuery();
        if (result.next()){
            partidoLocal = new PartidoLocal(partidoLocal.getPartido(), TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))), result.getInt("goles"));
        } else
            partidoLocal = null;
        BaseDato.cerrarConexion();
        return partidoLocal;
    }
}
