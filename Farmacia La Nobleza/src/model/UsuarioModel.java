package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.MysqlDBConexion;
import entities.Usuario;
import interfaces.UsuarioModelInterface;

public class UsuarioModel implements UsuarioModelInterface {

	Connection cn=null;
	PreparedStatement pstm =null;
	ResultSet rs =null;
	Usuario usuario=new Usuario();
	
	public List<Usuario> listarRegistro() {
		List <Usuario> listarReg=new ArrayList<Usuario>();
		
		try {
			cn=MysqlDBConexion.getConexion();
			
			String sql = "select Dni_Usuario,Nombre_Usuario,Apellido_Usuario,Fec_Nac_Usuario,Celular_Usuario,Telefono_Usuario,Correo_Usuario from Usuario;";
		    
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			
			while(rs.next()) {
				
				
				usuario.setDni_usuario(rs.getString("Dni_Usuario"));
				usuario.setNombre_usuario(rs.getString("Nombre_Usuario"));
				usuario.setApellido_usuario(rs.getString("Apellido_Usuario"));
				usuario.setFec_nac_usuario(rs.getString("Fec_Nac_Usuario"));
				usuario.setCelular_usuario(rs.getString("Celular_Usuario"));
				usuario.setTelefono_usuario(rs.getString("Telefono_Usuario"));
				usuario.setCorreo_usuario(rs.getString("Correo_Usuario"));
				
				listarReg.add(usuario);
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listarReg;
	}

	

	public int RegistroUsuario(Usuario usuario) {

		int banderita=-1;
		
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="insert into Usuario values(?,?,?,?,?,?,?,?,default,3);";
		    
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, usuario.getDni_usuario());
			pstm.setString(2, usuario.getNombre_usuario());
			pstm.setString(3, usuario.getApellido_usuario());
			pstm.setString(4, usuario.getFec_nac_usuario());
			pstm.setString(5, usuario.getCelular_usuario());
			pstm.setString(6, usuario.getTelefono_usuario());
			pstm.setString(7, usuario.getCorreo_usuario());
			pstm.setString(8, usuario.getPassword());
			
			banderita =pstm.executeUpdate();
			System.out.println(banderita);
		}catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			try {
				
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		
		return banderita;
	}


	@Override
	public int UpdateUsuario(Usuario usuario) {
		
		int salida =-1;
		try {
			
			cn = MysqlDBConexion.getConexion();
			String sql="UPDATE usuario SET Nombre_Usuario = ?, Apellido_Usuario = ?, Fec_Nac_Usuario = ?, Celular_Usuario = ?, Telefono_Usuario = ?, Correo_Usuario = ?, Contrasena = ? WHERE Dni_Usuario = ?;";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, usuario.getNombre_usuario());
			pstm.setString(2, usuario.getApellido_usuario());
			pstm.setString(3, usuario.getFec_nac_usuario());
			pstm.setString(4, usuario.getCelular_usuario());
			if(usuario.getTelefono_usuario()==null||usuario.getTelefono_usuario().equals(" ")) {
			pstm.setString(5, null);	
			}else {pstm.setString(5, usuario.getTelefono_usuario());}
			pstm.setString(6, usuario.getCorreo_usuario());
			pstm.setString(7, usuario.getPassword());
			pstm.setString(8, usuario.getDni_usuario());
			
			salida=pstm.executeUpdate();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		finally {
			try {
				
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		return salida;
	}



	@Override
	public Boolean buscaXdni(String dni) {
		
		Boolean salida = false;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			String sql="select * from usuario where ni_Usuario=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, dni);
			if(pstm.executeUpdate()==1) {
				salida=true;
			}
			
			
		} catch (Exception e) {
			
			System.out.println("Problema en metodo buscar x dni: "+e.getMessage());
		}
		finally {
			try {
				
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		return salida;
	}
}
