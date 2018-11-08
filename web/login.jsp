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
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <!--Nombre de la empresa-->

                <br><br>
                <div class="row justify-content-center" >
                    <div class="col-md-8 border border-dark rounded" style="background-color: white">
                        <h3 class="text-center"><strong>Bienvenido a Cinemas</strong></h3></br>

                        <form action="action">
                            <div class="form-group justify-content-center">
                                <div class="text-center">
                                    <label><strong>Usuario</strong></label>
                                </div>
                                <div class="col-6" style="margin-left: 25%">
                                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                                </div>
                                <br></br>
                                <div class="form-group">
                                    <div class="text-center">
                                        <label><strong>Contraseña</strong></label><div class="col-6 text-center">
                                        </div>
                                        <div class="col-6" style="margin-left: 25%">
                                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                        </div>
                                    </div>
                                </div>

                                <div class="text-center">
                                    <a type="submit" href="index.jsp" class="btn btn-primary">Ingresar</a>
                                </div>

                        </form>
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
