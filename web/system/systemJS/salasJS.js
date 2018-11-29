$(document).ready(function () {

    $("#nueva").click(function (e) {
        e.preventDefault();

        var idSala = $("#idSala").val();
        var sucursales = $("#sucursales").val();
        var numeroSala = $("#numeroSala").val();
        var tipoSala = $("#tipoSala").val();

        if (idSala != "") {
            $("#idSala").val("");
            $("#sucursales").val("");
            $("#numeroSala").val("");
            $("#tipoSala").val("");

        } else {
            var isValid = true;

            if (sucursales == "") {
                $("#sucursales").addClass("is-invalid");
                isValid = false;
            } else {
                $("#sucursales").removeClass("is-invalid");
            }

            if (numeroSala == "") {
                $("#numeroSala").addClass("is-invalid");
                isValid = false;
            } else {
                $("#numeroSala").removeClass("is-invalid");
            }

            if (tipoSala == "") {
                $("#tipoSala").addClass("is-invalid");
                isValid = false;
            } else {
                $("#tipoSala").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "sala.do?action=Nueva&sucursales=" + sucursales + "&numeroSala=" + numeroSala + "&tipoSala=" + tipoSala;
            }
        }
    });

    $("#modificar").click(function (e) {
        e.preventDefault();

        var idSala = $("#idSala").val();
        var sucursales = $("#sucursales").val();
        var numeroSala = $("#numeroSala").val();
        var tipoSala = $("#tipoSala").val();

        if (idSala == "") {
            $("#error").html("No se puede modificar un Registro que no exista");
            error();
        } else {
            var isValid = true;

            if (sucursales == "") {
                $("#sucursales").addClass("is-invalid");
                isValid = false;
            } else {
                $("#sucursales").removeClass("is-invalid");
            }

            if (numeroSala == "") {
                $("#numeroSala").addClass("is-invalid");
                isValid = false;
            } else {
                $("#numeroSala").removeClass("is-invalid");
            }

            if (tipoSala == "") {
                $("#tipoSala").addClass("is-invalid");
                isValid = false;
            } else {
                $("#tipoSala").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "sala.do?action=Modificar&idSala=" + idSala + "&sucursales=" + sucursales + "&numeroSala=" + numeroSala + "&tipoSala=" + tipoSala;
            }

        }
    });

    $("#eliminar").click(function (e) {
        e.preventDefault();

        var idSala = $("#idSala").val();
        var sucursales = $("#sucursales").val();
        var numeroSala = $("#numeroSala").val();
        var tipoSala = $("#tipoSala").val();

        if (idSala == "") {
            $("#error").html("No se puede eliminar un Registro que no exista");
            error();
        } else {
            var isValid = true;

            if (sucursales == "") {
                $("#sucursales").addClass("is-invalid");
                isValid = false;
            } else {
                $("#sucursales").removeClass("is-invalid");
            }

            if (numeroSala == "") {
                $("#numeroSala").addClass("is-invalid");
                isValid = false;
            } else {
                $("#numeroSala").removeClass("is-invalid");
            }

            if (tipoSala == "") {
                $("#tipoSala").addClass("is-invalid");
                isValid = false;
            } else {
                $("#tipoSala").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "sala.do?action=Eliminar&idSala=" + idSala;
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


