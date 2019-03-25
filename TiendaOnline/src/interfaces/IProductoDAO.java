package interfaces;

import java.util.Vector;

import beans.Producto;


public interface IProductoDAO {
	
public Producto findId(int idProducto);
	
	public void add(Producto producto) ;
	
	public void save(Producto producto);
	
	public Vector<Producto> list();
	
	public void delete(int idProducto) ;
	
	public Vector <Producto> list(String descripcionCategoria);

}
