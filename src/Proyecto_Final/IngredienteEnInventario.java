package Proyecto_Final;

import java.time.LocalDateTime;

public class IngredienteEnInventario {
	private int inventarioID;
	private IngredienteEnBBDD ingrediente;
	private double cantidad;
	private LocalDateTime caducidad;

	public IngredienteEnInventario(IngredienteEnBBDD ing, String[] atributos) {
		inventarioID = Integer.parseInt(atributos[0]);
		ingrediente = ing;
		cantidad = Double.parseDouble(atributos[1]);
		caducidad = LocalDateTime.parse(atributos[2].replace(' ', 'T'));
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
		return "\n\tcantidad en inventario: " + cantidad + ingrediente + "\tcaducidad: " + caducidad + "\n";
	}

	public String[] toInsert() {
		String insert = inventarioID + ";" + ingrediente.getId() + ";" + cantidad + ";"
				+ caducidad.toString().replace("T", " ");
		return insert.split(";");
	}
}