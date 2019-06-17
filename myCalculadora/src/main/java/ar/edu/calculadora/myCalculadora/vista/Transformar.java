package ar.edu.calculadora.myCalculadora.vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transformar extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

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
		setBounds(100, 100, 592, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNroComplejo = new JLabel("Nro Complejo");
		lblNroComplejo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNroComplejo.setBounds(54, 40, 88, 37);
		getContentPane().add(lblNroComplejo);
		
		textField = new JTextField();
		textField.setBounds(200, 47, 116, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Resultado :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(54, 129, 81, 22);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Transformar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(UIManager.getColor("windowBorder"));
		btnNewButton.setBounds(47, 190, 130, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(225, 190, 130, 25);
		getContentPane().add(btnNewButton_1);

	}
}
