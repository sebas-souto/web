package interfaces;

import java.util.Vector;

import beans.Categoria;


public interface ICategoriaDAO {
	
	public Categoria findId(int idCategoria);
	
	public void add(Categoria categoria) ;
	
	public void save(Categoria categoria);
	
	public Vector<Categoria> list();
	
	public void delete(int idCategoria) ;
	
	
	
}
