$(document).ready(function () {

    $("#nueva").click(function (e) {
        e.preventDefault();

        var idGenero = $("#idGenero").val();
        var genero = $("#genero").val();

        if (idGenero != "") {
            $("#idGenero").val("");
            $("#genero").val("");

        } else {
            var isValid = true;

            if (genero == "") {
                $("#genero").addClass("is-invalid");
                isValid = false;
            } else {
                $("#genero").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "genero.do?action=Nueva&genero=" + genero;
            }

        }
    });

    $("#modificar").click(function (e) {
        e.preventDefault();

        var idGenero = $("#idGenero").val();
        var genero = $("#genero").val();

        if (idGenero == "") {
            $("#error").html("No se puede modificar un Registro que no exista");
            error();
        } else {
            var isValid = true;

            if (genero == "") {
                $("#genero").addClass("is-invalid");
                isValid = false;
            } else {
                $("#genero").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "genero.do?action=Modificar&idGenero=" + idGenero + "&genero=" + genero;
            }

        }
    });

    $("#eliminar").click(function (e) {
        e.preventDefault();

        var idGenero = $("#idGenero").val();
        var genero = $("#genero").val();

        if (idGenero == "") {
            $("#error").html("No se puede eliminar un registro que no exista");
            error();
        } else {
            var isValid = true;

            if (genero == "") {
                $("#genero").addClass("is-invalid");
                isValid = false;
            } else {
                $("#genero").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "genero.do?action=Eliminar&idGenero=" + idGenero;
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
