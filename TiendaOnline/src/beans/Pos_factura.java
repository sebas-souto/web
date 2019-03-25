package beans;

public class Pos_factura {
	private int id_factura;
	private int pos_factura;
	private int id_producto;
	private int cantidad;
	
	public Pos_factura() {}
	
	public Pos_factura(int id_factura, int pos_factura, int id_producto, int cantidad) {
		super();
		this.id_factura = id_factura;
		this.pos_factura = pos_factura;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Pos_factura [id_factura=" + id_factura + ", pos_facura=" + pos_factura + ", id_producto=" + id_producto
				+ ", cantidad=" + cantidad + "]";
	}

	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	public int getPos_factura() {
		return pos_factura;
	}

	public void setPos_factura(int pos_factura) {
		this.pos_factura = pos_factura;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	

}
