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
	private ArrayList<IngredienteEnReceta> listaIngredientesEnRecetas;
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<Inventario> listaInventarios;
	private ArrayList<Filtro> listaFiltros;

	Utiles util = new Utiles();

	public Controlador() {
		listaIngredientes = new ArrayList<IngredienteEnBBDD>();
		listaRecetas = new ArrayList<Receta>();
		listaIngredientesEnRecetas = new ArrayList<IngredienteEnReceta>();
		listaUsuarios = new ArrayList<Usuario>();
		listaInventarios = new ArrayList<Inventario>();
		listaFiltros = new ArrayList<Filtro>();

		String bd = "prueba";
		String url = "jdbc:mysql://34.91.89.112:3306/" + bd;
		String user = "zther";
		String pass = "zther";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			System.out.println("Estableciendo coneccion con la base de datos"); // TODO BORRAR
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			System.out.println("ok"); // TODO BORRAR
			leerBBDD(rs, stmt);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

	}

	private void leerBBDD(ResultSet rs, Statement stmt) throws SQLException {
		IngredienteEnBBDD[] ingredientes;
		String row = "", atributos = "", ingredienteID = "", insert = "";
		System.out.println("Leyendo base de datos"); // TODO BORRAR
		rs = stmt.executeQuery("select * from ingrediente");
		while (rs.next()) {
			row = rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4) + ";"
					+ rs.getString(5) + ";" + rs.getString(6) + ";" + rs.getString(7) + ";" + rs.getString(8);
			listaIngredientes.add(new IngredienteEnBBDD(row.split(";")));
		}

		rs = stmt.executeQuery("select * from usuario");
		while (rs.next()) {

			row = rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4) + ";"
					+ rs.getString(5);
			listaUsuarios.add(new Usuario(row.split(";")));
		}

		for (Usuario bus : listaUsuarios) {
			rs = stmt.executeQuery("select * from inventario where userID =" + bus.getUserID());
			ingredienteID = "";
			atributos = "";

			while (rs.next()) {
				System.out.println(bus.nombre);
				ingredienteID += rs.getString(3) + "€€";
				atributos += rs.getString(4) + "€€" + rs.getString(5) + "&&";
			}
			if (!ingredienteID.isEmpty()) {
				ingredientes = new IngredienteEnBBDD[ingredienteID.split("€€").length];

				for (int i = 0; i < ingredientes.length; i++) {
					for (int j = 0; j < listaIngredientes.size(); j++) {
						if (listaIngredientes.get(j).getId() == Integer.parseInt(ingredienteID.split("€€")[i])) {
							ingredientes[i] = new IngredienteEnBBDD(listaIngredientes.get(j).toArray().split(";"));
						}
					}
				}
				insert = bus.getUserID() + ";" + atributos;
				listaInventarios.add(new Inventario(ingredientes, insert.split(";")));
			}
		}

		rs = stmt.executeQuery("select * from filtro");
		while (rs.next()) {
			row = rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4) + ";"
					+ rs.getString(5) + ";" + rs.getString(6) + ";" + rs.getString(7) + ";" + rs.getString(8) + ";"
					+ rs.getString(9);
			listaFiltros.add(new Filtro(row.split(";")));
		}

		rs = stmt.executeQuery("select * from receta");
		while (rs.next()) {
			row = rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4) + ";"
					+ rs.getString(5) + ";" + rs.getString(6) + ";" + rs.getString(7) + ";" + rs.getString(8) + ";"
					+ rs.getString(9) + ";" + rs.getString(10) + ";" + rs.getString(11);
			listaRecetas.add(new Receta(row.split(";")));
		}

		rs = stmt.executeQuery("select * from receta_ingredientes");
		while (rs.next()) {
			row = rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3);
			listaIngredientesEnRecetas.add(new IngredienteEnReceta(row.split(";")));
		}

		rs.close();
		stmt.close();
		System.out.println("ok"); // TODO BORRAR

	}

	public void mostrarUsuarios() {
		System.out.println(listaUsuarios.toString());
	}

//
//	public void mostrarIngredientes() {
//		System.out.println(listaIngredientes.toString());
//	}
//
	public void mostrarInventarios() {
		System.out.println(listaInventarios.toString());
	}
//
//	public void mostrarFiltros() {
//		System.out.println(listaFiltros.toString());
//	}
//
//	public void mostrarRecetas() {
//		System.out.println(listaRecetas.toString());
//	}
//
//	public void mostrarIngredientesEnRecetas() {
//		System.out.println(listaIngredientesEnReceta.toString());
//	}

}