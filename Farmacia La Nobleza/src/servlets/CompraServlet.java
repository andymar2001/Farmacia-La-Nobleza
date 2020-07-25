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
    	String id = (String) req.getParameter("id");
    	double totalCarritoDouble=(double) 0;
    	int totalped=0;
    	String type= (String) req.getParameter("type");
    	List<Detalle_Compra> itemPedidoCompras=null;
    	if(type==null) {
    	if(id!=null) {
    	if(pedido!=null) {
    		
			modeloCarrito.addDetalle_Pedido(pedido.Id_Pedido,Integer.parseInt(id));
    		itemPedidoCompras=modeloCarrito.productoxpedido(pedido.Id_Pedido);
    		for(Detalle_Compra item:itemPedidoCompras) {
				totalCarritoDouble+=item.total_detalle_producto();
				totalped++;
			}
    		req.setAttribute("nropro",totalped);
    		req.setAttribute("total", totalCarritoDouble);
    		req.setAttribute("productosXpedido", itemPedidoCompras);
    		req.setAttribute("pedido", pedido);
    		req.getRequestDispatcher("carrito-compras.jsp").forward(req, resp);
    	}
    	else { 
			modeloCarrito.addPedido(dniString);
			Compra pedidonuevo=modeloCarrito.compraxusuario(dniString);
			modeloCarrito.addDetalle_Pedido(pedidonuevo.Id_Pedido,Integer.parseInt(id));
			itemPedidoCompras = modeloCarrito.productoxpedido(pedidonuevo.getId_Pedido());
			for(Detalle_Compra item:itemPedidoCompras) {
				totalCarritoDouble+=item.total_detalle_producto();
				totalped++;
			}
			req.setAttribute("nropro",totalped);
    		req.setAttribute("total", totalCarritoDouble);
			req.setAttribute("productosXpedido", itemPedidoCompras);
    		req.setAttribute("pedido", pedido);
    		req.getRequestDispatcher("carrito-compras.jsp").forward(req, resp);
		}}
    	else if(id==null) {
    		itemPedidoCompras=modeloCarrito.productoxpedido(pedido.Id_Pedido);
    		for(Detalle_Compra item:itemPedidoCompras) {
				totalCarritoDouble+=item.total_detalle_producto();
				totalped++;
			}
    		req.setAttribute("nropro",totalped);
    		req.setAttribute("total", totalCarritoDouble);
    		req.setAttribute("productosXpedido", itemPedidoCompras);
    		req.setAttribute("pedido", pedido);
    		req.getRequestDispatcher("carrito-compras.jsp").forward(req, resp);
    	}}
    	else if(type.equals("delete")) {
    		String idproString=req.getParameter("idpro");
    		String idpedString=req.getParameter("idped");
    		String dni =req.getParameter("dni");
			int flag =modeloCarrito.deleteDetalle(Integer.parseInt(idpedString),Integer.parseInt(idproString));
				if(flag==1) {
					resp.sendRedirect("CompraServlet?dni="+dni);
				}
		}
    	
    }
    


}
