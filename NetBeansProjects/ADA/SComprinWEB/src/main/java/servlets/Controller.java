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
            case "doAlta":
                url = "AltaEwallet";
                break;
            case "doEliminar":
                url = "RecargarEwallet";
                break;
            case "doRecuperar":
                url = "AltaProducto";
                break;
            case "toNuevo":
                url = "nuevo.html";
                break;
            case "toMenu":
                url = "index.html";
                break;
            case "doLogin":
                url = "LoginAction";
                break;

        }
        request.getRequestDispatcher(url).forward(request, response);
    }

}
