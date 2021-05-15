package Proyecto_Final;

import java.time.LocalDateTime;

public class IngredienteEnInventario {
	private int inventarioID;
	private IngredienteEnBBDD ingrediente;
	private double cantidad;
	private LocalDateTime caducidad;

	public IngredienteEnInventario(IngredienteEnBBDD ingrediente, String ID, String[] atributo) {
		inventarioID = Integer.parseInt(ID);
		this.ingrediente = ingrediente;
		cantidad = Double.parseDouble(atributo[0]);
		caducidad = LocalDateTime.parse(atributo[1].replace(' ', 'T'));
	}

	public int getInventarioID() {
		return inventarioID;
	}

	public void setInventarioID(int inventarioID) {
		this.inventarioID = inventarioID;
	}

	public IngredienteEnBBDD getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(IngredienteEnBBDD ingrediente) {
		this.ingrediente = ingrediente;
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

	@Override
	public String toString() {
		return "\n\tIngrediente en inventarioID: " + inventarioID + "\n\tingrediente: " + ingrediente + "\n\tcantidad:"
				+ cantidad + "\n\tcaducidad: " + caducidad + "\n";
	}
}