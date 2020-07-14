package dao;

import interfaces.LoginModelInterface;
import interfaces.UsuarioModelInterface;
import interfaces.VentaModelInterface;
import model.LoginModel;
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
		// TODO Auto-generated method stub
		return new LoginModel();
	}

}
