package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.Categoria;

import interfaces.ICategoriaDAO;

public class CategoriaDAO implements ICategoriaDAO {
	private Connection con;
	public PreparedStatement plantillaSQL;
	public Statement sentencia;
	public ResultSet resultado;
	
	public CategoriaDAO(Connection con) {
		this.con=con;
		
		
	}

	
	@Override
	public Categoria findId(int idCategoria) {
		Categoria aux=null;
		
		try {
			plantillaSQL=con.prepareStatement("SELECT * FROM categorias WHERE id_categoria =?");
			plantillaSQL.setInt(1, idCategoria);
			resultado=plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				aux=new Categoria();
				aux.setIdCategoria(resultado.getInt("id_categoria"));
				aux.setDescripcion(resultado.getString("descripcion"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("find "+e);
		
		}
		
		return aux;
	}



	@Override
	public void add(Categoria user) {
		// TODO Auto-generated method stub
		try {
			plantillaSQL=con.prepareStatement("INSERT INTO CATEGORIAS VALUES (?,?)");
			plantillaSQL.setInt(1,user.getIdCategoria());
			plantillaSQL.setString(2, user.getDescripcion());

			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("**"+e);
		}

	}



	@Override
	public void save(Categoria user) {
		try {
			plantillaSQL=con.prepareStatement("UPDATE CATEGORIAS SET DESCRIPCION=?"+"WHERE ID_CATEGORIA=?");
			plantillaSQL.setInt(2, user.getIdCategoria());
			plantillaSQL.setString(1, user.getDescripcion());
			//la posicion va en funcion de la sistesis previamente asignada
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}



	@Override
	public Vector<Categoria> list() {
		
		Vector <Categoria> lista=new Vector();
		try {
			plantillaSQL=con.prepareStatement("SELECT * FROM CATEGORIAS");
			resultado=plantillaSQL.executeQuery();
			while (resultado.next()) {
				Categoria aux=new Categoria();
				aux.setIdCategoria(resultado.getInt("id_categoria"));
				aux.setDescripcion(resultado.getString("descripcion"));
				lista.add(aux);				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
					
		return lista;
	}



	@Override
	public void delete(int idCategoria) {

		try {
			plantillaSQL=con.prepareStatement("DELETE FROM CATEGORIAS WHERE ID_CATEGORIA=?");
			plantillaSQL.setInt(1,idCategoria);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	

	}

}