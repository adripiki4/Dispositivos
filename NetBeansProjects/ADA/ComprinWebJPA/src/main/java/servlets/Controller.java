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
            case "doRecuperarProductos":
                url = "RecuperarProductos";
                break;
            case "doRecuperarWallets":
                url = "RecuperarWallets";
                break;
            case "doRecuperarCompras":
                url = "RecuperarCompras";
                break;
            case "doRecuperarDevoluciones":
                url = "RecuperarDevoluciones";
                break;
            case "toNuevoEwallet":
                url = "nuevoEwallet.html";
                break;
            case "doAltaEwallet":
                url = "AltaEwallet";
                break;
            case "toNuevaCompra":
                url = "nuevaCompra.html";
                break;
            case "doAltaCompra":
                url="AltaCompra";
                break;
            case "doHacerDevolucion":
                url="AltaDevolucion";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

}
