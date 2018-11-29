$(document).ready(function () {

    $("#nueva").click(function (e) {
        e.preventDefault();

        var idPrecio = $("#idPrecio").val();
        var sucursales = $("#sucursales").val();
        var precio = $("#precio").val();
        var descripcion = $("#descripcion").val();

        if (idPrecio != "") {
            $("#idPrecio").val("");
            $("#sucursales").val("");
            $("#precio").val("");
            $("#descripcion").val("");

        } else {
            var isValid = true;

            if (sucursales == "") {
                $("#sucursales").addClass("is-invalid");
                isValid = false;
            } else {
                $("#sucursales").removeClass("is-invalid");
            }

            if (precio == "") {
                $("#precio").addClass("is-invalid");
                isValid = false;
            } else {
                $("#precio").removeClass("is-invalid");
            }

            if (descripcion == "") {
                $("#descripcion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#descripcion").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "precios.do?action=Nueva&sucursales=" + sucursales + "&precio=" + precio + "&descripcion=" + descripcion;
            }
        }
    });

    $("#modificar").click(function (e) {
        e.preventDefault();

        var idPrecio = $("#idPrecio").val();
        var sucursales = $("#sucursales").val();
        var precio = $("#precio").val();
        var descripcion = $("#descripcion").val();

        if (idPrecio == "") {
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

            if (precio == "") {
                $("#precio").addClass("is-invalid");
                isValid = false;
            } else {
                $("#precio").removeClass("is-invalid");
            }

            if (descripcion == "") {
                $("#descripcion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#descripcion").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "precios.do?action=Modificar&idPrecio=" + idPrecio + "&sucursales=" + sucursales + "&precio=" + precio + "&descripcion=" + descripcion;
            }

        }
    });

    $("#eliminar").click(function (e) {
        e.preventDefault();

        var idPrecio = $("#idPrecio").val();
        var sucursales = $("#sucursales").val();
        var precio = $("#precio").val();
        var descripcion = $("#descripcion").val();

        if (idPrecio == "") {
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

            if (precio == "") {
                $("#precio").addClass("is-invalid");
                isValid = false;
            } else {
                $("#precio").removeClass("is-invalid");
            }

            if (descripcion == "") {
                $("#descripcion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#descripcion").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "precios.do?action=Eliminar&idPrecio=" + idPrecio;
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
