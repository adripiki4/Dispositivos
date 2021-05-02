/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionMonitores;
import mx.com.gm.sga.domain.Monitores;

/**
 *
 * @author adrip
 */
@WebServlet("/RecuperarMonitores")
public class RecuperarMonitores extends HttpServlet {
     private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         GestionMonitores gmonitores = new GestionMonitores();
         List<Monitores> monitores = gmonitores.recuperarMonitores();
         for(Monitores m : monitores){
             System.out.println("Monitores: "+m);
         }
         
         //Guardamos los monitores en un atributo de peticion
         request.setAttribute("monitores", monitores);
         //Transferencia de la peticion
         request.getRequestDispatcher("monitores.jsp").forward(request, response);
     }
}
