package Proyecto_Final;

import java.util.ArrayList;

public class Inventario {
	private int inventarioID;
	private int userID;
	private ArrayList<IngredienteEnInventario> ingredientes;

	public Inventario(String ID) {
		userID = Integer.parseInt(ID);
	}

	public Inventario(IngredienteEnBBDD[] ingredientesArray, String[] atributos) {
		inventarioID = Integer.parseInt(atributos[0]);
		userID = Integer.parseInt(atributos[0]);
		ingredientes = new ArrayList<IngredienteEnInventario>();

		for (int i = 0; i < ingredientesArray.length; i++) {
			ingredientes.add(
					new IngredienteEnInventario(ingredientesArray[i], atributos[0], atributos[1].split("&&")[i].split("€€")));
		}
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

	// TODO hay que preparar un setter para recibir IngredienteEnBBDD + atributos de
	// IngredienteEnInventario y que haga la misma funcion que el constructor
	public void setIngredientes(ArrayList<IngredienteEnInventario> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String toString() {
		return "\n\nInventarioID: " + inventarioID + "\nuserID: " + userID + "\ningredientes: " + ingredientes + "\n";
	}

}