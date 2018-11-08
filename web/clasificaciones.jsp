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
                    <h3 class="text-center"><strong>Clasificaciones de las peliculas</strong></h3></br>
                  </div>
                  <!--Tabla con información de las empresas registradas-->
                  <div class="col-md-8 ">
                        <table class="table table-hover border border-dark" style="background-color: white">
                            <thead class="thead-dark">
                              <tr>
                                <th scope="col">Clasificación</th>
                                <th scope="col">Descripción</th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <th scope="row">Clasificación A</th>
                                <td>Descripción de la clasificación A</td>
                              </tr>
                              <tr>
                                <th scope="row">Clasificación B</th>
                                <td>Descripción de la clasificación B</td>
                              </tr>
                            </tbody>
                        </table>
                  </div>
                  <!--Formulario para ingresar y consultar datos-->
                  <div class="col-md-4 border border-dark rounded" style="background-color: white">
                    <form>
                      </br>
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Clasificación:</label>
                          <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="Ingrese nombre de la clasificación">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Descripción:</label>
                          <div class="col-sm-9">
                              <textarea class="form-control" style="width: 100%; min-height:250px; max-height: 250px"></textarea>
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
