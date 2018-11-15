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
                        <h3 class="text-center"><strong>Venta de Tickets</strong></h3></br>
                    </div>
                    <!--Tabla con información de las empresas registradas-->
                    <div class="col-md-8 ">
                        <table class="table table-hover border border-dark" style="background-color: white">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Películas</th>
                                    <th scope="col">Salas</th>
                                    <th scope="col">Horarios</th>
                                    <th scope="col">Cant.</th>
                                    <th scope="col">Total</th>
                                    <th scope="col">Estado</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">Película 1</th>
                                    <td>Sala 1</td>
                                    <td>1:00pm - 3:15pm</td>
                                    <td>2</td>
                                    <td>$ 7.00</td>
                                    <td>Pendiente</td>
                                </tr>
                                <tr>
                                    <th scope="row">Película 2</th>
                                    <td>Sala 1</td>
                                    <td>3:30pm - 6:25pm</td>
                                    <td>5</td>
                                    <td>$ 12.50</td>
                                    <td>Pendiente</td>
                                </tr>
                                <tr>
                                    <th scope="row">Película 3</th>
                                    <td>Sala 5</td>
                                    <td>10:00am - 12:15pm</td>
                                    <td>1</td>
                                    <td>$ 2.50</td>
                                    <td>Pendiente</td>
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
                                    <select class="form-control">
                                        <option value="">Sucursal 1</option>
                                        <option value="">Sucursal 2</option>
                                        <option value="">Sucursal 3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Sala:</label>
                                <div class="col-sm-9">
                                    <select class="form-control">
                                        <option value="">Sala 1</option>
                                        <option value="">Sala 2</option>
                                        <option value="">Sala 3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Película:</label>
                                <div class="col-sm-9">
                                    <select class="form-control">
                                        <option value="">Película 1</option>
                                        <option value="">Película 2</option>
                                        <option value="">Película 3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Horario:</label>
                                <div class="col-sm-9">
                                    <select class="form-control">
                                        <option value="">10:00am - 12:15pm</option>
                                        <option value="">11:30am - 1:25pm</option>
                                        <option value="">12:00pm - 3:40pm</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Precio:</label>
                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <span class="input-group-append input-group-addon">
                                            <span class="input-group-text" style="font-size: 15px;"><b>$</b></span>
                                        </span>
                                        <input type="text" class="form-control" placeholder="Precio por Entrada" disabled="false">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Nombre:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Ingrese nombre del cliente">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">DUI:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Ingrese DUI del cliente">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Cantidad:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Ingrese cantidad de tickets">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Total:</label>
                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <span class="input-group-append input-group-addon">
                                            <span class="input-group-text" style="font-size: 15px;"><b>$</b></span>
                                        </span>
                                        <input type="text" class="form-control" placeholder="Precio Total" disabled="false">
                                    </div>
                                </div>
                            </div>
                            <div class="text-center">
                                <!--botones para realizar acciones del formulario-->
                                <button type="submit" class="btn btn-info">Nuevo</button>
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
