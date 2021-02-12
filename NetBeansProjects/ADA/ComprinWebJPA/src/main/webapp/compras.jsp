<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionCompra,java.util.ArrayList,mx.com.gm.sga.domain.Compra"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Compras</title>
    </head>
    <body align="center">

        <c:set var="compras" value="${requestScope.compras}"/>

        <br/><br/><br/>

        <c:choose>

            <c:when test="${!empty compras}">

                <table border="1" align="center">
                    <tr>
                        <th>Id compra</th>
                        <th>Fecha Compra</th>
                        <th>Id Ewallet</th>
                        <th>Id Producto</th>
                        <th></th>
                    </tr>

                    <c:forEach var="cont" items="${compras}">
                        <tr><td>${cont.idcompra}</td>
                            <td>${cont.fechacompra}</td>
                            <td>${cont.ewallet}</td>
                            <td>${cont.idproducto}</td>
                            <td><a href="Controller?op=doHacerDevolucion&idcompra=${cont.idcompra}">Devolver Compra</a></td></tr>
                        </tr>


                    </c:forEach>



                </table>
            </c:when>
            <c:otherwise>
                <h1>No hay compras</h1>
            </c:otherwise>
        </c:choose>
        <br/>
        <br/>
        <a href="index.html">Menu</a>
    </body>
</html>