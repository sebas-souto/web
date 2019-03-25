package interfaces;

import java.util.Vector;

import beans.Usuario;

public interface IUsuarioService {

	public Vector <Usuario> listarUsuarios();
	
	public Usuario buscarNombreUsuarios(String idUsuario);
	
	public void borrarUsuarios(String idUsuario);
	
	public void altaUsuario(Usuario usario);
	
	public void save(Usuario usuario);
	
	public Vector <Usuario> listarUsuarios(String descripcionProducto, int tipo);

	
}
