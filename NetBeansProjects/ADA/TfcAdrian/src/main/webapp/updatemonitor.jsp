
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
            <span class="site-desc">Monitores-Editar</span>
        </a> <!-- / #logo-header -->

    </header>

    <!-- MAIN  -->
    <div class="main">


        <br>
        <br>

        <c:set var="monitor" value="${requestScope.monitor}"/>

        <fieldset>
            <legend>Editar Monitor</legend>
            <form action="Controller?op=doUpdateMonitor&idmonitores=${monitor.idmonitores}" method="post">

<!--                    <p>ID: <input type="text" id="idmonitores" size="30" name="idmonitores" value="${monitor.idmonitores}" readonly> </p>-->
                <p>Nombre: <input type="text" id="nombre" size="30" name="nombre" value="${monitor.nombre}"></p>
                <p>Apellidos: <input type="text" id="apellidos" size="30" name="apellidos" value="${monitor.apellidos}"></p>
                <p>Telefono: <input type="text" id="telefono" size="30" name="telefono" value="${monitor.telefono}"></p>
                <p>Email: <input type="text" id="email" size="30" name="email" value="${monitor.email}"></p>
                <input type="submit" value="Actualizar"/>
            </form>
            <br>
            <form action="RecuperarMonitores">
                <input type="submit" value="Atrás">
            </form>
        </fieldset>

    </body>
</html>
