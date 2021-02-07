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
import modelo.GestionProducto;
import mx.com.gm.sga.domain.Producto;

/**
 *
 * @author adrip
 */
@WebServlet("/RecuperarProductos")
public class RecuperarProductos extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionProducto gproducto = new GestionProducto();
        List<Producto> productos = gproducto.listarProductos();
         for(Producto p : productos){
            System.out.println(p);
        }
        //guardamos los productos en un atributo de peticion
        request.setAttribute("productos", productos);
        //transaferencia de la peticion
        request.getRequestDispatcher("productos.jsp").forward(request, response);
    }
}
