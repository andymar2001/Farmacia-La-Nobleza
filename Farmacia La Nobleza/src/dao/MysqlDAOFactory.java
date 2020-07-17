package dao;

import interfaces.CarritoModelInterface;
import interfaces.LoginModelInterface;
import interfaces.ProductoModelInterface;
import interfaces.UsuarioModelInterface;
import interfaces.VentaModelInterface;
import model.CompraModel;
import model.LoginModel;
import model.ProductoModel;
import model.UsuarioModel;
import model.VentaModel;

public class MysqlDAOFactory extends DAOFactory {

	@Override
	public VentaModelInterface getVentaModel() {
		return new VentaModel();
	}

	@Override
	public UsuarioModelInterface getUsuarioModel() {
		return new UsuarioModel();
	}

	@Override
	public LoginModelInterface getLogin() {
		return new LoginModel();
	}

	@Override
	public CarritoModelInterface getPedido() {
		return new CompraModel();
	}

	@Override
	public ProductoModelInterface getProducto() {
		return new ProductoModel();
	}

}
