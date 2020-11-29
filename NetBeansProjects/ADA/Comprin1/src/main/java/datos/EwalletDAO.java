/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.Ewallet;
import java.sql.Date;

/**
 *
 * @author adrip
 */
public class EwalletDAO {

    private static final String SQL_SELECT = "SELECT * FROM ewallet";
    private static final String SQL_INSERT = "INSERT INTO ewallet(Nombre, Apellidos, Dni ,FechaNacimiento,Email, SaldoPuntos, SaldoEuros) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE ewallet SET Nombre=?, Apellidos=?, Dni=?, FechaNacimiento=?, Email=?, SaldoPuntos=?, SaldoEuros=? WHERE Id_wallet=?";
    private static final String SQL_DELETE = "DELETE FROM ewallet WHERE Id_wallet=?";
    private static final String SQL_BUSCA = "SELECT * FROM ewallet WHERE Id_wallet=?";

    private Connection conexionTransaccional;

    public EwalletDAO() {

    }

    //Recibe la conexion externamente
    public EwalletDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Ewallet> Seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ewallet wallet;
        List<Ewallet> listawallet = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("Id_wallet");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                String dni = rs.getString("Dni");
                Date fechanacimento = rs.getDate("FechaNacimiento");
                String email = rs.getString("Email");
                int saldopuntos = rs.getInt("SaldoPuntos");
                int saldoeuros = rs.getInt("SaldoEuros");

                wallet = new Ewallet(idPersona, nombre, apellidos, dni, fechanacimento, email, saldopuntos, saldoeuros);
                listawallet.add(wallet);
            }
        } finally {
            Conexion.close(stmt);
            Conexion.close(rs);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return listawallet;
    }

    public int Insertar(Ewallet wallet) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, wallet.getNombre());
            stmt.setString(2, wallet.getApellidos());
            stmt.setString(3, wallet.getDni());
            stmt.setDate(4, wallet.getFechaNacimiento());
            stmt.setString(5, wallet.getEmail());
            stmt.setInt(6, wallet.getSaldoPuntos());
            stmt.setInt(7, wallet.getSaldoEuros());
            registros = stmt.executeUpdate();
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return registros;
    }

    public int Actualizar(Ewallet wallet) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, wallet.getNombre());
            stmt.setString(2, wallet.getApellidos());
            stmt.setString(3, wallet.getDni());
            stmt.setDate(4, wallet.getFechaNacimiento());
            stmt.setString(5, wallet.getEmail());
            stmt.setInt(6, wallet.getSaldoPuntos());
            stmt.setInt(7, wallet.getSaldoEuros());
            stmt.setInt(8, wallet.getId_wallet());
            registros = stmt.executeUpdate();
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return registros;
    }

    public int Eliminar(Ewallet wallet) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, wallet.getId_wallet());
            registros = stmt.executeUpdate();
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return registros;
    }

    public Ewallet BuscarWallet(int busca) throws SQLException {
        Ewallet encuentra = new Ewallet();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM ewallet WHERE Id_wallet= " + busca);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id_wallet");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                String dni = rs.getString("Dni");
                Date fechanacimento = rs.getDate("FechaNacimiento");
                String email = rs.getString("Email");
                int saldopuntos = rs.getInt("SaldoPuntos");
                int saldoeuros = rs.getInt("SaldoEuros");

                encuentra = new Ewallet(id, nombre, apellidos, dni, fechanacimento, email, saldopuntos, saldoeuros);

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
