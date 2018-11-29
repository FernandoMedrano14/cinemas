$(document).ready(function () {

    $("#nueva").click(function (e) {
        e.preventDefault();

        var idFuncion = $("#idFuncion").val();
        var horarios = $("#horarios").val();
        var peliculas = $("#peliculas").val();
        var precios = $("#precios").val();
        var estado = $("#estado").val();

        if (idClasificacion != "") {
            $("#idFunciones").val("");
            $("#horarios").val("");
            $("#peliculas").val("");
            $("#precios").val("");
            $("#estado").val("");

        } else {
            var isValid = true;

            if (horarios == "") {
                $("#horarios").addClass("is-invalid");
                isValid = false;
            } else {
                $("#horarios").removeClass("is-invalid");
            }

            if (peliculas == "") {
                $("#peliculas").addClass("is-invalid");
                isValid = false;
            } else {
                $("#peliculas").removeClass("is-invalid");
            }
            if (precios == "") {
                $("#precios").addClass("is-invalid");
                isValid = false;
            } else {
                $("#precios").removeClass("is-invalid");
            }
            if (estado == "") {
                $("#estado").addClass("is-invalid");
                isValid = false;
            } else {
                $("#estado").removeClass("is-invalid");
            }
            if (isValid) {
                location.href = "precios.do?action=Nueva&horarios=" + horarios + "&peliculas=" + peliculas + "&precios=" + precios + "&estado=" + estado;
            }

        }
    });

    $("#modificar").click(function (e) {
        e.preventDefault();

        var idFuncion = $("#idFuncion").val();
        var horarios = $("#horarios").val();
        var peliculas = $("#peliculas").val();
        var precios = $("#precios").val();
        var estado = $("#estado").val();

        if (idFuncion == "") {
            $("#error").html("No se puede modificar un Registro que no exista");
            error();
        } else {
            var isValid = true;

            if (horarios == "") {
                $("#horarios").addClass("is-invalid");
                isValid = false;
            } else {
                $("#horarios").removeClass("is-invalid");
            }

            if (peliculas == "") {
                $("#peliculas").addClass("is-invalid");
                isValid = false;
            } else {
                $("#peliculas").removeClass("is-invalid");
            }
            if (precios == "") {
                $("#precios").addClass("is-invalid");
                isValid = false;
            } else {
                $("#precios").removeClass("is-invalid");
            }
            if (estado == "") {
                $("#estado").addClass("is-invalid");
                isValid = false;
            } else {
                $("#estado").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "funciones.do?action=Modificar&idFuncion=" + idFuncion + "&horarios=" + horarios + "&peliculas=" + peliculas + "&precios=" + precios + "&estado=" + estado;
            }

        }
    });

    $("#eliminar").click(function (e) {
        e.preventDefault();

        var idFuncion = $("#idFuncion").val();
        var horarios = $("#horarios").val();
        var peliculas = $("#peliculas").val();
        var precios = $("#precios").val();
        var estado = $("#estado").val();

        if (idFuncion == "") {
            $("#error").html("No se puede eliminar un registro que no exista");
            error();
        } else {
            var isValid = true;

            if (horarios == "") {
                $("#horarios").addClass("is-invalid");
                isValid = false;
            } else {
                $("#horarios").removeClass("is-invalid");
            }

            if (peliculas == "") {
                $("#peliculas").addClass("is-invalid");
                isValid = false;
            } else {
                $("#peliculas").removeClass("is-invalid");
            }
            if (precios == "") {
                $("#precios").addClass("is-invalid");
                isValid = false;
            } else {
                $("#precios").removeClass("is-invalid");
            }
            if (estado == "") {
                $("#estado").addClass("is-invalid");
                isValid = false;
            } else {
                $("#estado").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "funciones.do?action=Eliminar&idFuncion=" + idFuncion;
            }

        }
    });

    toastr.options = {
        "debug": false,
        "positionClass": "toast-bottom-right",
        "onclick": null,
        "fadeIn": 300,
        "fadeOut": 100,
        "timeOut": 7000,
        "extendedTimeOut": 1000
    }

    var showToastrs = false;

    function error() {
        if (!showToastrs) {
            toastr.error($("#error").text(), 'Error!');
        }
    }

    function mensaje() {
        if (!showToastrs) {
            toastr.success($("#mensaje").text(), 'Éxito!');
        }
    }
    function info() {
        if (!showToastrs) {
            toastr.info($("#info").text(), 'Info!');
        }
    }
    function warning() {
        if (!showToastrs) {
            toastr.warning($("#warning").text(), 'Aviso!');
        }
    }

    if ($("#error").text() != "") {
        error();
    }
    if ($("#mensaje").text() != "") {
        mensaje();
    }
    if ($("#info").text() != "") {
        info();
    }
    if ($("#warning").text() != "") {
        warning();
    }

});
