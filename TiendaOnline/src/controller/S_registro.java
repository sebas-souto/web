package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.Usuario;
import interfaces.IUsuarioService;
import service.UsuarioService;



/**
 * Servlet implementation class S_Registro
 */
@WebServlet("/S_registro")
public class S_registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static int error=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_registro() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);//abro sesion
	
		/*RECOGE LOS DATOS DEL FORMULARIO*/
		String usuario=request.getParameter("user");
		String password=request.getParameter("password");
		String correo=request.getParameter("email");

		session.setAttribute("user", usuario);
		session.setAttribute("password", password);
		
		String mensaje="";
		error=0;
		mensaje=procederAlta(usuario,password,correo);
		
		session.setAttribute("mensaje", mensaje);
		
		if(error==0) {
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("registro.jsp");
			rd.forward(request, response);
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private static String procederAlta(String nombre,String password,String correo) {
		if(nombre==null||password==null||nombre==null) {
			error++;
			return "Verifique que ningun campo este vacio. ";
		}
		else {
			return altaUsuario(nombre,password,correo);
		}
	}
		
	public static String altaUsuario(String nombre,String password,String correo) {
		IUsuarioService usuariosservice=new UsuarioService();
		Usuario user=null;
		try {
			
			if(nombre!="" && password!="" && correo!="") {
				 user=usuariosservice.buscarNombreUsuarios(nombre);
				if (user==null) {
					user=new Usuario(nombre,password,correo); 
					usuariosservice.altaUsuario(user);
					return "Se ha dado de alta al usuario correctamente.";
				}
				else { 
					error++;
					return "El usuario introducido ya existe.";
					}
		}
		
			else {
				error++;
				return "Uno o varios campos estan vacios, verifique los datos introducidos.";
			}
		} catch (Exception e) {
			error++;
			return "Se ha producido un error, compruebe los datos introducidos.";
		}	
		
	}
				
}
