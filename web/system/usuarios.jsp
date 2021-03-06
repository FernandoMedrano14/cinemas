<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
   <head>
        <%@include file="./ext/head.html" %>
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
                                <logic:notEmpty name="UsuariosActionForm" property="listaUsuario">
                                    <logic:iterate id="ver" name="UsuariosActionForm" property="listaUsuario">
                                        <html:form action="/system/usuarios"> 
                                            <tr  style="cursor: pointer;" id="registro" class="infoBtn" 
                                                 data-info="${ver.idUsuario};;${ver.tiposUsuarios.tipo};;${ver.empresas.nombre};;${ver.nickname};;${ver.nombres};;${ver.apellidos};;${ver.correo};;${ver.contrasenia}">
                                                <th scope="row"><bean:write name="ver" property="nombres"/></th>
                                                <td><bean:write name="ver" property="correo" /></td>
                                                <td><bean:write name="ver" property="nickname" /></td>
                                                <td><bean:write name="ver" property="tiposUsuarios.tipo" /></td>
                                            </tr>
                                        </html:form>                               
                                    </logic:iterate>
                                </logic:notEmpty>                                
                            </tbody>
                        </table>
                    </div>
                    <!--Formulario para ingresar y consultar datos-->
                    <div class="col-md-4 border border-dark rounded" style="background-color: white">
                        <html:form action="/system/usuarios">
                            <br>
                            <div class="form-group row">
                                <div class="col-sm-9">
                                    <html:text styleId="" styleClass="form-control" property="idUsuario" readonly="true" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Nombres:</label>
                                <div class="col-sm-9">
                                    <html:text styleId="" styleClass="form-control" property="nombres" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Apellidos:</label>
                                <div class="col-sm-9">
                                    <html:text styleId="" styleClass="form-control" property="apellidos"/>                                    
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Usuario:</label>
                                <div class="col-sm-9">
                                    <html:text styleId="" styleClass="form-control" property="nickname"/>                                    
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Correo:</label>
                                <div class="col-sm-9">
                                    <html:text styleId="" styleClass="form-control" property="correo"/>                                    
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Contraseña:</label>
                                <div class="col-sm-9">
                                    <html:password styleId="" styleClass="form-control" property="contrasenia" redisplay="false" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Tipo de Usuario:</label>
                                <div class="col-sm-9">
                                    <html:select property="idTipoUsuario" styleId="" styleClass="form-control">
                                        <html:optionsCollection name="UsuariosActionForm" property="listaTiposUsuarios" label="tipo" value="idTipoUsuario" />
                                    </html:select>                                    
                                </div>
                            </div>
                                <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Empresa:</label>
                                <div class="col-sm-9">
                                    <html:select property="idEmpresa" styleId="" styleClass="form-control">
                                        <html:optionsCollection name="UsuariosActionForm" property="listaEmpresas" label="nombre" value="idEmpresa" />
                                    </html:select>                                    
                                </div>
                            </div>
                            <div class="text-center">
                                </br>
                                <!--botones para realizar acciones del formulario-->
                                <html:submit property="action" value="guardar" />
                                <button type="submit" class="btn btn-info">Nuevo</button>
                                <button type="submit" class="btn btn-secondary">Modificar</button>
                                <button type="submit" class="btn btn-danger">Eliminar</button><br></br>
                            </div>
                        </html:form>
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
