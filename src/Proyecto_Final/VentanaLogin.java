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
import java.awt.Image;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		username.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					password.grabFocus();
				}
			}
		});
		username.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				hiddenUsername.setVisible(false);
			}
		});

		username.setMargin(new Insets(-3, 2, 2, 2));
		username.setBounds(150, 97, 100, 19);
		username.setText("");
		username.setColumns(10);
		panLogin.add(username);

		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && !progressBar.isVisible()) {
					System.out.println("triggered");
					btnLogin.doClick();
				}
			}
		});
		password.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				hidenInvalidPass.setVisible(false);
			}
		});

		password.setMargin(new Insets(-3, 0, 0, 0));
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setBounds(150, 127, 100, 19);
		password.setColumns(10);
		panLogin.add(password);

		btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(150, 157, 100, 21);
		btnLogin.setFocusable(false);
		btnLogin.addActionListener(this);
		btnLogin.setVisible(false);
		panLogin.add(btnLogin);

		btnRegister = new JButton("REGISTRATE");
		btnRegister.setBounds(140, 228, 120, 21);
		btnRegister.setFocusable(false);
		btnRegister.addActionListener(this);
		btnRegister.setVisible(false);
		panLogin.add(btnRegister);

		lblUsername = new JLabel("Usuario:");
		lblUsername.setBounds(70, 100, 70, 13);
		panLogin.add(lblUsername);

		lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setBounds(70, 130, 80, 13);
		panLogin.add(lblPassword);

		lblRegister = new JLabel("\u00BFEres nuevo?");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBounds(140, 205, 120, 15);
		lblRegister.setVisible(false);
		panLogin.add(lblRegister);

		ImageIcon image = new ImageIcon("src/banner.png");
		banner = new JLabel("");
		banner.setIcon(new ImageIcon(image.getImage().getScaledInstance(330, 84, Image.SCALE_SMOOTH)));
		banner.setFont(new Font("Tahoma", Font.PLAIN, 60));
		banner.setHorizontalAlignment(SwingConstants.CENTER);
		banner.setBounds(35, 0, 330, 84);
		panLogin.add(banner);

		hiddenUsername = new JLabel("Usuario no existe");
		hiddenUsername.setVisible(false);
		hiddenUsername.setForeground(Color.RED);
		hiddenUsername.setBounds(255, 100, 140, 13);
		panLogin.add(hiddenUsername);

		hidenInvalidPass = new JLabel("Contrase\u00F1a invalida");
		hidenInvalidPass.setVisible(false);
		hidenInvalidPass.setForeground(Color.RED);
		hidenInvalidPass.setBounds(265, 130, 140, 13);
		panLogin.add(hidenInvalidPass);

		hidenForgotPass = new JLabel("\u00BFHas olvidado la contrase\u00F1a?");
		hidenForgotPass.setVisible(false);
		hidenForgotPass.setForeground(Color.RED);
		hidenForgotPass.setHorizontalAlignment(SwingConstants.CENTER);
		hidenForgotPass.setBounds(100, 184, 200, 15);
		panLogin.add(hidenForgotPass);

		lblpassHint = new JLabel("\uD83D\uDC41");
		lblpassHint.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				password.setFont(new Font("Tahoma", Font.PLAIN, 13));
				password.setEchoChar((char) 0);
			}

			public void mouseReleased(MouseEvent e) {
				password.setFont(new Font("Tahoma", Font.PLAIN, 15));
				password.setEchoChar('•');
			}
		});

		lblpassHint.setFont(UIManager.getFont("ColorChooser.font"));
		lblpassHint.setBounds(250, 129, 13, 13);
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
					main.setIconImage(this.getIconImage());
					main.setLocationRelativeTo(null);
					main.setBounds(115, 30, 1280, 800);
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

	public void setLoginReady() {
		btnLogin.setVisible(true);
		btnRegister.setVisible(true);
		lblRegister.setVisible(true);
	}

}