<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta charset="utf8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Cinemas</title>
        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/simple-sidebar.css" rel="stylesheet">
    </head>
    <body style="background-color: #E2fff0">
        <%@include file="./ext/menu.html" %>
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <!--Nombre de la empresa-->
                <%@include file="./ext/logo_nombre.html" %>
                <br><br>
                <div class="row justify-content-center" style="padding-right: 25px; margin-right: 25px">
                    <div class="col-md-12">
                        <h3 class="text-center"><strong>Ventas del dias de hoy</strong></h3></br>
                    </div>
                    <!--Tabla con información de las empresas registradas-->
                    <div class="col-md-4">
                        <table class="table table-hover border border-dark rounded" style="background-color: white;">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Peliculas</th>
                                    <th scope="col">Boletos vendidos</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Venom</td>
                                    <td class="text-center">40</td>  
                                </tr>
                                <tr>
                                    <td>Avengers</td>
                                    <td class="text-center">38</td>
                                </tr>
                                <tr>
                                    <td>La era de hielo</td>
                                    <td class="text-center">41</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>  
                <div class="row justify-content-center" style="padding-right: 25px; margin-right: 25px">            
                        <button type="submit" class="btn btn-info">Vender Tickets</button>
                        <button type="submit" class="btn btn-secondary" style="margin-left: 20px">Reportería</button>
                </div>
            </div>
            <!-- /#page-content-wrapper -->
        </div>
        <!-- /#wrapper -->

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Menu Toggle Script -->
        <script>
            $("#wrapper").toggleClass("toggled");
        </script>

    </body>

</html:html>
