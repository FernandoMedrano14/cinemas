$(document).ready(function () {

    $('.phone').mask('0000 0000', {reverse: true});
    $('.nit').mask('0000-000000-000-0', {reverse: true});
    $('.dui').mask('00000000-0', {reverse: true});
    $('.nrc').mask('000000-0', {reverse: true});
    $('.entero').mask('0000', {reverse: true});
    $('.decimal').mask('00000.00', {reverse: true});
    $('.duracion').mask('000 min', {reverse: true});

});
