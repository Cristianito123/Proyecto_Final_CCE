package Proyecto_Final;

public class Usuario {
	private int userID;
	private Filtro filtro;
	private Inventario inventario;
	private String username;
	private String nombre;
	private String apellidos;
	private String password;

	public Usuario() {
		userID = 0;
		filtro = new Filtro();
		inventario = new Inventario();
		username = "";
		nombre = "";
		apellidos = "";
		password = "";
	}

	public Usuario(String[] atributo) {
		userID = Integer.parseInt(atributo[0]);
		filtro = new Filtro(atributo[0]);
		inventario = new Inventario(atributo[0]);
		username = atributo[1];
		nombre = atributo[3];
		apellidos = atributo[4];
		password = atributo[2];
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int id) {
		this.userID = id;
	}

	public Filtro getFiltro() {
		return filtro;
	}

	public void setFiltro(String[] atributos) {
		filtro = new Filtro(atributos);
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(String atributos) {
		inventario = new Inventario(atributos.split(";"));
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
		return "\nUsername: " + username + "\nNombre: " + nombre + "\nApellidos: " + apellidos + "\nUserID: " + userID
				+ "\nPreferencias: " + filtro + "\nInventarioID: " + inventario + "\n";
	}

	public void toInsert() {
		// TODO Auto-generated method stub

	}
}