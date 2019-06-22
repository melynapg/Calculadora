package ar.edu.calculadora.myCalculadora.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.edu.calculadora.myCalculadora.controladores.CalculosControlador;
import ar.edu.calculadora.myCalculadora.modelo.Raices;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JButton;

public class OperacionesAvanzadas extends JFrame {

	private JPanel contentPane;
	private JTextField nroC;
	private JTextField indice = new JTextField();
	private JLabel label;
	private JLabel lblRe;
	private JLabel Resultado;

	private JComboBox<String> cbxOperacion = new JComboBox<String>();
	private CalculosControlador calculosControlador = new CalculosControlador();
	private JComboBox<String> cbxResultado = new JComboBox<String>();
	private JLabel resultadoPotencia;
	private JLabel lblOperacin;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperacionesAvanzadas frame = new OperacionesAvanzadas();
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
	public OperacionesAvanzadas() {
		setTitle("Radicación/ Potenciación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		cbxOperacion.setBounds(148, 211, 191, 30);
		cbxOperacion.addItem("");
		cbxOperacion.addItem("Radicación");
		cbxOperacion.addItem("Potenciación");
		contentPane.add(cbxOperacion);
		
		
		nroC = new JTextField();
		nroC.setBounds(368, 113, 182, 33);
		contentPane.add(nroC);
		nroC.setColumns(10);
		
		JLabel lblIndice = new JLabel("Indice");
		lblIndice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIndice.setBounds(38, 124, 56, 16);
		contentPane.add(lblIndice);
		
		JLabel lblNroComplejo = new JLabel("Nro Complejo");
		lblNroComplejo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNroComplejo.setBounds(235, 113, 121, 30);
		contentPane.add(lblNroComplejo);
		
	
		indice.setColumns(10);
		indice.setBounds(112, 113, 62, 33);
		contentPane.add(indice);
		
		label = new JLabel("");
		label.setBounds(38, 280, 56, 16);
		contentPane.add(label);
		
		lblRe = new JLabel("Resultado :");
		lblRe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRe.setBounds(38, 280, 83, 34);
		lblRe.setVisible(false);
		contentPane.add(lblRe);
		
		Resultado = new JLabel("Resultado");
		Resultado.setForeground(Color.RED);
		Resultado.setBounds(24, 359, 543, 46);
		contentPane.add(Resultado);
		Resultado.setVisible(false);
		

		cbxResultado.setEditable(true);
		cbxResultado.setBounds(148, 287, 182, 22);
		contentPane.add(cbxResultado);
		
		resultadoPotencia = new JLabel("Resultado Potencia:");
		resultadoPotencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		resultadoPotencia.setBounds(38, 327, 301, 34);
		contentPane.add(resultadoPotencia);
		
		lblOperacin = new JLabel("Operación");
		lblOperacin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOperacin.setBounds(38, 218, 71, 16);
		contentPane.add(lblOperacin);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				indice.setText("");
				nroC.setText("");
				lblRe.setVisible(false);
				cbxResultado.setVisible(false);
				Resultado.setText("");
				Resultado.setVisible(false);
				resultadoPotencia.setText("");
                resultadoPotencia.setVisible(false);				
				
				
				
			}
		});
		btnLimpiar.setBounds(80, 455, 137, 25);
		contentPane.add(btnLimpiar);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(348, 455, 127, 25);
		contentPane.add(btnNewButton);
		resultadoPotencia.setVisible(false);
		
		cbxResultado.setVisible(false);
	
		
		
		
        cbxOperacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                myBox(evt);
            }
        });
	}
	
	
	
	public void myBox(ActionEvent evt) {
		
		
		if(cbxOperacion.getSelectedItem().toString() == "Radicación") {
			
                   
         if (!calculosControlador.validarIndice(indice.getText())) {
        	 
        	 Resultado.setText(" Datos ingresado incorrecto , el campo indice debe ser numerico");
        	 Resultado.setVisible(true);
        	 
         }else if (!calculosControlador.validarNroOperacionesAvanzadas( nroC.getText())) {
			
        	 Resultado.setText(" Datos ingresado incorrecto , el campo NRO debe ser (a,b) o [c,dPI]");
        	 Resultado.setVisible(true);
        	 
		}else {
				
           ArrayList<Raices> raices = new ArrayList<Raices>();
           raices=calculosControlador.raicesradicacion(indice.getText(),nroC.getText());
           DecimalFormat f = new DecimalFormat("####.###");
           
           for (Raices ra : raices) {
        	
      		 String imp= "w" + ra.getIndice() +": "+"[ "+f.format(ra.getModulo() )+ "," +f.format(ra.getArgumento())+"PI]";
      		  
      		 cbxResultado.addItem(imp);
      		 
      		  }
           
            cbxResultado.setVisible(true);
        	lblRe.setVisible(true);   
           }
				
    
         
			
			
		}else if (cbxOperacion.getSelectedItem().toString() == "Potenciación") {
		
			  if (!calculosControlador.validarIndice(indice.getText())) {
		        	 
		        	 Resultado.setText(" Datos ingresado incorrecto, el campo indice debe ser numerico");
		        	 Resultado.setVisible(true);
		        	 
		         }else if (!calculosControlador.validarNroOperacionesAvanzadas( nroC.getText())) {
					
		        	 Resultado.setText(" Datos ingresado incorrecto , el campo NRO debe ser (a,b) o [c,dPI]");
		        	 Resultado.setVisible(true);
		        	 
				}else {
						
					String potencia = calculosControlador.potencia(indice.getText(),nroC.getText()); 
					
					 resultadoPotencia.setText("Resultado potencia: "+ potencia);
					 resultadoPotencia.setVisible(true);
			            cbxResultado.setVisible(false);
			        	lblRe.setVisible(false);
					 
					 
						
				}
			  
			  
			  
			
			
			
		}
		
		
		
	}
}
