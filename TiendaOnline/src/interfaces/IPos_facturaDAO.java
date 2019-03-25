package interfaces;

import java.util.Vector;

import beans.Pos_factura;

public interface IPos_facturaDAO {
	
	public Pos_factura findId(int id_factura);

	public void add(Pos_factura cFactura) ;
	
	public void save(Pos_factura cFactura);
	
	public Vector<Pos_factura> list();
	
	public void delete(int id_factura) ;
	

}
