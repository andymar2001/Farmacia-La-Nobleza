package interfaces;

import java.util.List;

import entities.Boleta;
import entities.Compra;
import entities.Detalle_Compra;

public interface CarritoModelInterface {
	
	public Compra compraxusuario(String dni);
	
	public Compra compraXID(int id);
	
	public List<Detalle_Compra> productoxpedido(int id_pedido);
	
	public int updatePedido(String estado,int id_pedido);
	
	public int addPedido(String dni);
	
	public int addDetalle_Pedido(int id_pedido,int id_producto);
	
	public int deleteDetalle(int id_pedidp,int id_producto);
	
	public int updateCantidadDetalle(int id_pedido,int id_producto,int cantidad);
	
	public int RCompra(String dni,Compra pedido);
	
	public Boleta buscaxdni(String dni);
}
