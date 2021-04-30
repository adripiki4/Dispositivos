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
import mx.com.gm.sga.domain.Cliente;

/**
 *
 * @author adrip
 */
@WebServlet("/UpdateCliente")
public class UpdateCliente extends HttpServlet {

    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idcliente");
        int idcliente = Integer.parseInt(id);
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String tele = request.getParameter("telefono");
        int telefono = Integer.parseInt(tele);
        String email = request.getParameter("email");
        String cuo = request.getParameter("cuota");
        double cuota = Double.parseDouble(cuo);
        
        Cliente cliente = new Cliente(idcliente, dni, nombre, apellidos, telefono, email, cuota);
        
        GestionCliente gcliente = new GestionCliente();
        gcliente.actualizarCliente(cliente);
        request.getRequestDispatcher("Controller?op=doRecuperarClientes").forward(request, response);
    }

}
