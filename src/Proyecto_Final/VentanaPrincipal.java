package Proyecto_Final;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private Controlador control;
	private VentanaLogin login;
	private JLabel lblIngEnInv, lblRecetasDispo;
	private JPanel contentPaneMain, contentPaneMenu, panelIngredientes, panelRecetas, panelMenu;
	private JScrollPane scrollPaneInventario, scrollPaneRecetas;
	private ArrayList<JToggleButton> ingredientes;
	private ArrayList<JLabel> info, foto;
	private ArrayList<JTextPane> nombreReceta, descripcion, preparacion, paneIngredientes;
	private ArrayList<JScrollPane> scrollIngredientes;
	private ArrayList<JButton> preparar;
	private ArrayList<JSeparator> separador;
	private ArrayList<IngredienteEnInventario> ingredientesBuscar;
	private ArrayList<IngredienteEnBBDD> ingredientesDispo;
	private ArrayList<Receta> recetasMostrar;
	private String logedUser;
	private JButton btnSyso, btnVolver, btnMenu;
	private JPanel panelFiltros;

	public VentanaPrincipal(VentanaLogin ventanaLogin, Controlador controlador, String username) {
		logedUser = username;
		control = controlador;
		login = ventanaLogin;
		System.out.println(username);
		control.mostrarUsuarios();
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
		ingredientesDispo = new ArrayList<IngredienteEnBBDD>();

		contentPaneMain = new JPanel(); // TODO QUITAR PARA TRABAJAR EN EL MENU Y PONER PARA EJECUTAR! *MAIN**EJECUTAR*
		contentPaneMenu = new JPanel(); // TODO QUITAR PARA TRABAJAR EN EL MAIN Y PONER PARA EJECUTAR! *MENU**EJECUTAR*
		setContentPane(contentPaneMain); // TODO QUITAR PARA TRABAJAR EN EL MENU Y PONER PARA EJECUTAR!*MAIN**EJECUTAR*
//		setContentPane(contentPaneMenu); //TODO PONER PARA TRABAJAR EN EL MENU Y QUITAR PARA EJECUTAR! *MENU*

		contentPaneMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneMain.setBackground(Color.WHITE);
		setBounds(0, 0, 1480, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		scrollPaneInventario = new JScrollPane();
		scrollPaneInventario.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneInventario.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneInventario.setBounds(10, 70, 250, 400);
		scrollPaneRecetas = new JScrollPane();
		scrollPaneRecetas.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneRecetas.setBackground(Color.WHITE);
		scrollPaneRecetas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneRecetas.setBounds(273, 70, 983, 683); // TODO ajustar lamina
		panelMenu = new JPanel();
		panelMenu.setBounds(10, 10, 966, 555);

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

		mostrarListaIngredientes();
		mostratListaRecetas();

		contentPaneMenu.add(panelMenu);
		contentPaneMain.add(scrollPaneInventario);
		contentPaneMain.add(scrollPaneRecetas);

		btnSyso = new JButton("syso");
		btnSyso.setBounds(10, 10, 85, 21);
//		btnSyso.setVisible(false); // TODO
		contentPaneMain.add(btnSyso);

		lblIngEnInv = new JLabel("Ingredientes en tu inventario");
		lblIngEnInv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngEnInv.setBounds(10, 30, 250, 30);
		contentPaneMain.add(lblIngEnInv);

		lblRecetasDispo = new JLabel("Recetas disponibles con todos los ingredientes de tu inventario");
		lblRecetasDispo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecetasDispo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRecetasDispo.setBounds(273, 30, 983, 30);
		contentPaneMain.add(lblRecetasDispo);
		panelMenu.setLayout(null);

		btnVolver = new JButton("<<");
		btnVolver.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				contentPaneMenu.setVisible(false);
				contentPaneMain.setVisible(true);
				setContentPane(contentPaneMain);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
		btnVolver.setBounds(0, 0, 32, 21);
		btnVolver.setMargin(new Insets(0, 0, 4, 0));
		btnVolver.setFocusable(false);
		panelMenu.add(btnVolver);

		btnMenu = new JButton("Menu");
		btnMenu.setFocusable(false);
		btnMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				contentPaneMain.setVisible(false);
				contentPaneMenu.setVisible(true);
				setContentPane(contentPaneMenu);
			}
		});
		btnMenu.setBounds(1171, 10, 85, 21);
		contentPaneMain.add(btnMenu);

		panelFiltros = new JPanel();
		panelFiltros.setBounds(10, 480, 250, 273);
		contentPaneMain.add(panelFiltros);
		panelFiltros.setLayout(null);

		btnSyso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("\n\n\nrecetasMostrar\n\n");
				System.out.println(recetasMostrar.toString());
				System.out.println("\n\n\ningredientesDispo\n\n");
				System.out.println(ingredientesDispo.toString());
				System.out.println("\n\n\ningredientesBuscar\n\n");
				System.out.println(ingredientesBuscar.toString());

			}
		});

		setVisible(true);
	}

	private void mostrarListaIngredientes() {
		int indice = 0, alto = 10;
		for (IngredienteEnInventario listaIng : control.getListaIngEnInv(logedUser)) {

			ingredientesDispo.add(listaIng.getIngrediente());
			ingredientes.add(new JToggleButton());
			info.add(new JLabel());
			ingredientes.get(indice).setBounds(10, alto, 115, 21);
			ingredientes.get(indice).setText(listaIng.getIngrediente().getNombre());
			ingredientes.get(indice).setFocusable(false);
			ingredientes.get(indice).setName(indice + ";" + listaIng.getIngrediente().getId());
			ingredientes.get(indice).addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					String[] name = e.getComponent().getName().split(";");
					int pos = Integer.parseInt(name[0]);
					int id = Integer.parseInt(name[1]);
					if (ingredientes.get(pos).isSelected()) {
						ingredientesBuscar.add(control.getListaIngEnInv(logedUser).get(id)); //TODO POSIBLE FALLO AL POSCICIONAR EL INGREDIENTE
					} else {
						ingredientesBuscar.remove(control.getListaIngEnInv(logedUser).get(id));
					}
					mostratListaRecetas();
				}
			});
			info.get(indice).setBounds(125, alto + 3, 140, 13);
			info.get(indice)
					.setText("Tienes: " + (int) listaIng.getCantidad() + listaIng.getIngrediente().getMedida() + ".");
			panelIngredientes.add(info.get(indice));
			panelIngredientes.add(ingredientes.get(indice));
			panelIngredientes.setPreferredSize(new Dimension(250, alto + 30));
			indice++;
			alto += 30;
		}
	}

//	(bus.getIngredientes().containsAll(control.getUserList().get(control.getUserID(logedUser))))
//	if (bus.getIngredientes().containsAll(control.getListaIngEnInv(logedUser)))
	private void mostratListaRecetas() {
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
			for (Receta bus : control.getRecetas()) {
				countIngReceta = 0;
				countIngDispo = 0;
				for (IngredienteEnReceta ing : bus.getIngredientes()) {
					countIngReceta++;
					for (IngredienteEnBBDD disp : ingredientesDispo) {
						if (ing.getIngrediente().getId() == disp.getId()) {
							countIngDispo++;
						}
					}
				}
				if (countIngReceta == countIngDispo) {
					recetasMostrar.add(bus);
				}
			}
		} else {
			for (Receta bus : control.getRecetas()) {
				countIngReceta = 0;
				countIngDispo = 0;
				for (IngredienteEnReceta ing : bus.getIngredientes()) {
					countIngReceta++;
					for (IngredienteEnInventario disp : ingredientesBuscar) {
						if (ing.getIngrediente().getId() == disp.getIngrediente().getId()) {
							countIngDispo++;
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
			preparar.get(indice).setBounds(10, alto, 140, 21);
			preparar.get(indice).setName(indice + ";" + receta.getRecetaID());
			preparar.get(indice).addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					String[] name = e.getComponent().getName().split(";");
					int pos = Integer.parseInt(name[0]);
					int id = Integer.parseInt(name[1]);
					System.out.println("Posicion de la receta en el array= " + pos + " id de la receta= " + id);

					// TODO
					// hacer bucles para restar ingredientes del inventario del usuario
					// correspondientes a los usados en la receta

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
}
