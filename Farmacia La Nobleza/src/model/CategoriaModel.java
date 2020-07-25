package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import database.MysqlDBConexion;
import entities.Categoria;
import interfaces.CategoriaModelInterface;

public class CategoriaModel implements CategoriaModelInterface {

	@Override
	public List<Categoria> listOptions() {
		
		List<Categoria> listOptions=new ArrayList<Categoria>();
		
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			
			cn=MysqlDBConexion.getConexion();
			String sql="SELECT c.Id_Categoria,c.Nombre_Categoria FROM categoria c where c.Estado='A';";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			
			while(rs.next()) {
				
				Categoria categoria=new Categoria();
				
				categoria.setId(rs.getInt("Id_Categoria"));
				categoria.setNombre(rs.getString("Nombre_Categoria"));
				
				listOptions.add(categoria);
				
			}
			
		} catch (Exception e) {
			System.out.println("Error en modelo listar options categoria "+e.getMessage());
		}
		
		return listOptions;
	}

}
