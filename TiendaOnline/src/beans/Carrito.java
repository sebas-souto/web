package beans;

public class Carrito  {
	private int cantidad;
	private Producto producto;
	
	public Carrito() {
		
	}
	
	public Carrito(int cantidad, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Carrito [cantidad=" + cantidad + ", producto=" + producto + "]";
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	

}
