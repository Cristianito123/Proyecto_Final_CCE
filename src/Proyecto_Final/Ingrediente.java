package Proyecto_Final;

import java.time.LocalDate;

public class Ingrediente {
	private String nombre;
	private float peso;
	private int cantidad;
	private LocalDate caducidad;

	private boolean alergeno;
	private boolean lactosa;
	private boolean gluten;
	private boolean vegetal;
	private boolean fruta;
	private boolean carbohidrato;
	private boolean proteina;
	private boolean carne;
	private boolean mariscos;
	private boolean pescado;
	private boolean pollo;
	private boolean agrio;
	private boolean acido;

	public Ingrediente() {
		nombre = "";
		peso = 0.0f;
		cantidad = 0;
		caducidad = null;
		alergeno = false;
		lactosa = false;
		gluten = false;
		vegetal = false;
		fruta = false;
		carbohidrato = false;
		proteina = false;
		carne = false;
		mariscos = false;
		pescado = false;
		pollo = false;
		agrio = false;
		acido = false;
	}

	public Ingrediente(String nombre, float peso, int cantidad, LocalDate caducidad) {
		this.nombre = nombre;
		this.peso = peso;
		this.cantidad = cantidad;
		this.caducidad = caducidad;
	}

	public Ingrediente(String nombre, boolean alergeno, boolean lactosa, boolean gluten, boolean vegetal, boolean fruta,
			boolean carbohidrato, boolean proteina, boolean carne, boolean mariscos, boolean pescado, boolean pollo,
			boolean agrio, boolean acido) {
		this.nombre = nombre;
		this.alergeno = alergeno;
		this.lactosa = lactosa;
		this.gluten = gluten;
		this.vegetal = vegetal;
		this.fruta = fruta;
		this.carbohidrato = carbohidrato;
		this.proteina = proteina;
		this.carne = carne;
		this.mariscos = mariscos;
		this.pescado = pescado;
		this.pollo = pollo;
		this.agrio = agrio;
		this.acido = acido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDate getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(LocalDate caducidad) {
		this.caducidad = caducidad;
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

	public boolean isFruta() {
		return fruta;
	}

	public void setFruta(boolean fruta) {
		this.fruta = fruta;
	}

	public boolean isCarbohidrato() {
		return carbohidrato;
	}

	public void setCarbohidrato(boolean carbohidrato) {
		this.carbohidrato = carbohidrato;
	}

	public boolean isProteina() {
		return proteina;
	}

	public void setProteina(boolean proteina) {
		this.proteina = proteina;
	}

	public boolean isCarne() {
		return carne;
	}

	public void setCarne(boolean carne) {
		this.carne = carne;
	}

	public boolean isMariscos() {
		return mariscos;
	}

	public void setMariscos(boolean mariscos) {
		this.mariscos = mariscos;
	}

	public boolean isPescado() {
		return pescado;
	}

	public void setPescado(boolean pescado) {
		this.pescado = pescado;
	}

	public boolean isPollo() {
		return pollo;
	}

	public void setPollo(boolean pollo) {
		this.pollo = pollo;
	}

	public boolean isAgrio() {
		return agrio;
	}

	public void setAgrio(boolean agrio) {
		this.agrio = agrio;
	}

	public boolean isAcido() {
		return acido;
	}

	public void setAcido(boolean acido) {
		this.acido = acido;
	}

}
