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

import org.w3c.dom.css.RGBColor;

import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;

public class VentanaLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panLogin;
	private Utiles util = new Utiles();
	private JTextField username;
	private JLabel lblUsername, lblPassword, lblRegister, banner, hiddenUsername, hidenInvalidPass, hidenForgotPass;
	private JButton btnLogin, btnRegister;
	private JPasswordField password;

	public VentanaLogin() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panLogin = new JPanel();
		setTitle("Filp & Cook");
		util.centrar(400, 300, this,null);
		util.setFavicon("src/PlaceHolder.png",this,null);
		panLogin.setLayout(null);
		setResizable(false);
		setContentPane(panLogin);

		username = new JTextField();
		username.setMargin(new Insets(-3, 2, 2, 2));
		username.setBounds(150, 86, 100, 19);
		panLogin.add(username);
		username.setColumns(10);

		password = new JPasswordField();
		password.setMargin(new Insets(-3, 0, 0, 0));
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

		banner = new JLabel("B A N N E R");
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
		hidenInvalidPass.setBounds(256, 119, 140, 13);
		panLogin.add(hidenInvalidPass);

		hidenForgotPass = new JLabel("\u00BFHas olvidado la contrase\u00F1a?");
		hidenForgotPass.setVisible(false);
		hidenForgotPass.setForeground(Color.RED);
		hidenForgotPass.setHorizontalAlignment(SwingConstants.CENTER);
		hidenForgotPass.setBounds(100, 173, 200, 15);
		panLogin.add(hidenForgotPass);

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
	}

}