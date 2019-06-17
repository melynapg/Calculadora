
package ar.edu.calculadora.myCalculadora.vista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperacionesBasicas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblOperaciones;
	private JLabel lblNewLabel;
	private JButton btnCancelar;
	private JLabel lblRespuesta;

	/**
	 * Launch the application.
	 */
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperacionesBasicas frame = new OperacionesBasicas();
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
	public OperacionesBasicas() {
		setTitle("Operaciones Basicas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nro Complejo");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(80, 64, 104, 22);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Nro Complejo");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(80, 130, 104, 22);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(251, 65, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(251, 131, 116, 22);
		contentPane.add(textField_1);
		
		lblOperaciones = new JLabel("Operaciones");
		lblOperaciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOperaciones.setBounds(80, 202, 104, 22);
		contentPane.add(lblOperaciones);
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(251, 203, 116, 22);
		contentPane.add(comboBox);
		
		lblNewLabel = new JLabel("Resultado :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(80, 259, 104, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCalcular.setBounds(80, 321, 170, 25);
		contentPane.add(btnCalcular);
		
		btnCancelar  = new JButton("Cancelar");

		btnCancelar.setBounds(328, 321, 182, 25);
		contentPane.add(btnCancelar);
		
		lblRespuesta = new JLabel("respuesta");
		lblRespuesta.setBounds(196, 260, 56, 16);
		contentPane.add(lblRespuesta);
	    comboBox.addItem("Sumar");
	    comboBox.addItem("Resta");
	    comboBox.addItem("Multiplicar");
	    comboBox.addItem("Dividir");
	 
	 
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		dispose(); 
			}
		});
		
		
	}
	
	

}