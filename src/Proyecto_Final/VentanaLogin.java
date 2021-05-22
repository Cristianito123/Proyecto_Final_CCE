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
	private Utiles util = new Utiles(this);
	private JTextField username;
	private JPasswordField password;
	private JButton btnLogin, btnRegister;
	private JProgressBar progressBar;
	private VentanaRegistro registro;
	private Controlador control;
	private JLabel lblUsername, lblPassword, lblpassHint, lblRegister, banner, hiddenUsername, hidenInvalidPass,
			hidenForgotPass;

	public VentanaLogin(Controlador controlador) {
		control = controlador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panLogin = new JPanel();
		panLogin.setBackground(Color.WHITE);
		setTitle("Filp & Cook");
		util.centrar(400, 300);
		util.setFavicon("src/icon.png");
		panLogin.setLayout(null);
		setResizable(false);
		setContentPane(panLogin);

		username = new JTextField();
		username.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				hiddenUsername.setVisible(false);
			}
		});
		username.setMargin(new Insets(-3, 2, 2, 2));
		username.setBounds(150, 86, 100, 19);
		username.setText("");
		username.setColumns(10);
		panLogin.add(username);

		password = new JPasswordField();
		password.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				hidenInvalidPass.setVisible(false);
			}
		});
		password.setMargin(new Insets(-3, 0, 0, 0));
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setBounds(150, 116, 100, 19);
		password.setColumns(10);
		panLogin.add(password);

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
		banner.setIcon(new ImageIcon("src/banner.png"));
		banner.setFont(new Font("Tahoma", Font.PLAIN, 60));
		banner.setHorizontalAlignment(SwingConstants.CENTER);
		banner.setBounds(25, 10, 350, 50);
		panLogin.add(banner);

		hiddenUsername = new JLabel("Usuario no existe");
		hiddenUsername.setVisible(false);
		hiddenUsername.setForeground(Color.RED);
		hiddenUsername.setBounds(255, 89, 140, 13);
		panLogin.add(hiddenUsername);

		hidenInvalidPass = new JLabel("Contrase\u00F1a invalida");
		hidenInvalidPass.setVisible(false);
		hidenInvalidPass.setForeground(Color.RED);
		hidenInvalidPass.setBounds(265, 119, 140, 13);
		panLogin.add(hidenInvalidPass);

		hidenForgotPass = new JLabel("\u00BFHas olvidado la contrase\u00F1a?");
		hidenForgotPass.setVisible(false);
		hidenForgotPass.setForeground(Color.RED);
		hidenForgotPass.setHorizontalAlignment(SwingConstants.CENTER);
		hidenForgotPass.setBounds(100, 173, 200, 15);
		panLogin.add(hidenForgotPass);

		lblpassHint = new JLabel("\uD83D\uDC41");
		lblpassHint.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				password.setFont(new Font("Tahoma", Font.PLAIN, 13));
				password.setEchoChar((char) 0);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				password.setFont(new Font("Tahoma", Font.PLAIN, 15));
				password.setEchoChar('�');
			}
		});
		lblpassHint.setFont(UIManager.getFont("ColorChooser.font"));
		lblpassHint.setBounds(250, 118, 13, 13);
		panLogin.add(lblpassHint);

		progressBar = new JProgressBar();
		progressBar.setBounds(-2, 250, 389, 20);
		progressBar.setValue(0);
		panLogin.add(progressBar);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegister) {
			System.out.println("abriendo ventana de registro");
			registro = new VentanaRegistro(this, control, username.getText());
			registro.setIconImage(getIconImage());
			dispose();

		}
		if (e.getSource() == btnLogin) {
			if (control.checkUser(username.getText())) {
				if (control.chekPass(password.getPassword(), username.getText())) {
					System.out.println("user ok, abriendo ventana main");
					VentanaPrincipal main = new VentanaPrincipal(this, control, username.getText());
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