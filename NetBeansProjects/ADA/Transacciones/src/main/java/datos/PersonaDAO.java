/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.util.*;
import domain.Persona;
import java.sql.*;

/**
 *
 * @author adriba
 */
public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT Id_persona, Nombre, Apellidos, Edad FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (Nombre, Apellidos, Edad) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE Id_persona = ?";
    private static final String SQL_UPDATE = "UPDATE persona SET Nombre = ?, Apellidos=?, Edad= ? WHERE Id_persona=?";
    private Connection conexionTransaccional;

    public PersonaDAO() {
    }

    public PersonaDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Persona> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Id_persona = rs.getInt("Id_persona");
                String Nombre = rs.getString("Nombre");
                String Apellidos = rs.getString("Apellidos");
                int Edad = rs.getInt("Edad");
                persona = new Persona(Id_persona, Nombre, Apellidos, Edad);
                personas.add(persona);

            }

        } //Borramos el catch porque se controla la excepcion desde TestMaenjopersona
        finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return personas;
    }

    public int insertar(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
            stmt.setInt(3, persona.getEdad());
            //stmt.setString(4, persona.getEmail());
            registros = stmt.executeUpdate();

        } finally {
            try {
                close(stmt);
            } catch (SQLException ex) {

            }
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }

        }
        return registros;
    }

    
    public int delete(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getId_persona());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
            } catch (SQLException ex) {
            }
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return registros;
    }

    public int update(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
            stmt.setInt(3, persona.getEdad());
            stmt.setInt(4, persona.getId_persona());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
            } catch (SQLException ex) {
            }
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return registros;
    }
}
