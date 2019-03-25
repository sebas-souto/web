package interfaces;

import java.util.Vector;

import beans.Cab_factura;

public interface ICab_facturaDAO {
	
	public Cab_factura findId(int id_factura);
	
	public int findLastFactura(String id_usuario);

	public void add(Cab_factura cFactura) ;
	
	public void save(Cab_factura cFactura);
	
	public Vector<Cab_factura> list();
	
	public void delete(int id_factura) ;
	

}
