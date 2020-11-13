/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.Conexion;
import static datos.Conexion.close;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author adriba
 */
public class TestManejoPersonas {

    public static void main(String[] args) throws SQLException {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaDAO personaDao = new PersonaDAO(conexion);
            Persona cambioPersona = new Persona();
            Persona nueva = new Persona();
            cambioPersona.setNombre("Pepica Doleeres");
            cambioPersona.setApellidos("Fungi");
            cambioPersona.setEdad(58);
            cambioPersona.setId_persona(4);
            personaDao.update(cambioPersona);
            nueva.setNombre("Manu");
            nueva.setApellidos("Amnesia");
            nueva.setEdad(10);
            nueva.setId_persona(6);
            personaDao.insertar(nueva);
            
           
            conexion.commit();
            System.out.println("Todo ha salido bien");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Algo ha fallado, Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }

}
