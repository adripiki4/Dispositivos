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
import modelo.GestionInscripcion;
import mx.com.gm.sga.domain.Actividad;
import mx.com.gm.sga.domain.Cliente;
import mx.com.gm.sga.domain.Inscripcion;

/**
 *
 * @author adrip
 */
@WebServlet("/FiltrarInscripiones")
public class FiltrarInscripiones extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String dni = request.getParameter("dni");
        GestionInscripcion ginscripcion = new GestionInscripcion();
        List<Inscripcion> list = ginscripcion.recuperarInscripciones();
        List<Inscripcion> pasa = new ArrayList<Inscripcion>();
        int opcion;

        if (nombre.equalsIgnoreCase("") == true) {
            //Busca por dni
            opcion = 1;
        } else if (dni.equalsIgnoreCase("") == true) {
            //Busca por dni
            opcion = 2;
        } else {
            opcion = 3;
        }

        switch (opcion) {

            //Busca por dni
            case 1:
                for (Inscripcion i : list) {
                    Cliente c = i.getCliente();
                    if (dni.equalsIgnoreCase(c.getDni()) == true) {
                        pasa.add(i);
                    }
                }
                break;

            //Busca por nombre
            case 2:
                for (Inscripcion i : list) {
                    Actividad a = i.getActividad();
                    if (nombre.equalsIgnoreCase(a.getNombre()) == true) {
                        pasa.add(i);
                    }
                }
                break;

            //Busca por los dos
            case 3:
                for (Inscripcion i : list) {
                    Actividad a = i.getActividad();
                    Cliente c = i.getCliente();
                    if (nombre.equalsIgnoreCase(a.getNombre()) == true) {
                        if (dni.equalsIgnoreCase(c.getDni()) == true) {
                            pasa.add(i);
                        }
                    }
                }
                break;

        }
        
        request.setAttribute("inscripciones",pasa);
        
        request.getRequestDispatcher("inscripciones.jsp").forward(request, response);

    }

}
