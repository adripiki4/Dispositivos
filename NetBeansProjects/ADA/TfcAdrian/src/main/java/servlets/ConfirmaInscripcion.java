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
import modelo.GestionActividad;
import modelo.GestionCliente;
import mx.com.gm.sga.domain.Actividad;
import mx.com.gm.sga.domain.Cliente;

/**
 *
 * @author adrip
 */
@WebServlet("/ConfirmaInscripcion")
public class ConfirmaInscripcion extends HttpServlet {
     private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idactividad = Integer.parseInt(request.getParameter("idactividad"));
        String dni = request.getParameter("dni");
        boolean find = false;
        
        GestionActividad gactividad = new GestionActividad();
        GestionCliente gcliente = new GestionCliente();
        
        //Recuperamos actividad
        Actividad actividad = gactividad.buscaActividad(idactividad);
        
        //Recuperamos el cliente por dni
        List<Cliente> list = gcliente.recuperarClientes();
        Cliente cliente = new Cliente();
        for(Cliente c : list){
            if(c.getDni().equalsIgnoreCase(dni)==true){
                cliente = c;
                find = true;
                break;
            }
        }
        
        //Pasamos los atributos
        if(find==true){
            request.setAttribute("actividad",actividad);
            request.setAttribute("cliente",cliente);
            
            request.getRequestDispatcher("confirmainscripcion.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("dniincorrecto.jsp").forward(request, response);
        }
    }
}
