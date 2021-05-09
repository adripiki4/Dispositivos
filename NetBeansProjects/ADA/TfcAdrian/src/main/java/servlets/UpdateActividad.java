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
import modelo.GestionActividad;
import modelo.GestionDeportes;
import modelo.GestionInstalacion;
import modelo.GestionMonitores;
import mx.com.gm.sga.domain.Actividad;
import mx.com.gm.sga.domain.Deportes;
import mx.com.gm.sga.domain.Instalacion;
import mx.com.gm.sga.domain.Monitores;

/**
 *
 * @author adrip
 */
@WebServlet("/UpdateActividad")
public class UpdateActividad extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idactividad = Integer.parseInt(request.getParameter("idactividad"));
        String nombre = request.getParameter("nombre");
        String instalacion = request.getParameter("instalacion");
        String monitor = request.getParameter("monitor");
        String aforo = request.getParameter("aforo");
        int maxpersonas = Integer.parseInt(aforo);
        String dia = request.getParameter("dia");
        String hora = request.getParameter("hora");
        String cuota = request.getParameter("cuota");
        double precio = Double.parseDouble(cuota);
       
        
        //Recuperamos la actividad para sacar los inscritos
        GestionActividad gactividad = new GestionActividad();
        Actividad busca = gactividad.buscaActividad(idactividad);
        int inscritos = busca.getInscritos();
       
        
        
        //Recuperamos la instalacion
        int idinstalacion = Integer.parseInt(instalacion);
        GestionInstalacion ginstalacion = new GestionInstalacion();
        Instalacion ins = ginstalacion.buscaInstalacion(idinstalacion);
        
        //Recuperamos el monitor
        int idmonitores = Integer.parseInt(monitor);
        GestionMonitores gmonitores = new GestionMonitores();
        Monitores moni = gmonitores.buscaMonitor(idmonitores);
        
        //Recuperamos el deporte
        
        Deportes depor =busca.getDeportes();
        
        
        //Creamos la actividady y actualizamos
        Actividad actividad = new Actividad(idactividad, nombre, dia, hora, maxpersonas, inscritos, precio, depor, ins, moni);
        gactividad.actualizarActividad(actividad);
        
        request.getRequestDispatcher("RecuperarActividades").forward(request, response);
    }

}
