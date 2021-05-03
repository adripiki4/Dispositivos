
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionInstalacion, java.util.ArrayList,mx.com.gm.sga.domain.InstalacionName"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Polideportivo-Instalaciones</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="newcss.css">
    </head>
    <body>
        <!-- MENU LATERAL -->
        <div class="sidenav">

            <a href="Controller?op=doRecuperarClientes">Clientes</a>
            <a href="Controller?op=doRecuperarActividades">Actividades</a>
            <a href="inscriptions.html">Inscripciones</a>
            <a href="Controller?op=doRecuperarInstalaciones">Instalaciones</a>
            <a href="Controller?op=doRecuperarMonitores">Monitores</a>
            <a href="users.html">Usuarios</a>

        </div>

        <!-- CABECERA -->
    <header id="main-header">

        <a id="logo-header" href="index.html">
            <span class="site-name">Polideportivo Adrián</span>
            <span class="site-desc">Instalaciones</span>
        </a> <!-- / #logo-header -->

    </header>
    <!-- MAIN  -->
    <div class="main">

        <br>
        <fieldset>
            <legend>Filtrar</legend>
            <form>
                <input type="text" id=""  placeholder="Deporte">
                <input type="submit" value="Buscar">
                <input type="reset" value="Limpiar">
            </form>
        </fieldset>
        <br>

        <c:set var="instalaciones" value="${requestScope.instalaciones}"/>

        <c:choose>

            <c:when test="${!empty instalaciones}">

                <table>

                    <tr>
                        <th>Instalacion</th>
                        <th>Precio Alquiler</th>
                        <th>Deporte</th>
                    </tr>
                    
                    <c:forEach var="ins" items="${instalaciones}">
                        
                        <tr>
                            <td>${ins.name}</td>
                            <td>${ins.precio}</td>
                            <td>${ins.deporte}</td>
                        </tr>
                        
                    </c:forEach>

                </table>

            </c:when>
            <c:otherwise>
                <h1>No hay instalaciones</h1>
            </c:otherwise>
        </c:choose>

    </body>
</html>
