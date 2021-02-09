/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adriba
 */
@WebServlet("/AltaEwallet")
public class AltaEwallet extends HttpServlet {
private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          String nombre = request.getParameter("nombre");
          String apellidos = request.getParameter("apellidos");
          String dni = request.getParameter("dni");
          Date fechanacimiento = request.getParameter("fechanacimiento");
          String email = request.getParameter("email");
          int saldoeuros = request.getParameter("saldoeuros");
          int saldopuntos = request.getParameter("saldopuntos");
          //Creamos un objeto de la capa logica de negocio
          //Llamamos al metodo para hacer el alta
          GestionEwallet gewallet = new GestionEwallet();
          gewallet.altaEwallet(nombre,apellidos,dni,fechanacimiento, email, saldoeuros, saldopuntos);
          request.getRequestDispatcher("index.html").forward(request, response);
          
//        String nombre = request.getParameter("nombre");
//        String email = request.getParameter("email");
//        int telefono = Integer.parseInt(request.getParameter("telefono"));
//        //creamos un objeto de la capa de lgica de negocio
//        //y llamamos al método encargado de hacer el alta
//        GestionContactos gcontactos = new GestionContactos();
//        gcontactos.altaContacto(nombre, email, telefono);
//        request.getRequestDispatcher("index.html").forward(request, response);
    }


}
