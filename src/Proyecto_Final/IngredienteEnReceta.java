package Proyecto_Final;

public class IngredienteEnReceta {
	int recetaID;
	private IngredienteEnBBDD ingrediente;
	double cantidad;

	public IngredienteEnReceta(IngredienteEnBBDD ing, String[] atributos) {
		recetaID = Integer.parseInt(atributos[0]);
		ingrediente = ing;
		cantidad = Double.parseDouble(atributos[1]);
	}

	public int getRecetaID() {
		return recetaID;
	}

	public void setRecetaID(int recetaID) {
		this.recetaID = recetaID;
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

	public String toString() {
		return "\n\tcantidad: " + cantidad + ingrediente + "\n";
	}

	public String[] toInsert() {
		String insert = recetaID + ";" + ingrediente.getId() + ";" + cantidad;
		return insert.split(";");
	}

}