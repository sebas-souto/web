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

import beans.Carrito;
import beans.Producto;
import interfaces.IProductoService;
import service.ProductoService;

/**
 * Servlet implementation class S_VerCarrito
 */
@WebServlet("/S_VerCarrito")
public class S_VerCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_VerCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);//abro sesion
		Vector <Carrito>miCarrito=(Vector <Carrito>)session.getAttribute("miCarrito");
		int idProducto=Integer.parseInt(request.getParameter("id_producto"));
		
		actualizaLista( idProducto,miCarrito);
		double total= dameTotalCarrito(miCarrito);
		session.setAttribute("miCarrito",miCarrito);//subo a la sesion
		session.setAttribute("total", total);
		
		RequestDispatcher rd=request.getRequestDispatcher("miCarrito.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void actualizaLista(int idProducto,Vector <Carrito>miCarrito) {
		IProductoService producto=new ProductoService();
		Producto item=producto.buscarProductos(idProducto);
		boolean resultado=buscaProducto(item,miCarrito);
		
		
	}
	
	private boolean buscaProducto(Producto producto,Vector <Carrito>miCarrito) {
		
		boolean resultado=true;
		for (Carrito item : miCarrito) {
			if(item.getProducto().getId_producto()==producto.getId_producto() && item.getCantidad()>1) {
				item.setCantidad(item.getCantidad()-1);
				resultado=false;
				break;
			}
			if(item.getProducto().getId_producto()==producto.getId_producto() && item.getCantidad()==1) {
				miCarrito.removeElement(item);
				break;
			}
			else {
				resultado=true;
			}
		}
		return resultado;

	}
	private double dameTotalCarrito(Vector <Carrito>miCarrito) {
		double total=0;
		for (Carrito item : miCarrito) {
			System.out.println(item.getProducto().getDescripcion()+" --"+item.getProducto().getPrecio()+" "+item.getCantidad());
			total+=item.getProducto().getPrecio()*item.getCantidad();
			System.out.println(total);
		}
		return total;
	}

}

