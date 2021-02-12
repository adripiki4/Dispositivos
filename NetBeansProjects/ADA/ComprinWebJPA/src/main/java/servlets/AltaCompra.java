/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionCompra;
import modelo.GestionEwallet;
import modelo.GestionProducto;
import mx.com.gm.sga.domain.Ewallet;
import mx.com.gm.sga.domain.Producto;

/**
 *
 * @author adrip
 */
@WebServlet("/AltaCompra")
public class AltaCompra extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean encuentra = false;
        int idwallet = Integer.parseInt(request.getParameter("idwallet"));
        int idproducto = Integer.parseInt(request.getParameter("idproducto"));
        GestionProducto gproducto = new GestionProducto();
        GestionEwallet gewallet = new GestionEwallet();

        //Comprobacion de que existe el ewallet
        List<Ewallet> listaewallets = gewallet.recuperarEwallets();
        for (Ewallet e : listaewallets) {
            int compara = e.getIdwallet();
            if (compara == idwallet) {
                encuentra = true;
                break;
            }
        }
        if (encuentra == false) {
            request.getRequestDispatcher("EwalletIncorrecta.html").forward(request, response);
        }

        //Comprobacion de que existe el producto
        List<Producto> listaproductos = gproducto.listarProductos();
        for (Producto p : listaproductos) {
            int busca = p.getIdproducto();
            if (busca == idproducto) {
                encuentra = true;
                break;
            }else{
                encuentra = false;
            }
        }
        if (encuentra == false) {
            request.getRequestDispatcher("EwalletIncorrecta.html").forward(request, response);
        }

        Ewallet ewallet = gewallet.buscaEwallet(idwallet);
        int saldo = ewallet.getSaldoeuros();
        System.out.println("Saldo" + saldo);

        //Comprobar el precio del producto y si tiene saldo
        Producto producto = gproducto.buscaProducto(idproducto);
        int preciopro = producto.getPrecioproducto();
        System.out.println("Precio" + preciopro);

        if (preciopro > saldo) {
            request.getRequestDispatcher("NoSaldo.html").forward(request, response);
            encuentra = false;
        }

        //Realizaoms la compra y restamos saldo y sumamos puntos
        if (encuentra == true) {
            int puntospro = producto.getPuntosproducto();
            int puntoswallet = ewallet.getSaldopuntos();

            saldo = saldo - preciopro;
            puntoswallet = puntoswallet + puntospro;

            //Actualizamos saldo y puntos
            ewallet.setSaldoeuros(saldo);
            ewallet.setSaldopuntos(puntoswallet);
            gewallet.actulizarEwallet(ewallet);

            java.util.Date fecha = new java.util.Date();
            long lo = fecha.getTime();
            java.sql.Date fechapasa = new java.sql.Date(lo);
            //creamos un objeto de la capa de lgica de negocio
            //y llamamos al método encargado de hacer el alta
            GestionCompra gcompra = new GestionCompra();
            gcompra.altaCompra(fechapasa, ewallet, idproducto);
            request.getRequestDispatcher("RecuperarCompras").forward(request, response);
        }
    }
}
