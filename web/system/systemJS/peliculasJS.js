$(document).ready(function () {

    $("#nueva").click(function (e) {
        e.preventDefault();

        var idPelicula = $("#idPelicula").val();
        var clasificaciones = $("#clasificaciones").val();
        var empresas = $("#empresas").val();
        var generos = $("#generos").val();
        var titulo = $("#titulo").val();
        var duracion = $("#duracion").val();
        var actores = $("#actores").val();
        var directores = $("#directores").val();
        var sinopsis = $("#sinopsis").val();
        var imagen = $("#imagen").val();
        var estado = $("#estado").val();

        if (idPelicula != "") {
            $("#idPelicula").val("");
            $("#clasificaciones").val("");
            $("#empresas").val("");
            $("#generos").val("");
            $("#titulo").val("");
            $("#duracion").val("");
            $("#actores").val("");
            $("#directores").val("");
            $("#sinopsis").val("");
            $("#imagen").val("");
            $("#estado").val("");

        } else {
            var isValid = true;

            if (clasificaciones == "") {
                $("#clasificaciones").addClass("is-invalid");
                isValid = false;
            } else {
                $("#clasificaciones").removeClass("is-invalid");
            }

            if (empresas == "") {
                $("#empresas").addClass("is-invalid");
                isValid = false;
            } else {
                $("#empresas").removeClass("is-invalid");
            }

            if (generos == "") {
                $("#genero").addClass("is-invalid");
                isValid = false;
            } else {
                $("#genero").removeClass("is-invalid");
            }

            if (titulo == "") {
                $("#titulo").addClass("is-invalid");
                isValid = false;
            } else {
                $("#titulo").removeClass("is-invalid");
            }

            if (duracion == "") {
                $("#duracion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#duracion").removeClass("is-invalid");
            }

            if (actores == "") {
                $("#actores").addClass("is-invalid");
                isValid = false;
            } else {
                $("#actores").removeClass("is-invalid");
            }
            if (directores == "") {
                $("#directores").addClass("is-invalid");
                isValid = false;
            } else {
                $("#directores").removeClass("is-invalid");
            }
            if (sinopsis == "") {
                $("#sinopsis").addClass("is-invalid");
                isValid = false;
            } else {
                $("#sinopsis").removeClass("is-invalid");
            }
            if (imagen == "") {
                $("#imagen").addClass("is-invalid");
                isValid = false;
            } else {
                $("#imagen").removeClass("is-invalid");
            }
            if (estado == "") {
                $("#estado").addClass("is-invalid");
                isValid = false;
            } else {
                $("#estado").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "peliculas.do?action=Nueva&clasificaciones=" + clasificaciones + "&empresas=" + empresas + "&generos=" + generos
                        + "&titulo=" + titulo + "&duracion=" + duracion + "&actores=" + actores + "&directores=" + directores + "&sinopsis=" + sinopsis
                        + "&imagen=" + imagen + "&estado=" + estado;
            }

        }
    });

    $("#modificar").click(function (e) {
        e.preventDefault();

        var idPelicula = $("#idPelicula").val();
        var clasificaciones = $("#clasificaciones").val();
        var empresas = $("#empresas").val();
        var generos = $("#generos").val();
        var titulo = $("#titulo").val();
        var duracion = $("#duracion").val();
        var actores = $("#actores").val();
        var directores = $("#directores").val();
        var sinopsis = $("#sinopsis").val();
        var imagen = $("#imagen").val();
        var estado = $("#estado").val();

        if (idPelicula == "") {
            $("#error").html("No se puede modificar un Registro que no exista");
            error();
        } else {
            var isValid = true;

            if (clasificaciones == "") {
                $("#clasificaciones").addClass("is-invalid");
                isValid = false;
            } else {
                $("#clasificaciones").removeClass("is-invalid");
            }

            if (empresas == "") {
                $("#empresas").addClass("is-invalid");
                isValid = false;
            } else {
                $("#empresas").removeClass("is-invalid");
            }

            if (generos == "") {
                $("#genero").addClass("is-invalid");
                isValid = false;
            } else {
                $("#genero").removeClass("is-invalid");
            }

            if (titulo == "") {
                $("#titulo").addClass("is-invalid");
                isValid = false;
            } else {
                $("#titulo").removeClass("is-invalid");
            }

            if (duracion == "") {
                $("#duracion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#duracion").removeClass("is-invalid");
            }

            if (actores == "") {
                $("#actores").addClass("is-invalid");
                isValid = false;
            } else {
                $("#actores").removeClass("is-invalid");
            }
            if (directores == "") {
                $("#directores").addClass("is-invalid");
                isValid = false;
            } else {
                $("#directores").removeClass("is-invalid");
            }
            if (sinopsis == "") {
                $("#sinopsis").addClass("is-invalid");
                isValid = false;
            } else {
                $("#sinopsis").removeClass("is-invalid");
            }
            if (imagen == "") {
                $("#imagen").addClass("is-invalid");
                isValid = false;
            } else {
                $("#imagen").removeClass("is-invalid");
            }
            if (estado == "") {
                $("#estado").addClass("is-invalid");
                isValid = false;
            } else {
                $("#estado").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "peliculas.do?action=Modificar&idPelicula=" + idPelicula + "&clasificaciones=" + clasificaciones + "&empresas=" + empresas + "&generos=" + generos
                        + "&titulo=" + titulo + "&duracion=" + duracion + "&actores=" + actores + "&directores=" + directores + "&sinopsis=" + sinopsis
                        + "&imagen=" + imagen + "&estado=" + estado;
            }

        }
    });

    $("#eliminar").click(function (e) {
        e.preventDefault();

        var idPelicula = $("#idPelicula").val();
        var clasificaciones = $("#clasificaciones").val();
        var empresas = $("#empresas").val();
        var generos = $("#generos").val();
        var titulo = $("#titulo").val();
        var duracion = $("#duracion").val();
        var actores = $("#actores").val();
        var directores = $("#directores").val();
        var sinopsis = $("#sinopsis").val();
        var imagen = $("#imagen").val();
        var estado = $("#estado").val();

        if (idPelicula == "") {
            $("#error").html("No se puede eliminar un Registro que no exista");
            error();
        } else {
            var isValid = true;

            if (clasificaciones == "") {
                $("#clasificaciones").addClass("is-invalid");
                isValid = false;
            } else {
                $("#clasificaciones").removeClass("is-invalid");
            }

            if (empresas == "") {
                $("#empresas").addClass("is-invalid");
                isValid = false;
            } else {
                $("#empresas").removeClass("is-invalid");
            }

            if (generos == "") {
                $("#genero").addClass("is-invalid");
                isValid = false;
            } else {
                $("#genero").removeClass("is-invalid");
            }

            if (titulo == "") {
                $("#titulo").addClass("is-invalid");
                isValid = false;
            } else {
                $("#titulo").removeClass("is-invalid");
            }

            if (duracion == "") {
                $("#duracion").addClass("is-invalid");
                isValid = false;
            } else {
                $("#duracion").removeClass("is-invalid");
            }

            if (actores == "") {
                $("#actores").addClass("is-invalid");
                isValid = false;
            } else {
                $("#actores").removeClass("is-invalid");
            }
            if (directores == "") {
                $("#directores").addClass("is-invalid");
                isValid = false;
            } else {
                $("#directores").removeClass("is-invalid");
            }
            if (sinopsis == "") {
                $("#sinopsis").addClass("is-invalid");
                isValid = false;
            } else {
                $("#sinopsis").removeClass("is-invalid");
            }
            if (imagen == "") {
                $("#imagen").addClass("is-invalid");
                isValid = false;
            } else {
                $("#imagen").removeClass("is-invalid");
            }
            if (estado == "") {
                $("#estado").addClass("is-invalid");
                isValid = false;
            } else {
                $("#estado").removeClass("is-invalid");
            }

            if (isValid) {
                location.href = "peliculas.do?action=Eliminar&idPelicula=" + idPelicula;
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
