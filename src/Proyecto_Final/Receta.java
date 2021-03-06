package Proyecto_Final;

import java.util.ArrayList;

public class Receta {
	private int recetaID;
	private String nombre;
	private ArrayList<IngredienteEnReceta> ingredientes;
	private String descripcion;
	private String preparacion;
	private boolean vegetariano;
	private boolean vegano;
	private boolean salado;
	private boolean dulce;
	private boolean picante;
	private String imagenUrl;
	private int tiempo;

	public Receta() {
		recetaID = 0;
		nombre = "";
		ingredientes = new ArrayList<IngredienteEnReceta>();
		descripcion = "";
		preparacion = "";
		vegetariano = false;
		vegano = false;
		salado = false;
		dulce = false;
		picante = false;
		imagenUrl = "";
		tiempo = 0;
	}

	public Receta(String[] atributo) {
		recetaID = Integer.parseInt(atributo[0]);
		nombre = atributo[1];
		ingredientes = new ArrayList<IngredienteEnReceta>();
		descripcion = atributo[2];
		preparacion = atributo[3];
		if (atributo[4].equalsIgnoreCase("1")) {
			vegetariano = true;
		} else {
			vegetariano = false;
		}
		if (atributo[5].equalsIgnoreCase("1")) {
			vegano = true;
		} else {
			vegano = false;
		}
		if (atributo[7].equalsIgnoreCase("1")) {
			salado = true;
		} else {
			salado = false;
		}
		if (atributo[8].equalsIgnoreCase("1")) {
			dulce = true;
		} else {
			dulce = false;
		}
		if (atributo[9].equalsIgnoreCase("1")) {
			picante = true;
		} else {
			picante = false;
		}
		imagenUrl = atributo[10];
		tiempo = Integer.parseInt(atributo[6]);
	}

	public int getRecetaID() {
		return recetaID;
	}

	public void setRecetaID(int id) {
		this.recetaID = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<IngredienteEnReceta> getIngredientes() {
		return ingredientes;
	}

	public void setIngrediente(IngredienteEnBBDD ing, String atributos) {
		ingredientes.add(new IngredienteEnReceta(ing, atributos.split(";")));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
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

	public boolean isSalado() {
		return salado;
	}

	public void setSalado(boolean salado) {
		this.salado = salado;
	}

	public boolean isDulce() {
		return dulce;
	}

	public void setDulce(boolean dulce) {
		this.dulce = dulce;
	}

	public boolean isPicante() {
		return picante;
	}

	public void setPicante(boolean picante) {
		this.picante = picante;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public String toString() {
		return "\n\nrecetaID: " + recetaID + "\nnombre: " + nombre + "\ndescripcion: " + descripcion + "\npreparacion: "
				+ preparacion + "\ningredientes: " + ingredientes + "\nvegetariano: " + vegetariano + "\nvegano: "
				+ vegano + "\nsalado: " + salado + "\ndulce: " + dulce + "\npicante: " + picante + "\ntiempo: "
				+ tiempo;
	}

	public String[] toInsert() {

		int vege = 0;
		int vega = 0;
		int sala = 0;
		int dulc = 0;
		int pica = 0;

		if (vegetariano) {
			vege = 1;
		} else {
			vege = 0;
		}
		if (vegano) {
			vega = 1;
		} else {
			vega = 0;
		}
		if (salado) {
			sala = 1;
		} else {
			sala = 0;
		}
		if (dulce) {
			dulc = 1;
		} else {
			dulc = 0;
		}
		if (picante) {
			pica = 1;
		} else {
			pica = 0;
		}

		String insert = recetaID + ";" + nombre + ";" + descripcion + ";" + preparacion + ";" + vege + ";" + vega + ";"
				+ tiempo + ";" + sala + ";" + dulc + ";" + pica + ";" + imagenUrl;
		return insert.split(";");
	}

}