package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.management.modelmbean.RequiredModelMBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entities.Usuario;
import interfaces.UsuarioModelInterface;
import model.UsuarioModel;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UsuarioServlet() {
        super();
        
    }
    
    protected void Verfica(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    	
    	String tipo=request.getParameter("type");
    	
    	if(tipo.equals("registrar")) {
    		registrar(request,response);
    	}else {
    		listarRegistros(request,response);
    	}
    }
    
    protected void listarRegistros(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    	 DAOFactory daoFactory=DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    	 
    	 UsuarioModelInterface dao=daoFactory.getUsuarioModel();
    	 
    	 List<Usuario> data=dao.listarRegistro();
    	 request.setAttribute("data", data);
    	 request.getRequestDispatcher("/registro-usuario.jsp").forward(request, response);
    	
    }
    
    protected void registrar(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    	 
    	DAOFactory daoFactory=DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    	 UsuarioModelInterface dao=daoFactory.getUsuarioModel();
    	 Usuario usuario =new Usuario();
    	 
    	
    	   String dni=request.getParameter("dni");
    	   String nombre =request.getParameter("nombres");
    	   String apellido=request.getParameter("apellidos");
    	   String fecha=request.getParameter("fecha");
    	   String celular=request.getParameter("celular");
    	   String telefono=request.getParameter("telefono");
    	   String correo=request.getParameter("correo");
    	   String contraseña=request.getParameter("contraseña");
    	   
    	   usuario.setDni_usuario(dni);
    	   usuario.setNombre_usuario(nombre);
    	   usuario.setApellido_usuario(apellido);
    	   usuario.setFec_nac_usuario(fecha);
    	   usuario.setCelular_usuario(celular);
    	   usuario.setTelefono_usuario(telefono);
    	   usuario.setCorreo_usuario(correo);
    	   usuario.setPassword(contraseña);
    	   
    	   int b=dao.RegistroCompra(usuario);
    	   
    	   if(b==1) {
    		   listarRegistros(request,response);
    		   request.getRequestDispatcher("/registro-usuario.jsp").forward(request, response);
    	   }else {
    		   request.setAttribute("message", "No registro bein xd");
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
