package Proyecto_Final;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class VentanaRegistro extends JFrame implements ActionListener {

	private JPanel panRegister;
	private Utiles util = new Utiles();
	private JButton btnVolver;
	private VentanaLogin login;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	
	public VentanaRegistro(VentanaLogin ventanaLogin) {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				login.setVisible(true);
			}
		});
		
		login = ventanaLogin;
//		login.setVisible(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panRegister = new JPanel();
		setTitle("Filp & Cook");
		util.centrar(400, 300, null, this);
		util.setFavicon("src/PlaceHolder.png", null, this);
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
		
		JLabel lblNewLabel = new JLabel("Nuevo registro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 10, 100, 20);
		panRegister.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(150, 57, 100, 19);
		panRegister.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 142, 100, 19);
		panRegister.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 181, 100, 19);
		panRegister.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(150, 84, 100, 19);
		panRegister.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(150, 113, 100, 19);
		panRegister.add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setBounds(70, 60, 70, 13);
		panRegister.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setBounds(70, 145, 70, 13);
		panRegister.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Verificar\r\n");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setBounds(70, 174, 70, 13);
		panRegister.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Nombre:");
		lblNewLabel_4.setBounds(70, 87, 70, 13);
		panRegister.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Apellidos:");
		lblNewLabel_5.setBounds(70, 116, 70, 13);
		panRegister.add(lblNewLabel_5);
		
		btnNewButton = new JButton("Completar registro");
		btnNewButton.setMargin(new Insets(2, 0, 2, 0));
		btnNewButton.setBounds(140, 217, 120, 21);
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(this);
		panRegister.add(btnNewButton);
		
		lblNewLabel_6 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_6.setBounds(70, 188, 70, 13);
		panRegister.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Nombre de usuario ya existe");
		lblNewLabel_7.setVisible(false);
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(260, 60, 140, 13);
		panRegister.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Contrase\u00F1a no coincide");
		lblNewLabel_8.setVisible(false);
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(260, 184, 140, 13);
		panRegister.add(lblNewLabel_8);

		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			System.out.println("volviendo al login");
			login.setVisible(true);
			dispose();
		}
	}

	public void pasarUsername(String text) {
		// TODO Auto-generated method stub

	}

}
