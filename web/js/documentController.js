$(document).ready(function () {

    $('.phone').mask('0000 0000', {reverse: true});
    $('.nit').mask('0000-000000-000-0', {reverse: true});
    $('.dui').mask('00000000-0', {reverse: true});
    $('.nrc').mask('000000-0', {reverse: true});
    $('.entero').mask('0000', {reverse: true});
    $('.decimal').mask('00000.00', {reverse: true});
    $('.duracion').mask('000 min', {reverse: true});

    toastr.options = {
        "debug": false,
        "positionClass": "toast-bottom-right",
        "onclick": null,
        "fadeIn": 300,
        "fadeOut": 100,
        "timeOut": 5000,
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

    window.onload = function () {
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
    }

});
