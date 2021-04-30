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
@WebServlet("/MostrarUpdate")
public class MostrarUpdate extends HttpServlet {
        private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
         protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             //Recuperamos el idcliente
             int idcliente = Integer.parseInt(request.getParameter("idcliente"));
             //Recuperamos el cliente
             GestionCliente gcliente = new GestionCliente();
             Cliente cliente = gcliente.buscaCliente(idcliente);
             List<Cliente> listacliente = new ArrayList<Cliente>();
             listacliente.add(cliente);
             //mostramos que lo hayamos encontrado y agregado a la lista para pasarlo
             System.out.println("Mostrarupdate: "+cliente);
             //Guardamos los clientes en un atributo de petición
             request.setAttribute("cliente", cliente);
             //Transferencia de la peticion
             request.getRequestDispatcher("updateclientes.jsp").forward(request, response);
             
         }
}
