/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionActividad;
import mx.com.gm.sga.domain.Actividad;
import mx.com.gm.sga.domain.Deportes;

/**
 *
 * @author adrip
 */
@WebServlet("/FiltrarSeleccionarActividad")
public class FiltrarSeleccionarActividad extends HttpServlet {
     private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deporte = request.getParameter("deporte");
        String dia = request.getParameter("dia");
        GestionActividad gactividad = new GestionActividad();
        List<Actividad> list = gactividad.recuperarActividades();
        List<Actividad> pasa = new ArrayList<Actividad>();
        int opcion;

        if (deporte.equalsIgnoreCase("") == true) {
            //Busca por dia
            opcion = 1;
        } else if (dia.equalsIgnoreCase("") == true) {
            //Busca por deporte
            opcion = 2;
        } else {
            opcion = 3;
        }

        
        switch (opcion) {

            //busca por dia
            case 1:
                for (Actividad a : list) {
                    if (dia.equalsIgnoreCase(a.getDia()) == true) {
                        pasa.add(a);
                    }
                }
                break;

            //Busca por deporte
            case 2:
                for (Actividad a : list) {
                    Deportes d = a.getDeportes();
                    if (deporte.equalsIgnoreCase(d.getName()) == true) {
                        pasa.add(a);
                    }
                }
                break;

            //Busca por los dos
            case 3:
                for (Actividad a : list) {
                    Deportes d = a.getDeportes();
                    if (dia.equalsIgnoreCase(a.getDia()) == true) {
                        if (deporte.equalsIgnoreCase(d.getName()) == true) {
                            pasa.add(a);
                        }
                    }
                }
                break;

        }
        
        request.setAttribute("actividades", pasa);
        
        request.getRequestDispatcher("selectactividad.jsp").forward(request, response);
    }
    
}
