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
import modelo.GestionCliente;
import mx.com.gm.sga.domain.Cliente;

/**
 *
 * @author adrip
 */
@WebServlet("/FiltrarCliente")
public class FiltrarCliente extends HttpServlet {
     private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String dni = request.getParameter("dni");
         
         GestionCliente gcliente = new GestionCliente();
         List<Cliente> list = gcliente.recuperarClientes();
         List<Cliente> pasa = new ArrayList<Cliente>();
         
         for(Cliente c : list){
             if(dni.equalsIgnoreCase(c.getDni())==true){
                 pasa.add(c);
             }
         }
         
         request.setAttribute("clientes",pasa);
         
         request.getRequestDispatcher("clientes.jsp").forward(request, response);
     }
    
}
