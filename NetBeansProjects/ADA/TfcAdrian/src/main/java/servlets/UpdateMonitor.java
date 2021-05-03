/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
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
@WebServlet("/UpdateMonitor")
public class UpdateMonitor extends HttpServlet{
     private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
      protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          int idmonitores = Integer.parseInt(request.getParameter("idmonitores"));
          String nombre = request.getParameter("nombre");
          String apellidos = request.getParameter("apellidos");
          int telefono = Integer.parseInt(request.getParameter("telefono"));
          String email = request.getParameter("email");
          
          Monitores monitor = new Monitores(idmonitores, nombre, apellidos, telefono, email);
          
          GestionMonitores gmonitores = new GestionMonitores();
          gmonitores.actualizarMonitores(monitor);
          request.getRequestDispatcher("Controller?op=doRecuperarMonitores").forward(request, response);
          
      }
    
}
