package entities;

public class Boleta {
	
	private int idboleta;
	private String dni_usuario;
	private int id_pedido;
	private double montototal;
	private String estado;
	public int getIdboleta() {
		return idboleta;
	}
	public void setIdboleta(int idboleta) {
		this.idboleta = idboleta;
	}
	public String getDni_usuario() {
		return dni_usuario;
	}
	public void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public double getMontototal() {
		return montototal;
	}
	public void setMontototal(double montototal) {
		this.montototal = montototal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
