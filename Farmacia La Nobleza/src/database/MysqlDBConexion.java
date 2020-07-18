package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDBConexion {
	
	public static Connection getConexion() {
//		 String nombreBD="CovidFarma";
//		  String usuario="root";
//		 String contraseña="mysql";
//		  String url="jdbc:mysql://localhost:3306/"+nombreBD+"?useUnicode=true&use"
//				 +"JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
//				 +"serverTimezone=UTC";
//		 
//		 Connection cn = null;
//		
//		try {
//			//obtener el drivers
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			//obtener coneccion	
//			cn = DriverManager.getConnection(url,usuario,contraseña);
//			
//			if(cn!=null) {
//				System.out.print("Conexion exitosa a la base de datos :");
//			}
//			
//		} catch (ClassNotFoundException e) {
//			System.out.print("Ocurre una classnotfound exception :" +e.getMessage());
//		}catch (SQLException e) {
//			System.out.print("ocurre una ecxepcion con sql eception :" +e.getMessage());
//		}
//		return cn;
//		
//		
		 String nombreBD="farmanobleza";
		 String usuario="root";
		 String contraseña="mysql";
		 String url="jdbc:mysql://localhost:3306/"+nombreBD+"?useUnicode=true&use"
				 +"JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
				 +"serverTimezone=UTC";
		 Connection cn = null;
		try {
			//obtener el drivers
			Class.forName("com.mysql.jdbc.Driver");
			//String connectionURL="jdbc:mysql://localhost:3306/farmanobleza?user=root&password=&useUnicode=true&characterEncoding=UTF-8";
			String connectionURL="jdbc:mysql://localhost:3307/farmanobleza?user=root&password=mysql&useUnicode=true&characterEncoding=UTF-8";
			cn=DriverManager.getConnection(connectionURL);
			
			if(cn!=null) {
				System.out.print("Conexion exitosa a la base de datos :");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.print("Ocurre una classnotfound exception :" +e.getMessage());
		}catch (SQLException e) {
			System.out.print("ocurre una ecxepcion con sql eception :" +e.getMessage());
		}
		return cn;
	}
}
