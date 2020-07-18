<%@ include file="snippets/head.jsp" %>
<%@page import="entities.Producto"%>
<%@page import="java.util.List"%>
<%@ taglib uri="etiquetaSlider" prefix="ts" %>
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
        <h2 class="runway__title title">Los Más Económicos</h2>
        <div class="slider-card">
          <div class="slider-card__prev">
            <i class="fas fa-chevron-left"></i>
          </div>
          
          <div class="slider-card__slider">
            <ts:tagBaratos top="5" />          
          </div>
          
          <div class="slider-card__next">
            <i class="fas fa-chevron-right"></i>
          </div>
        </div>
      </div>
    </section>
    <section class="runway section">
      <div class="runway__container container">
        <h2 class="runway__title title">Recomendados</h2>
        <div class="slider-card">
          <div class="slider-card__prev">
            <i class="fas fa-chevron-left"></i>
          </div>
          <div class="slider-card__slider">
            <ts:tagBaratos top="6" />
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