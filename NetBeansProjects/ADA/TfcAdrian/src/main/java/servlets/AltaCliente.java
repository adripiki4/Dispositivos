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
@WebServlet("/AltaCliente")
public class AltaCliente extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String tele = request.getParameter("telefono");
        int telefono = Integer.parseInt(tele);
        String email = request.getParameter("email");
        double cuota = 0;

        //Creamos un objeto de la capa logica de negocio
        //Llamamos al metodo para hacer el alta
        GestionCliente gcliente = new GestionCliente();
        gcliente.altaCliente(dni, nombre, apellidos, telefono,email,cuota);
        request.getRequestDispatcher("index.html").forward(request, response);
    }
}
