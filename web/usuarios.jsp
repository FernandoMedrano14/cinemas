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
        <%@include file="menu.html" %>
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <!--Nombre de la empresa-->
                <%@include file="logo_nombre.html" %>
                <br><br>
                <div class="row justify-content-center" style="padding-right: 25px; margin-right: 25px">
                    <div class="col-md-12">
                        <h3 class="text-center"><strong>Usuarios</strong></h3></br>
                    </div>
                    <!--Tabla con información de las empresas registradas-->
                    <div class="col-md-8 ">
                        <table class="table table-hover border border-dark" style="background-color: white">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Nombres</th>
                                    <th scope="col">Correo</th>
                                    <th scope="col">Username</th>
                                    <th scope="col">Tipo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td scope="row">Nombre 1</td>
                                    <td>Correo 1</td>
                                    <td>Username 1</td>
                                    <td>Administrador</td>
                                </tr>
                                <tr>
                                    <td scope="row">Nombre 2</td>
                                    <td>Correo 2</td>
                                    <td>Username 2</td>
                                    <td>Cajero</td>
                                </tr>
                                <tr>
                                    <td scope="row">Nombre 3</td>
                                    <td>Correo 3</td>
                                    <td>Username 1</td>
                                    <td>Cajero</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <!--Formulario para ingresar y consultar datos-->
                    <div class="col-md-4 border border-dark rounded" style="background-color: white">
                        <form>
                            <br>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Nombres:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Ingrese nombre del usuario">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Apellidos:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Ingrese apellido del usuario">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Usuario:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Ingrese nombre de usuario">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Correo:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Ingrese correo del usuario">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Contraseña:</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" placeholder="Ingrese contraseña del usuario">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Tipo de Usuario:</label>
                                <div class="col-sm-8">
                                    <select class="form-control">
                                        <option value="">Administrador</option>
                                        <option value="">Cajero</option>
                                        <option value="">Mantenimiento</option>
                                    </select>
                                </div>
                            </div>
                            <div class="text-center">
                                </br>
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
