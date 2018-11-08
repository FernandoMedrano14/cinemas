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
    <%@include file="menu.html" %>
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <!--Nombre de la empresa-->
                <%@include file="logo_nombre.html" %>
                <br><br>
                <div class="row" style="padding-right: 25px; margin-right: 25px">
                  <div class="col-md-12">
                    <h3 class="text-center"><strong>Empresas</strong></h3></br>
                  </div>
                  <!--Tabla con información de las empresas registradas-->
                  <div class="col-md-8 ">
                        <table class="table table-hover border border-dark" style="background-color: white">
                            <thead class="thead-dark">
                              <tr>
                                <th scope="col">Nombre</th>
                                <th scope="col">Dirección</th>
                                <th scope="col">Telefono</th>
                                <th scope="col">NIT</th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <th scope="row">empresa 1</th>
                                <td>direccion 1</td>
                                <td>telefono 1</td>
                                <td>nit-1</td>
                              </tr>
                              <tr>
                                <th scope="row">empresa 2</th>
                                <td>direccion 2</td>
                                <td>telefono 2</td>
                                <td>nit-2</td>
                              </tr>
                            </tbody>
                        </table>
                  </div>
                  <!--Formulario para ingresar y consultar datos-->
                  <div class="col-md-4 border border-dark rounded" style="background-color: white">
                    <form>
                      </br>
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Nombre:</label>
                          <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="Ingrese nombre de la empresa">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Dirección:</label>
                          <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="Ingrese el domicilio de la empresa">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Telefono:</label>
                          <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="Ingrese telefono de la empresa">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">NIT:</label>
                          <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="Ingrese el NIT de la empresa">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Registro:</label>
                          <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="Ingrese registro de la empresa">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Giro:</label>
                          <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="Ingrese el giro">
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
