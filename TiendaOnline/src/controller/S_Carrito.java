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
 * Servlet implementation class S_Carrito
 */
@WebServlet("/S_Carrito")
public class S_Carrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_Carrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);//abro sesion
		Vector <Carrito>miCarrito=(Vector <Carrito>)session.getAttribute("miCarrito");

		int id_producto=Integer.parseInt((String)request.getParameter("id_producto"));
		//System.out.println("Obtengo ID  producto: "+id_producto);
		
		IProductoService producto=new ProductoService();
		Producto productos=producto.buscarProductos(id_producto);
		crearMicarrito(productos,miCarrito);
	
		
		
		session.setAttribute("miCarrito",miCarrito);//subo a la sesion
		session.setAttribute("total", dameTotalCarrito(miCarrito));
		
		
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
	
	

	
	private void crearMicarrito(Producto producto,Vector <Carrito>miCarrito) {
		Carrito compra=new Carrito(0,producto);
		//comprobar si la lista esta vacia, si lo esta añadimos producto.
		if(miCarrito==null) {
			compra.setCantidad(compra.getCantidad()+1);
			
			miCarrito.add(compra);
			return;
		}
		//comprobar si el producto esta en la lista
		boolean listado=buscaProducto(compra,miCarrito);
		//si esta, sumamos cantidad, si no añadimos producto.
		if(listado){
			compra.setCantidad(compra.getCantidad()+1);
			miCarrito.add(compra);
		}
		
	}
	
	private boolean buscaProducto(Carrito compra,Vector <Carrito>miCarrito) {
		boolean resultado=true;
		for (Carrito item : miCarrito) {
			if(item.getProducto().getId_producto()==compra.getProducto().getId_producto()) {
				item.setCantidad(1+item.getCantidad());
			//	System.out.println("Sumo cantidad al producto: "+1+item.getCantidad()+"##"+item.getProducto().getDescripcion());
				resultado=false;
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
			total+=item.getProducto().getPrecio()*item.getCantidad();
		
		}
		
		return total;
	}
	
	
}
