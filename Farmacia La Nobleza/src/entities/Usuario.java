package entities;

import java.util.Date;

public class Usuario {
	
	private String dni_usuario;
	private String nombre_usuario;
	private String Apellido_usuario;
	private String fec_nac_usuario;
	private String celular_usuario;
	private String telefono_usuario;
	private String correo_usuario;
	private char estado_usuario;
	private int tipo_us;
	private String password;
	
	
	
	public int getTipo_us() {
		return tipo_us;
	}
	public void setTipo_us(int tipo_us) {
		this.tipo_us = tipo_us;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDni_usuario() {
		return dni_usuario;
	}
	public void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getApellido_usuario() {
		return Apellido_usuario;
	}
	public void setApellido_usuario(String apellido_usuario) {
		Apellido_usuario = apellido_usuario;
	}
	public String  getFec_nac_usuario() {
		return fec_nac_usuario;
	}
	public void setFec_nac_usuario(String fecha) {
		this.fec_nac_usuario = fecha;
	}
	public String getCelular_usuario() {
		return celular_usuario;
	}
	public void setCelular_usuario(String celular_usuario) {
		this.celular_usuario = celular_usuario;
	}
	public String getTelefono_usuario() {
		return telefono_usuario;
	}
	public void setTelefono_usuario(String telefono_usuario) {
		this.telefono_usuario = telefono_usuario;
	}
	public String getCorreo_usuario() {
		return correo_usuario;
	}
	public void setCorreo_usuario(String correo_usuario) {
		this.correo_usuario = correo_usuario;
	}
	public char getEstado_usuario() {
		return estado_usuario;
	}
	public void setEstado_usuario(char estado_usuario) {
		this.estado_usuario = estado_usuario;
	}
	
	

}
