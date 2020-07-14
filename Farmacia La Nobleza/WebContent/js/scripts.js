console.log("Bienvenido");
$(".banner").slick({
  slidesToShow: 1,
  slidesToScroll: 1,
  autoplay: true,
  autoplaySpeed: 2000,
  dots: true,
});
$(".slider-card__slider").slick({
  arrows: false,
  rows: 1,
  slidesToShow: 4,
  slidesToScroll: 1,
  autoplay: true,
  autoplaySpeed: 2000,
});
$(".slider-card__prev").click(function () {
  $(".slider-card__slider").slick("slickPrev");
});

$(".slider-card__next").click(function () {
  $(".slider-card__slider").slick("slickNext");
});
// VALIDACIÓN

const formLogin = document.getElementById("form-login");
const usuario = document.getElementById("usuario-login");
const constrasena = document.getElementById("contrasena-login");

formLogin.addEventListener("submit", (e) => {
  if (usuario.value.length == 0) {
    alert("Ingresar usuario");
    return false;
  }
  if (constrasena.value.length == 0) {
    alert("Ingresar contraseña");
    return false;
  }
});


