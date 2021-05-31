

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionCliente, java.util.ArrayList,mx.com.gm.sga.domain.Cliente, 
         modelo.GestionActividad, java.util.ArrayList,mx.com.gm.sga.domain.Actividad"%>
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
            <a href="">Usuarios</a>

        </div>

        <!-- CABECERA -->
    <header id="main-header">

        <a id="logo-header" href="index.html">
            <span class="site-name">Polideportivo Adri�n</span>
            <span class="site-desc">Nueva Inscripcion</span>
        </a> <!-- / #logo-header -->

    </header>

    <div class="main">
        <br>

        <c:set var="actividad" value="${requestScope.actividad}"/>
        <c:set var="cliente" value="${requestScope.cliente}"/>

        <fieldset>
            <legend>Confirmar Inscripcion</legend>
            <form action="Controller?op=doAltaInscripcion&idactividad=${actividad.idactividad}&idcliente=${cliente.idcliente}&precio=${actividad.precio}" method="post">

                <p><b>Actividad:</b> ${actividad.nombre}</p>
                <p><b>Precio: </b> ${actividad.precio}</p>
                <p><b>Dia de la semana: </b> ${actividad.dia}</p>
                <p><b>Hora: </b>  ${actividad.hora}</p>
                <p><b>Instalacion: </b> ${actividad.instalacion}</p>
                <hr>
                <p><b>Nombre : </b> ${cliente.nombre}</p>
                <p><b>Apellidos : </b> ${cliente.apellidos}</p>
                <p><b>DNI : </b> ${cliente.dni}</p>

                <input type="submit" value="Confirmar"/>
                <br>
            </form>
            <br>
            <form action="RecuperarInscripciones" method="post">
                <input type="submit" value="Cancelar">
            </form>
        </fieldset>


    </div>
</body>
</html>
