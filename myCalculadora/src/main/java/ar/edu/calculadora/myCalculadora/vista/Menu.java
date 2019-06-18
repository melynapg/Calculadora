package ar.edu.calculadora.myCalculadora.vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 896, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.MAGENTA);
		menuBar.setBounds(0, 0, 878, 26);
		frame.getContentPane().add(menuBar);
		menuBar.setBackground(Color.LIGHT_GRAY);
		
		JMenu c = new JMenu("Opciones");
		
		
		c.setBackground(Color.DARK_GRAY);
		menuBar.add(c);
	
		JMenuItem menuItem = new JMenuItem("Transformar");


		
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Transformar transformar1 = new Transformar();
				transformar1.setVisible(true);
				
			}
		});
		c.add(menuItem);
		
		JMenuItem menuItem1 = new JMenuItem("Operaciones Basicas");
		c.add(menuItem1);
		
			menuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OperacionesBasicas ob = new OperacionesBasicas();
				ob.setVisible(true);
				
			}
		});

		JMenuItem menuItem2 = new JMenuItem("Operaciones Avanzadas");
		c.add(menuItem2);
		
		JMenuItem menuItem3 = new JMenuItem("Fasores");
		c.add(menuItem3);
	
		JMenuItem menuItem4 = new JMenuItem("Salir");
		c.add(menuItem4);
	}
}
