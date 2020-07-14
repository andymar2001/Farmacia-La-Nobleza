<%@ include file="snippets/head.jsp" %>
<title>Registro Usuario - Farmacia La Nobleza</title>

</head>

<body>
  <%@ include file="snippets/header.jsp" %>

  <main class="main">
    <section class="registro-usuario section">
      <div class="registro-usuario__container container">
        <h2 class="registro-usuario__title title">Registro</h2>
        
        <form class="form registro-usuario__form" action="UsuarioServlet" method="post" id="form-register-user">
        <input type="hidden" name="type" value="registrar">
          
          <div class="form-group">
            <input class="input" type="text" name="nombres" id="nombres-user" placeholder="Nombres" required>
          </div>
          
          
          <div>
            <input class="input" type="text" name="apellidos" id="apellidos-user" placeholder="Apellidos">
          </div>
          
          <div>
            <input class="input" type="text" name="dni" id="dni-user" placeholder="Dni">
          </div>
          
          <div>
            <input class="input" type="text" name="celular" id="celular-user" placeholder="Celular" maxlength="9">
          </div>
          
          <div>
            <input class="input" type="text" name="telefono" id="telefono-user" placeholder="Telefono" maxlength="9">
          </div>
          
          <div>
            <input class="input" type="email" name="correo" id="correo-user" placeholder="Correo">
          </div>
          
            <div>
            <input class="input" type="text" name="fecha" id="fecha-user" placeholder="fecha">
          </div>
          
          <div>
            <input class="input" type="password" name="contraseña" id="contraseña-user" placeholder="Contraseña (Minimo 6 caracteres)">
          </div>
          
          
          <div>
            <div>
              <input class="button-submit" type="submit" name="register" value="Registrarme">
            </div>
          </div>
        </form>
      </div>

    </section>
  </main>
<%@ include file="snippets/footer.jsp" %>
</body>

</html>