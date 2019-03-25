package interfaces;

import java.util.Vector;


import beans.Producto;

public interface IProductoService {
	
	public Vector <Producto> listarProductos();
	
	public Producto buscarProductos(int idProducto);
	
	public void borrarProductos(int idProducto);
	
	public void altaProductos(Producto producto);
	
	public void save(Producto producto);
	
	public Vector <Producto> listarProductosPorDescripcion(String descripcionCategoria);



}
