<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionEwallet,java.util.ArrayList,mx.com.gm.sga.domain.Ewallet"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Area Clientes</title>
    </head>
    <body align="center">

        <c:set var="ewallets" value="${requestScope.ewallets}"/>

        <br/><br/><br/>

        <c:choose>

            <c:when test="${!empty ewallets}">

                <table border="1" align="center">
                    <tr>
                        <th>Id_ewallet</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>DNI</th>
                        <th>Fecha Nacimiento</th>
                        <th>Email</th>
                        <th>Saldo Puntos</th>
                        <th>Saldo Euros</th>
                        <th>Recargar 5 euros</th>
                        <th></th>
                    </tr>

                    <c:forEach var="cont" items="${ewallets}">
                        <tr><td>${cont.idwallet}</td>
                            <td>${cont.nombre}</td>
                            <td>${cont.apellidos}</td>
                            <td>${cont.dni}</td>
                            <td>${cont.fechanacimiento}</td>
                            <td>${cont.email}</td>
                            <td>${cont.saldopuntos}</td>
                            <td>${cont.saldoeuros}</td>
                            <td><a href="Controller?op=doHacerRecarga&idwallet=${cont.idwallet}">Recargar</a></td></tr>


                    </c:forEach>



                </table>
            </c:when>
            <c:otherwise>
                <h1>No hay ewallets</h1>
            </c:otherwise>
        </c:choose>
        <br/>
        <br/>
        <a href="index.html">Menu</a>
    </body>
</html>