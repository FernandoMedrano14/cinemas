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
        <script type="text/javascript" src="systemJS/peliculasJS.js"></script>
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
                        <h3 class="text-center"><strong>Películas</strong></h3></br>
                    </div>
                    <!--Tabla con información de las empresas registradas-->
                    <div class="col-md-8 ">
                        <table class="table table-hover border border-dark" style="background-color: white">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Título</th>
                                    <th scope="col">Duración</th>
                                    <th scope="col">Actores</th>
                                    <th scope="col">Directores</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">Título 1</th>
                                    <td>120 min</td>
                                    <td>Actor 1</td>
                                    <td>Director 1</td>
                                </tr>
                                <tr>
                                    <th scope="row">Título 2</th>
                                    <td>125 min</td>
                                    <td>Actor 2</td>
                                    <td>Director 2</td>
                                </tr>
                                <tr>
                                    <th scope="row">Título 3</th>
                                    <td>155 min</td>
                                    <td>Actor 3</td>
                                    <td>Director 3</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <!--Formulario para ingresar y consultar datos-->
                    <div class="col-md-4 border border-dark rounded" style="background-color: white">
                        <form>
                            </br>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Empresa:</label>
                                <div class="col-sm-9">
                                    <select class="form-control">
                                        <option value="">Empresa 1</option>
                                        <option value="">Empresa 2</option>
                                        <option value="">Empresa 3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Género:</label>
                                <div class="col-sm-9">
                                    <select class="form-control">
                                        <option value="">Comedia</option>
                                        <option value="">Acción</option>
                                        <option value="">Drama</option>
                                        <option value="">Suspenso</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Título:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Ingrese título de la película" maxlength="150">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Duración:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control duracion" placeholder="Ingrese duración de la película">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Actores:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Ingrese actores de la película" maxlength="150">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Sinópsis:</label>
                                <div class="col-sm-9">
                                    <textarea class="form-control" style="width: 100%; min-height:150px; max-height: 150px" maxlength="500"></textarea>
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
