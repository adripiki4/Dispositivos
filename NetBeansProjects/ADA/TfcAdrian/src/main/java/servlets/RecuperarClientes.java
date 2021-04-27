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
import modelo.GestionCliente;
import mx.com.gm.sga.domain.Cliente;

/**
 *
 * @author adrip
 */
@WebServlet("/RecuperarClientes")
public class RecuperarClientes extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionCliente gcliente = new GestionCliente();
        List<Cliente> listclientes = gcliente.recuperarClientes();
        for(Cliente cli : listclientes){
            System.out.println(cli);
        }
        //Guardamos los clintes en un atributo de peticion
        request.setAttribute("clientes", listclientes);
        //Transferencia de la peticion
        request.getRequestDispatcher("clientes.jsp").forward(request, response);
    }
    
}
