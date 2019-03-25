package service;

import java.util.Vector;

import beans.Cab_factura;
import beans.Producto;
import beans.Usuario;
import interfaces.ICab_facturaDAO;
import interfaces.ICab_facturaService;
import interfaces.IProductoDAO;
import interfaces.IUsuarioDAO;
import util.TransactionManager;

public class Cab_facturaService implements ICab_facturaService{

	@Override
	public Cab_factura buscarCab_factura(int idFactura) {
		
		TransactionManager manager=new TransactionManager();
		ICab_facturaDAO cab_FacturaDao=manager.getCab_facturaDAO();
		Cab_factura cabFactura=cab_FacturaDao.findId(idFactura);
		manager.cerrarConexion();
		return cabFactura;
	}

	@Override
	public void borrarCab_factura(int idFactura) {
		TransactionManager manager=new TransactionManager();
		ICab_facturaDAO cab_FacturaDao=manager.getCab_facturaDAO();
		cab_FacturaDao.delete(idFactura);
		manager.cerrarConexion();
		
		
	}

	@Override
	public void altaCab_factura(Cab_factura cab_factura) {
		TransactionManager manager=new TransactionManager();
		ICab_facturaDAO cab_FacturaDao=manager.getCab_facturaDAO();
		cab_FacturaDao.add(cab_factura);
		manager.cerrarConexion();
		
	}

	@Override
	public void save(Cab_factura cab_factura) {
		TransactionManager manager=new TransactionManager();
		ICab_facturaDAO cab_FacturaDao=manager.getCab_facturaDAO();
		cab_FacturaDao.save(cab_factura);
		manager.cerrarConexion();
		
	}

	@Override
	public Vector<Cab_factura> listarCab_factura() {
		TransactionManager manager=new TransactionManager();
		ICab_facturaDAO cab_FacturaDao=manager.getCab_facturaDAO();
		Vector <Cab_factura> cabFacturas=cab_FacturaDao.list();
		manager.cerrarConexion();
		
		return cabFacturas;
		
	}
	public int buscarUltimaFactura(String id_usuario) {
		TransactionManager manager=new TransactionManager();
		ICab_facturaDAO cab_FacturaDao=manager.getCab_facturaDAO();
		int lastFacturas=cab_FacturaDao.findLastFactura(id_usuario);
		manager.cerrarConexion();
		
		return lastFacturas;
	
	}

}
