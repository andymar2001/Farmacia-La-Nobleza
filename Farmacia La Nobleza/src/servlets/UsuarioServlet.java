package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entities.Usuario;
import interfaces.UsuarioModelInterface;
import utils.Constantes;
import utils.session;


@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory daoFactory=DAOFactory.getDaoFactory(DAOFactory.MYSQL);
	session saveSession=new session();
	 
	 UsuarioModelInterface dao=daoFactory.getUsuarioModel();
    
    public UsuarioServlet() {
        super();
        
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String tipo=request.getParameter("type");
    	
    		if(tipo.equals("registrar")) {
    		registrar(request,response);
    		}else if(tipo.equals("listarUsuarios")) {
    		listarRegistros(request,response);
    		}else if(tipo.equals("update")) {
    			updateUsuario(request,response);
    		}
    }
    
    public void listarRegistros(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{ 	 
    	 List<Usuario> data=dao.listarRegistro();
    	 request.setAttribute("data", data);
    	 request.getRequestDispatcher("/registro-usuario.jsp").forward(request, response);
    	
    }
    
    public void registrar(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

    	 Usuario usuario =new Usuario();
    	 
    	
    	   String dni=request.getParameter("dni");
    	   String nombre =request.getParameter("nombres");
    	   String apellido=request.getParameter("apellidos");
    	   String fecha=request.getParameter("fecha");
    	   String celular=request.getParameter("celular");
    	   String telefono=request.getParameter("telefono");
    	   String correo=request.getParameter("correo");
    	   String contraseña=request.getParameter("contrasena");
    	   
    	   usuario.setDni_usuario(dni);
    	   usuario.setNombre_usuario(nombre);
    	   usuario.setApellido_usuario(apellido);
    	   usuario.setFec_nac_usuario(fecha);
    	   usuario.setCelular_usuario(celular);
    	   usuario.setTelefono_usuario(telefono);
    	   usuario.setCorreo_usuario(correo);
    	   usuario.setPassword(contraseña);
    	   System.out.println(usuario.getPassword());
    	   if(dao.buscaXdni(dni)) {
    		   request.setAttribute("message", "Existe otro usuario con el mismo DNI");
    		   request.getRequestDispatcher("/registro-usuario.jsp").forward(request, response);
    	   }
    	   int b=dao.RegistroUsuario(usuario);
    	   
    	   
    	   if(b==1) {
    		   response.sendRedirect("login.jsp");
    	   }else {
    		   
    		   request.setAttribute("message", "No registro bien");
    		   request.getRequestDispatcher("/registro-usuario.jsp").forward(request, response);
    	   }
    	
    }
    
    
    public void updateUsuario(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    	
    	
    	Usuario usuario =new Usuario();
   	 
    	
 	   String dni=request.getParameter("dni");
 	   String nombre =request.getParameter("nombres");
 	   String apellido=request.getParameter("apellidos");
 	   String fecha=request.getParameter("fecha");
 	   String celular=request.getParameter("celular");
 	   String telefono=request.getParameter("telefono");
 	   String correo=request.getParameter("correo");
 	   String contraseña=request.getParameter("contrasena");
 	   
 	   usuario.setDni_usuario(dni);
 	   usuario.setNombre_usuario(nombre);
 	   usuario.setApellido_usuario(apellido);
 	   usuario.setFec_nac_usuario(fecha);
 	   usuario.setCelular_usuario(celular);
 	   usuario.setTelefono_usuario(telefono);
 	   usuario.setCorreo_usuario(correo);
 	   usuario.setPassword(contraseña);
 	   int b=dao.UpdateUsuario(usuario);
 	   
 	   
 	   if(b==1) {
 		   
 		   	saveSession.saveString(request, Constantes.DNI_US, usuario.getDni_usuario());
			saveSession.saveString(request, Constantes.NOMBRE_US, usuario.getNombre_usuario());
			saveSession.saveString(request, Constantes.APELLIDO_US, usuario.getApellido_usuario());
			saveSession.saveString(request, Constantes.FECHA_US, usuario.getFec_nac_usuario());
			saveSession.saveString(request, Constantes.CORREO_US, usuario.getCorreo_usuario());
			saveSession.saveString(request, Constantes.CONTRA_US, usuario.getPassword());
			saveSession.saveString(request, Constantes.CELULAR_US, usuario.getCelular_usuario());
			saveSession.saveString(request, Constantes.TELEFONO_US, usuario.getTelefono_usuario());
 		   	response.sendRedirect("index.jsp");
 	   }else {
 		   System.out.println("No registroooooooooo");
 		   request.setAttribute("message", "No registro bien");
 		   request.getRequestDispatcher("/registro-usuario.jsp").forward(request, response);
 	   }
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
