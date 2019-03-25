package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.Usuario;
import interfaces.IUsuarioDAO;

public class UsuarioDAO implements IUsuarioDAO {
	private Connection con;
	public PreparedStatement plantillaSQL;
	public Statement sentencia;
	public ResultSet resultado;

	
	
	public UsuarioDAO(Connection con) {
		this.con=con;
	}



	@Override
	public Usuario findId(String idUsuario) {
		Usuario aux=null;
		try {
			plantillaSQL=con.prepareStatement("SELECT * FROM usuarios WHERE id_usuario =?");
			plantillaSQL.setString(1, idUsuario);
			resultado=plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				aux=new Usuario();
				aux.setEmail(resultado.getString("email"));
				aux.setIdUsuario(resultado.getString("id_usuario"));
				aux.setPassword(resultado.getString("password"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("find "+e);
		
		}
		
		return aux;
	}



	@Override
	public void add(Usuario user) {
		// TODO Auto-generated method stub
		try {
			plantillaSQL=con.prepareStatement("INSERT INTO USUARIOS VALUES (?,?,?)");
			plantillaSQL.setString(1,user.getIdUsuario());
			plantillaSQL.setString(2, user.getPassword());
			plantillaSQL.setString(3, user.getEmail());
	
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());
			
		} catch (Exception e) {
		
			System.out.println("**"+e);
		}

	}



	@Override
	public void save(Usuario user) {
		try {
			plantillaSQL=con.prepareStatement("UPDATE USUARIOS SET PASSWORD=?, EMAIL=?"+"WHERE ID_USUARIO=?");
			plantillaSQL.setString(3, user.getIdUsuario());
			plantillaSQL.setString(1, user.getPassword());
			plantillaSQL.setString(2, user.getEmail());
			//la posicion va en funcion de la sistesis previamente asignada
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}



	@Override
	public Vector<Usuario> list() {
		
		Vector <Usuario> lista=new Vector();
		try {
			plantillaSQL=con.prepareStatement("SELECT * FROM USUARIOS");
			resultado=plantillaSQL.executeQuery();
			while (resultado.next()) {
				Usuario aux=new Usuario();
				
				aux=new Usuario();
				aux.setEmail(resultado.getString("email"));
				aux.setIdUsuario(resultado.getString("id_usuario"));
				aux.setPassword(resultado.getString("password"));
				lista.add(aux);				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
				
				
		return lista;
	}



	@Override
	public void delete(String idUsuario) {

		try {
			plantillaSQL=con.prepareStatement("DELETE FROM USUARIOS WHERE ID_USUARIO=?");
			plantillaSQL.setString(1, idUsuario);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}



	@Override
	public Vector<Usuario> list(String descripcionProducto,int tipo_consulta) {

		Vector <Usuario> lista=new Vector();
		try {
			if(tipo_consulta==1) {
			plantillaSQL=con.prepareStatement("SELECT u.id_usuario FROM PRODUCTOS p INNER JOIN pos_facturas pf ON p.id_producto =pf.id_producto INNER JOIN cab_facturas cf ON pf.id_factura =cf.id_factura INNER JOIN usuarios u  ON u.id_usuario =cf.id_usuario where p.descripcion=?;");
			}
			else {
			plantillaSQL=con.prepareStatement("SELECT distinct u.id_usuario FROM PRODUCTOS p INNER JOIN categorias c ON p.id_categoria =c.id_categoria INNER JOIN pos_facturas pf ON p.id_producto =pf.id_producto INNER JOIN cab_facturas cf ON pf.id_factura =cf.id_factura INNER JOIN usuarios u  ON u.id_usuario =cf.id_usuario where c.descripcion=?;");
			}
			plantillaSQL.setString(1, descripcionProducto);
			resultado=plantillaSQL.executeQuery();
			while (resultado.next()) {
				Usuario aux=new Usuario();
				aux=new Usuario();
				aux.setIdUsuario(resultado.getString("id_usuario"));
				lista.add(aux);				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
				
				
		return lista;
	}






	
	
}
