package Proyecto_Final;

import java.time.LocalDateTime;

public class Inventario {
	int userID;
	int ingredienteID;
	double cantidad;
	LocalDateTime caducidad;

	public Inventario(String[] atributo) {
		userID = Integer.parseInt(atributo[0]);
		ingredienteID = Integer.parseInt(atributo[1]);
		cantidad = Double.parseDouble(atributo[2]);
		caducidad = LocalDateTime.parse(atributo[3].replace(' ', 'T'));
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getIngredienteID() {
		return ingredienteID;
	}

	public void setIngredienteID(int ingredienteID) {
		this.ingredienteID = ingredienteID;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDateTime getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(LocalDateTime caducidad) {
		this.caducidad = caducidad;
	}

	public String toString() {
		return "\n\nuserID: " + userID + "\ningredienteID: " + ingredienteID + "\ncantidad: " + cantidad
				+ "\ncaducidad: " + caducidad;
	}

}