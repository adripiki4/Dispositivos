<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionDevolucion,java.util.ArrayList,mx.com.gm.sga.domain.Devolucion"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Devoluciones</title>
    </head>
    <body align="center">

        <c:set var="devoluciones" value="${requestScope.devoluciones}"/>

        <br/><br/><br/>

        <c:choose>

            <c:when test="${!empty devoluciones}">

                <table border="1" align="center">
                    <tr>
                        <th>Id Devolucion</th>
                        <th>Fecha Devolucion</th>
                        <th>Id Ewallet</th>
                        <th>Id Producto</th>
                        <th></th>
                    </tr>

                    <c:forEach var="cont" items="${devoluciones}">
                        <tr><td>${cont.iddevolucion}</td>
                            <td>${cont.fechadevolucion}</td>
                            <td>${cont.idwallet}</td>
                            <td>${cont.idproducto}</td>
                        </tr>


                    </c:forEach>



                </table>
            </c:when>
            <c:otherwise>
                <h1>No hay devoluciones</h1>
            </c:otherwise>
        </c:choose>
        <br/>
        <br/>
        <a href="index.html">Menu</a>
    </body>
</html>