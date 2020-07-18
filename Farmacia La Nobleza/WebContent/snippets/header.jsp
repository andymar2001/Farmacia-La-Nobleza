<%@page import="utils.Constantes"%>
<header class="header">
  <h1 class="ocultar">Farmacia La Nobleza</h1>
  <div class="header__container">
    <div class="header__top">
      <div class="header__top__container container">
        <div class="header__top__data">
          <a class="header__delivery" href="tel:922755337" target="_blank">
            <i class="fas fa-motorcycle"></i>
            <p>Delivery: <span>(044)123456</span></p>
          </a>
          <div class="header__redes">
            <a class="header__icon" href="#" target="_blank">
              <i class="fab fa-whatsapp"></i>
            </a>
            <a class="header__icon" href="#" target="_blank">
              <i class="fab fa-facebook-square"></i>
            </a>
            <a class="header__icon" href="#" target="_blank">
              <i class="fab fa-instagram"></i>
            </a>
          </div>
        </div>
        <div class="header__top__user">
        <%	Boolean activeSession=(Boolean) session.getAttribute(Constantes.LOGIN);
     		if(activeSession==null || activeSession==false){%>
          <a href="registro-usuario.jsp">
            <p>Registrarme</p>
          </a>
          <a href="login.jsp">
            <i class="fas fa-sign-in-alt"></i>
            <p>Iniciar Sesión</p>
          </a>
          <%}else{ String nombreUs = (String) session.getAttribute(Constantes.NOMBRE_US); %>
          <a href="registro-usuario.jsp">
            <i class="far fa-user-circle"></i>
            <p>Mi Perfil - <%=nombreUs.toUpperCase() %></p>
          </a>
          <a href="LoginServlet?type=logout" onclick="return confirm('Está seguro que desea Salir??')">
            <i class="fas fa-power-off"></i>
            <p>Salir</p>
          </a>
          <%} %>
        </div>
      </div>


    </div>
    <div class="header__center">
      <div class="header__center__container container">
        <figure class="header__logo">
          <a href="index.jsp">
            <img src="assets/img/logoFarmacia.png" alt="logo farmacia">
          </a>
        </figure>
        <nav class="header__nav">
          <ul class="main-menu">
            <li class="main-menu__item"><a href="ProductoServlet?cat=0">Inicio</a></li>
            <li class="main-menu__item"><a href="conocenos.jsp">Conócenos</a></li>
            <li class="main-menu__item"><a href="servicios.jsp">Servicios</a></li>
            <li class="main-menu__item"><a href="ProductoServlet?cat=0">Productos</a></li>
            <li class="main-menu__item"><a href="contacto.jsp">Contáctanos</a></li>
          </ul>
          <form class="header__nav__form" action="">
            <input type="text" name="" id="">
            <button><i class="fas fa-search"></i></button>
          </form>
        </nav>
      </div>
    </div>
    <div class="header__bottom">
      <div class="header__bottom__container">
        <div class="header__category">
          <i class="fas fa-home"></i>
          <p><a href="ProductoServlet?cat=1">HOGAR</a></p>
        </div>
        <div class="header__category">
          <i class="fas fa-pills"></i>
          <p><a href="ProductoServlet?cat=2">VITAMINAS Y SUPLEMENTOS</a></p>
        </div>
        <div class="header__category">
          <i class="fas fa-baby-carriage"></i>
          <p><a href="ProductoServlet?cat=3">INFANTIL Y MATERNIDAD</a></p>
        </div>
        <div class="header__category">
          <i class="fas fa-briefcase-medical"></i>
          <p><a href="ProductoServlet?cat=4">MEDICINA Y ORTOPEDIA</a></p>
        </div>
        <div class="header__category">
          <i class="fas fa-pump-medical"></i>
          <p><a href="ProductoServlet?cat=4">CUIDADO PERSONAL</a></p>
        </div>
        <div class="header__category">
          <i class="fas fa-head-side-mask"></i>
          <p>PROTECCIÓN COVID-19</p>
        </div>
      </div>
    </div>
  </div>
</header>