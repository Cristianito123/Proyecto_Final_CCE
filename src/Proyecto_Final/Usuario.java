package Proyecto_Final;

public class Usuario {
	int id;
	String username;
	String nombre;
	String apellidos;
	String password;

	public Usuario(String[] atributo) {
		id = Integer.parseInt(atributo[0]);
		username = atributo[1];
		nombre = atributo[3];
		apellidos = atributo[4];
		password = atributo[2];
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "\nid: " + id + "\nUsername: " + username + "\nNombre: " + nombre + "\nApellidos: " + apellidos;
	}
}