/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.awt.Component;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.GestionCliente;
import mx.com.gm.sga.domain.Cliente;

/**
 *
 * @author adrip
 */
@WebServlet("/AltaCliente")
public class AltaCliente extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean dnirepetido = false;
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String tele = request.getParameter("telefono");
        int telefono = Integer.parseInt(tele);
        String email = request.getParameter("email");
        double cuota = 0;

        GestionCliente gcliente = new GestionCliente();
        List<Cliente> clientes = gcliente.recuperarClientes();

        for (Cliente c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni) == true) {
                dnirepetido = true;
                break;
            }
        }

        if (dnirepetido == true) {
           
        } else {
            //Creamos un objeto de la capa logica de negocio
            //Llamamos al metodo para hacer el alta
            gcliente.altaCliente(dni, nombre, apellidos, telefono, email, cuota);
            request.getRequestDispatcher("Controller?op=doRecuperarClientes").forward(request, response);
        }

    }
}
