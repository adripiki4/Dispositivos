/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionCompra;
import modelo.GestionDevolucion;
import modelo.GestionEwallet;
import modelo.GestionProducto;
import mx.com.gm.sga.domain.Compra;
import mx.com.gm.sga.domain.Ewallet;
import mx.com.gm.sga.domain.Producto;

/**
 *
 * @author adrip
 */
@WebServlet("/AltaDevolucion")
public class AltaDevolucion extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idcompra = Integer.parseInt(request.getParameter("idcompra"));
        GestionCompra gcompra = new GestionCompra();
        //Recuperamos la compra
        Compra compra = gcompra.buscarCompra(idcompra);
        Ewallet ewallet = compra.getEwallet();
        int idwallet = ewallet.getIdwallet();
        int idproducto = compra.getIdproducto();
        gcompra.eliminarCompra(idcompra);

        //Devolvemos el dinero y restamos los puntos al ewallet
        GestionProducto gproducto = new GestionProducto();
        GestionEwallet gewallet = new GestionEwallet();

        Producto producto = gproducto.buscaProducto(idproducto);
        //Ewallet ewallet = gewallet.buscaEwallet(idwallet);

        int saldoeuros = ewallet.getSaldoeuros();
        int saldopuntos = ewallet.getSaldopuntos();
        int precio = producto.getPrecioproducto();
        int puntospro = producto.getPuntosproducto();

        saldoeuros = saldoeuros + precio;
        saldopuntos = saldopuntos - puntospro;
        
        ewallet.setSaldoeuros(saldoeuros);
        ewallet.setSaldopuntos(saldopuntos);
        
        //Actulizamos el ewallet
        gewallet.actulizarEwallet(ewallet);

        //creamos un objeto de la capa de lgica de negocio
        //y llamamos al método encargado de hacer el alta
        GestionDevolucion gdevolucion = new GestionDevolucion();
        java.util.Date fecha = new java.util.Date();
        long lo = fecha.getTime();
        java.sql.Date fechapasa = new java.sql.Date(lo);
        gdevolucion.altaDevolucion(fechapasa, idwallet, idproducto);

        request.getRequestDispatcher("RecuperarCompras").forward(request, response);
    }
}
