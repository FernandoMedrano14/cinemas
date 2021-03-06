$(document).ready(function () {

    $('#empresasTable').DataTable({
        language: {"url": 'dataTables/datatable_es.json'},
        columns: [
            {"width": "20%"},
            {"width": "50%"},
            {"width": "20%"},
            {"width": "20%"}
        ],
        columnDefs: [{
            targets: [0, 1, 3],
            className: 'dt-body-left'
        }],
        responsive: true,
        "autoWidth": false,
        "info": false,
        "scrollY": "350px",
        "scrollX": false,
        "scrollCollapse": true,
        "paging": false
    });

    $("#nueva").click(function (e) {
        e.preventDefault();

        var idEmpresa = $("#idEmpresa").val();
        var nombre = $("#nombre").val();
        var direccion = $("#direccion").val();
        var telefono = $("#telefono").val();
        var nit = $("#nit").val();
        var numeroRegistro = $("#numeroRegistro").val();
        var giro = $("#giro").val();

        if(idEmpresa == "" || idEmpresa == 0){
            var isValid = true;

            if (nombre == "") {
                $("#nombre").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nombre").removeClass("is-invalid");
            }

            if (direccion == "") {
                $("#direccion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#direccion").removeClass("is-invalid");
            }

            if (telefono == "") {
                $("#telefono").addClass("is-invalid");
                isValid = false;
            } else {
                $("#telefono").removeClass("is-invalid");
            }

            if (nit == "") {
                $("#nit").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nit").removeClass("is-invalid");
            }

            if (numeroRegistro == "") {
                $("#numeroRegistro").addClass("is-invalid");
                isValid = false;
            } else {
                $("#numeroRegistro").removeClass("is-invalid");
            }

            if (giro == "") {
                $("#giro").addClass("is-invalid");
                isValid = false;
            } else {
                $("#giro").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "empresa.do?action=Nueva&nombre=" + nombre + "&direccion=" + direccion + "&telefono=" + telefono
                        + "&nit=" + nit + "&numeroRegistro=" + numeroRegistro + "&giro=" + giro;
            }
        } else {
            $("#idEmpresa").val("");
            $("#nombre").val("");
            $("#direccion").val("");
            $("#telefono").val("");
            $("#nit").val("");
            $("#numeroRegistro").val("");
            $("#giro").val("");

            $("#nombre").removeClass("is-invalid");
            $("#direccion").removeClass("is-invalid");
            $("#telefono").removeClass("is-invalid");
            $("#nit").removeClass("is-invalid");
            $("#numeroRegistro").removeClass("is-invalid");
            $("#giro").removeClass("is-invalid");
        }
    });

    $("#modificar").click(function (e) {
        e.preventDefault();

        var idEmpresa = $("#idEmpresa").val();
        var nombre = $("#nombre").val();
        var direccion = $("#direccion").val();
        var telefono = $("#telefono").val();
        var nit = $("#nit").val();
        var numeroRegistro = $("#numeroRegistro").val();
        var giro = $("#giro").val();

        if (idEmpresa == "" || idEmpresa == 0) {
            $("#error").html("No se puede modificar un Registro que no exista");
            error();
        } else {
            var isValid = true;

            if (nombre == "") {
                $("#nombre").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nombre").removeClass("is-invalid");
            }

            if (direccion == "") {
                $("#direccion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#direccion").removeClass("is-invalid");
            }

            if (telefono == "") {
                $("#telefono").addClass("is-invalid");
                isValid = false;
            } else {
                $("#telefono").removeClass("is-invalid");
            }

            if (nit == "") {
                $("#nit").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nit").removeClass("is-invalid");
            }

            if (numeroRegistro == "") {
                $("#numeroRegistro").addClass("is-invalid");
                isValid = false;
            } else {
                $("#numeroRegistro").removeClass("is-invalid");
            }

            if (giro == "") {
                $("#giro").addClass("is-invalid");
                isValid = false;
            } else {
                $("#giro").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "empresa.do?action=Modificar&idEmpresa=" + idEmpresa + "&nombre=" + nombre + "&direccion=" + direccion + "&telefono=" + telefono
                        + "&nit=" + nit + "&numeroRegistro=" + numeroRegistro + "&giro=" + giro;
                $("#idEmpresa").val("");
            }

        }
    });

    $("#btnEliminar").click(function () {
        var idEmpresa = $("#idEmpresa").val();
        $("#keyDelete").val(idEmpresa);
        $("#deleteModal").modal("show");
    });

    $("#eliminar").click(function (e) {
        e.preventDefault();
        var idEmpresa = $("#keyDelete").val();

        if (idEmpresa == "" || idEmpresa == 0) {
            $("#error").html("No se puede eliminar un Registro que no exista");
            $("#deleteModal").modal("hide");
            error();
        } else {
            $("#idEmpresa").val("");
            $("#keyDelete").val("");
            location.href = "empresa.do?action=Eliminar&idEmpresa=" + idEmpresa;
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
