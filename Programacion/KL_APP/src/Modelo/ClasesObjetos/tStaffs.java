package Modelo.ClasesObjetos;

import Modelo.ClasesBaseDato.BaseDato;
import Modelo.ClasesBaseDato.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class tStaffs {
    /**
     * Insertar en la tabla staffs
     * @param staff Objeto Staff
     * @throws Exception
     */
    public static void insert(Staff staff) throws Exception{
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("insert into staff(nombre, apellido, dni, rol) values (?,?,?,?)");
        ps.setString(1, staff.getNombre());
        ps.setString(2, staff.getApellido());
        ps.setString(3, staff.getDNI());
        ps.setString(4, staff.getRol().toString());
        int n = ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static void update(Staff staff) throws Exception{
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update staffs set nombre=?, apellido=?, dni=?, rol=? where id_staff=?");
        ps.setString(1, staff.getNombre());
        ps.setString(2, staff.getApellido());
        ps.setString(3, staff.getDNI());
        ps.setString(4, staff.getRol().toString());
        ps.setInt(5, staff.getID());
        int n = ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    public static Staff buscarPorDNI(Staff staff) throws Exception{
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from staffs where dni=?");
        ps.setString(1, staff.getDNI());
        ResultSet result = ps.executeQuery();
        if (result.next()){
            Staff.tROl tROl = null;
            switch (result.getString("rol")){
                case "ENTRENADOR1" -> tROl = Staff.tROl.ENTRENADOR1;
                case "ENTRENADOR2" -> tROl = Staff.tROl.ENTRENADOR2;
                case "ANALISTA" -> tROl = Staff.tROl.ANALISTA;
            }
             staff = new Staff(result.getInt("id_staff"), result.getString("nombre"), result.getString("apellido"), result.getString("dni"), tROl);
        } else
            throw new Exception("Staff no encontrado");
        return staff;
    }

    public static ArrayList<Staff> buscarTodos() throws Exception{
        BaseDato.abrirConexion();
        ArrayList<Staff> listaStaffs = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from staffs");
        ResultSet result = ps.executeQuery();
        while (result.next()){
            Staff.tROl tROl = null;
            switch (result.getString("rol")){
                case "ENTRENADOR1" -> tROl = Staff.tROl.ENTRENADOR1;
                case "ENTRENADOR2" -> tROl = Staff.tROl.ENTRENADOR2;
                case "ANALISTA" -> tROl = Staff.tROl.ANALISTA;
            }
            Staff staff = new Staff(result.getInt("id_staff"), result.getString("nombre"), result.getString("apellido"), result.getString("dni"), tROl);
            listaStaffs.add(staff);
        }
        return listaStaffs;
    }

    public static void delete(Staff staff) throws Exception {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("delete from staff where dni = ?");
        ps.setString(1, staff.getDNI());
        int n = ps.executeUpdate();
        BaseDato.cerrarConexion();
    }
}
