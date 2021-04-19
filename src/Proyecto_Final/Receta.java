package Proyecto_Final;

public class Receta {
	Ingrediente[] ingredientes;
	String descripcion;
	String preparacion;

	// filtros de ajustes y preferencias
	boolean vegetariano;
	boolean vegano;

	// filtros de busqueda
	int tiempo;
	boolean salado;
	boolean dulce;
	boolean picante;

	public Receta() {
		ingredientes = null;
		descripcion = "";
		preparacion = "";
		vegetariano = false;
		vegano = false;
		tiempo = 0;
		salado = false;
		dulce = false;
		picante = false;
	}

}
