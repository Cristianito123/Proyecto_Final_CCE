package Proyecto_Final;

import java.time.LocalDate;

public class Ingrediente {
	int id;
	private String nombre;
	private int cantidad;
	String medida;
	private LocalDate caducidad;
	private boolean alergeno;
	private boolean lactosa;
	private boolean gluten;
	private boolean vegetal;
	private boolean proteina_animal;


	public Ingrediente() {

	}

	public Ingrediente(String nombre, float peso, int cantidad, LocalDate caducidad) {

	}

	public Ingrediente(String nombre, boolean alergeno, boolean lactosa, boolean gluten, boolean vegetal, boolean fruta,
			boolean carbohidrato, boolean proteina, boolean carne, boolean mariscos, boolean pescado, boolean pollo,
			boolean agrio, boolean acido) {

	}

}
