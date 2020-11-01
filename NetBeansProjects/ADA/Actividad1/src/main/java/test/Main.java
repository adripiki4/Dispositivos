/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author adrip
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario>listusa = usuarioDAO.seleccionar();
        
        //Insertando usuario
//        Usuario nuevo = new Usuario("Carlos","hahahaha");
//        usuarioDAO.insertar(nuevo);

     // Actualizar
//        Usuario actualiza = new Usuario(2, "Andres", "jujuju");
//        usuarioDAO.actualizar(actualiza);
//
////      Delete
        Usuario borrar = new Usuario(2);
        usuarioDAO.borrar(borrar);
        
        listusa=usuarioDAO.seleccionar();
        
        for(Usuario usa: listusa){
            System.out.println(usa);
        }
    }

}
