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

/* Clase para UI */
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

//FORMLOGIN

const formLogin = document.getElementById("form-login");
const usuario = document.getElementById("usuario-login");
const constrasena = document.getElementById("contrasena-login");

const formLoginIsValid = {
  usuario: false,
  contrasena: false,
};

if (formLogin && usuario && constrasena) {
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
}

//FORM REGISTER USER

const formRegisterUser = document.getElementById("form-register-user");

const nombresUser = document.getElementById("nombres-user");
const apellidosUser = document.getElementById("apellidos-user");
const dniUser = document.getElementById("dni-user");
const celularUser = document.getElementById("celular-user");
const telefonoUser = document.getElementById("telefono-user");
const correoUser = document.getElementById("correo-user");
const fechaUser = document.getElementById("fecha-user");
const contrasenaUser = document.getElementById("contrasena-user");

const formRegisterUserIsValid = {
  nombres: false,
  apellidos: false,
  dni: false,
  celular: false,
  telefono: false,
  correo: false,
  contrasena: false,
};


if (
  formRegisterUser &&
  nombresUser &&
  apellidosUser &&
  dniUser &&
  celularUser &&
  telefonoUser &&
  correoUser &&
  fechaUser &&
  contrasenaUser
) {
  formRegisterUser.addEventListener("submit", (e) => {
    e.preventDefault();
    validateFormRegisterUser();
  });

  nombresUser.addEventListener("input", (e) => {
    if (e.target.value.length > 0) {
      formRegisterUserIsValid.nombres = true;
      ui.removerElementoSiguiente(nombresUser);
    } else {
      formRegisterUserIsValid.nombres = false;
      nombresUser.after(ui.messageError("Ingresar nombres"));
    }
  });

  apellidosUser.addEventListener("input", (e) => {
    if (e.target.value.length > 0) {
      formRegisterUserIsValid.apellidos = true;
      ui.removerElementoSiguiente(apellidosUser);
    } else {
      formRegisterUserIsValid.apellidos = false;
      apellidosUser.after(ui.messageError("Ingresar apellidos"));
    }
  });

  dniUser.addEventListener("input", (e) => {
    if (e.target.value.length > 0) {
      formRegisterUserIsValid.dni = true;
      ui.removerElementoSiguiente(dniUser);
    } else {
      formRegisterUserIsValid.dni = false;
      dniUser.after(ui.messageError("Ingresar DNI"));
    }
  });

  celularUser.addEventListener("input", (e) => {
    if (e.target.value.length > 0) {
      formRegisterUserIsValid.celular = true;
      ui.removerElementoSiguiente(celularUser);
    } else {
      formRegisterUserIsValid.celular = false;
      celularUser.after(ui.messageError("Ingresar celular"));
    }
  });

  telefonoUser.addEventListener("input", (e) => {
    if (isNaN(parseInt(e.target.value))) {
      formRegisterUserIsValid.telefono = false;
      ui.removerElementoSiguiente(telefonoUser);
      telefonoUser.after(
        ui.messageError("Numero telefonico no es de formato numerico")
      );
    } else {
      formRegisterUserIsValid.telefono = true;
      ui.removerElementoSiguiente(telefonoUser);
    }
  });

  correoUser.addEventListener("input", (e) => {
    if (e.target.value.length > 0) {
      formRegisterUserIsValid.correo = true;
      ui.removerElementoSiguiente(correoUser);
    } else {
      formRegisterUserIsValid.correo = false;
      correoUser.after(ui.messageError("Ingresar correo"));
    }
  });

  contrasenaUser.addEventListener("input", (e) => {
    if (e.target.value.length > 0) {
      formRegisterUserIsValid.contrasena = true;
      ui.removerElementoSiguiente(contrasenaUser);
    } else {
      formRegisterUserIsValid.contrasena = false;
      contrasenaUser.after(ui.messageError("Ingresar contraseña"));
    }
  });

  const validateFormRegisterUser = () => {
    const formValues = Object.values(formRegisterUserIsValid);
    const valid = formValues.findIndex((value) => value == false);
    if (valid == -1) formRegisterUser.submit();
    else ui.notificationError("Error al registrarse");
  };
}
