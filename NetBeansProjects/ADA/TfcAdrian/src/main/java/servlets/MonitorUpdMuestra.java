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
@WebServlet("/MonitorUpdMuestra")
public class MonitorUpdMuestra extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //Recuperamos el id del monitor
         int idmonitores = Integer.parseInt(request.getParameter("idmonitores"));
         GestionMonitores gmonitores = new GestionMonitores();
         Monitores monitor = gmonitores.buscaMonitor(idmonitores);
         
         request.setAttribute("monitor", monitor);
         request.getRequestDispatcher("updatemonitor.jsp").forward(request, response);
         
         
     }
    
}
