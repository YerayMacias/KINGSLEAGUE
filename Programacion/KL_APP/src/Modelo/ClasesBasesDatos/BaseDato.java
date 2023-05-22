package Modelo.ClasesBasesDatos;

import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class BaseDato {
    private static Connection con;
    public static Connection getCon(){
        return con;
    }

    /**
     * Abrir conexion con la base de datos
     */
    public static void abrirConexion(){
        try {
            String url = "jdbc:oracle:thin:@172.20.225.114:1521:ORCL";
            String pass = "eqdaw04";
            String user = "eqdaw04";
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e){
            System.out.println("Problemas con la base de datos " + e.getMessage());
        }
    }

    /**
     * Cerrar conexion con la base de datos
     */
    public static void cerrarConexion(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Problemas con la base de datos " + e.getMessage());
        }
    }

    /**
     * Para ejecutar el PL/SQL de generar el calendario
     * @throws Exception
     */
    public static void generarCalendario() throws Exception {
        abrirConexion();
        CallableStatement statement = con.prepareCall("{call KL_CALENDARIO.GENERAR_CALENDARIO()}");
        statement.execute();
        cerrarConexion();
    }

    /**
     * Para ejecutar el PL/SQL de ver los enfrentamientos
     * @return ArrayList de ArrayList de Object - Para un JTable
     * @throws Exception
     */
    public static ArrayList<ArrayList<Object>> verEnfrentamientos() throws Exception {
        abrirConexion();
        CallableStatement statement = con.prepareCall("{call KL_CALENDARIO.VER_ENFRENTAMIENTOS(?)}");
        statement.registerOutParameter(1, OracleTypes.CURSOR);
        statement.execute();
        ResultSet result = ((OracleCallableStatement)statement).getCursor(1);
        ArrayList<ArrayList<Object>> datosTabla = new ArrayList<>();
        while (result.next()){
            ArrayList<Object> datosObtenidos = new ArrayList<>();
            int idPartido = result.getInt("id_partido");
            String nombreLocal = result.getString("local");
            String nombreVisitante = result.getString("visitante");
            int idJornada = result.getInt("id_jornada");
            String hora = result.getString("hora");

            // Añadir al array datosObtenidos
            datosObtenidos.add(idPartido);
            datosObtenidos.add(nombreLocal);
            datosObtenidos.add(nombreVisitante);
            datosObtenidos.add(idJornada);
            datosObtenidos.add(hora);

            //Añadir al array datosTabla
            datosTabla.add(datosObtenidos);
        }
        result.close();
        statement.close();
        cerrarConexion();
        return datosTabla;
    }

    /**
     * Para ejecutar el PL/SQL de mostrar la clasificacion
     * @return ArrayList de ArrayList de Object - Para un JTable
     * @throws Exception
     */
    public static ArrayList<ArrayList<Object>> mostrarClasificacion() throws Exception {
        abrirConexion();
        CallableStatement statement = con.prepareCall("{call mostrar_clasificacion(?)}");
        statement.registerOutParameter(1, OracleTypes.CURSOR);
        statement.execute();
        ResultSet result = ((OracleCallableStatement)statement).getCursor(1);
        ArrayList<ArrayList<Object>> datosTabla = new ArrayList<>();
        while (result.next()){
            ArrayList<Object> datosObtenidos = new ArrayList<>();
            String nombreEquipo = result.getString("nombre");
            String victorias = String.valueOf(result.getInt("victorias"));
            String derrotas = String.valueOf(result.getInt("derrotas"));
            String golesFavor = String.valueOf(result.getInt("goles_a_favor"));
            String golesContra = String.valueOf(result.getInt("goles_en_contra"));
            String diferenciaGoles = String.valueOf(result.getInt("diferencia_goles"));

            // Añadir al array datosObtenidos
            datosObtenidos.add(nombreEquipo);
            datosObtenidos.add(victorias);
            datosObtenidos.add(derrotas);
            datosObtenidos.add(golesFavor);
            datosObtenidos.add(golesContra);
            datosObtenidos.add(diferenciaGoles);

            // Añadir al array datosTabla
            datosTabla.add(datosObtenidos);
        }
        result.close();
        statement.close();
        cerrarConexion();
        return datosTabla;
    }

    /**
     * Para ejecutar el PLSQL de obtener los datos de los jugadores
     * @return ArrayList de ArrayList de Object - Para un JTable
     * @throws SQLException
     */
    public static ArrayList<ArrayList<Object>> obtener_datos_jugadores() throws SQLException {
        abrirConexion();
        CallableStatement statement = con.prepareCall("{call obtener_datos_jugadores(?)}");
        statement.registerOutParameter(1, OracleTypes.CURSOR);
        statement.execute();
        ResultSet result = ((OracleCallableStatement)statement).getCursor(1);
        ArrayList<ArrayList<Object>> datosTabla = new ArrayList<>();
        while (result.next()){
            ArrayList<Object> datosObtenidos = new ArrayList<>();
            String nombre = result.getString(1);
            String apellido = result.getString(2);
            String dni = result.getString(3);
            String posicion = result.getString(4);
            String equipoNombre = result.getString(5);
            String sueldo = result.getString(6);
            String clausula = result.getString(7);

            // Añadir al array datosObtenidos
            datosObtenidos.add(nombre);
            datosObtenidos.add(apellido);
            datosObtenidos.add(dni);
            datosObtenidos.add(posicion);
            datosObtenidos.add(equipoNombre);
            datosObtenidos.add(sueldo);
            datosObtenidos.add(clausula);

            // Añadir al array datosTabla
            datosTabla.add(datosObtenidos);
        }
        cerrarConexion();
        return datosTabla;
    }

    /**
     * Para generar el XML de todas las jornadas
     * @throws SQLException
     */
    public static void generarXMLJornadas() throws SQLException {
        abrirConexion();
        CallableStatement statement = con.prepareCall("{call kings_league_xml.obtener_xml_jornadas()}");
        statement.execute();
        cerrarConexion();
    }

    /**
     * Para generar el XML de la ultima jornada
     * @throws SQLException
     */
    public static void generarXMLUltimaJornada() throws SQLException {
        abrirConexion();
        CallableStatement statement = con.prepareCall("{call kings_league_xml.obtener_xml_ultimajornada()}");
        statement.execute();
        cerrarConexion();
    }

    /**
     * Para generar el XMl de clasificacion
     * @throws SQLException
     */
    public static void generarXMLClasificacion() throws SQLException {
        abrirConexion();
        CallableStatement statement = con.prepareCall("{call kings_league_xml.obtener_xml_clasificacion()}");
        statement.execute();
        cerrarConexion();
    }
}
