package Proyecto_Final;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Controlador {
	private ArrayList<Receta> listaRecetas;
	private ArrayList<IngredienteEnBBDD> listaIngredientes;
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<ImageIcon> listaImagenesRecetas;
	private VentanaLogin login;
	private Utiles util = new Utiles();
	private String[] c = new String[3];
	private BufferedReader br;
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Controlador() {
		login = new VentanaLogin(this);
		listaIngredientes = new ArrayList<IngredienteEnBBDD>();
		listaRecetas = new ArrayList<Receta>();
		listaUsuarios = new ArrayList<Usuario>();
		listaImagenesRecetas = new ArrayList<ImageIcon>();
		login.setProgBar(3);
		conectarBBDD();
		login.setProgBar(6);

		try {
			leerBBDD();
			cargarImagenes();
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
		desconectarBBDD();
	}

	public void conectarBBDD() {
		try {
			br = new BufferedReader(new FileReader("src/file.txt"));
			while (br.ready()) {
				c = br.readLine().split(";");
			}
			br.close();
			System.out.println("Estableciendo conexion con la base de datos"); // TODO BORRAR
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(c[0], c[1], c[2]);
			System.out.println("conexion ok"); // TODO BORRAR
		} catch (ClassNotFoundException | SQLException | IOException e1) {
			e1.printStackTrace();
		}
	}

	public void desconectarBBDD() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void leerBBDD() throws SQLException {
		stmt = conn.createStatement();
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
		login.setProgBar(12);

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
		login.setProgBar(18);

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
		login.setProgBar(24);

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
		login.setProgBar(30);

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
		login.setProgBar(36);

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
		login.setProgBar(42);

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
		login.setProgBar(50);
		System.out.println("ingredientes de recetas ok"); // TODO BORRAR
		System.out.println("todo ok"); // TODO BORRAR

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
		String atributos = "";
		if (listaUsuarios.size() > 0) {
			atributos += (listaUsuarios.get(listaUsuarios.size() - 1).getUserID() + 1);
		} else {
			atributos += "1";
		}
		atributos += ";" + user + ";" + pass + ";" + nombre + ";" + apellidos;
		listaUsuarios.add(new Usuario(atributos.split(";")));
	}

	public void insertBBDD(String orden) {
		try {
			stmt = conn.createStatement();
//"INSERT IGNORE INTO ? VALUES (?)"
			switch (orden) {
			case "ingrediente":
				// TODO PENDIENTE DE PROBAR CUANDO SE IMPLEMENTE UN ALTA INGREDIENTE
				for (IngredienteEnBBDD ing : listaIngredientes) {
					String[] ingrediente = ing.toInsert();
					stmt.executeUpdate("INSERT IGNORE INTO filtro VALUES (" + ingrediente[0] + ",'" + ingrediente[1]
							+ "','" + ingrediente[2] + "'," + ingrediente[3] + "," + ingrediente[4] + ","
							+ ingrediente[5] + "," + ingrediente[6] + "," + ingrediente[7] + ")");
				}
				break;
			case "usuario":
				for (Usuario user : listaUsuarios) {

					String[] usuario = user.toInsert();
					stmt.executeUpdate("INSERT IGNORE INTO usuario VALUES (" + usuario[0] + ",'" + usuario[1] + "','"
							+ usuario[2] + "','" + usuario[3] + "','" + usuario[4] + "')");

					String[] filtro = user.getFiltro().toInsert();
					stmt.executeUpdate("INSERT IGNORE INTO filtro VALUES (" + filtro[0] + "," + filtro[1] + ","
							+ filtro[2] + "," + filtro[3] + "," + filtro[4] + "," + filtro[5] + "," + filtro[6] + ","
							+ filtro[7] + "," + filtro[8] + ")");

					String[] inventario = user.getInventario().toInsert();
					stmt.executeUpdate(
							"INSERT IGNORE INTO Inventario VALUES (" + inventario[0] + "," + inventario[1] + ")");

					ArrayList<IngredienteEnInventario> ingredientes = user.getInventario().getIngredientes();
					for (IngredienteEnInventario ingrediente : ingredientes) {
						String[] ing = ingrediente.toInsert();
						stmt.executeUpdate("INSERT IGNORE INTO IngredientesEnInventario VALUES (" + ing[0] + ","
								+ ing[1] + "," + ing[2] + ",'" + ing[3] + "')");
					}
				}
				break;
			case "receta":
				// TODO PENDIENTE DE PROBAR CUANDO SE IMPLEMENTE UN ALTA RECETA
				for (Receta list : listaRecetas) {
					String[] receta = list.toInsert();
					stmt.executeUpdate("INSERT IGNORE INTO receta VALUES (" + receta[0] + ",'" + receta[1] + "','"
							+ receta[2] + "','" + receta[3] + "'," + receta[4] + "," + receta[5] + "," + receta[6] + ","
							+ receta[7] + "," + receta[8] + "," + receta[9] + ",'" + receta[10] + "')");

					ArrayList<IngredienteEnReceta> ingredientes = list.getIngredientes();
					for (IngredienteEnReceta ingrediente : ingredientes) {
						String[] ing = ingrediente.toInsert();
						stmt.executeUpdate("INSERT IGNORE INTO IngredientesEnReceta VALUES (" + ing[0] + "," + ing[1]
								+ "," + ing[2] + "')");
					}
				}
				break;
			case "preparar":

			}

			// TODO LLAMAR EL METODO desconectarBBDD SIEMPRE QUE SE USE EL METODO insertBBDD

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void updateBBDD(String orden, String parametros) {
		String[] parametro = parametros.split(";");

		try {

//"INSERT IGNORE INTO ? VALUES (?)"
			switch (orden) {
			case "ingrediente":
				pstmt = conn.prepareStatement("");

				for (IngredienteEnBBDD ing : listaIngredientes) {
					String[] ingrediente = ing.toInsert();
					pstmt.executeUpdate("INSERT IGNORE INTO filtro VALUES (" + ingrediente[0] + ",'" + ingrediente[1]
							+ "','" + ingrediente[2] + "'," + ingrediente[3] + "," + ingrediente[4] + ","
							+ ingrediente[5] + "," + ingrediente[6] + "," + ingrediente[7] + ")");
				}
				break;
			case "usuario":
				pstmt = conn.prepareStatement("");
				for (Usuario user : listaUsuarios) {

					String[] usuario = user.toInsert();
					pstmt.executeUpdate("INSERT IGNORE INTO usuario VALUES (" + usuario[0] + ",'" + usuario[1] + "','"
							+ usuario[2] + "','" + usuario[3] + "','" + usuario[4] + "')");

					String[] filtro = user.getFiltro().toInsert();
					pstmt.executeUpdate("INSERT IGNORE INTO filtro VALUES (" + filtro[0] + "," + filtro[1] + ","
							+ filtro[2] + "," + filtro[3] + "," + filtro[4] + "," + filtro[5] + "," + filtro[6] + ","
							+ filtro[7] + "," + filtro[8] + ")");

					String[] inventario = user.getInventario().toInsert();
					pstmt.executeUpdate(
							"INSERT IGNORE INTO Inventario VALUES (" + inventario[0] + "," + inventario[1] + ")");

					ArrayList<IngredienteEnInventario> ingredientes = user.getInventario().getIngredientes();
					for (IngredienteEnInventario ingrediente : ingredientes) {
						String[] ing = ingrediente.toInsert();
						pstmt.executeUpdate("INSERT IGNORE INTO IngredientesEnInventario VALUES (" + ing[0] + ","
								+ ing[1] + "," + ing[2] + ",'" + ing[3] + "')");
					}
				}
				break;
			case "ingEnInvUpdate":
				pstmt = conn.prepareStatement(
						"UPDATE IngredientesEnInventario SET cantidad = ? WHERE inventarioID = ? AND ingredienteID = ?");
				pstmt.setString(1, parametro[0]);
				pstmt.setString(2, parametro[1]);
				pstmt.setString(3, parametro[2]);
				pstmt.executeUpdate();
				break;
			case "ingEnInvDelete":
				pstmt = conn.prepareStatement(
						"DELETE FROM IngredientesEnInventario WHERE inventarioID = ? AND ingredienteID = ?");
				pstmt.setString(1, parametro[0]);
				pstmt.setString(2, parametro[1]);
				pstmt.executeUpdate();
				break;

//				INSERT INTO IngredientesEnInventario (inventarioID, ingredienteID, cantidad, caducidad) VALUES (?,?,?,?) ON DUPLICATE KEY 
//				UPDATE cantidad = ?	
//				ejemplo
//				INSERT INTO IngredientesEnInventario (inventarioID, ingredienteID, cantidad, caducidad) VALUES (2,0,2,'2025-06-30 15:04:50') ON DUPLICATE KEY 
//				UPDATE cantidad = 2;

			case "receta":
				pstmt = conn.prepareStatement("");
				for (Receta list : listaRecetas) {
					String[] receta = list.toInsert();
					pstmt.executeUpdate("INSERT IGNORE INTO receta VALUES (" + receta[0] + ",'" + receta[1] + "','"
							+ receta[2] + "','" + receta[3] + "'," + receta[4] + "," + receta[5] + "," + receta[6] + ","
							+ receta[7] + "," + receta[8] + "," + receta[9] + ",'" + receta[10] + "')");
				}

			}

			// TODO LLAMAR EL METODO desconectarBBDD SIEMPRE QUE SE USE EL METODO updateBBDD

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public ArrayList<IngredienteEnInventario> getListaIngEnInv(String logedUser) {
		ArrayList<IngredienteEnInventario> listaIng = null;
		for (Usuario bus : listaUsuarios) {
			if (bus.getUsername().equalsIgnoreCase(logedUser)) {
				listaIng = bus.getInventario().getIngredientes();
				break;
			}
		}
		return listaIng;
	}

	public ArrayList<Receta> getRecetas() {
		return listaRecetas;
	}

	private void cargarImagenes() throws IOException {
		int count = 50 / (listaRecetas.size());
		int progreso = 50;
		for (Receta bus : listaRecetas) {
			URL url = new URL(bus.getImagenUrl());
			ImageIcon image = new ImageIcon(ImageIO.read(url));
			listaImagenesRecetas.add(new ImageIcon(image.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
			progreso += count;
			login.setProgBar(progreso);
		}
		login.hideProgBar();
		login.setLoginReady();
	}

	public ArrayList<ImageIcon> getIconos() {
		return listaImagenesRecetas;
	}

	public ArrayList<Usuario> getUserList() {
		return listaUsuarios;

	}

	public int getUserID(String user) {
		int userID = 0;
		for (Usuario bus : listaUsuarios) {
			if (bus.getUsername() == user) {
				userID = bus.getUserID();
			}
		}
		return userID;
	}

}