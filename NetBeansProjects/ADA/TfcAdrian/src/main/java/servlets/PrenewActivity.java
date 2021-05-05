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
import modelo.GestionDeportes;
import modelo.GestionInstalacion;
import modelo.GestionMonitores;
import mx.com.gm.sga.domain.Deportes;
import mx.com.gm.sga.domain.Instalacion;
import mx.com.gm.sga.domain.Monitores;

/**
 *
 * @author adrip
 */
@WebServlet("/PrenewActivity")
public class PrenewActivity extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionMonitores gmonitores = new GestionMonitores();
        List<Monitores> listmonitores = gmonitores.recuperarMonitores();
        
        GestionInstalacion ginstalacion = new GestionInstalacion();
        List<Instalacion> listinstalacion = ginstalacion.recuperarInstalaciones();
        
        GestionDeportes gdeportes = new GestionDeportes();
        List<Deportes> listadeportes = gdeportes.recuperarDeportes();
        
        
        request.setAttribute("monitores", listmonitores);
        request.setAttribute("instalaciones", listinstalacion);
        request.setAttribute("deportes",listadeportes);
       
        request.getRequestDispatcher("newactividad.jsp").forward(request, response);
    }
}
