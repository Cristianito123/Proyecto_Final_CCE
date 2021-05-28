package Proyecto_Final;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
//import java.util.Scanner;

public class Utiles {
	Toolkit misc = Toolkit.getDefaultToolkit();
	private ImageIcon favicon;
	private VentanaLogin login;
	private VentanaRegistro registro;

	public Utiles(VentanaLogin ventanaLogin) {
		login = ventanaLogin;
	}

	public Utiles(VentanaRegistro ventanaRegistro) {
		registro = ventanaRegistro;
	}

	public Utiles() {
	}

	public void centrar(int anchoPanel, int altoPanel) {
		int anchoPantalla = misc.getScreenSize().width, altoPantalla = misc.getScreenSize().height;
		if (login != null) {
			login.setSize(anchoPanel, altoPanel);
			login.setLocation(anchoPantalla / 2 - anchoPanel / 2, altoPantalla / 2 - altoPanel / 2);
		}
		if (registro != null) {
			registro.setSize(anchoPanel, altoPanel);
			registro.setLocation(anchoPantalla / 2 - anchoPanel / 2, altoPantalla / 2 - altoPanel / 2);
		}
	}

	public void setFavicon(String ruta) {
		favicon = new ImageIcon(ruta);
		if (login != null) {
			login.setIconImage(favicon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		}
		if (registro != null) {
			registro.setIconImage(favicon.getImage());
		}
	}

	public String getPass(char[] password) {
		String pass = "";
		for (int i = 0; i < password.length; i++) {
			pass += password[i];
		}
		return pass;
	}

	public int getWSize(String op) {
		int size = 0;
		if (op.equalsIgnoreCase("width")) {
			size = misc.getScreenSize().width;
		} else {
			size = misc.getScreenSize().height;
		}
		return size;
	}

}