package interfaces;

import java.util.List;

import entities.Compra;
import entities.Detalle_Compra;

public interface CarritoModelInterface {
	
	public Compra compraxusuario(String dni);
	
	public List<Detalle_Compra> productoxpedido(int id_pedido);
	
	public int updatePedido(String estado,int id_pedido);
	
	public int GuardaBoleta(String dni,int id_pedido);
}
