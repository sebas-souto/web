package interfaces;

import java.util.Vector;

import beans.Pos_factura;

public interface IPos_facturaService {
	
	public Vector <Pos_factura> buscarPos_factura();
	
	public Pos_factura buscarPos_factura(int idFactura);
	
	public void borrarPos_factura(int idFactura);
	
	public void altaPos_factura(Pos_factura posFactura);
	
	public void save(Pos_factura posFactura);
	
	
}
