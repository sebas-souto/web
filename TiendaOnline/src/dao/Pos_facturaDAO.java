package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.Cab_factura;
import beans.Pos_factura;
import interfaces.IPos_facturaDAO;

public class Pos_facturaDAO implements IPos_facturaDAO{
	private Connection con;
	public PreparedStatement plantillaSQL;
	public Statement sentencia;
	public ResultSet resultado;
	
	public Pos_facturaDAO() {}
	
	public Pos_facturaDAO(Connection con) {
		this.con=con;
		
	}
	
	
	/*PENDIENTE COMPROBAR*/

	@Override
	public Pos_factura findId(int id_factura) {
		Pos_factura aux=null;
		/*ESTA INCOMPLETO YA QUE PASANDO SOLO UNA FACTURA DEVUELVE MULTIPLES POSICIONES COMO LA MISMA IDA*/
		try {
			plantillaSQL=con.prepareStatement("SELECT * FROM POS_FACTURAS WHERE id_factura=?");
			plantillaSQL.setInt(1, id_factura);
			resultado=plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				aux=new Pos_factura();
				aux.setId_factura(resultado.getInt("id_factura"));
				aux.setPos_factura(resultado.getInt("pos_factura"));
				aux.setId_producto(resultado.getInt("id_producto"));
				aux.setCantidad(resultado.getInt("cantidad"));
			}
			plantillaSQL.execute();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en find id  posicion de factura.");

			System.out.println("find "+e);
		
		}
		
		return aux;
	}
	

	@Override
	public void add(Pos_factura cFactura) {
		try {
			plantillaSQL=con.prepareStatement("INSERT INTO POS_FACTURAS VALUES (?,?,?,?)");
			
			plantillaSQL.setInt(1,cFactura.getId_factura());
			plantillaSQL.setInt(2,cFactura.getPos_factura());
			plantillaSQL.setInt(3,cFactura.getId_producto());
			plantillaSQL.setInt(4,cFactura.getCantidad());
			
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en añadir posicion de factura.");
			System.out.println("**"+e);
		}
		
		
	}

	@Override
	public void save(Pos_factura cFactura) {
		try {
			plantillaSQL=con.prepareStatement("UPDATE POS_FACTURAS SET POS_FACTURA=?, ID_PRODUCTO=?, CANTIDAD=?"+" WHERE ID_FACTURA=?");
			
			plantillaSQL.setInt(1,cFactura.getPos_factura());
			plantillaSQL.setInt(2,cFactura.getId_producto());
			plantillaSQL.setInt(3,cFactura.getCantidad());
			plantillaSQL.setInt(4,cFactura.getId_factura());
			//la posicion va en funcion de la sistesis previamente asignada
			System.out.println(plantillaSQL.toString());
			
			plantillaSQL.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en save cabecera de factura.");

			System.out.println(e);
		}
	}

	@Override
	public Vector<Pos_factura> list() {
		
		Vector <Pos_factura> lista=new Vector();
		try {
			plantillaSQL=con.prepareStatement("SELECT * FROM POS_FACTURAS");
			resultado=plantillaSQL.executeQuery();
			while (resultado.next()) {
				Pos_factura aux=new Pos_factura();
				aux.setCantidad(resultado.getInt("cantidad"));
				aux.setId_factura(resultado.getInt("id_factura"));
				aux.setId_producto(resultado.getInt("id_producto"));
				aux.setPos_factura(resultado.getInt("pos_factura"));
				
				lista.add(aux);				
			}
			plantillaSQL.execute();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en listar posicion de factura.");

			System.out.println(e);
		}

		return lista;
	}

	@Override
	public void delete(int id_factura) {
		try {
			plantillaSQL=con.prepareStatement("DELETE FROM POS_FACTURAS WHERE ID_FACTURA=?");
			plantillaSQL.setInt(1,id_factura);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
			
		} catch (Exception e) {
			System.out.println("Error en borrar posicion de factura.");

			System.out.println(e);
		}
		
	}
	
}
