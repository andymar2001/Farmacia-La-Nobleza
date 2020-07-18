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
    
    
    
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	List<Producto> listaProductos=null;
    	String categoriaString="";
    	
    	int categoria=Integer.parseInt(request.getParameter("cat"));
    	
    	if(categoria!=0) {
    		
    		listaProductos=modeloProducto.listadoProductosxCategoria(categoria);
    		
    	}else {
    		listaProductos=modeloProducto.listadoProductos();
    	}
    	switch (categoria) {
		case 1:
			categoriaString="<div class='productos__top'>" + 
					"              <div class='productos__icon'>" + 
					"                <i class='fas fa-home'></i>" + 
					"              </div>" + 
					"              <h2 class='productos__title title'>"+"HOGAR"+"</h2>" + 
					"            </div>";
			break;
		case 2:
			categoriaString="<div class='productos__top'>" + 
					"              <div class='productos__icon'>" + 
					"                <i class='fas fa-pills'></i>" + 
					"              </div>" + 
					"              <h2 class='productos__title title'>"+"VITAMINAS Y SUPLEMENTOS"+"</h2>" + 
					"            </div>";
			break;
		case 3:
			categoriaString="<div class='productos__top'>" + 
					"              <div class='productos__icon'>" + 
					"                <i class='fas fa-baby-carriage'></i>" + 
					"              </div>" + 
					"              <h2 class='productos__title title'>"+"INFANTIL Y MATERNIDAD"+"</h2>" + 
					"            </div>";
			break;
		case 4:
			categoriaString="<div class='productos__top'>" + 
					"              <div class='productos__icon'>" + 
					"                <i class='ffas fa-briefcase-medical'></i>" + 
					"              </div>" + 
					"              <h2 class='productos__title title'>"+"MEDICINA Y ORTOPEDIA"+"</h2>" + 
					"            </div>";
			break;
		case 5:
			categoriaString="<div class='productos__top'>" + 
					"              <div class='productos__icon'>" + 
					"                <i class='fas fa-pump-medical'></i>" + 
					"              </div>" + 
					"              <h2 class='productos__title title'>"+"CUIDADO PERSONAL"+"</h2>" + 
					"            </div>";
			break;		
		default:
			categoriaString="<div class='productos__top'>" + 
					"              <h2 class='productos__title title'>"+"PRODUCTOS"+"</h2>" + 
					"            </div>";
			break;
		}
    	
    	request.setAttribute("productos", listaProductos);
    	request.setAttribute("categoria", categoriaString);
    	request.getRequestDispatcher("productos.jsp").forward(request, response);
    	
    }
    
    
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);}

}
