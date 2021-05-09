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
import modelo.GestionActividad;
import mx.com.gm.sga.domain.Actividad;

/**
 *
 * @author adrip
 */
@WebServlet("/NewInscripcion2")
public class NewInscripcion2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int idactividad = Integer.parseInt(request.getParameter("idactividad"));
    GestionActividad gestionActividad = new GestionActividad();
    Actividad actividad = gestionActividad.buscaActividad(idactividad);
    
    request.setAttribute("actividad",actividad);
    request.getRequestDispatcher("selectcliente.jsp").forward(request, response);
}
    
}
