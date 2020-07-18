<%@ include file="snippets/head.jsp" %>
<%@page import="entities.Producto"%>
<%@page import="java.util.List"%>
<title>Inicio - Farmacia La Nobleza aqui estuvo ericson</title>

</head>

<body>
<%@ include file="snippets/header.jsp" %>


  <div class="banner">
    <figure>
      <img src="assets/img/banner1.jpg" alt="descripccion imagen">
    </figure>
    <figure>
      <img src="assets/img/banner2.jpg" alt="descripccion imagen">
    </figure>
    <figure>
      <img src="assets/img/banner3.jpg" alt="descripccion imagen">
    </figure>
  </div>

  <main class="main">

    <section class="runway section">
      <div class="runway__container container">
        <h2 class="runway__title title">Los Más Vendidos</h2>
        <div class="slider-card">
          <div class="slider-card__prev">
            <i class="fas fa-chevron-left"></i>
          </div>
          
          <div class="slider-card__slider">
         
          <% List<Producto> listSubject = (List<Producto>) request.getAttribute("productos");
			if(listSubject != null){
				for(Producto subjectItem: listSubject){%>
            <article class="card">
              <figure class="card__image">
                <img src="assets/img/producto.jpg" alt="producto">
              </figure>
              
              <div class="card__data">
                <h3 class="card__title"><%=subjectItem.getNom_producto() %></h3>
                <p class="card__price"><%=subjectItem.getPrecio_pro() %></p>
                <a href="#" class="button card__button"><i class="fas fa-plus-circle"></i><span>Ver Detalles</span></a>
                <a href="<%=(activeSession!=null)? "carrito-compras.jsp":"login.jsp" %>" class="button card__button"><i class="fas fa-cart-plus"></i><span>Agregar Al Carrito</span></a>
              </div>
            </article>
            <article class="card">
              <figure class="card__image">
                <img src="assets/img/producto.jpg" alt="producto">
              </figure>
              <div class="card__data">
                <h3 class="card__title"><%=subjectItem.getNom_producto() %></h3>
                <p class="card__price"><%=subjectItem.getPrecio_pro() %></p>
                <a href="#" class="button card__button"><i class="fas fa-plus-circle"></i><span>Ver Detalles</span></a>
                <a href="<%=(activeSession!=null)? "carrito-compras.jsp":"login.jsp" %>" class="button card__button"><i class="fas fa-cart-plus"></i><span>Agregar Al Carrito</span></a>
              </div>
            </article>
            <article class="card">
              <figure class="card__image">
                <img src="assets/img/producto.jpg" alt="producto">
              </figure>
              <div class="card__data">
                <h3 class="card__title"><%=subjectItem.getNom_producto() %></h3>
                <p class="card__price"><%=subjectItem.getPrecio_pro() %></p>
                <a href="#" class="button card__button"><i class="fas fa-plus-circle"></i><span>Ver Detalles</span></a>
                <a href="<%=(activeSession!=null)? "carrito-compras.jsp":"login.jsp" %>" class="button card__button"><i class="fas fa-cart-plus"></i><span>Agregar Al Carrito</span></a>
              </div>
            </article>
            <article class="card">
              <figure class="card__image">
                <img src="assets/img/producto.jpg" alt="producto">
              </figure>
              <div class="card__data">
                <h3 class="card__title"><%=subjectItem.getNom_producto() %></h3>
                <p class="card__price"><%=subjectItem.getPrecio_pro() %></p>
                <a href="#" class="button card__button"><i class="fas fa-plus-circle"></i><span>Ver Detalles</span></a>
                <a href="<%=(activeSession!=null)? "carrito-compras.jsp":"login.jsp" %>" class="button card__button"><i class="fas fa-cart-plus"></i><span>Agregar Al Carrito</span></a>
              </div>
            </article>
            <article class="card">
              <figure class="card__image">
                <img src="assets/img/producto.jpg" alt="producto">
              </figure>
              <div class="card__data">
                <h3 class="card__title"><%=subjectItem.getNom_producto() %></h3>
                <p class="card__price"><%=subjectItem.getPrecio_pro() %></p>
                <a href="#" class="button card__button"><i class="fas fa-plus-circle"></i><span>Ver Detalles</span></a>
                <a href="<%=(activeSession!=null)? "carrito-compras.jsp":"login.jsp" %>" class="button card__button"><i class="fas fa-cart-plus"></i><span>Agregar Al Carrito</span></a>
              </div>
            </article>
            
              <%}}%>
          </div>
          <div class="slider-card__next">
            <i class="fas fa-chevron-right"></i>
          </div>
        </div>
      </div>
    </section>
    <section class="runway section">
      <div class="runway__container container">
        <h2 class="runway__title title">Los Más Vistos</h2>
        <div class="slider-card">
          <div class="slider-card__prev">
            <i class="fas fa-chevron-left"></i>
          </div>
          <div class="slider-card__slider">
            <article class="card">
              <figure class="card__image">
                <img src="assets/img/producto.jpg" alt="producto">
              </figure>
              <div class="card__data">
                <h3 class="card__title">Panadol Antigripal x 1 Sobre (2 tabletas)</h3>
                <p class="card__price">2.30</p>
                <a href="#" class="button card__button"><i class="fas fa-plus-circle"></i><span>Ver Detalles</span></a>
                <a href="<%=(activeSession!=null)? "carrito-compras.jsp":"login.jsp" %>" class="button card__button"><i class="fas fa-cart-plus"></i><span>Agregar Al Carrito</span></a>
              </div>
            </article>
            <article class="card">
              <figure class="card__image">
                <img src="assets/img/producto.jpg" alt="producto">
              </figure>
              <div class="card__data">
                <h3 class="card__title">Panadol Antigripal x 1 Sobre (2 tabletas)</h3>
                <p class="card__price">2.30</p>
                <a href="#" class="button card__button"><i class="fas fa-plus-circle"></i><span>Ver Detalles</span></a>
                <a href="<%=(activeSession!=null)? "carrito-compras.jsp":"login.jsp" %>" class="button card__button"><i class="fas fa-cart-plus"></i><span>Agregar Al Carrito</span></a>
              </div>
            </article>
            <article class="card">
              <figure class="card__image">
                <img src="assets/img/producto.jpg" alt="producto">
              </figure>
              <div class="card__data">
                <h3 class="card__title">Panadol Antigripal x 1 Sobre (2 tabletas)</h3>
                <p class="card__price">2.30</p>
                <a href="#" class="button card__button"><i class="fas fa-plus-circle"></i><span>Ver Detalles</span></a>
                <a href="<%=(activeSession!=null)? "carrito-compras.jsp":"login.jsp" %>" class="button card__button"><i class="fas fa-cart-plus"></i><span>Agregar Al Carrito</span></a>
              </div>
            </article>
            <article class="card">
              <figure class="card__image">
                <img src="assets/img/producto.jpg" alt="producto">
              </figure>
              <div class="card__data">
                <h3 class="card__title">Panadol Antigripal x 1 Sobre (2 tabletas)</h3>
                <p class="card__price">2.30</p>
                <a href="#" class="button card__button"><i class="fas fa-plus-circle"></i><span>Ver Detalles</span></a>
                <a href="<%=(activeSession!=null)? "carrito-compras.jsp":"login.jsp" %>" class="button card__button"><i class="fas fa-cart-plus"></i><span>Agregar Al Carrito</span></a>
              </div>
            </article>
            <article class="card">
              <figure class="card__image">
                <img src="assets/img/producto.jpg" alt="producto">
              </figure>
              <div class="card__data">
                <h3 class="card__title">Panadol Antigripal x 1 Sobre (2 tabletas)</h3>
                <p class="card__price">2.30</p>
                <a href="#" class="button card__button"><i class="fas fa-plus-circle"></i><span>Ver Detalles</span></a>
                <a href="<%=(activeSession!=null)? "carrito-compras.jsp":"login.jsp" %>" class="button card__button"><i class="fas fa-cart-plus"></i><span>Agregar Al Carrito</span></a>
              </div>
            </article>
          </div>
          <div class="slider-card__next">
            <i class="fas fa-chevron-right"></i>
          </div>
        </div>
      </div>
    </section>

  </main>

<%@ include file="snippets/footer.jsp" %>
</body>

</html>