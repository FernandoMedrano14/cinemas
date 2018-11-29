$(document).ready(function () {

    $("#nueva").click(function (e) {
        e.preventDefault();

        var idVenta = $("#idVenta").val();
        var funciones = $("#funciones").val();
        var fechaVenta = $("#fechaVenta").val();
        var nombreCliente = $("#nombreCliente").val();
        var cantidad = $("#cantidad").val();
        var dui = $("#dui").val();
        var total = $("#total").val();
        var estado = $("#estado").val();

        if (idVenta != "") {
            $("#idVenta").val("");
            $("#funciones").val("");
            $("#fechaVenta").val("");
            $("#nombreCliente").val("");
            $("#cantidad").val("");
            $("#dui").val("");
            $("#total").val("");
            $("#estado").val("");

        } else {
            var isValid = true;

            if (funciones == "") {
                $("#funciones").addClass("is-invalid");
                isValid = false;
            } else {
                $("#funciones").removeClass("is-invalid");
            }

            if (fechaVenta == "") {
                $("#fechaVenta").addClass("is-invalid");
                isValid = false;
            } else {
                $("#fechaVenta").removeClass("is-invalid");
            }

            if (nombreCliente == "") {
                $("#nombreCliente").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nombreCliente").removeClass("is-invalid");
            }

            if (cantidad == "") {
                $("#cantidad").addClass("is-invalid");
                isValid = false;
            } else {
                $("#cantidad").removeClass("is-invalid");
            }
            if (dui == "") {
                $("#dui").addClass("is-invalid");
                isValid = false;
            } else {
                $("#dui").removeClass("is-invalid");
            }
            if (total == "") {
                $("#total").addClass("is-invalid");
                isValid = false;
            } else {
                $("#total").removeClass("is-invalid");
            }
            if (estado == "") {
                $("#estado").addClass("is-invalid");
                isValid = false;
            } else {
                $("#estado").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "ventas.do?action=Nueva&funciones=" + funciones + "&fechaVenta=" + fechaVenta + "&nombreCliente=" + nombreCliente
                        + "&cantidad=" + cantidad + "&dui=" + dui + "&total=" + total + "&estado=" + estado;
            }
        }
    });

    $("#modificar").click(function (e) {
        e.preventDefault();

        var idVenta = $("#idVenta").val();
        var funciones = $("#funciones").val();
        var fechaVenta = $("#fechaVenta").val();
        var nombreCliente = $("#nombreCliente").val();
        var cantidad = $("#cantidad").val();
        var dui = $("#dui").val();
        var total = $("#total").val();
        var estado = $("#estado").val();

        if (idVenta == "") {
            $("#error").html("No se puede modificar un Registro que no exista");
            error();
        } else {
            var isValid = true;

            if (funciones == "") {
                $("#funciones").addClass("is-invalid");
                isValid = false;
            } else {
                $("#funciones").removeClass("is-invalid");
            }

            if (fechaVenta == "") {
                $("#fechaVenta").addClass("is-invalid");
                isValid = false;
            } else {
                $("#fechaVenta").removeClass("is-invalid");
            }

            if (nombreCliente == "") {
                $("#nombreCliente").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nombreCliente").removeClass("is-invalid");
            }

            if (cantidad == "") {
                $("#cantidad").addClass("is-invalid");
                isValid = false;
            } else {
                $("#cantidad").removeClass("is-invalid");
            }
            if (dui == "") {
                $("#dui").addClass("is-invalid");
                isValid = false;
            } else {
                $("#dui").removeClass("is-invalid");
            }
            if (total == "") {
                $("#total").addClass("is-invalid");
                isValid = false;
            } else {
                $("#total").removeClass("is-invalid");
            }
            if (estado == "") {
                $("#estado").addClass("is-invalid");
                isValid = false;
            } else {
                $("#estado").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "ventas.do?action=Modificar&idVenta=" + idVenta + "&funciones=" + funciones + "&fechaVenta=" + fechaVenta + "&nombreCliente=" + nombreCliente
                        + "&cantidad=" + cantidad + "&dui=" + dui + "&total=" + total + "&estado=" + estado;
            }

        }
    });

    $("#eliminar").click(function (e) {
        e.preventDefault();

        var idVenta = $("#idVenta").val();
        var funciones = $("#funciones").val();
        var fechaVenta = $("#fechaVenta").val();
        var nombreCliente = $("#nombreCliente").val();
        var cantidad = $("#cantidad").val();
        var dui = $("#dui").val();
        var total = $("#total").val();
        var estado = $("#estado").val();

        if (idVenta == "") {
            $("#error").html("No se puede eliminar un Registro que no exista");
            error();
        } else {
            var isValid = true;

            if (funciones == "") {
                $("#funciones").addClass("is-invalid");
                isValid = false;
            } else {
                $("#funciones").removeClass("is-invalid");
            }

            if (fechaVenta == "") {
                $("#fechaVenta").addClass("is-invalid");
                isValid = false;
            } else {
                $("#fechaVenta").removeClass("is-invalid");
            }

            if (nombreCliente == "") {
                $("#nombreCliente").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nombreCliente").removeClass("is-invalid");
            }

            if (cantidad == "") {
                $("#cantidad").addClass("is-invalid");
                isValid = false;
            } else {
                $("#cantidad").removeClass("is-invalid");
            }
            if (dui == "") {
                $("#dui").addClass("is-invalid");
                isValid = false;
            } else {
                $("#dui").removeClass("is-invalid");
            }
            if (total == "") {
                $("#total").addClass("is-invalid");
                isValid = false;
            } else {
                $("#total").removeClass("is-invalid");
            }
            if (estado == "") {
                $("#estado").addClass("is-invalid");
                isValid = false;
            } else {
                $("#estado").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "ventas.do?action=Eliminar&idVenta=" + idVenta;
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





