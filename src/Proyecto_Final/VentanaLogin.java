package Proyecto_Final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class VentanaLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panLogin;
	private Utiles util = new Utiles();
	private JTextField username;
	private JLabel lblUsername, lblPassword, lblRegister, banner, hiddenUsername, hidenInvalidPass, hidenForgotPass;
	private JButton btnLogin, btnRegister;
	private JPasswordField password;
	private JLabel lblNewLabel;
	private JProgressBar progressBar;
	private Controlador control;

	public VentanaLogin(Controlador controlador) {
		control = controlador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panLogin = new JPanel();
		panLogin.setBackground(Color.WHITE);
		setTitle("Filp & Cook");
		util.centrar(400, 300, this, null);
		util.setFavicon("src/icon.png", this, null);
		panLogin.setLayout(null);
		setResizable(false);
		setContentPane(panLogin);

		username = new JTextField();
		username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hiddenUsername.setVisible(false);
			}
		});
		username.setMargin(new Insets(-3, 2, 2, 2));
		username.setBounds(150, 86, 100, 19);
		panLogin.add(username);
		username.setColumns(10);

		password = new JPasswordField();
		password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hidenInvalidPass.setVisible(false);
			}
		});
		password.setMargin(new Insets(-3, 0, 0, 0));
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setBounds(150, 116, 100, 19);
		panLogin.add(password);
		password.setColumns(10);

		btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(150, 146, 100, 21);
		btnLogin.setFocusable(false);
		btnLogin.addActionListener(this);
		panLogin.add(btnLogin);

		btnRegister = new JButton("REGISTRATE");
		btnRegister.setBounds(140, 217, 120, 21);
		btnRegister.setFocusable(false);
		btnRegister.addActionListener(this);
		panLogin.add(btnRegister);

		lblUsername = new JLabel("Usuario:");
		lblUsername.setBounds(70, 89, 70, 13);
		panLogin.add(lblUsername);

		lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setBounds(70, 119, 80, 13);
		panLogin.add(lblPassword);

		lblRegister = new JLabel("\u00BFEres nuevo?");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBounds(140, 194, 120, 15);
		panLogin.add(lblRegister);

		banner = new JLabel("");
		banner.setIcon(
				new ImageIcon("C:\\Users\\Zther\\git\\Proyecto_Final_CCE\\src\\horizontal_on_white_by_logaster-1.png"));
		banner.setFont(new Font("Tahoma", Font.PLAIN, 60));
		banner.setHorizontalAlignment(SwingConstants.CENTER);
		banner.setBounds(25, 10, 350, 50);
		panLogin.add(banner);

		hiddenUsername = new JLabel("Usuario no existe");
		hiddenUsername.setVisible(false);
		hiddenUsername.setForeground(Color.RED);
		hiddenUsername.setBounds(256, 89, 140, 13);
		panLogin.add(hiddenUsername);

		hidenInvalidPass = new JLabel("Contrase\u00F1a invalida");
		hidenInvalidPass.setVisible(false);
		hidenInvalidPass.setForeground(Color.RED);
		hidenInvalidPass.setBounds(272, 119, 140, 13);
		panLogin.add(hidenInvalidPass);

		hidenForgotPass = new JLabel("\u00BFHas olvidado la contrase\u00F1a?");
		hidenForgotPass.setVisible(false);
		hidenForgotPass.setForeground(Color.RED);
		hidenForgotPass.setHorizontalAlignment(SwingConstants.CENTER);
		hidenForgotPass.setBounds(100, 173, 200, 15);
		panLogin.add(hidenForgotPass);

		lblNewLabel = new JLabel("\uD83D\uDC41");
		lblNewLabel.addMouseListener(new MouseAdapter() {
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
		lblNewLabel.setFont(UIManager.getFont("ColorChooser.font"));
		lblNewLabel.setBounds(255, 118, 13, 13);
		panLogin.add(lblNewLabel);

		progressBar = new JProgressBar();
		progressBar.setBounds(-2, 250, 389, 20);
		panLogin.add(progressBar);
		progressBar.setValue(0);

		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegister) {
			System.out.println("abriendo ventana de registro");
			VentanaRegistro registro = new VentanaRegistro(this);

			if (!username.getText().isEmpty()) {
				registro.pasarUsername(username.getText());
			}

			dispose();

		}
		if (e.getSource() == btnLogin) {
			if (control.checkUserPass(username.getText())) {
				if (control.chekPass(password.getPassword())) {
					System.out.println("user ok, abriendo ventana main");
					VentanarPrincipal main = new VentanarPrincipal();
					main.setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
				} else {
					System.out.println("pass invalido");
					hidenInvalidPass.setVisible(true);
				}
			} else {
				System.out.println("user no existe");
				hiddenUsername.setVisible(true);
			}
		}

	}

	public void setProgBar(int i) {
		progressBar.setValue(i);
	}

	public void hideProgBar() {
		progressBar.setVisible(false);
	}
}