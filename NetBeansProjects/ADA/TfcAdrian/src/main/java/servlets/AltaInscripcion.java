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
import modelo.GestionActividad;
import modelo.GestionCliente;
import modelo.GestionInscripcion;
import mx.com.gm.sga.domain.Actividad;
import mx.com.gm.sga.domain.Cliente;
import mx.com.gm.sga.domain.Inscripcion;

/**
 *
 * @author adrip
 */
@WebServlet("/AltaInscripcion")
public class AltaInscripcion extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idactividad = Integer.parseInt(request.getParameter("idactividad"));
        int idcliente = Integer.parseInt(request.getParameter("idcliente"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        boolean repetido = false;
        System.out.println(precio);

        //Recuperamos objetos
        GestionCliente gcliente = new GestionCliente();
        GestionActividad gactividad = new GestionActividad();

        Cliente cliente = gcliente.buscaCliente(idcliente);
        Actividad actividad = gactividad.buscaActividad(idactividad);

        //Comprobamos que no se repita la inscripcion
        GestionInscripcion ginscripcion = new GestionInscripcion();
        List<Inscripcion> inscripciones = ginscripcion.recuperarInscripciones();

        for (Inscripcion i : inscripciones) {
            if (i.getActividad() == actividad) {
                if (i.getCliente() == cliente) {
                    repetido = true;
                    break;
                }
            }
        }

        if (repetido == true) {
            //meter condicion de fallo

        } else {
            //         Actualizamos valores
            double cuota = cliente.getCuota();
            cuota = (cuota) + (precio);

            cliente.setCuota(cuota);
            gcliente.actualizarCliente(cliente);

            int inscritos = actividad.getInscritos();
            inscritos = (inscritos) + (1);

            actividad.setInscritos(inscritos);
            gactividad.actualizarActividad(actividad);

            //Realizamos la nueva inscripcion
            Inscripcion nueva = new Inscripcion(cliente, actividad);
            ginscripcion.altaInscripcion(nueva);

            //Volvemos
            request.getRequestDispatcher("RecuperarInscripciones").forward(request, response);
        }

    }

}
