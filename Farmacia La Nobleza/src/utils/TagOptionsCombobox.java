package utils;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import dao.DAOFactory;
import entities.Categoria;
import interfaces.CategoriaModelInterface;

public class TagOptionsCombobox extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out=pageContext.getOut();
		
		DAOFactory daoFactory=DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		CategoriaModelInterface categoriaInterface=daoFactory.getListOptions();
		
		try {
			
			List<Categoria> listadoOptions=categoriaInterface.listOptions();
			
			for(Categoria categoria:listadoOptions) {
				out.print("<option value="+categoria.getId()+">"+categoria.getNombre()+"</option>");
			}
			
		} catch (Exception e) {
			System.out.println("error en tag listoptions "+e.getMessage());
		}
		
		return super.doStartTag();
	}

}
