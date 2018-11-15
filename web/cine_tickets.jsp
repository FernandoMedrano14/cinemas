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
        <title>Mis entradas</title>
        <meta charset="utf-8">
    </head>
    <body>

        <div class="container altura_container" >
            <%@include file="header_cliente.html" %>
            <div class="row row_cliente">
                <div class="col-2 text-right" style="background-color: black">
                    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical" style="margin-right: -25px; padding-top: 50%">
                        <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="cine_cartelera.jsp" role="tab" aria-controls="v-pills-home" aria-selected="true">Ver Cartelera</a>
                    </div>
                </div>
                <div class="col-10 text-dark">
                    <h3 class="text-center titulo-contenido">Cartelera</h3>
                    <div class="row justify-content-center">
                        <div class="col-8">
                            <div class="col-12 text-center">
                                <div class="form-check form-check-inline">
                                    <label class="form-check-label" for="inlineRadio1">Seleccionar horario:</label>
                                </div>
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
                            </div>
                            <hr>
                            <form>
                                <div class="form-group row">
                                    <label for="inputPassword" class="col-sm-2 col-form-label">DUI:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="inputPassword" placeholder="Ingrese su numero de DUI sin guiones">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="inputPassword" class="col-sm-2 col-form-label">Nombre:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="inputPassword" placeholder="Ingrese su nombre completo">
                                    </div>
                                </div>
                            </form>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th class="text-center">Cantidad</th>
                                        <th>Valor</th>
                                        <th>Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><div class="row justify-content-center">
                                                <button class="btn btn-primary" style="width: 30px;
                                                        height: 30px;
                                                        padding: 6px 0px;
                                                        border-radius: 15px;
                                                        text-align: center;
                                                        font-size: 12px;
                                                        line-height: 1.42857;"><strong>-</strong></button>
                                                <p style="margin-right: 10px; margin-left: 10px">1</p>
                                                <button class="btn btn-primary" style="width: 30px;
                                                        height: 30px;
                                                        padding: 6px 0px;
                                                        border-radius: 15px;
                                                        text-align: center;
                                                        font-size: 12px;
                                                        line-height: 1.42857;"><strong>+</strong></button>
                                            </div>
                                            </td>
                                        <td>$0.00</td>
                                        <td>$0.00</td>
                                    </tr>
                                </tbody>
                            </table>
                            <br></br>
                            <div class="row justify-content-end"><button class="btn btn-primary">Confirmar Compra</button></div>

                        </div>

                    </div>

                </div>
                <%@include file="footer_cliente.html" %>
            </div>
        </div>
    </body>
</html:html>