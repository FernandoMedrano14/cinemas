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
        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Javascript para máscaras -->
        <script type="text/javascript" src="vendor/jquery/jquery.mask.min.js"></script>
        <script type="text/javascript" src="documentController.js"></script>
        <script type="text/javascript" src="systemJS/generosJS.js"></script>
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
                <div class="row" style="padding-right: 25px; margin-right: 25px">
                    <div class="col-md-12">
                        <h3 class="text-center"><strong>Generos de peliculas</strong></h3></br>
                    </div>
                    <!--Tabla con información de las empresas registradas-->
                    <div class="col-md-8 ">
                        <table class="table table-hover border border-dark" id="generosTable" style="background-color: white">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Nombre del genero</th>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:notEmpty name="GenerosActionForm" property="listaGeneros">
                                    <logic:iterate id="ver" name="GenerosActionForm" property="listaGeneros">
                                        <html:form action="/system/genero">
                                            <tr style="cursor: pointer;" id="registro" class="infoBtn" 
                                                data-info="${ver.idGenero};;${ver.genero}">
                                                <td><bean:write name="ver" property="genero"/></td>
                                            </tr>
                                        </html:form>
                                    </logic:iterate>
                                </logic:notEmpty>

                            </tbody>
                        </table>
                    </div>
                    <!--Formulario para ingresar y consultar datos-->
                    <div class="col-md-4 border border-dark rounded" style="background-color: white">
                        <html:form action="/system/genero">
                            </br>
                            <div class="form-group row" hidden="true">
                                <label class="col-sm-3 col-form-label">ID:</label>
                                <div class="col-sm-9">
                                    <html:text styleId="idGenero" styleClass="form-control" property="idGenero" readonly="true"></html:text>
                                    </div>
                                </div>
                                <div class="form-group row" style="margin-top: 20%">
                                    <label class="col-sm-3 col-form-label">Genero:</label>
                                    <div class="col-sm-9">
                                    <html:text styleId="genero" styleClass="form-control" property="genero"></html:text>
                                    </div>
                                </div>
                                <div class="text-center" style="margin-top: 20%">
                                    </br>
                                    <!--botones para realizar acciones del formulario-->
                                <html:submit styleClass="btn btn-info" property="action" value="Nueva"></html:submit>
                                <html:submit styleClass="btn btn-secondary" property="action" value="Modificar"></html:submit>
                                <html:submit styleClass="btn btn-danger" property="action" value="Eliminar"></html:submit>
                                </div>
                        </html:form>
                    </div>
                </div>        
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
    <!-- /#wrapper -->

    <!-- Menu Toggle Script -->
    <script>
        $("#wrapper").toggleClass("toggled");

        $("#generosTable").on("dblclick", ".infoBtn", function () {
            var data = $(this).data("info").split(";;");
            $("#idGenero").val(data[0]);
            $("#genero").val(data[1]);
        });
    </script>

</body>

</html:html>
