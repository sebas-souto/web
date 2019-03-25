package util;

import java.sql.Connection;

import interfaces.ICategoriaDAO;
import interfaces.IPos_facturaDAO;
import interfaces.IProductoDAO;
import interfaces.IUsuarioDAO;
import interfaces.ICab_facturaDAO;
import dao.Cab_facturaDAO;
import dao.CategoriaDAO;
import dao.Pos_facturaDAO;
import dao.ProductoDAO;
import dao.UsuarioDAO;

public class TransactionManager {
	private Connection con;
	/*ESTABLECE LA CONECXION CON LA BASE DE DATOS*/
	
	public TransactionManager() {
		this.con = ConexionBBDD.conexion();
	}
	
	
	/*NOS DEVUELVE UN OBJETO TIPO DAO*/
	public ICategoriaDAO getClienteDAO() {
		return new CategoriaDAO(con);
	}
	public void cerrarConexion() {
		ConexionBBDD.desconexion();
	}
	
	/**/
	
	public ICategoriaDAO getCategoriaDAO() {
		return new CategoriaDAO(con);
	}
	
	public IProductoDAO getProductoDAO() {
		return new ProductoDAO(con);
	}
	
	public IUsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO(con);
	}
	
	public IPos_facturaDAO getPos_facturaDAO() {
		return new Pos_facturaDAO(con);
	}
	
	public ICab_facturaDAO getCab_facturaDAO() {
		return new Cab_facturaDAO(con);
		
	}
	
}
