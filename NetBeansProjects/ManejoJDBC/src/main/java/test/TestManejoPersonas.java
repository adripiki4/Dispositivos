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
        PersonaDAO personaDao = new PersonaDAO();
        List<Persona> personas = personaDao.seleccionar();
        

        //insertando neuvo objeto de tipo persona
        Persona personaNueva = new Persona("Maonolo", "Fernandez", 32);
        personaDao.insertar(personaNueva);
        for (Persona persona : personas) {
            System.out.println("persona = " + persona);
        }
        

    }



}
