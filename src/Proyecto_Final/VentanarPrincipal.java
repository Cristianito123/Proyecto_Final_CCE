package Proyecto_Final;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class VentanarPrincipal extends JFrame {

	private JPanel contentPane, panel;
	private JScrollPane scrollPane;
	private int alto =0, mov=0;
	private JButton btnNewButton, btnNewButton_1, btnNewButton_2;
	private ArrayList<JButton> ingredientes;

	public VentanarPrincipal() {
		ingredientes = new ArrayList<JButton>();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 10, 200, 700);

		
//		setBounds(100, 100, 1132, 598);
//		setBounds(100, 100, 500, 500);

//		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
//		panel.setLayout(null);
		panel.setBounds(10, 10, 200, 200);
//		contentPane.setLayout(new BorderLayout(0, 0));
		
		
//		scrollPane.setLayout(null);
		
		
		
		alto = 900;
		panel.setPreferredSize(new Dimension(200, alto));
		
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		
		
		

		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(10, 10, 115, 21);
		panel.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("New toggle button");
		tglbtnNewToggleButton_1.setBounds(10, 40, 115, 21);
		panel.add(tglbtnNewToggleButton_1);
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("New toggle button");
		tglbtnNewToggleButton_2.setBounds(10, 71, 115, 21);
		panel.add(tglbtnNewToggleButton_2);
		
		JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("New toggle button");
		tglbtnNewToggleButton_3.setBounds(10, 100, 115, 21);
		panel.add(tglbtnNewToggleButton_3);
		
		JToggleButton tglbtnNewToggleButton_4 = new JToggleButton("New toggle button");
		tglbtnNewToggleButton_4.setBounds(10, 130, 115, 21);
		panel.add(tglbtnNewToggleButton_4);
		
		JToggleButton tglbtnNewToggleButton_5 = new JToggleButton("New toggle button");
		tglbtnNewToggleButton_5.setBounds(10, 160, 115, 21);
		panel.add(tglbtnNewToggleButton_5);
		
		JToggleButton tglbtnNewToggleButton_6 = new JToggleButton("New toggle button");
		tglbtnNewToggleButton_6.setBounds(10, 190, 115, 21);
		panel.add(tglbtnNewToggleButton_6);


		
		contentPane.add(scrollPane);
		
		btnNewButton = new JButton("repaint");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				panel.setPreferredSize(new Dimension(200, alto));;
				
				btnNewButton_2.setVisible(true);;
			}
		});
		btnNewButton.setBounds(233, 53, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("+20");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(alto);;
				mov+=5;
				alto+=20;;
				ingredientes.add(btnNewButton);
				ingredientes.get(0).setBounds(250-mov, 107, 85, 21);
				panel.setPreferredSize(new Dimension(200, alto));;
				scrollPane.setViewportView(panel);
				contentPane.add(ingredientes.get(0));
			}
		});
		btnNewButton_1.setBounds(233, 107, 85, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("volver");
		btnNewButton_2.setVisible(false);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(true);;
			}
		});
		btnNewButton_2.setBounds(326, 53, 85, 21);
		contentPane.add(btnNewButton_2);
		setVisible(true);
	}
}