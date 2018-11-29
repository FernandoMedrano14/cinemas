$(document).ready(function () {

    $("#nueva").click(function (e) {
        e.preventDefault();

        var idSucursal = $("#idSucursal").val();
        var empresas = $("#empresas").val();
        var nombreSucursal = $("#nombreSucursal").val();
        var direccionSucursal = $("#direccionSucursal").val();
        var telefono = $("#telefono").val();

        if (idSucursal != "") {
            $("#idSucursal").val("");
            $("#empresas").val("");
            $("#nombreSucursal").val("");
            $("#direccionSucursal").val("");
            $("#telefono").val("");

        } else {
            var isValid = true;

            if (empresas == "") {
                $("#empresas").addClass("is-invalid");
                isValid = false;
            } else {
                $("#empresas").removeClass("is-invalid");
            }

            if (nombreSucursal == "") {
                $("#nombreSucursal").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nombreSucursal").removeClass("is-invalid");
            }

            if (direccionSucursal == "") {
                $("#direccionSucursal").addClass("is-invalid");
                isValid = false;
            } else {
                $("#direccionSucursal").removeClass("is-invalid");
            }

            if (telefono == "") {
                $("#telefono").addClass("is-invalid");
                isValid = false;
            } else {
                $("#telefono").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "sucursales.do?action=Nueva&empresas=" + empresas + "&nombreSucursal=" + nombreSucursal + "&direccionSucursal=" + direccionSucursal + "&telefono=" + telefono;
            }
        }
    });

    $("#modificar").click(function (e) {
        e.preventDefault();

        var idSucursal = $("#idSucursal").val();
        var empresas = $("#empresas").val();
        var nombreSucursal = $("#nombreSucursal").val();
        var direccionSucursal = $("#direccionSucursal").val();
        var telefono = $("#telefono").val();

        if (idSucursal == "") {
            $("#error").html("No se puede modificar un Registro que no exista");
            error();
        } else {
            var isValid = true;

            if (empresas == "") {
                $("#empresas").addClass("is-invalid");
                isValid = false;
            } else {
                $("#empresas").removeClass("is-invalid");
            }

            if (nombreSucursal == "") {
                $("#nombreSucursal").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nombreSucursal").removeClass("is-invalid");
            }

            if (direccionSucursal == "") {
                $("#direccionSucursal").addClass("is-invalid");
                isValid = false;
            } else {
                $("#direccionSucursal").removeClass("is-invalid");
            }

            if (telefono == "") {
                $("#telefono").addClass("is-invalid");
                isValid = false;
            } else {
                $("#telefono").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "sucursales.do?action=Modificar&idSucursal=" + idSucursal + "&empresas=" + empresas + "&nombreSucursal=" + nombreSucursal + "&direccionSucursal=" + direccionSucursal + "&telefono=" + telefono;
            }

        }
    });

    $("#eliminar").click(function (e) {
        e.preventDefault();

        var idSucursal = $("#idSucursal").val();
        var empresas = $("#empresas").val();
        var nombreSucursal = $("#nombreSucursal").val();
        var direccionSucursal = $("#direccionSucursal").val();
        var telefono = $("#telefono").val();

        if (idSucursal == "") {
            $("#error").html("No se puede eliminar un Registro que no exista");
            error();
        } else {
            var isValid = true;

            if (empresas == "") {
                $("#empresas").addClass("is-invalid");
                isValid = false;
            } else {
                $("#empresas").removeClass("is-invalid");
            }

            if (nombreSucursal == "") {
                $("#nombreSucursal").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nombreSucursal").removeClass("is-invalid");
            }

            if (direccionSucursal == "") {
                $("#direccionSucursal").addClass("is-invalid");
                isValid = false;
            } else {
                $("#direccionSucursal").removeClass("is-invalid");
            }

            if (telefono == "") {
                $("#telefono").addClass("is-invalid");
                isValid = false;
            } else {
                $("#telefono").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "sucursales.do?action=Eliminar&idSucursal=" + idSucursal;
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


