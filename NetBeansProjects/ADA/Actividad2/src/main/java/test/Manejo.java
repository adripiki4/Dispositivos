/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.CochesDAO;
import domain.Coches;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author adriba
 */
public class Manejo {
    
    public static void main(String[] args) throws SQLException{
        CochesDAO cochesdao = new CochesDAO();
        
        Coches c2 = new Coches("2425JKL", "Toyota", 2000, "44778569W");
        cochesdao.insertar(c2);
        
        
        
        
        List<Coches>listacoches = cochesdao.seleccionar();
        for(Coches c : listacoches){
            System.out.println(c);
        }
    }
    
}
