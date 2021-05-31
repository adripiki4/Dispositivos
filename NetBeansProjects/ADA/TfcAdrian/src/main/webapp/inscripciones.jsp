<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionInscripcion, java.util.ArrayList,mx.com.gm.sga.domain.Inscripcion"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Polideportivo-Inscripciones</title>
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
            <a href="users.html">Usuarios</a>

        </div>

        <!-- CABECERA -->
    <header id="main-header">

        <a id="logo-header" href="index.html">
            <span class="site-name">Polideportivo Adrián</span>
            <span class="site-desc">Inscripciones</span>
        </a> <!-- / #logo-header -->

    </header>
    <!-- MAIN  -->
    <div class="main">

        <br>
        <fieldset>
            <legend>Filtrar</legend>
            <form action="Controller?op=doFiltrarInscripiones" method="post">
                <input type="text" id="nombre" name="nombre"  placeholder="Nombre Actividad">
                <input type="text" id="dni" name="dni"  placeholder="DNI cliente">
                <input type="submit" value="Buscar">
            </form>
            <br>
            <form action="RecuperarInscripciones" method="post">
                <input type="submit" value="Mostrar todas">
            </form>
        </fieldset>
        <br>
        <form action="Controller?op=doNewInscripcion1" method="post">
            <input type="submit" value="Nueva Incripción">
        </form>
        <br>

        <c:set var="inscripciones" value="${requestScope.inscripciones}"/>

        <c:choose>
            <c:when test="${!empty inscripciones}">

                <table>
                    <tr>
                        <th>Nº Registro</th>
                        <th>Nombre Actividad</th>
                        <th>DNI Cliente</th>
                    </tr>

                    <c:forEach var="ins" items="${inscripciones}">
                        <tr>
                            <td>${ins.idinscripcion}</td>
                            <td>${ins.actividad}</td>
                            <td>${ins.cliente}</td>
                            <td><a class="seleccionar" href="Controller?op=doSeleccionarInscripcion&idinscripcion=${ins.idinscripcion}">Seleccionar</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <h1>No hay inscripciones</h1>
            </c:otherwise>
        </c:choose>

    </body>
</html>
