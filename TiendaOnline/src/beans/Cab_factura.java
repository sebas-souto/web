package beans;

public class Cab_factura {
	
		private int id_factura;
		private String id_usuario;
		
		public Cab_factura() {}
		
		public Cab_factura(int id_factura, String id_usuario) {
			super();
			this.id_factura = id_factura;
			this.id_usuario = id_usuario;
		}

		@Override
		public String toString() {
			return "Cab_factura [id_factura=" + id_factura + ", id_usuario=" + id_usuario + "]";
		}

		public int getId_factura() {
			return id_factura;
		}

		public void setId_factura(int id_factura) {
			this.id_factura = id_factura;
		}

		public String getId_usuario() {
			return id_usuario;
		}

		public void setId_usuario(String id_usuario) {
			this.id_usuario = id_usuario;
		}
		
			
}
