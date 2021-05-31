

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionActividad, java.util.ArrayList,mx.com.gm.sga.domain.Actividad"%>
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
            <span class="site-desc">Nueva Inscripcion</span>
        </a> <!-- / #logo-header -->

    </header>
    <!-- MAIN  -->
    <div class="main">
       
        
        <h3>Selecciona una actividad para continuar</h3>

        <fieldset>
            <legend>Filtrar</legend>
            <form action="Controller?op=doFiltrarSeleccionarActividad" method="post">
                <!--<label for="deporte">Deporte:</label>-->
                <select name="deporte" id="deporte">
                    <option value="">Deporte</option>
                    <option value="padel">Padel</option>
                    <option value="natacion">Natación</option>
                    <option value="futbol">Fútbol</option>
                    <option value="baloncesto">Baloncesto</option>
                    <option value="baile">Baile</option>
                </select>
                <!--<label for="dia">Día de la semana:</label>-->
                <select name="dia" id="dia">
                    <option value="">Día</option>
                    <option value="lunes">Lunes</option>
                    <option value="martes">Martes</option>
                    <option value="miercoles">Miercoles</option>
                    <option value="jueves">Jueves</option>
                    <option value="viernes">Viernes</option>
                </select>
                <!--<input type="text" id="dia" name="dia"  placeholder="Dia de la semana">-->
                <input type="submit" value="Buscar">
            </form>
            <br>
            <form action="RecuperarActividades" method="post">
                <input type="submit" value="Mostrar todas">
            </form>
        </fieldset>
        <br>
        <form action="RecuperarInscripciones" method="post">
            <input type="submit" value="Salir">
        </form>
        <br>
       
        

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
                            <td><a class="seleccionar" href="Controller?op=doSeleccionarCliente&idactividad=${act.idactividad}">Seleccionar</a></td>
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
