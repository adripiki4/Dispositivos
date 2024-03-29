
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
            <a href="Controller?op=doRecuperarInscripciones">Inscripciones</a>
            <a href="Controller?op=doRecuperarInstalaciones">Instalaciones</a>
            <a href="Controller?op=doRecuperarMonitores">Monitores</a>
            <a href="">Usuarios</a>

        </div>

        <!-- CABECERA -->
    <header id="main-header">

        <a id="logo-header" href="index.html">
            <span class="site-name">Polideportivo Adri�n</span>
            <span class="site-desc">Clientes</span>
        </a> <!-- / #logo-header -->

    </header>

    <!-- MAIN  -->
    <div class="main">
        <br>

        <fieldset>
            <legend>Filtrar</legend>
            <form action="Controller?op=doFiltrarCliente" method="post">
                <input type="text" id="dni" name="dni" placeholder="DNI">
                <input type="submit" value="Buscar">
            </form>
            <br>
            <form action="RecuperarClientes" method="post">
                <input type="submit" value="Mostrar todos">
            </form>
        </fieldset>
        
        <br>
        <form method=GET  action="newcliente.html">
            <input type="submit" value="Nuevo Cliente">
        </form>



        <br>

        <c:set var="clientes" value="${requestScope.clientes}"/>

        

        <c:choose>

            <c:when test="${!empty clientes}">

                <table>
                    <tr>
                        <th>DNI</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Tel�fono</th>
                        <th>Email</th>
                        <th>Cuota</th>
                    </tr>

                    <c:forEach var="cli" items="${clientes}">

                        <tr>
                            <td>${cli.dni}</td>
                            <td>${cli.nombre}</td>
                            <td>${cli.apellidos}</td>
                            <td>${cli.telefono}</td>
                            <td>${cli.email}</td>
                            <td>${cli.cuota} &#8364</td>
                            <td><a  class="seleccionar" href="Controller?op=doMostrarUpdate&idcliente=${cli.idcliente}">Seleccionar</a> </td>
                        </tr>

                    </c:forEach>

                </table>

            </c:when>
            <c:otherwise>
                <h1>No hay clientes</h1>
            </c:otherwise>
        </c:choose>

    </div>
</body>
</html>
