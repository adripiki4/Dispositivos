<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionProducto,java.util.ArrayList,mx.com.gm.sga.domain.Producto"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Productos</title>
    </head>
    <body>

        <c:set var="productos" value="${requestScope.productos}"/>

        <br/><br/><br/>

        <c:choose>

            <c:when test="${!empty productos}">

                <table border="1">
                    <tr>
                        <th>Id_producto</th>
                        <th>Nombre Producto</th>
                        <th>Precio Producto</th>
                        <th>Puntos Producto</th>
                        <th></th>
                    </tr>
                    <c:forEach var="cont" items="${productos}">
                        <tr><td>${cont.Id_producto}</td>
                            <td>${cont.NombreProducto}</td>
                            <td>${cont.PrecioProducto}</td>
                            <td>${cont.PuntosProducto}</td>
                            <td>Eliminar</td>
                        </tr>


                    </c:forEach>



                </table>
            </c:when>
            <c:otherwise>
                <h1>No hay productos</h1>
            </c:otherwise>
        </c:choose>
        <br/>
        <br/>
        <a href="index.html">Menu</a>
    </body>
</html>