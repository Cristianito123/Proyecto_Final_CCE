package Proyecto_Final;

public class Filtro {
	int userID;
	boolean vegetariano;
	boolean vegano;
	boolean alergico;
	boolean intolerante_lactosa;
	boolean intolerante_gluten;
	boolean buscar_salado;
	boolean buscar_dulce;
	boolean buscar_picante;

	public Filtro() {
		userID = 0;
		vegetariano = false;
		vegano = false;
		alergico = false;
		intolerante_lactosa = false;
		intolerante_gluten = false;
		buscar_salado = false;
		buscar_dulce = false;
		buscar_picante = false;
	}

	public Filtro(String id) {
		userID = Integer.parseInt(id);
		vegetariano = true;
		vegano = true;
		alergico = true;
		intolerante_lactosa = false;
		intolerante_gluten = false;
		buscar_salado = false;
		buscar_dulce = false;
		buscar_picante = false;
	}

	public Filtro(String[] atributo) {
		userID = Integer.parseInt(atributo[0]);
		if (atributo[1].equalsIgnoreCase("1")) {
			vegetariano = true;
		} else {
			vegetariano = false;
		}
		if (atributo[2].equalsIgnoreCase("1")) {
			vegano = true;
		} else {
			vegano = false;
		}
		if (atributo[3].equalsIgnoreCase("1")) {
			alergico = true;
		} else {
			alergico = false;
		}
		if (atributo[4].equalsIgnoreCase("1")) {
			intolerante_lactosa = true;
		} else {
			intolerante_lactosa = false;
		}
		if (atributo[5].equalsIgnoreCase("1")) {
			intolerante_gluten = true;
		} else {
			intolerante_gluten = false;
		}
		if (atributo[6].equalsIgnoreCase("1")) {
			buscar_salado = true;
		} else {
			buscar_salado = false;
		}
		if (atributo[7].equalsIgnoreCase("1")) {
			buscar_dulce = true;
		} else {
			buscar_dulce = false;
		}
		if (atributo[8].equalsIgnoreCase("1")) {
			buscar_picante = true;
		} else {
			buscar_picante = false;
		}
	}

	public int getUser() {
		return userID;
	}

	public void setUser(int user) {
		this.userID = user;
	}

	public boolean isVegetariano() {
		return vegetariano;
	}

	public void setVegetariano(boolean vegetariano) {
		this.vegetariano = vegetariano;
	}

	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}

	public boolean isAlergico() {
		return alergico;
	}

	public void setAlergico(boolean alergico) {
		this.alergico = alergico;
	}

	public boolean isIntolerante_lactosa() {
		return intolerante_lactosa;
	}

	public void setIntolerante_lactosa(boolean intolerante_lactosa) {
		this.intolerante_lactosa = intolerante_lactosa;
	}

	public boolean isIntolerante_gluten() {
		return intolerante_gluten;
	}

	public void setIntolerante_gluten(boolean intolerante_gluten) {
		this.intolerante_gluten = intolerante_gluten;
	}

	public boolean isBuscar_salado() {
		return buscar_salado;
	}

	public void setBuscar_salado(boolean buscar_salado) {
		this.buscar_salado = buscar_salado;
	}

	public boolean isBuscar_dulce() {
		return buscar_dulce;
	}

	public void setBuscar_dulce(boolean buscar_dulce) {
		this.buscar_dulce = buscar_dulce;
	}

	public boolean isBuscar_picante() {
		return buscar_picante;
	}

	public void setBuscar_picante(boolean buscar_picante) {
		this.buscar_picante = buscar_picante;
	}

	@Override
	public String toString() {
		return "\n\tvegetariano: " + vegetariano + "\n\tvegano: " + vegano + "\n\talergico: " + alergico
				+ "\n\tintolerante_lactosa: " + intolerante_lactosa + "\n\tintolerante_gluten: " + intolerante_gluten
				+ "\n\tbuscar_salado: " + buscar_salado + "\n\tbuscar_dulce: " + buscar_dulce + "\n\tbuscar_picante: "
				+ buscar_picante + "\n\tFiltro_userid_" + userID + "\n";
	}

	public void toInsert() {
		// TODO Auto-generated method stub

	}
}