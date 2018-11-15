<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta charset="utf-8">
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
                <div class="row" style="padding-right: 25px; margin-right: 25px">
                    <div class="col-md-12">
                        <h3 class="text-center"><strong>Horarios por sala</strong></h3></br>
                    </div>

                    <!--Tabla con información de las empresas registradas-->
                    <div class="col-md-8 ">
                        <form>
                            <div class="form-group row">
                                <label class="col-sm-5 col-form-label"><strong>Seleccionar sucursal:</strong></label>
                                <div class="col-sm-7">
                                    <select class="form-control" name="select">
                                        <option>Sucursal 1</option>
                                        <option>Sucursal 2</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-5 col-form-label"><strong>Seleccionar sala:</strong></label>
                                <div class="col-sm-7">
                                    <select class="form-control" name="select">
                                        <option>Sala 1</option>
                                        <option>Sala 2</option>
                                        <option>Sala 3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="text-right">
                                <button type="submit" class="btn btn-info">Ver horarios</button>
                            </div>  
                        </form>
                        <table class="table table-hover border border-dark" style="background-color: white">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Sucursal</th>
                                    <th scope="col">Numero de sala</th>
                                    <th scope="col">Horario</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">Sucursal 1</th>
                                    <td>Sala 1</td>
                                    <td>01:00pm - 03:00pm</td>

                                </tr>
                                <tr>
                                    <th scope="row">Sucursal 1</th>
                                    <td>Sala 2</td>
                                    <td>11:00am - 02:30pm</td>

                                </tr>
                                <tr>
                                    <th scope="row">Sucursal 1</th>
                                    <td>Sala 3</td>
                                    <td>03:30pm - 05:00pm</td>

                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <!--Formulario para ingresar y consultar datos-->
                    <div class="col-md-4 border border-dark rounded" style="background-color: white">
                        <form>
                            </br>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Sucursal:</label>
                                <div class="col-sm-9">
                                    <select class="form-control" name="select">
                                        <option>Sucursal 1</option>
                                        <option>Sucursal 2</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Sala:</label>
                                <div class="col-sm-9">
                                    <select class="form-control" name="select">
                                        <option>Sala 1</option>
                                        <option>Sala 2</option>
                                        <option>Sala 3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Horario desde:</label>
                                <div class="col-sm-7">
                                    <select class="custom-select" size="1">
                                        <option selected>Selecciona una hora</option>
                                        <option value="11">11:00am</option>
                                        <option value="12">12:00m</option>
                                        <option value="13">01:00pm</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Horario hasta:</label>
                                <div class="col-sm-7">
                                    <select class="custom-select" size="1">
                                        <option selected>Selecciona una hora</option>
                                        <option value="11">11:00am</option>
                                        <option value="12">12:00m</option>
                                        <option value="13">01:00pm</option>
                                    </select>
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
