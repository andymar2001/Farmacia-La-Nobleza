<%@ include file="snippets/head.jsp" %>
<title>Carrito de compras - Farmacia La Nobleza</title>

</head>

<body>
<%@ include file="snippets/header.jsp" %>
  <main class="main">
    <section class="carrito-compras section">
      <div class="carrito-compras__container container">
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
                    <p class="carrito-compras__table__data__title">ALCOHOL 96° X 1000 ML</p>
                    <p>SKU: 08646</p>
                    <p>Máximo de compra: 1 unidades.</p>
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
                    <p class="carrito-compras__table__data__title">ALCOHOL 96° X 1000 ML</p>
                    <p>SKU: 08646</p>
                    <p>Máximo de compra: 1 unidades.</p>
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
        </div>
        <div class="carrito-compras__2">
          <div class="carrito-compras__pagar">
            <p class="carrito-compras__pagar__title">TOTAL A PAGAR</p>
            <p class="carrito-compras__pagar__precio">S/ 27.00</p>
            <p class="carrito-compras__pagar__text">Compra mínima a partir de S/ 20.00</p>
            <div class="carrito-compras__pagar__delivery">
              <p class="carrito-compras__pagar__delivery__title">DELIVERY</p>
              <p class="carrito-compras__pagar__delivery__subtitle">(Por lanzamiento, el costo de envío es gratuito)</p>
              <div class="carrito-compras__pagar__delivery__icon">
                <i class="fas fa-motorcycle"></i>
              </div>
              <p class="carrito-compras__pagar__delivery__fecha">martes 14 de julio de 2020</p>
            </div>
            <p class="carrito-compras__frase">#AUnClicDeTuSalud</p>
            <input class="button-submit carrito-compras__submit" type="submit" value="PAGAR">
            <a href=""></a>
          </div>
        </div>
      </div>
    </section>
  </main>
<%@ include file="snippets/footer.jsp" %>
</body>

</html>