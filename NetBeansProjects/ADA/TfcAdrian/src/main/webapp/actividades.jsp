

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionActividad, java.util.ArrayList,mx.com.gm.sga.domain.Actividad"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Polideportivo-Actividades</title>
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
            <span class="site-desc">Actividades</span>
        </a> <!-- / #logo-header -->

    </header>
    <!-- MAIN  -->
    <div class="main">
        <br>

        <fieldset>
            <legend>Filtrar</legend>
            <form>
                <input type="text" id="deporte"  placeholder="Deporte">
                <input type="text" id="dia"  placeholder="Dia de la semana">
                <input type="submit" value="Buscar">
                <input type="submit" value="Limpiar">
            </form>
        </fieldset>
        <br>
        <form action="Controller?op=doPrenewActivity" method="post">
            <input type="submit" value="Nueva Actividad">
        </form><br>

        <c:set var="actividades" value="${requestScope.actividades}"/>

        <c:choose>

            <c:when test="${!empty actividades}">

                <table>
                    <tr>
                        <th>Actividad</th>
                        <th>Dia de la semana</th>
                        <th>Hora</th>
                        <th>Inscritos</th>
                        <th>Capacidad</th>
                        <th>Precio (Euros)</th>
                        <th>Instalacion</th>
                        <th>Deporte</th>
                        <th>Monitor</th>
                    </tr>
                    
                    <c:forEach var="act" items="${actividades}">
                        
                        <tr>
                            <td>${act.nombre}</td>
                            <td>${act.dia}</td>
                            <td>${act.hora}</td>
                            <td>${act.inscritos}</td>
                            <td>${act.maxpersonas}</td>
                            <td>${act.precio}</td>
                            <td>${act.instalacion}</td>
                            <td>${act.deportes}</td>
                            <td>${act.monitores}</td>
                            <td><a href="Controller?op=doActividadUpdate&idactividad=${act.idactividad}">Editar</a></td>
                        </tr>
                        
                    </c:forEach>

                </table>
            </c:when>
            
            <c:otherwise>
                <h1>No hay actividades</h1>
            </c:otherwise>

        </c:choose>

    </div>
</body>
</html>
