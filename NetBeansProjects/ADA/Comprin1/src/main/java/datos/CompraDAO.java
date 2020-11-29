/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.util.*;
import domain.Compra;
import java.sql.*;
import java.sql.Date;

/**
 *
 * @author adrip
 */
public class CompraDAO {

    private static final String SQL_SELECT = "SELECT * FROM compra";
    private static final String SQL_INSERT = "INSERT INTO compra (FechaCompra, Id_wallet, Id_producto) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE compra SET FechaCompra=?, Id_wallet=?, Id_producto=? WHERE Id_Compra=?";
    private static final String SQL_DELETE = "DELETE FROM compra WHERE Id_Compra=?";

    private Connection conexionTransaccional;

    public CompraDAO() {

    }

    //Recibe la conexion externamente
    public CompraDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Compra> Seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Compra aux;
        List<Compra> listaCompras = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idcompra = rs.getInt("Id_Compra");
                Date fechacompra = rs.getDate("FechaCompra");
                int idwallet = rs.getInt("Id_wallet");
                int idproducto = rs.getInt("Id_producto");
                aux = new Compra(idcompra, fechacompra, idwallet, idproducto);
                listaCompras.add(aux);
            }
        } finally {

            Conexion.close(stmt);
            Conexion.close(rs);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return listaCompras;
    }

    public int Insertar(Compra compra) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setDate(1, compra.getFechaCompra());
            stmt.setInt(2, compra.getId_wallet());
            stmt.setInt(3, compra.getId_producto());
            registros = stmt.executeUpdate();
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return registros;
    }

    public int Actualizar(Compra compra) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setDate(1, compra.getFechaCompra());
            stmt.setInt(2, compra.getId_wallet());
            stmt.setInt(3, compra.getId_producto());
            stmt.setInt(4, compra.getId_compra());
            registros = stmt.executeUpdate();
        } finally {

            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return registros;
    }

    public int Eliminar(Compra compra) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, compra.getId_compra());
            registros = stmt.executeUpdate();
        } finally {

            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return registros;
    }

    public Compra BuscarCompra(int busca) throws SQLException {
        Compra encuentra = new Compra();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM compra WHERE Id_Compra= " + busca);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_compra = rs.getInt("Id_Compra");
                Date fecha = rs.getDate("FechaCompra");
                int id_wallet = rs.getInt("Id_wallet");
                int id_pro = rs.getInt("Id_producto");

                encuentra = new Compra(id_compra, fecha, id_wallet, id_pro);
            }
        } finally {
            Conexion.close(stmt);

            Conexion.close(rs);

            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }

        return encuentra;
    }

}
