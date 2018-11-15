<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:html lang="true">
    <head>
        <link href="https://fonts.googleapis.com/css?family=Anton|Lobster" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style_cliente.css"/>
        <title>Bienvenido!</title>
        <meta charset="utf-8">
    </head>
    <body>

        <div class="container altura_container">
            <%@include file="header_cliente.html" %>
            <div class="row row_cliente">

                <div class="col-2 text-right" style="background-color: black">
                    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical" style="margin-right: -25px; padding-top: 50%">
                        <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="cine_cartelera.html" role="tab" aria-controls="v-pills-home" aria-selected="true">Ver Cartelera</a>
                    </div>
                </div>
                <div class="col-10 text-dark">

                    <div class="row justify-content-center">
                        <div class="col-8" style="padding-top:10%">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th style="width: 25%"><img src="img/karlm.jpg" style="width: 75%"></th>
                                        <th class="align-top"><h3 class="titulo-contenido">Titulo de la pelicula seleccionada</h3>  <br>
                                            Actores: Lorem ipsum, dolor sit, adipisicing elit.<br>
                                            Directores: Lorem ipsum, dolor sit, adipisicing elit <br>
                                            <div class=""><br><a class="btn btn-primary btn-sm justify-content-end" href="cine_tickets.jsp">Comprar Tickets</a></div>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="text-justify" colspan="2"><strong>Sinopsis:</strong> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                                            quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                                            consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                                            cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                                            proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</th>
                                    </tr>
                                </tbody>
                            </table>
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-end">
                                    <li class="page-item disabled">
                                        <a class="page-link" href="#" tabindex="-1">Anterior</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item">
                                        <a class="page-link" href="#">Siguiente</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>

                    </div>

                </div>
                <div class="fixed-bottom text-center text-white">
                    <small>Todos los derechos Reservados Â©</br> 
                        CÃ­nemas El Salvador - 2018
                    </small>

                </div>
            </div>
        </div>
    </body>
</html:html>