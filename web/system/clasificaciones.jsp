<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <%@include file="./ext/head.html" %>
        <!-- Javascript para Controlador -->
        <script type="text/javascript" src="systemJS/clasificacionesJS.js"></script>
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
                        <h3 class="text-center"><strong>Clasificaciones de las Películas</strong></h3></br>
                    </div>
                    <!--Tabla con información de las empresas registradas-->
                    <div class="col-md-8 ">
                        <table class="table table-hover border border-dark" id="classTable" style="background-color: white">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col" class="text-center">Clasificación</th>
                                    <th scope="col">Descripción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:notEmpty name="ClasificacionesActionForm" property="listaClasificacion">
                                    <logic:iterate id="ver" name="ClasificacionesActionForm" property="listaClasificacion">
                                        <html:form action="/system/clasificaciones"> 
                                            <tr  style="cursor: pointer;" id="registro" class="infoBtn" 
                                                 data-info="${ver.idClasificacion};;${ver.tipoClasificacion};;${ver.detalleClasificacion}">
                                                <th scope="row" class="text-center"><bean:write name="ver" property="tipoClasificacion"/></th>
                                                <td><bean:write name="ver" property="detalleClasificacion" /></td>
                                            </tr>
                                        </html:form>                                    
                                    </logic:iterate>
                                </logic:notEmpty>
                            </tbody>
                        </table>
                    </div>
                    <!--Formulario para ingresar y consultar datos-->
                    <div class="col-md-4 border border-dark rounded" style="background-color: white">
                        <html:form action="/system/clasificaciones" styleId="formClass">
                            <br>
                            <div class="form-group row" hidden="true">
                                <label class="col-sm-3 col-form-label">ID:</label>
                                <div class="col-sm-9">
                                    <html:text styleId="idClasificacion" styleClass="form-control" property="idClasificacion" readonly="true"></html:text>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Clasificación:</label>
                                <div class="col-sm-9">
                                    <html:text styleId="tipoClasificacion" styleClass="form-control" property="tipoClasificacion" maxlength="20"></html:text>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Descripción:</label>
                                <div class="col-sm-9">
                                    <html:textarea styleId="detalleClasificacion" styleClass="form-control" property="detalleClasificacion" style="width: 100%; min-height:250px; max-height: 250px; maxlength: 150"></html:textarea>
                                </div>
                            </div>
                            <div class="text-center">
                                </br>
                                <!--botones para realizar acciones del formulario-->
                                <html:submit styleId="nueva" styleClass="btn btn-info" property="action" value="Nueva"></html:submit>
                                <html:submit styleId="modificar" styleClass="btn btn-secondary" property="action" value="Modificar"></html:submit>
                                <button type="submit" class="btn btn-danger" id="btnEliminar">Eliminar</button><br></br>
                            </div>
                        </html:form>  
                    </div>
                </div>
                
                <div class="modal" tabindex="-1" role="dialog" id="deleteModal">
                    <form action="cliente" method="post">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Eliminar</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <input type="hidden" class="form-control" id="keyDelete">
                                    <p>¿Está seguro que desea eliminar este Registro?</p>
                                </div>
                                <div class="modal-footer">
                                    <submit id="eliminar" class="btn btn-danger">Confirmar</submit>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                </div>
                            </div>
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
        
        $("#classTable").on("dblclick", ".infoBtn", function () {
            var data = $(this).data("info").split(";;");
            $("#idClasificacion").val(data[0]);
            $("#tipoClasificacion").val(data[1]);
            $("#detalleClasificacion").val(data[2]);

            $("#tipoClasificacion").removeClass("is-invalid");
            $("#detalleClasificacion").removeClass("is-invalid");
        });
    </script>

</body>

</html:html>
