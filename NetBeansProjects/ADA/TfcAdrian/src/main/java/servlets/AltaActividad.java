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

/**
 *
 * @author adrip
 */
@WebServlet("/AltaActividad")
public class AltaActividad extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String instalacion = request.getParameter("instalacion");
        String monitor = request.getParameter("monitor");
        String aforo = request.getParameter("aforo");
        String dia = request.getParameter("dia");
        String hora = request.getParameter("hora");
        String cuota = request.getParameter("cuota");
        String deporte = request.getParameter("deporte");
        
        System.out.println(nombre+instalacion+monitor+aforo+dia+hora+cuota+"  "+deporte);
        
    }
    
}
