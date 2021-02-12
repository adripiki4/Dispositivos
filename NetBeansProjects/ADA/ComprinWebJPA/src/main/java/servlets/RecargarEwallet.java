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
import modelo.GestionEwallet;
import mx.com.gm.sga.domain.Ewallet;

/**
 *
 * @author adrip
 */
@WebServlet("/RecargarEwallet")
public class RecargarEwallet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idwallet = Integer.parseInt(request.getParameter("idwallet"));
        GestionEwallet gewallet = new GestionEwallet();
        Ewallet ewallet = gewallet.buscaEwallet(idwallet);
        //Hacer la recarga
        int saldo = ewallet.getSaldoeuros();
        saldo = saldo + 5;
        ewallet.setSaldoeuros(saldo);
        gewallet.actulizarEwallet(ewallet);
        request.getRequestDispatcher("RecuperarWallets").forward(request, response);
    }
}
