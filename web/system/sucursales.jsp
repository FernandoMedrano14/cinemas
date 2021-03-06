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
        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Javascript para máscaras -->
        <script type="text/javascript" src="vendor/jquery/jquery.mask.min.js"></script>
        <script type="text/javascript" src="documentController.js"></script>
        <script type="text/javascript" src="systemJS/sucursalesJS.js"></script>
        <!-- Javascript para Alerts -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.1/css/toastr.css" rel="stylesheet"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.1/js/toastr.js"></script>
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
                        <h3 class="text-center"><strong>Sucursales</strong></h3></br>
                    </div>
                    <!--Tabla con información de las empresas registradas-->
                    <div class="col-md-8 ">
                        <table class="table table-hover border border-dark" style="background-color: white">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Sucursales</th>
                                    <th scope="col">Dirección</th>
                                    <th scope="col">Teléfono</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">Sucursal 1</th>
                                    <td>Dirección 1</td>
                                    <td>0000 - 0000</td>
                                </tr>
                                <tr>
                                    <th scope="row">Sucursal 2</th>
                                    <td>Dirección 2</td>
                                    <td>0000 - 0000</td>
                                </tr>
                                <tr>
                                    <th scope="row">Sucursal 3</th>
                                    <td>Dirección 3</td>
                                    <td>0000 - 0000</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <!--Formulario para ingresar y consultar datos-->
                    <div class="col-md-4 border border-dark rounded" style="background-color: white">
                        <form>
                            <br>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Sucursal:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Ingrese nombre de la sucursal" maxlength="100">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Dirección:</label>
                                <div class="col-sm-9">
                                    <textarea class="form-control" style="width: 100%; min-height:100px; max-height: 100px" maxlength="100"></textarea>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Teléfono:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control phone" placeholder="Ingrese número telefónico">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Longitud:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Ingrese longitud">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Latitud:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Ingrese latitud">
                                </div>
                            </div>
                            <div class="text-center">
                                </br>
                                <!--botones para realizar acciones del formulario-->
                                <button type="submit" class="btn btn-info">Nueva</button>
                                <button type="submit" class="btn btn-secondary">Modificar</button>
                                <button type="submit" class="btn btn-danger">Eliminar</button><br></br>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- /#page-content-wrapper -->
        </div>
        <!-- /#wrapper -->

        <!-- Menu Toggle Script -->
        <script>
            $("#wrapper").toggleClass("toggled");
        </script>

    </body>

</html:html>
