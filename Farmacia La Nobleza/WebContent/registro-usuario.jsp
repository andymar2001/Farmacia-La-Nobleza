<%@ include file="snippets/head.jsp" %>
<% Boolean activeSessionHead=(Boolean) session.getAttribute(Constantes.LOGIN); %>
<title><%=(activeSessionHead!=null)? "Mi perfil - Farmacia la Nobleza":"Registro Usuario - Farmacia La Nobleza"%></title>

</head>

<body>
  <%@ include file="snippets/header.jsp" %>
<%	String nombres=(String) session.getAttribute(Constantes.NOMBRE_US); 
	String apellidos=(String) session.getAttribute(Constantes.APELLIDO_US);
	String dni=(String) session.getAttribute(Constantes.DNI_US);
	String celular=(String) session.getAttribute(Constantes.CELULAR_US);
	String telefono=(String) session.getAttribute(Constantes.TELEFONO_US);
	if(telefono==null||telefono.equals("")||telefono.length()==0)
		telefono="-";
	String correo = (String) session.getAttribute(Constantes.CORREO_US);
	String fecha=(String) session.getAttribute(Constantes.FECHA_US);
	String contrasena=(String) session.getAttribute(Constantes.CONTRA_US);%>
  <main class="main">
    <section class="registro-usuario section">
      <div class="registro-usuario__container container">
        <h2 class="registro-usuario__title title"><%=(activeSession!=null)? "Mi Perfil":"Registro"%></h2>
        
        <form class="form registro-usuario__form" action="UsuarioServlet" method="post" id="form-register-user">
        <input type="hidden" name="type" value="<%=(activeSession!=null)? "update":"registrar" %>">
          
          <div class="form-group">
          	<label class="label" for="nombres-user">Nombres:</label>
            <input class="input" type="text" name="nombres" id="nombres-user" placeholder="Nombres" value="<%=(activeSession!=null)? nombres:""%>">
          </div>     
          <div>
          	<label class="label" for="apellidos-user">Apellidos:</label>
            <input class="input" type="text" name="apellidos" id="apellidos-user" placeholder="Apellidos" value="<%=(activeSession!=null)? apellidos:""%>">
          </div>
          
          <div class="<%=(activeSession!=null)? "ocultar":"form-group" %>">
          	<label class="label" for="dni-user">Dni:</label>
            <input class="input" type="text" name="dni" id="dni-user" placeholder="Dni" value="<%=(activeSession!=null)? dni:""%>" >
          </div>
          
          <div>
          	<label class="label" for="celular-user">Celular:</label>
            <input class="input" type="text" name="celular" id="celular-user" placeholder="Celular" maxlength="9" value="<%=(activeSession!=null)? celular:""%>">
          </div>
          
          <div>
          	<label class="label" for="telefono-user">Telefono:</label>
            <input class="input" type="text" name="telefono" id="telefono-user" placeholder="Telefono" maxlength="9" value="<%=(activeSession!=null)? telefono:""%>">
          </div>
          
          <div>
          	<label class="label" for="correo-user">Correo:</label>
            <input class="input" type="email" name="correo" id="correo-user" placeholder="Correo" value="<%=(activeSession!=null)? correo:""%>">
          </div>
          
          <div>
         	 <label class="label" for="fecha-user">Fecha Nacimiento:</label>
            <input class="input" type="date" name="fecha" id="fecha-user" placeholder="fecha" value="<%=(activeSession!=null)? fecha:""%>">
          </div>
          
          <div>
          	<label class="label" for="contraseña-user">Contraseña:</label>
            <input class="input" type="password" name="contrasena" id="contrasena-user" placeholder="Contraseña (Minimo 6 caracteres)" value="<%=(activeSession!=null)? contrasena:""%>">
          </div>
          <div>
            <div>
              <input class="button-submit" type="submit" name="register" value="<%=(activeSession!=null)? "Actualizar Perfil":"Registrarme"%>">
            </div>
          </div>
        </form>
      </div>

    </section>
  </main>
<%@ include file="snippets/footer.jsp" %>
</body>

</html>