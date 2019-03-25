package interfaces;

import java.util.Vector;

import beans.Categoria;


public interface ICategoriaService {
	
	public Vector <Categoria> listarCategorias();
	
	public Categoria buscarCategorias(int idCategoria);
	
	public void borrarCategorias(int idCategoria);
	
	public void altaCategorias(Categoria categoria);
	
	public void save(Categoria categoria);

}
