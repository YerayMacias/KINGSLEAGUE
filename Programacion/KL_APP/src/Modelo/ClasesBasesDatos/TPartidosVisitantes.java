package Modelo.ClasesBasesDatos;

import Modelo.ClasesObjetos.Equipo;
import Modelo.ClasesObjetos.Partido;
import Modelo.ClasesObjetos.PartidoLocal;
import Modelo.ClasesObjetos.PartidoVisitante;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TPartidosVisitantes {
    public static PartidoVisitante buscarPorPartido(PartidoVisitante partidoVisitante) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("SELECT * FROM PARTIDOS_VISITANTES WHERE ID_PARTIDO = ?");
        ps.setInt(1, partidoVisitante.getPartido().getID());
        ResultSet result = ps.executeQuery();
        if (result.next()){
            partidoVisitante = new PartidoVisitante(partidoVisitante.getPartido(), TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))), result.getInt("goles"));
        }
        BaseDato.cerrarConexion();
        return partidoVisitante;
    }
}
