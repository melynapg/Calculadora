package ar.edu.calculadora.myCalculadora.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fasores extends JFrame {

	private JPanel contentPane;
	private JTextField txtAmpF;
	private JTextField txtFreF;
	private JTextField txtFaseF;
	private JTextField textAmpG;
	private JTextField texFrecG;
	private JTextField textFaseG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fasores frame = new Fasores();
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
	public Fasores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFasor = new JLabel("Fasor F(x) : ");
		lblFasor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFasor.setBounds(39, 84, 99, 23);
		contentPane.add(lblFasor);
		
		txtAmpF = new JTextField();
		txtAmpF.setForeground(Color.LIGHT_GRAY);
		txtAmpF.setText("Amplitud");
		txtAmpF.setBounds(127, 85, 56, 22);
		contentPane.add(txtAmpF);
		txtAmpF.setColumns(10);
		
		JComboBox cbxF = new JComboBox();
		cbxF.setBounds(195, 85, 68, 22);
		contentPane.add(cbxF);
	    cbxF.addItem("COS");
	    cbxF.addItem("SEN");
		txtFreF = new JTextField();
		txtFreF.setForeground(Color.LIGHT_GRAY);
		txtFreF.setText("frecuencia");
		txtFreF.setBounds(292, 85, 68, 22);
		contentPane.add(txtFreF);
		txtFreF.setColumns(10);
		
		txtFaseF = new JTextField();
		txtFaseF.setForeground(Color.LIGHT_GRAY);
		txtFaseF.setText("fase");
		txtFaseF.setBounds(401, 85, 68, 22);
		contentPane.add(txtFaseF);
		txtFaseF.setColumns(10);
		
		JLabel label = new JLabel("(");
		label.setBounds(275, 79, 35, 34);
		contentPane.add(label);
		
		JLabel lblX = new JLabel(" x +");
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setBounds(367, 88, 27, 16);
		contentPane.add(lblX);
		
		JLabel label_2 = new JLabel(")");
		label_2.setBounds(495, 79, 35, 34);
		contentPane.add(label_2);
		
		JLabel lblFasorGx = new JLabel("Fasor G(x) : ");
		lblFasorGx.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFasorGx.setBounds(39, 160, 99, 23);
		contentPane.add(lblFasorGx);
		
		textAmpG = new JTextField();
		textAmpG.setText("Amplitud");
		textAmpG.setForeground(Color.LIGHT_GRAY);
		textAmpG.setColumns(10);
		textAmpG.setBounds(127, 166, 56, 22);
		contentPane.add(textAmpG);
		
		JComboBox cbxG = new JComboBox();
		cbxG.setBounds(195, 166, 68, 22);
		contentPane.add(cbxG);
	    cbxG.addItem("COS");
	    cbxG.addItem("SEN");
		
		JLabel label_3 = new JLabel("(");
		label_3.setBounds(275, 160, 35, 34);
		contentPane.add(label_3);
		
		texFrecG = new JTextField();
		texFrecG.setText("frecuencia");
		texFrecG.setForeground(Color.LIGHT_GRAY);
		texFrecG.setColumns(10);
		texFrecG.setBounds(292, 166, 68, 22);
		contentPane.add(texFrecG);
		
		JLabel lblX_1 = new JLabel(" x +");
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX_1.setBounds(367, 167, 27, 16);
		contentPane.add(lblX_1);
		
		textFaseG = new JTextField();
		textFaseG.setText("fase");
		textFaseG.setForeground(Color.LIGHT_GRAY);
		textFaseG.setColumns(10);
		textFaseG.setBounds(401, 166, 68, 22);
		contentPane.add(textFaseG);
		
		JLabel label_5 = new JLabel(")");
		label_5.setBounds(495, 160, 35, 34);
		contentPane.add(label_5);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCalcular.setBounds(50, 284, 133, 25);
		contentPane.add(btnCalcular);
		
		
		JLabel lblResultado = new JLabel("Resultado :");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResultado.setBounds(86, 233, 88, 23);
		contentPane.add(lblResultado);
		
		JLabel lblFuncionResultado = new JLabel("Funcion resultado");
		lblFuncionResultado.setBounds(195, 234, 411, 23);
		contentPane.add(lblFuncionResultado);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(275, 284, 133, 25);
		contentPane.add(button);
	}
}
