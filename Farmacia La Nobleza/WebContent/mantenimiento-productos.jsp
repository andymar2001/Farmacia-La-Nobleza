<%@ include file="snippets/head.jsp" %>
<title>Mantenimiento Productos - Farmacia La Nobleza</title>
</head>

<body>
<%@ include file="snippets/header.jsp" %>
  <main class="main">
    <section class="mantenimiento-productos section">
      <div class="mantenimiento-productos__container container">
        <h2 class="title">Mantenimiento Productos</h2>
        <form action="" method="POST" id="">
          <select class="mantenimiento-productos__combotop input" name="" id="">
            <option disabled selected>Escoger categoria</option>
            <option value="hogar">Hogar</option>
            <option value="medicina">Medicina</option>
          </select>
          <input class="mantenimiento-productos__submit button-submit" type="submit" value="CONSULTAR">
        </form>
        <table class="mantenimiento-productos__table table">
          <thead class="table__thead">
            <tr class="table__row">
              <th class="table__item">
                Nombre
              </th>
              <th class="table__item">
                Proveedor
              </th>
              <th class="table__item">
                Categoria
              </th>
              <th class="table__item">
                Unidad de medida
              </th>
              <th class="table__item">
                Precio unidad
              </th>
              <th class="table__item">
                Stock
              </th>
            </tr>
          </thead>
          <tbody class="table__body">
            <tr class="table__row">
              <th class="table__item">
                Panadol
              </th>
              <th class="table__item">
                Bayer
              </th>
              <th class="table__item">
                Medicina
              </th>
              <th class="table__item">
                12
              </th>
              <th class="table__item">
                S/<span>12</span>
              </th>
              <th class="table__item">
                18
              </th>
            </tr>
            <tr class="table__row">
              <th class="table__item">
                Panadol
              </th>
              <th class="table__item">
                Bayer
              </th>
              <th class="table__item">
                Medicina
              </th>
              <th class="table__item">
                12
              </th>
              <th class="table__item">
                S/<span>12</span>
              </th>
              <th class="table__item">
                18
              </th>
            </tr>
          </tbody>
        </table>
      </div>
    </section>
  </main>
<%@ include file="snippets/footer.jsp" %>
</body>

</html>