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
    	String id = (String) req.getParameter("id");
    	String type= (String) req.getParameter("type");
    	List<Detalle_Compra> itemPedidoCompras=null;
    	Compra pedido = modeloCarrito.compraxusuario(dniString);
    	double totalCarritoDouble=(double) 0;
		int totalped=0;
    	if(type!=null &&type.equals("delete")) {
    		String idproString=req.getParameter("idpro");
    		String idpedString=req.getParameter("idped");
    		String dni =req.getParameter("dni");
			int flag =modeloCarrito.deleteDetalle(Integer.parseInt(idpedString),Integer.parseInt(idproString));
				if(flag==1) {
					resp.sendRedirect("CompraServlet?dni="+dni);
				}
    	}else if(dniString!=null) {
    		if(id!=null) {
    			if(pedido!=null) {
        			itemPedidoCompras=modeloCarrito.productoxpedido(pedido.getId_Pedido());
        			for(Detalle_Compra items:itemPedidoCompras) {
        				if(items.getId_producto()==Integer.parseInt(id)) {
        					modeloCarrito.updateCantidadDetalle(pedido.getId_Pedido(), Integer.parseInt(id), items.getCantidad()+1);
        					System.out.println("llego para upadatear");
        					break;
        				}else {
        					modeloCarrito.addDetalle_Pedido(pedido.Id_Pedido,Integer.parseInt(id));
        					break;
        				}
        			}        			
        			itemPedidoCompras=modeloCarrito.productoxpedido(pedido.getId_Pedido());
        			for(Detalle_Compra item:itemPedidoCompras) {
        				totalCarritoDouble+=item.total_detalle_producto();
        				totalped++;
        			}
            		req.setAttribute("nropro",totalped);
            		req.setAttribute("total", totalCarritoDouble);
            		req.setAttribute("productosXpedido", itemPedidoCompras);
            		req.setAttribute("pedido", pedido);
            		req.getRequestDispatcher("carrito-compras.jsp").forward(req, resp);
        		}else {
        			modeloCarrito.addPedido(dniString);
        			pedido=modeloCarrito.compraxusuario(dniString);
        			modeloCarrito.addDetalle_Pedido(pedido.getId_Pedido(), Integer.parseInt(id));
        			itemPedidoCompras=modeloCarrito.productoxpedido(pedido.getId_Pedido());
        			for(Detalle_Compra item:itemPedidoCompras) {
        				totalCarritoDouble+=item.total_detalle_producto();
        				totalped++;
        			}
        		}
    		}else {
    		pedido = modeloCarrito.compraxusuario(dniString);
    		itemPedidoCompras=modeloCarrito.productoxpedido(pedido.getId_Pedido());
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
    	}else if(type!=null && type.equals("addtag")) {
    		String idtagString=(String) req.getParameter("idtag");
    		req.setAttribute("idtag",idtagString);
    		req.getRequestDispatcher("carrito-compras.jsp").forward(req, resp);
    		
    	}
    	/*    	
    	
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
    	}}*/
    	
    }
    


}
