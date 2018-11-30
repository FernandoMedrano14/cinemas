$(document).ready(function () {

    $("#nueva").click(function (e) {
        e.preventDefault();

        var idClasificacion = $("#idClasificacion").val();
        var tipoClasificacion = $("#tipoClasificacion").val();
        var detalleClasificacion = $("#detalleClasificacion").val();

        if (idClasificacion != "") {
            $("#idClasificacion").val("");
            $("#tipoClasificacion").val("");
            $("#detalleClasificacion").val("");

        } else {
            var isValid = true;

            if (tipoClasificacion == "") {
                $("#tipoClasificacion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#tipoClasificacion").removeClass("is-invalid");
            }

            if (detalleClasificacion == "") {
                $("#detalleClasificacion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#detalleClasificacion").removeClass("is-invalid");
            }
            if (isValid) {
                location.href = "clasificaciones.do?action=Nueva&tipoClasificaicon=" + tipoClasificacion + "&detalleClasificacion=" + detalleClasificacion;
            }

        }
    });

    $("#modificar").click(function (e) {
        e.preventDefault();

        var idClasificacion = $("#idClasificacion").val();
        var tipoClasificacion = $("#tipoClasificacion").val();
        var detalleClasificacion = $("#detalleClasificacion").val();

        if (idClasificacion == "") {
            $("#error").html("No se puede modificar un Registro que no exista");
            error();
        } else {
            var isValid = true;

            if (tipoClasificacion == "") {
                $("#tipoClasificacion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#tipoClasificacion").removeClass("is-invalid");
            }

            if (detalleClasificacion == "") {
                $("#detalleClasificacion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#detalleClasificacion").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "clasificaciones.do?action=Modificar&idClasificacion=" + idClasificacion + "&tipoClasificacion=" + tipoClasificacion + "&detalleClasificacion=" + detalleClasificacion;
            }

        }
    });

    $("#eliminar").click(function (e) {
        e.preventDefault();

        var idClasificacion = $("#idClasificacion").val();
        var tipoClasificacion = $("#tipoClasificacion").val();
        var detalleClasificacion = $("#detalleClasificacion").val();

        if (idClasificacion == "") {
            $("#error").html("No se puede eliminar un registro que no exista");
            error();
        } else {
            var isValid = true;

            if (tipoClasificacion == "") {
                $("#tipoClasificacion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#tipoClasificacion").removeClass("is-invalid");
            }

            if (detalleClasificacion == "") {
                $("#detalleClasificacion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#detalleClasificacion").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "clasificaciones.do?action=Eliminar&idClasificacion=" + idClasificacion;
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