package Proyecto_Final;

public class IngredienteEnBBDD {
	private int id;
	private String nombre;
	private String medida;
	private boolean alergeno;
	private boolean lactosa;
	private boolean gluten;
	private boolean vegetal;
	private boolean proteina_animal;

	public IngredienteEnBBDD() {
		id = 0;
		nombre = "";
		medida = "";
		alergeno = false;
		lactosa = false;
		gluten = false;
		vegetal = false;
		proteina_animal = false;
	}

	public IngredienteEnBBDD(String[] atributo) {
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

	public String toString() {
		return medida + "\n\tNombre: " + nombre + "\n\tIngredienteID: " + id + "\n\tAlergeno: " + alergeno
				+ "\n\tLactosa: " + lactosa + "\n\tGluten: " + gluten + "\n\tVegetal: " + vegetal
				+ "\n\tProteina animal: " + proteina_animal + "\n";
	}

	public String toArray() {
		return id + ";" + nombre + ";" + medida + ";" + alergeno + ";" + lactosa + ";" + gluten + ";" + vegetal + ";"
				+ proteina_animal;
	}
	
	public String toName() {
		return nombre;
	}

	public String[] toInsert() {
		int aler = 0;
		int lact = 0;
		int glut = 0;
		int vege = 0;
		int prot = 0;

		if (alergeno) {
			aler = 1;
		} else {
			aler = 0;
		}
		if (lactosa) {
			lact = 1;
		} else {
			lact = 0;
		}
		if (gluten) {
			glut = 1;
		} else {
			glut = 0;
		}
		if (vegetal) {
			vege = 1;
		} else {
			vege = 0;
		}
		if (proteina_animal) {
			prot = 1;
		} else {
			prot = 0;
		}

		String insert = id + ";" + nombre + ";" + medida + ";" + aler + ";" + lact + ";" + glut + ";" + vege + ";"
				+ prot;
		return insert.split(";");
	}
}