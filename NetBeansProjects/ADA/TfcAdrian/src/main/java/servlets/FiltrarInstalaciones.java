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
import modelo.GestionInstalacion;
import mx.com.gm.sga.domain.Deportes;
import mx.com.gm.sga.domain.Instalacion;

/**
 *
 * @author adrip
 */
@WebServlet("/FiltrarInstalaciones")
public class FiltrarInstalaciones extends HttpServlet {
     private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String deporte = request.getParameter("deporte");
         GestionInstalacion ginstalacion = new GestionInstalacion();
         
         List<Instalacion> list = ginstalacion.recuperarInstalaciones();
         List<Instalacion> pasa = new ArrayList<Instalacion>();
         
         for(Instalacion i : list){
             Deportes d = i.getDeportes();
             if(deporte.equalsIgnoreCase(d.getName())==true){
                 pasa.add(i);
             }
         }
         
         //Pasamos los objetos
         request.setAttribute("instalaciones", pasa);
         
         request.getRequestDispatcher("instalaciones.jsp").forward(request, response);
         
         
     }
    
}
