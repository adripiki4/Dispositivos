
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionMonitores, java.util.ArrayList,mx.com.gm.sga.domain.Monitores"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Polideportivo-Monitores</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="newcss.css">
    </head>
    <body>
        <!-- MENU LATERAL -->
        <div class="sidenav">

            <a href="Controller?op=doRecuperarClientes">Clientes</a>
            <a href="Controller?op=doRecuperarActividades">Actividades</a>
            <a href="Controller?op=doRecuperarInscripciones">Inscripciones</a>
            <a href="Controller?op=doRecuperarInstalaciones">Instalaciones</a>
            <a href="Controller?op=doRecuperarMonitores">Monitores</a>
            <a href="">Usuarios</a>

        </div>

        <!-- CABECERA -->
    <header id="main-header">

        <a id="logo-header" href="index.html">
            <span class="site-name">Polideportivo Adrián</span>
            <span class="site-desc">Monitores</span>
        </a> <!-- / #logo-header -->

    </header>

    <!-- MAIN  -->
    <div class="main">

        <br>
        <fieldset>
            <legend>Filtrar</legend>
            <form action="Controller?op=doFiltrarMonitor" method="post">
                <input type="text" id="nombre" name="nombre"  placeholder="Nombre">
                <input type="submit" value="Buscar">
            </form>
            <br>
            <form action="RecuperarMonitores" method="post">
                <input type="submit" value="Mostrar todos">
            </form>
        </fieldset>
        <br>
        <form method=GET  action="newmonitor.html">
            <input type="submit" value="Nuevo Monitor">
        </form>
        <br>

        <c:set var="monitores" value="${requestScope.monitores}"/>

        <c:choose>

            <c:when test="${!empty monitores}">

                <table>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Teléfono</th>
                        <th>Email</th>
                    </tr>

                    <c:forEach var="moni" items="${monitores}">

                        <tr>
                            <td>${moni.nombre}</td>
                            <td>${moni.apellidos}</td>
                            <td>${moni.telefono}</td>
                            <td>${moni.email}</td>
                            <td><a class="seleccionar" href="Controller?op=doMonitorUpdate&idmonitores=${moni.idmonitores}">Seleccionar</a></td>

                        </tr>

                    </c:forEach>

                </table>

            </c:when>

            <c:otherwise>
                <h3>No se encontraron monitores</h3>
            </c:otherwise>

        </c:choose>

    </body>
</html>
