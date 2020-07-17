package entities;

public class Producto {

	private int id_producto;
	private String nom_producto;
	private int id_proveedor;
	private String nombre_proveedor;
	private int id_categoria;
	private String nombre_cat;
	private String u_medida;
	private double precio_pro;
	private int stock;
	private String estado;
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNom_producto() {
		return nom_producto;
	}
	public void setNom_producto(String nom_producto) {
		this.nom_producto = nom_producto;
	}
	public int getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	public String getNombre_proveedor() {
		return nombre_proveedor;
	}
	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombre_cat() {
		return nombre_cat;
	}
	public void setNombre_cat(String nombre_cat) {
		this.nombre_cat = nombre_cat;
	}
	public String getU_medida() {
		return u_medida;
	}
	public void setU_medida(String u_medida) {
		this.u_medida = u_medida;
	}
	public double getPrecio_pro() {
		return precio_pro;
	}
	public void setPrecio_pro(double precio_pro) {
		this.precio_pro = precio_pro;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
