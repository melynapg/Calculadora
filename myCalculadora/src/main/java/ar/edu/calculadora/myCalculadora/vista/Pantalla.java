package ar.edu.calculadora.myCalculadora.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ar.edu.calculadora.myCalculadora.controladores.CalculosControlador;
import ar.edu.calculadora.myCalculadora.modelo.Complejos;


@SuppressWarnings("unused")
public class Pantalla extends javax.swing.JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	public javax.swing.JTextField pReal;
	public javax.swing.JTextField pImg;
	public JTextField resultadoBinomica;
	public javax.swing.JButton btnTransformarBinomica;
	public CalculosControlador calculosControlador = new CalculosControlador();
	private Complejos z; 
	private JTextField resultadoPolar;
	private JTextField modulo;
	private JTextField argumento;
	private JTextField resultadoZ2Binomica;
	
	
	


	 public Pantalla() {
		 initialize();
	       
	 }

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
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


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 255, 250));

		frame.setBounds(1000, 100, 727, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JTextField pReal = new javax.swing.JTextField();
		pReal.setBounds(177, 15, 46, 20);
		frame.getContentPane().add(pReal);
		pReal.setColumns(10);
		
		final JTextField pImg = new javax.swing.JTextField();
		pImg.setBounds(327, 14, 46, 22);
		frame.getContentPane().add(pImg);
		pImg.setColumns(10);
		
		
	
	
		
		JButton btnTransformar = new javax.swing.JButton("Transformar");
		btnTransformar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTransformar.setBackground(new Color(60, 179, 113));
		btnTransformar.setBounds(403, 14, 149, 23);
		btnTransformar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
			
				
				Complejos z = new Complejos(0, 0);
				
			 Boolean validar = calculosControlador.validarBtnTransformar(pReal.getText(), pImg.getText());
			 
			 if (validar ) {
			    z= calculosControlador.setBinomicaValues( pReal.getText(), pImg.getText());
			 	calculosControlador.imprimeBinomica(z, resultadoBinomica);
				calculosControlador.imprimeDeBinomicaPolar(z, resultadoPolar);
				
			 } 
			 else 
			 {
				 
				 
				 validacion dialog = new validacion();
				  dialog.setVisible(true);
		
				 
			 }
					
			}

		

		
		});
		frame.getContentPane().add(btnTransformar);
		
		resultadoBinomica = new JTextField();
		resultadoBinomica.setBackground(new Color(0, 0, 0));
		resultadoBinomica.setEditable(false);
		resultadoBinomica.setForeground(new Color(144, 238, 144));
		resultadoBinomica.setBounds(151, 61, 106, 20);
		frame.getContentPane().add(resultadoBinomica);
		resultadoBinomica.setColumns(10);
		
		JLabel lblZ1 = new JLabel("Z1");
		lblZ1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblZ1.setForeground(Color.BLACK);
		lblZ1.setBounds(29, 18, 46, 14);
		frame.getContentPane().add(lblZ1);
		
		JLabel lblRez = new JLabel("Re(Z1)");
		lblRez.setForeground(new Color(0, 0, 128));
		lblRez.setBounds(112, 18, 46, 14);
		frame.getContentPane().add(lblRez);
		
		JLabel lblImgz = new JLabel("Img(Z1)");
		lblImgz.setForeground(new Color(0, 0, 128));
		lblImgz.setBounds(257, 18, 46, 14);
		frame.getContentPane().add(lblImgz);
		
		resultadoPolar = new JTextField();
		resultadoPolar.setBackground(new Color(0, 0, 0));
		resultadoPolar.setEditable(false);
		resultadoPolar.setForeground(new Color(144, 238, 144));
		resultadoPolar.setBounds(151, 92, 106, 20);
		frame.getContentPane().add(resultadoPolar);
		resultadoPolar.setColumns(10);
		
		JLabel lblFormaBinomica = new JLabel("Forma binomica");
		lblFormaBinomica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormaBinomica.setBounds(29, 64, 89, 17);
		frame.getContentPane().add(lblFormaBinomica);
		
		JLabel lblFormaPolar = new JLabel("Forma polar");
		lblFormaPolar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormaPolar.setBounds(29, 92, 76, 17);
		frame.getContentPane().add(lblFormaPolar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				resultadoBinomica.setText("");
				resultadoPolar.setText("");
				pReal.setText("");
				pImg.setText("");
				resultadoZ2Binomica.setText("");
				modulo.setText("");
				argumento.setText("");

				
			}
			
		});
		btnLimpiar.setBounds(42, 230, 132, 55);
		frame.getContentPane().add(btnLimpiar);
		
		JLabel lblZ = new JLabel("Z2");
		lblZ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblZ.setBounds(29, 133, 46, 14);
		frame.getContentPane().add(lblZ);
		
		JLabel lblModulo = new JLabel("modulo");
		lblModulo.setBounds(112, 135, 46, 14);
		frame.getContentPane().add(lblModulo);
		
		modulo = new JTextField();
		modulo.setBounds(177, 131, 46, 22);
		frame.getContentPane().add(modulo);
		modulo.setColumns(10);
		
		JLabel lblArgumento = new JLabel("argumento");
		lblArgumento.setBounds(233, 135, 70, 14);
		frame.getContentPane().add(lblArgumento);
		
		argumento = new JTextField();
		argumento.setBounds(327, 132, 46, 20);
		frame.getContentPane().add(argumento);
		argumento.setColumns(10);
		
		JButton btnNewButton = new JButton("Transformar");
		btnNewButton.setBackground(new Color(60, 179, 113));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		 Complejos zp = new Complejos(0, 0);
		 
		    z = calculosControlador.setPolarValues(modulo.getText() , argumento.getText());
		 	calculosControlador.imprimeBinomicaDesdePolar(z, resultadoZ2Binomica);		
		
		
			}
		});
		btnNewButton.setBounds(403, 131, 149, 23);
		frame.getContentPane().add(btnNewButton);
		
		resultadoZ2Binomica = new JTextField();
		resultadoZ2Binomica.setEnabled(false);
		resultadoZ2Binomica.setBackground(Color.DARK_GRAY);
		resultadoZ2Binomica.setBounds(151, 164, 106, 20);
		frame.getContentPane().add(resultadoZ2Binomica);
		resultadoZ2Binomica.setColumns(10);
		
		JLabel lblFormaBinomica_1 = new JLabel("Forma binomica");
		lblFormaBinomica_1.setBounds(10, 167, 131, 14);
		frame.getContentPane().add(lblFormaBinomica_1);
		
	
		

	
		
			
	}
	
	
		

	   private void transformarActionPerformed(java.awt.event.ActionEvent e) {//GEN-FIRST:event_transformarActionPerformed
	        // TODO add your handling code here:
	    }
}
