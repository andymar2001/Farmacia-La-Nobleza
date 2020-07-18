package utils;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import dao.DAOFactory;
import entities.Producto;
import interfaces.ProductoModelInterface;

public class TagProductosIndex extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	public String top;
	String carrito="carrito-compras.jsp";
	String login="login.jsp";
	
	
	@Override
	public int doStartTag() throws JspException {
		
		
		JspWriter out= pageContext.getOut();
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		ProductoModelInterface modeloInterface=daoFactory.getProducto();	
		
		try {
			
			List<Producto> listadoList=modeloInterface.ListadoTagEconomico(top);
			for(Producto producto:listadoList) {
			out.print("<article class='card'>");
			out.print("<figure class='card__image'>");
			out.print("<img src='assets/img/producto.jpg' alt='producto'>");
			out.print("</figure>");
			out.print("<div class='card__data'>");
			out.print("<h3 class='card__title'>"+producto.getNom_producto()+"</h3>");
			out.print("<p class='card__price'>"+producto.getPrecio_pro()+"</p>");
			out.print("<a href='#' class='button card__button'><i class='fas fa-plus-circle'></i><span>Ver Detalles</span></a>");
			out.print("<a href='login.jsp' class='button card__button'><i class='fas fa-cart-plus'></i><span>Agregar Al Carrito</span></a>");
			out.print("</div>");
			out.print("</article>");
			}
		} catch (Exception e) {
			System.out.println("Horror en el tag: "+e.getMessage());
		}
		
		return super.doStartTag();
	}



	public String getTop() {
		return top;
	}



	public void setTop(String top) {
		this.top = top;
	}
	
	
	
}
