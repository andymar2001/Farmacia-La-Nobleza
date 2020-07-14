<%@ include file="snippets/head.jsp" %>
<title>Login - Farmacia La Nobleza</title>

</head>

<body>
<%@ include file="snippets/header.jsp" %>

  <main class="main">
    <section class="login section">
      <div class="login__container container">
        <h2 class="login__title title">Iniciar Sesión</h2>
        <form class="login__form" action="" method="POST" id="form-login">
          <div>
            <input class="input" type="text" name="usuario" id="usuario-login" placeholder="Usuario">
          </div>
          <div>
            <input class="input" type="password" name="contrasena" id="contrasena-login" placeholder="Contraseña">
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
<script type="text/javascript">

	$(document).ready(function(){
		
	$('#form-login').bootstrapValidator({
		fields:{
			usuario:{
				validators:{
					notEmpty:{
                        message: "El USUARIO es OBLIGATORIO para iniciar sesión"
                    },
                    stringLength:{
                        min: 8,
                        max: 8,
                        message:"El USUARIO es su DNI"
                    }
				}
			},
			contrasena:{
				validators:{
					notEmpty:{
                        message: "La CONTRASEÑA es OBLIGATORIA para iniciar sesión"
                    }
				}
			}
		}
	  });
	$('#btn-login').click(function() {
        $('#form-login').bootstrapValidator('validate');
        
     });
	
	});

</script>
</body>

</html>