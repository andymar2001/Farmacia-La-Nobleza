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


@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory daoFactory=DAOFactory.getDaoFactory(DAOFactory.MYSQL);
	 
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
 	   System.out.println(usuario.getPassword());
 	   int b=dao.UpdateUsuario(usuario);
 	   
 	   
 	   if(b==1) {
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
