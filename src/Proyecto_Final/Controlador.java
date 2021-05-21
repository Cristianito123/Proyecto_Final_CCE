package Proyecto_Final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Controlador {
	private ArrayList<Receta> listaRecetas;
	private ArrayList<IngredienteEnBBDD> listaIngredientes;
	private ArrayList<Usuario> listaUsuarios;
	private VentanaLogin login;
	private Utiles util = new Utiles();

	public Controlador() {
		login = new VentanaLogin(this);
		listaIngredientes = new ArrayList<IngredienteEnBBDD>();
		listaRecetas = new ArrayList<Receta>();
		listaUsuarios = new ArrayList<Usuario>();

		String bd = "PF_CCE";
		String url = "jdbc:mysql://34.91.89.112:3306/" + bd;
		String user = "zther";
		String pass = "zther";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			login.setProgBar(1);
			System.out.println("Estableciendo conexion con la base de datos"); // TODO BORRAR
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			System.out.println("conexion ok"); // TODO BORRAR
			login.setProgBar(5);
			leerBBDD(rs, stmt);

			stmt.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	private void leerBBDD(ResultSet rs, Statement stmt) throws SQLException {
		String row = "", atributos = "", ingredienteID = "";
		int i = 0;
		System.out.println("Leyendo base de datos"); // TODO BORRAR

		// POBLAR ARRAYLIST DE INGREDIENTES
		rs = stmt.executeQuery("select * from ingrediente");
		while (rs.next()) {
			row = rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4) + ";"
					+ rs.getString(5) + ";" + rs.getString(6) + ";" + rs.getString(7) + ";" + rs.getString(8);
			if (!row.isEmpty()) {
				listaIngredientes.add(new IngredienteEnBBDD(row.split(";")));
			}
		}
		System.out.println("ingredientes en la BBDD ok"); // TODO BORRAR
		login.setProgBar(10);

		// POBLAR ARRAYLIST DE USUARIOS
		rs = stmt.executeQuery("select * from usuario");
		while (rs.next()) {

			row = rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4) + ";"
					+ rs.getString(5);
			if (!row.isEmpty()) {
				listaUsuarios.add(new Usuario(row.split(";")));
			}
		}
		System.out.println("usuarios ok"); // TODO BORRAR
		login.setProgBar(20);

		// POBLAR ARRAYLIST DE INVENTARIOS
		i = 0;
		for (Usuario bus : listaUsuarios) {
			rs = stmt.executeQuery("select * from Inventario where userID =" + bus.getUserID());
			while (rs.next()) {
				row = rs.getString(1) + ";" + rs.getString(2);
				if (!row.isEmpty()) {
					listaUsuarios.get(i).setInventario(row);
				}
			}
			i++;
		}
		System.out.println("inventarios ok"); // TODO BORRAR
		login.setProgBar(30);

		// POBLAR INVENTARIOS CON INGREDIENTES
		i = 0;
		for (Usuario bus : listaUsuarios) {
			rs = stmt.executeQuery("select * from IngredientesEnInventario where inventarioID ="
					+ bus.getInventario().getInventarioID());
			while (rs.next()) {
				ingredienteID = rs.getString(2);
				atributos = rs.getString(1) + ";" + rs.getString(3) + ";" + rs.getString(4);
				if (!ingredienteID.isEmpty()) {
					for (IngredienteEnBBDD ing : listaIngredientes) {
						if (ing.getId() == Integer.parseInt(ingredienteID)) {
							listaUsuarios.get(i).getInventario().setIngrediente(ing, atributos);
						}
					}
				}
			}
			i++;
		}
		System.out.println("ingredientes en inventarios ok"); // TODO BORRAR
		login.setProgBar(40);

		// GUARDAR PREFERENCIAS DE LOS USUARIOS
		i = 0;
		for (Usuario bus : listaUsuarios) {
			rs = stmt.executeQuery("select * from filtro where userID=" + bus.getUserID());
			while (rs.next()) {
				row = rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4) + ";"
						+ rs.getString(5) + ";" + rs.getString(6) + ";" + rs.getString(7) + ";" + rs.getString(8) + ";"
						+ rs.getString(9);
				if (!row.isEmpty()) {
					listaUsuarios.get(i).setFiltro(row.split(";"));
				}
			}
			i++;
		}
		System.out.println("filtros ok"); // TODO BORRAR
		login.setProgBar(60);

		// POBLAR ARRAYLIST DE RECETAS
		rs = stmt.executeQuery("select * from receta");
		while (rs.next()) {
			row = rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4) + ";"
					+ rs.getString(5) + ";" + rs.getString(6) + ";" + rs.getString(7) + ";" + rs.getString(8) + ";"
					+ rs.getString(9) + ";" + rs.getString(10) + ";" + rs.getString(11);
			if (!row.isEmpty()) {
				listaRecetas.add(new Receta(row.split(";")));
			}
		}
		System.out.println("recetas ok"); // TODO BORRAR
		login.setProgBar(80);

		// POBLAR RECETAS CON INGREDIENTES
		i = 0;
		for (Receta bus : listaRecetas) {
			rs = stmt.executeQuery("select * from IngredientesEnReceta where recetaID =" + bus.getRecetaID());
			while (rs.next()) {
				ingredienteID = rs.getString(2);
				atributos = rs.getString(1) + ";" + rs.getString(3);
				if (!row.isEmpty()) {
					for (IngredienteEnBBDD ing : listaIngredientes) {
						if (ing.getId() == Integer.parseInt(ingredienteID)) {
							listaRecetas.get(i).setIngrediente(ing, atributos);
						}
					}
				}
			}
			i++;
		}
		login.setProgBar(100);
		System.out.println("ingredientes de recetas ok"); // TODO BORRAR
		rs.close();
		System.out.println("todo ok"); // TODO BORRAR
		login.hideProgBar();

	}

	public void mostrarUsuarios() {
		System.out.println(listaUsuarios.toString());
	}

	public void mostrarIngredientes() {
		System.out.println(listaIngredientes.toString());
	}

	public void mostrarRecetas() {
		System.out.println(listaRecetas.toString());
	}

	public boolean checkUser(String user) {
		for (Usuario bus : listaUsuarios) {
			if (bus.getUsername().equalsIgnoreCase(user)) {
				return true;
			}
		}
		return false;
	}

	public boolean chekPass(char[] password, String user) {
		String pass = util.getPass(password);
		for (Usuario bus : listaUsuarios) {
			if (bus.getPassword().equalsIgnoreCase(pass) && bus.getUsername().equalsIgnoreCase(user)) {
				return true;
			}
		}
		return false;
	}

	public void userAdd(String user, String nombre, String apellidos, String pass) {
		listaUsuarios.add(new Usuario(user, nombre, apellidos, pass));
	}

}