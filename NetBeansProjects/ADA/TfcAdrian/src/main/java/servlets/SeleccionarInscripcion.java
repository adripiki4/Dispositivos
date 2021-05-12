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
import modelo.GestionInscripcion;
import mx.com.gm.sga.domain.Actividad;
import mx.com.gm.sga.domain.Cliente;
import mx.com.gm.sga.domain.Inscripcion;

/**
 *
 * @author adrip
 */
@WebServlet("/SeleccionarInscripcion")
public class SeleccionarInscripcion extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int idinscripcion = Integer.parseInt(request.getParameter("idinscripcion"));
         GestionInscripcion ginscripcion = new GestionInscripcion();
         Inscripcion inscripcion = ginscripcion.buscaInscripcion(idinscripcion);
         Actividad actividad = inscripcion.getActividad();
         Cliente cliente = inscripcion.getCliente();
         
         request.setAttribute("inscripcion",inscripcion);
         request.setAttribute("actividad",actividad);
         request.setAttribute("cliente",cliente);
         
         request.getRequestDispatcher("deleteinscripcion.jsp").forward(request, response);
     }
    
}
