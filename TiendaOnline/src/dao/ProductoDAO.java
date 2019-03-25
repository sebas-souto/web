package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.Categoria;
import beans.Producto;
import interfaces.IProductoDAO;

public class ProductoDAO implements IProductoDAO{
	
	private Connection con;
	public PreparedStatement plantillaSQL;
	public Statement sentencia;
	public ResultSet resultado;
	
	
	public ProductoDAO(Connection con) {
		this.con=con;
	}

	@Override
	public Producto findId(int idProducto) {
		Producto aux=null;
		
		try {
			plantillaSQL=con.prepareStatement("SELECT * FROM productos WHERE id_producto =?");
			plantillaSQL.setInt(1, idProducto);
			resultado=plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				aux=new Producto();
				aux.setDescripcion(resultado.getString("descripcion"));
				aux.setId_categoria(resultado.getInt("id_categoria"));
				aux.setId_producto(resultado.getInt("id_producto"));
				aux.setPrecio(resultado.getDouble("precio"));
				aux.setStock(resultado.getInt("stock"));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("find "+e);
		
		}
		
		return aux;
		
	}

	@Override
	public void add(Producto producto) {
		
		try {
			plantillaSQL=con.prepareStatement("INSERT INTO PRODUCTOS VALUES (?,?,?,?,?)");
		
			plantillaSQL.setInt(1,producto.getId_producto());
			
			plantillaSQL.setInt(2, producto.getId_categoria());
			plantillaSQL.setString(3, producto.getDescripcion());
			plantillaSQL.setDouble(4, producto.getPrecio());
			plantillaSQL.setInt(5, producto.getStock());
			
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("**"+e);
		}
		
	}

	@Override
	public void save(Producto producto) {
		try {
			plantillaSQL=con.prepareStatement("UPDATE PRODUCTOS SET ID_CATEGORIA=?, DESCRIPCION=?, PRECIO=?, STOCK=?"+" WHERE ID_PRODUCTO=?");
			plantillaSQL.setInt(1, producto.getId_categoria());
			plantillaSQL.setString(2, producto.getDescripcion());
			plantillaSQL.setDouble(3, producto.getPrecio());
			plantillaSQL.setInt(4, producto.getStock());
			plantillaSQL.setInt(5,producto.getId_producto());
			//la posicion va en funcion de la sistesis previamente asignada
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

	@Override
	public Vector<Producto> list() {
		Vector <Producto> lista=new Vector();
		try {
			plantillaSQL=con.prepareStatement("SELECT * FROM PRODUCTOS");
			resultado=plantillaSQL.executeQuery();
			while (resultado.next()) {
				Producto aux=new Producto();
				aux.setDescripcion(resultado.getString("descripcion"));
				aux.setId_categoria(resultado.getInt("id_categoria"));
				aux.setId_producto(resultado.getInt("id_producto"));
				aux.setPrecio(resultado.getDouble("precio"));
				aux.setStock(resultado.getInt("stock"));
				lista.add(aux);				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
				
				
		return lista;
	}

	@Override
	public void delete(int idProducto) {

		try {
			plantillaSQL=con.prepareStatement("DELETE FROM PRODUCTOS WHERE ID_PRODUCTO=?");
			plantillaSQL.setInt(1,idProducto);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	

			
	}

	@Override
	public Vector<Producto> list(String descripcionCategoria) {
		Vector <Producto> lista=new Vector();
		try {
			plantillaSQL=con.prepareStatement("SELECT p.id_producto,p.id_categoria,p.descripcion, p.precio,p.stock FROM PRODUCTOS p INNER JOIN categorias c  ON p.id_categoria =c.id_categoria  where c.descripcion=? ;");
			plantillaSQL.setString(1, descripcionCategoria);
			resultado=plantillaSQL.executeQuery();
			while (resultado.next()) {
				Producto aux=new Producto();
				aux.setId_producto(resultado.getInt(1));
				aux.setId_categoria(resultado.getInt(2));
				aux.setDescripcion(resultado.getString("p.descripcion"));
				aux.setPrecio(resultado.getDouble(4));
				aux.setStock(resultado.getInt(5));
				lista.add(aux);				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
				
		return lista;
	}
	

}
