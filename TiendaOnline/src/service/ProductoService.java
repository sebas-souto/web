package service;

import java.util.Vector;

import beans.Categoria;
import beans.Producto;
import interfaces.ICategoriaDAO;
import interfaces.IProductoDAO;
import interfaces.IProductoService;
import util.TransactionManager;

public class ProductoService implements IProductoService{

	@Override
	public Vector<Producto> listarProductos() {
		TransactionManager manager=new TransactionManager();
		IProductoDAO productoDao=manager.getProductoDAO();
		Vector <Producto> productos=productoDao.list();
		manager.cerrarConexion();
		
		return productos;
	}

	@Override
	public Producto buscarProductos(int idProducto) {
		
		TransactionManager manager=new TransactionManager();
		IProductoDAO productoDao=manager.getProductoDAO();
		Producto producto=productoDao.findId(idProducto);
		manager.cerrarConexion();

		return producto;
		
	}

	@Override
	public void borrarProductos(int idProducto) {
		TransactionManager manager=new TransactionManager();
		IProductoDAO productoDao=manager.getProductoDAO();
		productoDao.delete(idProducto);
		manager.cerrarConexion();
		
	}

	@Override
	public void altaProductos(Producto producto) {
		TransactionManager manager=new TransactionManager();
		IProductoDAO productoDao=manager.getProductoDAO();
		productoDao.add(producto);
		manager.cerrarConexion();
		
	}

	@Override
	public void save(Producto producto) {
		TransactionManager manager=new TransactionManager();
		IProductoDAO productoDao=manager.getProductoDAO();
		productoDao.save(producto);
		manager.cerrarConexion();
		
	}

	@Override
	public Vector<Producto> listarProductosPorDescripcion(String descripcionCategoria) {
		TransactionManager manager=new TransactionManager();
		IProductoDAO productoDao=manager.getProductoDAO();
		Vector <Producto> productos=productoDao.list(descripcionCategoria);
		manager.cerrarConexion();
		
		return productos;
	}

	

}
