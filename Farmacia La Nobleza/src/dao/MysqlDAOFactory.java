package dao;

import interfaces.UsuarioModelInterface;
import interfaces.VentaModelInterface;
import model.UsuarioModel;
import model.VentaModel;

public class MysqlDAOFactory extends DAOFactory {

	@Override
	public VentaModelInterface getVentaModel() {
		// TODO Auto-generated method stub
		return new VentaModel();
	}

	@Override
	public UsuarioModelInterface getLoginModel() {
		// TODO Auto-generated method stub
		return new UsuarioModel();
	}

}
