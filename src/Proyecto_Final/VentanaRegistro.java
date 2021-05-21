package Proyecto_Final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
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

public class VentanaRegistro extends JFrame implements ActionListener {

	private JPanel panRegister;
	private Utiles util = new Utiles();

	private VentanaLogin login;

	private JPasswordField password;
	private JPasswordField passwordVerif;
	private JTextField username, nombre, apellidos;

	private JButton btnVolver, btnRegisterComplete;
	private JLabel lblUsername, lblNombre, lblApellidos, lblPassword, lblVerificar, lblPasswordVerif, lblUsernameExist,
			lblInvalidPass;

	public VentanaRegistro(VentanaLogin ventanaLogin) {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				login.setVisible(true);
			}
		});

		login = ventanaLogin;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panRegister = new JPanel();
		panRegister.setBackground(Color.WHITE);
		setTitle("Filp & Cook");
		util.centrar(400, 300, null, this);
		util.setFavicon("src/icon.png", null, this);
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

		JLabel lblTitulo = new JLabel("Nuevo registro");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(150, 10, 100, 20);
		panRegister.add(lblTitulo);

		username = new JTextField();
		username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblUsernameExist.setVisible(false);
			}
		});
		username.setBounds(150, 57, 100, 19);
		panRegister.add(username);
		username.setColumns(10);

		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setBounds(150, 142, 100, 19);
		panRegister.add(password);
		password.setColumns(10);

		passwordVerif = new JPasswordField();
		passwordVerif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblInvalidPass.setVisible(false);
			}
		});
		passwordVerif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordVerif.setBounds(150, 181, 100, 19);
		panRegister.add(passwordVerif);
//		passwordVerif.sh
		passwordVerif.setColumns(10);

		nombre = new JTextField();
		nombre.setBounds(150, 84, 100, 19);
		panRegister.add(nombre);
		nombre.setColumns(10);

		apellidos = new JTextField();
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

		lblUsernameExist = new JLabel("Nombre de usuario ya existe");
		lblUsernameExist.setVisible(false);
		lblUsernameExist.setForeground(Color.RED);
		lblUsernameExist.setBounds(260, 60, 140, 13);
		panRegister.add(lblUsernameExist);

		lblInvalidPass = new JLabel("Contrase\u00F1a no coincide");
		lblInvalidPass.setVisible(false);
		lblInvalidPass.setForeground(Color.RED);
		lblInvalidPass.setBounds(276, 184, 140, 13);
		panRegister.add(lblInvalidPass);

		JLabel iconPassHiden = new JLabel("\uD83D\uDC41");
		iconPassHiden.setFont(UIManager.getFont("ColorChooser.font"));
		iconPassHiden.setIcon(null);
		iconPassHiden.setBounds(255, 144, 13, 13);
		iconPassHiden.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				password.setFont(new Font("Tahoma", Font.PLAIN, 13));
				password.setEchoChar((char) 0);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				password.setFont(new Font("Tahoma", Font.PLAIN, 15));
				password.setEchoChar('•');
			}
		});
		panRegister.add(iconPassHiden);

		JLabel iconPassHiden_2 = new JLabel("\uD83D\uDC41");
		iconPassHiden_2.setFont(UIManager.getFont("ColorChooser.font"));
		iconPassHiden_2.setBounds(255, 183, 13, 13);
		iconPassHiden_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passwordVerif.setFont(new Font("Tahoma", Font.PLAIN, 13));
				passwordVerif.setEchoChar((char) 0);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				passwordVerif.setFont(new Font("Tahoma", Font.PLAIN, 15));
				passwordVerif.setEchoChar('•');
			}
		});
		panRegister.add(iconPassHiden_2);

		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			System.out.println("volviendo al login");
			login.setVisible(true);
			dispose();
		}
	}

	public void pasarUsername(String userName) {
		username.setText(userName);
	}
}
