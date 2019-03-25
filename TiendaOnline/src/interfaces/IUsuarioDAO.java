package interfaces;

import java.util.Vector;

import beans.Usuario;

public interface IUsuarioDAO {
	
	/*Interfaz del DAO*/
	
	public Usuario findId(String idUsuario);

	
	public void add(Usuario cli) ;
	
	public void save(Usuario cli);
	
	public Vector<Usuario> list();
	
	public void delete(String idUsuario) ;
	
	
	public Vector<Usuario> list(String descripcionProducto,int tipo);

	
}
