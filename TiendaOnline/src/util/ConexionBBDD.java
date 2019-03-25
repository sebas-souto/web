package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
static Connection con;
	
	public static Connection conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//(1)
			System.out.println("2");
			String url="jdbc:mysql://localhost:3306/curso?user=root&password=root&useSSL=false&serverTimezone=UTC";////(2)--ip+puerto+tabla+user+pass
			con=DriverManager.getConnection(url);//(2)
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		return con;
	}
	
	
	public static void desconexion() {
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

}
