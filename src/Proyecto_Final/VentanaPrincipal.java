package Proyecto_Final;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private Controlador control;
	private VentanaLogin login;
	private JPanel contentPane, panel, panel_1;
	private JScrollPane scrollPane, scrollPane_1;
	private int alto = 0, mov = 0;
	private JButton btnNewButton, btnNewButton_2;
	private ArrayList<JToggleButton> ingredientes;
	private ArrayList<JLabel> info;
	ArrayList<IngredienteEnInventario> ingredientesBuscar;
	private String logedUser;
	private int indice;
	private JButton btnNewButton_1;

	public VentanaPrincipal(VentanaLogin ventanaLogin, Controlador controlador, String username) {
		logedUser = username;
		control = controlador;
		login = ventanaLogin;
		System.out.println(username);
		control.mostrarUsuarios();
		setTitle("Filp & Cook  Bienvenido " + logedUser);
		ingredientes = new ArrayList<JToggleButton>();
		info = new ArrayList<JLabel>();
		ingredientesBuscar = new ArrayList<IngredienteEnInventario>();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scrollPane = new JScrollPane();
		scrollPane_1 = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(273, 209, 153, 400); // TODO ajustar pane
		scrollPane.setBounds(10, 10, 250, 400);

//		setLocationRelativeTo(null);
//		panel.setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel_1 = new JPanel();

		panel.setBounds(10, 10, 200, 200);
		panel_1.setBounds(315, 44, 200, 200);
//		contentPane.setLayout(new BorderLayout(0, 0));

//		scrollPane.setLayout(null);

		alto = 10;
//		panel.setPreferredSize(new Dimension(200, alto));

//		contentPane.add(panel_1); // TODO BORRAR??

		scrollPane_1.setViewportView(panel_1);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		panel_1.setLayout(null);
		panel_1.setPreferredSize(new Dimension(250, 200)); // TODO ajustar panel
		indice = 0;
		for (IngredienteEnInventario listaIng : control.getListaIngEnInv(logedUser)) {

//			ingredientes.add(listaIng.getIngrediente().getId(), new JToggleButton());
			ingredientes.add(new JToggleButton());
			info.add(new JLabel());
			ingredientes.get(indice).setBounds(10, alto, 115, 21);
			ingredientes.get(indice).setText(listaIng.getIngrediente().getNombre());
			ingredientes.get(indice).setFocusable(false);
			ingredientes.get(indice).setName(indice + ";" + listaIng.getIngrediente().getId());
//			ingredientes.get(indice).setin
//			ingredientes.get(i).isSelected();
			ingredientes.get(indice).addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
//				System.out.println("getID "+e.getID()+"\n");
//				System.out.println("toString "+ e.toString()+"\n");
//				System.out.println("getSource "+e.getSource()+"\n");
//				System.out.println(e.getComponent().getName());
					String[] name = e.getComponent().getName().split(";");
					int pos = Integer.parseInt(name[0]);
					int id = Integer.parseInt(name[1]);

//				for (int i =0; i<e.getComponent().getName().length()-3;i++) {
//					pos = Integer.parseInt(e.getComponent().getName());
//					e.getComponent().getName().charAt(i);
//				}
					if (ingredientes.get(pos).isSelected()) {
						ingredientesBuscar.add(control.getListaIngEnInv(logedUser).get(id));
//					System.out.println(ingredientes.get(pos).getText());
//					btnNewButton_1.setLocation(btnNewButton_1.getLocation().x, btnNewButton_1.getLocation().y+10);
					} else {
						ingredientesBuscar.remove(control.getListaIngEnInv(logedUser).get(id));
//					System.out.println(ingredientes.get(pos).getText());
//					btnNewButton_1.setLocation(btnNewButton_1.getLocation().x, btnNewButton_1.getLocation().y-10);
					}

				}
			});
			info.get(indice).setBounds(125, alto + 3, 140, 13);
			info.get(indice)
					.setText("Tienes: " + (int) listaIng.getCantidad() + listaIng.getIngrediente().getMedida() + ".");
			panel.add(info.get(indice));
			panel.add(ingredientes.get(indice));
			panel.setPreferredSize(new Dimension(250, alto + 30));
			indice++;
			alto += 30;
		}

		contentPane.add(scrollPane);
		contentPane.add(scrollPane_1);

		btnNewButton_1 = new JButton("syso");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(ingredientesBuscar.toString());
			}
		});
		btnNewButton_1.setBounds(351, 232, 85, 21);
		contentPane.add(btnNewButton_1);

//		btnNewButton_2 = new JButton("volver");
//		btnNewButton_2.setVisible(false);
//		btnNewButton_2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				panel.setVisible(true);
//				;
//			}
//		});
//		btnNewButton_2.setBounds(326, 53, 85, 21);
//		contentPane.add(btnNewButton_2);

//		JButton btnNewButton_3 = new JButton("insertar usuario");
//		btnNewButton_3.setBounds(326, 107, 85, 21);
//		contentPane.add(btnNewButton_3);
		setVisible(true);
	}
}