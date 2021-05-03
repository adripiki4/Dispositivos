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
import modelo.GestionCliente;

/**
 *
 * @author adrip
 */
@WebServlet("/EliminarCliente")
public class EliminarCliente extends HttpServlet {
     private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionCliente gcliente = new GestionCliente();
        String idcliente = request.getParameter("idcliente");
        int id = Integer.parseInt(idcliente);
        gcliente.eliminarCliente(id);
        request.getRequestDispatcher("RecuperarClientes").forward(request, response);
    }
}
