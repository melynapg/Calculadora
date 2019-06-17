
package ar.edu.calculadora.myCalculadora.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;

public class OperacionesBasicas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblOperaciones;

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
	    comboBox.addItem("Suma");
	    comboBox.addItem("Resta");
	    comboBox.addItem("Multiplicar");
	    comboBox.addItem("Dividir");
	   
	
		
		
		
		
	}
	
	

	
}