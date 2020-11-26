/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Devolucion;
import static datos.Conexion.close;
import java.sql.*;
import java.util.*;
import java.sql.Date;

/**
 *
 * @author adrip
 */
public class DevolucionDAO {

    private static final String SQL_SELECT = "SELECT * FROM devolucion";
    private static final String SQL_INSERT = "INSERT INTO devolucion(FechaDevolucion,Id-wallet,Id_producto) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE devolucion SET FechaDevolucion=?, Id-wallet=?, Id_producto=? where Id_devolucion=?";
    private static final String SQL_DELETE = "DELETE FROM devolucion WHERE Id_devolucion=?";

    private Connection conexionTransaccional;

    public DevolucionDAO() {

    }

    //Recibe la conexion externamente
    public DevolucionDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Devolucion> Seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Devolucion devolu;
        List<Devolucion> listaDevolucion = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iddevolucion = rs.getInt("Id_devolucion");
                Date fechadevolucion = rs.getDate("FechaDevolucion");
                int idwallet = rs.getInt("Id-wallet");
                int idproducto = rs.getInt("Id_producto");
                devolu = new Devolucion(iddevolucion, fechadevolucion, idwallet, idproducto);
                listaDevolucion.add(devolu);
            }
        } finally {

            Conexion.close(stmt);
            Conexion.close(rs);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return listaDevolucion;
    }

    public int Insertar(Devolucion devolucion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setDate(1, devolucion.getFechaDevolucion());
            stmt.setInt(2, devolucion.getId_wallet());
            stmt.setInt(3, devolucion.getId_producto());

            registros = stmt.executeUpdate();
        } finally {

            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return registros;
    }
    
    public int Actualizar(Devolucion devolucion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setDate(1, devolucion.getFechaDevolucion());
            stmt.setInt(2, devolucion.getId_wallet());
            stmt.setInt(3, devolucion.getId_producto());
            stmt.setInt(4, devolucion.getId_devolucion());
            registros = stmt.executeUpdate();
        } finally {

            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return registros;
    }
    
    public int Eliminar(Devolucion devolucion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, devolucion.getId_devolucion());
            registros = stmt.executeUpdate();
        } finally {

            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return registros;
    }

}
