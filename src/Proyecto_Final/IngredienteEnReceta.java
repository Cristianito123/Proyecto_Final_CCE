package Proyecto_Final;

public class IngredienteEnReceta {
	int recetaID;
	int ingredienteID;
	double cantidad;

	public IngredienteEnReceta(String[] atributo) {
		recetaID = Integer.parseInt(atributo[0]);
		ingredienteID = Integer.parseInt(atributo[1]);
		cantidad = Double.parseDouble(atributo[2]);
	}

	public int getRecetaID() {
		return recetaID;
	}

	public void setRecetaID(int recetaID) {
		this.recetaID = recetaID;
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

	public String toString() {
		return "\n\n recetaID: " + recetaID + "\ningredienteID: " + ingredienteID + "\ncantidad: " + cantidad;
	}

}