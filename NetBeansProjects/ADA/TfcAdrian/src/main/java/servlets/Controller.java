package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        String url = "";
        switch (op) {
            case "doRecuperarClientes":
                url = "RecuperarClientes";
                break;
            case "doAltaCliente":
                url = "AltaCliente";
                break;
            case "doMostrarUpdate":
                url = "MostrarUpdate";
                break;
            case "doUpdateCliente":
                url = "UpdateCliente";
                break;
            case "doEliminarCliente":
                url = "EliminarCliente";
                break;
            case "doRecuperarMonitores":
                url = "RecuperarMonitores";
                break;
            case "doAltaMonitor":
                url = "AltaMonitor";
                break;
            case "doMonitorUpdate":
                url = "MonitorUpdMuestra";
                break;
            case "doUpdateMonitor":
                url = "UpdateMonitor";
                break;
            case "doRecuperarInstalaciones":
                url = "RecuperarInstalaciones";
                break;
            case "doRecuperarActividades":
                url = "RecuperarActividades";
                break;
            case "doPrenewActivity":
                url = "PrenewActivity";
                break;
            case "doAltaActividad":
                url = "AltaActividad";
                break;
            case "doActividadUpdate":
                url = "ViewEditActividad";
                break;
            case "doUpdateActividad":
                url = "UpdateActividad";
                break;
            case "doRecuperarInscripciones":
                url = "RecuperarInscripciones";
                break;
            case "doNewInscripcion1":
                url = "NewInscripcion1";
                break;
            case "doSeleccionarCliente":
                url = "NewInscripcion2";
                break;
            case "doConfirmaInscripcion":
                url = "ConfirmaInscripcion";
                break;
            case "doAltaInscripcion":
                url = "AltaInscripcion";
                break;
            case "doSeleccionarInscripcion":
                url = "SeleccionarInscripcion";
                break;
            case "doEliminarInscripcion":
                url = "EliminarInscripcion";
                break;
            case "doFiltrarInstalaciones":
                url = "FiltrarInstalaciones";
                break;
            case "doFiltrarCliente":
                url = "FiltrarCliente";
                break;
            case "doFiltrarMonitor":
                url = "FiltrarMonitor";
                break;
            case "doFiltrarActividad":
                url = "FiltrarActividad";
                break;
            case "doFiltrarInscripiones":
                url = "FiltrarInscripiones";
                break;
            case "doFiltrarSeleccionarActividad":
                url = "FiltrarSeleccionarActividad";
                break;

        }
        request.getRequestDispatcher(url).forward(request, response);
    }

}
