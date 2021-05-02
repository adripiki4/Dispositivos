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
import modelo.GestionCompra;
import mx.com.gm.sga.domain.Compra;
import mx.com.gm.sga.domain.Ewallet;


/**
 *
 * @author adrip
 */
@WebServlet("/RecuperarCompras")
public class RecuperarCompras extends HttpServlet{
     private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionCompra gcompra = new GestionCompra();
        List<Compra> compras = gcompra.listarCompras();
         for(Compra c : compras){
            System.out.println(c);
        }
        //guardamos los productos en un atributo de peticion
        request.setAttribute("compras", compras);
        //transaferencia de la peticion
        request.getRequestDispatcher("compras.jsp").forward(request, response);
    }
}
