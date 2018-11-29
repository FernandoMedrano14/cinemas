$(document).ready(function () {

    $("#nueva").click(function (e) {
        e.preventDefault();

        var idUsuario = $("#idUsuario").val();
        var empresas = $("#empresas").val();
        var tiposUsuarios = $("#tiposUsuarios").val();
        var nickname = $("#nickname").val();
        var nombres = $("#nombres").val();
        var apellidos = $("#apellidos").val();
        var correo = $("#correo").val();
        var contrasenia = $("#contrasenia").val();

        if (idUsuario != "") {
            $("#idUsuario").val("");
            $("#empresas").val("");
            $("#tiposUsuarios").val("");
            $("#nickname").val("");
            $("#nombres").val("");
            $("#apellidos").val("");
            $("#correo").val("");
            $("#contrasenia").val("");

        } else {
            var isValid = true;

            if (empresas == "") {
                $("#empresas").addClass("is-invalid");
                isValid = false;
            } else {
                $("#empresas").removeClass("is-invalid");
            }

            if (tiposUsuarios == "") {
                $("#tiposUsuarios").addClass("is-invalid");
                isValid = false;
            } else {
                $("#tiposUsuarios").removeClass("is-invalid");
            }

            if (nickname == "") {
                $("#nickname").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nickname").removeClass("is-invalid");
            }

            if (nombres == "") {
                $("#nombres").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nombres").removeClass("is-invalid");
            }
            if (apellidos == "") {
                $("#apellidos").addClass("is-invalid");
                isValid = false;
            } else {
                $("#apellidos").removeClass("is-invalid");
            }
            if (correo == "") {
                $("#correo").addClass("is-invalid");
                isValid = false;
            } else {
                $("#correo").removeClass("is-invalid");
            }
            if (contrasenia == "") {
                $("#contrasenia").addClass("is-invalid");
                isValid = false;
            } else {
                $("#contrasenia").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "usuarios.do?action=Nueva&empresas=" + empresas + "&tiposUsuarios=" + tiposUsuarios + "&nickname=" + nickname
                        + "&nombres=" + nombres + "&apellidos=" + apellidos + "&correo=" + correo + "&contrasenia=" + contrasenia;
            }
        }
    });

    $("#modificar").click(function (e) {
        e.preventDefault();

        var idUsuario = $("#idUsuario").val();
        var empresas = $("#empresas").val();
        var tiposUsuarios = $("#tiposUsuarios").val();
        var nickname = $("#nickname").val();
        var nombres = $("#nombres").val();
        var apellidos = $("#apellidos").val();
        var correo = $("#correo").val();
        var contrasenia = $("#contrasenia").val();

        if (idUsuario == "") {
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

            if (tiposUsuarios == "") {
                $("#tiposUsuarios").addClass("is-invalid");
                isValid = false;
            } else {
                $("#tiposUsuarios").removeClass("is-invalid");
            }

            if (nickname == "") {
                $("#nickname").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nickname").removeClass("is-invalid");
            }

            if (nombres == "") {
                $("#nombres").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nombres").removeClass("is-invalid");
            }
            if (apellidos == "") {
                $("#apellidos").addClass("is-invalid");
                isValid = false;
            } else {
                $("#apellidos").removeClass("is-invalid");
            }
            if (correo == "") {
                $("#correo").addClass("is-invalid");
                isValid = false;
            } else {
                $("#correo").removeClass("is-invalid");
            }
            if (contrasenia == "") {
                $("#contrasenia").addClass("is-invalid");
                isValid = false;
            } else {
                $("#contrasenia").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "usuarios.do?action=Modificar&idUsuario=" + idUsuario + "&empresas=" + empresas + "&tiposUsuarios=" + tiposUsuarios + "&nickname=" + nickname + "&nombres=" + nombres + "&apellidos=" + apellidos + "&correo=" + correo + "&contrasenia=" + contrasenia;
            }

        }
    });

    $("#eliminar").click(function (e) {
        e.preventDefault();

        var idUsuario = $("#idUsuario").val();
        var empresas = $("#empresas").val();
        var tiposUsuarios = $("#tiposUsuarios").val();
        var nickname = $("#nickname").val();
        var nombres = $("#nombres").val();
        var apellidos = $("#apellidos").val();
        var correo = $("#correo").val();
        var contrasenia = $("#contrasenia").val();

        if (idUsuario == "") {
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

            if (tiposUsuarios == "") {
                $("#tiposUsuarios").addClass("is-invalid");
                isValid = false;
            } else {
                $("#tiposUsuarios").removeClass("is-invalid");
            }

            if (nickname == "") {
                $("#nickname").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nickname").removeClass("is-invalid");
            }

            if (nombres == "") {
                $("#nombres").addClass("is-invalid");
                isValid = false;
            } else {
                $("#nombres").removeClass("is-invalid");
            }
            if (apellidos == "") {
                $("#apellidos").addClass("is-invalid");
                isValid = false;
            } else {
                $("#apellidos").removeClass("is-invalid");
            }
            if (correo == "") {
                $("#correo").addClass("is-invalid");
                isValid = false;
            } else {
                $("#correo").removeClass("is-invalid");
            }
            if (contrasenia == "") {
                $("#contrasenia").addClass("is-invalid");
                isValid = false;
            } else {
                $("#contrasenia").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "usuarios.do?action=Eliminar&idUsuario=" + idUsuario;
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





