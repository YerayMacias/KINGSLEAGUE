package Modelo.ClasesBasesDatos;

import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

import java.sql.*;

/**
 * @author
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
            String url = "jdbc:oracle:thin:@localhost:1521:ORCLCDB";
            String pass = "oracle";
            String user = "system";
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

    public static void generarCalendario() throws Exception {
        abrirConexion();
        CallableStatement statement = con.prepareCall("{call KL_CALENDARIO.GENERAR_CALENDARIO()}");
        statement.execute();
        cerrarConexion();
    }

    public static String verEnfrentamientos() throws Exception {
        abrirConexion();
        CallableStatement statement = con.prepareCall("{call KL_CALENDARIO.VER_ENFRENTAMIENTOS(?)}");
        statement.registerOutParameter(1, OracleTypes.CURSOR);
        statement.execute();
        ResultSet result = ((OracleCallableStatement)statement).getCursor(1);
        String mensaje = "";
        while (result.next()){
            int idPartido = result.getInt("id_partido");
            String nombreLocal = result.getString("local");
            String nombreVisitante = result.getString("visitante");
            int idJornada = result.getInt("id_jornada");
            String hora = result.getString("hora");
            mensaje += "Partido: " + idPartido + " Local: " + nombreLocal + " Visitante: "
                    + nombreVisitante + " Jornada: " + idJornada + " Hora: " + hora + "\n";
        }
        result.close();
        statement.close();
        cerrarConexion();
        return mensaje;
    }

    public static String mostrarClasificacion() throws Exception {
        abrirConexion();
        CallableStatement statement = con.prepareCall("{call mostrar_clasificacion(?)}");
        statement.registerOutParameter(1, OracleTypes.CURSOR);
        statement.execute();
        ResultSet result = ((OracleCallableStatement)statement).getCursor(1);
        String mensaje = "";
        while (result.next()){
            String nombreEquipo = result.getString("nombre");
            String victorias = String.valueOf(result.getInt("victorias"));
            String derrotas = String.valueOf(result.getInt("derrotas"));
            String golesFavor = String.valueOf(result.getInt("goles_a_favor"));
            String golesContra = String.valueOf(result.getInt("goles_en_contra"));
            String diferenciaGoles = String.valueOf(result.getInt("diferencia_goles"));
            mensaje += "Nombre: " + nombreEquipo + " Victorias: " + victorias + " Derrotas: " + derrotas + " " +
                    "Goles a favor: " + golesFavor + " Goles en contra: " + golesContra + " Diferencia de goles "
                    + diferenciaGoles + "\n";
        }
        result.close();
        statement.close();
        cerrarConexion();
        return mensaje;
    }

    public static String obtener_datos_jugadores() throws SQLException {
        abrirConexion();
        CallableStatement statement = con.prepareCall("{call obtener_datos_jugadores(?)}");
        statement.registerOutParameter(1, OracleTypes.CURSOR);
        statement.execute();
        ResultSet result = ((OracleCallableStatement)statement).getCursor(1);
        String mensaje = "";
        while (result.next()){
            String nombre = result.getString("j.nombre");
            String apellido = result.getString("j.apellido");
            String dni = result.getString("j.dni");
            String posicion = result.getString("j.posicion");
            String equipoNombre = result.getString("e.nombre");
            String sueldo = result.getString("ej.sueldo");
            String clausula = result.getString("ej.clausula");

            mensaje += "Nombre: " + nombre + " Apellido: " + apellido + " DNI: " + dni +
                    " Posicion: " + posicion + " Equipo" + equipoNombre + " Sueldo: " + sueldo +
                    " Clausula: " + clausula + "\n";
        }
        cerrarConexion();
        return mensaje;
    }

    public static void main(String[] args) {
        try {
            System.out.println(obtener_datos_jugadores());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
