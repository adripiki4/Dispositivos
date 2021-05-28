<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionActividad, java.util.ArrayList,mx.com.gm.sga.domain.ActividadName"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Polideportivo-Actividad</title>
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
            <span class="site-desc">Actividades-Editar</span>
        </a> <!-- / #logo-header -->

    </header>

    <!-- MAIN  -->
    <div class="main">
        <br>


        <fieldset>
            <legend>Editar Actividad</legend>
            <c:set var="actividad" value="${requestScope.actividad}"/>
            <form action="Controller?op=doUpdateActividad&idactividad=${actividad.idactividad}" method="post">


                <p>Nombre de la Actividad: <input type="text" id="nombre" size="30" name="nombre" value="${actividad.nombre}"></p>

                <!--                Seleccionar instalaciones-->
                <c:set var="instalaciones" value="${requestScope.instalaciones}"/>
                <c:choose>
                    <c:when test="${!empty instalaciones}">
                        <label for="instalacion">Instalacion: (Actual ${actividad.instalacion}) </label>
                        <select name="instalacion" id="instalacion">

                            <c:forEach var="ins" items="${instalaciones}">

                            <option value="${ins.idinstalacion}">${ins.name}</option>

                            </c:forEach>
                        </select>
                    </c:when>
                    <c:otherwise>
                        <p>No hay instalaciones disponibles</p>
                    </c:otherwise>
                </c:choose>
                <br><br>


                <!--                    Seleccionar monitores-->
                <c:set var="monitores" value="${requestScope.monitores}"/>
                <c:choose>
                    <c:when test="${!empty monitores}">
                        <label for="monitor">Monitores: (Actual ${actividad.monitores}) </label>
                        <select name="monitor" id="monitor">

                            <c:forEach var="moni" items="${monitores}">

                                <option value="${moni.idmonitores}">${moni.nombre}</option>

                            </c:forEach>

                        </select>
                    </c:when>
                    <c:otherwise>
                        <p>NO hay monitores</p>
                    </c:otherwise>
                </c:choose>



                <p>Aforo MAX: <input type="text" id="aforo" size="30" name="aforo" value="${actividad.maxpersonas}"></p>
                <p>Día de semana: <input type="text" id="dia" size="30" name="dia" value="${actividad.dia}"></p>
                <p>Hora (HH:mm): <input type="text" id="hora" size="30" name="hora" value="${actividad.hora}"></p>
                <p>Cuota: <input type="text" id="cuota" size="30" name="cuota" value="${actividad.precio}"></p>
                <p>Deporte <input type="text" id="deporte" size="30" name="deporte" value="${actividad.deportes}" readonly></p>


                <br>

                <input type="submit" value="Guardar"/>
            </form>

            <br>
            <form action="RecuperarActividades" method="post">
                <input type="submit" value="Atrás">
            </form>
        </fieldset>




    </div>
</body>
</html>
