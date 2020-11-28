/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Producto;
import static datos.Conexion.close;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adrip
 */
public class ProductoDAO {

    private static final String SQL_SELECT = "SELECT * FROM producto";
    private static final String SQL_INSERT = "INSERT INTO producto( NombreProducto, PrecioProducto, PuntosProducto) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE Id_producto=?";
    private static final String SQL_UPDATE = "UPDATE producto SET NombreProducto=?, PrecioProducto=?, PuntosProducto=?  where Id_producto=?";

    private Connection conexionTransaccional;

    public ProductoDAO() {

    }

    //Recibe la conexion externamente
    public ProductoDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Producto> Seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> listaproducto = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idproducto = rs.getInt("Id_producto");
                String nombreproducto = rs.getString("NombreProducto");
                int precioproducto = rs.getInt("PrecioProducto");
                int puntosproducto = rs.getInt("PuntosProducto");
                producto = new Producto(idproducto, nombreproducto, precioproducto, puntosproducto);
                listaproducto.add(producto);
            }
        } finally {

            Conexion.close(stmt);
            Conexion.close(rs);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return listaproducto;
    }

    public int Insertar(Producto producto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getNombreProducto());
            stmt.setInt(2, producto.getPrecioProducto());
            stmt.setInt(3, producto.getPuntosProducto());
            registros = stmt.executeUpdate();
        } finally {

            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return registros;
    }

    public int Actualizar(Producto producto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getNombreProducto());
            stmt.setInt(2, producto.getPrecioProducto());
            stmt.setInt(3, producto.getPuntosProducto());
            stmt.setInt(4, producto.getId_producto());
            registros = stmt.executeUpdate();
        } finally {

            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return registros;
    }

    public int Eliminar(Producto producto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getId_producto());
            registros = stmt.executeUpdate();
        } finally {

            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return registros;
    }

    public Producto BuscarProducto(int busca) throws SQLException {
        Producto encuentra = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        // int id = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM producto WHERE Id_producto= " + busca);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id_producto");
                String nombre = rs.getString("NombreProducto");
                int precio = rs.getInt("PrecioProducto");
                int puntos = rs.getInt("PuntosProducto");

                encuentra = new Producto(id, nombre, precio, puntos);

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
