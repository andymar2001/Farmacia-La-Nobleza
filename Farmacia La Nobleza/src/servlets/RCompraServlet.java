package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entities.Boleta;
import entities.Compra;
import entities.Detalle_Compra;
import interfaces.CarritoModelInterface;

/**
 * Servlet implementation class RCompraServlet
 */
@WebServlet("/RCompraServlet")
public class RCompraServlet extends HttpServlet {
	
	DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
	CarritoModelInterface modeloCarritoModelInterface=daoFactory.getPedido();
	
	private static final long serialVersionUID = 1L;
    public RCompraServlet() {super();}

    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    			String idpedidoString=(String) req.getParameter("idpedido");
    			String tipoEntrega=(String) req.getParameter("tipoEntrega");
    			String fechaEnvio=(String) req.getParameter("fechaEntrega");
    			String direccionString=(String) req.getParameter("direccion");
    			String ciudadString=(String) req.getParameter("ciudad");
    			String regioString=(String) req.getParameter("ciudad");
    			Compra compra=modeloCarritoModelInterface.compraXID(Integer.parseInt(idpedidoString));
    			compra.setEnvio(tipoEntrega);
    			compra.setFechaEnvio(fechaEnvio);
    			compra.setDireccionDestinatario(direccionString);
    			compra.setCiudadDestinatario(ciudadString);
    			compra.setRegionDestinatario(regioString);
    			if(compra.getEnvio().equals("D")) {
    				compra.setCargo(25.5);
    			}
    			else {
					compra.setCargo(0);
				}
    			int flag=modeloCarritoModelInterface.RCompra(compra.getDni_Usuario(), compra);
    			if(flag==1) {
    				Boleta boleta=modeloCarritoModelInterface.buscaxdni(compra.getDni_Usuario());
    				Compra pedidoCompra=modeloCarritoModelInterface.compraXID(boleta.getId_pedido());
    				List<Detalle_Compra> detalle_Compras=modeloCarritoModelInterface.productoxpedido(pedidoCompra.getId_Pedido());
    				req.setAttribute("boleta", boleta);
    				req.setAttribute("pedido", pedidoCompra);
    				req.setAttribute("listado", detalle_Compras);
    				req.getRequestDispatcher("final.jsp").forward(req, resp);
    			}
    			else {
					req.setAttribute("mensaje", "Ocurrio un problema, vuelva a intentarlo mas tarde");
					req.getRequestDispatcher("final.jsp").forward(req, resp);
				}
    	
    	}


}
