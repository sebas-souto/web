package beans;

public class Usuario {
	private String idUsuario;
	private String password;
	private String email;
	
	
	public Usuario() {}
	
	public Usuario(String idUsuario, String password, String email) {
		super();
		this.idUsuario = idUsuario;
		this.password = password;
		this.email = email;
	}
	
	

	@Override
	public String toString() {
		return "Usuario \nIdUsuario=" + idUsuario + "\npassword=" + password + "\nemail=" + email + "]";
	}
	
	

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
