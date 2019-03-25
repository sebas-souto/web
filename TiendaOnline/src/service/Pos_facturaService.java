package service;

import java.util.Vector;

import beans.Cab_factura;
import beans.Pos_factura;
import interfaces.ICab_facturaDAO;
import interfaces.IPos_facturaDAO;
import interfaces.IPos_facturaService;
import util.TransactionManager;

public class Pos_facturaService implements IPos_facturaService{

	@Override
	public Vector<Pos_factura> buscarPos_factura(){
		TransactionManager manager=new TransactionManager();
		IPos_facturaDAO pos_facturaDAO=manager.getPos_facturaDAO();
		Vector <Pos_factura> cabFacturas=pos_facturaDAO.list();
		manager.cerrarConexion();
		return cabFacturas;
	}
	

	@Override
	public Pos_factura buscarPos_factura(int idFactura) {
		
		TransactionManager manager=new TransactionManager();
		IPos_facturaDAO cab_FacturaDao=manager.getPos_facturaDAO();
		Pos_factura posFactura=cab_FacturaDao.findId(idFactura);
		manager.cerrarConexion();
		return posFactura;
	
	}

	@Override
	public void borrarPos_factura(int idFactura) {
		TransactionManager manager=new TransactionManager();
		IPos_facturaDAO posFacturaDao=manager.getPos_facturaDAO();
		posFacturaDao.delete(idFactura);
		manager.cerrarConexion();
		
		
	}
	

	@Override
	public void altaPos_factura(Pos_factura posFactura) {
		TransactionManager manager=new TransactionManager();
		IPos_facturaDAO posFacturaDao=manager.getPos_facturaDAO();
		posFacturaDao.add(posFactura);
		manager.cerrarConexion();
		
	}

	@Override
	public void save(Pos_factura posFactura) {
		
		TransactionManager manager=new TransactionManager();
		IPos_facturaDAO posFacturaDao=manager.getPos_facturaDAO();
		posFacturaDao.save(posFactura);
		manager.cerrarConexion();
		
		
	}

	
	
}
