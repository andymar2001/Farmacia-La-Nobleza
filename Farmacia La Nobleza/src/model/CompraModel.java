 package model;
import interfaces.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	PreparedStatement pstm2=null;
	ResultSet rs = null;

	@Override
	public Compra compraxusuario(String dni) {
		Compra compra=new Compra();
		
		try {
			
			cn=MysqlDBConexion.getConexion();
			String sql="select * from Pedido where Dni_Usuario=? and Estado='C'";
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
		
		
		try {
			
			cn=MysqlDBConexion.getConexion();
			String sql="select d.Id_Pedido,"
					 + "d.Id_Producto,"
					 + "p.Nom_producto,"
					 + "d.Precio_Unidad,"
					 + "d.Cantidad,"
					 + "d.Descuento "
					 + "from detalle_pedido d inner join "
					 + "tb_producto p "
					 + "on d.Id_Producto = p.Id_Producto "
					 + "where Id_Pedido=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, id_pedido);
			rs=pstm.executeQuery();
			
			
			while(rs.next()) {
				Detalle_Compra itemCompra = new Detalle_Compra();
				itemCompra.setId_pedido(id_pedido);
				itemCompra.setId_producto(rs.getInt("Id_Producto"));
				itemCompra.setNombre_producto(rs.getString("Nom_producto"));
				itemCompra.setPrecio_uni(rs.getDouble("Precio_Unidad"));
				itemCompra.setCantidad(rs.getInt("Cantidad"));
				itemCompra.setDescuento(rs.getDouble("Descuento"));
				System.out.println("llego: "+itemCompra.getNombre_producto());
				compras.add(itemCompra);
				
				System.out.println("Producto añadido");
				
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
			ProductoModelInterface modeloInterface = new ProductoModel();
			Producto producto=modeloInterface.productoXid(id_producto);
			cn=MysqlDBConexion.getConexion();
			String sql="insert into Detalle_pedido values(?,?,?,?,null)";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id_producto);
			pstm.setInt(2, id_pedido);
			pstm.setDouble(3, producto.getPrecio_pro());
			pstm.setInt(4, 1);
			salida=pstm.executeUpdate();
			
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

	@Override
	public int deleteDetalle(int id_pedidp, int id_producto) {
		
		int salida =-1;
		
		try {
			
			cn=MysqlDBConexion.getConexion();
			String sql="delete from farmanobleza.detalle_pedido where detalle_pedido.Id_Producto= "+id_producto+" and detalle_pedido.Id_Pedido= "+id_pedidp;
			pstm=cn.prepareStatement(sql);
			salida=pstm.executeUpdate();
		 } catch (Exception e) {
			System.out.println("Problema en deleteDetalle_pedido: "+e.getMessage());
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
	public int updateCantidadDetalle(int id_pedido, int id_producto,int cantidad) {
		int salida =-1;
		
		try {
			
			cn=MysqlDBConexion.getConexion();
			String sql="UPDATE Detalle_pedido SET Cantidad = ? WHERE Id_Pedido = ? and Id_Producto=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cantidad);
			pstm.setInt(2, id_pedido);
			pstm.setInt(3, id_producto);
			salida=pstm.executeUpdate();
			System.out.println("updateo");
			
		} catch (Exception e) {
			System.out.println("Problema en deleteDetalle_pedido: "+e.getMessage());
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
	public int RCompra(String dni,Compra pedido) {
		int salida=-1;
		double monto=0;
		
		try {
			
			List<Detalle_Compra> listaCompras=productoxpedido(pedido.getId_Pedido());
			for(Detalle_Compra compra:listaCompras) {
				monto+=compra.total_detalle_producto();
			}
			cn=MysqlDBConexion.getConexion();
			cn.setAutoCommit(false);
			String sqlpedidoString="UPDATE pedido SET FechaEnvio = ?, Envio = ?, Cargo = ?, DireccionDestinatario =?, CiudadDestinatario =?, RegionDestinatario=?, Estado = 'P' WHERE Id_Pedido = ?";
			String sqlAddBoleta="insert into Boleta values(null,?,?,?,'V')";
			pstm=cn.prepareStatement(sqlpedidoString);
			pstm.setString(1, pedido.getFechaEnvio());
			pstm.setString(2, pedido.getEnvio());
			pstm.setDouble(3, pedido.getCargo());
			pstm.setString(4, pedido.getDireccionDestinatario());
			pstm.setString(5, pedido.getCiudadDestinatario());
			pstm.setString(6, pedido.getRegionDestinatario());
			pstm.setInt(7, pedido.getId_Pedido());
			pstm.executeUpdate();
			pstm2=cn.prepareStatement(sqlAddBoleta);
			pstm2.setString(1, dni);
			pstm2.setInt(2, pedido.getId_Pedido());
			pstm2.setDouble(3, monto);
			pstm2.executeUpdate();
			cn.commit();
			salida=1;
		} catch(SQLException e) {
	        if(cn!=null){
	            try {
	                cn.rollback();
	            }catch (SQLException ex) {
	                System.out.println("problema en transaccion"+ex.toString());
	            }
	         }
	 }catch (Exception e) {
			System.out.println("Problema desconocido:  "+e.getMessage());
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
	public Compra compraXID(int id) {
		Compra compra=null;
		
		try {
			
			cn=MysqlDBConexion.getConexion();
			String sqloString="select * from pedido where Id_Pedido=?";
			pstm=cn.prepareStatement(sqloString);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			if(rs.next()) {
				compra=new Compra();
				compra.setId_Pedido(rs.getInt("Id_Pedido"));
				compra.setDni_Usuario(rs.getString("Dni_Usuario"));
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
			}
			
		} catch (Exception e) {
			System.out.println("Problema en compraxID: "+e.getMessage());
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
	public Boleta buscaxdni(String dni) {
		
		Boleta boleta=null;
		
			try {
				
				cn=MysqlDBConexion.getConexion();
				String sqlString="select * from Boleta where Dni_Usuario=? and Estado='V' order by id_boleta desc";
				pstm=cn.prepareStatement(sqlString);
				pstm.setString(1, dni);
				rs=pstm.executeQuery();
				
				if(rs.next()) {
					boleta=new Boleta();
					boleta.setIdboleta(rs.getInt("id_boleta"));
					boleta.setDni_usuario(rs.getString("Dni_Usuario"));
					boleta.setId_pedido(rs.getInt("Id_Pedido"));
					boleta.setMontototal(rs.getDouble("Monto_total"));
					boleta.setEstado(rs.getString("Estado"));
					
				}
				
			} catch (Exception e) {
				System.out.println("Problema en deleteDetalle_pedido: "+e.getMessage());
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
		return boleta;
		
	}
	
	
	

}
