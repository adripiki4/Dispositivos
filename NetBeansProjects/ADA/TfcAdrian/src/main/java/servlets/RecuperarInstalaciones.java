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
import modelo.GestionDeportes;
import modelo.GestionInstalacion;
import mx.com.gm.sga.domain.Deportes;
import mx.com.gm.sga.domain.Instalacion;
import mx.com.gm.sga.domain.InstalacionName;

/**
 *
 * @author adrip
 */
@WebServlet("/RecuperarInstalaciones")
public class RecuperarInstalaciones extends HttpServlet {
     private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         GestionInstalacion ginstalacion = new GestionInstalacion();
         GestionDeportes gdeportes = new GestionDeportes();
         List<Instalacion> listinsta = ginstalacion.recuperarInstalaciones();
//         List<Deportes> listdepor = gdeportes.recuperarDeportes();
         List<InstalacionName> listinstalaciones = new ArrayList<InstalacionName>();
         
//         for(Instalacion ins:listinsta){
//             for(Deportes d : listdepor){
//                 if(ins.getDeportes_id()== d.getId()){
//                     InstalacionName nueva = new InstalacionName(ins.getIdinstalacion(), ins.getName(), ins.getPrecio(),d.getName());
//                     listinstalaciones.add(nueva);
//                 }
//             }
//         }

        for(Instalacion ins : listinsta){
            Deportes depor = ins.getDeporte();
            InstalacionName nueva = new InstalacionName(ins.getIdinstalacion(),ins.getName(),ins.getPrecio(),depor.getName());
            listinstalaciones.add(nueva);
        }
         
         for(InstalacionName i : listinstalaciones){
             System.out.println(i);
         }
         
         //Guardamos las instalaciones en un atributo de peticion
         request.setAttribute("instalaciones", listinstalaciones);
         //Transferencia de la peticion
         request.getRequestDispatcher("instalaciones.jsp").forward(request, response);
     } 
}
