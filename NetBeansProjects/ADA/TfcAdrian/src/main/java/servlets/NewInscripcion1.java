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
import mx.com.gm.sga.domain.Actividad;
import mx.com.gm.sga.domain.ActividadName;
import mx.com.gm.sga.domain.Deportes;
import mx.com.gm.sga.domain.Instalacion;
import mx.com.gm.sga.domain.Monitores;

/**
 *
 * @author adrip
 */
@WebServlet("/NewInscripcion1")
public class NewInscripcion1 extends HttpServlet {
     private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         GestionActividad gactividad = new GestionActividad();
         List<Actividad> actividades = gactividad.recuperarActividades();
         List<ActividadName> list = new ArrayList<ActividadName>();
         
         for(Actividad a : actividades){
             Instalacion ins = a.getInstalacion();
             Deportes depor = a.getDeportes();
             Monitores moni = a.getMonitores();
             String instalacion = ins.getName();
             String deporte = depor.getName();
             String monitor = moni.getNombre();
             ActividadName nueva = new ActividadName(a.getIdactividad(), a.getNombre(),a.getDia(), a.getHora(), a.getMaxpersonas(), a.getInscritos(),a.getPrecio() ,instalacion, deporte, monitor);
             list.add(nueva);
         }
         
         for(ActividadName ac: list){
             System.out.println(ac);
         }
         
         //Guardamos los registros en un atributo de peticion
         request.setAttribute("actividades", actividades);
         //Transferencia de la peticion
         request.getRequestDispatcher("selectactividad.jsp").forward(request, response);
     }
    
}
