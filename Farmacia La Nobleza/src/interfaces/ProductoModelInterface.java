package interfaces;

import java.util.List;

import entities.Producto;

public interface ProductoModelInterface {

	
	public List<Producto> listadoProductos();
	public List<Producto> listadoProductosxCategoria(int id);
	public List<Producto> ListadoTagEconomico(String cantida_reg);
	
	
}
