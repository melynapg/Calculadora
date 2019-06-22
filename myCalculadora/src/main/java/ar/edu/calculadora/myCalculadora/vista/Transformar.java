package ar.edu.calculadora.myCalculadora.vista;

import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;

import javax.swing.UIManager;

import ar.edu.calculadora.myCalculadora.controladores.CalculosControlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transformar extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNroComplejo;
	private CalculosControlador calculosControlador = new CalculosControlador();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transformar frame = new Transformar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Transformar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Transformar Nro Complejo");
		setBounds(100, 100, 776, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNroComplejo = new JLabel("Nro Complejo");
		lblNroComplejo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNroComplejo.setBounds(188, 44, 88, 37);
		getContentPane().add(lblNroComplejo);
		
		textNroComplejo = new JTextField();
		textNroComplejo.setBounds(334, 51, 116, 30);
		getContentPane().add(textNroComplejo);
		textNroComplejo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Resultado :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 129, 82, 22);
		getContentPane().add(lblNewLabel);
		final JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setVisible(false);
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResultado.setBounds(90, 132, 635, 16);
		getContentPane().add(lblResultado);
		
		JButton btnNewButton = new JButton("Transformar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			int es =calculosControlador.isBinomicaPolar(textNroComplejo.getText());
			 	

				
				switch (es) {
				case 0:
					
					lblResultado.setText("Dato ingresado Incorrecto.Formato correcto Binomica (a,b)  Polar[c,dPI]");			
				    lblResultado.setForeground(Color.RED);
					lblResultado.setVisible(true);
				    
				    
					break;
				case 1:
					
				  String  s =calculosControlador.transformarAPolar(textNroComplejo.getText());
					
				  lblResultado.setText(s);
				  lblResultado.setVisible(true);
				  break;
				case 2:
					
				 String  s1 =calculosControlador.transformarABinomica(textNroComplejo.getText());
						
				 lblResultado.setText(s1);
				 lblResultado.setVisible(true);					
					
					break;
				default:
					break;
				}
			}
		});
		btnNewButton.setBackground(UIManager.getColor("windowBorder"));
		btnNewButton.setBounds(182, 177, 130, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(360, 177, 130, 25);
		getContentPane().add(btnNewButton_1);
		


	}
}
