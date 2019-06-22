package ar.edu.calculadora.myCalculadora.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.edu.calculadora.myCalculadora.controladores.FasoresControlador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fasores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Famp;
	private JTextField Ffrec;
	private JTextField Ffase;
	private JTextField Gampl;
	private JTextField Gfrec;
	private JTextField Gfase;
	private FasoresControlador fasoresContoles = new FasoresControlador();
	private JComboBox<String> cbxG = new JComboBox<String>();
	
	private JComboBox<String> cbxF = new JComboBox<String>();
	private JTextField txtAmplitud;
	private JTextField txtCossen;
	private JTextField txtFrecuencia;
	private JTextField txtFase;
	

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
		setTitle("Fasores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFasor = new JLabel("Fasor F(x) : ");
		lblFasor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFasor.setBounds(39, 84, 99, 23);
		contentPane.add(lblFasor);
		
		Famp = new JTextField();
		Famp.setBounds(127, 85, 56, 22);
		contentPane.add(Famp);
		Famp.setColumns(10);

		cbxF.setBounds(195, 85, 68, 22);
		contentPane.add(cbxF);
	    cbxF.addItem("COS");
	    cbxF.addItem("SEN");
		Ffrec = new JTextField();
		Ffrec.setForeground(Color.BLACK);
		Ffrec.setBounds(292, 85, 68, 22);
		contentPane.add(Ffrec);
		Ffrec.setColumns(10);
		
		Ffase = new JTextField();

		Ffase.setForeground(Color.BLACK);
		Ffase.setBounds(401, 85, 68, 22);
		contentPane.add(Ffase);
		Ffase.setColumns(10);
		
		JLabel label = new JLabel("(");
		label.setBounds(275, 79, 35, 34);
		contentPane.add(label);
		
		JLabel lblX = new JLabel(" x +");
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setBounds(367, 88, 27, 16);
		contentPane.add(lblX);
		
		JLabel lblPi = new JLabel("PI )");
		lblPi.setBounds(474, 79, 56, 34);
		contentPane.add(lblPi);
		
		JLabel TxtG = new JLabel("Fasor G(x) : ");
		TxtG.setFont(new Font("Tahoma", Font.BOLD, 14));
		TxtG.setBounds(39, 165, 88, 23);
		contentPane.add(TxtG);
		
		Gampl = new JTextField();
		Gampl.setForeground(Color.BLACK);
		Gampl.setColumns(10);
		Gampl.setBounds(127, 166, 56, 22);
		contentPane.add(Gampl);
		
		
		cbxG.setBounds(195, 166, 68, 22);
		contentPane.add(cbxG);
	    cbxG.addItem("COS");
	    cbxG.addItem("SEN");
		
		JLabel label_3 = new JLabel("(");
		label_3.setBounds(275, 160, 35, 34);
		contentPane.add(label_3);
		
		Gfrec = new JTextField();
		Gfrec.setForeground(Color.BLACK);
		Gfrec.setColumns(10);
		Gfrec.setBounds(292, 166, 68, 22);
		contentPane.add(Gfrec);
		
		JLabel lblX_1 = new JLabel(" x +");
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX_1.setBounds(367, 167, 27, 16);
		contentPane.add(lblX_1);
		
		Gfase = new JTextField();

		Gfase.setForeground(Color.BLACK);
		Gfase.setColumns(10);
		Gfase.setBounds(401, 166, 68, 22);
		contentPane.add(Gfase);
		
		JLabel lblPi_1 = new JLabel("PI )");
		lblPi_1.setBounds(474, 160, 35, 34);
		contentPane.add(lblPi_1);
		JLabel lblResultado = new JLabel("Resultado :");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResultado.setBounds(12, 217, 88, 23);
		contentPane.add(lblResultado);
		
		final JLabel lblFuncionResultado = new JLabel("Funcion resultado");
		lblFuncionResultado.setBounds(27, 248, 790, 23);
		lblFuncionResultado.setVisible(false);
		contentPane.add(lblFuncionResultado);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(336, 284, 133, 41);
		contentPane.add(button);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				if(!fasoresContoles.validarFormato(Famp.getText(), Ffase.getText(), Ffrec.getText())) {
				
					lblFuncionResultado.setText("Datos ingresado incorrecto.\n Formato correcto AMPLITUD numerico ej: 2 , 2.0 \nFASE/FRECUENCIA alfanúmerico ej: 1PI , 0.5PI , 2PI ");
					lblFuncionResultado.setVisible(true);
					lblFuncionResultado.setForeground(Color.RED);
				}else if (!fasoresContoles.validarFrecuencia(Ffrec.getText(), Gfrec.getText())) {
					
					lblFuncionResultado.setText("Datos ingresado incorrecto. Las frecuencias de F(x) y G(x) deben ser iguales.");
                    lblFuncionResultado.setVisible(true);	
                    lblFuncionResultado.setForeground(Color.RED);
				}else {
					
				    lblFuncionResultado.setText(fasoresContoles.suma(Famp.getText(), Ffrec.getText(), Ffase.getText(),cbxF.getSelectedItem().toString(), Gampl.getText(), Gfrec.getText(),Gfase.getText(),cbxG.getSelectedItem().toString()));
					lblFuncionResultado.setVisible(true);
				}
							
			}
		});
		btnCalcular.setBounds(105, 284, 133, 41);
		contentPane.add(btnCalcular);
		
		JLabel lblFx = new JLabel(" F(x) :");
		lblFx.setForeground(Color.GRAY);
		lblFx.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFx.setBounds(39, 22, 74, 34);
		contentPane.add(lblFx);
		
		txtAmplitud = new JTextField();
		txtAmplitud.setForeground(Color.GRAY);
		txtAmplitud.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAmplitud.setText("Amplitud");
		txtAmplitud.setEnabled(false);
		txtAmplitud.setEditable(false);
		txtAmplitud.setBounds(115, 28, 68, 22);
		contentPane.add(txtAmplitud);
		txtAmplitud.setColumns(10);
		
		txtCossen = new JTextField();
		txtCossen.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCossen.setForeground(Color.GRAY);
		txtCossen.setEnabled(false);
		txtCossen.setEditable(false);
		txtCossen.setText("COS/SEN");
		txtCossen.setBounds(195, 29, 68, 22);
		contentPane.add(txtCossen);
		txtCossen.setColumns(10);
		
		txtFrecuencia = new JTextField();
		txtFrecuencia.setEnabled(false);
		txtFrecuencia.setEditable(false);
		txtFrecuencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtFrecuencia.setForeground(Color.GRAY);
		txtFrecuencia.setText(" Frecuencia");
		txtFrecuencia.setBounds(286, 29, 74, 22);
		contentPane.add(txtFrecuencia);
		txtFrecuencia.setColumns(10);
		
		JLabel lblX_2 = new JLabel("x +");
		lblX_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblX_2.setBounds(367, 32, 35, 16);
		contentPane.add(lblX_2);
		
		txtFase = new JTextField();
		txtFase.setEnabled(false);
		txtFase.setEditable(false);
		txtFase.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtFase.setForeground(Color.GRAY);
		txtFase.setText("Fase");
		txtFase.setBounds(401, 29, 56, 22);
		contentPane.add(txtFase);
		txtFase.setColumns(10);
		
		JLabel lblPi_2 = new JLabel("PI )");
		lblPi_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPi_2.setForeground(Color.GRAY);
		lblPi_2.setBounds(463, 32, 56, 16);
		contentPane.add(lblPi_2);
		
		JLabel label_1 = new JLabel("(");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setForeground(Color.GRAY);
		label_1.setBounds(275, 32, 35, 16);
		contentPane.add(label_1);
		
		

	}
}
