package entities;

public class Detalle_Compra {
	
	
	private int id_pedido;
	private String nombre_producto;
	private int id_producto;
	private double precio_uni;
	private int cantidad;
	private double descuento;
		
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public double getPrecio_uni() {
		return precio_uni;
	}
	public void setPrecio_uni(double precio_uni) {
		this.precio_uni = precio_uni;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public double total_detalle_producto() {
		return (cantidad*precio_uni)-(cantidad*precio_uni*descuento)/100;
	}

}
