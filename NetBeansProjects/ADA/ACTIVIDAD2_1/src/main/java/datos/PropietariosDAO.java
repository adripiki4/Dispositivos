/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.propietarios;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author adrip
 */
public class PropietariosDAO {

    //Definimos las sentencias de Sql
    private static final String SQL_SELECT = "SELECT  DNI, Nombre, Edad FROM propietarios";
    private static final String SQL_INSERT = "INSERT INTO propietarios(DNI, Nombre, Edad) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM propietarios WHERE DNI=?";
    private static final String SQL_UPDATE = "UPDATE propietarios SET Nombre=?, Edad=? where DNI=?";

    //Metodo que devuelve todos los propietarios de la bd.
    public List<propietarios> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        propietarios propietario = null;
        List<propietarios> listpropietario = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String dni = rs.getString("DNI");
                String nombre = rs.getString("Nombre");
                int edad = rs.getInt("Edad");
                propietario = new propietarios(dni, nombre, edad);
                listpropietario.add(propietario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        return listpropietario;

    }
    
     public int insertar(propietarios propietarios) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, propietarios.getDni());
            stmt.setString(2, propietarios.getNombre());
            stmt.setInt(3,propietarios.getEdad());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);

            } catch (SQLException ex) {
            }
            try {
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
      public int eliminar(propietarios propietarios) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, propietarios.getDni());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);

            } catch (SQLException ex) {
            }
            try {
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
      
       public int actualizarpropietarios (propietarios propietarios){
         Connection conn = null;
         PreparedStatement stmt = null;
         int registros = 0;
         try{
             conn = getConnection();
             stmt = conn.prepareStatement(SQL_UPDATE);
             stmt.setString(1, propietarios.getNombre());
             stmt.setInt(2, propietarios.getEdad());
             stmt.setString(3,propietarios.getDni());
             registros = stmt.executeUpdate();
         }catch(SQLException ex){ 
             ex.printStackTrace(System.out);
         }finally{
             try{
                 close(stmt);
             }catch(SQLException ex){
             }
             try{
                 close(conn);
             }catch(SQLException ex){
                 ex.printStackTrace(System.out);
             }
         }
         return  registros;
     }
}
