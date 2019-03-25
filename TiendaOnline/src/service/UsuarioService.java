package service;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import beans.Usuario;
import interfaces.IUsuarioDAO;
import interfaces.IUsuarioService;
import util.TransactionManager;

public class UsuarioService implements IUsuarioService{

	@Override
	public Vector<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		TransactionManager manager=new TransactionManager();
		IUsuarioDAO usuarioDao=manager.getUsuarioDAO();
		Vector <Usuario> usuarios=usuarioDao.list();
		manager.cerrarConexion();
		
		return usuarios;
	}

	@Override
	public Usuario buscarNombreUsuarios(String idUsuario) {
		TransactionManager manager=new TransactionManager();
		IUsuarioDAO usuarioDao=manager.getUsuarioDAO();
		Usuario usuario=usuarioDao.findId(idUsuario);
		manager.cerrarConexion();

		return usuario;
	}
	
	public boolean confirmaUser(String user,String pass) {
		System.out.println("Estoy en la confirmacion.");
		Usuario usuario=buscarNombreUsuarios(user);
		System.out.println("El usuario exite: "+usuario.getIdUsuario());
		if(user!=null) {
			if(usuario.getPassword().equals(pass)) {
				return true;
			}	
			else {
				return false;
			}
		}
		else return false;
	}
	
	public void borrarUsuarios(String idUsuario) {
		TransactionManager manager=new TransactionManager();
		IUsuarioDAO usuarioDao=manager.getUsuarioDAO();
		usuarioDao.delete(idUsuario);
		manager.cerrarConexion();

	}

	@Override
	public void altaUsuario(Usuario usario) {
		TransactionManager manager=new TransactionManager();
		IUsuarioDAO usuarioDao=manager.getUsuarioDAO();
		usuarioDao.add(usario);
		manager.cerrarConexion();
		
	}
	
	@Override
	public void save(Usuario usuario) {
		TransactionManager manager=new TransactionManager();
		IUsuarioDAO clienteDAO=manager.getUsuarioDAO();
		clienteDAO.save(usuario);
		manager.cerrarConexion();
		
	}

	@Override
	public Vector<Usuario> listarUsuarios(String descripcionProducto, int tipo) {
		TransactionManager manager=new TransactionManager();
		IUsuarioDAO usuarioDao=manager.getUsuarioDAO();
		Vector <Usuario> usuarios=usuarioDao.list(descripcionProducto, tipo);
		manager.cerrarConexion();
		
		return usuarios;
	}
	

}
