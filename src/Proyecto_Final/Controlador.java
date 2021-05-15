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

		String bd = "PF_CCE";
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
		String row = "", atributos = "", ingredienteID = "";
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

		// POBLAR ARRAYLIST DE USUARIOS
		rs = stmt.executeQuery("select * from usuario");
		while (rs.next()) {

			row = rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4) + ";"
					+ rs.getString(5);
			if (!row.isEmpty()) {
				listaUsuarios.add(new Usuario(row.split(";")));
			}
		}

		// POBLAR ARRAYLIST DE INVENTARIOS
		for (Usuario bus : listaUsuarios) {
			rs = stmt.executeQuery("select * from Inventario where userID =" + bus.getUserID());
			while (rs.next()) {
				row = rs.getString(1) + ";" + rs.getString(2);
				if (!row.isEmpty()) {
					listaInventarios.add(new Inventario(row.split(";")));
				}
			}
		}

		// POBLAR INVENTARIOS CON INGREDIENTES
		for (Inventario bus : listaInventarios) {
			rs = stmt
					.executeQuery("select * from IngredientesEnInventario where inventarioID =" + bus.getInventarioID());
			ingredienteID = "";
			atributos = "";
			int i = 0;

			while (rs.next()) {
				ingredienteID += rs.getString(2) + "€€";
				atributos += rs.getString(3) + "€€" + rs.getString(4) + "&&";
			}
			if (!ingredienteID.isEmpty()) {
				ingredientes = new IngredienteEnBBDD[ingredienteID.split("€€").length];

				for (int j = 0; j < ingredientes.length; j++) {
					for (int k = 0; k < listaIngredientes.size(); k++) {
						if (listaIngredientes.get(k).getId() == Integer.parseInt(ingredienteID.split("€€")[j])) {
							ingredientes[j] = new IngredienteEnBBDD(listaIngredientes.get(k).toArray().split(";"));
						}
					}
				}
				listaInventarios.get(i).setIngredientes(ingredientes, atributos);
				i++;
			}
		}

		// AUN NO LLEGO AQUI XD
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

		rs = stmt.executeQuery("select * from IngredientesEnReceta");
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