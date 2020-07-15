<%@ include file="snippets/head.jsp" %>
<title>Medicinas - Farmacia La Nobleza</title>

</head>

<body>
<%@ include file="snippets/header.jsp" %>
  <main class="main">
    <section class="productos section">
      <div class="productos__container container">
        <div class="productos__2fr">
          <div>
            <div class="productos__top">
              <div class="productos__icon">
                <i class="fas fa-home"></i>
              </div>
              <h2 class="productos__title title">HOGAR</h2>
            </div>
            <div class="productos__filtro">
              <div class="productos__filtro__item">
                <input type="checkbox" name="productos" id="aseo-limpieza">
                <label for="aseo-limpieza">Aseo y limpieza</label>
              </div>
              <div class="productos__filtro__item">
                <input type="checkbox" name="productos" id="botellas-tomatodos">
                <label for="botellas-tomatodos">Botellas y tomatodos</label>
              </div>
              <div class="productos__filtro__item">
                <input type="checkbox" name="productos" id="teletrabajo">
                <label for="teletrabajo">Teletrabajo</label>
              </div>
            </div>
          </div>
          <div>
            <figure>
              <img src="assets/img/banner-productos.jpg" alt="">
            </figure>
            <div class="productos__flex">
              <select class="input" name="" id="">
                <option disabled selected>Ordenar por:</option>
                <option value="item 1">Precio de mayor a menor</option>
                <option value="item 2">Precio de menor a mayor</option>
                <option value="item 3">Ordenar de letra A hasta la Z</option>
                <option value="item 3">Ordenar de letra Z hasta la A</option>
              </select>
              <p class="productos__frase title">#AUnClicDeTuSalud</p>
            </div>
            <div class="productos__grid">
              <article class="card">
                <figure class="card__image">
                  <img src="assets/img/productos.jpg" alt="producto">
                </figure>
                <div class="card__data">
                  <h3 class="card__title">ACEITE DE COCO EXTRA VIRGEN X 250 ML</h3>
                  <p class="card__price">27.00</p>
                  <a href="#" class="button card__button"><i class="fas fa-plus-circle"></i><span>Ver Detalles</span></a>
                  <p class="button card__button"><i class="fas fa-cart-plus"></i><span>Agregar Al Carrito</span></p>
                </div>
              </article>
              <article class="card">
                <figure class="card__image">
                  <img src="assets/img/productos.jpg" alt="producto">
                </figure>
                <div class="card__data">
                  <h3 class="card__title">ACEITE DE COCO EXTRA VIRGEN X 250 ML</h3>
                  <p class="card__price">27.00</p>
                  <a href="#" class="button card__button"><i class="fas fa-plus-circle"></i><span>Ver Detalles</span></a>
                  <p class="button card__button"><i class="fas fa-cart-plus"></i><span>Agregar Al Carrito</span></p>
                </div>
              </article>
              <article class="card">
                <figure class="card__image">
                  <img src="assets/img/productos.jpg" alt="producto">
                </figure>
                <div class="card__data">
                  <h3 class="card__title">ACEITE DE COCO EXTRA VIRGEN X 250 ML</h3>
                  <p class="card__price">27.00</p>
                  <a href="#" class="button card__button"><i class="fas fa-plus-circle"></i><span>Ver Detalles</span></a>
                  <p class="button card__button"><i class="fas fa-cart-plus"></i><span>Agregar Al Carrito</span></p>
                </div>
              </article>
            </div>
          </div>
        </div>

      </div>
    </section>
  </main>
<%@ include file="snippets/footer.jsp" %>
</body>

</html>