package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entities.Producto;
import interfaces.ProductoModelInterface;


@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
	ProductoModelInterface modeloProducto=daoFactory.getProducto();

    public ProductoServlet() {super();}
   
    protected void service2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	List<Producto> listaProductos=null;
    	
    	int categoria=Integer.parseInt(request.getParameter("cat2"));
    	
    	if(categoria!=0) {
    		
    		listaProductos=modeloProducto.listadoProductosxCategoria(categoria);
    		
    	}else {
    		listaProductos=modeloProducto.listadoProductos();
    	}
    	
    	request.setAttribute("productos2", listaProductos);
    	request.getRequestDispatcher("index.jsp").forward(request, response);
    	
    }
    
   
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	List<Producto> listaProductos=null;
    	
    	int categoria=Integer.parseInt(request.getParameter("cat"));
    	
    	if(categoria!=0) {
    		
    		listaProductos=modeloProducto.listadoProductosxCategoria(categoria);
    		
    	}else {
    		listaProductos=modeloProducto.listadoProductos();
    	}
    	
    	request.setAttribute("productos", listaProductos);
    	request.getRequestDispatcher("index.jsp").forward(request, response);
    	
    }
    
    
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);}

}
