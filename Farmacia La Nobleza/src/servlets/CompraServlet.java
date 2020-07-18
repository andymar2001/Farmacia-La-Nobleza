package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entities.Compra;
import entities.Detalle_Compra;
import interfaces.CarritoModelInterface;


@WebServlet("/CompraServlet")
public class CompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DAOFactory daoFactory=DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    CarritoModelInterface modeloCarrito=daoFactory.getPedido();

    public CompraServlet() {super();}

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String dniString =(String) req.getParameter("dni");
    	Compra pedido = modeloCarrito.compraxusuario(dniString);
    	List<Detalle_Compra> itemPedidoCompras=null;
    	if(pedido!=null) {
    		itemPedidoCompras=modeloCarrito.productoxpedido(pedido.Id_Pedido);
    		req.setAttribute("productosXpedido", itemPedidoCompras);
    		req.setAttribute("pedido", pedido);
    		req.getRequestDispatcher("carrito-compras.jsp").forward(req, resp);
    	}
    	else {   		
			modeloCarrito.addPedido(dniString);
			modeloCarrito.compraxusuario(dniString);
			req.setAttribute("productosXpedido", itemPedidoCompras);
    		req.setAttribute("pedido", pedido);
    		req.getRequestDispatcher("carrito-compras.jsp").forward(req, resp);
		}
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);}

}
