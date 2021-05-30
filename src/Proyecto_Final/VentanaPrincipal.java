package Proyecto_Final;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Utiles util = new Utiles();
	private int wWidth = util.getWSize("width"), wHeight = util.getWSize("height"), userIndice;
	private Controlador control;
	private VentanaLogin login;
	private Usuario us;
	private String logedUser;
	private DecimalFormat decimal = new DecimalFormat("#.##");
	private JScrollPane scrollPaneInventario, scrollPaneRecetas;
	private ArrayList<JToggleButton> ingredientes;
	private ArrayList<JLabel> info, foto;
	private ArrayList<JTextPane> nombreReceta, descripcion, preparacion, paneIngredientes;
	private ArrayList<JScrollPane> scrollIngredientes;
	private ArrayList<JButton> preparar;
	private ArrayList<JSeparator> separador;
	private ArrayList<IngredienteEnInventario> ingredientesBuscar;
	private ArrayList<IngredienteEnInventario> ingredientesDispo;
	private ArrayList<Receta> recetasMostrar;
	private JTextField textField, textField_1;
	private JToggleButton tglbtnVegetariano, tglbtnVegano, tglbtnAlergico, tglbtnLactosa, tglbtnGluten;
	private JLabel lblIngEnInv, lblRecetasDispo, lblRecetasDispo2, lblVolver, lblVegetariano, lblVegano, lblAlergico,
			lblLactosa, lblGluten, lblNewLabel_1, lblNewLabel_2, lblFechaInvalida, lblCantidadInvalida, lblIngExito,
			lblLogoApp, lblLogoCeinmark, lblMedida, lblNewLabel_3;
	private JPanel contentPaneMain, contentPaneMenu, panelIngredientes, panelRecetas, panelMenu, panelOpciones,
			panelFiltros, panelOpIngredientes, panelOpPreferencias, panelOpAltaIngrediente, panelOpAltaReceta, panelBienvenida;
	private JButton btnSyso, btnVolver, btnMenu, btnFiltros, btnAltaIngrediente, btnAgregarRecetas,
			btnAgregarIngredientes, btnCerrarSesion;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	
	public VentanaPrincipal(VentanaLogin ventanaLogin, Controlador controlador, String username) {
		setBackground(Color.WHITE);
		control = controlador;
		login = ventanaLogin;
		logedUser = username;
		userIndice = control.getUserIndex(username);
		us = control.getUser(username);
		setTitle("Filp & Cook  Bienvenido " + logedUser);
		ingredientes = new ArrayList<JToggleButton>();
		info = new ArrayList<JLabel>();
		foto = new ArrayList<JLabel>();
		nombreReceta = new ArrayList<JTextPane>();
		descripcion = new ArrayList<JTextPane>();
		preparacion = new ArrayList<JTextPane>();
		paneIngredientes = new ArrayList<JTextPane>();
		scrollIngredientes = new ArrayList<JScrollPane>();
		preparar = new ArrayList<JButton>();
		separador = new ArrayList<JSeparator>();
		recetasMostrar = new ArrayList<Receta>();
		ingredientesBuscar = new ArrayList<IngredienteEnInventario>();
		ingredientesDispo = new ArrayList<IngredienteEnInventario>();

		contentPaneMain = new JPanel();// TODO QUITAR PARA TRABAJAR EN EL MENU Y PONER PARA TRABAJAR EN EL MAIN (PONER PARA EJECUTAR!)*
		setContentPane(contentPaneMain);// TODO QUITAR PARA TRABAJAR EN EL MENU Y PONER PARA TRABAJAR EN EL MAIN (PONER PARA EJECUTAR!)*
		contentPaneMenu = new JPanel();// TODO PONER PARA TRABAJAR EN EL MENU Y QUITAR PARA TRABAJAR EN EL MAIN (PONER PARA EJECUTAR!)*
//		setContentPane(contentPaneMenu);//TODO PONER PARA TRABAJAR EN EL MENU Y QUITAR PARA TRABAJAR EN EL MAIN (QUITAR PARA EJECUTAR!)

		contentPaneMenu.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if (util.misc.getScreenSize().width < getSize().width) {
					contentPaneMenu.setBounds((wWidth - 1280) / 2, (wHeight - 800) / 2, 1280, 800);
				}
			}

			public void mouseExited(MouseEvent e) {
				if (util.misc.getScreenSize().width < getSize().width) {
					contentPaneMain.setBounds((wWidth - 1280) / 2, (wHeight - 800) / 2, 1280, 800);
					System.out.println("horizontal maximized");
				}
			}
		});
		contentPaneMain.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				if (util.misc.getScreenSize().width < getSize().width) {
					contentPaneMain.setBounds((wWidth - 1280) / 2, (wHeight - 800) / 2, 1280, 800);
				}
			}

			public void mouseExited(MouseEvent e) {
				if (util.misc.getScreenSize().width < getSize().width) {
					contentPaneMenu.setBounds((wWidth - 1280) / 2, (wHeight - 800) / 2, 1280, 800);
				}
			}
		});

		contentPaneMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneMain.setBackground(Color.WHITE);
		contentPaneMenu.setBackground(Color.WHITE);
		setBounds(115, 30, 1280, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		scrollPaneInventario = new JScrollPane();
		scrollPaneInventario.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneInventario.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneInventario.setBounds(10, 52, 250, 400);
		scrollPaneRecetas = new JScrollPane();
		scrollPaneRecetas.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneRecetas.setBackground(Color.WHITE);
		scrollPaneRecetas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneRecetas.setBounds(273, 52, 983, 683);
		panelMenu = new JPanel(); // TODO QUITAR PARA TRABAJAR EN EL MAIN Y PONER PARA EJECUTAR!**
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setBounds(0, 0, 1276, 753);

		contentPaneMain.setLayout(null);
		contentPaneMenu.setLayout(null);
		contentPaneMenu.setVisible(false);
		contentPaneMain.setVisible(true);

		panelIngredientes = new JPanel();
		panelIngredientes.setBackground(Color.WHITE);
		panelRecetas = new JPanel();
		panelRecetas.setBackground(Color.WHITE);

		panelIngredientes.setBounds(10, 10, 200, 200);
		panelRecetas.setBounds(273, 10, 200, 200);

		scrollPaneRecetas.setViewportView(panelRecetas);
		scrollPaneInventario.setViewportView(panelIngredientes);
		panelIngredientes.setLayout(null);
		panelRecetas.setLayout(null);

		contentPaneMenu.add(panelMenu);
		contentPaneMain.add(scrollPaneInventario);
		contentPaneMain.add(scrollPaneRecetas);

		btnSyso = new JButton("syso");
		btnSyso.setFocusable(false);
		btnSyso.setBounds(10, 740, 85, 21);
		btnSyso.addActionListener(this);
		btnSyso.setVisible(false); // TODO
		contentPaneMain.add(btnSyso);

		lblIngEnInv = new JLabel("Ingredientes en tu inventario");
		lblIngEnInv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngEnInv.setBounds(10, 12, 250, 30);
		contentPaneMain.add(lblIngEnInv);

		lblRecetasDispo = new JLabel("Recetas disponibles con todos los ingredientes de tu inventario");
		lblRecetasDispo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecetasDispo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRecetasDispo.setBounds(273, 12, 983, 30);
		contentPaneMain.add(lblRecetasDispo);

		lblRecetasDispo2 = new JLabel("Recetas disponibles con los ingredientes seleccionados");
		lblRecetasDispo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecetasDispo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRecetasDispo2.setBounds(273, 12, 983, 30);
		lblRecetasDispo2.setVisible(false);
		contentPaneMain.add(lblRecetasDispo2);

		panelMenu.setLayout(null);

		btnVolver = new JButton("<<");
		btnVolver.addActionListener(this);
		
		panelBienvenida = new JPanel();
		panelBienvenida.setBackground(Color.WHITE);
		panelBienvenida.setBorder(new LineBorder(Color.BLACK));
		panelBienvenida.setVisible(false);
		panelBienvenida.setBounds(273, 52, 983, 683);
		panelMenu.add(panelBienvenida);
		panelBienvenida.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Bienvenido a Flip & Cook");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(0, 324, 983, 30);
		panelBienvenida.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Puedes empezar agregando ingredientes a tu inventario");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 374, 983, 30);
		panelBienvenida.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Luego ajustar tus preferencias alimentarias");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 404, 983, 30);
		panelBienvenida.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Cuando estes listo puedes darle al boton de volver para empezar a Flipar y Cocinar ;)");
		lblNewLabel_7.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(0, 434, 983, 30);
		panelBienvenida.add(lblNewLabel_7);
		
		
		ImageIcon imgBannerBienvenida = new ImageIcon("src/logo.png");
		JLabel lblBanner = new JLabel("");
		lblBanner.setIcon(new ImageIcon(imgBannerBienvenida.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH)));
		lblBanner.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanner.setBounds(241, 11, 500, 300);
		panelBienvenida.add(lblBanner);
		
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
		btnVolver.setBounds(10, 10, 32, 21);
		btnVolver.setMargin(new Insets(0, 0, 4, 0));
		btnVolver.setFocusable(false);
		panelMenu.add(btnVolver);

		panelOpciones = new JPanel();
		panelOpciones.setBorder(new LineBorder(Color.BLACK));
		panelOpciones.setBackground(Color.WHITE);
		panelOpciones.setBounds(10, 52, 250, 683);
		panelMenu.add(panelOpciones);
		panelOpciones.setLayout(null);

		btnCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesion.setFocusable(false);
		btnCerrarSesion.addActionListener(this);
		btnCerrarSesion.setBounds(25, 134, 200, 21);
		panelOpciones.add(btnCerrarSesion);

		btnAgregarIngredientes = new JButton("Agregar ingredientes");
		btnAgregarIngredientes.addActionListener(this);
		btnAgregarIngredientes.setFocusable(false);
		btnAgregarIngredientes.setBounds(25, 10, 200, 21);
		panelOpciones.add(btnAgregarIngredientes);

		btnAgregarRecetas = new JButton("Agregar Recetas");
		btnAgregarRecetas.addActionListener(this);
		btnAgregarRecetas.setFocusable(false);
		btnAgregarRecetas.setVisible(false);
		if (logedUser.equalsIgnoreCase("ADMIN")) {
			btnAgregarRecetas.setVisible(true);
		}
		btnAgregarRecetas.setBounds(25, 103, 200, 21);
		panelOpciones.add(btnAgregarRecetas);

		btnAltaIngrediente = new JButton("Alta Ingredientes BBDD");
		btnAltaIngrediente.addActionListener(this);
		btnAltaIngrediente.setFocusable(false);
		btnAltaIngrediente.setVisible(false);
		if (logedUser.equalsIgnoreCase("ADMIN")) {
			btnAltaIngrediente.setVisible(true);
		}
		btnAltaIngrediente.setBounds(25, 72, 200, 21);
		panelOpciones.add(btnAltaIngrediente);

		btnFiltros = new JButton("Ajustar preferencias");
		btnFiltros.addActionListener(this);
		btnFiltros.setFocusable(false);
		btnFiltros.setBounds(25, 41, 200, 21);
		panelOpciones.add(btnFiltros);

		ImageIcon imgPanelOp = new ImageIcon("src/PANEL_OP.png");
		JLabel lblImgPanel = new JLabel("");
		lblImgPanel.setIcon(new ImageIcon(imgPanelOp.getImage().getScaledInstance(230, 506, Image.SCALE_SMOOTH)));
		lblImgPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgPanel.setBounds(10, 166, 230, 506);
		panelOpciones.add(lblImgPanel);

		lblVolver = new JLabel("Volver");
		lblVolver.setBounds(45, 14, 45, 13);
		panelMenu.add(lblVolver);

		panelOpIngredientes = new JPanel();
		panelOpIngredientes.setBorder(new LineBorder(Color.BLACK));
		panelOpIngredientes.setBackground(Color.WHITE);
		panelOpIngredientes.setBounds(273, 52, 983, 683);
		panelOpIngredientes.setVisible(false);
		panelMenu.add(panelOpIngredientes);
		panelOpIngredientes.setLayout(null);

		JComboBox<Object> comboBox = new JComboBox<Object>(control.getIngredientesBBDD());
		comboBox.setBounds(10, 10, 300, 21);
		panelOpIngredientes.add(comboBox);

		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				lblMedida.setText("(Unidad de medida: "
						+ control.getIngrediente(comboBox.getSelectedItem().toString()).getMedida() + ")");
				lblCantidadInvalida.setVisible(false);
				lblIngExito.setVisible(false);
			}
		});
		textField.setBounds(320, 11, 150, 19);
		panelOpIngredientes.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				lblFechaInvalida.setVisible(false);
				lblIngExito.setVisible(false);
			}
		});
		textField_1.setBounds(320, 40, 150, 19);
		panelOpIngredientes.add(textField_1);
		textField_1.setColumns(10);

		lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(474, 14, 65, 13);
		panelOpIngredientes.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Caducidad (DD-MM-AAAA)");
		lblNewLabel_2.setBounds(474, 43, 155, 13);
		panelOpIngredientes.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int dia = 0, mes = 0, year = 0;
				String dCero = "", mCero = "";
				boolean fechOk = false, cantOk = false;
				try {
					// TODO
//					asd
					dia = Integer.parseInt(textField_1.getText().split("-")[0]);
					if (dia < 10 && !textField_1.getText().split("-")[0].contains("0")) {
						dCero = "0";
					} else {
						dCero = "";
					}
					mes = Integer.parseInt(textField_1.getText().split("-")[1]);
					if (mes < 10 && !textField_1.getText().split("-")[1].contains("0")) {
						mCero = "0";
					} else {
						mCero = "";
					}
					year = Integer.parseInt(textField_1.getText().split("-")[2]);
					if (textField_1.getText().split("-").length == 3 && dia < 32 && dia > 0 && mes > 0 && mes < 13
							&& year >= (LocalDate.now().getYear()) && year < (LocalDate.now().getYear() + 30)) {
						fechOk = true;
						System.out.println(textField_1.getText().split("-").length);

					} else {
						lblFechaInvalida.setVisible(true);
					}
				} catch (Exception exc) {
					System.out.println("error en formato de fecha");
					lblFechaInvalida.setVisible(true);
				}

				try {
					if (Double.parseDouble(textField.getText()) > 0
							&& Double.parseDouble(textField.getText()) < 99999) {
						cantOk = true;
					} else {
						lblCantidadInvalida.setVisible(true);
					}
				} catch (Exception exc) {
					System.out.println("error cantidad");
					lblCantidadInvalida.setVisible(true);
				}

				if (cantOk && fechOk) {
					lblIngExito.setVisible(true);
					boolean existe = false;
					int indiceIng = 0;
					for (IngredienteEnInventario bus : control.getListaIngEnInv(logedUser)) {
						if (bus.getIngrediente().getNombre().equalsIgnoreCase(comboBox.getSelectedItem().toString())) {
							existe = true;
							break;
						}
						indiceIng++;
					}
					if (!existe) {
						us.getInventario().setIngrediente(control.getIngrediente(comboBox.getSelectedItem().toString()),
								us.getInventario().getInventarioID() + ";" + textField.getText() + ";" + year + "-"
										+ mes + "-" + dia + " " + LocalTime.now());
					} else {
						us.getInventario().getIngredientes().get(indiceIng)
								.setCantidad(us.getInventario().getIngredientes().get(indiceIng).getCantidad()
										+ Double.parseDouble(textField.getText()));
						us.getInventario().getIngredientes().get(indiceIng).setCaducidad(
								LocalDateTime.parse(year + "-" + mCero + textField_1.getText().split("-")[1] + "-"
										+ dCero + textField_1.getText().split("-")[0] + "T" + LocalTime.now()));
					}

					control.conectarBBDD();
					control.updateBBDD("addIngInv",
							us.getInventario().getInventarioID() + ";"
									+ control.getIngrediente(comboBox.getSelectedItem().toString()).getId() + ";"
									+ textField.getText() + ";" + year + "-" + mes + "-" + dia + " " + LocalTime.now());
					control.desconectarBBDD();
					textField.setText("");
					textField_1.setText("");
					lblMedida.setText("");
				}

			}
		});
		btnNewButton.setBounds(320, 69, 150, 21);
		panelOpIngredientes.add(btnNewButton);

		lblFechaInvalida = new JLabel("Error en formato de fecha");
		lblFechaInvalida.setVisible(false);
		lblFechaInvalida.setForeground(Color.RED);
		lblFechaInvalida.setBounds(627, 43, 200, 13);
		panelOpIngredientes.add(lblFechaInvalida);

		lblCantidadInvalida = new JLabel("Cantidad invalida");
		lblCantidadInvalida.setForeground(Color.RED);
		lblCantidadInvalida.setVisible(false);
		lblCantidadInvalida.setBounds(696, 14, 200, 13);
		panelOpIngredientes.add(lblCantidadInvalida);

		lblIngExito = new JLabel("Ingrediente agregado con exito");
		lblIngExito.setVisible(false);
		lblIngExito.setForeground(new Color(0, 128, 0));
		lblIngExito.setAutoscrolls(true);
		lblIngExito.setBounds(480, 73, 200, 13);
		panelOpIngredientes.add(lblIngExito);

		lblMedida = new JLabel("");
		lblMedida.setBounds(530, 14, 165, 13);
		panelOpIngredientes.add(lblMedida);

		panelOpPreferencias = new JPanel();
		panelOpPreferencias.setBorder(new LineBorder(Color.BLACK));
		panelOpPreferencias.setBackground(Color.WHITE);
		panelOpPreferencias.setBounds(273, 52, 983, 683);
		panelOpPreferencias.setVisible(false);
		panelMenu.add(panelOpPreferencias);
		panelOpPreferencias.setLayout(null);

		lblVegetariano = new JLabel("No");
		lblVegano = new JLabel("No");
		lblAlergico = new JLabel("No");
		lblLactosa = new JLabel("No");
		lblGluten = new JLabel("No");

		tglbtnVegetariano = new JToggleButton("Vegetariano");
		tglbtnVegano = new JToggleButton("Vegano");
		tglbtnAlergico = new JToggleButton("Alergia alimentaria");
		tglbtnLactosa = new JToggleButton("Intolerancia a la lactosa");
		tglbtnGluten = new JToggleButton("Intolerancia al gluten");

		if (us.getFiltro().isVegetariano()) {
			lblVegetariano.setText("Si");
			tglbtnVegetariano.setSelected(true);
		}
		lblVegetariano.setBounds(220, 14, 45, 13);
		panelOpPreferencias.add(lblVegetariano);

		if (us.getFiltro().isVegano()) {
			lblVegano.setText("Si");
			tglbtnVegano.setSelected(true);
		}
		lblVegano.setBounds(220, 45, 45, 13);
		panelOpPreferencias.add(lblVegano);

		if (us.getFiltro().isAlergico()) {
			lblAlergico.setText("Si");
			tglbtnAlergico.setSelected(true);
		}
		lblAlergico.setBounds(220, 76, 45, 13);
		panelOpPreferencias.add(lblAlergico);

		if (us.getFiltro().isIntolerante_lactosa()) {
			lblLactosa.setText("Si");
			tglbtnLactosa.setSelected(true);
		}
		lblLactosa.setBounds(220, 107, 45, 13);
		panelOpPreferencias.add(lblLactosa);

		if (us.getFiltro().isIntolerante_gluten()) {
			lblGluten.setText("Si");
			tglbtnGluten.setSelected(true);
		}
		lblGluten.setBounds(220, 138, 45, 13);
		panelOpPreferencias.add(lblGluten);

		tglbtnVegetariano.setFocusable(false);
		tglbtnVegetariano.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				control.conectarBBDD();
				if (!tglbtnVegetariano.isSelected()) {
					control.getUserList().get(userIndice).getFiltro().setVegetariano(true);
					control.updateBBDD("vegetariano", 1 + ";" + us.getUserID());
					lblVegetariano.setText("Si");
				} else {
					control.getUserList().get(userIndice).getFiltro().setVegetariano(false);
					control.updateBBDD("vegetariano", 0 + ";" + us.getUserID());
					lblVegetariano.setText("No");
				}
				control.desconectarBBDD();
			}
		});
		tglbtnVegetariano.setBounds(10, 10, 200, 21);
		panelOpPreferencias.add(tglbtnVegetariano);

		tglbtnGluten.setFocusable(false);
		tglbtnVegano.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				control.conectarBBDD();
				if (!tglbtnVegano.isSelected()) {
					control.getUserList().get(userIndice).getFiltro().setVegano(true);
					control.updateBBDD("vegano", 1 + ";" + us.getUserID());
					lblVegano.setText("Si");
				} else {
					control.getUserList().get(userIndice).getFiltro().setVegano(false);
					control.updateBBDD("vegano", 0 + ";" + us.getUserID());
					lblVegano.setText("No");
				}
				control.desconectarBBDD();
			}
		});
		tglbtnVegano.setBounds(10, 41, 200, 21);
		panelOpPreferencias.add(tglbtnVegano);

		tglbtnGluten.setFocusable(false);
		tglbtnAlergico.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				control.conectarBBDD();
				if (!tglbtnAlergico.isSelected()) {
					control.getUserList().get(userIndice).getFiltro().setAlergico(true);
					control.updateBBDD("alergico", 1 + ";" + us.getUserID());
					lblAlergico.setText("Si");
				} else {
					control.getUserList().get(userIndice).getFiltro().setAlergico(false);
					control.updateBBDD("alergico", 0 + ";" + us.getUserID());
					lblAlergico.setText("No");
				}
				control.desconectarBBDD();
			}
		});
		tglbtnAlergico.setBounds(10, 72, 200, 21);
		panelOpPreferencias.add(tglbtnAlergico);

		tglbtnGluten.setFocusable(false);
		tglbtnLactosa.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				control.conectarBBDD();
				if (!tglbtnLactosa.isSelected()) {
					control.getUserList().get(userIndice).getFiltro().setIntolerante_lactosa(true);
					control.updateBBDD("lactosa", 1 + ";" + us.getUserID());
					lblLactosa.setText("Si");
				} else {
					control.getUserList().get(userIndice).getFiltro().setIntolerante_lactosa(false);
					control.updateBBDD("lactosa", 0 + ";" + us.getUserID());
					lblLactosa.setText("No");
				}
				control.desconectarBBDD();
			}
		});
		tglbtnLactosa.setBounds(10, 103, 200, 21);
		panelOpPreferencias.add(tglbtnLactosa);

		tglbtnGluten.setFocusable(false);
		tglbtnGluten.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				control.conectarBBDD();
				if (!tglbtnGluten.isSelected()) {
					control.getUserList().get(userIndice).getFiltro().setIntolerante_gluten(true);
					control.updateBBDD("gluten", 1 + ";" + us.getUserID());
					lblGluten.setText("Si");
				} else {
					control.getUserList().get(userIndice).getFiltro().setIntolerante_gluten(false);
					control.updateBBDD("gluten", 0 + ";" + us.getUserID());
					lblGluten.setText("No");
				}
				control.desconectarBBDD();
			}
		});
		tglbtnGluten.setBounds(10, 134, 200, 21);
		panelOpPreferencias.add(tglbtnGluten);

		panelOpAltaIngrediente = new JPanel();
		panelOpAltaIngrediente.setBackground(new Color(192, 192, 192));
		panelOpAltaIngrediente.setBounds(273, 52, 983, 683);
		panelOpAltaIngrediente.setVisible(false);
		panelMenu.add(panelOpAltaIngrediente);
		panelOpAltaIngrediente.setLayout(null);

		panelOpAltaReceta = new JPanel();
		panelOpAltaReceta.setBackground(Color.PINK);
		panelOpAltaReceta.setBounds(273, 52, 966, 683);
		panelOpAltaReceta.setVisible(false);
		panelMenu.add(panelOpAltaReceta);
		panelOpAltaReceta.setLayout(null);
		
		lblNewLabel_3 = new JLabel("Menu de ajustes");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(273, 12, 983, 30);
		panelMenu.add(lblNewLabel_3);

		btnMenu = new JButton("Men\u00FA");
		btnMenu.setFocusable(false);
		btnMenu.addActionListener(this);
		btnMenu.setBounds(1171, 10, 85, 21);
		contentPaneMain.add(btnMenu);

		ImageIcon logoApp = new ImageIcon("src/logo.png");
		ImageIcon logoCeinmark = new ImageIcon("src/CEINMARK.png");
		panelFiltros = new JPanel();
		panelFiltros.setBackground(Color.WHITE);
		panelFiltros.setBounds(10, 462, 250, 273);
		contentPaneMain.add(panelFiltros);
		panelFiltros.setLayout(null);

		lblLogoApp = new JLabel("");
		lblLogoApp.setBackground(Color.WHITE);
		lblLogoApp.setIcon(new ImageIcon(logoApp.getImage().getScaledInstance(250, 140, Image.SCALE_SMOOTH)));
		lblLogoApp.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoApp.setBounds(0, 0, 250, 140);
		panelFiltros.add(lblLogoApp);

		lblLogoCeinmark = new JLabel("");
		lblLogoCeinmark.setBackground(Color.WHITE);
		lblLogoCeinmark.setIcon(new ImageIcon(logoCeinmark.getImage().getScaledInstance(219, 37, Image.SCALE_SMOOTH)));
		lblLogoCeinmark.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoCeinmark.setBounds(15, 226, 219, 37);
		panelFiltros.add(lblLogoCeinmark);

		JTextPane txtpnProyectoFinal = new JTextPane();
		txtpnProyectoFinal.setEditable(false);
		txtpnProyectoFinal.setFocusable(false);
		txtpnProyectoFinal.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtpnProyectoFinal.setText(
				"Proyecto final 1\u00BA DAM 2020-2021\r\n-Carlos Antony Moscoso\r\n-Christian Ruiz Gonz\u00E1lez\r\n-Ezequiel Sanchez Alonso");
		txtpnProyectoFinal.setBounds(10, 150, 224, 65);
		panelFiltros.add(txtpnProyectoFinal);

		setVisible(true);

		mostrarListaIngredientes();
	}

	private void mostrarListaIngredientes() {
//		lblRecetasDispo2.setVisible(false);
//		lblRecetasDispo.setVisible(true);
		panelIngredientes.removeAll();
		info.removeAll(info);
		ingredientes.removeAll(ingredientes);
		ingredientesDispo.removeAll(ingredientesDispo);
		ingredientesBuscar.removeAll(ingredientesBuscar);
		panelIngredientes.repaint();

		int indice = 0, alto = 10;
		for (IngredienteEnInventario listaIng : control.getListaIngEnInv(logedUser)) {
			if (listaIng.getCantidad() > 0) {
				ingredientesDispo.add(listaIng);
				ingredientes.add(new JToggleButton());
				info.add(new JLabel());
				ingredientes.get(indice).setBounds(10, alto, 115, 21);
				ingredientes.get(indice).setText(listaIng.getIngrediente().getNombre());
				ingredientes.get(indice).setFocusable(false);
				ingredientes.get(indice).addActionListener(this);
				ingredientes.get(indice).setName(
						listaIng.getIngrediente().getNombre() + ";" + indice + ";" + listaIng.getIngrediente().getId());
				info.get(indice).setBounds(125, alto + 3, 140, 13);

				String cant = "";
				if (listaIng.getCantidad() - ((int) listaIng.getCantidad()) > 0) {
					cant = decimal.format(listaIng.getCantidad()) + "";
				} else {
					cant = (int) listaIng.getCantidad() + "";
				}

				info.get(indice).setText("Tienes: " + cant + listaIng.getIngrediente().getMedida() + ".");
				panelIngredientes.add(info.get(indice));
				panelIngredientes.add(ingredientes.get(indice));
				panelIngredientes.setPreferredSize(new Dimension(250, alto + 30));
				indice++;
				alto += 30;
				mostraListaRecetas();
			}
		}
	}

	private void mostraListaRecetas() {
		panelRecetas.removeAll();
		nombreReceta.removeAll(nombreReceta);
		descripcion.removeAll(descripcion);
		foto.removeAll(foto);
		preparacion.removeAll(preparacion);
		scrollIngredientes.removeAll(scrollIngredientes);
		paneIngredientes.removeAll(paneIngredientes);
		preparar.removeAll(preparar);
		separador.removeAll(separador);
		recetasMostrar.removeAll(recetasMostrar);
		panelRecetas.repaint();

		int countIngReceta = 0, countIngDispo = 0;
		if (ingredientesBuscar.isEmpty()) {
			lblRecetasDispo2.setVisible(false);
			lblRecetasDispo.setVisible(true);
			for (Receta bus : control.getRecetas()) {
				countIngReceta = 0;
				countIngDispo = 0;
				for (IngredienteEnReceta ing : bus.getIngredientes()) {
					countIngReceta++;
					for (IngredienteEnInventario disp : ingredientesDispo) {
						if (ing.getIngrediente().getId() == disp.getIngrediente().getId()) {
							if (disp.getCantidad() >= ing.getCantidad()) {
								countIngDispo++;
							}
						}
					}
				}
				if (countIngReceta == countIngDispo) {
					recetasMostrar.add(bus);
				}
			}
		} else {
			lblRecetasDispo2.setVisible(true);
			lblRecetasDispo.setVisible(false);
			for (Receta bus : control.getRecetas()) {
				countIngReceta = 0;
				countIngDispo = 0;
				for (IngredienteEnReceta ing : bus.getIngredientes()) {
					countIngReceta++;
					for (IngredienteEnInventario disp : ingredientesBuscar) {
						if (ing.getIngrediente().getId() == disp.getIngrediente().getId()) {
							if (disp.getCantidad() >= ing.getCantidad()) {
								countIngDispo++;
							}
						}
					}
				}
				if (countIngReceta == countIngDispo) {
					recetasMostrar.add(bus);
				}
			}
		}

		int indice = 0, alto = 10;
		for (Receta receta : recetasMostrar) {

			nombreReceta.add(new JTextPane());
			nombreReceta.get(indice).setFont(new Font("Tahoma", Font.BOLD, 10));
			nombreReceta.get(indice).setFocusable(false);
			nombreReceta.get(indice).setEditable(false);
			nombreReceta.get(indice).setText(receta.getNombre());
			nombreReceta.get(indice).setBounds(10, alto, 140, 36);
			panelRecetas.add(nombreReceta.get(indice));

			descripcion.add(new JTextPane());
			descripcion.get(indice).setFocusable(false);
			descripcion.get(indice).setEditable(false);
			descripcion.get(indice).setText(receta.getDescripcion());
			descripcion.get(indice).setBounds(160, alto, 811, 36);
			panelRecetas.add(descripcion.get(indice));
			alto += 40;

			foto.add(new JLabel(""));
			foto.get(indice).setFocusable(false);
			foto.get(indice).setIcon(control.getIconos().get(receta.getRecetaID() - 1));
			foto.get(indice).setBounds(10, alto, 140, 140);
			panelRecetas.add(foto.get(indice));

			preparacion.add(new JTextPane());
			preparacion.get(indice).setEditable(false);
			preparacion.get(indice).setFocusable(false);
			preparacion.get(indice).setText(receta.getPreparacion());
			preparacion.get(indice).setBounds(160, alto, 811, 246);
			panelRecetas.add(preparacion.get(indice));
			alto += 150;

			scrollIngredientes.add(new JScrollPane());
			scrollIngredientes.get(indice).setBounds(10, alto, 140, 65);
			panelRecetas.add(scrollIngredientes.get(indice));
			alto += 72;

			String ingredientes = "";
			for (IngredienteEnReceta bus : receta.getIngredientes()) {
				ingredientes += bus.getIngrediente().getNombre() + " " + (int) bus.getCantidad()
						+ bus.getIngrediente().getMedida() + "\r\n";
			}
			paneIngredientes.add(new JTextPane());
			paneIngredientes.get(indice).setText(ingredientes);
			paneIngredientes.get(indice).setEditable(false);
			paneIngredientes.get(indice).setFocusable(false);
			scrollIngredientes.get(indice).setViewportView(paneIngredientes.get(indice));

			preparar.add(new JButton("Preparada"));
			preparar.get(indice).setFocusable(false);
			preparar.get(indice).setBounds(10, alto, 140, 21);
			preparar.get(indice).setName(receta.getNombre() + ";" + receta.getRecetaID());
			preparar.get(indice).setActionCommand(receta.getNombre() + ";" + receta.getRecetaID());
			preparar.get(indice).addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					String[] name = e.getComponent().getName().split(";");
					int id = Integer.parseInt(name[1]);
					Receta receta = null;
					for (Receta bus : recetasMostrar) {
						if (bus.getRecetaID() == id) {
							receta = bus;
//							System.out.println("\nvas vas a preparar la siguiente receta " + receta.getNombre());
						}
					}
					int userIndex = 0, ingIndex = 0;
					double cantidadInv = 0, cantidadRec = 0;
					userIndex = 0;
					for (Usuario user : control.getUserList()) {
//						System.out.println(user.getNombre());
						if (user.getUsername().equalsIgnoreCase(logedUser)) {
//							System.out.println("if correcto, es " + user.getNombre());
							ingIndex = 0;
							control.conectarBBDD();
							for (IngredienteEnInventario ingInv : user.getInventario().getIngredientes()) {
//								System.out.println("ingInv= " + ingInv.getIngrediente().getNombre());
								for (IngredienteEnReceta ingRec : receta.getIngredientes()) {
//									System.out.println("ingRec= " + ingRec.getIngrediente().getNombre());
									if (ingRec.getIngrediente().getId() == ingInv.getIngrediente().getId()) {
//										System.out.println("if correcto, es " + ingRec.getIngrediente().getNombre());
//										System.out.println("dispo en inv= " + ingInv.getCantidad());
//										System.out.println("necesarios= " + ingRec.getCantidad());
										cantidadInv = ingInv.getCantidad();
										cantidadRec = ingRec.getCantidad();
										if (cantidadInv > cantidadRec) {
											System.out.println("UPDATE QUERY");
											control.getUserList().get(userIndex).getInventario().getIngredientes()
													.get(ingIndex).setCantidad(cantidadInv - ingRec.getCantidad());
//											control.updateBBDD("ingEnInvUpdate",
//													cantidadInv - ingRec.getCantidad() + ";" + ingInv.getInventarioID()
//															+ ";" + ingInv.getIngrediente().getId());
										} else {
											System.out.println("DELETE FROM");
											control.getUserList().get(userIndex).getInventario().getIngredientes()
													.get(ingIndex).setCantidad(cantidadInv - ingRec.getCantidad());
//											control.updateBBDD("ingEnInvDelete",
//													ingInv.getInventarioID() + ";" + ingInv.getIngrediente().getId());
										}
										break;
									}
								}
								ingIndex++;
							}
							control.updateBBDD("preparar", user.getUserID() + ";" + id);
							control.desconectarBBDD();
							break;
						}
						userIndex++;
					}
					mostrarListaIngredientes();
				}
			});
			panelRecetas.add(preparar.get(indice));
			alto += 26;

			separador.add(new JSeparator());
			separador.get(indice).setBounds(10, alto, 961, 2);
			panelRecetas.add(separador.get(indice));
			alto += 12;

			panelRecetas.setPreferredSize(new Dimension(700, alto));
			indice++;
		}
	}

	public void toMenu() {
		contentPaneMain.setVisible(false);
		contentPaneMenu.setVisible(true);
		panelBienvenida.setVisible(true);
		setContentPane(contentPaneMenu);
	}

	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.paramString());
//		System.out.println(e.getActionCommand().split(";")[0]);
//		System.out.println(preparar.toString());

		if (e.getSource() == btnAgregarIngredientes) {
			panelOpIngredientes.setVisible(true);
			panelOpPreferencias.setVisible(false);
			panelOpAltaIngrediente.setVisible(false);
			panelOpAltaReceta.setVisible(false);
			panelBienvenida.setVisible(false);
			panelMenu.add(panelOpIngredientes);
		}

		if (e.getSource() == btnFiltros) {
			panelOpIngredientes.setVisible(false);
			panelOpPreferencias.setVisible(true);
			panelOpAltaIngrediente.setVisible(false);
			panelOpAltaReceta.setVisible(false);
			panelBienvenida.setVisible(false);
			panelMenu.add(panelOpPreferencias);
		}

		if (e.getSource() == btnAltaIngrediente) {
			panelOpIngredientes.setVisible(false);
			panelOpPreferencias.setVisible(false);
			panelOpAltaIngrediente.setVisible(true);
			panelOpAltaReceta.setVisible(false);
			panelBienvenida.setVisible(false);
			panelMenu.add(panelOpAltaIngrediente);
		}

		if (e.getSource() == btnAgregarRecetas) {
			panelOpIngredientes.setVisible(false);
			panelOpPreferencias.setVisible(false);
			panelOpAltaIngrediente.setVisible(false);
			panelOpAltaReceta.setVisible(true);
			panelBienvenida.setVisible(false);
			panelMenu.add(panelOpAltaReceta);
		}

		if (e.getSource() == btnSyso) {
			System.out.println(preparar.toString());
		}

		if (e.getSource() == btnMenu) {
			contentPaneMain.setVisible(false);
			contentPaneMenu.setVisible(true);
			setContentPane(contentPaneMenu);
		}

		if (e.getSource() == btnVolver) {
			contentPaneMenu.setVisible(false);
			contentPaneMain.setVisible(true);
			mostrarListaIngredientes();
			setContentPane(contentPaneMain);
		}

		if (e.getSource() == btnCerrarSesion) {
			login.setVisible(true);
			dispose();
		}

		for (JToggleButton boton : ingredientes) {
			if (e.getSource().toString().contains(boton.getText())) {

				String[] name = boton.getName().split(";");
				int pos = Integer.parseInt(name[1]);
				int id = Integer.parseInt(name[2]);
				IngredienteEnInventario ingrediente = null;
				for (IngredienteEnInventario bus : control.getListaIngEnInv(logedUser)) {
					if (bus.getIngrediente().getId() == id) {
						ingrediente = bus;
					}
				}
				if (ingredientes.get(pos).isSelected()) {
					ingredientesBuscar.add(ingrediente);
				} else {
					ingredientesBuscar.remove(ingrediente);
				}
				mostraListaRecetas();
//				lblRecetasDispo2.setVisible(true);
//				lblRecetasDispo.setVisible(false);
				break;
			}
		}
	}
}
