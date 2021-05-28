package Proyecto_Final;

import java.util.ArrayList;

public class Inventario {
	private int inventarioID;
	private int userID;
	private ArrayList<IngredienteEnInventario> ingredientes;

	public Inventario() {
		inventarioID = 0;
		userID = 0;
		ingredientes = new ArrayList<IngredienteEnInventario>();
	}

	public Inventario(String id) {
		inventarioID = Integer.parseInt(id);
		userID = Integer.parseInt(id);
		ingredientes = new ArrayList<IngredienteEnInventario>();
	}

	public Inventario(String[] atributo) {
		inventarioID = Integer.parseInt(atributo[0]);
		userID = Integer.parseInt(atributo[1]);
		ingredientes = new ArrayList<IngredienteEnInventario>();
	}

	public int getInventarioID() {
		return inventarioID;
	}

	public void setInventarioID(int inventarioID) {
		this.inventarioID = inventarioID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public ArrayList<IngredienteEnInventario> getIngredientes() {
		return ingredientes;
	}

	public void setIngrediente(IngredienteEnBBDD ing, String atributos) {
		System.out.println(atributos);// TODO BORRAR
		ingredientes.add(new IngredienteEnInventario(ing, atributos.split(";")));
	}

	public String toString() {
		return inventarioID + "" + ingredientes + "\n";
	}

	public String[] toInsert() {
		String insert = inventarioID + ";" + userID;
		return insert.split(";");
	}

	public void removeIngrediente(int ingIndex) {
		ingredientes.remove(ingIndex);
	}

}