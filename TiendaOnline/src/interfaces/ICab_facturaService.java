package interfaces;

import java.util.Vector;

import beans.Cab_factura;
import beans.Producto;

public interface ICab_facturaService {
	
	public Vector <Cab_factura> listarCab_factura();

	
	public Cab_factura buscarCab_factura(int idFactura);
	
	public void borrarCab_factura(int idFactura);
	
	public void altaCab_factura(Cab_factura cab_factura);
	
	public void save(Cab_factura cab_factura);
	
	public int buscarUltimaFactura(String id_usuario);

}
