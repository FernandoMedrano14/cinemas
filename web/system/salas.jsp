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
                        <h3 class="text-center"><strong>Salas de Cine</strong></h3></br>
                    </div>
                    <!--Tabla con información de las empresas registradas-->
                    <div class="col-md-8">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Seleccionar Sucursal:</label>
                                    <div class="col-sm-7">
                                        <select class="form-control">
                                            <option value="">Sucursal 1</option>
                                            <option value="">Sucursal 2</option>
                                            <option value="">Sucursal 3</option>
                                        </select>
                                    </div>
                                    <div class="col-sm-2 text-right">
                                        <button type="submit" class="btn btn-info">Buscar</button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <table class="table table-hover border border-dark" style="background-color: white">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">Sucursal</th>
                                            <th scope="col">N° de Sala</th>
                                            <th scope="col">Tipo</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">Sucursal 1</th>
                                            <td>Sala 5</td>
                                            <td>2D</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Sucursal 1</th>
                                            <td>Sala 3</td>
                                            <td>3D</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Sucursal 1</th>
                                            <td>Sala 2</td>
                                            <td>2D</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--Formulario para ingresar y consultar datos-->
                    <div class="col-md-4 border border-dark rounded" style="background-color: white">
                        <form>
                            </br>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Sucursal:</label>
                                <div class="col-sm-8">
                                    <select class="form-control">
                                        <option value="">Sucursal 1</option>
                                        <option value="">Sucursal 2</option>
                                        <option value="">Sucursal 3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">N° de Sala:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" placeholder="Ingrese el n° de la sala">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Tipo de Sala:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" placeholder="Ingrese tipo de sala">
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

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Menu Toggle Script -->
        <script>

            $("#wrapper").toggleClass("toggled");

        </script>

    </body>

</html:html>
