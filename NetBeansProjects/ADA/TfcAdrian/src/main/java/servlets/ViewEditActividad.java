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
import modelo.GestionActividad;
import modelo.GestionInstalacion;
import modelo.GestionMonitores;
import mx.com.gm.sga.domain.Actividad;
import mx.com.gm.sga.domain.Deportes;
import mx.com.gm.sga.domain.Instalacion;
import mx.com.gm.sga.domain.Monitores;

/**
 *
 * @author adrip
 */
@WebServlet("/ViewEditActividad")
public class ViewEditActividad extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int idactividad = Integer.parseInt(request.getParameter("idactividad"));
         GestionActividad gactividad = new GestionActividad();
         Actividad actividad = gactividad.buscaActividad(idactividad);
         Deportes deporte = actividad.getDeportes();
         
         
         GestionInstalacion gins = new GestionInstalacion();
         List<Instalacion> list = gins.recuperarInstalaciones();
         
         List<Instalacion> instalaciones = new ArrayList<Instalacion>();
         
         for(Instalacion i : list){
             Deportes d = i.getDeporte();
             if(d.getId()== deporte.getId()){
                 instalaciones.add(i);
             }
         }
         
         GestionMonitores gmonitores = new GestionMonitores();
         List<Monitores> monitores = gmonitores.recuperarMonitores();
         
         
         request.setAttribute("monitores", monitores);
         request.setAttribute("instalaciones", instalaciones);
         request.setAttribute("actividad",actividad);
         
         request.getRequestDispatcher("updateactividad.jsp").forward(request, response);
         
     }
    
}
