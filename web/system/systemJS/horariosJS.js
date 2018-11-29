$(document).ready(function () {

    $("#nueva").click(function (e) {
        e.preventDefault();

        var idHorario = $("#idHorario").val();
        var salas = $("#salas").val();
        var horarios = $("#horarios").val();

        if (idHorario != "") {
            $("#idHorario").val("");
            $("#salas").val("");
            $("#horarios").val("");

        } else {
            var isValid = true;

            if (salas == "") {
                $("#salas").addClass("is-invalid");
                isValid = false;
            } else {
                $("#salas").removeClass("is-invalid");
            }
            if (horarios == "") {
                $("#horarios").addClass("is-invalid");
                isValid = false;
            } else {
                $("#horarios").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "horarios.do?action=Nueva&salas=" + salas + "&horarios=" + horarios;
            }

        }
    });

    $("#modificar").click(function (e) {
        e.preventDefault();

        var idHorario = $("#idHorario").val();
        var salas = $("#salas").val();
        var horarios = $("#horarios").val();

        if (idHorario == "") {
            $("#error").html("No se puede modificar un Registro que no exista");
            error();
        } else {
            var isValid = true;

            if (salas == "") {
                $("#salas").addClass("is-invalid");
                isValid = false;
            } else {
                $("#salas").removeClass("is-invalid");
            }
            if (horarios == "") {
                $("#horarios").addClass("is-invalid");
                isValid = false;
            } else {
                $("#horarios").removeClass("is-invalid");
            }
            if (isValid) {
                location.href = "horarios.do?action=Modificar&idhorario=" + idHorario + "&salas=" + salas + "&horarios=" + horarios;
            }
        }
    });

    $("#eliminar").click(function (e) {
        e.preventDefault();

        var idHorario = $("#idHorario").val();
        var salas = $("#salas").val();
        var horarios = $("#horarios").val();

        if (idHorario == "") {
            $("#error").html("No se puede eliminar un registro que no exista");
            error();
        } else {
            var isValid = true;

            if (salas == "") {
                $("#salas").addClass("is-invalid");
                isValid = false;
            } else {
                $("#salas").removeClass("is-invalid");
            }
            if (horarios == "") {
                $("#horarios").addClass("is-invalid");
                isValid = false;
            } else {
                $("#horarios").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "horarios.do?action=Eliminar&idHorario=" + idHorario;
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
