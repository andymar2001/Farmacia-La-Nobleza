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

class UI {
  messageError(message) {
    const messageError = document.createElement("P");
    messageError.className = "message-error";
    messageError.textContent = `${message}`;
    return messageError;
  }
  removerElementoSiguiente(elemento) {
    if (elemento.nextElementSibling) {
      elemento.nextElementSibling.remove();
    }
  }
  notificationError(message) {
    const notification = document.createElement("DIV");
    notification.className = "notificacion--error";
    notification.innerHTML = `
      <i class="fas fa-times"></i>
      <p class="notificacion--error__text">${message}</p>
    `;
    setTimeout(() => {
      notification.remove();
    }, 2500);
    return document.querySelector("body").appendChild(notification);
  }
}

const ui = new UI();

/* VALIDACIÓN */

/* FORMLOGIN */

const formLogin = document.getElementById("form-login");
const usuario = document.getElementById("usuario-login");
const constrasena = document.getElementById("contrasena-login");

const formLoginIsValid = {
  usuario: false,
  contrasena: false,
};

formLogin.addEventListener("submit", (e) => {
  e.preventDefault();
  validateFormLogin();
});

usuario.addEventListener("input", (e) => {
  if (e.target.value.length > 0) {
    formLoginIsValid.usuario = true;
    ui.removerElementoSiguiente(usuario);
  } else {
    formLoginIsValid.usuario = false;
    usuario.after(ui.messageError("Debes ingresar tu DNI"));
  }
});

constrasena.addEventListener("input", (e) => {
  if (e.target.value.length > 0) {
    formLoginIsValid.contrasena = true;
    ui.removerElementoSiguiente(constrasena);
  } else {
    formLoginIsValid.usuario = false;
    constrasena.after(ui.messageError("Debes ingresar tu contraseña"));
  }
});

const validateFormLogin = () => {
  const formValues = Object.values(formLoginIsValid);
  const valid = formValues.findIndex((value) => value == false);
  if (valid == -1) formLogin.submit();
  else ui.notificationError("Error al iniciar sesión");
};