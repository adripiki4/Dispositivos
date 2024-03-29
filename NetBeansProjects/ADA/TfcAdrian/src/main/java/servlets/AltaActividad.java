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
@WebServlet("/AltaActividad")
public class AltaActividad extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String instalacion = request.getParameter("instalacion");
        String monitor = request.getParameter("monitor");
        String aforo = request.getParameter("aforo");
        int maxpersonas = Integer.parseInt(aforo);
        String dia = request.getParameter("dia");
        String hora = request.getParameter("hora");
        String cuota = request.getParameter("cuota");
        double precio = Double.parseDouble(cuota);
        String deporte = request.getParameter("deporte");
        
        //Recuperamos la instalacion
        int idinstalacion = Integer.parseInt(instalacion);
        GestionInstalacion ginstalacion = new GestionInstalacion();
        Instalacion ins = ginstalacion.buscaInstalacion(idinstalacion);
        
        //Recuperamos el monitor
        int idmonitores = Integer.parseInt(monitor);
        GestionMonitores gmonitores = new GestionMonitores();
        Monitores moni = gmonitores.buscaMonitor(idmonitores);
        
        //Recuperamos el deporte
        int iddeporte = Integer.parseInt(deporte);
        GestionDeportes gdeporte = new GestionDeportes();
        Deportes depor = gdeporte.buscaDeporte(iddeporte);
        
        Actividad nueva = new Actividad(nombre, dia, hora, maxpersonas, precio, depor, ins, moni);
        
        GestionActividad gactividad = new GestionActividad();
        gactividad.altaActividad(nueva);
        
        request.getRequestDispatcher("RecuperarActividades").forward(request, response);
        
        
        
    }
    
}
