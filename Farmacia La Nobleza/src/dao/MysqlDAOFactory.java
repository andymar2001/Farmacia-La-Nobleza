package dao;

import interfaces.VentaModelInterface;

public class MysqlDAOFactory extends DAOFactory {

	@Override
	public VentaModelInterface getVentaModel() {
		// TODO Auto-generated method stub
		return new VentaModel();
	}

}
