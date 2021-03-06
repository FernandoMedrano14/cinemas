<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:html lang="true">
    <head>
        <link href="https://fonts.googleapis.com/css?family=Anton|Lobster" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style_cliente.css"/>
        <title>Cartelera</title>
        <meta charset="utf-8">
    </head>
    <body>

        <div class="container altura_container">
            <%@include file="header_cliente.html" %>
            <div class="row row_cliente">

                <div class="col-2 text-right div-izquierdo">
                    <div class="nav flex-column nav-pills menu-izquierdo" id="v-pills-tab" role="tablist" aria-orientation="vertical" style="margin-right: -25px; padding-top: 50%">
                        <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="cine_cartelera.jsp" role="tab" aria-controls="v-pills-home" aria-selected="true">Ver Cartelera</a>
                    </div>
                </div>
                <div class="col-10 text-dark">
                    <h3 class="text-center titulo-contenido" >Cartelera</h3>
                    <form class="form-inline justify-content-center">
                        <div class="form-group mb-2">
                            <label>Seleccionar Sucursal:</label>
                        </div>
                        <div class="form-group mx-sm-3 mb-2">
                            <select class="form-control" style="width: 300px" >
                                <option>Sucursal 1</option>
                                <option>Sucursal 2</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary mb-2">Ver Cartelera</button>
                    </form>
                    <hr>
                    <div class="row justify-content-center">
                        <div class="col-8">
                            <table>
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="text-justify" style="width: 60%"><strong>Pelicula 1</strong></br></br>
                                            <a href="cine_sinopsis.jsp">Ver Sinopsis</a><br><br>
                                            <p>Horarios:</p>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                                                <label class="form-check-label" for="inlineRadio1">11:00am</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                                                <label class="form-check-label" for="inlineRadio2">01:00pm</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3">
                                                <label class="form-check-label" for="inlineRadio3">03:00pm</label>
                                            </div>
                                        </td>
                                        <td class="text-center"><img src="img/correlab.jpg" style="width: 50%">
                                            <button class="btn btn-primary btn-sm">Comprar Tickets</button></td>
                                    </tr>
                                    <tr>
                                        <td class="text-justify" style="width: 60%; padding-top: 8%"><strong>Pelicula 2</strong></br></br>
                                            <a href="cine_sinopsis.jsp">Ver Sinopsis</a><br><br>
                                            <p>Horarios:</p>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                                                <label class="form-check-label" for="inlineRadio1">11:00am</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                                                <label class="form-check-label" for="inlineRadio2">01:00pm</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3">
                                                <label class="form-check-label" for="inlineRadio3">03:00pm</label>
                                            </div>
                                        </td>
                                        <td class="text-center"><img src="img/karlm.jpg" style="width: 50%">
                                            <button class="btn btn-primary btn-sm">Comprar Tickets</button>
                                        </td>
                                    </tr>

                                </tbody>
                            </table><br>

                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-end">
                                    <li class="page-item disabled">
                                        <a class="page-link" href="#" tabindex="-1">Anterior</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item">
                                        <a class="page-link" href="#">Siguiente</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>

                    </div>

                </div>
                <%@include file="footer_cliente.html" %>
            </div>
        </div>
    </body>
</html:html>