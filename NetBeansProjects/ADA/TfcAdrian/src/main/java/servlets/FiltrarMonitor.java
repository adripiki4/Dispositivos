/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/FiltrarMonitor")
public class FiltrarMonitor extends HttpServlet {
     private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String nombre = request.getParameter("nombre");
         
         GestionMonitores gmonitores = new GestionMonitores();
         List<Monitores> list = gmonitores.recuperarMonitores();
         List<Monitores> pasa = new ArrayList<Monitores>();
         
         for(Monitores m : list){
             if(nombre.equalsIgnoreCase(m.getNombre())==true){
                 pasa.add(m);
             }
         }
         
         request.setAttribute("monitores", pasa);
         
         request.getRequestDispatcher("monitores.jsp").forward(request, response);
     }
    
}
