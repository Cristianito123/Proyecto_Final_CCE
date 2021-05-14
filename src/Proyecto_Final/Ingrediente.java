package Proyecto_Final;

public class Ingrediente {
	private int id;
	private String nombre;
	private String medida;
	private boolean alergeno;
	private boolean lactosa;
	private boolean gluten;
	private boolean vegetal;
	private boolean proteina_animal;

	public Ingrediente(String[] atributo) {
		id = Integer.parseInt(atributo[0]);
		nombre = atributo[1];
		medida = atributo[2];
		if (atributo[3].equalsIgnoreCase("1")) {
			alergeno = true;
		} else {
			alergeno = false;
		}
		if (atributo[4].equalsIgnoreCase("1")) {
			lactosa = true;
		} else {
			lactosa = false;
		}
		if (atributo[5].equalsIgnoreCase("1")) {
			gluten = true;
		} else {
			gluten = false;
		}
		if (atributo[6].equalsIgnoreCase("1")) {
			vegetal = true;
		} else {
			vegetal = false;
		}
		if (atributo[7].equalsIgnoreCase("1")) {
			proteina_animal = true;
		} else {
			proteina_animal = false;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public boolean isAlergeno() {
		return alergeno;
	}

	public void setAlergeno(boolean alergeno) {
		this.alergeno = alergeno;
	}

	public boolean isLactosa() {
		return lactosa;
	}

	public void setLactosa(boolean lactosa) {
		this.lactosa = lactosa;
	}

	public boolean isGluten() {
		return gluten;
	}

	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}

	public boolean isVegetal() {
		return vegetal;
	}

	public void setVegetal(boolean vegetal) {
		this.vegetal = vegetal;
	}

	public boolean isProteina_animal() {
		return proteina_animal;
	}

	public void setProteina_animal(boolean proteina_animal) {
		this.proteina_animal = proteina_animal;
	}

	@Override
	public String toString() {
		return "\nIngrediente N�: " + id + "\nNombre: " + nombre + "\nMedida: " + medida + "\nAlergeno: " + alergeno
				+ "\nLactosa: " + lactosa + "\nGluten: " + gluten + "\nVegetal: " + vegetal + "\nProteina animal: "
				+ proteina_animal;
	}

}