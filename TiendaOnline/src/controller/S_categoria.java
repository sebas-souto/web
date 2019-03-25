package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Producto;
import interfaces.IProductoService;
import service.ProductoService;

/**
 * Servlet implementation class S_categoria
 */
@WebServlet("/S_categoria")
public class S_categoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_categoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*RECOGE LOS DATOS DEL FORMULARIO*/
		HttpSession session=request.getSession(true);//abro sesion
		String user=(String)session.getAttribute("user");
		session.setAttribute("user", user);

		String descripcion=request.getParameter("descripcion");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		IProductoService producto=new ProductoService();
		Vector<Producto> productos=producto.listarProductosPorDescripcion(descripcion);
		
		session.setAttribute("descripcion", descripcion);
		session.setAttribute("productos", productos);//subo a la sesion
			
		RequestDispatcher rd=request.getRequestDispatcher("Productos.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
}
