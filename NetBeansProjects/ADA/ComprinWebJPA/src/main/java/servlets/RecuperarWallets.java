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
import modelo.GestionEwallet;
import mx.com.gm.sga.domain.Ewallet;


/**
 *
 * @author adrip
 */
@WebServlet("/RecuperarWallets")
public class RecuperarWallets extends HttpServlet {
     private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionEwallet gwallet = new GestionEwallet();
        List<Ewallet> ewallets = gwallet.recuperarEwallets();
         for(Ewallet e : ewallets){
            System.out.println(e);
        }
        //guardamos los productos en un atributo de peticion
        request.setAttribute("ewallets", ewallets);
        //transaferencia de la peticion
        request.getRequestDispatcher("ewallets.jsp").forward(request, response);
    }
}
