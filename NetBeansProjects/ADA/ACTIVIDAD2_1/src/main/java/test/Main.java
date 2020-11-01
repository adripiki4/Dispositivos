/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import datos.CochesDAO;
import datos.PropietariosDAO;
import domain.Coches;
import domain.propietarios;
import java.sql.*;
import java.util.List;
/**
 *
 * @author adrip
 */
public class Main {
    
    public static void main(String[] args) throws SQLException{
        CochesDAO cdao = new CochesDAO();
        PropietariosDAO pdao = new PropietariosDAO();
        
//        Coches nuevo = new Coches("2323JKL", "Toyota", 2000, "55896222D");
//        cdao.insertar(nuevo);
//        
//        List<Coches>listcoches = cdao.seleccionar();
//        
//        for(Coches c : listcoches){
//            System.out.println(c);
//        }

        List<propietarios> listpro = pdao.seleccionar();
        for (propietarios pr : listpro){
            System.out.println(pr);
        }
    }
}
