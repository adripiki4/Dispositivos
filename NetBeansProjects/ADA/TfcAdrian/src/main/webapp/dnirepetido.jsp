

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionCliente, java.util.ArrayList,mx.com.gm.sga.domain.Cliente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Polideportivo-Clientes</title>
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
            <a href="">Usuarios</a>

        </div>

        <!-- CABECERA -->
    <header id="main-header">

        <a id="logo-header" href="index.html">
            <span class="site-name">Polideportivo Adrián</span>
            <span class="site-desc">Clientes-Nuevo</span>
        </a> <!-- / #logo-header -->

    </header>

    <!-- MAIN  -->
    <div class="main">
        <br>


        <c:set var="cliente" value="${requestScope.cliente}"/>
        <fieldset>
            <legend>Nuevo Cliente</legend>
            <form action="Controller?op=doAltaCliente" method="post">

                <p class="incorrecto">El DNI introducido ya se encuentra registrado</p>
                <p>Nombre: <input type="text" id="nombre" size="30" name="nombre" value="${cliente.nombre}"></p>
                <p>Apellidos: <input type="text" id="apellidos" size="30" name="apellidos" value="${cliente.apellidos}"></p>
                <p>DNI: <input type="text" id="dni" size="30" name="dni" value=""></p>
                <p>Telefono: <input type="text" id="telefono" size="30" name="telefono" value="${cliente.telefono}"></p>
                <p>Email: <input type="text" id="email" size="30" name="email" value="${cliente.email}"></p>
                <input type="submit" value="Guardar"/>
            </form>
            <br>
            <form action="RecuperarClientes">
                <input type="submit" value="Atrás"/>
            </form>


        </fieldset>

        <br>
        <br>
        <hr>



    </div>
</body>
</html>
