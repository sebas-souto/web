package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Carrito;
import beans.Categoria;
import beans.Producto;
import beans.Usuario;
import interfaces.ICategoriaService;
import interfaces.IProductoService;
import interfaces.IUsuarioService;
import service.CategoriaService;
import service.ProductoService;
import service.UsuarioService;

/*
 * PENDIENTE INTRODUCIR COOKIES PARA RECODAR USUARIO Y CONTRASEÑA.
 * */


/**
 * Servlet implementation class S_index
 */
@WebServlet("/S_index")
public class S_index extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*DECLARACION DE VARIABLES E INICIALIZACION*/
		
		 Vector<Carrito> miCarrito=new Vector();
		 HttpSession session=request.getSession(true);//abro sesion
		 String user="";
		 String mensaje="";
		 
		 /*RECOGEMOS LOS PARAMETROS INTRODUCIDOS EN EL FORMULARIO INDEX.JSP*/
		 String password=request.getParameter("password");
		 user=request.getParameter("user");
		
		/*cookie poner check box de recordar datos
		 * guarmos datos
		 * en el html recoremmos array de cookies y completamos campos si procede.
		 * */

		/**/
		//VERIFICAMOS QUE LO CAMPOS NO ESTEN VACIOS
		mensaje=compruebaCampos(user,  password);
		//CONFIRMAMOS QUE EL USUARIO ESTE EN LA BBDD Y QUE LA CLAVE COINCIDA.
		System.out.println("Proce a verificacion: "+user+password);
		
		if(mensaje.equals("OK"))  mensaje=verificaLogin( user, password);
		
		//PASAMOS LAS VARIABLES POR SESSION
		session.setAttribute("user", user);
		session.setAttribute("mensaje", mensaje);
		
		
		//CARGAMOS LA SESION O RECARGAMOS EL INDEX EN FUNCION DE LA COMPROBACION PREVIA
		System.out.println("El mensaje posterior a la comparacion es: "+ mensaje);
		if(mensaje.equals("Has iniciado sesion correctamente :)")) {
			cargaSesion( request,  response,user);
			session.setAttribute("miCarrito", miCarrito);						
			}
		
		else {
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			session.setAttribute("user", user);
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
	
	//REALIZAMOS LA COMPROBACION DEL LOGIN LLAMANDO A TRES METODOS DISTINTOS:
	/*compruebaCampos(nombre,pass): VERIFICAMOS QUE LOS CAMPOS NO ESTEN VACIOS, NINGUNO DE ELLOS. RETORNA STRING
	 * usuariosservice.confirmaUser(nombre, pass):VEFICAMOS USUARIO Y COMPARAMOS PASS(BBDD VS FORMULARIO). RETORNA BOOLEAN
	 * verificaDatos(confimar);-PASAMOS EL BOOLEAN Y NOS DEVUELVE EL MENSAJE 
	 * EN CASO DE ERROR CAPTURA Exception
	 * */
	private  String verificaLogin(String nombre,String pass) {
		
		UsuarioService usuariosservice=new UsuarioService();
	    String mensaje="";
	    
		try {
			
			boolean confimar=usuariosservice.confirmaUser(nombre, pass);
			System.out.println("Confirmacion de usuario: "+confimar);
			mensaje=verificaDatos(confimar);
						
			return mensaje;
			
		}catch (Exception e) {
			return "Se ha producido un error verifique los datos introducidos.";
		}
	}
	
	
	private String compruebaCampos(String nombre, String pass) {
		if (nombre.isEmpty() && pass.isEmpty()) {
			
			return "Introduce usuario y contraseña.";
		}
		if (nombre.isEmpty()|| pass.isEmpty()) {
			
			return "Campo de usuario o contraseña vacio.";
		}
		else return "OK";
	}

	
	private String verificaDatos(boolean confimar) {
		
		if (confimar) {
			System.out.println("Realizo la confirmacion");
		 return "Has iniciado sesion correctamente :)";
		}

		else {
		
			return "Contraseña o usuario incorrecto.";
		}
		
	}
	
	
	private void cargaSesion(HttpServletRequest request, HttpServletResponse response,String usuario) {
		HttpSession session=request.getSession(true);//abro sesion
		ICategoriaService categoria=new CategoriaService();
			
		Vector<Categoria> categorias=categoria.listarCategorias();
		
		String pagina="Categoria.jsp";
		session.setAttribute("user", usuario);	 
		session.setAttribute("categorias", categorias);
		RequestDispatcher rd=request.getRequestDispatcher("Categoria.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void cargarCookie(String user, String password,HttpServletResponse response) {
		
		Cookie cusuario=new Cookie("user",user);
		Cookie cpassword=new Cookie("password",password);
		cusuario.setMaxAge(3600);//durancion de la cookie.
		System.out.println("Realizo la cookie.");
		response.addCookie(cusuario);
		response.addCookie(cpassword);
		
	}
	
	private void leerCookies(HttpServletRequest request) {
		Cookie[] cookies=request.getCookies();//recupero cookies
		for (int i = 0; i < cookies.length; i++) {
			Cookie aux=cookies[i];
			System.out.println(aux.getName()+" "+aux.getValue());
		}
	}
	
		
}

