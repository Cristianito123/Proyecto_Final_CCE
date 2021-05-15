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

	public Inventario(String[] atributo) {
		inventarioID = Integer.parseInt(atributo[0]);
		userID = Integer.parseInt(atributo[1]);
	}

	public int getUserID() {
		return userID;
	}

	public int getInventarioID() {
		return inventarioID;
	}

	public void setInventarioID(int inventarioID) {
		this.inventarioID = inventarioID;
	}

	public ArrayList<IngredienteEnInventario> getIngredientes() {
		return ingredientes;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String toString() {
		return "\n\nInventarioID: " + inventarioID + "\nuserID: " + userID + "\ningredientes: " + ingredientes + "\n";
	}

	public void setIngredientes(IngredienteEnBBDD[] ingredientesArray, String atributos) {
		ingredientes = new ArrayList<IngredienteEnInventario>();
		for (int i = 0; i < ingredientesArray.length; i++) {
			ingredientes.add(new IngredienteEnInventario(ingredientesArray[i], this.inventarioID,
					atributos.split("&&")[i].split("€€")));
		}
	}

}