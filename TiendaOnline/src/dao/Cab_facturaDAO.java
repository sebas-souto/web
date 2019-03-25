package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.Cab_factura;
import beans.Producto;
import interfaces.ICab_facturaDAO;

public class Cab_facturaDAO implements ICab_facturaDAO{
	private Connection con;
	public PreparedStatement plantillaSQL;
	public Statement sentencia;
	public ResultSet resultado;
	
	public Cab_facturaDAO(Connection con) {
		this.con=con;
		
	}
	@Override
	public Cab_factura findId(int id_factura) {
		Cab_factura aux=null;
		
		try {
			plantillaSQL=con.prepareStatement("SELECT * FROM CAB_FACTURAS WHERE id_factura=?");
			plantillaSQL.setInt(1, id_factura);
			resultado=plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				aux=new Cab_factura();
				aux.setId_factura(resultado.getInt("id_factura"));
				aux.setId_usuario(resultado.getString("id_usuario"));
			}
			
			plantillaSQL.execute();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en find cabecera de factura.");

			System.out.println("find "+e);
		
		}
		
		return aux;
		
	}

	@Override
	public void add(Cab_factura cFactura) {

		try {
			plantillaSQL=con.prepareStatement("INSERT INTO `curso`.`cab_facturas` (`ID_USUARIO`) VALUES (?)");
		//	INSERT INTO `curso`.`cab_facturas` (`ID_USUARIO`) VALUES ('ANA');

			plantillaSQL.setString(1,cFactura.getId_usuario());
			
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en añadir cabecera de factura.");

			System.out.println("**"+e);
		}
			
	}

	@Override
	public void save(Cab_factura cFactura) {
		try {
			plantillaSQL=con.prepareStatement("UPDATE CAB_FACTURAS SET ID_USUARIO=?,"+" WHERE ID_FACTURA=?");
			plantillaSQL.setString(1, cFactura.getId_usuario());
			//la posicion va en funcion de la sistesis previamente asignada
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en actualizar cabecera de factura.");

			System.out.println(e);
		}
		
	}

	@Override
	public Vector<Cab_factura> list() {
		Vector <Cab_factura> lista=new Vector();
		try {
			plantillaSQL=con.prepareStatement("SELECT * FROM CAB_FACTURAS");
			resultado=plantillaSQL.executeQuery();
			while (resultado.next()) {
				Cab_factura aux=new Cab_factura();
				aux.setId_factura(resultado.getInt("id_factura"));
				aux.setId_usuario(resultado.getString("id_usuario"));
			
				lista.add(aux);	
			}
			plantillaSQL.execute();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en listar cabecera de factura.");

			System.out.println(e);
		}
		return lista;
	}

	@Override
	public void delete(int id_factura) {
		try {
			plantillaSQL=con.prepareStatement("DELETE FROM CAB_FACTURAS WHERE ID_FACTURA=?");
			plantillaSQL.setInt(1,id_factura);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
			
		} catch (Exception e) {
			System.out.println("Error en borrar factura.");

			System.out.println(e);
		}
		
	}
	@Override
	public int findLastFactura(String id_usuario) {
		
		int idFactura=0;
		try {
			plantillaSQL=con.prepareStatement("select max(ID_FACTURA) from CAB_FACTURAS WHERE ID_USUARIO=?");
			plantillaSQL.setString(1,id_usuario);
			resultado=plantillaSQL.executeQuery();
			while (resultado.next()) {
			System.out.println(plantillaSQL.toString());
			idFactura=resultado.getInt(1);
			System.out.println("Rescasto los siguientes datos: "+idFactura);
			System.out.println("Estoy en el while de findLastFactura");

			plantillaSQL.execute();
			System.out.println("Estoy en el while de findLastFactura despues de plantillaSQL.execute()");

			}
			System.out.println("salgo del while de findLastFactura");

			

			
		} catch (Exception e) {
			System.out.println("####Error en findLastFactura####");
			System.out.println(e);
		}
		return idFactura;
		
	}

}
