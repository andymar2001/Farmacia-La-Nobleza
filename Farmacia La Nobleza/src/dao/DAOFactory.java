package dao;

import interfaces.VentaModelInterface;

public abstract class DAOFactory {

		public static final int MYSQL=1;
		public static final int SQL_SERVER=2;
		public static final int ORACLE=3;
	
		public abstract VentaModelInterface getVentaModel();
		
		public static DAOFactory getDaoFactory(int tipo) {
			switch (tipo) {
			case MYSQL:
				
				return new MysqlDAOFactory();
				
			case SQL_SERVER:
				
				break;
				
			case ORACLE:
				
				break;
				
			}
			
			return null;
			
		}
}
