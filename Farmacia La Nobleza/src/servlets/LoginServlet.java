package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entities.Usuario;
import interfaces.LoginModelInterface;
import utils.Constantes;
import utils.CookiesSave;
import utils.session;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DAOFactory daoFactory= DAOFactory.getDaoFactory(DAOFactory.MYSQL);
	session saveSession = new session();
	CookiesSave cookiesSave=new CookiesSave();

    public LoginServlet() {super();}


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String type=request.getParameter("type");
    	if(type.equals("login")) {
    		
    		String dni =request.getParameter("usuario");
    		String contra =request.getParameter("contrasena");
    		
    		LoginModelInterface login=daoFactory.getLogin();
    		
    		if(request.getParameter("checkRemember")!=null) {
    			cookiesSave.saveCookie(response, Constantes.COOKIE_DNI,dni);
    		}else {
				cookiesSave.deleteCookie(response, Constantes.COOKIE_DNI);
			}
    		
    		Usuario usuario=login.loginOn(dni, contra);
    		
    		if(usuario!=null) {
    			
    			if(!usuario.getEstado_usuario().equals("I")) {
    			
    			saveSession.saveBoolean(request, Constantes.LOGIN, true);
    			saveSession.saveString(request, Constantes.DNI_US, usuario.getDni_usuario());
    			saveSession.saveString(request, Constantes.ESTADO_US, usuario.getEstado_usuario());
    			saveSession.saveString(request, Constantes.NOMBRE_US, usuario.getNombre_usuario());
    			saveSession.saveString(request, Constantes.APELLIDO_US, usuario.getApellido_usuario());
    			saveSession.saveString(request, Constantes.FECHA_US, usuario.getFec_nac_usuario());
    			saveSession.saveString(request, Constantes.CORREO_US, usuario.getCorreo_usuario());
    			saveSession.saveString(request, Constantes.CONTRA_US, usuario.getPassword());
    			saveSession.saveString(request, Constantes.CELULAR_US, usuario.getCelular_usuario());
    			saveSession.saveString(request, Constantes.TELEFONO_US, usuario.getTelefono_usuario());
    			saveSession.saveInt(request, Constantes.ROL_US, usuario.getTipo_us());
    			
    			response.sendRedirect("index.jsp");
    			}else {
    				request.setAttribute("msj", "Usuario INACTIVO, comuníquese con nosotros para solucionar este problema");
        			request.getRequestDispatcher("login.jsp").forward(request, response);
    			}
    			
    		}else {
    			request.setAttribute("msj", "Error usuario y/o clave");
    			request.getRequestDispatcher("login.jsp").forward(request, response);
    		}
    		
    	}else if(type.equals("logout")) {
    		saveSession.invalidateSession(request);
    		response.sendRedirect("index.jsp");
    	}
    	
    }
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
