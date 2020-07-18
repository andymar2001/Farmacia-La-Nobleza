 package model;
import interfaces.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.MysqlDBConexion;
import entities.*;

public class CompraModel implements CarritoModelInterface{
	
	public Date fechaActual=new Date();
	public SimpleDateFormat formato_AMD=new SimpleDateFormat("yyyy-MM-dd");
	public String fechactualString=formato_AMD.format(fechaActual);
	Connection cn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	@Override
	public Compra compraxusuario(String dni) {
		Compra compra=new Compra();
		
		try {
			
			cn=MysqlDBConexion.getConexion();
			String sql="select * from Pedido where Dni_Usuario=? and Estado=C";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, dni);
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				
				compra.setId_Pedido(rs.getInt("Id_Pedido"));
				compra.setDni_Usuario(dni);
				compra.setFechaPedido(rs.getString("FechaPedido"));
				compra.setFechaEntrega(rs.getString("FechaEntrega"));
				compra.setFechaEnvio(rs.getString("FechaEnvio"));
				compra.setEnvio(rs.getString("Envio"));
				compra.setCargo(rs.getDouble("Cargo"));
				compra.setDireccionDestinatario(rs.getString("DireccionDestinatario"));
				compra.setCiudadDestinatario(rs.getString("CiudadDestinatario"));
				compra.setRegionDestinatario(rs.getString("RegionDestinatario"));
				compra.setEstado(rs.getString("Estado"));
				
				System.out.println("Trajo el pedido: "+compra.getId_Pedido()+" suuuuuuuper bien NANI");
				
			}else {
				compra=null;
			}
			
		} catch (Exception e) {
			System.out.println("Error en metodo: "+e.getMessage());
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
		return compra;
	}

	@Override
	public List<Detalle_Compra> productoxpedido(int id_pedido) {
		
		List<Detalle_Compra> compras=new ArrayList<Detalle_Compra>();
		Detalle_Compra itemCompra = new Detalle_Compra();
		
		try {
			
			cn=MysqlDBConexion.getConexion();
			String sql="select d.Id_Pedido,"
					 + "d.Id_Producto,"
					 + "p.Nom_producto,"
					 + "d.Precio_Unidad,"
					 + "d.Cantidad,"
					 + "d.Descuento "
					 + "from covidfarma.detalle_pedido d inner join "
					 + "covidfarma.tb_producto p "
					 + "on d.Id_Producto = p.Id_Producto "
					 + "where Id_Pedido=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, id_pedido);
			rs=pstm.executeQuery();
			
			if(rs.next())
			while(rs.next()) {
				
				itemCompra.setId_pedido(id_pedido);
				itemCompra.setId_producto(rs.getInt("Id_Producto"));
				itemCompra.setNombre_producto(rs.getString("Nom_producto"));
				itemCompra.setPrecio_uni(rs.getDouble("Precio_Unidad"));
				itemCompra.setCantidad(rs.getInt("Cantidad"));
				itemCompra.setDescuento(rs.getDouble("Descuento"));
				
				compras.add(itemCompra);
				
				System.out.println("Producto añadido");
				
			}
			else {
				itemCompra.setNombre_producto("Sin Productos Añadidos");
				compras.add(itemCompra);
			}
			
		} catch (Exception e) {
			System.out.println("Error en metodo listado productos x pedidos: "+e.getMessage());
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
		return compras;
	}

	@Override
	public int updatePedido(String estado,int id_pedido) {
		int salida=-1;
		
		try {
			
			cn=MysqlDBConexion.getConexion();
			String sql="UPDATE Pedido SET Estado = ? WHERE Id_Pedido = ?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, estado);
			pstm.setInt(2, id_pedido);
			
			salida=pstm.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error update estado pedido");
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
		return salida;
	}

	@Override
	public int GuardaBoleta(String dni, int id_pedido) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	@Override
	public int addPedido(String dni) {

		int salida=-1;
		
		try {
			
			cn=MysqlDBConexion.getConexion();
			String sql="insert into pedido values(null,?,?,null,null,null,null,null,null,null,default)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, dni);
			pstm.setString(2, fechactualString);
			
			salida=pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en el metodo de creacion de pedido: "+e.getMessage());
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
		return salida;
	}

	@Override
	public int addDetalle_Pedido(int id_pedido, int id_producto) {
		
		int salida=-1;
		try {
			
			cn=MysqlDBConexion.getConexion();
			String sql="insert into Detalle_pedido values(?,?,)";
			
		} catch (Exception e) {
			System.out.println("Problema en addDetalle_pedido: "+e.getMessage());
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
		return salida;
	}

	
	

}
