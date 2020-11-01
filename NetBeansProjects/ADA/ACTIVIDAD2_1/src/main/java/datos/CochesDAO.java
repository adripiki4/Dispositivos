/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import domain.Coches;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriba
 */
public class CochesDAO {

    private static final String SQL_SELECT = "SELECT Matricula, Marca, Precio,DNI FROM coches";
    private static final String SQL_INSERT = "INSERT INTO coches(Matricula, Marca, Precio, DNI) VALUES (?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM coches WHERE Matricula=?";
    private static final String SQL_UPDATE = "UPDATE usuario SET Precio=?, DNI=? where Matricula=?";

    //Metodo que devuelve en una lista todos los coches de la bd
    public List<Coches> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Coches coche = null;
        String matricula="";
        String marca="";
        int precio=0;
        String dni="";
        List<Coches> listacoches = new ArrayList<>();
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                matricula= rs.getString("Matricula");
                marca = rs.getString("Marca");
                precio = rs.getInt("Precio");
                dni = rs.getString("DNI");
                
                coche = new Coches(matricula, marca, precio, dni);
                listacoches.add(coche);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        
        return listacoches;
    }
    
    //Insertamos nuevo coche en la bd
    public int insertar(Coches coche){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, coche.getMatricula());
            stmt.setString(2, coche.getMarca());
            stmt.setInt(3, coche.getPrecio());
            stmt.setString(4, coche.getDni());
            registros = stmt.executeUpdate();
            
        }catch(SQLException ex) {
            ex.printStackTrace(System.out);
        }finally {
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
        return registros;
    }

}
