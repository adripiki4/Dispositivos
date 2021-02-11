/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionEwallet;
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
          String fechanacimiento = request.getParameter("fechanacimiento");
          String email = request.getParameter("email");
          String saldoeu = request.getParameter("saldoeuros");
          String saldopu = request.getParameter("saldopuntos");
          int saldoeuros = Integer.parseInt(saldoeu);
          int saldopuntos = 0;
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date fecha = null;
    try {
        fecha = sdf.parse(fechanacimiento);
    } catch (ParseException ex) {
        Logger.getLogger(AltaEwallet.class.getName()).log(Level.SEVERE, null, ex);
    }
          java.sql.Date fechabuena = new java.sql.Date(fecha.getTime());
          
          
          
          //Creamos un objeto de la capa logica de negocio
          //Llamamos al metodo para hacer el alta
          GestionEwallet gewallet = new GestionEwallet();
          gewallet.altaEwallet(nombre,apellidos,dni,fechabuena, email, saldoeuros, saldopuntos);
          request.getRequestDispatcher("index.html").forward(request, response);

    }


}
