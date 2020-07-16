package entities;

public class Compra {
	
	public int Id_Pedido;
	public String FechaPedido;
	public String FechaEntrega;
	public String FechaEnvio;
	public String envio;
	public double cargo;
	public String Destinatario;
	public String DireccionDestinatario;
	public String CiudadDestinatario;
	public String RegionDestinatario;
	public String CodPostalDestinatario;
	public String Dni_Usuario;
	public String Estado;
	public int getId_Pedido() {
		return Id_Pedido;
	}
	public void setId_Pedido(int id_Pedido) {
		Id_Pedido = id_Pedido;
	}
	public String getFechaPedido() {
		return FechaPedido;
	}
	public void setFechaPedido(String fechaPedido) {
		FechaPedido = fechaPedido;
	}
	public String getFechaEntrega() {
		return FechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		FechaEntrega = fechaEntrega;
	}
	public String getFechaEnvio() {
		return FechaEnvio;
	}
	public void setFechaEnvio(String fechaEnvio) {
		FechaEnvio = fechaEnvio;
	}
	public String getEnvio() {
		return envio;
	}
	public void setEnvio(String envio) {
		this.envio = envio;
	}
	public double getCargo() {
		return cargo;
	}
	public void setCargo(double cargo) {
		this.cargo = cargo;
	}
	public String getDestinatario() {
		return Destinatario;
	}
	public void setDestinatario(String destinatario) {
		Destinatario = destinatario;
	}
	public String getDireccionDestinatario() {
		return DireccionDestinatario;
	}
	public void setDireccionDestinatario(String direccionDestinatario) {
		DireccionDestinatario = direccionDestinatario;
	}
	public String getCiudadDestinatario() {
		return CiudadDestinatario;
	}
	public void setCiudadDestinatario(String ciudadDestinatario) {
		CiudadDestinatario = ciudadDestinatario;
	}
	public String getRegionDestinatario() {
		return RegionDestinatario;
	}
	public void setRegionDestinatario(String regionDestinatario) {
		RegionDestinatario = regionDestinatario;
	}
	public String getCodPostalDestinatario() {
		return CodPostalDestinatario;
	}
	public void setCodPostalDestinatario(String codPostalDestinatario) {
		CodPostalDestinatario = codPostalDestinatario;
	}
	public String getDni_Usuario() {
		return Dni_Usuario;
	}
	public void setDni_Usuario(String dni_Usuario) {
		Dni_Usuario = dni_Usuario;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
}
