package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.MysqlDBConexion;
import entities.Usuario;
import interfaces.LoginModelInterface;

public class LoginModel implements LoginModelInterface {
	
	
	public Date fechaObjeto;
	public Date newFecha;
	public Date newFechaSql;
	public SimpleDateFormat formato_AMD=new SimpleDateFormat("yyyy-MM-dd");
	public SimpleDateFormat formato_DMA=new SimpleDateFormat("EEEE, dd 'de' MMMM 'del' yyyy");
	public SimpleDateFormat formato_DMA2=new SimpleDateFormat("dd-MM-yyyy");
	public String fechachange="";

		Usuario usuario= new Usuario();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
	@Override
	public Usuario loginOn(String dni, String clave) {
		
		try {
			
			cn=MysqlDBConexion.getConexion();
			String sql="select * from Usuario where Dni_Usuario=? and Contrasena=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, dni);
			pstm.setString(2, clave);
			rs = pstm.executeQuery();
			if(rs.next()) {
				
				usuario.setDni_usuario(rs.getString("Dni_Usuario"));
				usuario.setNombre_usuario(rs.getString("Nombre_Usuario"));
				usuario.setApellido_usuario(rs.getString("Apellido_Usuario"));
				fechaObjeto=new Date();
				fechaObjeto=formato_AMD.parse(rs.getString("Fec_Nac_Usuario"));
				fechachange=formato_DMA2.format(fechaObjeto);
				usuario.setFec_nac_usuario(fechachange);
				usuario.setCelular_usuario(rs.getString("Celular_Usuario"));
				usuario.setTelefono_usuario(rs.getString("Telefono_Usuario"));
				usuario.setCorreo_usuario(rs.getString("Correo_Usuario"));
				usuario.setPassword(rs.getString("Contrasena"));
				usuario.setEstado_usuario(rs.getString("Estado"));
				usuario.setTipo_us(rs.getInt("id_tipo_usario"));
				
				System.out.println(usuario.getNombre_usuario());
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		
		return usuario;
		
	}

}
