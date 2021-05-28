package Proyecto_Final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaRegistro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panRegister;
	private Utiles util = new Utiles(this);
	private VentanaLogin login;
	private JPasswordField password, passwordVerif;
	private JTextField username, nombre, apellidos;
	private JButton btnVolver, btnRegisterComplete;
	private Controlador control;
	private boolean success = false;
	private JLabel lblTitulo, lblUsername, lblNombre, lblApellidos, lblPassword, lblVerificar, lblPasswordVerif,
			lblUsernameExist, lblInvalidPass, lblIntroduceUsuario, lblIntroduceNombre, lblIntroduceApellidos,
			lblIntroduceContraseña, iconPassHiden, iconPassHiden_2;

	public VentanaRegistro(VentanaLogin ventanaLogin, Controlador controlador, String user) {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				if (!success) {
					login.setVisible(true);
				} else {
					success = false;
				}
			}
		});
		control = controlador;
		login = ventanaLogin;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panRegister = new JPanel();
		panRegister.setBackground(Color.WHITE);
		setTitle("Filp & Cook");
		util.centrar(400, 300);
		panRegister.setLayout(null);
		setContentPane(panRegister);

		btnVolver = new JButton("<<");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
		btnVolver.setBounds(10, 15, 32, 21);
		btnVolver.setMargin(new Insets(0, 0, 4, 0));
		btnVolver.setFocusable(false);
		btnVolver.addActionListener(this);
		panRegister.add(btnVolver);

		lblTitulo = new JLabel("Nuevo registro");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(150, 10, 100, 20);
		panRegister.add(lblTitulo);

		username = new JTextField();
		username.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					nombre.grabFocus();
				}
			}
		});
		username.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblUsernameExist.setVisible(false);
				lblIntroduceUsuario.setVisible(false);
			}
		});
		username.setBounds(150, 57, 100, 19);
		username.setText(user);
		panRegister.add(username);
		username.setColumns(10);

		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					passwordVerif.grabFocus();
				}
			}
		});
		password.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblIntroduceContraseña.setVisible(false);
			}
		});
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setBounds(150, 142, 100, 19);
		panRegister.add(password);
		password.setColumns(10);

		passwordVerif = new JPasswordField();
		passwordVerif.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("triggered");
					btnRegisterComplete.doClick();
				}
			}
		});
		passwordVerif.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblInvalidPass.setVisible(false);
			}
		});
		passwordVerif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordVerif.setBounds(150, 181, 100, 19);
		panRegister.add(passwordVerif);
		passwordVerif.setColumns(10);

		nombre = new JTextField();
		nombre.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					apellidos.grabFocus();
				}
			}
		});
		nombre.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblIntroduceNombre.setVisible(false);
			}
		});
		nombre.setBounds(150, 84, 100, 19);
		panRegister.add(nombre);
		nombre.setColumns(10);

		apellidos = new JTextField();
		apellidos.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					password.grabFocus();
				}
			}
		});
		apellidos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblIntroduceApellidos.setVisible(false);
			}
		});
		apellidos.setBounds(150, 113, 100, 19);
		panRegister.add(apellidos);
		apellidos.setColumns(10);

		lblUsername = new JLabel("Usuario:");
		lblUsername.setBounds(70, 60, 70, 13);
		panRegister.add(lblUsername);

		lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setBounds(70, 145, 70, 13);
		panRegister.add(lblPassword);

		lblVerificar = new JLabel("Verificar\r\n");
		lblVerificar.setVerticalAlignment(SwingConstants.TOP);
		lblVerificar.setBounds(70, 174, 70, 13);
		panRegister.add(lblVerificar);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(70, 87, 70, 13);
		panRegister.add(lblNombre);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(70, 116, 70, 13);
		panRegister.add(lblApellidos);

		btnRegisterComplete = new JButton("Completar registro");
		btnRegisterComplete.setMargin(new Insets(2, 0, 2, 0));
		btnRegisterComplete.setBounds(140, 217, 120, 21);
		btnRegisterComplete.setFocusable(false);
		btnRegisterComplete.addActionListener(this);
		panRegister.add(btnRegisterComplete);

		lblPasswordVerif = new JLabel("Contrase\u00F1a:");
		lblPasswordVerif.setBounds(70, 188, 70, 13);
		panRegister.add(lblPasswordVerif);

		lblUsernameExist = new JLabel("Ya existe");
		lblUsernameExist.setVisible(false);
		lblUsernameExist.setForeground(Color.RED);
		lblUsernameExist.setBounds(255, 60, 140, 13);
		panRegister.add(lblUsernameExist);

		lblInvalidPass = new JLabel("No coincide");
		lblInvalidPass.setVisible(false);
		lblInvalidPass.setForeground(Color.RED);
		lblInvalidPass.setBounds(265, 184, 140, 13);
		panRegister.add(lblInvalidPass);

		iconPassHiden = new JLabel("\uD83D\uDC41");
		iconPassHiden.setFont(UIManager.getFont("ColorChooser.font"));
		iconPassHiden.setIcon(null);
		iconPassHiden.setBounds(250, 144, 13, 13);
		iconPassHiden.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				password.setFont(new Font("Tahoma", Font.PLAIN, 13));
				password.setEchoChar((char) 0);
			}

			public void mouseReleased(MouseEvent e) {
				password.setFont(new Font("Tahoma", Font.PLAIN, 15));
				password.setEchoChar('•');
			}
		});
		panRegister.add(iconPassHiden);

		iconPassHiden_2 = new JLabel("\uD83D\uDC41");
		iconPassHiden_2.setFont(UIManager.getFont("ColorChooser.font"));
		iconPassHiden_2.setBounds(250, 183, 13, 13);
		iconPassHiden_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				passwordVerif.setFont(new Font("Tahoma", Font.PLAIN, 13));
				passwordVerif.setEchoChar((char) 0);
			}

			public void mouseReleased(MouseEvent e) {
				passwordVerif.setFont(new Font("Tahoma", Font.PLAIN, 15));
				passwordVerif.setEchoChar('•');
			}
		});
		panRegister.add(iconPassHiden_2);

		lblIntroduceUsuario = new JLabel("Indica un nombre");
		lblIntroduceUsuario.setForeground(Color.RED);
		lblIntroduceUsuario.setBounds(255, 60, 140, 13);
		lblIntroduceUsuario.setVisible(false);
		panRegister.add(lblIntroduceUsuario);

		lblIntroduceNombre = new JLabel("Indica un nombre");
		lblIntroduceNombre.setForeground(Color.RED);
		lblIntroduceNombre.setBounds(255, 87, 140, 13);
		lblIntroduceNombre.setVisible(false);
		panRegister.add(lblIntroduceNombre);

		lblIntroduceApellidos = new JLabel("Indica los apellidos");
		lblIntroduceApellidos.setForeground(Color.RED);
		lblIntroduceApellidos.setBounds(255, 116, 140, 13);
		lblIntroduceApellidos.setVisible(false);
		panRegister.add(lblIntroduceApellidos);

		lblIntroduceContraseña = new JLabel("Contrase\u00F1a invalida");
		lblIntroduceContraseña.setForeground(Color.RED);
		lblIntroduceContraseña.setBounds(265, 145, 140, 13);
		lblIntroduceContraseña.setVisible(false);
		panRegister.add(lblIntroduceContraseña);

		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			System.out.println("volviendo al login");
			login.setVisible(true);
			dispose();
		}
		if (e.getSource() == btnRegisterComplete) {
			System.out.println("verificando registro");
			if (!username.getText().isBlank()) {
				if (!nombre.getText().isBlank()) {
					if (!apellidos.getText().isBlank()) {
						if (!util.getPass(password.getPassword()).isBlank()) {
							if (!control.checkUser(username.getText())) {
								if (util.getPass(password.getPassword())
										.equalsIgnoreCase(util.getPass(passwordVerif.getPassword()))) {
									control.conectarBBDD();
									control.userAdd(username.getText(), nombre.getText(), apellidos.getText(),
											util.getPass(password.getPassword()));
									control.insertBBDD("usuario");
									VentanaPrincipal main = new VentanaPrincipal(login, control, username.getText());
									main.setIconImage(this.getIconImage());
									main.setLocationRelativeTo(null);
									main.setBounds(115, 30, 1280, 800);
									main.toMenu();
									success = true;
									control.desconectarBBDD();
									dispose();
								} else {
									System.out.println("no coinciden");
									lblInvalidPass.setVisible(true);
								}
							} else {
								System.out.println("username ocupado");
								lblUsernameExist.setVisible(true);
							}
						} else {
							System.out.println("pass vacio");
							lblIntroduceContraseña.setVisible(true);
						}
					} else {
						System.out.println("apellidos vacio");
						lblIntroduceApellidos.setVisible(true);
					}
				} else {
					System.out.println("nombe vacio");
					lblIntroduceNombre.setVisible(true);
				}
			} else {
				System.out.println("username vacio");
				lblIntroduceUsuario.setVisible(true);
			}
		}
	}
}
