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
@WebServlet("/AltaMonitor")
public class AltaMonitor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String nombre = request.getParameter("nombre");
         String apellidos = request.getParameter("apellidos");
         String tel = request.getParameter("telefono");
         int telefono = Integer.parseInt(tel);
         String email = request.getParameter("email");
         
         GestionMonitores gmonitores = new GestionMonitores();
         Monitores monitor = new Monitores(nombre, apellidos, telefono, email);
         gmonitores.altaMonitor(monitor);
         
         request.getRequestDispatcher("Controller?op=doRecuperarMonitores").forward(request, response);
     }
}
