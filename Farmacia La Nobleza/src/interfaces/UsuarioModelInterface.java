package interfaces;

import java.util.List;

import entities.Usuario;

public interface UsuarioModelInterface {
	
	public List<Usuario> listarRegistro();
	
	public int RegistroUsuario(Usuario usuario);
	
	public int UpdateUsuario(Usuario usuario);

}
