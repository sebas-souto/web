package service;

import java.util.Vector;

import beans.Categoria;
import dao.CategoriaDAO;
import interfaces.ICategoriaDAO;
import interfaces.ICategoriaService;
import util.TransactionManager;

public class CategoriaService implements ICategoriaService{

	@Override
	public Vector<Categoria> listarCategorias() {
		// TODO Auto-generated method stub
		TransactionManager manager=new TransactionManager();
		ICategoriaDAO usuarioDao=manager.getCategoriaDAO();
		Vector <Categoria> usuarios=usuarioDao.list();
		manager.cerrarConexion();
		
		return usuarios;
	}

	@Override
	public Categoria buscarCategorias(int idCategoria) {
		TransactionManager manager=new TransactionManager();
		ICategoriaDAO categoriaDao=manager.getCategoriaDAO();
		Categoria usuario=categoriaDao.findId(idCategoria);
		manager.cerrarConexion();

		return usuario;
	}
	
	public void borrarCategorias(int idCategoria) {
		TransactionManager manager=new TransactionManager();
		ICategoriaDAO categoriaDao=manager.getCategoriaDAO();
		categoriaDao.delete(idCategoria);
		manager.cerrarConexion();
	}
	

	@Override
	public void altaCategorias(Categoria usario) {
		TransactionManager manager=new TransactionManager();
		ICategoriaDAO usuarioDao=manager.getCategoriaDAO();
		usuarioDao.add(usario);
		manager.cerrarConexion();
		
	}
	
	@Override
	public void save(Categoria usuario) {
		TransactionManager manager=new TransactionManager();
		ICategoriaDAO clienteDAO=manager.getCategoriaDAO();
		clienteDAO.save(usuario);
		manager.cerrarConexion();
		
	}
	
	
}
