package model;

import java.awt.peer.SystemTrayPeer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.MysqlDBConexion;
import entities.Producto;
import interfaces.ProductoModelInterface;

public class ProductoModel implements ProductoModelInterface {
	
	Connection cn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	@Override
	public List<Producto> listadoProductos() {
		List<Producto> listaProductos=new ArrayList<Producto>();
		int cantidadF=0;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			String sql="select pro.Id_Producto,"
					 + "pro.Nom_producto,"
					 + "pro.Id_Proveedor,"
					 + "pv.Nombre_Cia,"
					 + "pro.Id_Categoria, "
					 + "c.Nombre_Categoria, "
					 + "pro.U_Medida,"
					 + "pro.Precio_Unidad,"
					 + "pro.Unidades_Existencia,"
					 + "pro.Estado "
					 + "from farmanobleza.tb_producto pro inner join farmanobleza.categoria c "
					 + "on pro.Id_Categoria=c.Id_Categoria "
					 + "inner join farmanobleza.proveedor pv on pro.Id_Proveedor=pv.Id_Proveedor where pro.Estado='A';";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			if (rs.last()) {
				cantidadF=rs.getRow();
				rs.beforeFirst();
			}
			if(cantidadF!=0) {
				
				while(rs.next()) {
					Producto producto = new Producto();
					producto.setId_producto(rs.getInt("Id_Producto"));
					producto.setNom_producto(rs.getString("Nom_producto"));
					producto.setId_proveedor(rs.getInt("Id_Proveedor"));
					producto.setNombre_proveedor(rs.getString("Nombre_Cia"));
					producto.setId_categoria(rs.getInt("Id_Categoria"));
					producto.setNombre_cat(rs.getString("Nombre_Categoria"));
					producto.setU_medida(rs.getString("U_Medida"));
					producto.setPrecio_pro(rs.getDouble("Precio_Unidad"));
					producto.setStock(rs.getInt("Unidades_Existencia"));
					producto.setEstado(rs.getString("Estado"));
					listaProductos.add(producto);
				}
				
			}else {
				
				Producto producto = new Producto();producto.setNom_producto("NO EXISTEN PRODUCTOS AUN");listaProductos.add(producto);
			}
			
		} catch (Exception e) {
			System.out.println("error metodo listado de productos en general "+e.getMessage());
		}
		
		return listaProductos;
	}

	@Override
	public List<Producto> listadoProductosxCategoria(int id) {
		List<Producto> listaProductos=new ArrayList<Producto>();
		int cantidadF=0;
		try {
			
			cn = MysqlDBConexion.getConexion();
			String sql="select pro.Id_Producto,pro.Nom_producto,pro.Id_Proveedor,pv.Nombre_Cia,pro.Id_Categoria,c.Nombre_Categoria,pro.U_Medida,pro.Precio_Unidad,pro.Unidades_Existencia,pro.Estado from farmanobleza.tb_producto pro inner join farmanobleza.categoria c on pro.Id_Categoria=c.Id_Categoria inner join farmanobleza.proveedor pv on pro.Id_Proveedor=pv.Id_Proveedor where pro.Id_Categoria=? and pro.Estado='A'";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			
			if (rs.last()) {
				cantidadF=rs.getRow();
				rs.beforeFirst();
			}
			if(cantidadF!=0) {
				
				while(rs.next()) {

					Producto producto = new Producto();
					producto.setId_producto(rs.getInt("Id_Producto"));
					producto.setNom_producto(rs.getString("Nom_producto"));
					producto.setId_proveedor(rs.getInt("Id_Proveedor"));
					producto.setNombre_proveedor(rs.getString("Nombre_Cia"));
					producto.setId_categoria(rs.getInt("Id_Categoria"));
					producto.setNombre_cat(rs.getString("Nombre_Categoria"));
					producto.setU_medida(rs.getString("U_Medida"));
					producto.setPrecio_pro(rs.getDouble("Precio_Unidad"));
					producto.setStock(rs.getInt("Unidades_Existencia"));
					producto.setEstado(rs.getString("Estado"));
					
					listaProductos.add(producto);
				}
				
			}else {

				Producto producto = new Producto();
				producto.setNom_producto("NO EXISTEN PRODUCTOS AUN");
				listaProductos.add(producto);
			}
			
		} catch (Exception e) {
			System.out.println("error metodo listado de productos en general");
		}
		
		return listaProductos;
	}

	@Override
	public List<Producto> ListadoTagEconomico(String cantida_reg) {
		
		List<Producto> listaProductos=new ArrayList<Producto>();
		int cantidadF=0;
		
		try {
			
			cn = MysqlDBConexion.getConexion();
			String sql="SELECT * FROM farmanobleza.tb_producto p where p.Estado='A' order by p.Precio_Unidad limit "+cantida_reg;
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			if (rs.last()) {
				cantidadF=rs.getRow();
				rs.beforeFirst();
			}
			if(cantidadF!=0) {
				
				while(rs.next()) {
					Producto producto = new Producto();
					producto.setId_producto(rs.getInt("Id_Producto"));
					producto.setNom_producto(rs.getString("Nom_producto"));
					producto.setPrecio_pro(rs.getDouble("Precio_Unidad"));
					producto.setEstado(rs.getString("Estado"));
					listaProductos.add(producto);
				}
				
			}else {
				
				Producto producto = new Producto();producto.setNom_producto("NO EXISTEN PRODUCTOS AUN");listaProductos.add(producto);
			}
			
		} catch (Exception e) {
			System.out.println("error metodo listado de productos en general "+e.getMessage());
		}
		
		return listaProductos;
		
	}

}
