<%@ include file="snippets/head.jsp" %>
<title>Carrito de compras - Farmacia La Nobleza</title>

</head>

<body>
<%@ include file="snippets/header.jsp" %>
  <main class="main">
    <section class="carrito-compras section">
      <form id="form-carrito" action="" method="post" class="carrito-compras__container container">
        <div class="carrito-compras__1">
          <div class="carrito-compras__top">
            <p class="carrito-compras__title">TU PEDIDO</p>
            <p class="carrito-compras__productos">1 Producto(s)</p>
          </div>
          <table class="carrito-compras__table">
            <thead>
              <tr>
                <th>Producto</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Total</th>
                <th>Borrar</th>
              </tr>
            </thead>
            <tbody>
              <tr class="carrito-compras__table__row">
                <th class="carrito-compras__table__producto">
                  <figure class="carrito-compras__table__img">
                    <img src="assets/img/producto.jpg" alt="foto">
                  </figure>
                  <div class="carrito-compras__table__data">
                    <p class="carrito-compras__table__data__title">ALCOHOL 96ï¿½ X 1000 ML</p>
                    <p>SKU: 08646</p>
                    <p>Maximo de compra: 1 unidades.</p>
                  </div>
                </th>
                <th class="carrito-compras__table__number">
                  <input type="number" name="" id="" value="1">
                </th>
                <th>
                  S/<span>15.40</span>
                </th>
                <th>
                  S/<span>15.40</span>
                </th>
                <th class="carrito-compras__table__delete">
                  <i class="far fa-trash-alt"></i>
                </th>
              </tr>
              <tr class="carrito-compras__table__row">
                <th class="carrito-compras__table__producto">
                  <figure class="carrito-compras__table__img">
                    <img src="assets/img/producto.jpg" alt="foto">
                  </figure>
                  <div class="carrito-compras__table__data">
                    <p class="carrito-compras__table__data__title">ALCOHOL 96ï¿½ X 1000 ML</p>
                    <p>SKU: 08646</p>
                    <p>Maximo de compra: 1 unidades.</p>
                  </div>
                </th>
                <th class="carrito-compras__table__number">
                  <input type="number" name="" id="" value="1">
                </th>
                <th>
                  S/<span>15.40</span>
                </th>
                <th>
                  S/<span>15.40</span>
                </th>
                <th class="carrito-compras__table__delete">
                  <i class="far fa-trash-alt"></i>
                </th>
              </tr>
            </tbody>
          </table>
          <div class="carrito-compras__inputs">
	          <div class="carrito-compras__gridtwo">
	          	<div>
	          		<label for="fecha-entrega-carrito" class="label">Fecha de entrega:</label>
	          		<input id="fecha-entrega-carrito" class="input" type="date" name="fechaEntrega">
	        	</div>
	          </div>
	          <div>
		       	<label class="label">Tipo de entrega:</label>
		          <div id="entrega-carrito">
	          		<div>
	          			<input id="delivery-carrito" type="radio" name="tipoEntrega" value="D">
	          			<label for="delivery-carrito" class="">Delivery</label>
	          		</div>
	          		<div>
	          			<input id="tienda-carrito" type="radio" name="tipoEntrega" value="T">
	          			<label for="tienda-carrito" class="">Tienda</label>
	          		</div>
		          </div>
		       </div>
	          <div class="carrito-compras__gridthree">
		          <div>
		          	<label for="direccion-carrito" class="label">Dirección de entrega:</label>
		          	<input id="direccion-carrito" class="input" type="text" name="direccion" placeholder="Dirección de destinatario">
		          </div>
		          <div>
		          	<label for="ciudad-carrito" class="label">Ciudad de destinatario:</label>
		          	<input id="ciudad-carrito" class="input" type="text" name="ciudad" placeholder="Ciudad de destinatario">
		          </div>
		          <div>
		          	<label for="region-carrito" class="label">Región de destinatario:</label>
		          	<input id="region-carrito" class="input" type="text" name="region" placeholder="Región de destinatario">
		          </div>
	          </div>
          </div>
        </div>
        <div class="carrito-compras__2">
          <div class="carrito-compras__pagar">
            <p class="carrito-compras__pagar__title">TOTAL A PAGAR</p>
            <p class="carrito-compras__pagar__precio">S/ 27.00</p>
            <p class="carrito-compras__pagar__text">Compra minima a partir de S/ 20.00</p>
            <div class="carrito-compras__pagar__delivery">
              <p class="carrito-compras__pagar__delivery__title">DELIVERY</p>
              <p class="carrito-compras__pagar__delivery__subtitle">(Por lanzamiento, el costo de envï¿½o es gratuito)</p>
              <div class="carrito-compras__pagar__delivery__icon">
                <i class="fas fa-motorcycle"></i>
              </div>
              <p class="carrito-compras__pagar__delivery__fecha">martes 14 de julio de 2020</p>
            </div>
            <p class="carrito-compras__frase">#AUnClicDeTuSalud</p>
            <input class="button-submit carrito-compras__submit" type="submit" value="PAGAR">
          </div>
        </div>
      </form>
    </section>
  </main>
<%@ include file="snippets/footer.jsp" %>
<script src="js/formCarrito.js"></script>
</body>

</html>