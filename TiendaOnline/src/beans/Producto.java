package beans;

public class Producto {
	private int id_producto;
	private int id_categoria;
	private String descripcion;
	private double precio;
	private int stock;
	
	
	public Producto() {}
	
	
	public Producto(int id_producto, int id_categoria, String descripcion, double precio, int stock) {
		super();
		this.id_producto = id_producto;
		this.id_categoria = id_categoria;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", id_categoria=" + id_categoria + ", descripcion="
				+ descripcion + ", precio=" + precio + ", stock=" + stock + "]";
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	

}
