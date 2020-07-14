<%@ include file="snippets/head.jsp" %>

<title>Login - Farmacia La Nobleza</title>

</head>

<body>
<%@ include file="snippets/header.jsp" %>
<% 	  			//1. Listado de Cookies 
		  		Cookie[] saveCoookie = request.getCookies();
		  		String dnilCookie = null;
		  		if(saveCoookie.length!=0)
		  		//2.Recorrer la lista de cookies 
		  		for(int i=0; i < saveCoookie.length; i++){
		  			//3.Validar si el cookie existe 
		  			if(saveCoookie[i].getName().equals(Constantes.COOKIE_DNI)){
		  				dnilCookie = saveCoookie[i].getValue();
		  			}
		  		}%>
  <main class="main">
    <section class="login section">
      <div class="login__container container">
        <h2 class="login__title title">Iniciar Sesión</h2>
        <form class="login__form" action="LoginServlet" method="POST" id="form-login">
        	<input type="hidden" name="type" value="login">
          <div>
            <input class="input" type="text" name="usuario" id="usuario-login" placeholder="Usuario" value="<%=(dnilCookie!=null)? dnilCookie:""%>">
          </div>
          <div>
            <input class="input" type="password" name="contrasena" id="contrasena-login" placeholder="Contraseña">
          </div>         
          <div>
            <input type="checkbox" name="checkRemember" value="checkRemember">
		    <label class="form-check-label">Recordar usuario</label>
          </div>
          <div>
            <div>
              <input class="button-submit" type="submit" name="login" value="Iniciar Sesión" id="btn-login">
            </div>
          </div>
        </form>
      </div>
    </section>
  </main>

<%@ include file="snippets/footer.jsp" %>
</body>

</html>