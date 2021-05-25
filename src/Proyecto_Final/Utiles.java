package Proyecto_Final;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
//import java.util.Scanner;

public class Utiles {
	private Toolkit misc = Toolkit.getDefaultToolkit();
	private ImageIcon favicon;
	private VentanaLogin login;
	private VentanaRegistro registro;
//	private char n[] = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
//	private Scanner ent;
//	private boolean error;
//	private int num;
//	private String cadena;

	public Utiles(VentanaLogin ventanaLogin) {
		login = ventanaLogin;
//		ent = new Scanner(System.in);
//		error = false;
	}

	public Utiles(VentanaRegistro ventanaRegistro) {
		registro = ventanaRegistro;
	}

//	public String getString(String mensaje) { // GET STRING --------------------------------------------- GET STRING
//		reset(mensaje);
//		cadena = ent.nextLine();
//		return cadena;
//	}// --------------------------------------------------------------------------------------------------------------------------------------------
//
//	public String getLetras(String mensaje) { // ------------------ SOLO LETRAS Y ESPACIO (PARA LOS NOMBRES Y APELLIDOS)
//		do {
//			reset(mensaje);
//			cadena = ent.nextLine();
//			for (int i = 0; i < cadena.length(); i++) {
//				if (cadena.charAt(i) == ' ') {
//				} else if (cadena.charAt(i) > 90 && cadena.charAt(i) < 97) {
//					error("Entrada invalida..");
//					break;
//				} else if (cadena.charAt(i) > 122 || cadena.charAt(i) < 65) {
//					error("Entrada invalida..");
//					break;
//				}
//			}
//		} while (error);
//		return cadena;
//	}// --------------------------------------------------------------------------------------------------------------------------------------------
//
//	public int getOpcion(int min, int max) { // GET OPCIONES ---------------------------------- GET OPCIONES
//		reset("> Usa el teclado numerico para ingresar el numero correspondiente a la opcion deseada..");
//		num = getEntero("");
//		if (num < min) {
//			num = 0;
//		}
//		if (num > max) {
//			num = 0;
//		}
//		return num;
//	}// --------------------------------------------------------------------------------------------------------------------------------------------
//
//	public int getEntero(String mensaje) { // GET ENTERO -------------------------------------------------GET ENTERO
//		do {
//			reset(mensaje);
//			try {
//				num = ent.nextInt();
//			} catch (Exception e) {
//				error("Entrada invalida.. (Solo se aceptan numeros)");
//			}
//		} while (error);
//		return num;
//	}// --------------------------------------------------------------------------------------------------------------------------------------------
//
//	public float getFloat(String mensaje) { // GET FLOAT -------------------------------------------------GET FLOAT
//		float f=0.0f;
//		do {
//			reset(mensaje);
//			try {
//				f = ent.nextFloat();
//			} catch (Exception e) {
//				error("Entrada invalida..");
//			}
//		} while (error);
//		return f;
//	}// --------------------------------------------------------------------------------------------------------------------------------------------
//
//	public String getISBN(String mensaje) { // GET ISBN --------------------------------------------- GET ISBN
//		do {
//			reset(mensaje);
//			cadena = ent.nextLine();
//			if (cadena.length() != 14) {
//				error("Entrada invalida..");
//			}
//			if (error) {
//
//			} else {
//				for (int i = 0; i < cadena.length(); i++) {
//					if (i == 3) {
//						if (cadena.charAt(i) != 45) {
//							error("Entrada invalida..");
//							break;
//						}
//					} else {
//						if (cadena.charAt(i) < 48 || cadena.charAt(i) > 57) {
//							error("Entrada invalida..");
//							break;
//						}
//					}
//				}
//			}
//		} while (error);
//		return cadena;
//	}// --------------------------------------------------------------------------------------------------------------------------------------------
//
//	public int getNum(String numeros) { // COMPONER UN NUMERO
//		boolean ok = false;
//		num = 0;
//		for (int contador = 0; contador < numeros.length(); contador++) {
//			ok = false;
//			for (int i = 0; i < n.length; i++) {
//				if (numeros.charAt(contador) == n[i]) {
//					num = i + (num * 10);
//					ok = true;
//				}
//			}
//			if (!ok) {
//				contador = cadena.length();
//				error = true;
//				break;
//			}
//		}
//		return num;
//	}
//
//	public int genRandom(int min, int max) { // GET RANDOM --------------------------------------------- GET RANDOM
//		int num = (int) (Math.random() * (1 + max - min)) + min;
//		return num;
//	}
//
//	private void reset(String mensaje) {
//		ent = new Scanner(System.in);
//		error = false;
//		System.out.println(mensaje);
//	}
//
//	private void error(String mensaje) {
//		error = true;
//		System.out.println(mensaje);
//	}
//
//	public void cls() {
//		System.out.print("\n\n\n\n\n\n\n\n\n\n" + "\n\n\n\n\n\n\n\n\n\n" + "\n\n\n\n\n\n\n\n\n\n"
//				+ "\n\n\n\n\n\n\n\n\n\n" + "\n\n\n\n\n\n\n\n\n\n");
//	}
//
//	public void hl() {
//		System.out.print(
//				"+---------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");
//	}
//
//	public String getDNI(String mensaje) { // GET DNI --------------------------------------------- GET DNI
//		String DNI = "", aux = "";
//		do {
//			reset(mensaje);
//			int numDni = getEntero("");
//			if (numDni <= 0 || numDni > 99999999) {
//				error("Entrada invalida.. DNI fuera de rango");
//			}
//			switch ((numDni % 23)) {
//			case 0:
//				aux = numDni + "T";
//				break;
//			case 1:
//				aux = numDni + "R";
//				break;
//			case 2:
//				aux = numDni + "W";
//				break;
//			case 3:
//				aux = numDni + "A";
//				break;
//			case 4:
//				aux = numDni + "G";
//				break;
//			case 5:
//				aux = numDni + "M";
//				break;
//			case 6:
//				aux = numDni + "Y";
//				break;
//			case 7:
//				aux = numDni + "F";
//				break;
//			case 8:
//				aux = numDni + "P";
//				break;
//			case 9:
//				aux = numDni + "D";
//				break;
//			case 10:
//				aux = numDni + "X";
//				break;
//			case 11:
//				aux = numDni + "B";
//				break;
//			case 12:
//				aux = numDni + "N";
//				break;
//			case 13:
//				aux = numDni + "J";
//				break;
//			case 14:
//				aux = numDni + "Z";
//				break;
//			case 15:
//				aux = numDni + "S";
//				break;
//			case 16:
//				aux = numDni + "Q";
//				break;
//			case 17:
//				aux = numDni + "V";
//				break;
//			case 18:
//				aux = numDni + "H";
//				break;
//			case 19:
//				aux = numDni + "L";
//				break;
//			case 20:
//				aux = numDni + "C";
//				break;
//			case 21:
//				aux = numDni + "K";
//				break;
//			case 22:
//				aux = numDni + "E";
//				break;
//			}
//		} while (error);
//
//		switch (aux.length()) {
//		case 2:
//			DNI = "0000000" + aux;
//			break;
//		case 3:
//			DNI = "000000" + aux;
//			break;
//		case 4:
//			DNI = "00000" + aux;
//			break;
//		case 5:
//			DNI = "0000" + aux;
//			break;
//		case 6:
//			DNI = "000" + aux;
//			break;
//		case 7:
//			DNI = "00" + aux;
//			break;
//		case 8:
//			DNI = "0" + aux;
//			break;
//		case 9:
//			DNI = aux;
//			break;
//		}
//		return DNI;
//	} // ---------------------------------------------------------------FIN GET DNI
//
//	public String getMail(String mensaje) { // GET CORREO --------------------------------------------- GET CORREO
//		do {
//			reset(mensaje);
//			cadena = ent.nextLine();
//			for (int i = 0; i < cadena.length(); i++) {
//				if (cadena.charAt(i) == ' ' || cadena.charAt(i) == '_' || cadena.charAt(i) == '.'
//						|| cadena.charAt(i) > 47 && cadena.charAt(i) < 58
//						|| cadena.charAt(i) > 63 && cadena.charAt(i) < 91
//						|| cadena.charAt(i) > 96 && cadena.charAt(i) < 123) {
//				} else {
//					error("No se admiten caracteres especiales");
//					break;
//				}
//	TODO		if (verificar la sintaxis del correo) {
//					
//				}
//			}
//		} while (error);
//		return cadena;
//	}// --------------------------------------------------------------------------------------------------------------------------------------------
//
//	public int getEnteroRango(int min, int max, String mensaje) { // ENTERO RANGO --------------- ENTERO RANGO
//		do {
//			reset(mensaje);
//			num = getEntero("");
//			if (num < min) {
//				error("Numero fuera de rango");
//			}
//			if (num > max) {
//				error("Numero fuera de rango");
//			}
//		} while (error);
//		return num;
//	} // --------------------------------------------------------------------------------------------------------------------------------------------

	public Utiles() {
		// TODO Auto-generated constructor stub
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

}