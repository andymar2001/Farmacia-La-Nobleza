const formCarrito = document.getElementById("form-carrito");

const fechaEntrega = document.getElementById("fecha-entrega-carrito");
const entregaCarrito = document.getElementById("entrega-carrito");
const deliveryCarrito = document.getElementById("delivery-carrito");
const tiendaCarrito = document.getElementById("tienda-carrito");
const direccionCarrito = document.getElementById("direccion-carrito");
const ciudadCarrito = document.getElementById("ciudad-carrito");
const regionCarrito = document.getElementById("region-carrito");

formCarrito.addEventListener("submit", (e) => {
  e.preventDefault();
  validateForm();
});

const formIsValid = {
  fechaEntrega: false,
  entrega: false,
  direccion: false,
  ciudad: false,
  region: false,
};

fechaEntrega.addEventListener("change", (e) => {
  formIsValid.fechaEntrega = true;
});

entregaCarrito.addEventListener("change", (e) => {
  if (e.target.checked == true) formIsValid.entrega = true;
});

deliveryCarrito.addEventListener("click", (e) => {
  direccionCarrito.removeAttribute("disabled", false);
  ciudadCarrito.removeAttribute("disabled", false);
  regionCarrito.removeAttribute("disabled", false);

  formIsValid.direccion = false;
  formIsValid.ciudad = false;
  formIsValid.region = false;
});

tiendaCarrito.addEventListener("click", (e) => {
  direccionCarrito.value = "";
  ciudadCarrito.value = "";
  regionCarrito.value = "";

  direccionCarrito.setAttribute("disabled", true);
  ciudadCarrito.setAttribute("disabled", true);
  regionCarrito.setAttribute("disabled", true);

  formIsValid.direccion = true;
  formIsValid.ciudad = true;
  formIsValid.region = true;
});

direccionCarrito.addEventListener("input", (e) => {
  if (e.target.value.trim().length > 0) formIsValid.direccion = true;
});

ciudadCarrito.addEventListener("input", (e) => {
  if (e.target.value.trim().length > 0) formIsValid.ciudad = true;
});

regionCarrito.addEventListener("input", (e) => {
  if (e.target.value.trim().length > 0) formIsValid.region = true;
});

const validateForm = () => {
  const formValues = Object.values(formIsValid);
  const valid = formValues.findIndex((value) => value == false);
  if (valid == -1) formCarrito.submit();
  else ui.notificationError("Error al validar carrito");
};
