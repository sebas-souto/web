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

import beans.Cab_factura;
import beans.Carrito;
import beans.Pos_factura;
import beans.Producto;
import beans.Usuario;
import dao.Cab_facturaDAO;
import interfaces.ICab_facturaService;
import interfaces.IPos_facturaService;
import interfaces.IProductoService;
import interfaces.IUsuarioService;
import service.Cab_facturaService;
import service.Pos_facturaService;
import service.ProductoService;
import service.UsuarioService;

/**/
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 * Servlet implementation class S_comprar
 */
@WebServlet("/S_comprar")
public class S_comprar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_comprar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//declaro la variable de posicion.
		int posicion=1;
		HttpSession session=request.getSession(true);//abro sesion
		//recogo el carrito.
		Vector <Carrito>miCarrito=(Vector <Carrito>)session.getAttribute("miCarrito");
		//recogo el nombre de usuario.
		String user=(String)session.getAttribute("user");
		

		
		actualizaStock(miCarrito);
		realizarFactura(miCarrito,user,posicion);
		
		session.invalidate();
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/*ALCTUALIZAMOS EL STOCK EN LA BASE DE DATOS:
	 * RECOGEMOS EL STOCK ACTUAL Y LE RESTAMOS LA CANTIDAD DEL ARTICULO QUE ESTA EN EL CARRITO.
	 * LANZAMOS UN UPDATE EN LA BBDD*/
	
	public void actualizaStock(Vector <Carrito>miCarrito) {
		IProductoService stock=new ProductoService();
		for (Carrito item : miCarrito) {
			item.getProducto().setStock(item.getProducto().getStock()-item.getCantidad());;
			stock.save(item.getProducto());
		}
	}
	
	/*GENERAMOS FACTURA: PARA LO CUAL ES NECESARIO:
	 * -CREAR UNA CABECERA DE FACTURA
	 * -GENERAR POSICIONES DE FACTURA CON LOS ARTICULOS CORRESPONDIENTE
	 * -RECOGER TODOS LOS DATOS Y ORDENARLO COMO DISPONGAMOS:
	 * */
	
	public void realizarFactura(Vector <Carrito>miCarrito,String user,int posicion) {
			
			ICab_facturaService generarCabFac=new Cab_facturaService();
			//realizar cab factura
			Cab_factura cFac=new Cab_factura(0,user);
			//la guardamos en la bbdd
			generarCabFac.altaCab_factura(cFac);
			//obtenemos id factura, ya que al ser autoincrementable no disponemos de su id al crearla.
			int idfactura=generarCabFac.buscarUltimaFactura(cFac.getId_usuario());
			System.out.println("paro aqui");

			//con el id de factura obtenido creamos  posision factura
			IPos_facturaService posFactura=new Pos_facturaService();
			System.out.println("paro aqui1");

			//recoremos el carrito y generamos posicion por cada articulo nuevo y lo añadimos en la bbdd
			for (Carrito carrito : miCarrito) {
				Pos_factura factura=new Pos_factura(idfactura, posicion++, carrito.getProducto().getId_producto(), carrito.getCantidad());
				System.out.println("paro aqui2");

				//añadir posfactura
				posFactura.altaPos_factura(factura);
				System.out.println("paro aqui3");

			}
			System.out.println("paro aqui4");

			 imprimirFactura(idfactura);
	}
	
	/*UNA VEZ CREADA BASTA CON OBTENER DE LA BBDD LOS DATOS QUE DISPONEN COMO VARIABLE COMUN EL ID DE FACTURA.
	 * */
	
	public void imprimirFactura(int idFactura ) {
		//declaro mensaje que donde dejaramos los datos de factura en el orden que queramos
		String mensaje="";
		String destino="";
		//imprimir cabecera
		ICab_facturaService dameCabFac=new Cab_facturaService();
		IPos_facturaService damePosFac=new Pos_facturaService();
		IUsuarioService comprador=new UsuarioService ();
		
		//obtenemos cabecera,
		Cab_factura cf=dameCabFac.buscarCab_factura(idFactura);
		
		mensaje+="Nº factura: "+cf.getId_factura()+" Usuario: "+cf.getId_usuario()+"\n";
		Usuario user1=comprador.buscarNombreUsuarios(cf.getId_usuario());
		destino=user1.getEmail();
		//imprimir pos factura
		Vector<Pos_factura> posiciones=damePosFac.buscarPos_factura();
		//recorremos todas las posiciones de la bbdd y nos quedamos con las que coincidan con el id de factura.
		double total=0;
		for (Pos_factura pos_factura : posiciones) {
			if(pos_factura.getId_factura()==idFactura) {
				IProductoService pro=new ProductoService();
				Producto producto=pro.buscarProductos(pos_factura.getId_producto());
				mensaje+=pos_factura.getId_factura()+"     "+pos_factura.getPos_factura()+"   "+producto.getDescripcion()+"   "+pos_factura.getCantidad()+"  Precio Unidad: "+producto.getPrecio()+"\n";
				total+=+pos_factura.getCantidad()*producto.getPrecio();
			}
		}
		mensaje+="TOTAL"+total+ " EUROS";
		System.out.println("Se realiza compra y se envia a : "+destino);
		System.out.println("Se envia el siguiente contenido : "+mensaje);

		 enviarCorreo(mensaje,destino);
		
	}
	

	 public void enviarCorreo(String mensaje,String destino) {
		 
		 	//String destinatario = "cursolucatic2019@gmail.com"; //A quien le quieres escribir.
		    String asunto = "Compra finalizada.";
		    String cuerpo =mensaje;

		    enviarConGMail(destino, asunto, cuerpo);
		 			     
	 }
	
	private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
	    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
	    String remitente = "cursolucatic2019@gmail.com";  //Para la dirección nomcuenta@gmail.com

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "lucatic2019");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "lucatic2019");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
			System.out.println("Error en enviarConGMail.");

	        me.printStackTrace();   //Si se produce un error
	    }
	}
	
	
	 

}
