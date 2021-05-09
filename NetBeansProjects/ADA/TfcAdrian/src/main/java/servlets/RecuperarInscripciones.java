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
import modelo.GestionInscripcion;
import mx.com.gm.sga.domain.Inscripcion;

/**
 *
 * @author adrip
 */
@WebServlet("/RecuperarInscripciones")
public class RecuperarInscripciones extends HttpServlet {
     private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
      protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          GestionInscripcion ginscripcion = new GestionInscripcion();
          List<Inscripcion> inscripciones = ginscripcion.recuperarInscripciones();
          
          request.setAttribute("inscripciones", inscripciones);
          request.getRequestDispatcher("inscripciones.jsp").forward(request, response);
      }
    
}
