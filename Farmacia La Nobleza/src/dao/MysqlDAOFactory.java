package dao;

import interfaces.UsuarioModelInterface;
import interfaces.VentaModelInterface;
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

}
